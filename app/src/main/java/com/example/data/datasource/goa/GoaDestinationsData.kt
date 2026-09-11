package com.example.data.datasource.goa

import com.example.data.datasource.common.RegionalSeasonalHelper
import com.example.data.model.Attraction
import com.example.data.model.BestTimeInfo
import com.example.data.model.Destination
import com.example.data.model.DiscoveryLevel
import com.example.data.model.FoodGuide
import com.example.data.model.FoodItem
import com.example.data.model.HiddenGem
import com.example.data.model.TravelCategory
import com.example.data.model.TravelRouteInfo

object GoaDestinationsData {

    val dudhsagar = Destination(
        id = "goa-dudhsagar",
        name = "Dudhsagar Falls & Bhagwan Mahavir Wildlife",
        state = "Goa",
        stateCode = "GA",
        district = "South Goa",
        taluk = "Dharbandora",
        latitude = 15.3144,
        longitude = 74.3143,
        tagline = "The thunderous Sea of Milk cascading in four tiers across the Goa-Karnataka border",
        description = "Dudhsagar ('Sea of Milk') is one of India's tallest four-tiered waterfalls, cascading 310 metres down the sheer Western Ghats inside the Bhagwan Mahaveer Sanctuary. The iconic railway bridge arches directly in front of the middle cascade.",
        shortDescription = "310m four-tiered roaring waterfall through lush tropical jungle",
        bestDurationMinDays = 1,
        bestDurationMaxDays = 2,
        altitude = "310 m",
        destinationTypes = listOf("Waterfall", "Wildlife", "Trekking", "Adventure", "Nature"),
        discoveryLevel = DiscoveryLevel.POPULAR,
        bestMonths = "July to February",
        categories = listOf(TravelCategory.WATERFALLS, TravelCategory.ADVENTURE, TravelCategory.NATURE),
        attractions = listOf(
            Attraction(
                id = "dudhsagar-base-jeep",
                destinationId = "goa-dudhsagar",
                name = "Dudhsagar Jeep Safari & Forest Stream Walk",
                description = "4x4 jungle jeep safari through river crossings in Mollem National Park leading to the base pool.",
                category = "Safari / Trek",
                latitude = 15.3144,
                longitude = 74.3143,
                recommendedDurationMinutes = 180,
                entryFeeAdult = "₹500 jeep safari share + ₹100 forest entry",
                parkingAvailable = true,
                familyFriendly = true,
                tips = "Life jackets are mandatory for entering the base pool; book authorized jeeps from Kulem."
            )
        ),
        hiddenGems = listOf(
            HiddenGem(
                id = "gem-netravali-bubbling-lake",
                destinationId = "goa-dudhsagar",
                name = "Netravali Mysterious Bubbling Lake (Budbud Talyo)",
                description = "An ancient temple pond where methane bubbles mysteriously rise to the surface continuously and intensify when you clap.",
                whyItIsSpecial = "A rare acoustic and geological marvel tucked in a tranquil temple courtyard.",
                category = "Hidden Gem / Sacred Water",
                location = "Netravali, South Goa",
                latitude = 15.0890,
                longitude = 74.2040,
                crowdLevel = "Low"
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Panaji" to 60, "Hyderabad" to 650, "Bengaluru" to 560),
            drivingTimes = mapOf("Panaji" to "1.5 Hours", "Hyderabad" to "12 Hours", "Bengaluru" to "10 Hours"),
            roadTripRoute = "NH 748 through Ponda -> Mollem -> Kulem jeep base.",
            nearestRailwayStation = "Kulem Railway Station (6 km from jeep base)",
            nearestAirport = "Dabolim Airport (GOI - 70 km) / Mopa (GOX - 85 km)"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("goa-dudhsagar")
    )

    val destinations: List<Destination> = listOf(dudhsagar)
}
