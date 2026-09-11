package com.example.data.datasource.karnataka

import com.example.data.datasource.common.RegionalSeasonalHelper
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

object KarnatakaChikkamagaluruNatureData {

    val chikkamagaluru = Destination(
        id = "karnataka-chikkamagaluru",
        name = "Chikkamagaluru",
        state = "Karnataka",
        district = "Chikkamagaluru",
        tagline = "The Birthplace of Indian Coffee & Majestic Western Ghats",
        description = "Where Baba Budan first planted seven sacred coffee beans in the 17th century, Chikkamagaluru is a lush highland realm of verdant estates, babbling mountain brooks, dramatic peaks, and colonial homestays.",
        rating = 4.8f,
        reviewCount = 16200,
        coverResId = null,
        categories = listOf(TravelCategory.MOUNTAINS, TravelCategory.COUPLES, TravelCategory.NATURE, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "September – March",
            weatherSummary = "Crisp hill station weather, morning blankets of mist, white coffee blossoms in March",
            peakSeason = "October – February",
            offSeason = "June – August (Vigorous southwest monsoon)",
            expectedCrowd = "High",
            temperatureRange = "14°C – 27°C",
            suggestedDuration = "3–4 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-chikkamagaluru"),
        attractions = listOf(
            Attraction(
                id = "ckm-mullayanagiri",
                destinationId = "karnataka-chikkamagaluru",
                name = "Mullayanagiri Peak",
                description = "The highest summit in Karnataka at 1,930 meters (6,330 feet), offering panoramic vistas across the Western Ghats with a small Shiva shrine at the top.",
                category = "Mountain Summit",
                openingTime = "06:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹50",
                difficultyLevel = "Moderate (450 steps from parking to summit)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "06:30 AM for cloud sea or 04:30 PM for sunset",
                tips = "Narrow ghat road; drive carefully. The summit is often engulfed in dramatic sweeping mist."
            ),
            Attraction(
                id = "ckm-baba-budangiri",
                destinationId = "karnataka-chikkamagaluru",
                name = "Baba Budangiri (Chandra Drona Range)",
                description = "Sacred crescent-shaped mountain range housing the revered shrine of Sufi saint Baba Budan and Guru Dattatreya inside an ancient cave.",
                category = "Spiritual & Mountains",
                openingTime = "08:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                difficultyLevel = "Easy to Moderate",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning hours",
                tips = "Visit Manikyadhara waterfall just 3 km further along the ridge."
            ),
            Attraction(
                id = "ckm-jhari-falls",
                destinationId = "karnataka-chikkamagaluru",
                name = "Jhari Falls (Buttermilk Falls)",
                description = "Picturesque natural cascade plunging into a refreshing forest pool, accessible via a rugged 4x4 off-road jeep track through private coffee estates.",
                category = "Waterfalls",
                openingTime = "08:30 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "Jeep ride ₹700 – ₹900 per vehicle (up to 6 people)",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                difficultyLevel = "Moderate",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "10:30 AM",
                tips = "Private vehicles must be parked at the main road checkpost; hire local 4x4 jeeps for the steep descent."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-ckm-serai",
                destinationId = "karnataka-chikkamagaluru",
                name = "The Serai Chikmagalur",
                category = "Luxury Private Pool Resort",
                minimumPrice = 21000,
                maximumPrice = 42000,
                rating = 4.8f,
                reviewCount = 2600,
                amenities = listOf("Private Pool Villas inside Coffee Plantation", "Oma Spa", "Coffee Tasting Session", "Fine Dining"),
                approximatePrice = "Approx. ₹24,000 / night (verify before travel)",
                phone = "+91 8262 224 903",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-ckm-trivik",
                destinationId = "karnataka-chikkamagaluru",
                name = "Trivik Hotels & Resorts",
                category = "Luxury Mountain View Resort",
                minimumPrice = 16000,
                maximumPrice = 32000,
                rating = 4.9f,
                reviewCount = 1800,
                amenities = listOf("Panoramic Valley Suites", "Infinity Pool", "Bonfire", "Plantation Tour"),
                approximatePrice = "Approx. ₹18,500 / night (verify before travel)",
                phone = "+91 8262 258 777",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Malnad Akki Rotti with Kaalu Huli",
                    isVegetarian = true,
                    description = "Soft, fragrant rice flour flatbread speckled with fresh coriander and grated coconut, accompanied by mixed sprout and lentil curry.",
                    popularAt = "Town Canteen (Chikkamagaluru), estate homestays"
                ),
                FoodItem(
                    name = "Estate Arabica Coffee with Cardamom",
                    isVegetarian = true,
                    description = "Freshly brewed single-origin shade-grown Arabica coffee with creamy frothed milk.",
                    popularAt = "Coffee Yatra Museum Cafe & MG Road coffee houses"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Town Canteen",
                    cuisine = "Iconic Malnad Tiffin",
                    rating = 4.6f,
                    isVegFriendly = true,
                    signatureDish = "Crispy Benne Masala Dosa & Gulab Jamun",
                    priceForTwo = "₹200",
                    distance = "Ratnagiri Road"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Hyderabad" to 650, "Bengaluru" to 242, "Chennai" to 585, "Mumbai" to 870,
                "Pune" to 730, "Delhi" to 2260, "Kolkata" to 2060, "Visakhapatnam" to 1230,
                "Vijayawada" to 880, "Kochi" to 460, "Coimbatore" to 345, "Madurai" to 490
            ),
            drivingTimes = mapOf(
                "Bengaluru" to "4h 15m via Hassan NH75", "Hyderabad" to "11h 30m", "Mangaluru" to "3h 15m"
            ),
            roadTripRoute = "NH75 from Bengaluru via Kunigal, Channarayapatna, and Hassan, then SH57 to Chikkamagaluru.",
            tollAndParkingNotes = "Excellent 4-lane expressway till Hassan. Scenic two-lane tree-lined state highway from Hassan to Chikkamagaluru.",
            nearestRailwayStation = "Chikkamagaluru (CKM) / Kadur Junction (40 km) / Hassan (60 km)",
            nearestAirport = "Mangaluru International Airport (IXE - 150 km) / Bengaluru (260 km)",
            busTrainFlightOptions = "Direct KSRTC non-stop buses run every hour from Satellite Bus Station, Bengaluru."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3800,
            foodEstimatePerDay = 1200,
            activitiesTotal = 1200,
            travelEstimate = 2000,
            totalEstimateMin = 12000,
            totalEstimateMax = 32000
        )
    )

    val mullayanagiri = Destination(
        id = "karnataka-mullayanagiri",
        name = "Mullayanagiri",
        state = "Karnataka",
        district = "Chikkamagaluru",
        tagline = "The Crown of Karnataka at 1,930 Meters",
        description = "As Karnataka's highest peak, Mullayanagiri provides awe-inspiring views of undulating ridges, blanketed in cloud formations, with historic trekking trails extending towards Bababudangiri.",
        rating = 4.8f,
        reviewCount = 8900,
        coverResId = null,
        categories = listOf(TravelCategory.MOUNTAINS, TravelCategory.ADVENTURE, TravelCategory.NATURE),
        bestTime = BestTimeInfo(
            bestMonths = "September – March",
            weatherSummary = "Brisk chilly winds, breathtaking clear vistas after sunrise",
            peakSeason = "November – February",
            offSeason = "June – August (Gale winds and slippery wet rocks)",
            expectedCrowd = "High",
            temperatureRange = "10°C – 22°C",
            suggestedDuration = "1 Day"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-mullayanagiri"),
        attractions = listOf(
            Attraction(
                id = "mullayanagiri-summit-trail",
                destinationId = "karnataka-mullayanagiri",
                name = "Mullayanagiri Temple & Ridge Trek",
                description = "Ascent to the historic sage Mullappa Swamy shrine perched on the precipice, marking Karnataka's highest geographical elevation.",
                category = "High Altitude Trek",
                openingTime = "06:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 150,
                parkingAvailable = true,
                parkingFee = "₹50",
                difficultyLevel = "Moderate",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "06:30 AM",
                tips = "Carry windproof jackets; winds can be strong enough to challenge balance."
            )
        ),
        stays = emptyList(),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Hot Ginger Tea & Steamed Corn",
                    isVegetarian = true,
                    description = "Freshly roasted hill corn cobs seasoned with lemon and chilli, paired with hot spiced tea.",
                    popularAt = "Stalls at base parking lot"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Chikkamagaluru" to 22, "Bengaluru" to 265, "Hyderabad" to 670),
            drivingTimes = mapOf("Chikkamagaluru" to "45m", "Bengaluru" to "5h 0m"),
            roadTripRoute = "From Chikkamagaluru town via Kaimara checkpost ascending the steep ghat road.",
            tollAndParkingNotes = "Forest checkpost fee at Kaimara (~₹20). Single-lane ghat with designated passing bays.",
            nearestRailwayStation = "Chikkamagaluru (25 km)",
            nearestAirport = "Mangaluru (165 km)",
            busTrainFlightOptions = "Best reached by taxi or personal car from Chikkamagaluru town."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3500,
            foodEstimatePerDay = 800,
            activitiesTotal = 300,
            travelEstimate = 1200,
            totalEstimateMin = 3500,
            totalEstimateMax = 8000
        )
    )

    val kemmanagundi = Destination(
        id = "karnataka-kemmanagundi",
        name = "Kemmanagundi",
        state = "Karnataka",
        district = "Chikkamagaluru",
        tagline = "The Royal Hill Station of the Mysore Kings",
        description = "Nestled at 1,434 meters amidst the Baba Budan range, Kemmanagundi served as the summer retreat for Maharaja Krishnaraja Wodeyar IV, renowned for manicured royal rose gardens, Z-point sunset edge, and Hebbe Falls.",
        rating = 4.6f,
        reviewCount = 5200,
        coverResId = null,
        categories = listOf(TravelCategory.MOUNTAINS, TravelCategory.NATURE, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "September – March",
            weatherSummary = "Refreshing cool breezes, lush flowering gardens, misty morning valleys",
            peakSeason = "October – February",
            offSeason = "July – August",
            expectedCrowd = "Moderate",
            temperatureRange = "14°C – 26°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-kemmanagundi"),
        attractions = listOf(
            Attraction(
                id = "kemmana-z-point",
                destinationId = "karnataka-kemmanagundi",
                name = "Z Point Trek & Valley Overlook",
                description = "Thrilling 3 km ridge walk along narrow cliff pathways overlooking deep emerald Western Ghat valleys, with refreshing mountain winds.",
                category = "Trek & Viewpoint",
                openingTime = "06:00 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                difficultyLevel = "Moderate (Narrow cliff trail)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Sunset 05:00 PM",
                tips = "Watch your step along the edge; breathtaking views of the Shanti Falls along the trail."
            ),
            Attraction(
                id = "kemmana-raj-bhavan",
                destinationId = "karnataka-kemmanagundi",
                name = "Raj Bhavan Horticultural Rose Gardens",
                description = "Terraced ornamental gardens laid out with hundreds of rose varieties, exotic flowering shrubs, and sunset pavilions built for the royal family.",
                category = "Gardens & Heritage",
                openingTime = "08:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "₹20",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 09:30 AM",
                tips = "Delightful spot for family strolls and photography."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-kemmana-horticulture",
                destinationId = "karnataka-kemmanagundi",
                name = "Horticulture Department Guest House",
                category = "Government Heritage Hilltop Stay",
                minimumPrice = 1800,
                maximumPrice = 3200,
                rating = 3.9f,
                reviewCount = 420,
                amenities = listOf("Direct Access to Royal Gardens", "Canteen", "Valley Views"),
                approximatePrice = "Approx. ₹2,200 / night (verify before travel)",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Malnad Bisi Oota",
                    isVegetarian = true,
                    description = "Freshly cooked steaming rice, saaru, buttermilk, and vegetable palya.",
                    popularAt = "Kemmanagundi hilltop canteen"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Chikkamagaluru" to 55, "Bengaluru" to 255, "Shivamogga" to 68),
            drivingTimes = mapOf("Chikkamagaluru" to "1h 45m", "Bengaluru" to "5h 15m"),
            roadTripRoute = "From Bengaluru via Tumakuru, Arsikere, and Tarikere, then taking the Lingadahalli ghat road.",
            tollAndParkingNotes = "Ghat road is narrow with winding bends through forest reserves.",
            nearestRailwayStation = "Tarikere Junction (35 km) / Birur (40 km)",
            nearestAirport = "Mangaluru (190 km) / Bengaluru (275 km)",
            busTrainFlightOptions = "KSRTC buses run from Tarikere and Chikkamagaluru to Kemmanagundi."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 800,
            activitiesTotal = 400,
            travelEstimate = 1600,
            totalEstimateMin = 5500,
            totalEstimateMax = 12000
        )
    )

    val hebbeFalls = Destination(
        id = "karnataka-hebbe-falls",
        name = "Hebbe Falls",
        state = "Karnataka",
        district = "Chikkamagaluru",
        tagline = "The Two-Tiered Medicinal Forest Cascade",
        description = "Hidden inside dense coffee plantations near Kemmanagundi, Hebbe Falls crashes down 168 meters in two stages—Dodda Hebbe and Chikka Hebbe—fed by mountain springs believed to possess herbal medicinal properties.",
        rating = 4.7f,
        reviewCount = 4700,
        coverResId = null,
        categories = listOf(TravelCategory.WATERFALLS, TravelCategory.ADVENTURE, TravelCategory.NATURE),
        bestTime = BestTimeInfo(
            bestMonths = "September – February",
            weatherSummary = "High water volume, scenic greenery, invigorating forest pools",
            peakSeason = "October – January",
            offSeason = "June – July (Heavy flood currents)",
            expectedCrowd = "Moderate",
            temperatureRange = "16°C – 26°C",
            suggestedDuration = "1 Day"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-hebbe-falls"),
        attractions = listOf(
            Attraction(
                id = "hebbe-falls-trek",
                destinationId = "karnataka-hebbe-falls",
                name = "Hebbe Falls Off-Road Jeep Safari & Trek",
                description = "Exciting 4x4 rugged safari through private coffee estates crossing mountain streams, followed by a 1 km forest walk to the pool under the roaring fall.",
                category = "Waterfalls",
                openingTime = "06:00 AM",
                closingTime = "04:00 PM",
                entryFeeAdult = "Forest Jeep ₹500 – ₹700 per person",
                recommendedDurationMinutes = 180,
                parkingAvailable = true,
                difficultyLevel = "Moderate to Challenging (Bumpy jeep ride and river boulder walk)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "10:00 AM – 01:00 PM",
                tips = "Carry a change of dry clothes. Leeches can be present during post-monsoon months; carry salt or tobacco powder."
            )
        ),
        stays = emptyList(),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Hot Maggi & Black Coffee",
                    isVegetarian = true,
                    description = "Steaming noodles and fresh estate coffee after a cold dip.",
                    popularAt = "Jeep parking food sheds"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Kemmanagundi" to 10, "Chikkamagaluru" to 65, "Bengaluru" to 265),
            drivingTimes = mapOf("Kemmanagundi" to "30m", "Bengaluru" to "5h 30m"),
            roadTripRoute = "From Kemmanagundi base via authorized Forest Department 4x4 jeeps.",
            tollAndParkingNotes = "Private cars are not permitted on the rough estate trail beyond the checkpost.",
            nearestRailwayStation = "Tarikere (42 km)",
            nearestAirport = "Mangaluru (195 km)",
            busTrainFlightOptions = "Drive to Kemmanagundi and board the local 4x4 forest transfer."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 600,
            activitiesTotal = 700,
            travelEstimate = 1200,
            totalEstimateMin = 3500,
            totalEstimateMax = 7500
        )
    )

    val bhadraSanctuary = Destination(
        id = "karnataka-bhadra-wildlife",
        name = "Bhadra Wildlife Sanctuary",
        state = "Karnataka",
        district = "Chikkamagaluru & Shivamogga",
        tagline = "The Tiger Reserve of Muthodi & River Bhadra",
        description = "Covering 490 sq km across the Western Ghats, Bhadra Tiger Reserve features moist deciduous forests, bamboo groves, and the shimmering backwaters of Bhadra reservoir, teeming with tigers, leopards, and over 300 bird species.",
        rating = 4.6f,
        reviewCount = 3800,
        coverResId = null,
        categories = listOf(TravelCategory.WILDLIFE, TravelCategory.ADVENTURE, TravelCategory.NATURE),
        bestTime = BestTimeInfo(
            bestMonths = "October – May",
            weatherSummary = "Cool post-monsoon greenery (Oct-Feb); March-May ideal for predator sightings at waterholes",
            peakSeason = "November – March",
            offSeason = "June – August",
            expectedCrowd = "Moderate",
            temperatureRange = "17°C – 32°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-bhadra-wildlife"),
        attractions = listOf(
            Attraction(
                id = "bhadra-muthodi-safari",
                destinationId = "karnataka-bhadra-wildlife",
                name = "Muthodi Jeep Safari",
                description = "Forest Department jeep safari through dense teak canopy and riparian corridors tracking tigers, gaur (Indian bison), Malabar giant squirrels, and king cobras.",
                category = "Wildlife Safari",
                openingTime = "06:30 AM – 08:30 AM & 04:00 PM – 06:00 PM",
                closingTime = "06:00 PM",
                entryFeeAdult = "₹500 (Canter) / ₹2,000 (Gypsy)",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "06:30 AM early morning safari",
                tips = "Pre-booking through Jungle Lodges River Tern Lodge ensures prime boat and jeep safari slots."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-bhadra-river-tern",
                destinationId = "karnataka-bhadra-wildlife",
                name = "River Tern Lodge (Jungle Lodges & Resorts)",
                category = "Premier Wildlife Island Resort",
                minimumPrice = 9000,
                maximumPrice = 18000,
                rating = 4.8f,
                reviewCount = 1900,
                amenities = listOf("Water Cottages on Reservoir", "Boat Safari", "Kayaking", "All-Inclusive Dining"),
                approximatePrice = "Approx. ₹11,000 / person (all-inclusive)",
                website = "https://junglelodges.com",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Malnad Fish Curry & Neer Dosa",
                    isVegetarian = false,
                    description = "Catch of freshwater fish cooked in coconut milk, green chillies, and ginger, paired with paper-thin rice dosas.",
                    popularAt = "River Tern Lodge dining deck"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Bengaluru" to 280, "Chikkamagaluru" to 32, "Shivamogga" to 42),
            drivingTimes = mapOf("Bengaluru" to "5h 15m", "Chikkamagaluru" to "1h 0m"),
            roadTripRoute = "From Tarikere towards Lakkavalli dam or from Chikkamagaluru to Muthodi camp.",
            tollAndParkingNotes = "Quiet forest approach roads; keep headlights dim and do not honk.",
            nearestRailwayStation = "Tarikere (20 km) / Birur (35 km)",
            nearestAirport = "Mangaluru (175 km) / Bengaluru (290 km)",
            busTrainFlightOptions = "Drive from Bengaluru via NH48/NH206 to Tarikere then Lakkavalli."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 7500,
            foodEstimatePerDay = 1500,
            activitiesTotal = 2200,
            travelEstimate = 2200,
            totalEstimateMin = 18000,
            totalEstimateMax = 42000
        )
    )

    val jogFalls = Destination(
        id = "karnataka-jog-falls",
        name = "Jog Falls",
        state = "Karnataka",
        district = "Shivamogga",
        tagline = "India's Legendary 253-Meter Untiered Waterfall",
        description = "Created by the Sharavathi river dropping dramatically 253 meters (830 feet), Jog Falls is composed of four distinct cascades—Raja (kingly plunge), Roarer (violent burst), Rocket (jetting stream), and Rani (graceful foam sheet).",
        rating = 4.7f,
        reviewCount = 14800,
        coverResId = null,
        categories = listOf(TravelCategory.WATERFALLS, TravelCategory.NATURE, TravelCategory.FAMILY_FRIENDLY, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "July – December",
            weatherSummary = "Monsoon (July-Oct) offers magnificent thunderous roar and massive spray; post-monsoon offers clear skies and rainbows",
            peakSeason = "August – November",
            offSeason = "March – May (Sharavathi river water diverted for hydel power)",
            expectedCrowd = "Very High (Monsoon weekends)",
            temperatureRange = "18°C – 29°C",
            suggestedDuration = "1–2 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-jog-falls"),
        attractions = listOf(
            Attraction(
                id = "jog-falls-viewing-deck",
                destinationId = "karnataka-jog-falls",
                name = "KSTDC Jog Falls Viewpoint & Laser Show",
                description = "Expansive elevated amphitheatre directly facing the canyon where all four cascades merge into a thunderous gorge, complete with evening musical laser projections.",
                category = "Waterfalls & Viewpoint",
                openingTime = "07:00 AM",
                closingTime = "09:00 PM (Laser show 07:30 PM)",
                entryFeeAdult = "₹50 (Indians), ₹200 (Foreigners)",
                entryFeeChild = "₹25",
                recommendedDurationMinutes = 150,
                parkingAvailable = true,
                parkingFee = "₹50",
                difficultyLevel = "Easy (Wheelchair accessible decks)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "09:30 AM for rainbow arcs, or sunset illumination",
                tips = "Steps down to the bottom of the gorge are currently regulated for visitor safety. Best views are from the British Bungalow and KSTDC viewpoint."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-jog-kstdc-mayura",
                destinationId = "karnataka-jog-falls",
                name = "KSTDC Hotel Mayura Gerusoppa Jog Falls",
                category = "Government Valley View Resort",
                minimumPrice = 2800,
                maximumPrice = 5500,
                rating = 4.2f,
                reviewCount = 1600,
                amenities = listOf("Balconies directly facing Jog Falls", "Restaurant", "Gardens"),
                approximatePrice = "Approx. ₹3,400 / night (verify before travel)",
                website = "https://kstdc.co",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Malnad Jackfruit Dosa & Filter Coffee",
                    isVegetarian = true,
                    description = "Crispy dosas made with ripe halasina hannu (jackfruit) puree, served with coconut chutney.",
                    popularAt = "Gerusoppa highway tiffin stalls"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Hyderabad" to 585, "Bengaluru" to 380, "Chennai" to 710, "Mumbai" to 730,
                "Pune" to 590, "Delhi" to 2080, "Kolkata" to 1980, "Visakhapatnam" to 1190,
                "Vijayawada" to 820, "Kochi" to 595, "Coimbatore" to 480, "Madurai" to 620
            ),
            drivingTimes = mapOf(
                "Bengaluru" to "7h 0m via NH48 & Sagara", "Shivamogga" to "2h 15m", "Gokarna" to "2h 30m"
            ),
            roadTripRoute = "From Bengaluru via Tumakuru, Shivamogga, and Sagara on NH206 (Honnavar Road).",
            tollAndParkingNotes = "FASTag tolls on NH48 up to Tumakuru/Chitradurga. Two-lane picturesque highway between Shivamogga and Jog.",
            nearestRailwayStation = "Talaguppa (14 km) / Sagara Jambagaru (30 km)",
            nearestAirport = "Shivamogga Airport (RQY - 110 km) / Hubballi (160 km) / Mangaluru (200 km)",
            busTrainFlightOptions = "Direct overnight express train (Talaguppa Express) runs daily from KSR Bengaluru to Talaguppa, 14 km from Jog Falls."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3200,
            foodEstimatePerDay = 900,
            activitiesTotal = 400,
            travelEstimate = 2200,
            totalEstimateMin = 7500,
            totalEstimateMax = 18000
        )
    )

    val shivamogga = Destination(
        id = "karnataka-shivamogga",
        name = "Shivamogga",
        state = "Karnataka",
        district = "Shivamogga",
        tagline = "The Gateway to Malnad & The Land of Arecanut",
        description = "Bordering the Western Ghats on the banks of Tunga river, Shivamogga is the cultural entry point to Malnad, home to the Sakrebyle Elephant Camp, Tiger & Lion Safari at Tyavarekoppa, and Mandagadde bird sanctuary.",
        rating = 4.5f,
        reviewCount = 6800,
        coverResId = null,
        categories = listOf(TravelCategory.FAMILY_FRIENDLY, TravelCategory.NATURE, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "September – March",
            weatherSummary = "Pleasant greenery, cool river breezes, active elephant bathing",
            peakSeason = "October – January",
            offSeason = "April – May (Summer heats up to 36°C)",
            expectedCrowd = "Moderate",
            temperatureRange = "17°C – 32°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-shivamogga"),
        attractions = listOf(
            Attraction(
                id = "shiva-sakrebyle",
                destinationId = "karnataka-shivamogga",
                name = "Sakrebyle Elephant Camp",
                description = "Forest Department riverfront sanctuary on the Tunga river where travelers observe captive Asian elephants being scrubbed, fed, and trained by expert mahouts.",
                category = "Wildlife & Conservation",
                openingTime = "08:30 AM – 11:30 AM",
                closingTime = "11:30 AM",
                entryFeeAdult = "₹50 (Indians), ₹200 (Foreigners)",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 08:30 AM for river bathing",
                tips = "Camp closes strictly by 11:30 AM when elephants are led into the deep jungle for free grazing."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-shiva-royal-orchid",
                destinationId = "karnataka-shivamogga",
                name = "Royal Orchid Central",
                category = "Upscale City Hotel",
                minimumPrice = 3600,
                maximumPrice = 6500,
                rating = 4.4f,
                reviewCount = 1800,
                amenities = listOf("Central AC", "Multi-cuisine Restaurant", "Fitness Centre"),
                approximatePrice = "Approx. ₹4,200 / night (verify before travel)",
                phone = "+91 8182 401 999",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Shimoga Halasina Hannu Idli (Jackfruit Idli)",
                    isVegetarian = true,
                    description = "Steamed rice cakes cooked inside aromatic teak leaves with sweet jackfruit flesh and pure ghee.",
                    popularAt = "Meenakshi Bhavan (Gandhi Bazaar)"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Bengaluru" to 300, "Mysuru" to 250, "Hubballi" to 195, "Hyderabad" to 540),
            drivingTimes = mapOf("Bengaluru" to "5h 30m via NH48 & Arsikere", "Hubballi" to "3h 30m"),
            roadTripRoute = "Via NH48 from Bengaluru to Tumakuru, then NH206 through Tiptur, Arsikere, and Kadur.",
            tollAndParkingNotes = "FASTag tolls on expressway sections; NH206 is a scenic two-lane corridor.",
            nearestRailwayStation = "Shivamogga Town (SMET)",
            nearestAirport = "Shivamogga Kuvempu Airport (RQY - 12 km)",
            busTrainFlightOptions = "Direct Jan Shatabdi and Intercity trains connect KSR Bengaluru to Shivamogga daily in under 5 hours."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2800,
            foodEstimatePerDay = 800,
            activitiesTotal = 400,
            travelEstimate = 1600,
            totalEstimateMin = 6500,
            totalEstimateMax = 15000
        )
    )

    val agumbe = Destination(
        id = "karnataka-agumbe",
        name = "Agumbe",
        state = "Karnataka",
        district = "Shivamogga",
        tagline = "The Cherrapunji of South India & King Cobra Capital",
        description = "Perched at 823 meters in the rainforests of the Western Ghats, Agumbe receives the second highest annual rainfall in India (~7,600 mm). Famous for the Malgudi Days setting (Doddamane), sunset over Arabian Sea, and King Cobra research station.",
        rating = 4.7f,
        reviewCount = 5900,
        coverResId = null,
        categories = listOf(TravelCategory.NATURE, TravelCategory.ADVENTURE, TravelCategory.WATERFALLS),
        bestTime = BestTimeInfo(
            bestMonths = "October – February",
            weatherSummary = "Crisp cool rainforest mist, post-monsoon cascading waterfalls, clear sunset horizons",
            peakSeason = "November – January",
            offSeason = "June – August (Massive monsoon downpours >7,000 mm)",
            expectedCrowd = "Moderate",
            temperatureRange = "16°C – 26°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-agumbe"),
        attractions = listOf(
            Attraction(
                id = "agumbe-sunset-viewpoint",
                destinationId = "karnataka-agumbe",
                name = "Agumbe Sunset Point (Arabian Sea Horizon)",
                description = "Scenic roadside vantage point on the 14th hairpin curve of Agumbe ghat where on clear evenings the sun sets directly into the distant Arabian Sea.",
                category = "Scenic Viewpoint",
                openingTime = "06:00 AM",
                closingTime = "07:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "05:30 PM – 06:30 PM",
                tips = "Carry warm jackets as cool breeze picks up sharply after sunset."
            ),
            Attraction(
                id = "agumbe-barkana-falls",
                destinationId = "karnataka-agumbe",
                name = "Barkana Falls & Onake Abbi Falls",
                description = "Magnificent 260-meter tiered waterfall on the Sita river crashing down deep dense shola valleys, reached through a guided rainforest hike.",
                category = "Waterfalls & Trek",
                openingTime = "08:00 AM",
                closingTime = "04:30 PM",
                entryFeeAdult = "Forest permit ₹200",
                recommendedDurationMinutes = 180,
                parkingAvailable = true,
                difficultyLevel = "Challenging (Rainforest terrain)",
                familyFriendly = false,
                childrenFriendly = false,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Morning with guide",
                tips = "Forest Department permission and an authorized naturalist guide are required. Wear leech socks."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-agumbe-doddamane",
                destinationId = "karnataka-agumbe",
                name = "Doddamane (Malgudi Days Heritage Homestay)",
                category = "150-Year-Old Heritage Homestay",
                minimumPrice = 1200,
                maximumPrice = 2000,
                rating = 4.6f,
                reviewCount = 680,
                amenities = listOf("Traditional Central Courtyard", "Affectionate Malnad Home-Cooked Meals", "Historic Nostalgia"),
                approximatePrice = "Approx. ₹1,500 / person (pay what you like tradition)",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Kashaya (Herbal Immunity Brew)",
                    isVegetarian = true,
                    description = "Traditional herbal tea boiled with coriander seeds, cumin, black pepper, and jaggery in creamy milk.",
                    popularAt = "Doddamane & local roadside tea stalls"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Bengaluru" to 350, "Udupi" to 55, "Shivamogga" to 90, "Mangaluru" to 100),
            drivingTimes = mapOf("Udupi" to "1h 30m via Someshwara Ghat", "Bengaluru" to "7h 0m"),
            roadTripRoute = "From Udupi via Hebri and Someshwara ascending the 14-hairpin Agumbe ghat.",
            tollAndParkingNotes = "Steep winding ghat section with lush canopy; heavy transport vehicles restricted.",
            nearestRailwayStation = "Udupi (55 km)",
            nearestAirport = "Mangaluru International Airport (100 km)",
            busTrainFlightOptions = "KSRTC buses run from Bengaluru and Shivamogga to Thirthahalli and Agumbe."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2000,
            foodEstimatePerDay = 600,
            activitiesTotal = 500,
            travelEstimate = 1800,
            totalEstimateMin = 4800,
            totalEstimateMax = 11000
        )
    )

    val kodachadri = Destination(
        id = "karnataka-kodachadri",
        name = "Kodachadri",
        state = "Karnataka",
        district = "Shivamogga",
        tagline = "The Abode of Clouds & Sarvajna Peetha Peak",
        description = "Rising 1,343 meters above sea level amidst Mookambika Wildlife Sanctuary, Kodachadri is a sacred mountain where Adi Shankaracharya meditated, famed for the stone Sarvajna Peetha, Arasinagundi waterfalls, and thrilling off-road jeep trails.",
        rating = 4.7f,
        reviewCount = 6200,
        coverResId = null,
        categories = listOf(TravelCategory.ADVENTURE, TravelCategory.SPIRITUAL, TravelCategory.MOUNTAINS),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Brisk winds, clear skies, sea-like horizons towards Byndoor coast",
            peakSeason = "November – February",
            offSeason = "June – August (Gale-force monsoon winds)",
            expectedCrowd = "Moderate to High",
            temperatureRange = "13°C – 25°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-kodachadri"),
        attractions = listOf(
            Attraction(
                id = "koda-sarvajna-peetha",
                destinationId = "karnataka-kodachadri",
                name = "Sarvajna Peetha & Shankaracharya Temple",
                description = "Ancient stone meditation cell erected at the mountain peak where Adi Shankaracharya sat in tapasya, overlooking dramatic vertical cliffs and the green canopy below.",
                category = "Spiritual & Mountain Trek",
                openingTime = "06:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "Jeep hire ₹3,000 per vehicle (up to 8 people)",
                recommendedDurationMinutes = 240,
                parkingAvailable = true,
                difficultyLevel = "Challenging (4x4 off-road or 12 km trek)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Sunrise or 04:00 PM",
                tips = "The 4x4 jeep ride from Kollur / Nittur is one of India's roughest and most exhilarating off-road trails."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-koda-nittur-homestay",
                destinationId = "karnataka-kodachadri",
                name = "Simha Farms Kodachadri",
                category = "Eco Farm Homestay",
                minimumPrice = 2200,
                maximumPrice = 4000,
                rating = 4.3f,
                reviewCount = 450,
                amenities = listOf("Plantation Setting", "Campfire", "Homecooked Vegetarian Food"),
                approximatePrice = "Approx. ₹2,500 / night (verify before travel)",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Malnad Tambuli & Rasam",
                    isVegetarian = true,
                    description = "Cooling yogurt dish seasoned with medicinal herbs and curry leaves, followed by black pepper rasam.",
                    popularAt = "Nittur village homestays"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Bengaluru" to 400, "Kollur" to 35, "Shivamogga" to 115, "Mangaluru" to 155),
            drivingTimes = mapOf("Kollur" to "1h 15m", "Bengaluru" to "8h 0m"),
            roadTripRoute = "From Sagara or Hosanagara through Nagara Fort to Nittur base.",
            tollAndParkingNotes = "Jeeps depart from Nittur or Sampekatte; private non-4x4 vehicles strictly cannot ascend.",
            nearestRailwayStation = "Kundapura (50 km) / Byndoor (45 km)",
            nearestAirport = "Mangaluru (155 km)",
            busTrainFlightOptions = "Buses run from Bengaluru and Shimoga to Kollur Mookambika and Nittur."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 700,
            activitiesTotal = 800,
            travelEstimate = 2000,
            totalEstimateMin = 6500,
            totalEstimateMax = 15000
        )
    )

    val sakleshpur = Destination(
        id = "karnataka-sakleshpur",
        name = "Sakleshpur",
        state = "Karnataka",
        district = "Hassan",
        tagline = "The Green Route, Star Fort & Bisle Ghat View",
        description = "Cradled in the Western Ghats at 950 meters, Sakleshpur is renowned for the 8-pointed star-shaped Manjarabad Fort built by Tipu Sultan, the majestic Bisle Ghat panorama overlooking three mountain ranges, and coffee and cardamom plantations.",
        rating = 4.7f,
        reviewCount = 11200,
        coverResId = null,
        categories = listOf(TravelCategory.WEEKEND_GETAWAYS, TravelCategory.MOUNTAINS, TravelCategory.NATURE, TravelCategory.ROAD_TRIPS),
        bestTime = BestTimeInfo(
            bestMonths = "September – March",
            weatherSummary = "Cool breezy climate, post-monsoon emerald slopes, pleasant sunny afternoons",
            peakSeason = "October – February",
            offSeason = "July – August",
            expectedCrowd = "Moderate to High",
            temperatureRange = "15°C – 28°C",
            suggestedDuration = "2–3 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-sakleshpur"),
        attractions = listOf(
            Attraction(
                id = "saklesh-manjarabad-fort",
                destinationId = "karnataka-sakleshpur",
                name = "Manjarabad Fort (Star Fort)",
                description = "Unique 1792 CE eight-pointed star fort designed by French military engineers for Tipu Sultan, perched on a 988-meter hill with underground passages and cross-valley views.",
                category = "Fort & Architecture",
                openingTime = "08:00 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy to Moderate (250 steps up)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 08:30 AM or late afternoon",
                tips = "Aerial drone or wide-angle photography reveals the geometric eight-pointed star rampart."
            ),
            Attraction(
                id = "saklesh-bisle-ghat",
                destinationId = "karnataka-sakleshpur",
                name = "Bisle Ghat Beauty Spot (Viewpoint)",
                description = "One of India's most dramatic panoramic viewpoints overlooking three mountain ranges—Yenikallu Betta, Doddabetta, and Pushpagiri—with deep untouched forest valleys.",
                category = "Scenic Viewpoint",
                openingTime = "06:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "10:00 AM – 03:30 PM when mist clears",
                tips = "Protected glass-railed observation pavilion constructed by the Forest Department."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-saklesh-rosh-resort",
                destinationId = "karnataka-sakleshpur",
                name = "Roshanara Plantation Retreat",
                category = "Heritage Coffee Estate Bungalow",
                minimumPrice = 4500,
                maximumPrice = 8500,
                rating = 4.6f,
                reviewCount = 940,
                amenities = listOf("Century-Old Estate Bungalow", "Stream Treks", "Home-Cooked Malnad Delicacies"),
                approximatePrice = "Approx. ₹5,200 / night (verify before travel)",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Halasina Beejada Palya & Akki Rotti",
                    isVegetarian = true,
                    description = "Tender jackfruit seed curry tempered with mustard and coconut, paired with hot rice rottis.",
                    popularAt = "Plantation homestays"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Bengaluru" to 220, "Hassan" to 40, "Mangaluru" to 130, "Hyderabad" to 670),
            drivingTimes = mapOf("Bengaluru" to "3h 45m via NH75", "Mangaluru" to "3h 0m via Shiradi Ghat"),
            roadTripRoute = "Via NH75 from Bengaluru through Nelamangala, Kunigal, and Hassan directly to Sakleshpur.",
            tollAndParkingNotes = "FASTag tolls on NH75. Shiradi ghat section is fully concreted.",
            nearestRailwayStation = "Sakleshpur (SKLR - 2 km)",
            nearestAirport = "Mangaluru (135 km) / Bengaluru (240 km)",
            busTrainFlightOptions = "Vistadome coach trains run daily on the scenic Bengaluru-Sakleshpur-Mangaluru railway route."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3500,
            foodEstimatePerDay = 1000,
            activitiesTotal = 500,
            travelEstimate = 1600,
            totalEstimateMin = 8500,
            totalEstimateMax = 20000
        )
    )

    val kudremukh = Destination(
        id = "karnataka-kudremukh",
        name = "Kudremukh",
        state = "Karnataka",
        district = "Chikkamagaluru",
        tagline = "The Horse-Faced Peak & Shola Grassland Wilderness",
        description = "Named for its distinctive horse-head-shaped profile at 1,894 meters, Kudremukh is a UNESCO World Heritage biodiversity hotspot featuring vast rolling emerald shola grasslands, deep cloud forests, and protected wildlife.",
        rating = 4.8f,
        reviewCount = 5700,
        coverResId = null,
        categories = listOf(TravelCategory.ADVENTURE, TravelCategory.MOUNTAINS, TravelCategory.NATURE),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Breathtaking green grassland ridges, cool breeze, pristine forest streams",
            peakSeason = "November – February",
            offSeason = "July – August",
            expectedCrowd = "Regulated (50 trekkers per day strictly enforced)",
            temperatureRange = "12°C – 24°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-kudremukh"),
        attractions = listOf(
            Attraction(
                id = "kudre-peak-trek",
                destinationId = "karnataka-kudremukh",
                name = "Kudremukh Peak 20 km Trek",
                description = "Epic 20 km round-trip trek ascending through shola forests, Ontimara (lone tree) ridge, and rolling carpeted mountains to the horse-head summit.",
                category = "Adventure Trekking",
                openingTime = "06:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "₹500 (Forest Department permit with guide)",
                recommendedDurationMinutes = 480,
                parkingAvailable = true,
                difficultyLevel = "Challenging (Strenuous full-day hike)",
                familyFriendly = false,
                childrenFriendly = false,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Start at 06:30 AM sharp",
                tips = "Only 50 trek permits issued per day on myecotrip.com. Camping on the summit is strictly prohibited."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-kudre-base-homestay",
                destinationId = "karnataka-kudremukh",
                name = "Bella Homestay Kudremukh",
                category = "Trekker Base Homestay",
                minimumPrice = 1800,
                maximumPrice = 3000,
                rating = 4.5f,
                reviewCount = 510,
                amenities = listOf("Trek Guide", "Home-Cooked Malnad Meals", "Jeep Pickup"),
                approximatePrice = "Approx. ₹2,000 / person (including all meals)",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Steamed Rice with Halasina Saaru",
                    isVegetarian = true,
                    description = "Hot piping rice served with tender raw jackfruit curry and fresh coconut chutney.",
                    popularAt = "Trekker basecamp homestays at Balagal"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Bengaluru" to 310, "Mangaluru" to 110, "Chikkamagaluru" to 95),
            drivingTimes = mapOf("Mangaluru" to "2h 45m", "Bengaluru" to "6h 30m"),
            roadTripRoute = "From Bengaluru via Hassan, Belur, Mudigere, and Kalasa to Kudremukh forest gate.",
            tollAndParkingNotes = "Forest checkposts enforce time stamps: transit through the park must be completed within 1.5 hours.",
            nearestRailwayStation = "Mangaluru Junction (110 km)",
            nearestAirport = "Mangaluru International Airport (110 km)",
            busTrainFlightOptions = "Buses run from Bengaluru and Mangaluru to Kalasa, from where local jeeps head to Balagal."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 800,
            activitiesTotal = 700,
            travelEstimate = 1800,
            totalEstimateMin = 5800,
            totalEstimateMax = 14000
        )
    )

    val bheemeshwari = Destination(
        id = "karnataka-bheemeshwari",
        name = "Bheemeshwari",
        state = "Karnataka",
        district = "Mandya",
        tagline = "The Cauvery Eco-Adventure & River Camp",
        description = "Set along the banks of the mighty River Cauvery surrounded by dry deciduous hills, Bheemeshwari is renowned for eco-nature walks, coracle rides, river rafting, zip-lining, and wildlife spotting.",
        rating = 4.4f,
        reviewCount = 4200,
        coverResId = null,
        categories = listOf(TravelCategory.ADVENTURE, TravelCategory.WEEKEND_GETAWAYS, TravelCategory.FAMILY_FRIENDLY),
        bestTime = BestTimeInfo(
            bestMonths = "September – March",
            weatherSummary = "Brisk river breeze, post-monsoon river volume, active birdlife",
            peakSeason = "October – February",
            offSeason = "April – May (Summer afternoon heat)",
            expectedCrowd = "Moderate",
            temperatureRange = "18°C – 32°C",
            suggestedDuration = "1–2 Days"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("karnataka-bheemeshwari"),
        attractions = listOf(
            Attraction(
                id = "bheema-adventure-camp",
                destinationId = "karnataka-bheemeshwari",
                name = "Bheemeshwari Adventure Camp (Jungle Lodges)",
                description = "Riverside eco-adventure hub featuring rope walks, zip-lining across river rapids, coracle rides, and morning nature walks with naturalists.",
                category = "Adventure & River",
                openingTime = "08:30 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "Day visit ₹1,400 (includes lunch & activities)",
                recommendedDurationMinutes = 240,
                parkingAvailable = true,
                difficultyLevel = "Easy to Moderate",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 09:00 AM",
                tips = "Watch for marsh crocodiles basking on river sandbanks from the safety of coracle boats."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-bheema-camp",
                destinationId = "karnataka-bheemeshwari",
                name = "Jungle Lodges Bheemeshwari Nature Camp",
                category = "Riverside Log Huts & Tented Camp",
                minimumPrice = 4500,
                maximumPrice = 8500,
                rating = 4.3f,
                reviewCount = 980,
                amenities = listOf("Wooden Cottages by the River", "Coracle Safari", "Bonfire", "Buffet Meals"),
                approximatePrice = "Approx. ₹5,500 / person (all-inclusive)",
                website = "https://junglelodges.com",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Riverside Country Buffet",
                    isVegetarian = false,
                    description = "Hearty South Indian buffet with ragi mudde, country chicken saaru, chapati, and payasam.",
                    popularAt = "Gol Ghar at Bheemeshwari Camp"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Bengaluru" to 100, "Mysuru" to 85, "Kanakapura" to 45),
            drivingTimes = mapOf("Bengaluru" to "2h 30m", "Mysuru" to "2h 0m"),
            roadTripRoute = "Via Kanakapura Road (NH948) through Kanakapura and Halagur, then taking the rural road to Muthatti.",
            tollAndParkingNotes = "Minimal toll; scenic countryside road flanked by silk farms and tamarind trees.",
            nearestRailwayStation = "Mandya (50 km) / Bengaluru (100 km)",
            nearestAirport = "Bengaluru Kempegowda (135 km)",
            busTrainFlightOptions = "Drive or hire a cab from Bengaluru or Mysuru."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 4500,
            foodEstimatePerDay = 1000,
            activitiesTotal = 1200,
            travelEstimate = 1200,
            totalEstimateMin = 6500,
            totalEstimateMax = 16000
        )
    )

    val allChikkamagaluruNatureDestinations = listOf(
        chikkamagaluru,
        mullayanagiri,
        kemmanagundi,
        hebbeFalls,
        bhadraSanctuary,
        jogFalls,
        shivamogga,
        agumbe,
        kodachadri,
        sakleshpur,
        kudremukh,
        bheemeshwari
    )
}
