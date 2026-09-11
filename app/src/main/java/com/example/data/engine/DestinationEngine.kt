package com.example.data.engine

import com.example.data.datasource.DestinationsDataSource
import com.example.data.model.Destination
import com.example.data.model.DestinationMatch
import com.example.data.model.TravelCategory
import java.util.Calendar
import kotlin.math.roundToInt

object DestinationEngine {

    /**
     * Retrieve all destinations in the catalog
     */
    fun getAllDestinations(): List<Destination> = DestinationsDataSource.destinations

    /**
     * Look up destination by unique identifier
     */
    fun getDestinationById(id: String): Destination? = DestinationsDataSource.getDestinationById(id)

    /**
     * Filter destinations by state (e.g., Telangana, Andhra Pradesh, Karnataka, Kerala)
     */
    fun getDestinationsByState(state: String): List<Destination> {
        if (state.isBlank() || state.equals("All", ignoreCase = true)) {
            return getAllDestinations()
        }
        return getAllDestinations().filter { it.state.contains(state, ignoreCase = true) }
    }

    /**
     * Get distinct list of states represented in the catalog
     */
    fun getAvailableStates(): List<String> {
        val states = getAllDestinations().map { it.state }.distinct().sorted()
        return listOf("All") + states
    }

    /**
     * Filter destinations within a maximum road distance from an origin city
     */
    fun getDestinationsWithinDistance(originCity: String, maxDistanceKm: Int): List<Destination> {
        return getAllDestinations().filter { dest ->
            val dist = dest.travelRoute.originDistances[originCity] ?: 300
            dist <= maxDistanceKm
        }.sortedBy { it.travelRoute.originDistances[originCity] ?: 300 }
    }

    /**
     * Filter destinations by travel category / experience vibe
     */
    fun getDestinationsByCategory(category: TravelCategory): List<Destination> {
        return getAllDestinations().filter { it.categories.contains(category) }
    }

    /**
     * Multi-criteria scoring engine:
     * destinationScore = originDistanceScore + budgetScore + durationScore + travellerTypeScore + experienceScore + seasonScore + transportScore
     */
    fun rankDestinations(
        originCity: String,
        budget: Int,
        durationDays: Int,
        partyType: String = "Couple",
        preferredVibes: List<String> = emptyList(),
        transportMode: String = "Car"
    ): List<DestinationMatch> {
        val destinations = getAllDestinations()
        val scoredList = mutableListOf<DestinationMatch>()

        val currentMonth = when (Calendar.getInstance().get(Calendar.MONTH)) {
            Calendar.JANUARY -> "January"
            Calendar.FEBRUARY -> "February"
            Calendar.MARCH -> "March"
            Calendar.APRIL -> "April"
            Calendar.MAY -> "May"
            Calendar.JUNE -> "June"
            Calendar.JULY -> "July"
            Calendar.AUGUST -> "August"
            Calendar.SEPTEMBER -> "September"
            Calendar.OCTOBER -> "October"
            Calendar.NOVEMBER -> "November"
            else -> "December"
        }

        for (dest in destinations) {
            val reasons = mutableListOf<String>()

            val distanceKm = dest.travelRoute.originDistances[originCity]
                ?: if (originCity.equals("Hyderabad", ignoreCase = true) && dest.state.equals("Telangana", ignoreCase = true)) 160 else 350

            val costEstimate = TravelCostEngine.estimateCompleteTrip(
                destination = dest,
                originCity = originCity,
                days = durationDays,
                partyType = partyType,
                tier = if (budget < 12000) "Budget" else if (budget > 35000) "Luxury" else "Mid-Range",
                transportMode = transportMode
            )
            val totalCost = costEstimate["total"] ?: 12000

            // 1. originDistanceScore (0 to 20 pts)
            // Suitable driving radius according to trip duration (e.g., 1 day -> <150km, 2 days -> <300km, 3 days -> <500km)
            val idealMaxDistance = durationDays * 160
            val originDistanceScore: Double = when {
                distanceKm <= idealMaxDistance -> {
                    reasons.add("Ideal distance: $distanceKm km from $originCity")
                    20.0
                }
                distanceKm <= idealMaxDistance + 120 -> {
                    reasons.add("Manageable road distance: $distanceKm km from $originCity")
                    15.0
                }
                distanceKm <= idealMaxDistance + 250 -> 10.0
                else -> 5.0
            }

            // 2. budgetScore (0 to 20 pts)
            val budgetScore: Double = when {
                totalCost <= budget -> {
                    val savings = budget - totalCost
                    val ratio = (savings.toDouble() / (budget + 1)).coerceAtMost(0.4)
                    reasons.add("Fits comfortably within budget (Est. ₹$totalCost vs ₹$budget)")
                    16.0 + (4.0 * (1.0 - ratio))
                }
                totalCost <= (budget * 1.15) -> {
                    reasons.add("Slight stretch on budget (Est. ₹$totalCost vs ₹$budget)")
                    12.0
                }
                else -> 4.0
            }

            // 3. durationScore (0 to 15 pts)
            val durationScore: Double = when {
                durationDays in dest.bestDurationMinDays..dest.bestDurationMaxDays -> {
                    reasons.add("Perfect $durationDays-day pace for ${dest.name}")
                    15.0
                }
                durationDays == dest.bestDurationMinDays - 1 || durationDays == dest.bestDurationMaxDays + 1 -> 11.0
                else -> 7.0
            }

            // 4. travellerTypeScore (0 to 15 pts)
            val destText = (dest.name + " " + dest.tagline + " " + dest.description + " " + dest.recommendedFor.joinToString(" ") + " " + dest.categories.joinToString(" ") { it.displayName }).lowercase()
            val travellerTypeScore: Double = when (partyType.lowercase()) {
                "solo" -> {
                    if (destText.contains("solo") || destText.contains("peaceful") || destText.contains("trek") || destText.contains("heritage")) {
                        reasons.add("Great peaceful solo retreat")
                        15.0
                    } else 12.0
                }
                "couple" -> {
                    if (destText.contains("couple") || destText.contains("scenic") || destText.contains("romantic") || destText.contains("resort") || dest.categories.contains(TravelCategory.COUPLES)) {
                        reasons.add("Curated romantic stays & scenic spots for couples")
                        15.0
                    } else 12.0
                }
                "family" -> {
                    if (destText.contains("family") || dest.attractions.any { it.familyFriendly } || dest.categories.contains(TravelCategory.FAMILY)) {
                        reasons.add("Family-friendly attractions & comfortable amenities")
                        15.0
                    } else 11.0
                }
                "friends" -> {
                    if (destText.contains("adventure") || destText.contains("trek") || destText.contains("road trip") || destText.contains("friends")) {
                        reasons.add("Exciting adventure & outdoor spots for friends")
                        15.0
                    } else 12.0
                }
                else -> 12.0
            }

            // 5. experienceScore (0 to 15 pts)
            var vibeHits = 0
            if (preferredVibes.isNotEmpty()) {
                for (vibe in preferredVibes) {
                    val v = vibe.lowercase().trim()
                    if (v.isBlank()) continue
                    if (destText.contains(v) ||
                        (v.contains("peace") && (destText.contains("serene") || destText.contains("calm") || destText.contains("quiet"))) ||
                        (v.contains("scener") && (destText.contains("view") || destText.contains("hills") || destText.contains("nature"))) ||
                        (v.contains("nature") && (destText.contains("forest") || destText.contains("green") || destText.contains("lake") || destText.contains("waterfall"))) ||
                        (v.contains("food") && (dest.foodGuide.localSpecialties.isNotEmpty() || dest.foodSpecialties.isNotEmpty())) ||
                        (v.contains("heritage") && (destText.contains("fort") || destText.contains("temple") || destText.contains("unesco") || destText.contains("history"))) ||
                        (v.contains("adventure") && (destText.contains("trek") || destText.contains("climb") || destText.contains("boating") || destText.contains("waterfall")))
                    ) {
                        vibeHits++
                    }
                }
            }
            val experienceScore: Double = if (preferredVibes.isEmpty()) {
                12.0
            } else {
                val ratio = vibeHits.toDouble() / preferredVibes.size
                if (vibeHits > 0) {
                    reasons.add("Matches ${preferredVibes.take(2).joinToString(", ")} vibes")
                }
                (ratio * 15.0).coerceIn(4.0, 15.0)
            }

            // 6. seasonScore (0 to 10 pts)
            val seasonScore: Double = when {
                dest.bestTime.bestMonths.contains(currentMonth, ignoreCase = true) || dest.bestMonths.contains(currentMonth, ignoreCase = true) -> {
                    reasons.add("In prime season right now ($currentMonth)")
                    10.0
                }
                dest.bestTime.peakSeason.contains(currentMonth, ignoreCase = true) -> 9.0
                else -> 6.0
            }

            // 7. transportScore (0 to 5 pts)
            val transportScore: Double = when (transportMode.lowercase()) {
                "car", "bike" -> if (distanceKm <= 400) 5.0 else 3.0
                "train" -> if (dest.travelRoute.nearestRailwayStation.isNotBlank()) 5.0 else 2.0
                "bus" -> 4.0
                "flight" -> if (dest.travelRoute.nearestAirport.isNotBlank()) 5.0 else 2.0
                else -> 4.0
            }

            val totalScore = originDistanceScore + budgetScore + durationScore + travellerTypeScore + experienceScore + seasonScore + transportScore
            val finalPercentage = totalScore.roundToInt().coerceIn(45, 98)

            scoredList.add(
                DestinationMatch(
                    destination = dest,
                    matchPercentage = finalPercentage,
                    matchingReasons = reasons.take(3),
                    distanceFromOriginKm = distanceKm,
                    estimatedTripCost = totalCost
                )
            )
        }

        return scoredList.sortedByDescending { it.matchPercentage }
    }
}
