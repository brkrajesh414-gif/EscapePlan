package com.example.data.datasource.maharashtra

import com.example.data.datasource.common.RegionalSeasonalHelper
import com.example.data.model.Accommodation
import com.example.data.model.Attraction
import com.example.data.model.BestTimeInfo
import com.example.data.model.BudgetBreakdown
import com.example.data.model.BudgetTier
import com.example.data.model.DayStop
import com.example.data.model.Destination
import com.example.data.model.DestinationBudget
import com.example.data.model.DiscoveryLevel
import com.example.data.model.FoodGuide
import com.example.data.model.FoodItem
import com.example.data.model.FoodSpecialty
import com.example.data.model.HiddenGem
import com.example.data.model.ItineraryActivity
import com.example.data.model.ItineraryDay
import com.example.data.model.ItineraryTemplate
import com.example.data.model.LocalExperience
import com.example.data.model.Restaurant
import com.example.data.model.RestaurantItem
import com.example.data.model.ScenicRoute
import com.example.data.model.TravelCategory
import com.example.data.model.TravelRoute
import com.example.data.model.TravelRouteInfo
import com.example.data.model.VerificationLevel

object MaharashtraDestinationsData {

    val devkundWaterfall = Destination(
        id = "maharashtra-devkund",
        name = "Devkund Waterfall",
        state = "Maharashtra",
        stateCode = "MH",
        district = "Raigad",
        taluk = "Mangaon",
        village = "Bhira",
        latitude = 18.5204,
        longitude = 73.4356,
        tagline = "The mythical plunge pool hidden deep within the Tamhini Ghat rainforest",
        description = "Devkund ('Bathing Pond of Gods') is a breathtaking plunge waterfall nestled inside the dense, pristine forests of Tamhini Ghat near Bhira village. Three cascading mountain streams converge into a deep turquoise natural pool surrounded by sheer volcanic rock walls. It requires a 6.5 km scenic jungle trek crossing streams and rocky riverbeds.",
        shortDescription = "Mystic emerald pool waterfall hidden in the Sahyadri Tamhini forest",
        fullDescription = "Devkund Waterfall is one of Maharashtra's finest natural wonders and a quintessential hidden gem. Revered by local villagers as the sacred bathing site of forest deities, the plunge pool boasts crystalline turquoise water enclosed by colossal Sahyadri cliff faces. The trek from Bhira village passes through dense teak jungle, gushing seasonal streams, and open riverbeds with panoramic views of the Western Ghats.",
        bestDurationMinDays = 1,
        bestDurationMaxDays = 2,
        altitude = "540 m",
        destinationTypes = listOf("Waterfall", "Hidden Gem", "Trekking", "Nature", "Adventure", "Offbeat", "Forest"),
        discoveryLevel = DiscoveryLevel.HIDDEN_GEM,
        verificationLevel = VerificationLevel.GOVERNMENT,
        bestMonths = "July to November",
        recommendedFor = listOf("Adventure Seekers", "Trekkers", "Nature Photographers", "Weekend Campers"),
        categories = listOf(
            TravelCategory.WATERFALLS,
            TravelCategory.ADVENTURE,
            TravelCategory.NATURE,
            TravelCategory.WEEKEND_GETAWAYS
        ),
        safetyNotes = "FLASH FLOOD WARNING: In peak July-August downpours, streams rise rapidly. Swimming in the central plunge pool is strictly restricted due to intense underwater currents and depths exceeding 60 feet. Mandatory local guide required at Bhira checkpoint.",
        bestTime = BestTimeInfo(
            bestMonths = "July to November",
            weatherSummary = "Lush green monsoon mist with roaring waterfall; pleasant cool post-monsoon winter",
            peakSeason = "August to October",
            offSeason = "March to May (Waterfall dries up into trickle)",
            expectedCrowd = "Moderate on weekends; very quiet on weekdays",
            temperatureRange = "19°C – 28°C",
            suggestedDuration = "1–2 Days"
        ),
        attractions = listOf(
            Attraction(
                id = "devkund-plunge-pool",
                destinationId = "maharashtra-devkund",
                name = "Devkund Waterfall Plunge Pool",
                description = "The main 220-foot plunge waterfall crashing into a natural emerald pool framed by volcanic amphitheatre cliffs.",
                category = "Waterfall",
                latitude = 18.5204,
                longitude = 73.4356,
                openingTime = "07:00 AM",
                closingTime = "04:30 PM",
                entryFeeAdult = "₹50 (Local Eco-Tourism Forest Fee)",
                entryFeeChild = "Free under 10",
                recommendedDurationMinutes = 180,
                distanceFromDestinationKm = 0f,
                parkingAvailable = true,
                parkingFee = "₹50 at Bhira base",
                difficultyLevel = "Moderate Trek (6.5 km one way)",
                familyFriendly = false,
                childrenFriendly = false,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Early Morning (07:30 AM - 11:00 AM)",
                tips = "Wear sturdy grip trekking shoes; carry at least 2 litres of water and dry clothes in a waterproof pouch.",
                discoveryLevel = DiscoveryLevel.HIDDEN_GEM,
                trekDistanceKm = 6.5f,
                trekDurationMinutes = 180,
                swimmingAllowed = false,
                safetyNotes = "Deep water (60+ ft). Lifejackets mandatory near water edge. Swimming forbidden."
            ),
            Attraction(
                id = "bhira-dam-reservoir",
                destinationId = "maharashtra-devkund",
                name = "Bhira Dam (Tata Power Hydroelectric)",
                description = "Scenic reservoir lake where the Kundalika river originates, surrounded by mist-capped Sahyadri peaks.",
                category = "Lake / Dam",
                latitude = 18.4982,
                longitude = 73.3912,
                openingTime = "06:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 60,
                distanceFromDestinationKm = 4.2f,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                tips = "Great picnic and photography spot before or after the trek."
            ),
            Attraction(
                id = "tamhini-plus-valley",
                destinationId = "maharashtra-devkund",
                name = "Plus Valley & Tamhini Ghat Viewpoint",
                description = "A dramatic plus-shaped Sahyadri valley chasm that drops over 1,000 feet with dozens of seasonal ribbon cascades.",
                category = "Viewpoint",
                latitude = 18.4862,
                longitude = 73.4215,
                openingTime = "24 Hours",
                closingTime = "Sunset recommended",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 45,
                distanceFromDestinationKm = 8.5f,
                parkingAvailable = true,
                difficultyLevel = "Easy roadside",
                familyFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                tips = "Stunning monsoon clouds floating through the valley floor."
            )
        ),
        hiddenGems = listOf(
            HiddenGem(
                id = "gem-devkund-secret-stream",
                destinationId = "maharashtra-devkund",
                name = "Kundalika River Headwaters Secret Pool",
                description = "A secluded shallow rock pool 800m before the main Devkund falls, shaded by giant Jamun and wild fig trees with gentle clean current.",
                whyItIsSpecial = "Safe natural wading pool away from the turbulent plunge, where river pebbles shine in dappled sunlight.",
                category = "Nature Spot",
                location = "Between Camp 2 and Devkund rocky riverbed",
                latitude = 18.5140,
                longitude = 73.4290,
                bestMonths = "September to December",
                crowdLevel = "Low",
                difficulty = "Moderate",
                accessibility = "Jungle trail only",
                recommendedDuration = "45 mins",
                entryFee = "Covered in forest entry",
                parking = "At Bhira village",
                safetyNotes = "Do not venture if current is fast during heavy rain.",
                localTips = "Perfect spot for a refreshing foot dip and energy snack break."
            )
        ),
        localExperiences = listOf(
            LocalExperience(
                destinationId = "maharashtra-devkund",
                name = "Bhira Village Agri-Homestay & Pithla Bhakri Meal",
                description = "Savor authentic village-cooked Maharashtrian hot Pithla (spiced gram flour curry) with rustic Jowar Bhakri and fiery Thecha, cooked on wood fire by Bhira village families.",
                duration = "1.5 Hours",
                approximateCost = "₹150 - ₹250 per thali",
                bestMonths = "July to February",
                familyFriendly = true,
                bookingRequired = false,
                source = "Bhira Eco-Tourism Village Committee"
            )
        ),
        scenicRoutes = listOf(
            ScenicRoute(
                origin = "Pune / Mumbai / Hyderabad",
                destination = "Devkund Waterfall (Bhira)",
                routeName = "Tamhini Ghat Rainforest Highway (SH-70 / NH-66)",
                distanceKm = 170,
                estimatedTime = "4 Hours",
                scenicRating = 4.9f,
                attractionsAlongRoute = listOf("Mulshi Dam Backwaters", "Tamhini Waterfall Valley", "Dongarwadi Waterfall", "Plus Valley"),
                viewpoints = listOf("Tamhini Crest View", "Mulshi Lake Edge"),
                waterfalls = listOf("Tamhini Roadside Cascades", "Kansai Falls"),
                restaurants = listOf("Quick Bites Dhabas at Tamhini", "Bhira Village Canteen"),
                fuelStops = listOf("Paud HP Station", "Mangaon IOCL"),
                roadCondition = "Winding scenic ghat road with smooth asphalt; cautious driving during heavy fog and rains",
                bestSeason = "July to October"
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-bhira-village-homestay",
                destinationId = "maharashtra-devkund",
                name = "Bhira Village Community Homestays",
                category = "Homestay",
                minimumPrice = 800,
                maximumPrice = 1800,
                rating = 4.4f,
                reviewCount = 380,
                amenities = listOf("Clean Mattresses", "Home-Cooked Food", "Hot Water", "Local Guide Assistance"),
                approximatePrice = "₹1,000 - ₹1,500 / night (Includes breakfast & dinner)",
                latitude = 18.5020,
                longitude = 73.3980
            ),
            Accommodation(
                id = "stay-tamhini-eco-resort",
                destinationId = "maharashtra-devkund",
                name = "Tamhini Forest View Eco-Resort",
                category = "Resort",
                minimumPrice = 2800,
                maximumPrice = 5200,
                rating = 4.3f,
                reviewCount = 210,
                amenities = listOf("Mountain View Balcony", "Restaurant", "Wi-Fi in Lobby", "Garden Lawn", "Parking"),
                approximatePrice = "₹3,500 / night",
                distanceFromDestinationKm = 14f,
                latitude = 18.4720,
                longitude = 73.4410
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Pithla Bhakri with Thecha",
                    isVegetarian = true,
                    description = "Gram flour savory curry paired with crisp-tender jowar/bajra flatbread and spicy pounded green chili garlic chutney.",
                    popularAt = "Bhira Village Base Kitchens",
                    priceRange = "₹120 - ₹180"
                ),
                FoodItem(
                    name = "Kanda Poha & Solkadhi",
                    isVegetarian = true,
                    description = "Flattened rice tempered with mustard, peanuts, and onions, washed down with refreshing coconut milk kokum digestive Solkadhi.",
                    popularAt = "Tamhini Ghat Roadside Dhabas",
                    priceRange = "₹60 - ₹100"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Kaka Niwas Bhira Village Dining",
                    cuisine = "Authentic Konkani & Maharashtrian",
                    rating = 4.6f,
                    isVegFriendly = true,
                    signatureDish = "Chulivarchi Pithla Bhakri & Gavran Chicken Thali",
                    priceForTwo = "₹350",
                    distance = "At Bhira Trek Base"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Pune" to 110,
                "Mumbai" to 140,
                "Hyderabad" to 540,
                "Bengaluru" to 880
            ),
            drivingTimes = mapOf(
                "Pune" to "3 Hours",
                "Mumbai" to "3.5 - 4 Hours",
                "Hyderabad" to "9.5 Hours",
                "Bengaluru" to "14 Hours"
            ),
            roadTripRoute = "From Pune: Chandani Chowk -> Paud -> Mulshi Dam -> Tamhini Ghat -> Bhira village base. From Mumbai: Mumbai-Pune Expressway -> Khopoli exit -> Pali -> Mangaon -> Bhira.",
            tollAndParkingNotes = "State toll: ~₹100 at Pali/Mulshi. Dedicated community parking at Bhira village: ₹50 for cars, ₹30 for bikes.",
            nearestRailwayStation = "Mangaon Railway Station (28 km) / Roha Railway Station (36 km)",
            nearestAirport = "Pune International Airport (PNQ - 115 km) / Mumbai Chhatrapati Shivaji (BOM - 145 km)",
            busTrainFlightOptions = "State transport MSRTC buses connect Mangaon with Pune & Mumbai. From Mangaon, local sharing jeeps/autos reach Bhira village in 45 mins.",
            fuelEstimateCar = mapOf("Pune" to 1100, "Mumbai" to 1500, "Hyderabad" to 5800),
            tollEstimate = mapOf("Pune" to 80, "Mumbai" to 320, "Hyderabad" to 650),
            roadCondition = "Good tarmac with winding twists through scenic Tamhini mountain pass. Watch out for potholes and fog during peak monsoon."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 1400,
            foodEstimatePerDay = 600,
            activitiesTotal = 300,
            travelEstimate = 1500,
            totalEstimateMin = 3800,
            totalEstimateMax = 8500,
            tiers = listOf(
                BudgetTier("Budget", 2200, 3800, 5800, 5000),
                BudgetTier("Mid-Range", 3500, 6000, 9500, 8000),
                BudgetTier("Luxury", 6000, 11000, 16000, 14000)
            )
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("maharashtra-devkund"),
        timedScheduleTemplate = listOf(
            DayStop("Morning", "06:30 AM", "Depart from base / Pune / Mumbai and drive through misty Tamhini Ghat", "2.5 Hours", "Breakfast at Mulshi: Hot Misal Pav & Chai"),
            DayStop("Morning", "09:00 AM", "Arrive at Bhira Village, register with Eco Forest Committee, start 6.5 km Devkund Jungle Trek", "2.5 Hours", "Carry hydration and energy bars"),
            DayStop("Afternoon", "11:30 AM", "Reach Devkund Waterfall plunge pool; marvel at emerald waters and towering amphitheater cliffs", "1.5 Hours", null, "Photography from designated safe viewing boulders"),
            DayStop("Afternoon", "01:30 PM", "Trek back to Bhira village through riverbed crossings", "2 Hours"),
            DayStop("Late Afternoon", "03:30 PM", "Enjoy village-cooked hot Pithla Bhakri meal at Bhira base", "1 Hour", "Authentic rural Maharashtrian Thali"),
            DayStop("Evening", "05:00 PM", "Sunset at Bhira Dam reservoir or Plus Valley viewpoint before relaxing drive back", "1.5 Hours")
        )
    )

    val lonavala = Destination(
        id = "maharashtra-lonavala",
        name = "Lonavala & Khandala",
        state = "Maharashtra",
        stateCode = "MH",
        district = "Pune",
        taluk = "Maval",
        latitude = 18.7557,
        longitude = 73.4091,
        tagline = "The iconic twin hill resorts of the Sahyadri mountains with ancient Buddhist caves",
        description = "Lonavala is Maharashtra's premier monsoon getaway, situated at the edge of the Western Ghats. Known for lush green ravines, Karla and Bhaja ancient rock-cut Buddhist caves, historic Maratha forts like Rajmachi and Lohagad, gushing waterfalls, and world-famous sweet chikki.",
        shortDescription = "Misty hill station with forts, deep waterfalls, and ancient rock caves",
        fullDescription = "Surrounded by sweeping valleys and deep gorges, Lonavala and Khandala have drawn travelers for over a century. From the precipitous drop of Tiger's Leap to the serene waters of Bushi and Pawna lakes, the region offers a blend of heritage, scenic road trips, and pleasant Sahyadri climate.",
        bestDurationMinDays = 2,
        bestDurationMaxDays = 3,
        altitude = "624 m",
        destinationTypes = listOf("Hill Station", "Fort", "Caves", "Lakes", "Waterfall", "Heritage", "Weekend Trip"),
        discoveryLevel = DiscoveryLevel.ICONIC,
        bestMonths = "July to March",
        categories = listOf(
            TravelCategory.MOUNTAINS,
            TravelCategory.NATURE,
            TravelCategory.HERITAGE,
            TravelCategory.WEEKEND_GETAWAYS
        ),
        attractions = listOf(
            Attraction(
                id = "lonavala-tiger-point",
                destinationId = "maharashtra-lonavala",
                name = "Tiger's Leap (Wagh Dari)",
                description = "A dramatic cliff-top with a sheer drop of over 650 metres resembling a leaping tiger, providing sweeping views of the Konkan plains.",
                category = "Viewpoint",
                latitude = 18.7230,
                longitude = 73.3645,
                openingTime = "06:00 AM",
                closingTime = "06:30 PM",
                recommendedDurationMinutes = 60,
                familyFriendly = true,
                photographyAllowed = true,
                tips = "Savor hot corn bhajjis and steaming chai in the monsoon fog."
            ),
            Attraction(
                id = "lonavala-karla-caves",
                destinationId = "maharashtra-lonavala",
                name = "Karla Buddhist Rock-Cut Caves",
                description = "Ancient 2nd-century BC Buddhist rock architecture housing India's largest and best-preserved rock-cut chaitya hall with wooden rib vaults.",
                category = "Caves / Heritage",
                latitude = 18.7828,
                longitude = 73.4705,
                openingTime = "09:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "₹25 (ASI)",
                recommendedDurationMinutes = 90,
                familyFriendly = true,
                photographyAllowed = true,
                tips = "Climb the 350 stone steps in morning hours; temple of Ekvira Devi sits outside."
            ),
            Attraction(
                id = "lonavala-lohagad-fort",
                destinationId = "maharashtra-lonavala",
                name = "Lohagad Fort (Iron Fort)",
                description = "Magnificent hill fort fortified by Chhatrapati Shivaji Maharaj, featuring four intact gateways and the long Vinchukata (Scorpion's Tail) ridge.",
                category = "Fort / Trek",
                latitude = 18.7042,
                longitude = 73.4795,
                openingTime = "07:00 AM",
                closingTime = "05:30 PM",
                recommendedDurationMinutes = 150,
                difficultyLevel = "Moderate Trek",
                familyFriendly = true,
                photographyAllowed = true,
                tips = "Panoramic views of Pawna Lake and Visapur Fort from the high ramparts."
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Lonavala Crushed Peanut Chikki",
                    isVegetarian = true,
                    description = "Brittle sweet confection made with golden jaggery and roasted peanuts, crafted freshly since 1892.",
                    popularAt = "Maganlal Chikki & Cooper's Fudge",
                    priceRange = "₹200 - ₹500/kg"
                ),
                FoodItem(
                    name = "Vada Pav & Corn Bhaji",
                    isVegetarian = true,
                    description = "Crispy golden spiced potato dumpling in soft pav with dry garlic chutney, best eaten hot on rainy cliffs.",
                    popularAt = "Tiger Point & Expressway Dhabas",
                    priceRange = "₹40 - ₹80"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Pune" to 65,
                "Mumbai" to 85,
                "Hyderabad" to 595,
                "Bengaluru" to 900
            ),
            drivingTimes = mapOf(
                "Pune" to "1.5 Hours",
                "Mumbai" to "2 Hours",
                "Hyderabad" to "10 Hours",
                "Bengaluru" to "14 Hours"
            ),
            roadTripRoute = "Seamless access via the 6-lane Mumbai-Pune Expressway (NH 48) exiting directly into Lonavala toll gate.",
            tollAndParkingNotes = "Expressway toll applies (~₹320 from Mumbai, ~₹120 from Pune). Paid parking available at caves and viewpoints.",
            nearestRailwayStation = "Lonavala Railway Station (Centrally located with frequent local trains from Pune & Mumbai)",
            nearestAirport = "Pune International Airport (70 km) / Navi Mumbai Airport",
            busTrainFlightOptions = "Dozens of daily express trains stop at Lonavala. Intercity AC buses depart every 15 minutes."
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("maharashtra-lonavala")
    )

    val kaasPlateau = Destination(
        id = "maharashtra-kaas",
        name = "Kaas Plateau (Valley of Flowers of Maharashtra)",
        state = "Maharashtra",
        stateCode = "MH",
        district = "Satara",
        latitude = 17.7214,
        longitude = 73.8211,
        tagline = "UNESCO World Natural Heritage volcanic plateau carpeted with wild endemic blossoms",
        description = "Kaas Pathar is an extraordinary laterite rock plateau in the Sahyadri Tiger Reserve landscape. Following late monsoon rains in August and September, the barren volcanic tableland transforms into a vibrant, multi-colored living carpet of over 850 species of rare wildflowers and insectivorous orchids.",
        shortDescription = "UNESCO floral biodiversity marvel blooming with millions of rare wild orchids",
        fullDescription = "Perched at 1,200 meters in the Western Ghats near Satara, Kaas is a UNESCO World Heritage biodiversity hotspot. Its thin laterite soil supports rare endemic plants including Utricularia, Impatiens, and Pogostemon that bloom for just 4 to 6 weeks every year.",
        bestDurationMinDays = 1,
        bestDurationMaxDays = 2,
        altitude = "1,200 m",
        destinationTypes = listOf("Nature", "Hidden Gem", "Photography", "Botanical", "UNESCO Heritage", "Weekend Trip"),
        discoveryLevel = DiscoveryLevel.HIDDEN_GEM,
        verificationLevel = VerificationLevel.GOVERNMENT,
        bestMonths = "Late August to mid-October",
        categories = listOf(TravelCategory.NATURE, TravelCategory.WEEKEND_GETAWAYS),
        attractions = listOf(
            Attraction(
                id = "kaas-flower-plateau",
                destinationId = "maharashtra-kaas",
                name = "Kaas Plateau Wildflower Reserve",
                description = "Walking trails flanked by purple, yellow, and blue wildflower carpets blooming under misty skies.",
                category = "Nature Reserve",
                latitude = 17.7214,
                longitude = 73.8211,
                openingTime = "07:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "₹100 (Online Booking Mandatory during bloom)",
                recommendedDurationMinutes = 150,
                parkingAvailable = true,
                familyFriendly = true,
                photographyAllowed = true,
                tips = "Walking off the marked wooden pathways is strictly prohibited to protect microflora."
            ),
            Attraction(
                id = "kaas-lake-kumudini",
                destinationId = "maharashtra-kaas",
                name = "Kaas Lake & Kumudini Lily Pond",
                description = "Serene high-altitude lake rimmed by dense forests and a quiet pond covered with floating white Kumudini water lilies.",
                category = "Lake",
                latitude = 17.7120,
                longitude = 73.8050,
                recommendedDurationMinutes = 60,
                familyFriendly = true,
                photographyAllowed = true,
                tips = "Quiet early morning photography."
            ),
            Attraction(
                id = "vajrai-waterfall-satara",
                destinationId = "maharashtra-kaas",
                name = "Thoseghar & Bhambavli Vajrai Waterfall",
                description = "India's highest 3-tier plunge waterfall dropping 1,840 feet from the Urmodi river cliffs near Satara.",
                category = "Waterfall",
                latitude = 17.6520,
                longitude = 73.7840,
                recommendedDurationMinutes = 90,
                entryFeeAdult = "₹50",
                familyFriendly = true,
                photographyAllowed = true,
                tips = "Spectacular view from the safety watchtower."
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Satari Kandi Peda",
                    isVegetarian = true,
                    description = "Famed traditional caramelized reduced-milk sweet originating from Satara town.",
                    popularAt = "Modi Peda Satara",
                    priceRange = "₹400/kg"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Pune" to 135, "Mumbai" to 280, "Hyderabad" to 520),
            drivingTimes = mapOf("Pune" to "3 Hours", "Mumbai" to "5.5 Hours", "Hyderabad" to "9 Hours"),
            roadTripRoute = "NH 48 Pune-Bengaluru Highway -> Satara city -> Kaas Ghat road (24 km scenic climb).",
            tollAndParkingNotes = "Satara highway toll applies. Dedicated parking lot 1 km before plateau with electric shuttle buses.",
            nearestRailwayStation = "Satara Railway Station (28 km)",
            nearestAirport = "Pune Airport (145 km)",
            busTrainFlightOptions = "Express trains stop at Satara. Regular MSRTC city buses connect Satara bus stand to Kaas."
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("maharashtra-kaas")
    )

    val bhandardara = Destination(
        id = "maharashtra-bhandardara",
        name = "Bhandardara & Mount Kalsubai",
        state = "Maharashtra",
        stateCode = "MH",
        district = "Ahmednagar",
        latitude = 19.5350,
        longitude = 73.7580,
        tagline = "Peaceful mountain retreat at the base of Maharashtra's highest peak with pristine lakes",
        description = "Bhandardara is an idyllic holiday village tucked in the northern Sahyadri ranges along the Pravara River. It is celebrated for Arthur Lake, the roaring 170-foot Randha Falls, Umbrella Falls at Wilson Dam, and Mount Kalsubai (1,646 m, highest peak in Maharashtra).",
        shortDescription = "Misty lake country and giant waterfalls beneath Everest of Maharashtra",
        fullDescription = "Away from commercial crowds, Bhandardara is a haven for stargazers, trekkers, and nature enthusiasts. In pre-monsoon May-June, millions of fireflies illuminate the forest canopy in a nocturnal spectacle.",
        bestDurationMinDays = 2,
        bestDurationMaxDays = 3,
        altitude = "750 m",
        destinationTypes = listOf("Hill Station", "Waterfall", "Lake", "Trekking", "Camping", "Offbeat"),
        discoveryLevel = DiscoveryLevel.OFFBEAT,
        bestMonths = "July to February (May-June for Fireflies Festival)",
        categories = listOf(TravelCategory.MOUNTAINS, TravelCategory.WATERFALLS, TravelCategory.NATURE),
        attractions = listOf(
            Attraction(
                id = "bhandardara-randha-falls",
                destinationId = "maharashtra-bhandardara",
                name = "Randha Falls",
                description = "Majestic 170-foot plunge waterfall on the Pravara river rushing into a deep rocky gorge.",
                category = "Waterfall",
                latitude = 19.5480,
                longitude = 73.7910,
                recommendedDurationMinutes = 60,
                entryFeeAdult = "₹30",
                familyFriendly = true,
                photographyAllowed = true
            ),
            Attraction(
                id = "bhandardara-kalsubai-peak",
                destinationId = "maharashtra-bhandardara",
                name = "Mount Kalsubai Peak Trek",
                description = "Highest point in Maharashtra (1,646 metres) with iron ladders bolted to cliff faces leading to the summit temple.",
                category = "Trek",
                latitude = 19.6010,
                longitude = 73.7120,
                recommendedDurationMinutes = 300,
                difficultyLevel = "Strenuous (6.5 km uphill)",
                familyFriendly = false,
                tips = "Start trek at 4:00 AM from Bari village for incredible sunrise over cloud sea."
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Mumbai" to 165, "Pune" to 175, "Nashik" to 70, "Hyderabad" to 630),
            drivingTimes = mapOf("Mumbai" to "4 Hours", "Pune" to "4.5 Hours", "Nashik" to "2 Hours", "Hyderabad" to "11 Hours"),
            roadTripRoute = "NH 160 Mumbai-Nashik highway -> Igatpuri -> Ghoti bypass -> Bhandardara.",
            tollAndParkingNotes = "Igatpuri toll applies. Local parking free at villages.",
            nearestRailwayStation = "Igatpuri Railway Station (45 km)",
            nearestAirport = "Nashik Airport (85 km) / Mumbai Airport (170 km)",
            busTrainFlightOptions = "Trains stop at Igatpuri, followed by taxi or state bus to Bhandardara."
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("maharashtra-bhandardara")
    )

    val destinations: List<Destination> = listOf(
        devkundWaterfall,
        lonavala,
        kaasPlateau,
        bhandardara
    )

    fun getById(id: String): Destination? = destinations.find { it.id == id }
}
