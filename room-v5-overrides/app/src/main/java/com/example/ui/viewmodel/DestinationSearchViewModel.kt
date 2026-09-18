package com.example.ui.viewmodel

import android.app.Application
import android.graphics.Bitmap
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.BuildConfig
import com.example.core.operation
import com.example.data.datasource.DestinationsDataSource
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.net.FetchPhotoRequest
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

data class SearchSuggestion(val id: String, val title: String, val local: Boolean)
data class MapDestination(val id: String, val title: String, val coordinates: LatLng,
    val description: String = "", val thumbnail: Bitmap? = null, val attribution: String = "")
data class DestinationSearchState(val loading: Boolean = false, val suggestions: List<SearchSuggestion> = emptyList(),
    val selected: MapDestination? = null, val error: String? = null)

@OptIn(FlowPreview::class)
class DestinationSearchViewModel(application: Application) : AndroidViewModel(application) {
    private val query = MutableStateFlow("")
    private val mutable = MutableStateFlow(DestinationSearchState())
    val state = mutable.asStateFlow()
    private val client by lazy {
        check(BuildConfig.MAPS_ANDROID_KEY.isNotBlank()) { "Maps/Places API key is not configured. Offline destinations remain searchable." }
        if (!Places.isInitialized()) Places.initializeWithNewPlacesApiEnabled(application, BuildConfig.MAPS_ANDROID_KEY)
        Places.createClient(application)
    }
    private var token = AutocompleteSessionToken.newInstance()
    private var selection: Job? = null
    val markers = DestinationsDataSource.destinations.filter { it.latitude != 0.0 || it.longitude != 0.0 }
        .map { MapDestination(it.id, it.name, LatLng(it.latitude, it.longitude), it.tagline) }

    init {
        viewModelScope.launch {
            query.debounce(300).collectLatest { text ->
                if (text.length < 2) { mutable.update { it.copy(suggestions = emptyList(), loading = false) }; return@collectLatest }
                mutable.update { it.copy(loading = true, error = null) }
                val local = DestinationsDataSource.searchDestinations(text).take(8).map { SearchSuggestion(it.id, "${it.name}, ${it.state}", true) }
                if (BuildConfig.MAPS_ANDROID_KEY.isBlank()) {
                    mutable.update { it.copy(loading = false, suggestions = local, error = null) }
                    return@collectLatest
                }
                val result = operation {
                    client.findAutocompletePredictions(FindAutocompletePredictionsRequest.builder()
                        .setQuery(text).setCountries("IN").setSessionToken(token).build()).await()
                        .autocompletePredictions.map { SearchSuggestion(it.placeId, it.getFullText(null).toString(), false) }
                }
                if (query.value == text) mutable.update { it.copy(loading = false, suggestions = local + result.getOrDefault(emptyList()), error = result.exceptionOrNull()?.message) }
            }
        }
    }
    fun search(text: String) { query.value = text.trim() }
    fun retry() {
        val current = query.value
        query.value = ""
        viewModelScope.launch {
            kotlinx.coroutines.delay(320)
            if (query.value.isEmpty()) query.value = current
        }
    }
    fun dismiss() { selection?.cancel(); mutable.update { it.copy(selected = null) } }
    fun selectMarker(marker: MapDestination) { selection?.cancel(); mutable.update { it.copy(selected = marker) } }
    fun select(suggestion: SearchSuggestion) {
        selection?.cancel()
        selection = viewModelScope.launch {
            val result = operation {
                if (suggestion.local) {
                    val destination = DestinationsDataSource.getDestinationById(suggestion.id) ?: error("Destination no longer available")
                    require(destination.latitude != 0.0 || destination.longitude != 0.0) { "No verified map coordinates for this destination. Use Explore to view its travel details." }
                    MapDestination(destination.id, destination.name, LatLng(destination.latitude, destination.longitude), destination.description)
                } else {
                    val place = client.fetchPlace(FetchPlaceRequest.builder(suggestion.id,
                        listOf(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG, Place.Field.PHOTO_METADATAS))
                        .setSessionToken(token).build()).await().place
                    token = AutocompleteSessionToken.newInstance()
                    val metadata = place.photoMetadatas?.firstOrNull()
                    val photo = if (metadata == null) null else operation {
                        client.fetchPhoto(FetchPhotoRequest.builder(metadata).setMaxWidth(600).setMaxHeight(400).build()).await().bitmap
                    }.getOrNull()
                    MapDestination(suggestion.id, place.name ?: suggestion.title, place.latLng ?: error("Place has no coordinates"),
                        thumbnail = photo, attribution = metadata?.attributions.orEmpty())
                }
            }
            mutable.update { it.copy(selected = result.getOrNull(), error = result.exceptionOrNull()?.message) }
        }
    }
}
