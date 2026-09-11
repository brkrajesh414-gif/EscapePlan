package com.example.data.engine

import com.example.data.model.Attraction
import com.example.data.model.DayStop
import com.example.data.model.Destination
import com.example.data.model.ItineraryDay

object ItineraryPlannerEngine {

    /**
     * Generates a balanced day-by-day itinerary for any duration (1 to 7+ days)
     * based on the destination's rich data (attractions, food specialties, and route times).
     */
    fun generateDaysPlan(
        destination: Destination,
        originCity: String,
        durationDays: Int,
        transportMode: String
    ): List<ItineraryDay> {
        val days = mutableListOf<ItineraryDay>()
        val attractions = if (destination.attractions.isNotEmpty()) destination.attractions else listOf(
            Attraction(
                id = "attr-default-1",
                destinationId = destination.id,
                name = "${destination.name} Heritage Landmark",
                description = "Iconic attraction showcasing the history and beauty of ${destination.name}.",
                category = "Heritage"
            ),
            Attraction(
                id = "attr-default-2",
                destinationId = destination.id,
                name = "${destination.name} Scenic Point",
                description = "Panoramic natural viewpoint overlooking the landscapes of ${destination.district}.",
                category = "Nature"
            )
        )

        val daysCount = maxOf(1, durationDays)

        if (daysCount == 1) {
            // 1-Day: Express Highlights
            val attr1 = attractions[0]
            val attr2 = attractions.getOrNull(1) ?: attr1
            val stops = listOf(
                DayStop(
                    timeOfDay = "Morning (06:00 – 10:30)",
                    title = "$originCity → ${destination.name} & Morning Wonder",
                    placeOrActivity = "Depart early from $originCity via $transportMode. Head straight to ${attr1.name}.",
                    duration = destination.travelRoute.drivingTimes[originCity] ?: "3 Hours",
                    foodSuggestion = "Breakfast: Highway tiffin or authentic local idli/dosa along the route",
                    tip = "Depart before 06:30 AM to maximize day sightseeing hours."
                ),
                DayStop(
                    timeOfDay = "Afternoon (11:00 – 15:30)",
                    title = "${attr1.name} & Local Flavors",
                    placeOrActivity = "${attr1.description}. Spend quality time exploring the landmark before a regional lunch.",
                    duration = attr1.suggestedDurationHours,
                    foodSuggestion = "Lunch: Must-try ${destination.foodGuide.localSpecialties.firstOrNull()?.name ?: "authentic regional thali"}",
                    tip = attr1.insiderTip.ifBlank { "Keep hydrated and wear comfortable walking footwear." }
                ),
                DayStop(
                    timeOfDay = "Evening & Return (16:00 – Night)",
                    title = "${attr2.name} Sunset & Return to $originCity",
                    placeOrActivity = "Visit ${attr2.name} for sunset vistas. Pick up local handicrafts before driving back to $originCity.",
                    duration = "3-4 Hours transit",
                    foodSuggestion = "Evening snack: Local tea/snack, dinner on highway return",
                    tip = "Carry memories and souvenirs from local markets."
                )
            )
            days.add(
                ItineraryDay(
                    dayNumber = 1,
                    dayTitle = "Day 1: Express Highlights of ${destination.name}",
                    routeHighlight = "$originCity → ${attr1.name} → ${attr2.name} → Return $originCity",
                    stops = stops
                )
            )
            return days
        }

        // For multi-day trips (2 to 7+ days)
        // Day 1: Arrival, Check-in & Sunset Vista
        val eveningAttr = attractions.getOrNull(2) ?: attractions.last()
        days.add(
            ItineraryDay(
                dayNumber = 1,
                dayTitle = "Day 1: Arrival & Evening Golden Hour",
                routeHighlight = "$originCity → ${destination.name} → Check-in → ${eveningAttr.name}",
                stops = listOf(
                    DayStop(
                        timeOfDay = "Morning (06:30 – 12:30)",
                        title = "$originCity → ${destination.name} Transit",
                        placeOrActivity = "Scenic road transit via $transportMode through picturesque countryside.",
                        duration = destination.travelRoute.drivingTimes[originCity] ?: "Morning transit",
                        foodSuggestion = "Highway Breakfast: Fresh tiffin at highway stop",
                        tip = "Check tire pressures and carry offline maps before departure."
                    ),
                    DayStop(
                        timeOfDay = "Afternoon (13:00 – 15:30)",
                        title = "Hotel Check-in & Regional Lunch",
                        placeOrActivity = "Check into ${destination.stays.firstOrNull()?.name ?: "curated resort"} and unwind.",
                        duration = "2 Hours",
                        foodSuggestion = "Lunch: ${destination.foodGuide.restaurants.firstOrNull()?.signatureDish ?: "Traditional regional feast"}"
                    ),
                    DayStop(
                        timeOfDay = "Evening (16:00 – 19:30)",
                        title = "${eveningAttr.name} & Twilight Views",
                        placeOrActivity = "Experience ${eveningAttr.name} during golden hour.",
                        duration = "2.5 Hours",
                        foodSuggestion = "Evening: Fresh snacks and local tea",
                        tip = eveningAttr.insiderTip.ifBlank { "Best lighting for landscape photography." }
                    )
                )
            )
        )

        // Intermediate Days: 2 to daysCount - 1
        for (d in 2 until daysCount) {
            val attrIndex1 = ((d - 2) * 2) % attractions.size
            val attrIndex2 = ((d - 2) * 2 + 1) % attractions.size
            val a1 = attractions[attrIndex1]
            val a2 = attractions[attrIndex2]

            val dayFocusTitle = when (d) {
                2 -> "Core Wonders & Historic Landmarks"
                3 -> "Nature Trails, Lakes & Scenic Splendors"
                4 -> "Local Culture, Craft Traditions & Hidden Gems"
                5 -> "Wildlife Reserves & Forest Exploration"
                6 -> "Panoramic Viewpoints & Culinary Trails"
                else -> "Deep Exploration & Leisure Day"
            }

            days.add(
                ItineraryDay(
                    dayNumber = d,
                    dayTitle = "Day $d: $dayFocusTitle",
                    routeHighlight = "${a1.name} → ${a2.name} → Evening Bazaar",
                    stops = listOf(
                        DayStop(
                            timeOfDay = "Morning (08:30 – 12:30)",
                            title = a1.name,
                            placeOrActivity = a1.description,
                            duration = a1.suggestedDurationHours,
                            foodSuggestion = "Breakfast at stay: Fresh local fruits and hot breakfast",
                            tip = a1.insiderTip.ifBlank { "Arrive early to beat mid-day heat." }
                        ),
                        DayStop(
                            timeOfDay = "Afternoon (13:00 – 16:30)",
                            title = a2.name,
                            placeOrActivity = a2.description,
                            duration = a2.suggestedDurationHours,
                            foodSuggestion = "Lunch: ${destination.foodGuide.localSpecialties.getOrNull(d % destination.foodGuide.localSpecialties.size.coerceAtLeast(1))?.name ?: "Authentic local specialty"}"
                        ),
                        DayStop(
                            timeOfDay = "Evening (17:00 – 20:30)",
                            title = "Cultural Immersion & Local Markets",
                            placeOrActivity = "Explore local bazaars for regional crafts, textiles, and spices of ${destination.district}.",
                            duration = "2 Hours",
                            foodSuggestion = "Dinner at ${destination.foodGuide.restaurants.getOrNull(1)?.name ?: "authentic local eatery"}"
                        )
                    )
                )
            )
        }

        // Final Day: Morning Sight, Souvenir Shopping & Return Journey
        val finalAttr = attractions.getOrNull(1) ?: attractions.first()
        days.add(
            ItineraryDay(
                dayNumber = daysCount,
                dayTitle = "Day $daysCount: Scenic Finale & Return to $originCity",
                routeHighlight = "${finalAttr.name} → Souvenir Shopping → Return to $originCity",
                stops = listOf(
                    DayStop(
                        timeOfDay = "Morning (08:00 – 11:30)",
                        title = finalAttr.name,
                        placeOrActivity = finalAttr.description,
                        duration = finalAttr.suggestedDurationHours,
                        foodSuggestion = "Breakfast and hotel checkout",
                        tip = "Pack bags and complete checkout formalities."
                    ),
                    DayStop(
                        timeOfDay = "Afternoon (12:30 – 14:30)",
                        title = "Local Handicrafts & Farewell Lunch",
                        placeOrActivity = "Pick up authentic souvenirs, GI-tagged crafts, and regional delicacies from ${destination.name}.",
                        duration = "1.5 Hours",
                        foodSuggestion = "Farewell Lunch: Hearty lunch before driving back"
                    ),
                    DayStop(
                        timeOfDay = "Evening (15:00 – Night)",
                        title = "Return Journey to $originCity",
                        placeOrActivity = "Scenic drive back via $transportMode with wonderful memories.",
                        duration = destination.travelRoute.drivingTimes[originCity] ?: "Return transit",
                        tip = "Plan a highway tea stop during sunset."
                    )
                )
            )
        )

        return days
    }
}
