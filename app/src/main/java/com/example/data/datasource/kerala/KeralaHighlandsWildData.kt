package com.example.data.datasource.kerala

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

object KeralaHighlandsWildData {

    val munnar = Destination(
        id = "kerala-munnar",
        name = "Munnar",
        state = "Kerala",
        district = "Idukki",
        tagline = "The Kashmir of South India & High Ranges of Anamudi",
        description = "Perched at 1,600 meters at the confluence of three mountain rivers (Muthirapuzha, Nallathanni, and Kundaly), Munnar is South India's premier tea hill station. Home to Anamudi Peak (2,695 m - highest peak in South India), endangered Nilgiri Tahr at Eravikulam National Park, Mattupetty Dam, and endless rolling carpets of manicured emerald tea plantations.",
        rating = 4.9f,
        reviewCount = 28600,
        coverResId = null,
        categories = listOf(TravelCategory.MOUNTAINS, TravelCategory.COUPLES, TravelCategory.FAMILY_FRIENDLY, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "September – May",
            weatherSummary = "Crisp, misty highland climate; winter nights drop to 5°C; stunning Neelakurinji blossom blooms every 12 years",
            peakSeason = "October – February & April – May",
            offSeason = "June – August (Monsoons - heavy rains bring dramatic waterfalls)",
            expectedCrowd = "Very High",
            temperatureRange = "7°C – 22°C",
            suggestedDuration = "3–4 Days"
        ),
        seasons = RegionalSeasonalHelper.createHighAltitudeSeasons("kerala-munnar"),
        attractions = listOf(
            Attraction(
                id = "munn-eravikulam",
                destinationId = "kerala-munnar",
                name = "Eravikulam National Park (Rajamalai)",
                description = "97 sq km high-altitude sanctuary harboring the largest surviving population of the endangered Nilgiri Tahr (mountain wild goat), offering panoramic views of Anamudi Peak across rolling shola grasslands.",
                category = "National Park & Wildlife",
                openingTime = "07:30 AM – 04:00 PM (Closed Feb – March for calving season)",
                closingTime = "04:00 PM",
                entryFeeAdult = "₹200 (Indians), ₹500 (Foreigners) - includes park safari bus",
                entryFeeChild = "₹150",
                recommendedDurationMinutes = 180,
                parkingAvailable = true,
                parkingFee = "₹50 (At base booking counter)",
                difficultyLevel = "Easy to Moderate (Paved 1 km uphill walk at summit)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "First morning bus at 07:30 AM for clear visibility and grazing tahr sightings",
                tips = "Book tickets online in advance via Kerala Forest Department website to skip long counter queues."
            ),
            Attraction(
                id = "munn-mattupetty-dam",
                destinationId = "kerala-munnar",
                name = "Mattupetty Dam & Echo Point",
                description = "Concrete gravity dam nestled among rolling tea slopes with speedboating on the tranquil reservoir, followed by the natural acoustic phenomenon of Echo Point along the lake banks.",
                category = "Lakes & Boating",
                openingTime = "09:00 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "₹10 (Speedboat ₹500 for 5 persons)",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹40",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "10:00 AM or late afternoon 03:30 PM",
                tips = "Wild elephants frequently come down to drink water on the opposite shores of Mattupetty lake."
            ),
            Attraction(
                id = "munn-tea-museum",
                destinationId = "kerala-munnar",
                name = "Tata Tea Museum (KDHP Nallathanni)",
                description = "India's first tea museum tracing the 130-year evolution of Munnar's tea industry from manual roller crushers to modern CTC and orthodox manufacturing, with live tea tasting sessions.",
                category = "Heritage & Industry",
                openingTime = "09:00 AM – 05:00 PM (Closed Mondays)",
                closingTime = "05:00 PM",
                entryFeeAdult = "₹150 (Includes factory demonstration)",
                entryFeeChild = "₹50",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 10:30 AM or 02:30 PM for the documentary film screening",
                tips = "Purchase factory-fresh single-origin orthodox and green tea packets at the museum outlet."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-munn-windermere",
                destinationId = "kerala-munnar",
                name = "Windermere Estate Munnar",
                category = "Boutique Tea Plantation Estate",
                minimumPrice = 12000,
                maximumPrice = 24000,
                rating = 4.8f,
                reviewCount = 2200,
                amenities = listOf("60-Acre Working Cardamom & Coffee Estate", "Plantation Walks", "The Barn Fine Dining", "Campfire"),
                approximatePrice = "Approx. ₹14,000 / night (verify before travel)",
                phone = "+91 4865 230 512",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-munn-fragrant-nature",
                destinationId = "kerala-munnar",
                name = "Fragrant Nature Munnar",
                category = "5-Star Luxury Hill Resort",
                minimumPrice = 8500,
                maximumPrice = 18000,
                rating = 4.7f,
                reviewCount = 2400,
                amenities = listOf("Fireplaces in all Rooms", "Panoramic Valley Views", "Ayurvedic Prana Spa", "Multi-Cuisine Dining"),
                approximatePrice = "Approx. ₹9,800 / night (verify before travel)",
                phone = "+91 4865 214 000",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Fresh Cardamom-Infused Tea & Kerala Porotta with Beef Fry",
                    isVegetarian = false,
                    description = "Freshly harvested green cardamom pods brewed into rich estate milk tea, alongside flaky porottas with spiced beef dry fry.",
                    popularAt = "Rapsy Restaurant (Munnar town market - since 1980)"
                ),
                FoodItem(
                    name = "Appam with Vegetable Ishtu & Puttu Kadala",
                    isVegetarian = true,
                    description = "Steamed cylindrical rice-coconut cakes (Puttu) paired with dark roasted chickpea curry (Kadala).",
                    popularAt = "Saravana Bhavan & Hotel SN"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Rapsy Restaurant",
                    cuisine = "Local Kerala Comfort Food",
                    rating = 4.4f,
                    isVegFriendly = true,
                    signatureDish = "Spanish Omelette, Beef Fry & Porotta",
                    priceForTwo = "₹400",
                    distance = "Main Bazaar"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Kochi" to 130, "Madurai" to 155, "Coimbatore" to 160, "Bengaluru" to 475, "Thekkady" to 95
            ),
            drivingTimes = mapOf(
                "Kochi" to "3h 45m via NH85 (Gap Road)", "Madurai" to "4h 0m via Theni & Bodimettu", "Thekkady" to "3h 0m via SH19"
            ),
            roadTripRoute = "Via NH85 passing through Kothamangalam, Adimali, Cheeyappara waterfalls, and ascending the breathtaking Gap Road.",
            tollAndParkingNotes = "Recently upgraded 2-lane highway with scenic pull-outs. Free parking at scenic viewpoints.",
            nearestRailwayStation = "Aluva (AWY - 110 km) / Ernakulam Junction (130 km)",
            nearestAirport = "Cochin International Airport (COK - 110 km) / Madurai (155 km)",
            busTrainFlightOptions = "KSRTC low-floor AC buses run multiple times daily from Ernakulam (KSRTC bus station) directly to Munnar."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 4500,
            foodEstimatePerDay = 1200,
            activitiesTotal = 800,
            travelEstimate = 2000,
            totalEstimateMin = 13000,
            totalEstimateMax = 32000
        )
    )

    val wayanad = Destination(
        id = "kerala-wayanad",
        name = "Wayanad",
        state = "Kerala",
        district = "Wayanad",
        tagline = "The Land of Paddy Fields & Prehistoric Edakkal Caves",
        description = "Resting on the southern tip of the Deccan plateau between 700 and 2,100 meters, Wayanad is an emerald mountain paradise of spice plantations (pepper, cardamom, coffee), the 6,000-year-old Neolithic petroglyphs of Edakkal Caves, Chembra Peak with its natural heart-shaped lake, Banasura Sagar Dam—India's largest earthen dam, and Muthanga Wildlife Sanctuary.",
        rating = 4.8f,
        reviewCount = 23800,
        coverResId = null,
        categories = listOf(TravelCategory.MOUNTAINS, TravelCategory.ADVENTURE, TravelCategory.NATURE, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "October – May",
            weatherSummary = "Crisp hill air, pleasant daytime temperatures, lush green post-monsoon waterfalls",
            peakSeason = "November – February",
            offSeason = "June – August (Heavy monsoon - beautiful rainforest trails)",
            expectedCrowd = "High",
            temperatureRange = "15°C – 28°C",
            suggestedDuration = "3–4 Days"
        ),
        seasons = RegionalSeasonalHelper.createHighAltitudeSeasons("kerala-wayanad"),
        attractions = listOf(
            Attraction(
                id = "waya-edakkal-caves",
                destinationId = "kerala-wayanad",
                name = "Edakkal Caves (6,000 BCE Petroglyphs)",
                description = "Natural rock cleft split into two chambers atop Ambukuthi Mala at 1,200 meters, featuring priceless Stone Age petroglyphs and human/animal carvings dating from 6,000 BCE to 1,000 BCE.",
                category = "Prehistoric Archaeology",
                openingTime = "09:00 AM – 04:00 PM (Closed Mondays)",
                closingTime = "04:00 PM",
                entryFeeAdult = "₹50",
                entryFeeChild = "₹25",
                recommendedDurationMinutes = 150,
                parkingAvailable = true,
                parkingFee = "₹40",
                difficultyLevel = "Moderate (Steep stepped climb up 300 steps)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 09:30 AM before afternoon heat",
                tips = "Daily visitor limit is capped at 1,920 persons; arrive early to ensure entry passes."
            ),
            Attraction(
                id = "waya-banasura-dam",
                destinationId = "kerala-wayanad",
                name = "Banasura Sagar Dam & Speedboating",
                description = "The largest earthen dam in India and second largest in Asia, impounding the Karamanathodu tributary of Kabini river with picturesque island hillocks set against Banasura Peak.",
                category = "Dam & Adventure Boating",
                openingTime = "09:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "₹40 (Speedboat ₹850 for 5 persons)",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹50",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning or late afternoon",
                tips = "Ziplining across the reservoir waters is available for thrill seekers."
            ),
            Attraction(
                id = "waya-chembra-peak",
                destinationId = "kerala-wayanad",
                name = "Chembra Peak & Heart-Shaped Lake (Hridaya Saras)",
                description = "Highest peak in Wayanad (2,100 meters) featuring an adventurous trek through tea slopes and shola grasslands to a natural perennial lake shaped precisely like a heart that never dries up.",
                category = "Adventure Trek",
                openingTime = "07:00 AM – 12:00 PM (Passes issued until noon)",
                closingTime = "02:00 PM (Trek completion)",
                entryFeeAdult = "Trek permit ₹1,000 per group (up to 5 persons) with forest guide",
                recommendedDurationMinutes = 240,
                parkingAvailable = true,
                difficultyLevel = "Moderate to Challenging (4 km steep trek)",
                familyFriendly = false,
                childrenFriendly = false,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "First morning batch at 07:00 AM",
                tips = "Only 200 trek permits issued per day by the Forest Department. Wear sturdy hiking shoes with good grip."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-waya-vythiri-resort",
                destinationId = "kerala-wayanad",
                name = "Vythiri Resort Wayanad",
                category = "Luxury Rainforest & Treehouse Resort",
                minimumPrice = 14000,
                maximumPrice = 30000,
                rating = 4.8f,
                reviewCount = 3200,
                amenities = listOf("Luxury Treehouses with Jacuzzis", "Canopy Hanging Bridge", "Natural Stream Pool", "Ayurvedic Spa"),
                approximatePrice = "Approx. ₹16,000 / night (verify before travel)",
                phone = "+91 4936 256 800",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-waya-windflower",
                destinationId = "kerala-wayanad",
                name = "The Windflower Resort & Spa Vythiri",
                category = "5-Star Tea Plantation Resort",
                minimumPrice = 7500,
                maximumPrice = 16000,
                rating = 4.6f,
                reviewCount = 2100,
                amenities = listOf("Villas amidst Tea Gardens", "Ayurvedic Spa", "Infinity Pool overlooking Chembra"),
                approximatePrice = "Approx. ₹8,800 / night (verify before travel)",
                phone = "+91 80 4115 2200",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Malabar Bamboo Biryani & Kanthari Chicken",
                    isVegetarian = false,
                    description = "Fragrant spiced kaima rice and chicken steamed inside hollow raw bamboo stems over hot embers, alongside chicken cooked with bird's-eye chillies (Kanthari).",
                    popularAt = "Udupi Restaurant & 1980's A Nostalgic Restaurant (Kalpetta)"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "1980's A Nostalgic Restaurant",
                    cuisine = "Traditional Kerala Village Food",
                    rating = 4.6f,
                    isVegFriendly = true,
                    signatureDish = "Sadhya on Banana Leaf, Neymeen Fry & Beef Curry",
                    priceForTwo = "₹600",
                    distance = "Kalpetta bypass"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Bengaluru" to 280, "Mysuru" to 135, "Kozhikode" to 85, "Kochi" to 260, "Coimbatore" to 220
            ),
            drivingTimes = mapOf(
                "Mysuru" to "3h 0m via Bandipur & Sulthan Bathery",
                "Kozhikode" to "2h 30m via 9 hairpin bends of Thamarassery Churam",
                "Bengaluru" to "6h 0m via Mysuru Expressway"
            ),
            roadTripRoute = "Via NH766 from Bengaluru/Mysuru passing through Bandipur and Muthanga forest corridors into Sulthan Bathery.",
            tollAndParkingNotes = "Bandipur forest checkpost closes at night (09:00 PM – 06:00 AM). Drive during daylight.",
            nearestRailwayStation = "Kozhikode (CLT - 85 km)",
            nearestAirport = "Calicut International Airport (CCJ - 95 km) / Kannur (90 km)",
            busTrainFlightOptions = "KSRTC Karnataka and Kerala run regular Volvo club class buses directly from Bengaluru to Sulthan Bathery/Kalpetta."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 4000,
            foodEstimatePerDay = 1100,
            activitiesTotal = 800,
            travelEstimate = 1800,
            totalEstimateMin = 11000,
            totalEstimateMax = 28000
        )
    )

    val thekkady = Destination(
        id = "kerala-thekkady",
        name = "Thekkady (Periyar)",
        state = "Kerala",
        district = "Idukki",
        tagline = "The Tiger Reserve, Periyar Lake & Spice Fragrance",
        description = "Set at 900 to 1,800 meters around the 26 sq km artificial Periyar Lake created by the Mullaperiyar Dam in 1895, Thekkady is the sanctuary of the Periyar Tiger Reserve. Famed for lake boat safaris spotting wild elephant herds swimming across water bodies, bamboo rafting, spice plantation walks (cardamom, pepper, cinnamon, vanilla), and Kadathanadan Kalarippayattu martial arts.",
        rating = 4.8f,
        reviewCount = 21400,
        coverResId = null,
        categories = listOf(TravelCategory.WILDLIFE, TravelCategory.NATURE, TravelCategory.ADVENTURE, TravelCategory.FAMILY_FRIENDLY),
        bestTime = BestTimeInfo(
            bestMonths = "September – May",
            weatherSummary = "Crisp forest climate, optimal waterhole wildlife sightings between March and May",
            peakSeason = "October – February",
            offSeason = "June – August",
            expectedCrowd = "High",
            temperatureRange = "15°C – 29°C",
            suggestedDuration = "2–3 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("kerala-thekkady"),
        attractions = listOf(
            Attraction(
                id = "thek-lake-boat-safari",
                destinationId = "kerala-thekkady",
                name = "Periyar Lake Wildlife Boat Safari",
                description = "90-minute double-decker boat cruise through the drowned tree snags of Periyar Lake, providing prime vantage points to observe wild elephant herds, sambar deer, wild boar, and water birds along the lake shores.",
                category = "Wildlife Boat Safari",
                openingTime = "Safaris depart: 07:30 AM, 09:30 AM, 11:15 AM, 01:45 PM, 03:30 PM",
                closingTime = "05:00 PM",
                entryFeeAdult = "Park entry ₹45 (Indians), Boat safari ₹255 – ₹300",
                entryFeeChild = "₹85",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹50",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "First morning cruise at 07:30 AM or 03:30 PM afternoon cruise",
                tips = "Book tickets online in advance via Periyar Tiger Conservation Foundation portal (periyartigerreserve.org)."
            ),
            Attraction(
                id = "thek-bamboo-rafting",
                destinationId = "kerala-thekkady",
                name = "Full-Day Bamboo Rafting & Jungle Trek",
                description = "Dawn-to-dusk eco-tourism adventure combining a 3-hour trek through dense evergreen forests accompanied by armed tribal trackers, followed by bamboo rafting across the remote reaches of Periyar Lake.",
                category = "Eco Trekking & Rafting",
                openingTime = "08:00 AM – 05:00 PM",
                closingTime = "05:00 PM",
                entryFeeAdult = "₹2,500 – ₹3,000 per person (includes guide, gear, breakfast & lunch)",
                recommendedDurationMinutes = 540,
                parkingAvailable = true,
                difficultyLevel = "Moderate to Strenuous",
                familyFriendly = false,
                childrenFriendly = false,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Full-day program starting at 08:00 AM",
                tips = "Leech socks are provided by the forest department; carry extra drinking water."
            ),
            Attraction(
                id = "thek-kadathanadan-kalari",
                destinationId = "kerala-thekkady",
                name = "Kadathanadan Kalari & Kathakali Centre",
                description = "Spectacular evening live demonstration of Kalaripayattu—the world's oldest martial art dating back 3,000 years—featuring sword fighting, urumi (flexible whip blade), and acrobatic fire ring leaps.",
                category = "Martial Arts Performance",
                openingTime = "Shows at 06:00 PM & 07:00 PM",
                closingTime = "08:00 PM",
                entryFeeAdult = "₹300 – ₹400",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "06:00 PM show",
                tips = "The gallery is designed like an authentic subterranean mud-floored Kalari pit."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-thek-spice-village-cghearth",
                destinationId = "kerala-thekkady",
                name = "Spice Village - CGH Earth",
                category = "Eco Luxury Tribal Village Resort",
                minimumPrice = 13000,
                maximumPrice = 26000,
                rating = 4.8f,
                reviewCount = 2800,
                amenities = listOf("Elephant Grass Thatched Cottages", "Organic Spices Garden", "Tiger Trails Restaurant", "Ayurveda"),
                approximatePrice = "Approx. ₹15,000 / night (verify before travel)",
                phone = "+91 484 426 1710",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-thek-cardamom-county",
                destinationId = "kerala-thekkady",
                name = "Cardamom County by Xandari",
                category = "4-Star Eco Resort",
                minimumPrice = 5500,
                maximumPrice = 11000,
                rating = 4.5f,
                reviewCount = 1800,
                amenities = listOf("Swimming Pool", "Organic Farm Walks", "Ayurvedic Spa", "Steps from Tiger Reserve Gate"),
                approximatePrice = "Approx. ₹6,500 / night (verify before travel)",
                phone = "+91 4869 224 501",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Fresh Green Peppercorn Chicken & Bamboo Shoot Curry",
                    isVegetarian = false,
                    description = "Country chicken cooked in fresh unripened green peppercorns, alongside spicy wild bamboo shoot stir-fry.",
                    popularAt = "50's Cafe & Dhyan Dining (Kumily town)"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Madurai" to 140, "Kochi" to 155, "Kottayam" to 110, "Munnar" to 95, "Alappuzha" to 135
            ),
            drivingTimes = mapOf(
                "Madurai" to "3h 30m via Theni & Kumily", "Kochi" to "4h 0m via Kanjirappally", "Munnar" to "3h 0m"
            ),
            roadTripRoute = "Via NH183 through Kanjirappally and Mundakkayam ascending the Western Ghats into Kumily.",
            tollAndParkingNotes = "FASTag tolls on plains; well-paved mountain roads.",
            nearestRailwayStation = "Kottayam (KTYM - 110 km) / Madurai (140 km)",
            nearestAirport = "Madurai International Airport (140 km) / Cochin International (150 km)",
            busTrainFlightOptions = "Buses run from Ernakulam, Kottayam, and Madurai directly to Kumily central bus terminal."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3800,
            foodEstimatePerDay = 1100,
            activitiesTotal = 900,
            travelEstimate = 1600,
            totalEstimateMin = 10000,
            totalEstimateMax = 25000
        )
    )

    val vagamon = Destination(
        id = "kerala-vagamon",
        name = "Vagamon",
        state = "Kerala",
        district = "Idukki",
        tagline = "Rolling Green Pine Valleys & Paragliding Meadows",
        description = "Known as the 'Scotland of Asia' at 1,100 meters, Vagamon is an uncommercialized hill retreat characterized by sweeping velvety green meadows (Vagamon Pine Forest), three sacred hills (Thangal Para, Murugan Para, and Kurisumala), peaceful Christian Cistercian monastery, and annual International Paragliding Grand Prix.",
        rating = 4.6f,
        reviewCount = 8900,
        coverResId = null,
        categories = listOf(TravelCategory.MOUNTAINS, TravelCategory.ADVENTURE, TravelCategory.COUPLES, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "September – May",
            weatherSummary = "Mild cool climate, breezy meadows, morning mists rolling over pine forests",
            peakSeason = "October – February",
            offSeason = "June – July",
            expectedCrowd = "Moderate",
            temperatureRange = "12°C – 24°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createHighAltitudeSeasons("kerala-vagamon"),
        attractions = listOf(
            Attraction(
                id = "vaga-pine-forest",
                destinationId = "kerala-vagamon",
                name = "Vagamon Pine Forest & Meadows",
                description = "Man-made pine sanctuary planted during the British era sloping down deep valleys, accompanied by the Motty hills—rolling bald green grass mounds with panoramic vistas.",
                category = "Forest & Meadows",
                openingTime = "08:30 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "₹20",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 09:30 AM or late afternoon 04:30 PM",
                tips = "Great for quiet walks among tall pine trunks and photography."
            ),
            Attraction(
                id = "vaga-kurisumala",
                destinationId = "kerala-vagamon",
                name = "Kurisumala Ashram & Hill Walk",
                description = "Monastery founded in 1958 by a Belgian Trappist monk and an English Benedictine monk blending Christian liturgy with Indian ascetic traditions, surrounded by high-altitude dairy farms and 14 prayer stations.",
                category = "Spiritual & Scenic Hill",
                openingTime = "07:00 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                difficultyLevel = "Moderate (Pleasant hill walk)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Early morning 07:30 AM",
                tips = "Maintain silence around the monastery chapel."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-vaga-winter-vale",
                destinationId = "kerala-vagamon",
                name = "Winter Vale Green Stay Vagamon",
                category = "Eco Nature Resort",
                minimumPrice = 3800,
                maximumPrice = 7500,
                rating = 4.4f,
                reviewCount = 1100,
                amenities = listOf("Plantation Setting", "Swimming Pool", "Campfire", "Home-Style Kerala Food"),
                approximatePrice = "Approx. ₹4,500 / night (verify before travel)",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Hot Tea & Pazham Pori (Banana Fritters)",
                    isVegetarian = true,
                    description = "Crispy golden ripe plantain fritters served with hot milk tea in the cool mountain mist.",
                    popularAt = "Pine forest entrance tea stalls"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Kottayam" to 65, "Kochi" to 105, "Thekkady" to 45),
            drivingTimes = mapOf("Kottayam" to "1h 45m via Pala", "Kochi" to "3h 0m via Thodupuzha"),
            roadTripRoute = "Via Pala and Erattupetta ascending the scenic Teekoy mountain pass.",
            tollAndParkingNotes = "Narrow but well-tarred 2-lane roads with gentle curves.",
            nearestRailwayStation = "Kottayam (65 km)",
            nearestAirport = "Cochin International Airport (100 km)",
            busTrainFlightOptions = "KSRTC buses run from Kottayam, Erattupetta, and Pala to Vagamon."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3000,
            foodEstimatePerDay = 800,
            activitiesTotal = 400,
            travelEstimate = 1400,
            totalEstimateMin = 6500,
            totalEstimateMax = 15000
        )
    )

    val athirappilly = Destination(
        id = "kerala-athirappilly",
        name = "Athirappilly",
        state = "Kerala",
        district = "Thrissur",
        tagline = "The Niagara of India & 80-Foot Rainforest Waterfalls",
        description = "Nicknamed the 'Niagara of India', Athirappilly is Kerala's largest waterfall: an 80-foot high, 330-foot wide roaring curtain of water cascading over granite shelves on the Chalakudy River. Located within dense riparian rainforests of the Western Ghats home to all four South Indian hornbill species, accompanied by Vazhachal Falls and Thumboormuzhy Butterfly Park.",
        rating = 4.8f,
        reviewCount = 18400,
        coverResId = null,
        categories = listOf(TravelCategory.WATERFALLS, TravelCategory.NATURE, TravelCategory.FAMILY_FRIENDLY, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "September – January (Monsoon fullness peaks July – November)",
            weatherSummary = "Thunderous waterfall volume, misty spray enveloping viewing decks, lush green rainforest canopy",
            peakSeason = "October – January",
            offSeason = "March – May (Water volume reduces)",
            expectedCrowd = "High",
            temperatureRange = "22°C – 31°C",
            suggestedDuration = "1–2 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("kerala-athirappilly"),
        attractions = listOf(
            Attraction(
                id = "athi-waterfalls",
                destinationId = "kerala-athirappilly",
                name = "Athirappilly Waterfalls & Riverbed Trek",
                description = "Magnificent 80-foot cataract featured in movies like 'Baahubali' and 'Dil Se', featuring a paved walking path to the top of the falls and a trail descending down through bamboo groves to the misty riverbed base.",
                category = "Iconic Waterfalls",
                openingTime = "08:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "₹50 (Combined ticket for Athirappilly & Vazhachal)",
                entryFeeChild = "₹15",
                recommendedDurationMinutes = 150,
                parkingAvailable = true,
                parkingFee = "₹40",
                difficultyLevel = "Easy to top deck; Moderate descent to riverbed",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "08:30 AM before tourist crowds or late afternoon 03:30 PM",
                tips = "Bathing/swimming in the river is strictly prohibited due to dangerous hidden currents. Carry raincoats/waterproof covers for cameras due to heavy spray mist."
            ),
            Attraction(
                id = "athi-vazhachal",
                destinationId = "kerala-athirappilly",
                name = "Vazhachal Waterfalls & Riparian Forest",
                description = "Located 5 km upstream, Vazhachal is an inclined rapids cascade surging through natural herbal and medicinal plant reserves with shaded benches and hornbill viewpoints.",
                category = "Waterfalls & Rapids",
                openingTime = "08:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "Included in Athirappilly entrance ticket",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning or afternoon alongside Athirappilly",
                tips = "Keep an eye on the high canopy trees for sightings of the Great Indian Hornbill and Malabar Pied Hornbill."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-athi-rainforest-resort",
                destinationId = "kerala-athirappilly",
                name = "Rainforest Resort Athirapally",
                category = "Luxury Boutique Falls-Facing Resort",
                minimumPrice = 14000,
                maximumPrice = 28000,
                rating = 4.8f,
                reviewCount = 1400,
                amenities = listOf("Direct Unobstructed Views of Waterfalls", "Infinity Pool", "Treehouses", "Fine Dining"),
                approximatePrice = "Approx. ₹16,500 / night (verify before travel)",
                phone = "+91 480 276 9062",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Kerala Meals & Fresh Freshwater Fish Fry",
                    isVegetarian = false,
                    description = "Traditional banana leaf lunch with red matta rice, sambar, avial, and crisp freshwater fish fry.",
                    popularAt = "Local dining halls near the Athirappilly entrance gate"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Cochin Airport" to 40, "Kochi" to 70, "Thrissur" to 55, "Valparai" to 80),
            drivingTimes = mapOf("Cochin Airport" to "1h 15m via Chalakudy", "Thrissur" to "1h 30m"),
            roadTripRoute = "From NH544 at Chalakudy, turning onto the scenic SH21 forest road hugging the Chalakudy River.",
            tollAndParkingNotes = "Smooth 2-lane forest highway. Large designated car parking lots outside Athirappilly gate.",
            nearestRailwayStation = "Chalakudy (CKI - 30 km) / Thrissur (55 km)",
            nearestAirport = "Cochin International Airport (COK - 40 km)",
            busTrainFlightOptions = "KSRTC buses run frequently between Chalakudy KSRTC stand and Athirappilly/Vazhachal."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3500,
            foodEstimatePerDay = 900,
            activitiesTotal = 300,
            travelEstimate = 1200,
            totalEstimateMin = 6500,
            totalEstimateMax = 16000
        )
    )

    val silentValley = Destination(
        id = "kerala-silent-valley",
        name = "Silent Valley National Park",
        state = "Kerala",
        district = "Palakkad",
        tagline = "Last Undisturbed Tropical Rainforest & Lion-Tailed Macaque Sanctuary",
        description = "One of India's most pristine and untouched ecological paradises, Silent Valley spans 90 sq km across the Kundali Hills of the Nilgiri Biosphere. Celebrated for dense virgin rainforests untouched by civilization, absence of the usual cicadas (hence 'Silent Valley'), River Kunthi, and harboring India's largest population of the endangered Lion-tailed Macaque.",
        rating = 4.7f,
        reviewCount = 5200,
        coverResId = null,
        categories = listOf(TravelCategory.WILDLIFE, TravelCategory.NATURE, TravelCategory.ADVENTURE),
        bestTime = BestTimeInfo(
            bestMonths = "November – April",
            weatherSummary = "Clear forest trails, active wildlife sightings; heavy monsoon rains June–September",
            peakSeason = "December – February",
            offSeason = "June – August (May be closed during extreme monsoons)",
            expectedCrowd = "Low (Strictly regulated eco-tourism permits)",
            temperatureRange = "14°C – 28°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("kerala-silent-valley"),
        attractions = listOf(
            Attraction(
                id = "sil-sairandhri-safari",
                destinationId = "kerala-silent-valley",
                name = "Sairandhri Forest Jeep Safari & Watchtower",
                description = "Official Forest Department 23-km guided jeep safari through deep rainforest to the Sairandhri watchtower overlooking the emerald Kunthi river valley and canopy walks.",
                category = "Rainforest Eco Safari",
                openingTime = "08:00 AM – 01:00 PM (Last jeep departs at 01:00 PM)",
                closingTime = "05:00 PM",
                entryFeeAdult = "Jeep safari ₹2,000 – ₹2,500 per vehicle (up to 5 persons) + guide fee ₹200",
                recommendedDurationMinutes = 300,
                parkingAvailable = true,
                difficultyLevel = "Moderate (Rough forest jeep track + 1.5 km trek to river)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "First morning batch at 08:00 AM from Mukkali reception",
                tips = "Entry permits must be obtained in the morning at the Forest Department Information Centre in Mukkali."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-sil-inspection-bungalow",
                destinationId = "kerala-silent-valley",
                name = "Silent Valley Forest Department Eco Lodge (Mukkali)",
                category = "Government Eco Forest Lodge",
                minimumPrice = 1800,
                maximumPrice = 3200,
                rating = 4.3f,
                reviewCount = 420,
                amenities = listOf("Rainforest Surroundings", "Forest Canteen", "Naturalist Assistance"),
                approximatePrice = "Approx. ₹2,200 / night (verify before travel)",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Forest Canteen Kerala Meals",
                    isVegetarian = true,
                    description = "Fresh hot vegetarian meals prepared by local tribal eco-development committee staff at Mukkali.",
                    popularAt = "Mukkali Forest Canteen"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Palakkad" to 60, "Coimbatore" to 75, "Kozhikode" to 110),
            drivingTimes = mapOf("Palakkad" to "1h 45m via Mannarkkad", "Coimbatore" to "2h 15m"),
            roadTripRoute = "Via NH966 to Mannarkkad, then state highway to Mukkali (base camp).",
            tollAndParkingNotes = "Private vehicles are parked at Mukkali base camp; only forest department 4WD jeeps are permitted inside the national park.",
            nearestRailwayStation = "Palakkad Junction (PGT - 60 km)",
            nearestAirport = "Coimbatore International Airport (CJB - 85 km)",
            busTrainFlightOptions = "Buses run from Palakkad and Mannarkkad to Mukkali."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 700,
            activitiesTotal = 700,
            travelEstimate = 1400,
            totalEstimateMin = 5500,
            totalEstimateMax = 12000
        )
    )

    val allHighlandsWildDestinations = listOf(
        munnar,
        wayanad,
        thekkady,
        vagamon,
        athirappilly,
        silentValley
    )
}
