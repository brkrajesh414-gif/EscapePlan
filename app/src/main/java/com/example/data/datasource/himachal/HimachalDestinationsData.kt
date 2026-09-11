package com.example.data.datasource.himachal

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

object HimachalDestinationsData {

    val manali = Destination(
        id = "himachal-manali",
        name = "Manali & Solang Valley",
        state = "Himachal Pradesh",
        stateCode = "HP",
        district = "Kullu",
        latitude = 32.2432,
        longitude = 77.1892,
        tagline = "Himalayan adventure haven amidst deodar forests and snow-crowned summits",
        description = "Manali sits at 2,050 meters along the Beas River. Gateway to Solang Valley, Atal Tunnel, and Ladakh, it offers paragliding, snow activities, apple orchards, wooden Himachali temples, and tranquil forest treks.",
        shortDescription = "Himalayan resort town famous for snow valleys and river adventures",
        bestDurationMinDays = 3,
        bestDurationMaxDays = 5,
        altitude = "2,050 m",
        destinationTypes = listOf("Himalayas", "Snow", "Adventure", "Hill Station", "Rivers", "Trekking"),
        discoveryLevel = DiscoveryLevel.ICONIC,
        bestMonths = "March to June & October to February (for Snow)",
        categories = listOf(TravelCategory.MOUNTAINS, TravelCategory.ADVENTURE, TravelCategory.NATURE),
        attractions = listOf(
            Attraction(
                id = "solang-valley-manali",
                destinationId = "himachal-manali",
                name = "Solang Valley Snow Point",
                description = "Side valley renowned for adventure sports including skiing, paragliding, zorbing, and cable car rides.",
                category = "Adventure / Snow",
                latitude = 32.3166,
                longitude = 77.1578,
                recommendedDurationMinutes = 180,
                familyFriendly = true,
                photographyAllowed = true
            ),
            Attraction(
                id = "hadimba-temple-manali",
                destinationId = "himachal-manali",
                name = "Hidimba Devi Temple",
                description = "Unique 16th-century pagoda-style wooden temple built around a natural cave sanctuary inside towering deodar pine forest.",
                category = "Temple / Heritage",
                latitude = 32.2483,
                longitude = 77.1812,
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 60,
                familyFriendly = true,
                photographyAllowed = true
            )
        ),
        hiddenGems = listOf(
            HiddenGem(
                id = "gem-jogini-waterfall-manali",
                destinationId = "himachal-manali",
                name = "Jogini Waterfall & Vashisht Pine Trail",
                description = "Cascading mountain waterfall flowing through sacred deodar groves, reached via a quiet cliff trek from Vashisht village.",
                whyItIsSpecial = "Secluded natural pools and panoramic views of snow peaks, far quieter than the town center.",
                category = "Hidden Waterfall",
                location = "Vashisht, Manali",
                latitude = 32.2610,
                longitude = 77.1950,
                crowdLevel = "Low to Moderate"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Siddu with Ghee & Walnut Chutney",
                    isVegetarian = true,
                    description = "Steamed fermented wheat bun stuffed with crushed spiced poppy seeds or walnuts, dipped in hot clarified mountain butter.",
                    popularAt = "Old Manali Cafes",
                    priceRange = "₹120 - ₹180"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Delhi" to 540, "Chandigarh" to 310),
            drivingTimes = mapOf("Delhi" to "11 Hours", "Chandigarh" to "7.5 Hours"),
            roadTripRoute = "NH 21 through Kiratpur -> Mandi -> Kullu -> Manali.",
            nearestRailwayStation = "Joginder Nagar (Narrow gauge - 145 km) / Chandigarh (Broad gauge - 310 km)",
            nearestAirport = "Bhuntar Airport (KUU - 50 km)"
        ),
        seasons = RegionalSeasonalHelper.createHighAltitudeSeasons("himachal-manali")
    )

    val destinations: List<Destination> = listOf(manali)
}
