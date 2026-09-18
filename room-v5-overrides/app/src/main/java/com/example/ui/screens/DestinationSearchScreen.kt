package com.example.ui.screens

import android.Manifest
import android.content.pm.PackageManager
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.BuildConfig
import com.example.core.operation
import com.example.ui.components.ErrorBanner
import com.example.ui.viewmodel.DestinationSearchViewModel
import com.example.util.destinationPin
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

@OptIn(ExperimentalMaterial3Api::class)
@Composable fun DestinationSearchScreen(onAddToTrip: (String) -> Unit, premiumPins: Boolean, onPremium: () -> Unit, model: DestinationSearchViewModel = viewModel()) {
    val state by model.state.collectAsStateWithLifecycle()
    val fallbackContext = LocalContext.current
    if (BuildConfig.MAPS_ANDROID_KEY.isBlank()) {
        var fallbackQuery by androidx.compose.runtime.saveable.rememberSaveable { mutableStateOf("") }
        Column(Modifier.padding(16.dp)) {
            Text("Find a place on the map", style = androidx.compose.material3.MaterialTheme.typography.headlineSmall)
            Text("Open directions and nearby places in Google Maps. You can browse saved destination guides in Explore.")
            OutlinedTextField(fallbackQuery, { fallbackQuery = it }, label = { Text("Place or area") }, modifier = Modifier.fillMaxWidth())
            Button(enabled = fallbackQuery.isNotBlank(), onClick = {
                val uri = android.net.Uri.parse("https://www.google.com/maps/search/?api=1&query=" + android.net.Uri.encode(fallbackQuery.trim()))
                runCatching { fallbackContext.startActivity(android.content.Intent(android.content.Intent.ACTION_VIEW, uri)) }
                    .onFailure { android.widget.Toast.makeText(fallbackContext, "No maps or browser app available", android.widget.Toast.LENGTH_LONG).show() }
            }) { Text("Open Google Maps") }
        }
        return
    }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var query by remember { mutableStateOf("") }
    var pinHue by remember { mutableStateOf(BitmapDescriptorFactory.HUE_AZURE) }
    var locationMessage by remember { mutableStateOf<String?>(null) }
    var permission by remember { mutableStateOf(
        ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
    ) }
    val camera = rememberCameraPositionState { position = CameraPosition.fromLatLngZoom(LatLng(17.3850, 78.4867), 6f) }
    LaunchedEffect(state.selected?.coordinates) {
        state.selected?.let { camera.position = CameraPosition.fromLatLngZoom(it.coordinates, 13f) }
    }
    val permissionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { granted ->
        permission = granted[Manifest.permission.ACCESS_FINE_LOCATION] == true || granted[Manifest.permission.ACCESS_COARSE_LOCATION] == true
        if (!permission) locationMessage = "Location denied. Showing Hyderabad; you can still search and move the map."
    }
    LaunchedEffect(permission) {
        if (permission && (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)) operation {
            val cancellation = CancellationTokenSource()
            try {
                val location = LocationServices.getFusedLocationProviderClient(context)
                    .getCurrentLocation(Priority.PRIORITY_BALANCED_POWER_ACCURACY, cancellation.token).await()
                if (location != null) camera.position = CameraPosition.fromLatLngZoom(LatLng(location.latitude, location.longitude), 11f)
                else locationMessage = "Location unavailable. Search or move the map."
            } finally { cancellation.cancel() }
        }.onFailure { locationMessage = it.message }
    }
    Column {
        OutlinedTextField(query, { query = it; model.search(it) }, label = { Text("Search destinations") }, modifier = Modifier.fillMaxWidth().padding(12.dp))
        TextButton(onClick = { permissionLauncher.launch(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)) }) { Text("Use my location") }
        TextButton(onClick = { if (premiumPins) pinHue = if (pinHue == BitmapDescriptorFactory.HUE_AZURE) BitmapDescriptorFactory.HUE_VIOLET else BitmapDescriptorFactory.HUE_AZURE else onPremium() }) { Text("Change pin colour") }
        locationMessage?.let { Text(it, Modifier.padding(12.dp)) }
        state.error?.let { ErrorBanner(it, model::retry) }
        if (BuildConfig.MAPS_ANDROID_KEY.isNotBlank()) {
            GoogleMap(Modifier.fillMaxWidth().height(280.dp), cameraPositionState = camera, properties = MapProperties(isMyLocationEnabled = permission)) {
                val pin = remember(premiumPins, pinHue) { destinationPin(if (premiumPins) pinHue else BitmapDescriptorFactory.HUE_AZURE) }
                model.markers.forEach { marker ->
                    Marker(state = MarkerState(marker.coordinates), title = marker.title,
                        icon = pin,
                        onClick = { model.selectMarker(marker); true })
                }
                state.selected?.let { selected -> Marker(state = MarkerState(selected.coordinates), title = selected.title, onClick = { true }) }
            }
        } else Text("Configure the restricted Android Maps/Places key to enable the interactive map.", Modifier.padding(16.dp))
        if (state.loading) Text("Searching…", Modifier.padding(12.dp))
        LazyColumn {
            items(state.suggestions, key = { "${it.local}:${it.id}" }) { result ->
                TextButton(onClick = { model.select(result) }) { Text(result.title) }
            }
            if (state.suggestions.any { !it.local }) item { Text("Google Maps", Modifier.padding(12.dp)) }
        }
    }
    state.selected?.let { selected ->
        ModalBottomSheet(onDismissRequest = model::dismiss) {
            Column(Modifier.padding(24.dp)) {
                Text(selected.title)
                Text(selected.description)
                selected.thumbnail?.let { Image(it.asImageBitmap(), selected.title, Modifier.fillMaxWidth().height(160.dp)) }
                if (selected.attribution.isNotBlank()) AndroidView(
                    factory = { TextView(it).apply { movementMethod = LinkMovementMethod.getInstance() } },
                    update = { it.text = HtmlCompat.fromHtml(selected.attribution, HtmlCompat.FROM_HTML_MODE_LEGACY) }
                )
                Button(onClick = { model.dismiss(); onAddToTrip("Plan a trip to ${selected.title} near ${selected.coordinates.latitude}, ${selected.coordinates.longitude}") }) { Text("Add to Trip") }
            }
        }
    }
}
