package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.datasource.DestinationsDataSource
import com.example.data.model.Destination
import com.example.data.model.TravelCategory
import com.example.data.repository.TravelRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class ExploreUiState(
    val originCity: String = "Hyderabad",
    val searchQuery: String = "",
    val selectedCategory: TravelCategory? = null,
    val selectedFilter: String = "All",
    val selectedState: String = "All",
    val favoriteIds: Set<String> = emptySet(),
    val filteredDestinations: List<Destination> = emptyList()
)

class ExploreViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = TravelRepository(application)

    private val _originCity = MutableStateFlow("Hyderabad")
    val originCity: StateFlow<String> = _originCity.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedCategory = MutableStateFlow<TravelCategory?>(null)
    val selectedCategory: StateFlow<TravelCategory?> = _selectedCategory.asStateFlow()

    private val _selectedFilter = MutableStateFlow("All")
    val selectedFilter: StateFlow<String> = _selectedFilter.asStateFlow()

    private val _selectedState = MutableStateFlow("All")
    val selectedState: StateFlow<String> = _selectedState.asStateFlow()

    val availableCities: List<String> = DestinationsDataSource.supportedOriginCities
    val availableStates: List<String> = repository.getAvailableStates()

    val favoriteIds = repository.getAllFavorites().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    private val _uiState = MutableStateFlow(
        ExploreUiState(filteredDestinations = repository.getAllDestinations())
    )
    val uiState: StateFlow<ExploreUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val flowGroup1 = combine(_originCity, _searchQuery, _selectedCategory) { city, query, cat ->
                Triple(city, query, cat)
            }
            val flowGroup2 = combine(_selectedFilter, _selectedState, favoriteIds) { filter, state, favs ->
                Triple(filter, state, favs)
            }

            combine(flowGroup1, flowGroup2) { g1, g2 ->
                val (city, query, category) = g1
                val (filter, state, favorites) = g2

                val base = repository.searchDestinations(
                    query = query,
                    category = category,
                    state = if (state.equals("All", ignoreCase = true)) null else state
                )
                val favSet = favorites.map { it.destinationId }.toSet()

                val filtered = when (filter) {
                    "⭐ Hidden Gems", "Hidden Gems" -> base.filter {
                        it.discoveryLevel == com.example.data.model.DiscoveryLevel.HIDDEN_GEM ||
                        it.discoveryLevel == com.example.data.model.DiscoveryLevel.LOCAL_SECRET ||
                        it.discoveryLevel == com.example.data.model.DiscoveryLevel.OFFBEAT ||
                        it.hiddenGems.isNotEmpty()
                    }
                    "Under 500 km" -> base.filter { repository.getDistanceForCity(it, city) <= 500 }
                    "Budget < ₹15k" -> base.filter { it.budget.totalEstimateMin <= 15000 }
                    "Top Rated (4.7+)" -> base.filter { it.rating >= 4.7f }
                    "Couples Pick" -> base.filter { it.categories.contains(TravelCategory.COUPLES) }
                    else -> base
                }

                ExploreUiState(
                    originCity = city,
                    searchQuery = query,
                    selectedCategory = category,
                    selectedFilter = filter,
                    selectedState = state,
                    favoriteIds = favSet,
                    filteredDestinations = filtered
                )
            }.collect {
                _uiState.value = it
            }
        }
    }

    fun setOriginCity(city: String) {
        _originCity.value = city
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun selectCategory(category: TravelCategory?) {
        if (_selectedCategory.value == category) {
            _selectedCategory.value = null
        } else {
            _selectedCategory.value = category
        }
    }

    fun selectFilter(filter: String) {
        _selectedFilter.value = filter
    }

    fun selectState(state: String) {
        _selectedState.value = state
    }

    fun toggleFavorite(destination: Destination) {
        viewModelScope.launch {
            val isFav = _uiState.value.favoriteIds.contains(destination.id)
            repository.toggleFavorite(destination, isFav)
        }
    }

    fun getDistance(destination: Destination): Int {
        return repository.getDistanceForCity(destination, _originCity.value)
    }

    fun getDrivingTime(destination: Destination): String {
        return repository.getDrivingTimeForCity(destination, _originCity.value)
    }
}
