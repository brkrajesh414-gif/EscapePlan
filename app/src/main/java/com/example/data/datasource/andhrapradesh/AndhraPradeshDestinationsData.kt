package com.example.data.datasource.andhrapradesh

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

object AndhraPradeshDestinationsData {

    val arakuValley = Destination(
        id = "andhra-araku",
        name = "Araku Valley & Borra Caves",
        state = "Andhra Pradesh",
        stateCode = "AP",
        district = "Alluri Sitharama Raju",
        latitude = 18.3273,
        longitude = 82.8775,
        tagline = "Misty Eastern Ghats coffee hills and million-year-old subterranean caves",
        description = "Araku Valley is a serene hill station nestled amidst the high ranges of the Eastern Ghats. Famous for organic tribal coffee plantations, Katiki waterfall, and the awe-inspiring 150-million-year-old Borra Caves with massive stalactites and stalagmites.",
        shortDescription = "Eastern Ghats misty coffee valley, tribal heritage, and ancient caves",
        bestDurationMinDays = 2,
        bestDurationMaxDays = 3,
        altitude = "911 m",
        destinationTypes = listOf("Hill Station", "Caves", "Coffee Plantations", "Waterfalls", "Tribal Culture"),
        discoveryLevel = DiscoveryLevel.POPULAR,
        bestMonths = "October to March",
        categories = listOf(TravelCategory.MOUNTAINS, TravelCategory.NATURE, TravelCategory.HERITAGE),
        attractions = listOf(
            Attraction(
                id = "borra-caves-ap",
                destinationId = "andhra-araku",
                name = "Borra Limestone Caves",
                description = "Deep limestone caves illuminated with multi-colored lights, featuring natural calcite formations resembling the Shivalinga.",
                category = "Caves / Geological",
                latitude = 18.2811,
                longitude = 83.0396,
                openingTime = "10:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "₹80",
                recommendedDurationMinutes = 90,
                familyFriendly = true,
                photographyAllowed = true
            ),
            Attraction(
                id = "katiki-waterfalls",
                destinationId = "andhra-araku",
                name = "Katiki Waterfalls",
                description = "Scenic 50-foot waterfall cascading from the Gosthani river deep inside dense forests, reachable by local 4x4 jeeps.",
                category = "Waterfall",
                latitude = 18.2980,
                longitude = 83.0120,
                recommendedDurationMinutes = 90,
                discoveryLevel = DiscoveryLevel.HIDDEN_GEM
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Bongu Chicken (Bamboo Chicken)",
                    isVegetarian = false,
                    description = "Tender marinated chicken slow-cooked inside raw bamboo hollows over glowing charcoal with zero oil.",
                    popularAt = "Araku Valley tribal food stalls",
                    priceRange = "₹250 - ₹350"
                ),
                FoodItem(
                    name = "Araku Organic Filter Coffee",
                    isVegetarian = true,
                    description = "Rich, aromatic single-origin Arabica coffee grown organically by indigenous tribal farmers.",
                    popularAt = "Araku Coffee House",
                    priceRange = "₹40 - ₹80"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Visakhapatnam" to 115, "Hyderabad" to 650, "Bhubaneswar" to 430),
            drivingTimes = mapOf("Visakhapatnam" to "3 Hours", "Hyderabad" to "11.5 Hours"),
            roadTripRoute = "NH 16 from Vizag -> Pendurthi -> S.Kota -> Ananthagiri Ghat to Araku.",
            nearestRailwayStation = "Araku Railway Station (Scenic Vistadome train route from Vizag)",
            nearestAirport = "Visakhapatnam Airport (VTZ - 110 km)"
        ),
        seasons = RegionalSeasonalHelper.createDeccanSeasons("andhra-araku")
    )

    val gandikota = Destination(
        id = "andhra-gandikota",
        name = "Gandikota (The Grand Canyon of India)",
        state = "Andhra Pradesh",
        stateCode = "AP",
        district = "YSR Kadapa",
        latitude = 14.8142,
        longitude = 78.2862,
        tagline = "Spectacular red sandstone gorge carved by the Pennar River beneath a 12th-century fort",
        description = "Gandikota is India's Grand Canyon, where the Pennar River has carved a deep, majestic gorge through the Erramala hills over millennia. The massive granite Gandikota Fort perches on the edge of the abyss, housing ancient temples, a historic granary, and the Jamia Masjid.",
        shortDescription = "Majestic river gorge canyon and ancient stone fort",
        bestDurationMinDays = 1,
        bestDurationMaxDays = 2,
        destinationTypes = listOf("Canyon", "Fort", "Camping", "Heritage", "Geological Wonder", "Sunset"),
        discoveryLevel = DiscoveryLevel.OFFBEAT,
        bestMonths = "September to February",
        categories = listOf(TravelCategory.ADVENTURE, TravelCategory.HERITAGE, TravelCategory.NATURE),
        attractions = listOf(
            Attraction(
                id = "gandikota-gorge-view",
                destinationId = "andhra-gandikota",
                name = "Pennar River Gorge Viewpoint",
                description = "Clifftop viewpoint offering breathtaking views of the 300-foot deep river canyon and sheer layered bedrock.",
                category = "Canyon / Viewpoint",
                latitude = 14.8142,
                longitude = 78.2862,
                openingTime = "24 Hours",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 120,
                familyFriendly = true,
                photographyAllowed = true,
                tips = "Watch both sunrise and sunset here; cliff-edge rock camping is available."
            ),
            Attraction(
                id = "belum-caves-near-gandikota",
                destinationId = "andhra-gandikota",
                name = "Belum Caves (60 km from Gandikota)",
                description = "Second largest cave system in India, extending over 3.2 km with underground passages, sinkholes, and freshwater streams.",
                category = "Caves",
                latitude = 15.1012,
                longitude = 78.1118,
                entryFeeAdult = "₹65",
                recommendedDurationMinutes = 120,
                familyFriendly = true
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Bengaluru" to 280, "Hyderabad" to 380, "Chennai" to 390),
            drivingTimes = mapOf("Bengaluru" to "5.5 Hours", "Hyderabad" to "7 Hours", "Chennai" to "7.5 Hours"),
            roadTripRoute = "NH 44 -> Anantapur / Gooty -> Jammalamadugu -> Gandikota.",
            nearestRailwayStation = "Muddanuru Railway Station (26 km) / Jammalamadugu (15 km)",
            nearestAirport = "Bengaluru Airport (260 km) / Tirupati Airport (220 km)"
        ),
        seasons = RegionalSeasonalHelper.createDeccanSeasons("andhra-gandikota")
    )

    val destinations: List<Destination> = listOf(arakuValley, gandikota)
}
