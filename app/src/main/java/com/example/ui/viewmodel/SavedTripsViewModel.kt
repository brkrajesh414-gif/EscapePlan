package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.datasource.DestinationsDataSource
import com.example.data.local.FavoriteDestinationEntity
import com.example.data.local.SavedTripEntity
import com.example.data.model.Destination
import com.example.data.model.GeneratedItinerary
import com.example.data.repository.TravelRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SavedTripsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = TravelRepository(application)

    val savedTrips: StateFlow<List<SavedTripEntity>> = repository.getAllSavedTrips().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val favoriteDestinations: StateFlow<List<FavoriteDestinationEntity>> = repository.getAllFavorites().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    private val _selectedSavedItinerary = MutableStateFlow<GeneratedItinerary?>(null)
    val selectedSavedItinerary: StateFlow<GeneratedItinerary?> = _selectedSavedItinerary.asStateFlow()

    fun deleteTrip(id: String) {
        viewModelScope.launch {
            repository.deleteSavedTrip(id)
        }
    }

    fun openTripDetails(trip: SavedTripEntity) {
        val parsed = repository.parseItinerary(trip.itineraryJson)
        _selectedSavedItinerary.value = parsed
    }

    fun closeTripDetails() {
        _selectedSavedItinerary.value = null
    }

    fun getDestinationById(id: String): Destination? {
        return DestinationsDataSource.getDestinationById(id)
    }
}
