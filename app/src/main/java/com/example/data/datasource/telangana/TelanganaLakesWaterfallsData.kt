package com.example.data.datasource.telangana

import com.example.R
import com.example.data.model.*

object TelanganaLakesWaterfallsData {

    val laknavaram = Destination(
        id = "telangana-laknavaram",
        name = "Laknavaram Lake",
        state = "Telangana",
        district = "Mulugu",
        mandal = "Govindaraopet",
        latitude = 18.1583,
        longitude = 80.0556,
        tagline = "Island Archipelago, Hanging Suspension Bridge & Forest Waters",
        description = "Sprawling 10,000-acre natural Kakatiya lake surrounded by dense Govindaraopet reserve forest, featuring 13 lush green islands, a 160-meter iconic hanging suspension bridge, and island glamping.",
        bestDurationMinDays = 1,
        bestDurationMaxDays = 2,
        altitude = "210 m MSL",
        destinationTypes = listOf("Lakes", "Nature", "Eco Tourism", "Boating", "Camping"),
        bestMonths = "August to February",
        recommendedFor = listOf("Couples", "Family", "Adventure Lovers", "Nature Seekers"),
        rating = 4.7f,
        reviewCount = 5900,
        categories = listOf(TravelCategory.NATURE, TravelCategory.LAKES, TravelCategory.COUPLES, TravelCategory.ROAD_TRIPS),
        bestTime = BestTimeInfo(
            bestMonths = "August to February",
            weatherSummary = "Lush green post-monsoon scenery with cool morning lake mists",
            peakSeason = "October – January",
            offSeason = "April – June",
            expectedCrowd = "Moderate to High on weekends",
            temperatureRange = "18°C – 32°C",
            suggestedDuration = "1–2 Days"
        ),
        attractions = listOf(
            Attraction(
                id = "lkn-hanging-bridge",
                destinationId = "telangana-laknavaram",
                name = "Hanging Suspension Bridge & Island Walk",
                description = "160-meter steel suspension bridge connecting the main lakeshore to an idyllic wooded island with walking paths and bamboo benches.",
                category = "Suspension Bridge",
                openingTime = "08:00 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "₹50 (Entry + Bridge)",
                entryFeeChild = "₹30",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning or late afternoon for reflections on water",
                tips = "Take the speed boat across to secluded islands for tranquil forest views."
            ),
            Attraction(
                id = "lkn-speed-boating",
                destinationId = "telangana-laknavaram",
                name = "Telangana Tourism Island Boating",
                description = "Motor boats and high-speed watercraft ferrying visitors between the 13 lush wooded islands and remote lake coves.",
                category = "Boating",
                openingTime = "09:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "₹100 per person (Motor Boat), ₹400 (Speed Boat)",
                entryFeeChild = "₹50",
                recommendedDurationMinutes = 45,
                parkingAvailable = true,
                parkingFee = "Included",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Sunset ride at 04:30 PM",
                tips = "Life jackets are strictly mandatory and provided at boarding."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-lkn-haritha-island",
                destinationId = "telangana-laknavaram",
                name = "Haritha Lake View Island Resort, Laknavaram",
                category = "Eco Island Resort",
                minimumPrice = 2800,
                maximumPrice = 4500,
                rating = 4.4f,
                reviewCount = 1250,
                amenities = listOf("Island Wooden Cottages", "Boat Transfer", "Restaurant", "Campfire"),
                approximatePrice = "Approx. ₹3,200 / night (verify before travel)",
                phone = "+91 8715 200 400",
                website = "https://tourism.telangana.gov.in",
                lastVerifiedDate = "2024-2025"
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Hyderabad" to 220, "Warangal" to 72, "Mulugu" to 26),
            drivingTimes = mapOf("Hyderabad" to "4h 30m", "Warangal" to "1h 40m", "Mulugu" to "35m"),
            roadTripRoute = "Hyderabad -> Warangal (NH163) -> Mulugu -> Pasra -> Govindaraopet -> Laknavaram Lake.",
            tollAndParkingNotes = "Toll on NH163 up to Warangal (~₹160); forest parking ₹30.",
            nearestRailwayStation = "Warangal (72 km) / Kazipet (78 km)",
            nearestAirport = "Hyderabad RGI Airport (240 km)",
            busTrainFlightOptions = "Buses from Hanamkonda to Pasra / Medaram stop near the Laknavaram lake turnoff."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 900,
            activitiesTotal = 700,
            travelEstimate = 2200,
            totalEstimateMin = 5900,
            totalEstimateMax = 11500
        )
    )

    val pakhalLake = Destination(
        id = "telangana-pakhal",
        name = "Pakhal Lake",
        state = "Telangana",
        district = "Warangal",
        mandal = "Khanapur",
        latitude = 17.9628,
        longitude = 79.9922,
        tagline = "Ancient 1213 CE Forest Sanctuary & Hilltop Lake",
        description = "Constructed by Kakatiya King Ganapathideva in 1213 CE by damming a tributary of the Krishna river, Pakhal Lake is embraced by undulating low hillocks and a 839 sq km teeming wildlife sanctuary.",
        bestDurationMinDays = 1,
        bestDurationMaxDays = 2,
        altitude = "280 m MSL",
        destinationTypes = listOf("Lakes", "Wildlife", "Nature", "Heritage"),
        bestMonths = "November to March",
        recommendedFor = listOf("Nature Lovers", "Bird Watchers", "Couples", "Peaceful Retreats"),
        rating = 4.4f,
        reviewCount = 2800,
        categories = listOf(TravelCategory.NATURE, TravelCategory.LAKES, TravelCategory.WILDLIFE),
        attractions = listOf(
            Attraction(
                id = "pkh-sanctuary",
                destinationId = "telangana-pakhal",
                name = "Pakhal Wildlife Sanctuary & Lake Bund",
                description = "Dense deciduous forest home to leopards, chital deer, four-horned antelopes, marsh crocodiles, and migratory waterfowl like teals and egrets.",
                category = "Wildlife Sanctuary",
                openingTime = "06:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "₹30",
                entryFeeChild = "₹15",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Early morning for migratory birds, or 04:30 PM for crocodile spotting",
                tips = "Carry binoculars for birdwatching along the shallow eastern marshes."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-pkh-haritha",
                destinationId = "telangana-pakhal",
                name = "Haritha Forest Camp, Pakhal",
                category = "Government Tourism",
                minimumPrice = 1600,
                maximumPrice = 2800,
                rating = 4.0f,
                reviewCount = 420,
                amenities = listOf("Lake-Facing Rooms", "Dining", "Forest Walkways"),
                approximatePrice = "Approx. ₹1,800 / night (verify before travel)",
                phone = "+91 870 256 2236",
                lastVerifiedDate = "2024-2025"
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Hyderabad" to 200, "Warangal" to 50, "Narsampet" to 12),
            drivingTimes = mapOf("Hyderabad" to "4h 0m", "Warangal" to "1h 15m", "Narsampet" to "20m"),
            roadTripRoute = "Hyderabad -> Warangal (NH163) -> Narsampet road -> Pakhal Lake.",
            tollAndParkingNotes = "Standard toll on NH163 (~₹160).",
            nearestRailwayStation = "Warangal (50 km) / Kazipet (56 km)",
            nearestAirport = "Hyderabad RGI Airport (220 km)",
            busTrainFlightOptions = "TSRTC buses run from Warangal to Narsampet with local auto connects to the lake."
        )
    )

    val bogathaWaterfalls = Destination(
        id = "telangana-bogatha",
        name = "Bogatha Waterfalls",
        state = "Telangana",
        district = "Mulugu",
        mandal = "Wazeedu",
        latitude = 18.5367,
        longitude = 80.4908,
        tagline = "The 'Niagara of Telangana' Amidst Dense Teak Forests",
        description = "One of Telangana's most magnificent roaring waterfalls, cascading 30 feet across a wide rocky ledge on the Cheekupally Vagu stream in dense Eastern Ghats forest.",
        bestDurationMinDays = 1,
        bestDurationMaxDays = 2,
        altitude = "150 m MSL",
        destinationTypes = listOf("Waterfalls", "Nature", "Adventure", "Monsoon"),
        bestMonths = "July to November",
        recommendedFor = listOf("Youth", "Friends", "Adventure Seekers", "Photographers"),
        rating = 4.6f,
        reviewCount = 6100,
        categories = listOf(TravelCategory.WATERFALLS, TravelCategory.NATURE, TravelCategory.ADVENTURE),
        bestTime = BestTimeInfo(
            bestMonths = "July to November",
            weatherSummary = "Peak roaring waterfall flow during monsoon, pleasant pool bathing till winter",
            peakSeason = "August – October",
            offSeason = "March – May (Dry summer trickle)",
            expectedCrowd = "High on monsoon weekends",
            temperatureRange = "22°C – 33°C",
            suggestedDuration = "1 Day"
        ),
        attractions = listOf(
            Attraction(
                id = "bgt-falls",
                destinationId = "telangana-bogatha",
                name = "Bogatha Cascades & Forest Pool",
                description = "Wide curtain cascade plunging into a natural pool surrounded by rock boulders, lush greenery, and watchtowers developed by the Forest Department.",
                category = "Waterfall",
                openingTime = "09:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "₹30",
                entryFeeChild = "₹15",
                recommendedDurationMinutes = 180,
                parkingAvailable = true,
                parkingFee = "₹50",
                difficultyLevel = "Easy to Moderate (Short paved forest path from parking)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "10:30 AM to 03:00 PM",
                tips = "Swimming is allowed only in designated safe zones monitored by forest guards. Carry extra change of clothes."
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Hyderabad" to 325, "Warangal" to 135, "Bhadrachalam" to 120, "Eturnagaram" to 30),
            drivingTimes = mapOf("Hyderabad" to "6h 30m", "Warangal" to "2h 45m", "Bhadrachalam" to "2h 30m", "Eturnagaram" to "35m"),
            roadTripRoute = "Warangal -> Mulugu -> Pasra -> Eturnagaram (NH163) -> Wazeedu -> Bogatha Falls.",
            tollAndParkingNotes = "Forest toll ₹50; scenic drive through Eturnagaram reserve forest.",
            nearestRailwayStation = "Bhadrachalam Road / Kothagudem (130 km) or Warangal (135 km)",
            nearestAirport = "Hyderabad RGI Airport (345 km)",
            busTrainFlightOptions = "Buses run from Hanamkonda to Wazeedu/Venkatapuram. Private cabs recommended."
        )
    )

    val kuntalaWaterfalls = Destination(
        id = "telangana-kuntala",
        name = "Kuntala Waterfalls",
        state = "Telangana",
        district = "Adilabad",
        mandal = "Neradigonda",
        latitude = 19.3087,
        longitude = 78.4842,
        tagline = "Telangana's Highest Waterfall (150 ft Plunge)",
        description = "Highest waterfall in Telangana, cascading 150 feet in two tiers on the Kadam River down deep Sahyadri granite gorges surrounded by dense teak jungle.",
        bestDurationMinDays = 1,
        bestDurationMaxDays = 2,
        altitude = "420 m MSL",
        destinationTypes = listOf("Waterfalls", "Nature", "Adventure", "Trekking"),
        bestMonths = "July to December",
        recommendedFor = listOf("Adventure Seekers", "Trekkers", "Youth", "Couples"),
        rating = 4.6f,
        reviewCount = 5200,
        categories = listOf(TravelCategory.WATERFALLS, TravelCategory.NATURE, TravelCategory.ADVENTURE),
        attractions = listOf(
            Attraction(
                id = "ktl-falls",
                destinationId = "telangana-kuntala",
                name = "Kuntala 150-foot Canyon Plunge",
                description = "Breathtaking two-tier waterfall roaring down rock cliffs. Accessed via 400 stone steps descending through deciduous mountain forest.",
                category = "Waterfall",
                openingTime = "08:30 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "₹30",
                entryFeeChild = "₹15",
                recommendedDurationMinutes = 180,
                parkingAvailable = true,
                parkingFee = "₹50",
                difficultyLevel = "Moderate to Strenuous (400 stone steps to descend and climb back)",
                familyFriendly = true,
                childrenFriendly = false,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 09:30 AM to 01:00 PM",
                tips = "Climbing back up the 400 steps requires moderate stamina. Carry drinking water and wear good grip shoes."
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Hyderabad" to 260, "Nirmal" to 42, "Adilabad" to 58),
            drivingTimes = mapOf("Hyderabad" to "4h 45m", "Nirmal" to "50m", "Adilabad" to "1h 15m"),
            roadTripRoute = "Hyderabad -> NH44 north past Medchal, Kamareddy, Armoor, Nirmal -> Neradigonda (turn off to Kuntala 12 km).",
            tollAndParkingNotes = "NH44 smooth 4-lane expressway with ~₹280 tolls.",
            nearestRailwayStation = "Adilabad (58 km) / Mancherial (95 km)",
            nearestAirport = "Hyderabad RGI Airport (280 km) / Nagpur (250 km)",
            busTrainFlightOptions = "Frequent TSRTC buses to Nirmal/Neradigonda on NH44; local jeeps and autos to falls."
        )
    )

    val pocheraWaterfalls = Destination(
        id = "telangana-pochera",
        name = "Pochera Waterfalls",
        state = "Telangana",
        district = "Adilabad",
        mandal = "Boath",
        latitude = 19.3361,
        longitude = 78.4069,
        tagline = "Picturesque Step-Cascade Canyon on Godavari Tributary",
        description = "Charming step-waterfall where the Godavari tributary stream falls 20 meters over a wide bed of hard granite rock terraces before narrowing into a deep rock gorge.",
        bestDurationMinDays = 1,
        bestDurationMaxDays = 1,
        altitude = "380 m MSL",
        destinationTypes = listOf("Waterfalls", "Nature", "Picnic"),
        bestMonths = "August to January",
        recommendedFor = listOf("Family", "Couples", "Picnickers", "Road Trippers"),
        rating = 4.5f,
        reviewCount = 3700,
        categories = listOf(TravelCategory.WATERFALLS, TravelCategory.NATURE, TravelCategory.FAMILY),
        attractions = listOf(
            Attraction(
                id = "pcr-falls",
                destinationId = "telangana-pochera",
                name = "Pochera Granite Terraces & Gorge",
                description = "Scenic amphitheater of stepped granite rock shelves where cool water cascades before rushing through a narrow rocky canyon.",
                category = "Waterfall",
                openingTime = "09:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "₹20",
                entryFeeChild = "₹10",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy (Gentle slope from parking, much easier access than Kuntala)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Late morning or sunset",
                tips = "Easily combined with Kuntala on the same day trip since they are only 15 km apart."
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Hyderabad" to 255, "Nirmal" to 38, "Kuntala Falls" to 15),
            drivingTimes = mapOf("Hyderabad" to "4h 30m", "Nirmal" to "45m", "Kuntala Falls" to "25m"),
            roadTripRoute = "NH44 north past Nirmal to Boath crossroad -> 6 km paved forest road to Pochera.",
            tollAndParkingNotes = "Part of NH44 corridor.",
            nearestRailwayStation = "Adilabad (50 km)",
            nearestAirport = "Hyderabad RGI Airport (275 km)",
            busTrainFlightOptions = "Buses to Boath / Neradigonda on NH44."
        )
    )

    val singur = Destination(
        id = "telangana-singur",
        name = "Singur Dam & Crocodile Sanctuary",
        state = "Telangana",
        district = "Sangareddy",
        mandal = "Pulkal",
        latitude = 17.7547,
        longitude = 77.9250,
        tagline = "Deep Water Manjeera Reservoir & Mugger Crocodile Sanctuary",
        description = "Massive irrigation and drinking water reservoir on the Manjeera River with a live storage capacity of nearly 30 TMC, famed as a protected sanctuary for freshwater mugger crocodiles and water birds.",
        bestDurationMinDays = 1,
        bestDurationMaxDays = 1,
        altitude = "523 m MSL",
        destinationTypes = listOf("Lakes", "Dam", "Wildlife", "Day Trip"),
        bestMonths = "October to March",
        recommendedFor = listOf("Family", "Bird Watchers", "Day Trippers"),
        rating = 4.3f,
        reviewCount = 2200,
        categories = listOf(TravelCategory.LAKES, TravelCategory.WILDLIFE, TravelCategory.ROAD_TRIPS),
        attractions = listOf(
            Attraction(
                id = "sng-reservoir",
                destinationId = "telangana-singur",
                name = "Singur Dam Spillway & Crocodile Watch",
                description = "Expansive dam crest with views of open reservoir waters where mugger crocodiles bask on sandy islets during sunny winter mornings.",
                category = "Dam & Wildlife",
                openingTime = "09:00 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "₹20",
                entryFeeChild = "₹10",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 10:00 AM for crocodile basking",
                tips = "Watch from the elevated viewpoint; maintain distance from the water's edge."
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Hyderabad" to 85, "Sangareddy" to 32),
            drivingTimes = mapOf("Hyderabad" to "1h 45m", "Sangareddy" to "40m"),
            roadTripRoute = "Hyderabad (Miyapur / Patancheru) -> NH65 to Sangareddy -> Jogipet road to Singur.",
            tollAndParkingNotes = "NH65 toll at Patancheru ~₹75.",
            nearestRailwayStation = "Sangareddy / Lingampalli (65 km)",
            nearestAirport = "Hyderabad RGI Airport (100 km)",
            busTrainFlightOptions = "Buses from Sangareddy bus station connect to Pulkal and Jogipet."
        )
    )

    val nagarjunaSagar = Destination(
        id = "telangana-nagarjunasagar",
        name = "Nagarjuna Sagar",
        state = "Telangana",
        district = "Nalgonda",
        mandal = "Nidigonda / Vijayapuri",
        latitude = 16.5742,
        longitude = 79.3144,
        tagline = "World's Tallest Masonry Dam & Island Buddhist Museum",
        description = "Engineering triumph on the mighty Krishna River holding 26 crest gates, home to Nagarjunakonda Island Museum accessible by passenger launch, displaying priceless 2nd-century Mahayana Buddhist relics.",
        bestDurationMinDays = 1,
        bestDurationMaxDays = 2,
        altitude = "180 m MSL",
        destinationTypes = listOf("Lakes", "Dam", "Buddhist Heritage", "Boating"),
        bestMonths = "August to February",
        recommendedFor = listOf("Family", "Couples", "History Lovers", "Students"),
        rating = 4.7f,
        reviewCount = 9800,
        categories = listOf(TravelCategory.LAKES, TravelCategory.HERITAGE, TravelCategory.FAMILY, TravelCategory.ROAD_TRIPS),
        attractions = listOf(
            Attraction(
                id = "ngs-museum-island",
                destinationId = "telangana-nagarjunasagar",
                name = "Nagarjunakonda Buddhist Island Museum",
                description = "Island museum in the center of the vast reservoir housing excavated stupas, sculptures, and inscriptions of Acharya Nagarjuna's 2nd-century Buddhist university.",
                category = "Island Museum",
                openingTime = "09:30 AM",
                closingTime = "04:30 PM (Closed Fridays)",
                entryFeeAdult = "Launch ₹150 + Museum ₹20",
                entryFeeChild = "Launch ₹100 + Museum ₹10",
                recommendedDurationMinutes = 240,
                parkingAvailable = true,
                parkingFee = "₹40 at Launch Station",
                difficultyLevel = "Easy (45-minute scenic ferry ride each way)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Catch the 10:00 AM or 11:30 AM ferry launch",
                tips = "Carry caps or umbrellas for the island walk; ferry schedule depends on water level."
            ),
            Attraction(
                id = "ngs-dam-view",
                destinationId = "telangana-nagarjunasagar",
                name = "Nagarjuna Sagar Dam Viewpoint",
                description = "Spectacular panoramic viewpoint of the 124-meter tall stone masonry dam, power house, and churning emerald Krishna gorge.",
                category = "Dam Viewpoint",
                openingTime = "08:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "Free",
                entryFeeChild = "Free",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Late afternoon 04:30 PM",
                tips = "During peak flood releases, all 26 gates opening creates an awe-inspiring mist plume visible kilometers away."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-ngs-vijaya-vihar",
                destinationId = "telangana-nagarjunasagar",
                name = "Haritha Vijay Vihar, Nagarjuna Sagar",
                category = "Government Tourism",
                minimumPrice = 2200,
                maximumPrice = 3800,
                rating = 4.2f,
                reviewCount = 1890,
                amenities = listOf("Panoramic Dam Views", "Swimming Pool", "Restaurant", "Gardens"),
                approximatePrice = "Approx. ₹2,400 / night (verify before travel)",
                phone = "+91 8680 277 362",
                website = "https://tourism.telangana.gov.in",
                lastVerifiedDate = "2024-2025"
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Hyderabad" to 150, "Nalgonda" to 72, "Vijayawada" to 195),
            drivingTimes = mapOf("Hyderabad" to "3h 0m", "Nalgonda" to "1h 30m", "Vijayawada" to "3h 45m"),
            roadTripRoute = "Hyderabad (LB Nagar) -> Nagarjuna Sagar Highway (SH19 / 4-lane smooth highway) via Ibrahimpatnam and Mall to Vijayapuri.",
            tollAndParkingNotes = "State highway toll ~₹80.",
            nearestRailwayStation = "Macherla (24 km) / Miryalaguda (65 km)",
            nearestAirport = "Hyderabad RGI Airport (145 km)",
            busTrainFlightOptions = "Regular direct TSRTC buses operate from Hyderabad MGBS to Nagarjuna Sagar."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2200,
            foodEstimatePerDay = 900,
            activitiesTotal = 500,
            travelEstimate = 1900,
            totalEstimateMin = 5500,
            totalEstimateMax = 11000
        )
    )

    val allLakesWaterfallsDestinations = listOf(
        laknavaram,
        pakhalLake,
        bogathaWaterfalls,
        kuntalaWaterfalls,
        pocheraWaterfalls,
        singur,
        nagarjunaSagar
    )
}
