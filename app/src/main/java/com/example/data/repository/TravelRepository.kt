package com.example.data.repository

import android.content.Context
import com.example.data.datasource.DestinationsDataSource
import com.example.data.engine.AiTripParser
import com.example.data.engine.DestinationEngine
import com.example.data.engine.TravelCostEngine
import com.example.data.local.AppDatabase
import com.example.data.local.FavoriteDestinationEntity
import com.example.data.local.SavedTripEntity
import com.example.data.model.Attraction
import com.example.data.model.DayStop
import com.example.data.model.Destination
import com.example.data.model.DestinationMatch
import com.example.data.model.GeneratedItinerary
import com.example.data.model.ItineraryDay
import com.example.data.model.ParsedTravelQuery
import com.example.data.model.TravelCategory
import com.example.data.remote.GeminiClient
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.Flow
import java.util.UUID

class TravelRepository(private val context: Context) {

    private val database = AppDatabase.getInstance(context)
    private val tripDao = database.tripDao()

    companion object {
        private val moshi by lazy {
            Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        }
        private val itineraryAdapter by lazy {
            moshi.adapter(GeneratedItinerary::class.java)
        }
    }

    fun getAllDestinations(): List<Destination> = DestinationsDataSource.destinations

    fun getDestinationById(id: String): Destination? = DestinationsDataSource.getDestinationById(id)

    fun getAvailableStates(): List<String> = DestinationsDataSource.getAvailableStates()

    fun getDestinationsByState(state: String): List<Destination> = DestinationsDataSource.getDestinationsByState(state)

    fun getDestinationsWithinDistance(originCity: String, maxDistanceKm: Int): List<Destination> =
        DestinationEngine.getDestinationsWithinDistance(originCity, maxDistanceKm)

    fun parseTravelPrompt(prompt: String): ParsedTravelQuery = AiTripParser.parseQuery(prompt)

    fun rankDestinations(
        originCity: String,
        budget: Int,
        durationDays: Int,
        partyType: String,
        vibes: List<String>
    ): List<DestinationMatch> = DestinationEngine.rankDestinations(
        originCity = originCity,
        budget = budget,
        durationDays = durationDays,
        partyType = partyType,
        preferredVibes = vibes
    )

    fun importCsvDestinations(csvText: String): Int = DestinationsDataSource.importCsvDestinations(csvText)

    fun searchDestinations(
        query: String,
        category: TravelCategory? = null,
        state: String? = null,
        discoveryLevel: com.example.data.model.DiscoveryLevel? = null
    ): List<Destination> {
        var list = DestinationsDataSource.destinations
        if (!state.isNullOrBlank() && !state.equals("All", ignoreCase = true)) {
            list = list.filter { it.state.contains(state, ignoreCase = true) }
        }
        if (category != null) {
            list = list.filter { it.categories.contains(category) }
        }
        if (discoveryLevel != null) {
            list = list.filter { it.discoveryLevel == discoveryLevel }
        }
        if (query.isBlank()) return list
        val q = query.trim().lowercase()
        return list.filter {
            it.name.lowercase().contains(q) ||
            it.state.lowercase().contains(q) ||
            it.district.lowercase().contains(q) ||
            it.tagline.lowercase().contains(q) ||
            it.attractions.any { a -> a.name.lowercase().contains(q) } ||
            it.hiddenGems.any { h -> h.name.lowercase().contains(q) }
        }
    }

    fun getDestinationsByDiscoveryLevel(level: com.example.data.model.DiscoveryLevel): List<Destination> =
        DestinationsDataSource.getDestinationsByDiscoveryLevel(level)

    fun getAllHiddenGems(): List<com.example.data.model.HiddenGem> =
        DestinationsDataSource.getAllHiddenGems()

    fun getAllSavedHiddenGems(): Flow<List<com.example.data.local.SavedHiddenGemEntity>> =
        tripDao.getAllSavedHiddenGems()

    suspend fun saveHiddenGem(gem: com.example.data.model.HiddenGem, destination: Destination) {
        tripDao.insertHiddenGem(
            com.example.data.local.SavedHiddenGemEntity(
                id = gem.id,
                destinationId = destination.id,
                name = gem.name,
                category = gem.category,
                stateName = destination.state,
                district = destination.district
            )
        )
    }

    suspend fun removeSavedHiddenGem(gemId: String) {
        tripDao.removeHiddenGem(gemId)
    }

    fun getDistanceForCity(destination: Destination, city: String): Int {
        return destination.travelRoute.originDistances[city] ?: 500
    }

    fun getDrivingTimeForCity(destination: Destination, city: String): String {
        return destination.travelRoute.drivingTimes[city] ?: "Approx. 8h drive"
    }

    fun getAllSavedTrips(): Flow<List<SavedTripEntity>> = tripDao.getAllSavedTrips()

    suspend fun saveTrip(itinerary: GeneratedItinerary) {
        val json = itineraryAdapter.toJson(itinerary)
        val entity = SavedTripEntity(
            id = itinerary.id,
            title = itinerary.title,
            destinationName = itinerary.destinationName,
            originCity = itinerary.originCity,
            durationDays = itinerary.durationDays,
            totalBudget = itinerary.estimatedBudget,
            tripType = itinerary.tripType,
            summary = itinerary.summary,
            itineraryJson = json
        )
        tripDao.insertTrip(entity)
    }

    suspend fun deleteSavedTrip(id: String) {
        tripDao.deleteTrip(id)
    }

    fun parseItinerary(json: String): GeneratedItinerary? {
        return try {
            itineraryAdapter.fromJson(json)
        } catch (e: Exception) {
            null
        }
    }

    fun getAllFavorites(): Flow<List<FavoriteDestinationEntity>> = tripDao.getAllFavorites()

    fun isFavorite(destinationId: String): Flow<Boolean> = tripDao.isFavorite(destinationId)

    suspend fun toggleFavorite(destination: Destination, isCurrentlyFav: Boolean) {
        if (isCurrentlyFav) {
            tripDao.removeFavorite(destination.id)
        } else {
            tripDao.insertFavorite(
                FavoriteDestinationEntity(
                    destinationId = destination.id,
                    name = destination.name,
                    state = destination.state,
                    rating = destination.rating
                )
            )
        }
    }

    /**
     * Core AI Trip Planning Engine
     * Combines Gemini Generative AI with intelligent heuristic travel synthesis
     */
    suspend fun generateAiTrip(
        originCity: String,
        budget: Int,
        tripType: String,
        durationDays: Int,
        transportMode: String,
        experience: String,
        customPrompt: String? = null
    ): GeneratedItinerary {
        // Find best matching destination
        val matchedDestination = findBestDestination(
            originCity = originCity,
            budget = budget,
            experience = experience,
            customPrompt = customPrompt
        )

        // Build deep Travel Knowledge context for Gemini
        val knowledgeContext = buildString {
            append("Destination: ${matchedDestination.name} (${matchedDestination.state}, ${matchedDestination.district}). ")
            append("Tagline: ${matchedDestination.tagline}. ")
            append("Best Season: ${matchedDestination.bestTime.bestMonths} (${matchedDestination.bestTime.temperatureRange}). ")
            if (matchedDestination.attractions.isNotEmpty()) {
                append("Attractions & Knowledge: ")
                matchedDestination.attractions.take(3).forEach { a ->
                    append("${a.name} [Entry: ${a.entryFee}, Hours: ${a.openingTime}-${a.closingTime}]. Tip: ${a.insiderTip}. Photo: ${a.photographyAdvice}. Family/Senior: ${a.familySuitability} / ${a.seniorAccessibility}. ")
                }
            }
            if (matchedDestination.foodGuide.localSpecialties.isNotEmpty()) {
                append("Specialties: ")
                matchedDestination.foodGuide.localSpecialties.take(2).forEach { f ->
                    append("${f.name} (${f.priceRange}) at ${f.popularAt}. ")
                }
            }
            append("Route: ${matchedDestination.travelRoute.roadTripRoute}. Condition: ${matchedDestination.travelRoute.roadCondition}.")
        }

        // Try querying Gemini for personalized narrative & highlights if network is available
        val isOnline = com.example.util.NetworkUtils.isNetworkAvailable(context)
        val geminiAnswer = if (isOnline) {
            val aiPrompt = """
                You are a hyper-local travel assistant.
                Trip Request: Origin: $originCity | Budget: ₹$budget | Duration: $durationDays days | Party: $tripType | Transport: $transportMode | Vibe: $experience.
                Knowledge Base for ${matchedDestination.name}:
                $knowledgeContext
                ${customPrompt?.let { "User specific request: '$it'" } ?: ""}

                Using this travel knowledge, produce:
                1. An inspiring 2-sentence summary tailored to this $tripType.
                2. 3 sharp, insider travel tips referencing specific timings, food spots, or photography advice.
            """.trimIndent()
            GeminiClient.askGemini(aiPrompt, timeoutMillis = 5000L)
        } else {
            null // Instant local fallback when offline
        }

        // Calculate comprehensive dynamic budgets via TravelCostEngine
        val costMap = TravelCostEngine.estimateCompleteTrip(
            destination = matchedDestination,
            originCity = originCity,
            days = durationDays,
            partyType = tripType,
            tier = if (budget > 30000) "Luxury" else if (budget < 12000) "Budget" else "Mid-Range",
            transportMode = transportMode
        )

        val stayCost = costMap["stay"] ?: (matchedDestination.budget.stayEstimatePerNight * maxOf(1, durationDays - 1))
        val foodCost = costMap["food"] ?: 3500
        val activitiesCost = costMap["activities"] ?: 1500
        val travelCost = costMap["travel"] ?: 4000
        val totalCost = costMap["total"] ?: (stayCost + foodCost + activitiesCost + travelCost)

        // Build days itinerary based on matched destination
        val itineraryDays = generateDaysPlan(
            destination = matchedDestination,
            originCity = originCity,
            durationDays = durationDays,
            transportMode = transportMode
        )

        val tips = if (!geminiAnswer.isNullOrBlank()) {
            val lines = geminiAnswer.lines()
                .map { it.trim().trimStart('-', '*', '•', '1', '2', '3', '.', ' ') }
                .filter { it.length > 25 }
            if (lines.size >= 3) lines.take(3) else listOf(
                "Gemini Tip: Start before 6:30 AM from $originCity to avoid highway bottlenecks.",
                "Travel Knowledge: ${matchedDestination.attractions.firstOrNull()?.insiderTip ?: "Visit attractions early morning."}",
                "Food Tip: Savor authentic ${matchedDestination.foodGuide.localSpecialties.firstOrNull()?.name ?: "local specialties"}."
            )
        } else {
            listOf(
                "Travel Knowledge: ${matchedDestination.attractions.firstOrNull()?.insiderTip ?: "Visit early to beat tourist crowds."}",
                "Photography: ${matchedDestination.attractions.firstOrNull()?.photographyAdvice ?: "Golden hour lighting is ideal."}",
                "Food Guide: Try authentic ${matchedDestination.foodGuide.localSpecialties.firstOrNull()?.name ?: "regional specialties"}."
            )
        }

        val summaryText = if (!geminiAnswer.isNullOrBlank()) {
            geminiAnswer.lines().filter { it.isNotBlank() }.take(2).joinToString(" ")
        } else {
            "An idyllic $durationDays-day $tripType escape to ${matchedDestination.name} featuring panoramic viewpoints, rich regional dishes, and curated stays."
        }

        return GeneratedItinerary(
            id = UUID.randomUUID().toString(),
            title = "$durationDays-Day ${matchedDestination.name} Escape",
            destinationName = matchedDestination.name,
            originCity = originCity,
            durationDays = durationDays,
            tripType = tripType,
            transportMode = transportMode,
            estimatedBudget = totalCost,
            stayCost = stayCost,
            foodCost = foodCost,
            activitiesCost = activitiesCost,
            travelCost = travelCost,
            summary = summaryText,
            days = itineraryDays,
            packingAndTravelTips = tips
        )
    }

    private fun findBestDestination(
        originCity: String,
        budget: Int,
        experience: String,
        customPrompt: String?
    ): Destination {
        val all = DestinationsDataSource.destinations
        val p = customPrompt?.lowercase() ?: ""

        // Check if prompt specifically mentions a known destination
        val explicitMatch = all.find { p.contains(it.name.lowercase()) || (it.district.isNotBlank() && p.contains(it.district.lowercase())) }
        if (explicitMatch != null) return explicitMatch

        if (!customPrompt.isNullOrBlank()) {
            val parsed = AiTripParser.parseQuery(customPrompt)
            if (parsed.candidateMatches.isNotEmpty()) {
                return parsed.candidateMatches.first().destination
            }
        }

        val ranked = DestinationEngine.rankDestinations(
            originCity = originCity,
            budget = budget,
            durationDays = 3,
            partyType = "Couple",
            preferredVibes = listOf(experience)
        )

        return ranked.firstOrNull()?.destination ?: all.first()
    }

    fun generateDaysPlan(
        destination: Destination,
        originCity: String,
        durationDays: Int,
        transportMode: String
    ): List<ItineraryDay> = com.example.data.engine.ItineraryPlannerEngine.generateDaysPlan(
        destination = destination,
        originCity = originCity,
        durationDays = durationDays,
        transportMode = transportMode
    )
}
