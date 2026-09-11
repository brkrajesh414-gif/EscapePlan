package com.example.data.datasource.rajasthan

import com.example.data.datasource.common.RegionalSeasonalHelper
import com.example.data.model.Attraction
import com.example.data.model.BestTimeInfo
import com.example.data.model.Destination
import com.example.data.model.DiscoveryLevel
import com.example.data.model.FoodGuide
import com.example.data.model.FoodItem
import com.example.data.model.TravelCategory
import com.example.data.model.TravelRouteInfo

object RajasthanDestinationsData {

    val jaipur = Destination(
        id = "rajasthan-jaipur",
        name = "Jaipur (The Pink City)",
        state = "Rajasthan",
        stateCode = "RJ",
        district = "Jaipur",
        latitude = 26.9124,
        longitude = 75.7873,
        tagline = "The royal capital of palaces, hilltop forts, astronomical wonders, and vibrant bazaars",
        description = "Jaipur, UNESCO World Heritage city, is the capital of Rajasthan. Founded in 1727 by Maharaja Sawai Jai Singh II, it is famous for its rose-pink terracotta walls, Amer Fort, the lattice facade of Hawa Mahal, and astronomical Jantar Mantar.",
        shortDescription = "Royal pink city with majestic hilltop forts and grand royal palaces",
        bestDurationMinDays = 2,
        bestDurationMaxDays = 4,
        destinationTypes = listOf("Heritage", "Palaces", "Forts", "Shopping", "Food", "UNESCO Heritage"),
        discoveryLevel = DiscoveryLevel.ICONIC,
        bestMonths = "October to March",
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.FAMILY, TravelCategory.FOOD),
        attractions = listOf(
            Attraction(
                id = "amer-fort-jaipur",
                destinationId = "rajasthan-jaipur",
                name = "Amer Fort & Sheesh Mahal",
                description = "Opulent hilltop fort with Rajput and Mughal architecture, artistic cobbled pathways, and the glittering Mirror Palace.",
                category = "Fort",
                latitude = 26.9855,
                longitude = 75.8513,
                openingTime = "08:00 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "₹100 (Indian) / ₹500 (Foreigner)",
                recommendedDurationMinutes = 150,
                familyFriendly = true,
                photographyAllowed = true
            ),
            Attraction(
                id = "hawa-mahal-jaipur",
                destinationId = "rajasthan-jaipur",
                name = "Hawa Mahal (Palace of Winds)",
                description = "Five-story pink sandstone pyramid with 953 intricately carved jharokhas (casements) designed for royal women to observe street festivals unseen.",
                category = "Palace",
                latitude = 26.9239,
                longitude = 75.8267,
                entryFeeAdult = "₹50",
                recommendedDurationMinutes = 60,
                familyFriendly = true,
                photographyAllowed = true
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Pyaaz Kachori & Dal Baati Churma",
                    isVegetarian = true,
                    description = "Flaky golden pastry filled with spiced onions, accompanied by baked wheat balls dunked in pure ghee with spiced lentil curry.",
                    popularAt = "Rawat Mishthan Bhandar",
                    priceRange = "₹50 - ₹200"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Delhi" to 280, "Agra" to 240, "Hyderabad" to 1480, "Mumbai" to 1150),
            drivingTimes = mapOf("Delhi" to "4.5 Hours via Delhi-Mumbai Expressway", "Agra" to "4 Hours"),
            roadTripRoute = "NH 48 or the new Delhi-Mumbai Expressway directly connected to Jaipur ring road.",
            nearestRailwayStation = "Jaipur Junction",
            nearestAirport = "Jaipur International Airport (JAI)"
        ),
        seasons = RegionalSeasonalHelper.createDeccanSeasons("rajasthan-jaipur")
    )

    val destinations: List<Destination> = listOf(jaipur)
}
