package com.example.ui.screens

import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.zIndex
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.components.EmptyStateView
import com.example.ui.components.ErrorBanner
import com.example.ui.components.LoadingShimmer
import com.example.ui.viewmodel.GenerationState
import com.example.ui.viewmodel.ItineraryViewModel
import com.example.util.TripExporter
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable fun ItineraryPlannerScreen(
    tripId: String? = null,
    initialPrompt: String = "",
    onLegacyPlanner: () -> Unit,
    canExport: (String) -> Boolean,
    onPremium: () -> Unit,
    onTripOpened: () -> Unit,
    model: ItineraryViewModel = viewModel()
) {
    val state by model.state.collectAsStateWithLifecycle()
    val trip by model.trip.collectAsStateWithLifecycle()
    val trips by model.trips.collectAsStateWithLifecycle()
    val error by model.error.collectAsStateWithLifecycle()
    val message by model.message.collectAsStateWithLifecycle()
    var prompt by remember(initialPrompt) { mutableStateOf(initialPrompt) }
    var inputError by remember { mutableStateOf<String?>(null) }
    var dayIndex by remember(trip?.trip?.id) { mutableIntStateOf(0) }
    var swapId by remember { mutableStateOf<String?>(null) }
    var replacement by remember { mutableStateOf("") }
    var exportError by remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dragThreshold = with(LocalDensity.current) { 48.dp.toPx() }
    LaunchedEffect(tripId) { tripId?.let(model::open) }
    LaunchedEffect(trip?.trip?.id) { if (trip != null) onTripOpened() }
    LazyColumn(Modifier.padding(horizontal = 16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        item {
            OutlinedTextField(prompt, { prompt = it }, label = { Text("Describe your trip, dates, budget and interests") }, modifier = Modifier.fillMaxWidth())
            Row {
                Button(onClick = {
                    inputError = when {
                        Regex("(?i)\\s*\\d+\\s*km\\s*").matches(prompt) -> "Add a starting city, for example: Within $prompt of Hyderabad for 2 days."
                        prompt.trim().length < 10 -> "Add a destination or starting city and the number of days."
                        prompt.length > 2000 -> "Please shorten your request to 2,000 characters."
                        else -> null
                    }
                    if (inputError == null) model.generateTrip(prompt.trim())
                }, enabled = state !is GenerationState.Generating) { Text("Generate & save") }
                TextButton(onClick = onLegacyPlanner) { Text("Offline planner") }
            }
            inputError?.let { Text(it, color = androidx.compose.material3.MaterialTheme.colorScheme.error) }
            Text("Example: A 2-day trip within 200 km of Hyderabad for two people, budget ₹10,000.")
            Text("AI output is a draft. Confirm travel times, opening hours, prices and safety locally.")
        }
        if (state is GenerationState.Generating) item {
            LoadingShimmer()
            Text("Cancel stops waiting here. If the server finishes, use Recover completed plans to retrieve the result; a completed paid generation uses its pass.")
            TextButton(onClick = model::cancel) { Text("Cancel") }
        }
        (state as? GenerationState.Failure)?.let { failure -> item { ErrorBanner(failure.message, { model.generateTrip(prompt) }) } }
        error?.let { item { ErrorBanner(it, { tripId?.let(model::open) }) } }
        exportError?.let { item { Text(it) } }
        val current = trip
        if (current != null) {
            val days = current.days.sortedBy { it.day.dayNumber }
            item {
                Text(current.trip.title)
                Row {
                    TextButton(onClick = { runCatching { context.startActivity(TripExporter.textIntent(current)) }.onFailure { exportError = it.message } }) { Text("Share") }
                    TextButton(onClick = { if (!canExport(current.trip.id)) onPremium() else scope.launch {
                        TripExporter.pdf(context, current).fold({ intent -> runCatching { context.startActivity(intent) }.onFailure { exportError = it.message } }, { exportError = it.message })
                    } }) { Text("PDF") }
                    TextButton(onClick = { model.delete(current.trip.id) }) { Text("Delete") }
                }
                if (days.isNotEmpty()) ScrollableTabRow(selectedTabIndex = dayIndex.coerceAtMost(days.lastIndex)) {
                    days.forEachIndexed { index, day -> Tab(index == dayIndex, { dayIndex = index }, text = { Text("Day ${day.day.dayNumber}") }) }
                }
            }
            val day = days.getOrNull(dayIndex)
            if (day != null) items(day.activities.sortedBy { it.position }, key = { it.id }) { activity ->
                var drag by remember(activity.id) { mutableFloatStateOf(0f) }
                Card(Modifier.fillMaxWidth().offset { IntOffset(0, drag.roundToInt()) }.zIndex(if (drag == 0f) 0f else 1f).pointerInput(activity.id, day.day.id) {
                    detectDragGesturesAfterLongPress(onDragStart = { drag = 0f }, onDragCancel = { drag = 0f }, onDragEnd = {
                        if (drag > dragThreshold) model.move(day.day.id, activity.id, 1)
                        if (drag < -dragThreshold) model.move(day.day.id, activity.id, -1)
                        drag = 0f
                    }) { change, amount -> change.consume(); drag += amount.y }
                }) {
                    Column(Modifier.padding(16.dp)) {
                        Text("${activity.timeSlot}  •  ${activity.title}")
                        Text(activity.notes)
                        Text("Estimated: ${current.trip.currency} ${activity.estimatedCost}")
                        Row {
                            TextButton(onClick = { model.move(day.day.id, activity.id, -1) }) { Text("Up") }
                            TextButton(onClick = { model.move(day.day.id, activity.id, 1) }) { Text("Down") }
                            TextButton(onClick = { swapId = activity.id; replacement = activity.title }) { Text("Swap") }
                        }
                    }
                }
            }
        } else item { EmptyStateView("Plan your next escape", "Generate a trip or open one of your saved plans below.") }
        item { Text("Saved plans") }
        item { TextButton(onClick = model::recover) { Text("Recover completed plans") }; message?.let { Text(it) } }
        items(trips, key = { it.id }) { saved -> TextButton(onClick = { model.open(saved.id) }) { Text(saved.title) } }
    }
    if (swapId != null) AlertDialog(onDismissRequest = { swapId = null }, title = { Text("Replace activity") },
        text = { OutlinedTextField(replacement, { replacement = it }, label = { Text("New activity") }) },
        confirmButton = { TextButton(onClick = { swapId?.let { model.swap(it, replacement) }; swapId = null }) { Text("Save") } },
        dismissButton = { TextButton(onClick = { swapId = null }) { Text("Cancel") } })
}
