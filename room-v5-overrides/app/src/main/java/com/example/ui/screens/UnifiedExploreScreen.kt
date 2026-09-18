package com.example.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.data.datasource.DestinationsDataSource
import com.example.data.model.PlaceCatalogEntry
import com.example.data.repository.HiddenPlacesRepository
import com.example.data.repository.PlaceCatalogRepository
import com.example.data.engine.PlaceSearch
import com.example.data.repository.RegionalGuide
import com.example.data.repository.loadRegionalGuides

private data class ExploreEntry(
    val key: String, val name: String, val area: String, val summary: String,
    val terms: String, val categories: List<String>, val kind: String, val id: String,
    val catalog: PlaceCatalogEntry? = null,
    val regional: RegionalGuide? = null
)

@Composable
fun UnifiedExploreScreen(
    onDestination: (String) -> Unit,
    onHidden: (String) -> Unit,
    onPlan: (String) -> Unit,
    budgetContent: @Composable () -> Unit
) {
    val context = LocalContext.current
    var query by rememberSaveable { mutableStateOf("") }
    var category by rememberSaveable { mutableStateOf<String?>(null) }
    var budgetMode by rememberSaveable { mutableStateOf(false) }
    var entries by remember { mutableStateOf<List<ExploreEntry>>(emptyList()) }
    var loading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf<String?>(null) }
    var reload by remember { mutableIntStateOf(0) }
    var regionalDetail by remember { mutableStateOf<RegionalGuide?>(null) }
    var detail by remember { mutableStateOf<PlaceCatalogEntry?>(null) }
    LaunchedEffect(reload) {
        loading = true
        val repository = PlaceCatalogRepository(context)
        val catalog = repository.load()
        val hidden = HiddenPlacesRepository(context).load()
        val regions = loadRegionalGuides(context)
        val rich = DestinationsDataSource.destinations.map { destination ->
            val aliases = catalog.getOrDefault(emptyList()).filter { repository.existingGuide(it)?.id == destination.id }
            ExploreEntry("guide:${destination.id}", destination.name, destination.state, destination.tagline,
                listOf(destination.name, destination.state, destination.district, destination.tagline,
                    aliases.flatMap { it.aliases + it.name }.joinToString(" "),
                    destination.attractions.joinToString(" ") { it.name }).joinToString(" "),
                destination.categories.map { it.displayName }, "guide", destination.id)
        }
        val hiddenEntries = hidden.getOrDefault(emptyList()).map {
            ExploreEntry("hidden:${it.id}", it.name, it.stateOrUt, it.whyVisit,
                "${it.name} ${it.stateOrUt} ${it.districtOrBase} ${it.categories.joinToString(" ")}",
                it.categories, "hidden", it.id)
        }
        val basic = catalog.getOrDefault(emptyList()).filter { repository.existingGuide(it) == null }.map {
            ExploreEntry("catalog:${it.id}", it.name, it.state.orEmpty(),
                (it.description ?: it.topAttractions.joinToString(" · ")).ifBlank { "${it.categories.joinToString(" · ")} · Travel information is limited" },
                "${it.name} ${it.aliases.joinToString(" ")} ${it.state.orEmpty()} ${it.categories.joinToString(" ")}",
                it.categories, "catalog", it.id, it)
        }
        val regionalEntries = regions.getOrDefault(emptyList()).map {
            ExploreEntry("region:${it.id}", it.name, "Regional guide",
                "Seasons, places, stays, food and transport from your supplied travel notes.",
                it.name + " " + it.sections.joinToString(" ") { section -> section.text },
                listOf("Regional guides"), "region", it.id, regional = it)
        }
        entries = (rich + hiddenEntries + basic + regionalEntries).sortedBy { it.name }
        error = if (catalog.isFailure || hidden.isFailure || regions.isFailure) "Some guides could not be loaded. You can still browse the available places." else null
        loading = false
    }
    fun openMaps(name: String) {
        runCatching { context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/?api=1&query=" + Uri.encode(name)))) }
            .onFailure { android.widget.Toast.makeText(context, "No browser or maps app available", android.widget.Toast.LENGTH_LONG).show() }
    }
    if (budgetMode) {
        Column {
            TextButton(onClick = { budgetMode = false }) { Text("Back to all places") }
            Text("Budget filters cover destinations with cost estimates.", Modifier.padding(horizontal = 16.dp))
            Box(Modifier.weight(1f)) { budgetContent() }
        }
        return
    }
    val results = remember(entries, query, category) {
        entries.filter { (category == null || category in it.categories) && PlaceSearch.matches(query, it.terms + " " + it.categories.joinToString(" ")) }
            .sortedByDescending { PlaceSearch.normalized(it.name).startsWith(PlaceSearch.normalized(query)) }
    }
    Column(Modifier.fillMaxSize().padding(horizontal = 16.dp)) {
        Text("Explore", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(vertical = 12.dp))
        OutlinedTextField(query, { query = it }, label = { Text("Place, state or interest") },
            placeholder = { Text("Try Srisailam, Kashi or waterfalls") }, singleLine = true,
            trailingIcon = { if (query.isNotEmpty()) TextButton(onClick = { query = "" }) { Text("Clear") } }, modifier = Modifier.fillMaxWidth())
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            item { FilterChip(category == null, { category = null }, label = { Text("All") }) }
            items(entries.flatMap { it.categories }.distinct().sorted()) { value ->
                FilterChip(category == value, { category = if (category == value) null else value }, label = { Text(value) })
            }
        }
        TextButton(onClick = { budgetMode = true }) { Text("Budget & trip filters") }
        if (loading) LinearProgressIndicator(Modifier.fillMaxWidth())
        error?.let { Text(it); TextButton(onClick = { reload++ }) { Text("Reload guides") } }
        Text("${results.size} places", style = MaterialTheme.typography.labelMedium)
        LazyColumn(Modifier.weight(1f).testTag("search_results"), verticalArrangement = Arrangement.spacedBy(10.dp), contentPadding = PaddingValues(vertical = 12.dp)) {
            if (!loading && results.isEmpty()) item {
                Text("No saved guide matches this search. Try a shorter name or clear the category.")
                TextButton(onClick = { category = null; query = "" }) { Text("Show all places") }
                if (query.isNotBlank()) TextButton(onClick = { openMaps(query) }) { Text("Search this place in Google Maps") }
            }
            items(results, key = { it.key }) { entry ->
                Card(Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(entry.name, style = MaterialTheme.typography.titleLarge)
                        if (entry.area.isNotBlank()) Text(entry.area, style = MaterialTheme.typography.labelLarge)
                        Text(entry.summary, maxLines = 3)
                        TextButton(onClick = {
                            when (entry.kind) {
                                "guide" -> onDestination(entry.id)
                                "hidden" -> onHidden(entry.id)
                                "region" -> regionalDetail = entry.regional
                                else -> detail = entry.catalog
                            }
                        }) { Text(when (entry.kind) { "catalog" -> "Travel information"; "region" -> "View regional guide"; else -> "View guide" }) }
                    }
                }
            }
        }
    }
    detail?.let { place ->
        AlertDialog(onDismissRequest = { detail = null }, title = { Text(place.name) }, text = {
            Column(Modifier.verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(place.categories.joinToString(" · "))
                place.description?.let { Text(it) }
                place.sourceUrl?.let { url -> TextButton(onClick = {
                    runCatching { context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url))) }
                        .onFailure { android.widget.Toast.makeText(context, "No browser available", android.widget.Toast.LENGTH_LONG).show() }
                }) { Text("Official visitor information") } }
                place.state?.let { Text("State: $it") }
                place.bestTimeToVisit?.let { Text("When to visit: $it") }
                place.nearestAirport?.let { Text("Airport: $it") }
                place.nearestRailwayStation?.let { Text("Rail: $it") }
                if (place.topAttractions.isNotEmpty()) Text("See: ${place.topAttractions.joinToString(", ")}")
                place.popularHotels.forEach { Text("Stay: ${it.name} · ${it.priceTier} · ${it.location}") }
                place.popularFoodSpots.forEach { Text("Food: ${it.dishOrCuisine} · ${it.recommendedSpot}") }
                if (place.topAttractions.isEmpty() && place.bestTimeToVisit == null) Text("A full guide is not available yet. Open Maps to find directions, nearby accommodation and current visitor information.")
                TextButton(onClick = { openMaps("${place.name} ${place.state.orEmpty()} India") }) { Text("Directions & nearby places") }
                TextButton(onClick = { detail = null; onPlan("Plan a trip to ${place.name}, ${place.state.orEmpty()}") }) { Text("Plan a trip") }
            }
        }, confirmButton = { TextButton(onClick = { detail = null }) { Text("Close") } })
    }
    regionalDetail?.let { guide ->
        AlertDialog(onDismissRequest = { regionalDetail = null }, title = { Text(guide.name) },
            text = {
                Column(Modifier.verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text("Regional planning notes supplied for this app. These are not live opening hours, availability or individual hotel listings.", style = MaterialTheme.typography.bodySmall)
                    guide.sections.forEach { section ->
                        Text(section.label, style = MaterialTheme.typography.titleMedium)
                        Text(section.text)
                    }
                    Text("Check current access, weather, transport and entry requirements before travelling.", style = MaterialTheme.typography.bodySmall)
                    TextButton(onClick = { openMaps(guide.name + " India") }) { Text("Open regional map") }
                }
            },
            confirmButton = { TextButton(onClick = { regionalDetail = null }) { Text("Close") } })
    }

}
