package com.example.data.engine

import android.content.Context
import com.example.data.datasource.DestinationsDataSource
import com.example.data.model.Accommodation
import com.example.data.model.Attraction
import com.example.data.model.BestTimeInfo
import com.example.data.model.BudgetBreakdown
import com.example.data.model.Destination
import com.example.data.model.FoodGuide
import com.example.data.model.FoodItem
import com.example.data.model.RestaurantItem
import com.example.data.model.TravelCategory
import com.example.data.model.TravelRouteInfo
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object DataImportEngine {

    private val moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    /**
     * Parse and import destinations from a CSV string.
     * Expected CSV Header:
     * Destination,State,District,Category,BestSeason,BudgetMin,BudgetMax,Attraction1,AttractionTip,SpecialtyFood,RecommendedStay
     */
    fun importFromCsv(csvText: String): List<Destination> {
        val lines = csvText.lines().map { it.trim() }.filter { it.isNotEmpty() }
        if (lines.size <= 1) return emptyList()

        val imported = mutableListOf<Destination>()
        // Skip header
        for (i in 1 until lines.size) {
            val parts = lines[i].split(",").map { it.trim().trim('"', '\'') }
            if (parts.size >= 7) {
                val name = parts[0]
                val state = parts[1]
                val district = if (parts.size > 2) parts[2] else ""
                val categoryStr = if (parts.size > 3) parts[3] else "Nature"
                val bestSeason = if (parts.size > 4) parts[4] else "Oct - Feb"
                val budgetMin = parts.getOrNull(5)?.toIntOrNull() ?: 10000
                val budgetMax = parts.getOrNull(6)?.toIntOrNull() ?: 20000
                val attractionName = parts.getOrNull(7) ?: "$name Viewpoint"
                val attractionTip = parts.getOrNull(8) ?: "Visit early morning to avoid crowds"
                val foodName = parts.getOrNull(9) ?: "Local Regional Thali"
                val stayName = parts.getOrNull(10) ?: "$name Heritage Resort"

                val id = name.lowercase().replace(" ", "-").replace(Regex("[^a-z0-9-]"), "")

                val dest = Destination(
                    id = id,
                    name = name,
                    state = state,
                    district = district,
                    tagline = "Explore the scenic beauty and cultural richness of $name",
                    description = "$name in $state offers a tranquil escape with vibrant attractions, local cuisine, and comfortable stays.",
                    rating = 4.6f,
                    reviewCount = 850,
                    coverResId = null,
                    categories = listOf(TravelCategory.NATURE, TravelCategory.ROAD_TRIPS),
                    bestTime = BestTimeInfo(
                        bestMonths = bestSeason,
                        weatherSummary = "Pleasant and breezy",
                        peakSeason = bestSeason,
                        offSeason = "May - July",
                        expectedCrowd = "Moderate",
                        temperatureRange = "18°C - 28°C",
                        suggestedDuration = "3 Days / 2 Nights"
                    ),
                    attractions = listOf(
                        Attraction(
                            id = "$id-attraction-1",
                            name = attractionName,
                            category = "Scenic View",
                            distanceKmFromCenter = 3.5f,
                            distanceToNextAttraction = "5 km",
                            suggestedDurationHours = "2 hours",
                            description = "Prime point of interest in $name featuring sweeping landscapes.",
                            highlight = "Panorama & Sunrise",
                            insiderTip = attractionTip,
                            openingTime = "08:30 AM",
                            closingTime = "06:00 PM"
                        )
                    ),
                    stays = listOf(
                        Accommodation(
                            id = "$id-stay-1",
                            name = stayName,
                            type = "Resort",
                            pricePerNight = (budgetMin * 0.3).toInt().coerceAtLeast(2000),
                            rating = 4.5f,
                            reviewsCount = 420,
                            distanceFromAttractions = "2.5 km",
                            amenities = listOf("WiFi", "Restaurant", "Parking", "Mountain View"),
                            highlights = "Scenic balcony rooms and authentic hospitality"
                        )
                    ),
                    foodGuide = FoodGuide(
                        localSpecialties = listOf(
                            FoodItem(
                                name = foodName,
                                isVegetarian = false,
                                description = "Traditional local specialty of $name prepared with fresh regional spices.",
                                popularAt = "Local food stalls & highway dhabas"
                            )
                        ),
                        restaurants = listOf(
                            RestaurantItem(
                                name = "$name Garden Restaurant",
                                cuisine = "South Indian & Regional",
                                rating = 4.4f,
                                isVegFriendly = true,
                                signatureDish = foodName,
                                priceForTwo = "₹550",
                                distance = "1 km from town center"
                            )
                        )
                    ),
                    travelRoute = TravelRouteInfo(
                        originDistances = mapOf("Hyderabad" to 550, "Bengaluru" to 450, "Chennai" to 400),
                        drivingTimes = mapOf("Hyderabad" to "9h 30m", "Bengaluru" to "7h 45m"),
                        roadTripRoute = "National Highway connecting to well-paved state arterial roads.",
                        tollAndParkingNotes = "Standard FASTag tolls; ample resort parking available.",
                        nearestRailwayStation = "$name Junction / Station",
                        nearestAirport = "Regional Airport (within 120 km)",
                        busTrainFlightOptions = "Overnight sleeper buses and direct superfast trains connect nearby hubs."
                    ),
                    budget = BudgetBreakdown(
                        stayEstimatePerNight = (budgetMin * 0.3).toInt().coerceAtLeast(2000),
                        foodEstimatePerDay = 1200,
                        activitiesTotal = 1500,
                        travelEstimate = 4500,
                        totalEstimateMin = budgetMin,
                        totalEstimateMax = budgetMax
                    )
                )
                imported.add(dest)
            }
        }
        return imported
    }

    /**
     * Exports a sample CSV template for content contributors
     */
    fun getCsvTemplate(): String {
        return """
Destination,State,District,Category,BestSeason,BudgetMin,BudgetMax,Attraction1,AttractionTip,SpecialtyFood,RecommendedStay
Araku Valley,Andhra Pradesh,Alluri Sitharama Raju,Mountains,Oct - Feb,14000,24000,Borra Caves,Reach before 10 AM to avoid cave crowds,Bamboo Chicken,Haritha Valley Resort
Lambasingi,Andhra Pradesh,Alluri Sitharama Raju,Nature,Nov - Jan,12000,20000,Thajangi Reservoir,Early sunrise between 5:30-6:30 AM has thick fog,Bongu Chicken,Chitrakoot Mist Camp
Horsley Hills,Andhra Pradesh,Chittoor,Mountains,Sep - Feb,10000,18000,Gali Bandalu,Windy sunset point carry light sweater,Eucalyptus Honey,Haritha Hill Resort
Gandikota,Andhra Pradesh,Kadapa,Heritage,Oct - Mar,9000,16000,Pennar River Gorge,Sunset photography from gorge edge is breathtaking,Rayalaseema Ragi Mudda,Freakouts Adventure Camp
        """.trimIndent()
    }
}
