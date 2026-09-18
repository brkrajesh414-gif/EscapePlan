package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.datasource.DestinationsDataSource
import com.example.data.model.DestinationMatch
import com.example.data.model.GeneratedItinerary
import com.example.data.model.ParsedTravelQuery
import com.example.data.repository.TravelRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class AiPlannerUiState(
    val originCity: String = "Hyderabad",
    val budget: Int = 20000,
    val tripType: String = "Couple",
    val durationDays: Int = 3,
    val transportMode: String = "Car",
    val experience: String = "Nature & Scenery",
    val discoveryPreference: String = "All Spots",
    val hotelPreference: String = "3-Star Resort",
    val freeformPrompt: String = "",
    val isGenerating: Boolean = false,
    val inputError: String? = null,
    val generatedItinerary: GeneratedItinerary? = null,
    val candidateMatches: List<DestinationMatch> = emptyList(),
    val parsedQuery: ParsedTravelQuery? = null,
    val isSaved: Boolean = false,
    val activeTab: Int = 0 // 0 = Wizard ("What do you want?"), 1 = Conversational AI, 2 = Regional Knowledge
)

class AiPlannerViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = TravelRepository(application)

    private val _uiState = MutableStateFlow(AiPlannerUiState())
    val uiState: StateFlow<AiPlannerUiState> = _uiState.asStateFlow()

    val availableCities = DestinationsDataSource.supportedOriginCities
    val tripTypes = listOf("Solo", "Couple", "Family", "Friends")
    val durations = listOf(1, 2, 3, 4, 7)
    val transports = listOf("Car 🚗", "Bike 🏍️", "Train 🚆", "Bus 🚌", "Flight ✈️")
    val discoveryOptions = listOf("All Spots", "⭐ Hidden Gems", "Offbeat", "Iconic")
    val experiences = listOf(
        "Hidden Gems & Offbeat ⭐",
        "Nature & Scenery 🌳",
        "Mountains 🏔️",
        "Beaches 🏖️",
        "Heritage & History 🏛️",
        "Spiritual 🛕",
        "Adventure 🏕️",
        "Food Trail 🍴"
    )
    val budgetOptions = listOf(5000, 10000, 20000, 35000, 50000)

    val samplePrompts = listOf(
        "Monsoon road trip to Devkund waterfall hidden gem, 2 days, friends, nature trek under ₹8,000",
        "I'm in Hyderabad. I have ₹20,000 and 3 days. I want a peaceful trip with my wife, good food and nice scenery. Where should I go?",
        "Hidden gems and waterfalls road trip from Pune / Mumbai for weekend, budget ₹6,000",
        "Offbeat canyon and fort road trip to Gandikota from Bengaluru under ₹12,000",
        "Weekend trip from Hyderabad. Budget ₹10,000, 2 people, car, nature + food, 2 days",
        "Bengaluru to scenic hill station, 3 days, couple trip, nature + coffee estates, budget ₹18,000",
        "Heritage & bouldering road trip from Hyderabad for 3 days with friends under ₹15,000"
    )

    fun setOriginCity(city: String) {
        _uiState.value = _uiState.value.copy(originCity = city)
        refreshCandidateMatches()
    }

    fun setBudget(budget: Int) {
        _uiState.value = _uiState.value.copy(budget = budget)
        refreshCandidateMatches()
    }

    fun setTripType(type: String) {
        _uiState.value = _uiState.value.copy(tripType = type)
        refreshCandidateMatches()
    }

    fun setDuration(days: Int) {
        _uiState.value = _uiState.value.copy(durationDays = days)
        refreshCandidateMatches()
    }

    fun setTransport(mode: String) {
        _uiState.value = _uiState.value.copy(transportMode = mode)
    }

    fun setExperience(exp: String) {
        _uiState.value = _uiState.value.copy(experience = exp)
        refreshCandidateMatches()
    }

    fun setDiscoveryPreference(pref: String) {
        _uiState.value = _uiState.value.copy(discoveryPreference = pref)
        refreshCandidateMatches()
    }

    fun setFreeformPrompt(prompt: String) {
        _uiState.value = _uiState.value.copy(freeformPrompt = prompt)
        if (prompt.isNotBlank()) {
            val parsed = repository.parseTravelPrompt(prompt)
            _uiState.value = _uiState.value.copy(
                parsedQuery = parsed,
                candidateMatches = parsed.candidateMatches
            )
        }
    }

    fun setActiveTab(tabIndex: Int) {
        _uiState.value = _uiState.value.copy(activeTab = tabIndex)
    }

    private fun refreshCandidateMatches() {
        val current = _uiState.value
        val vibes = mutableListOf(current.experience)
        if (current.discoveryPreference == "⭐ Hidden Gems" || current.discoveryPreference == "Offbeat") {
            vibes.add("Peaceful")
            vibes.add("Nature")
        }
        val matches = repository.rankDestinations(
            originCity = current.originCity,
            budget = current.budget,
            durationDays = current.durationDays,
            partyType = current.tripType,
            vibes = vibes
        )
        val filtered = when (current.discoveryPreference) {
            "⭐ Hidden Gems" -> matches.filter {
                it.destination.discoveryLevel == com.example.data.model.DiscoveryLevel.HIDDEN_GEM ||
                it.destination.discoveryLevel == com.example.data.model.DiscoveryLevel.LOCAL_SECRET ||
                it.destination.hiddenGems.isNotEmpty()
            }.ifEmpty { matches }
            "Offbeat" -> matches.filter {
                it.destination.discoveryLevel == com.example.data.model.DiscoveryLevel.OFFBEAT ||
                it.destination.discoveryLevel == com.example.data.model.DiscoveryLevel.HIDDEN_GEM
            }.ifEmpty { matches }
            "Iconic" -> matches.filter {
                it.destination.discoveryLevel == com.example.data.model.DiscoveryLevel.ICONIC ||
                it.destination.discoveryLevel == com.example.data.model.DiscoveryLevel.POPULAR
            }.ifEmpty { matches }
            else -> matches
        }
        _uiState.value = _uiState.value.copy(candidateMatches = filtered)
    }

    fun generateTripForSpecificDestination(destinationId: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isGenerating = true, isSaved = false)
            val currentState = _uiState.value
            val dest = repository.getDestinationById(destinationId)
            val prompt = if (dest != null) "Plan trip to ${dest.name}" else null

            val itinerary = repository.generateAiTrip(
                originCity = currentState.originCity,
                budget = currentState.budget,
                tripType = currentState.tripType,
                durationDays = currentState.durationDays,
                transportMode = currentState.transportMode.split(" ").first(),
                experience = currentState.experience.split(" ").first(),
                customPrompt = prompt
            )

            _uiState.value = _uiState.value.copy(
                isGenerating = false,
                generatedItinerary = itinerary
            )
        }
    }

    fun generateTripFromWizard() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isGenerating = true, isSaved = false)
            val currentState = _uiState.value
            val matches = repository.rankDestinations(
                originCity = currentState.originCity,
                budget = currentState.budget,
                durationDays = currentState.durationDays,
                partyType = currentState.tripType,
                vibes = listOf(currentState.experience)
            )

            val itinerary = repository.generateAiTrip(
                originCity = currentState.originCity,
                budget = currentState.budget,
                tripType = currentState.tripType,
                durationDays = currentState.durationDays,
                transportMode = currentState.transportMode.split(" ").first(),
                experience = currentState.experience.split(" ").first()
            )
            _uiState.value = _uiState.value.copy(
                isGenerating = false,
                generatedItinerary = itinerary,
                candidateMatches = matches
            )
        }
    }

    fun generateTripFromPrompt(prompt: String) {
        if (Regex("""(?i)\s*\d+\s*km\s*""").matches(prompt)) {
            _uiState.value = _uiState.value.copy(inputError = "Add your starting city: for example, within $prompt of Hyderabad for 2 days.")
            return
        }
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                freeformPrompt = prompt,
                inputError = null,
                isGenerating = true,
                isSaved = false
            )

            // Deep parsing via AiTripParser
            val parsed = repository.parseTravelPrompt(prompt)

            val detectedCity = parsed.originCity
            val detectedBudget = parsed.budget
            val detectedDays = parsed.durationDays
            val detectedType = parsed.partyType
            val detectedTransport = parsed.travelRequest.transportMode
            val detectedExp = parsed.preferredVibes.firstOrNull() ?: _uiState.value.experience

            if (parsed.candidateMatches.isEmpty()) {
                _uiState.value = _uiState.value.copy(isGenerating = false, inputError = "No saved destinations have a recorded distance within this limit from $detectedCity. Try a wider distance.")
                return@launch
            }
            val itinerary = repository.generateAiTrip(
                originCity = detectedCity,
                budget = detectedBudget,
                tripType = detectedType,
                durationDays = detectedDays,
                transportMode = detectedTransport,
                experience = detectedExp,
                customPrompt = prompt
            )

            _uiState.value = _uiState.value.copy(
                isGenerating = false,
                generatedItinerary = itinerary,
                originCity = detectedCity,
                budget = detectedBudget,
                durationDays = detectedDays,
                tripType = detectedType,
                candidateMatches = parsed.candidateMatches,
                parsedQuery = parsed
            )
        }
    }

    fun saveItinerary() {
        val current = _uiState.value.generatedItinerary ?: return
        viewModelScope.launch {
            repository.saveTrip(current)
            _uiState.value = _uiState.value.copy(isSaved = true)
        }
    }

    fun clearResult() {
        _uiState.value = _uiState.value.copy(generatedItinerary = null, isSaved = false)
    }
}
