package com.example.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.components.EmptyStateView
import com.example.ui.components.ErrorBanner
import com.example.ui.components.LoadingShimmer
import com.example.ui.viewmodel.PlaceCatalogViewModel

@Composable
fun PlaceCatalogScreen(
    onOpenGuide: (String) -> Unit,
    onPlan: (String) -> Unit,
    model: PlaceCatalogViewModel = viewModel()
) {
    val state by model.state.collectAsStateWithLifecycle()
    var expandedId by rememberSaveable { mutableStateOf<String?>(null) }
    Column(Modifier.padding(horizontal = 16.dp)) {
        Text("Places by category", style = MaterialTheme.typography.headlineSmall)
        OutlinedTextField(state.query, model::search, label = { Text("Search places or alternate names") }, modifier = Modifier.fillMaxWidth())
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            item { FilterChip(state.category == null, { model.category(null) }, label = { Text("All") }) }
            items(state.categories, key = { it }) { category ->
                FilterChip(state.category == category, { model.category(category) }, label = { Text(category) })
            }
        }
        Text("Community-supplied categories and travel details. Confirm hotel availability, transport and seasons before booking.", style = MaterialTheme.typography.bodySmall)
        when {
            state.loading -> LoadingShimmer()
            state.error != null -> ErrorBanner(requireNotNull(state.error), model::reload)
            state.filtered.isEmpty() -> EmptyStateView("No matching places", "Try another category or name.")
            else -> LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.weight(1f)) {
                items(state.filtered, key = { it.id }) { place ->
                    Card(Modifier.fillMaxWidth()) {
                        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Text(place.name, style = MaterialTheme.typography.titleMedium)
                            Text(place.categories.joinToString(" · "))
                            TextButton(onClick = { expandedId = if (expandedId == place.id) null else place.id }) {
                                Text(if (expandedId == place.id) "Hide details" else "View details")
                            }
                            if (expandedId == place.id) {
                                place.description?.let { Text(it) }
                                place.state?.let { Text("State: $it") }
                                place.bestTimeToVisit?.let { Text("Best time: $it") }
                                place.nearestAirport?.let { Text("Airports: $it") }
                                place.nearestRailwayStation?.let { Text("Railway stations: $it") }
                                if (place.latitude != null && place.longitude != null) Text("Approximate destination coordinates: ${place.latitude}, ${place.longitude}")
                                if (place.popularHotels.isNotEmpty()) {
                                    Text("Places to stay", style = MaterialTheme.typography.titleSmall)
                                    place.popularHotels.forEach { Text("${it.name} · ${it.priceTier} · ${it.location}") }
                                }
                                if (place.popularFoodSpots.isNotEmpty()) {
                                    Text("Food suggestions", style = MaterialTheme.typography.titleSmall)
                                    place.popularFoodSpots.forEach { Text("${it.dishOrCuisine} — ${it.recommendedSpot}") }
                                }
                                if (place.topAttractions.isNotEmpty()) Text("Attractions: ${place.topAttractions.joinToString(", ")}")
                                if (place.bestTimeToVisit == null && place.topAttractions.isEmpty()) Text("This entry currently contains a name and categories. More travel details have not been supplied.")
                                model.guideId(place)?.let { id ->
                                    TextButton(onClick = { onOpenGuide(id) }) { Text("Open existing destination guide") }
                                }
                                TextButton(onClick = { onPlan("Plan a trip to ${place.name}. Interests: ${place.categories.joinToString(", ")}. Confirm travel times and costs.") }) { Text("Plan a trip") }
                            }
                        }
                    }
                }
            }
        }
    }
}
