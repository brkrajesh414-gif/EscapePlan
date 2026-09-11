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

object KarnatakaBengaluruMysuruData {

    val bengaluru = Destination(
        id = "karnataka-bengaluru",
        name = "Bengaluru",
        state = "Karnataka",
        district = "Bengaluru Urban",
        tagline = "The Garden City, Tech Capital & Craft Beer Hub of India",
        description = "Bengaluru blends colonial gardens, royal palaces, tech innovation, vibrant live-music scenes, and iconic South Indian tiffin institutions.",
        rating = 4.7f,
        reviewCount = 14500,
        coverResId = null,
        categories = listOf(TravelCategory.WEEKEND_GETAWAYS, TravelCategory.HERITAGE, TravelCategory.FAMILY_FRIENDLY),
        bestTime = BestTimeInfo(
            bestMonths = "September – March",
            weatherSummary = "Pleasant year-round weather with balmy afternoons and cool breezy evenings",
            peakSeason = "October – February",
            offSeason = "April – May (Warmer months up to 34°C)",
            expectedCrowd = "High",
            temperatureRange = "16°C – 29°C",
            suggestedDuration = "2–3 Days"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("karnataka-bengaluru"),
        attractions = listOf(
            Attraction(
                id = "blr-lalbagh",
                destinationId = "karnataka-bengaluru",
                name = "Lalbagh Botanical Garden & Glass House",
                description = "Historical 240-acre botanical haven commissioned by Hyder Ali in 1760, featuring a century-old London Crystal Palace-inspired Glass House.",
                category = "Nature & Heritage",
                openingTime = "06:00 AM",
                closingTime = "07:00 PM",
                entryFeeAdult = "₹25 (Free for morning walkers 6-9 AM)",
                entryFeeChild = "Free below 12 years",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Early morning 06:30 AM or late afternoon",
                tips = "Visit during Republic Day or Independence Day for the world-famous floral sculpture exhibitions."
            ),
            Attraction(
                id = "blr-bangalore-palace",
                destinationId = "karnataka-bengaluru",
                name = "Bangalore Palace",
                description = "Tudor-revival royal residence built in 1878 by the Wadiyar dynasty, boasting fortified towers, gothic stained glass, and wood carvings.",
                category = "Palace & Heritage",
                openingTime = "10:00 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "₹250 (Indians), ₹500 (Foreigners)",
                entryFeeChild = "₹150",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹50",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "11:00 AM",
                tips = "Audio guides are included in the ticket. Walk around the royal durbar hall on the upper floor."
            ),
            Attraction(
                id = "blr-cubbon-park",
                destinationId = "karnataka-bengaluru",
                name = "Cubbon Park & Vidhana Soudha",
                description = "Lush 300-acre green lung in the city center flanked by the Neo-Dravidian granite majesty of Vidhana Soudha and High Court.",
                category = "Park & Architecture",
                openingTime = "06:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "Free",
                entryFeeChild = "Free",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning or Sunday car-free hours",
                tips = "Vehicles are banned on Sundays. Admire the illuminated facade of Vidhana Soudha on Sunday evenings from 6:30 PM."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-blr-taj-west-end",
                destinationId = "karnataka-bengaluru",
                name = "The Taj West End",
                category = "Luxury Heritage Resort",
                minimumPrice = 14000,
                maximumPrice = 30000,
                rating = 4.8f,
                reviewCount = 2800,
                amenities = listOf("20-acre Botanical Gardens", "Colonial Heritage Verandahs", "Outdoor Pool", "Jiva Spa"),
                approximatePrice = "Approx. ₹16,500 / night (verify before travel)",
                phone = "+91 80 6660 5660",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-blr-bloomrooms",
                destinationId = "karnataka-bengaluru",
                name = "Bloomrooms @ Indiranagar",
                category = "Boutique / Mid-Range",
                minimumPrice = 2800,
                maximumPrice = 4500,
                rating = 4.4f,
                reviewCount = 1900,
                amenities = listOf("High-speed WiFi", "Crisp Cloud Beds", "Cafe", "Walkable to metro"),
                approximatePrice = "Approx. ₹3,200 / night (verify before travel)",
                phone = "+91 80 4652 0000",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Benne Masala Dosa (Butter Dosa)",
                    isVegetarian = true,
                    description = "Golden, crispy yet spongy dosa roasted generously in pure white butter, filled with spiced potato palya and served with coconut chutney.",
                    popularAt = "CTR (Shri Sagar - Malleshwaram), Vidyarthi Bhavan (Gandhi Bazaar)"
                ),
                FoodItem(
                    name = "Bisi Bele Bath",
                    isVegetarian = true,
                    description = "Wholesome spiced rice and lentil mash simmered with vegetables, nutmeg, tamarind, and topped with crunchy boondi and pure ghee.",
                    popularAt = "MTR (Lalbagh Road), Maiyas"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Vidyarthi Bhavan",
                    cuisine = "Authentic South Indian Tiffin",
                    rating = 4.7f,
                    isVegFriendly = true,
                    signatureDish = "Crispy Benne Masala Dosa with Thick Chutney",
                    priceForTwo = "₹220",
                    distance = "Gandhi Bazaar, Basavanagudi"
                ),
                RestaurantItem(
                    name = "Toit Brewpub",
                    cuisine = "Craft Brewery & Wood-Fired Pizza",
                    rating = 4.6f,
                    isVegFriendly = true,
                    signatureDish = "Tint-In-Wit Belgian Wheat Ale & Smoked Chicken Pizza",
                    priceForTwo = "₹1,800",
                    distance = "100 Feet Road, Indiranagar"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Hyderabad" to 570, "Bengaluru" to 0, "Chennai" to 345, "Mumbai" to 980,
                "Pune" to 840, "Delhi" to 2150, "Kolkata" to 1860, "Visakhapatnam" to 1010,
                "Vijayawada" to 660, "Kochi" to 535, "Coimbatore" to 365, "Madurai" to 435
            ),
            drivingTimes = mapOf(
                "Hyderabad" to "8h 30m", "Bengaluru" to "0 Min", "Chennai" to "6h 0m", "Mumbai" to "15h 30m",
                "Pune" to "13h 0m", "Kochi" to "9h 30m", "Coimbatore" to "6h 30m", "Madurai" to "7h 30m"
            ),
            roadTripRoute = "Hub of southern India connected by NH44 (Hyderabad-Kanyakumari), NH48 (Mumbai-Pune-Bengaluru), and NH75.",
            tollAndParkingNotes = "FASTag mandatory on all expressways. High-density urban traffic during rush hours (08:30-11:00 AM & 05:30-08:30 PM).",
            nearestRailwayStation = "KSR Bengaluru City (SBC) / Yesvantpur (YPR) / SMVT Bengaluru",
            nearestAirport = "Kempegowda International Airport Bengaluru (BLR)",
            busTrainFlightOptions = "Unmatched flight frequencies globally & pan-India; Vande Bharat trains to Hyderabad, Chennai, Coimbatore, Mysuru, Dharwad, and Madurai."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3200,
            foodEstimatePerDay = 1100,
            activitiesTotal = 800,
            travelEstimate = 1200,
            totalEstimateMin = 7500,
            totalEstimateMax = 22000
        )
    )

    val nandiHills = Destination(
        id = "karnataka-nandi-hills",
        name = "Nandi Hills",
        state = "Karnataka",
        district = "Chikkaballapur",
        tagline = "Ancient Fortress Summit Above the Rolling Clouds",
        description = "Perched at 1,478 meters, Nandi Hills is famed for breathtaking sunrise views, dense sea of morning clouds, Tipu Sultan's summer residence, and century-old temples.",
        rating = 4.5f,
        reviewCount = 9800,
        coverResId = null,
        categories = listOf(TravelCategory.WEEKEND_GETAWAYS, TravelCategory.MOUNTAINS, TravelCategory.ROAD_TRIPS),
        bestTime = BestTimeInfo(
            bestMonths = "September – February",
            weatherSummary = "Misty, foggy mornings with brisk winds and cool evenings",
            peakSeason = "October – January",
            offSeason = "March – May (Afternoons warm up to 32°C)",
            expectedCrowd = "Very High (Weekends)",
            temperatureRange = "15°C – 26°C",
            suggestedDuration = "1 Day / Weekend"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-nandi-hills"),
        attractions = listOf(
            Attraction(
                id = "nandi-sunrise-viewpoint",
                destinationId = "karnataka-nandi-hills",
                name = "Nandi Sunrise Viewpoint & Cloud Bed",
                description = "Legendary cliff edge viewpoint where visitors witness golden dawn rays piercing a surreal blanket of thick white mist.",
                category = "Scenic Viewpoint",
                openingTime = "06:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "₹20",
                entryFeeChild = "Free below 12 years",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹100 (Cars), ₹30 (Two-wheelers)",
                difficultyLevel = "Easy to Moderate",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "06:00 AM – 07:15 AM",
                tips = "Hill gates open at 06:00 AM. Start from Bengaluru by 04:15 AM on weekends to avoid massive entrance queues."
            ),
            Attraction(
                id = "nandi-tipu-drop",
                destinationId = "karnataka-nandi-hills",
                name = "Tipu's Drop & Summer Lodge",
                description = "A dramatic 600-meter sheer cliff precipice with historical legends, surrounded by Tipu Sultan's fortified ramparts.",
                category = "Heritage & Viewpoint",
                openingTime = "06:00 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "Included in hill entry",
                recommendedDurationMinutes = 45,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Morning or late afternoon",
                tips = "Strong wind gusts at the edge; keep children close behind safety barricades."
            ),
            Attraction(
                id = "nandi-bhoga-nandeeshwara",
                destinationId = "karnataka-nandi-hills",
                name = "Bhoga Nandeeshwara Temple (Nandi Village)",
                description = "Stunning 9th-century Nolamba-Chola-Hoysala temple complex at the base of the hill featuring ornate stone pillars and a stepped holy Kalyani pond.",
                category = "Spiritual & Heritage",
                openingTime = "06:30 AM",
                closingTime = "07:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                parkingFee = "₹20",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "After descent from hill around 09:30 AM",
                tips = "One of Karnataka's oldest intact temples. The reflective waters in the stepped tank offer pristine photo opportunities."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-nandi-kstdc-pine",
                destinationId = "karnataka-nandi-hills",
                name = "KSTDC Hotel Mayura Pine Top",
                category = "Government Hilltop Stay",
                minimumPrice = 2200,
                maximumPrice = 3800,
                rating = 3.9f,
                reviewCount = 820,
                amenities = listOf("Top-of-hill Access before gates open", "Restaurant", "Panoramic Valley Balconies"),
                approximatePrice = "Approx. ₹2,600 / night (verify before travel)",
                website = "https://kstdc.co",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-nandi-jw-marriott",
                destinationId = "karnataka-nandi-hills",
                name = "JW Marriott Bengaluru Prestige Golfshire Resort & Spa",
                category = "Ultra Luxury Golf Resort",
                minimumPrice = 18000,
                maximumPrice = 36000,
                rating = 4.8f,
                reviewCount = 1400,
                amenities = listOf("Championship 18-hole Golf Course", "Luxury Spa", "Infinity Pool overlooking Nandi Hills"),
                approximatePrice = "Approx. ₹22,000 / night (verify before travel)",
                phone = "+91 80 4344 4444",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Nandi Highway Hot Thatte Idli",
                    isVegetarian = true,
                    description = "Plate-sized pillowy steamed rice cakes drenched in spiced red chutney podi and freshly melted butter.",
                    popularAt = "Highway tiffin dhabas on Bellary Road / Devanahalli"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Nandi Upachar",
                    cuisine = "Pure Veg South Indian Highway Restaurant",
                    rating = 4.4f,
                    isVegFriendly = true,
                    signatureDish = "Ghee Thatte Idli with Podi & Filter Kaapi",
                    priceForTwo = "₹350",
                    distance = "Devanahalli Highway Junction"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Hyderabad" to 515, "Bengaluru" to 60, "Chennai" to 365, "Mumbai" to 930,
                "Pune" to 790, "Delhi" to 2100, "Kolkata" to 1820, "Visakhapatnam" to 960,
                "Vijayawada" to 615, "Kochi" to 590, "Coimbatore" to 420, "Madurai" to 490
            ),
            drivingTimes = mapOf(
                "Bengaluru" to "1h 30m", "Hyderabad" to "7h 45m", "Chennai" to "6h 30m"
            ),
            roadTripRoute = "Via Bellary Road (NH44) through Hebbal, Yelahanka, and Devanahalli bypass, then SH104 ascending Nandi ghat road.",
            tollAndParkingNotes = "Devanahalli toll on NH44 (~₹115). Nandi ghat road is paved two-lane with 40 hairpin turns; drive with low gears.",
            nearestRailwayStation = "Chikkaballapur (15 km) / Yelahanka Junction (42 km)",
            nearestAirport = "Kempegowda International Airport (BLR - 35 km)",
            busTrainFlightOptions = "Direct KSRTC buses from Majestic (Kempegowda Bus Station) and BMTC sunrise specials on weekends."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 800,
            activitiesTotal = 400,
            travelEstimate = 1000,
            totalEstimateMin = 3500,
            totalEstimateMax = 12000
        )
    )

    val skandagiri = Destination(
        id = "karnataka-skandagiri",
        name = "Skandagiri",
        state = "Karnataka",
        district = "Chikkaballapur",
        tagline = "The Legendary Night Trek Above a Sea of Clouds",
        description = "Also known as Kalavara Durga, Skandagiri is India's most celebrated night-trekking summit, where hikers ascend under moonlight to witness dawn break over an endless ocean of clouds.",
        rating = 4.6f,
        reviewCount = 5200,
        coverResId = null,
        categories = listOf(TravelCategory.ADVENTURE, TravelCategory.MOUNTAINS, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Chilly nights at 10°C-14°C, clear starry skies, and surreal morning cloud-beds",
            peakSeason = "November – February",
            offSeason = "June – August (Slippery wet rocks in monsoon)",
            expectedCrowd = "High (Advance permits mandatory)",
            temperatureRange = "12°C – 28°C",
            suggestedDuration = "1 Day (Night Trek)"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-skandagiri"),
        attractions = listOf(
            Attraction(
                id = "skandagiri-trek",
                destinationId = "karnataka-skandagiri",
                name = "Kalavara Durga Sunrise Trek",
                description = "Thrilling 8 km round-trip trek ascending through wilderness, dilapidated fort gates, and boulders to an altitude of 1,450 meters.",
                category = "Adventure & Trekking",
                openingTime = "03:30 AM (Morning batch) / 08:00 AM (Day batch)",
                closingTime = "12:00 PM",
                entryFeeAdult = "₹250 (Forest Department online permit mandatory)",
                entryFeeChild = "Not recommended below 10 years",
                recommendedDurationMinutes = 300,
                parkingAvailable = true,
                parkingFee = "₹50",
                difficultyLevel = "Moderate (Steep rocky ascent)",
                familyFriendly = false,
                childrenFriendly = false,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Sunrise 05:45 AM – 06:45 AM",
                tips = "Book permit in advance at myecotrip.com. Carry headlamps, 2 liters of water, warm windcheater, and energy bars."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-skandagiri-homestay",
                destinationId = "karnataka-skandagiri",
                name = "Kalavara Basecamp Homestay",
                category = "Trekker Basecamp",
                minimumPrice = 1600,
                maximumPrice = 3000,
                rating = 4.2f,
                reviewCount = 310,
                amenities = listOf("Trek Guide Assistance", "Campfire", "Homecooked Kannada Meals"),
                approximatePrice = "Approx. ₹1,800 / night (verify before travel)",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Hot Ragi Mudde with Bassaru",
                    isVegetarian = true,
                    description = "Nutritious steamed finger-millet balls served with fragrant dill leaf and lentil broth.",
                    popularAt = "Local village messes near Kalavara"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Hyderabad" to 510, "Bengaluru" to 68, "Chennai" to 370),
            drivingTimes = mapOf("Bengaluru" to "1h 45m", "Hyderabad" to "7h 30m"),
            roadTripRoute = "NH44 from Bengaluru towards Chikkaballapur, then turn left towards Kalavara village.",
            tollAndParkingNotes = "FASTag toll on NH44. Base parking at Papagni Mutt / Forest checkpost.",
            nearestRailwayStation = "Chikkaballapur (7 km)",
            nearestAirport = "Bengaluru Kempegowda International (42 km)",
            busTrainFlightOptions = "Drive or hire a cab from Bengaluru departing around 01:30 AM to reach base before 03:30 AM."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 1800,
            foodEstimatePerDay = 600,
            activitiesTotal = 350,
            travelEstimate = 1200,
            totalEstimateMin = 2800,
            totalEstimateMax = 6500
        )
    )

    val savandurga = Destination(
        id = "karnataka-savandurga",
        name = "Savandurga",
        state = "Karnataka",
        district = "Ramanagara",
        tagline = "Asia's Largest Monolith Rock & Fortified Citadel",
        description = "Rising 1,226 meters above sea level, Savandurga comprises twin peaks (Karigudda and Biligudda) forming one of the largest single monolith rock formations in the world, flanked by the Arkavathi river forests.",
        rating = 4.4f,
        reviewCount = 3800,
        coverResId = null,
        categories = listOf(TravelCategory.ADVENTURE, TravelCategory.WEEKEND_GETAWAYS, TravelCategory.NATURE),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Dry breezy weather; rocks become scorching in summer and slippery in monsoon",
            peakSeason = "November – February",
            offSeason = "April – May / Monsoon downpours",
            expectedCrowd = "Moderate",
            temperatureRange = "17°C – 30°C",
            suggestedDuration = "1 Day"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("karnataka-savandurga"),
        attractions = listOf(
            Attraction(
                id = "savan-monolith-trek",
                destinationId = "karnataka-savandurga",
                name = "Biligudda Monolith Trek",
                description = "Challenging bare-granite rock scramble passing ruined fortifications of Kempe Gowda to the hilltop Nandi pavilion.",
                category = "Adventure Trek",
                openingTime = "06:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 240,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Challenging (Steep rock friction walking)",
                familyFriendly = false,
                childrenFriendly = false,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Start early by 06:30 AM",
                tips = "Wear shoes with exceptional rubber grip. Never attempt during rainfall as wet granite becomes dangerously slick."
            ),
            Attraction(
                id = "savan-manchanabele",
                destinationId = "karnataka-savandurga",
                name = "Manchanabele Dam & Reservoir",
                description = "Serene backwater reservoir formed across the Arkavathi river with red mud trails and birdwatching.",
                category = "Lakes & Water",
                openingTime = "09:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "₹20",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Late afternoon 04:00 PM",
                tips = "Swimming is strictly prohibited due to deep silt undertows."
            )
        ),
        stays = emptyList(),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Hot Mysore Pak & Maddur Vada",
                    isVegetarian = true,
                    description = "Crunchy onion and semolina savory fritters and ghee-rich sweets.",
                    popularAt = "Highway joints near Magadi"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Bengaluru" to 55, "Mysuru" to 125, "Hyderabad" to 620),
            drivingTimes = mapOf("Bengaluru" to "1h 30m", "Mysuru" to "2h 45m"),
            roadTripRoute = "From Bengaluru via Magadi Road (SH85) through Machohalli and Tavarekere.",
            tollAndParkingNotes = "Minimal toll; scenic state highway with village sections.",
            nearestRailwayStation = "Magadi (12 km) / Bengaluru City (50 km)",
            nearestAirport = "Bengaluru Kempegowda International (85 km)",
            busTrainFlightOptions = "Regular buses connect Majestic to Magadi, from where autos run to Savandurga base."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2000,
            foodEstimatePerDay = 600,
            activitiesTotal = 200,
            travelEstimate = 900,
            totalEstimateMin = 2200,
            totalEstimateMax = 5000
        )
    )

    val bannerghatta = Destination(
        id = "karnataka-bannerghatta",
        name = "Bannerghatta",
        state = "Karnataka",
        district = "Bengaluru Urban",
        tagline = "Bengaluru's Wilderness Safari & Butterfly Oasis",
        description = "A comprehensive 260-sq-km national park on Bengaluru's southern edge, featuring protected tiger/lion safaris, India's first butterfly conservatory, and elephant sanctuaries.",
        rating = 4.3f,
        reviewCount = 8900,
        coverResId = null,
        categories = listOf(TravelCategory.FAMILY_FRIENDLY, TravelCategory.WILDLIFE, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "September – March",
            weatherSummary = "Pleasant woodland microclimate, active animals during cooler morning hours",
            peakSeason = "October – January",
            offSeason = "April – May (Warm summer afternoons)",
            expectedCrowd = "Very High (Weekends & School Holidays)",
            temperatureRange = "18°C – 31°C",
            suggestedDuration = "1 Day"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("karnataka-bannerghatta"),
        attractions = listOf(
            Attraction(
                id = "bnp-grand-safari",
                destinationId = "karnataka-bannerghatta",
                name = "Grand Wildlife Safari (AC Bus / Jeep)",
                description = "Protected 8 km drive through fenced natural habitats to witness Bengal tigers, Asiatic lions, sloth bears, and white tigers roaming free.",
                category = "Wildlife Safari",
                openingTime = "09:30 AM",
                closingTime = "04:30 PM (Closed Tuesdays)",
                entryFeeAdult = "₹350 (Non-AC Safari), ₹570 (AC Bus Safari)",
                entryFeeChild = "₹200",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹60",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "First morning batch 09:30 AM",
                tips = "Book combo tickets (Zoo + Safari + Butterfly Park) online beforehand to skip 1-hour ticket counter lines."
            ),
            Attraction(
                id = "bnp-butterfly-park",
                destinationId = "karnataka-bannerghatta",
                name = "Butterfly Park & Dome Conservatory",
                description = "Enclosed 10,000-sq-ft polycarbonate greenhouse supporting a tropical environment with over 30 vibrant butterfly species.",
                category = "Nature & Ecology",
                openingTime = "09:30 AM",
                closingTime = "05:00 PM (Closed Tuesdays)",
                entryFeeAdult = "₹50 (Included in combo tickets)",
                recommendedDurationMinutes = 45,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Sunny midday when butterflies are actively fluttering",
                tips = "Walk gently along the landscaped nectar trails to observe cocoon metamorphosis."
            )
        ),
        stays = emptyList(),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "South Indian Thali & Ice Creams",
                    isVegetarian = true,
                    description = "Fast service vegetarian meals and snacks.",
                    popularAt = "KSTDC Mayura restaurant inside park campus"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Bengaluru" to 22, "Mysuru" to 140, "Chennai" to 330),
            drivingTimes = mapOf("Bengaluru" to "45m", "Mysuru" to "2h 30m"),
            roadTripRoute = "Via Bannerghatta Main Road or NICE Expressway to Bannerghatta circle exit.",
            tollAndParkingNotes = "NICE Road toll (~₹65); large supervised park vehicle lot.",
            nearestRailwayStation = "Karmelaram (20 km) / KSR Bengaluru (24 km)",
            nearestAirport = "Bengaluru Airport (65 km)",
            busTrainFlightOptions = "Direct BMTC AC Volvo bus route 365 runs every 10 minutes from Majestic Kempegowda Bus Station."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 600,
            activitiesTotal = 700,
            travelEstimate = 500,
            totalEstimateMin = 2500,
            totalEstimateMax = 6000
        )
    )

    val ramanagara = Destination(
        id = "karnataka-ramanagara",
        name = "Ramanagara",
        state = "Karnataka",
        district = "Ramanagara",
        tagline = "The Sholay Rocks, Silk City & Bouldering Playground",
        description = "Famed across India as 'Ramgarh' from the iconic movie Sholay, Ramanagara features dramatic towering granite boulders, India's only vulture sanctuary, and Asia's largest silk cocoon market.",
        rating = 4.4f,
        reviewCount = 4100,
        coverResId = null,
        categories = listOf(TravelCategory.ADVENTURE, TravelCategory.WEEKEND_GETAWAYS, TravelCategory.ROAD_TRIPS),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Pleasant weather, ideal friction on granite rocks for trekking and climbing",
            peakSeason = "November – February",
            offSeason = "April – June (Hot sun on rocks)",
            expectedCrowd = "Moderate",
            temperatureRange = "18°C – 32°C",
            suggestedDuration = "1 Day"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("karnataka-ramanagara"),
        attractions = listOf(
            Attraction(
                id = "ram-ramadevara-betta",
                destinationId = "karnataka-ramanagara",
                name = "Ramadevara Betta & Vulture Sanctuary",
                description = "Scenic 400-step ascent to a 1,000-year-old temple surrounded by rocky hills where critically endangered Long-billed Vultures nest.",
                category = "Nature & Cinema Heritage",
                openingTime = "09:00 AM",
                closingTime = "04:30 PM",
                entryFeeAdult = "₹25",
                entryFeeChild = "₹10",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy to Moderate (Stepped path)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Morning before 11:00 AM",
                tips = "Look out for nesting vultures on the vertical cliffs; bring binoculars."
            )
        ),
        stays = emptyList(),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Maddur Vada",
                    isVegetarian = true,
                    description = "Crispy, golden-fried savoury snack made with rice flour, semolina, onions, curry leaves, and green chillies.",
                    popularAt = "Maddur Tiffany's on highway"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Bengaluru" to 48, "Mysuru" to 95, "Hyderabad" to 620),
            drivingTimes = mapOf("Bengaluru" to "50m via Bengaluru-Mysuru Expressway", "Mysuru" to "1h 15m"),
            roadTripRoute = "Via the modern 10-lane Bengaluru-Mysuru Expressway (NH275).",
            tollAndParkingNotes = "Expressway toll (~₹165). Two-wheelers and autos prohibited on main carriageway.",
            nearestRailwayStation = "Ramanagaram (RMGM - 3 km)",
            nearestAirport = "Bengaluru Kempegowda International (85 km)",
            busTrainFlightOptions = "Frequent passenger and express trains from Bengaluru to Mysuru stop at Ramanagaram station."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2200,
            foodEstimatePerDay = 600,
            activitiesTotal = 300,
            travelEstimate = 800,
            totalEstimateMin = 2000,
            totalEstimateMax = 5500
        )
    )

    val kanakapura = Destination(
        id = "karnataka-kanakapura",
        name = "Kanakapura",
        state = "Karnataka",
        district = "Ramanagara",
        tagline = "Riverside Escapes, Gushing Cascades & Adventure Camps",
        description = "Nestled along the Arkavathi and Cauvery river basins, Kanakapura is the hub for rustic weekend retreats, river kayaking, Chunchi Falls, and Mekedatu gorge.",
        rating = 4.3f,
        reviewCount = 3300,
        coverResId = null,
        categories = listOf(TravelCategory.WEEKEND_GETAWAYS, TravelCategory.ADVENTURE, TravelCategory.NATURE),
        bestTime = BestTimeInfo(
            bestMonths = "September – February",
            weatherSummary = "Post-monsoon river flows, lush greeneries, pleasant days",
            peakSeason = "October – January",
            offSeason = "April – May (Dry riverbeds)",
            expectedCrowd = "Moderate",
            temperatureRange = "19°C – 32°C",
            suggestedDuration = "1–2 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-kanakapura"),
        attractions = listOf(
            Attraction(
                id = "kanaka-chunchi-falls",
                destinationId = "karnataka-kanakapura",
                name = "Chunchi Falls",
                description = "Cascading 50-foot tiered waterfall on the Arkavathi river carving through deep rocky gorges surrounded by deciduous woods.",
                category = "Waterfalls",
                openingTime = "08:30 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "₹30 parking fee",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                difficultyLevel = "Moderate (Rocky hike down)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Morning or 03:30 PM",
                tips = "Avoid swimming in the gorge as deep undercurrents and submerged rocks are dangerous."
            ),
            Attraction(
                id = "kanaka-mekedatu-sangama",
                destinationId = "karnataka-kanakapura",
                name = "Sangama & Mekedatu (Goat's Leap)",
                description = "Confluence of Arkavathi and Cauvery rivers at Sangama, followed by a dramatic narrow gorge where the raging river constricts into a 10-meter crevice.",
                category = "River & Canyon",
                openingTime = "08:30 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "Coracle ride ₹50, Forest bus ₹30",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                difficultyLevel = "Moderate",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Morning hours",
                tips = "Coracle boats ferry visitors across the shallow riverbed at Sangama to access the Mekedatu bus."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-kanaka-camp",
                destinationId = "karnataka-kanakapura",
                name = "Discovery Village Kanakapura",
                category = "Adventure Resort",
                minimumPrice = 3800,
                maximumPrice = 7000,
                rating = 4.3f,
                reviewCount = 650,
                amenities = listOf("Rope Activities", "Kayaking", "Cottages & Luxury Tents", "Buffet Dining"),
                approximatePrice = "Approx. ₹4,500 / night (verify before travel)",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Ragi Rotti with Avarekalu Saaru",
                    isVegetarian = true,
                    description = "Hand-patted roasted finger-millet flatbread served with fresh seasonal hyacinth bean curry.",
                    popularAt = "Village highway canteens on Kanakapura Road"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Bengaluru" to 62, "Mysuru" to 110, "Chennai" to 360),
            drivingTimes = mapOf("Bengaluru" to "1h 30m", "Mysuru" to "2h 30m"),
            roadTripRoute = "Via Kanakapura Road (NH209 / NH948) through Art of Living ashram, Harohalli, and Kanakapura town.",
            tollAndParkingNotes = "Minimal toll; four-laned highway up to Kanakapura bypass.",
            nearestRailwayStation = "Bengaluru City (62 km)",
            nearestAirport = "Bengaluru Kempegowda (98 km)",
            busTrainFlightOptions = "KSRTC buses leave every 15 minutes from K.R. Market (Bengaluru) to Kanakapura."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3000,
            foodEstimatePerDay = 800,
            activitiesTotal = 600,
            travelEstimate = 900,
            totalEstimateMin = 3800,
            totalEstimateMax = 9000
        )
    )

    val mysuru = Destination(
        id = "karnataka-mysuru",
        name = "Mysuru",
        state = "Karnataka",
        district = "Mysuru",
        tagline = "The Royal City of Palaces, Sandalwood & Silk",
        description = "Former capital of the Kingdom of Mysore, famed for the grand Indo-Saracenic Mysore Palace, centuries of Wadiyar royal patronages, Dasara grand pageantry, and world-class silk and sandalwood crafts.",
        rating = 4.8f,
        reviewCount = 18200,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.FAMILY_FRIENDLY, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "September – March",
            weatherSummary = "Mild sunny days, pleasant temperatures, electric Dasara festival atmosphere in Oct",
            peakSeason = "October – January",
            offSeason = "April – May (Summers reach 35°C)",
            expectedCrowd = "Very High (Dasara & Weekends)",
            temperatureRange = "17°C – 31°C",
            suggestedDuration = "2–3 Days"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("karnataka-mysuru"),
        attractions = listOf(
            Attraction(
                id = "mys-palace",
                destinationId = "karnataka-mysuru",
                name = "Mysore Palace (Amba Vilas)",
                description = "Magnificent three-storey stone palace designed by Henry Irwin featuring domes of fine ochre marble, stained-glass ceilings, and 97,000 bulbs illuminating on Sunday evenings.",
                category = "Palace & Heritage",
                openingTime = "10:00 AM",
                closingTime = "05:30 PM (Illumination Sun/Holidays 07:00 PM – 07:45 PM)",
                entryFeeAdult = "₹100 (Indians), ₹400 (Foreigners)",
                entryFeeChild = "₹50 (10-18 yrs), Free below 10",
                recommendedDurationMinutes = 150,
                parkingAvailable = true,
                parkingFee = "₹50",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "10:30 AM for interior tour; 06:45 PM for Sunday exterior illumination",
                tips = "Footwear must be deposited at the outer counter. Do not miss the sound & light show in the evening."
            ),
            Attraction(
                id = "mys-chamundi-hill",
                destinationId = "karnataka-mysuru",
                name = "Chamundi Hill & Sri Chamundeshwari Temple",
                description = "Prominent 1,000-meter hilltop shrine dedicated to Goddess Chamundeshwari, guardian deity of Mysore, accompanied by a colossal monolithic Nandi statue.",
                category = "Spiritual & Viewpoint",
                openingTime = "07:30 AM",
                closingTime = "09:00 PM",
                entryFeeAdult = "Free (Special darshan ₹100)",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹40",
                difficultyLevel = "Easy by road (or 1,000 steps climb)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = false,
                bestTimeOfDay = "Early morning 07:30 AM or sunset panoramic city view",
                tips = "Watch out for mischievous hill monkeys. View the 16-foot monolithic black granite Nandi halfway down the hill."
            ),
            Attraction(
                id = "mys-brindavan-gardens",
                destinationId = "karnataka-mysuru",
                name = "Brindavan Gardens & KRS Dam",
                description = "Expansive 60-acre terraced garden laid out across the Krishna Raja Sagara dam with fountains, topiary, and illuminated musical fountain shows.",
                category = "Gardens & Leisure",
                openingTime = "06:30 AM",
                closingTime = "09:00 PM (Musical fountain 07:00 PM – 08:00 PM)",
                entryFeeAdult = "₹50",
                entryFeeChild = "₹10",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹50",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "05:30 PM to catch sunset followed by the illuminated fountain show",
                tips = "Boating across the reservoir is available till 06:00 PM."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-mys-lalitha-mahal",
                destinationId = "karnataka-mysuru",
                name = "Lalitha Mahal Palace Hotel",
                category = "Heritage Luxury Palace",
                minimumPrice = 8500,
                maximumPrice = 19000,
                rating = 4.5f,
                reviewCount = 2100,
                amenities = listOf("Italian Marble Grand Staircase", "Royal Banquet Hall", "Sweeping Chamundi Hill Views"),
                approximatePrice = "Approx. ₹9,500 / night (verify before travel)",
                phone = "+91 821 257 1265",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-mys-grand-mercura",
                destinationId = "karnataka-mysuru",
                name = "Grand Mercure Mysuru",
                category = "Upscale Modern Hotel",
                minimumPrice = 4500,
                maximumPrice = 8500,
                rating = 4.6f,
                reviewCount = 3100,
                amenities = listOf("Rooftop Pool", "Spa", "Multi-cuisine Dining", "Kids Play Area"),
                approximatePrice = "Approx. ₹5,200 / night (verify before travel)",
                phone = "+91 821 402 1212",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Mylari Butter Masala Dosa",
                    isVegetarian = true,
                    description = "Ultra-soft, melt-in-the-mouth white dosa smeared with secret herb-infused butter palya and dollops of fresh white butter.",
                    popularAt = "Original Vinayaka Mylari (Nazarbad)"
                ),
                FoodItem(
                    name = "Original Mysore Pak",
                    isVegetarian = true,
                    description = "Legendary melt-in-mouth confection made of roasted chickpea flour, sugar syrup, and copious quantities of bubbling pure ghee.",
                    popularAt = "Guru Sweets (Market Road - descendants of the royal palace inventor)"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Hotel Vinayaka Mylari",
                    cuisine = "Authentic Mysore Dosa",
                    rating = 4.7f,
                    isVegFriendly = true,
                    signatureDish = "Mylari Sagu Dosa with Coconut Chutney & Filter Coffee",
                    priceForTwo = "₹180",
                    distance = "Nazarbad Main Road"
                ),
                RestaurantItem(
                    name = "Guru Sweet Mart",
                    cuisine = "Royal Heritage Confectionery",
                    rating = 4.8f,
                    isVegFriendly = true,
                    signatureDish = "Warm Ghee Mysore Pak",
                    priceForTwo = "₹250",
                    distance = "Near Devaraja Market"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Hyderabad" to 710, "Bengaluru" to 142, "Chennai" to 485, "Mumbai" to 1080,
                "Pune" to 940, "Delhi" to 2290, "Kolkata" to 2000, "Visakhapatnam" to 1150,
                "Vijayawada" to 800, "Kochi" to 410, "Coimbatore" to 200, "Madurai" to 345
            ),
            drivingTimes = mapOf(
                "Bengaluru" to "1h 45m via Expressway", "Hyderabad" to "10h 30m", "Chennai" to "7h 45m", "Coimbatore" to "4h 30m"
            ),
            roadTripRoute = "Via the world-class Bengaluru-Mysuru 10-lane expressway (NH275) with direct flyovers bypassing all towns.",
            tollAndParkingNotes = "FASTag expressway toll (~₹330). Ample parking at Palace South Gate and Chamundi foothill.",
            nearestRailwayStation = "Mysuru Junction (MYS - 2 km)",
            nearestAirport = "Mysore Airport (MYQ - Mandakalli) / Bengaluru BLR (185 km)",
            busTrainFlightOptions = "High-speed Vande Bharat and Shatabdi express trains connect Bengaluru to Mysuru in just 70-80 minutes."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2800,
            foodEstimatePerDay = 900,
            activitiesTotal = 600,
            travelEstimate = 1200,
            totalEstimateMin = 6500,
            totalEstimateMax = 18000
        )
    )

    val coorg = Destination(
        id = "karnataka-coorg",
        name = "Coorg (Kodagu)",
        state = "Karnataka",
        district = "Kodagu",
        tagline = "The Scotland of India & Coffee Plantation Haven",
        description = "Draped in emerald green mist along the Western Ghats, Coorg is world-renowned for shade-grown Arabica/Robusta coffee estates, fragrant spice orchards, martial Kodava culture, and roaring waterfalls.",
        rating = 4.8f,
        reviewCount = 19400,
        coverResId = null,
        categories = listOf(TravelCategory.COUPLES, TravelCategory.NATURE, TravelCategory.WEEKEND_GETAWAYS, TravelCategory.ROAD_TRIPS),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Cool misty mornings, refreshing climate, fragrant coffee blossoms in March",
            peakSeason = "November – February",
            offSeason = "June – August (Heavy southwest monsoon)",
            expectedCrowd = "High",
            temperatureRange = "14°C – 26°C",
            suggestedDuration = "3–4 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-coorg"),
        attractions = listOf(
            Attraction(
                id = "coorg-abbey-falls",
                destinationId = "karnataka-coorg",
                name = "Abbey Falls",
                description = "Gushing 70-foot waterfall cascading between private coffee plantations and spice estates, viewed from a hanging pedestrian bridge.",
                category = "Waterfalls",
                openingTime = "09:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "₹15",
                entryFeeChild = "Free below 5 years",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                parkingFee = "₹40",
                difficultyLevel = "Easy to Moderate (200 paved steps down through coffee estate)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "10:00 AM or 03:30 PM",
                tips = "Swimming is strictly banned. The hanging bridge offers the best wide-angle photography."
            ),
            Attraction(
                id = "coorg-rajas-seat",
                destinationId = "karnataka-coorg",
                name = "Raja's Seat (Madikeri)",
                description = "Historic seasonal garden pavilion where the Kings of Kodagu watched crimson sunsets over mist-draped Western Ghat valley layers.",
                category = "Scenic Viewpoint",
                openingTime = "06:00 AM",
                closingTime = "08:00 PM",
                entryFeeAdult = "₹10",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "05:30 PM – 06:45 PM for sunset and musical fountains",
                tips = "Toy train ride for children operates alongside the garden."
            ),
            Attraction(
                id = "coorg-namdroling",
                destinationId = "karnataka-coorg",
                name = "Namdroling Monastery (Golden Temple, Bylakuppe)",
                description = "The largest Nyingma Tibetan teaching center outside Tibet, featuring 40-foot gilded statues of Buddha Shakyamuni, Padmasambhava, and Amitayus with vibrant Tibetan murals.",
                category = "Spiritual & Culture",
                openingTime = "09:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "01:00 PM (catch monks chanting) or 04:30 PM",
                tips = "Remove shoes at the temple entrance. Visit the Tibetan refugee bazaar outside for authentic handmade momos and prayer flags."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-coorg-taj-madikeri",
                destinationId = "karnataka-coorg",
                name = "Taj Madikeri Resort & Spa",
                category = "Ultra Luxury Rainforest Resort",
                minimumPrice = 22000,
                maximumPrice = 48000,
                rating = 4.9f,
                reviewCount = 3400,
                amenities = listOf("180-acre Rainforest Sanctuary", "Heated Indoor Pool", "Jiva Grande Spa", "Private Valley Villas"),
                approximatePrice = "Approx. ₹25,000 / night (verify before travel)",
                phone = "+91 8272 665 800",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-coorg-plantation-homestay",
                destinationId = "karnataka-coorg",
                name = "Evolve Back Coorg (Orange County)",
                category = "Luxury Plantation Resort",
                minimumPrice = 28000,
                maximumPrice = 55000,
                rating = 4.9f,
                reviewCount = 2900,
                amenities = listOf("Private Pool Villas", "Coffee & Spice Trail", "Coracle Rides", "Ayurvedic Village"),
                approximatePrice = "Approx. ₹32,000 / night (verify before travel)",
                phone = "+91 80 4191 1122",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-coorg-heritage-homestay",
                destinationId = "karnataka-coorg",
                name = "Club Mahindra Madikeri",
                category = "Premium Family Resort",
                minimumPrice = 6500,
                maximumPrice = 12000,
                rating = 4.5f,
                reviewCount = 4100,
                amenities = listOf("Coffee Plantation Walk", "Adventure Zone", "2 Swimming Pools", "Multi-cuisine Buffet"),
                approximatePrice = "Approx. ₹7,500 / night (verify before travel)",
                phone = "+91 8272 221 114",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Coorg Pandi Curry & Kadambuttu",
                    isVegetarian = false,
                    description = "Signature Kodava pork curry slow-simmered in freshly roasted aromatic spice blend and sour wild Kachampuli vinegar, paired with steamed rice dumplings.",
                    popularAt = "Coorg Cuisine (Madikeri), Raintree Restaurant"
                ),
                FoodItem(
                    name = "Akki Rotti with Bamboo Shoot Curry (Kani Curry)",
                    isVegetarian = true,
                    description = "Crispy rice flatbreads served with tender young forest bamboo shoot curry and spicy bird's eye chilli chutney.",
                    popularAt = "Kodava traditional homestays"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Coorg Cuisine",
                    cuisine = "Authentic Kodava Tribal Specialities",
                    rating = 4.6f,
                    isVegFriendly = true,
                    signatureDish = "Pandi Curry with Kadambuttu & Akki Rotti",
                    priceForTwo = "₹650",
                    distance = "Opposite Main Bus Stand, Madikeri"
                ),
                RestaurantItem(
                    name = "Raintree",
                    cuisine = "Heritage Continental & Coorg Fine Dining",
                    rating = 4.5f,
                    isVegFriendly = true,
                    signatureDish = "Claypot Coorg Pepper Curry & Filter Coffee Tiramisu",
                    priceForTwo = "₹1,200",
                    distance = "Pension Lane, Madikeri"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Hyderabad" to 825, "Bengaluru" to 255, "Chennai" to 595, "Mumbai" to 990,
                "Pune" to 850, "Delhi" to 2380, "Kolkata" to 2120, "Visakhapatnam" to 1270,
                "Vijayawada" to 915, "Kochi" to 365, "Coimbatore" to 315, "Madurai" to 460
            ),
            drivingTimes = mapOf(
                "Bengaluru" to "4h 45m via Mysuru Expressway & Kushalnagar",
                "Mysuru" to "2h 30m",
                "Hyderabad" to "13h 0m",
                "Mangaluru" to "3h 15m"
            ),
            roadTripRoute = "NH275 from Bengaluru to Mysuru Expressway, then through Hunsur, Kushalnagar, and ascending to Madikeri.",
            tollAndParkingNotes = "FASTag tolls on Bengaluru-Mysuru section. Beautiful winding mountain ghats from Kushalnagar to Madikeri with scenic estate overlooks.",
            nearestRailwayStation = "Mysuru Junction (120 km) / Hassan (115 km)",
            nearestAirport = "Kannur International Airport (CNN - 85 km) / Mangaluru (140 km) / Bengaluru (285 km)",
            busTrainFlightOptions = "Frequent KSRTC Rajahamsa and Airavat Club Class AC sleeper buses run nightly from Bengaluru, Mysuru, and Mangaluru."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 4500,
            foodEstimatePerDay = 1400,
            activitiesTotal = 1200,
            travelEstimate = 2200,
            totalEstimateMin = 14000,
            totalEstimateMax = 36000
        )
    )

    val madikeri = Destination(
        id = "karnataka-madikeri",
        name = "Madikeri",
        state = "Karnataka",
        district = "Kodagu",
        tagline = "The Hilltop Capital of Kodagu",
        description = "The picturesque administrative heart of Coorg sitting at 1,150 meters, featuring the 17th-century Madikeri Fort, Omkareshwara temple with Gothic and Islamic minarets, and misty coffee slopes.",
        rating = 4.6f,
        reviewCount = 8200,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.MOUNTAINS, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Crisp hill air, temperature dipping to 12°C in December",
            peakSeason = "November – January",
            offSeason = "June – August (Torrential rains)",
            expectedCrowd = "High",
            temperatureRange = "13°C – 25°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-madikeri"),
        attractions = listOf(
            Attraction(
                id = "madikeri-fort",
                destinationId = "karnataka-madikeri",
                name = "Madikeri Fort & Palace Museum",
                description = "Originally built by Mudduraja in the late 17th century and rebuilt in stone by Tipu Sultan, featuring life-sized stone elephants and an archaeological museum.",
                category = "Fort & Heritage",
                openingTime = "10:00 AM",
                closingTime = "05:30 PM (Closed Mondays)",
                entryFeeAdult = "₹25",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 10:30 AM",
                tips = "Explore the museum housed inside the British-era St. Mark's church within the ramparts."
            ),
            Attraction(
                id = "madikeri-omkareshwara",
                destinationId = "karnataka-madikeri",
                name = "Omkareshwara Temple",
                description = "Unique 1820 CE Shiva temple built by King Lingarajendra II showcasing Gothic and Islamic architectural minarets surrounding a freshwater tank with holy fish.",
                category = "Spiritual & Heritage",
                openingTime = "06:30 AM",
                closingTime = "08:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 45,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = false,
                bestTimeOfDay = "Early morning or lit up at twilight",
                tips = "Visitors can feed the sacred carp fish in the temple pond."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-madikeri-resort",
                destinationId = "karnataka-madikeri",
                name = "Heritage Resort Madikeri",
                category = "Hillside Nature Resort",
                minimumPrice = 5200,
                maximumPrice = 9800,
                rating = 4.4f,
                reviewCount = 1100,
                amenities = listOf("Cottages on Hill Slopes", "Ayurvedic Centre", "Coffee Bar"),
                approximatePrice = "Approx. ₹5,800 / night (verify before travel)",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Coorg Filter Kaapi & Homemade Chocolates",
                    isVegetarian = true,
                    description = "Strong aromatic chicory-free estate coffee paired with handmade dark chocolates spiced with cardamom and cinnamon.",
                    popularAt = "Madikeri main market spice shops"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Bengaluru" to 250, "Mysuru" to 120, "Mangaluru" to 135),
            drivingTimes = mapOf("Bengaluru" to "4h 30m", "Mysuru" to "2h 30m"),
            roadTripRoute = "NH275 leading directly into Madikeri city center.",
            tollAndParkingNotes = "City center parking can be congested near Raja's Seat during sunset.",
            nearestRailwayStation = "Subrahmanya Road (85 km) / Mysuru (120 km)",
            nearestAirport = "Kannur Airport (85 km)",
            busTrainFlightOptions = "Direct KSRTC buses from Bangalore, Mysore, and Mangalore."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3500,
            foodEstimatePerDay = 1100,
            activitiesTotal = 600,
            travelEstimate = 1800,
            totalEstimateMin = 9500,
            totalEstimateMax = 22000
        )
    )

    val kushalnagar = Destination(
        id = "karnataka-kushalnagar",
        name = "Kushalnagar",
        state = "Karnataka",
        district = "Kodagu",
        tagline = "Gateway to Coorg & Tibetan Culture Hub",
        description = "Lying at the eastern gateway of Coorg on the Cauvery river, Kushalnagar is famed for the Bylakuppe Tibetan settlement, Nisargadhama bamboo island, and Harangi dam.",
        rating = 4.5f,
        reviewCount = 6800,
        coverResId = null,
        categories = listOf(TravelCategory.FAMILY_FRIENDLY, TravelCategory.WEEKEND_GETAWAYS, TravelCategory.NATURE),
        bestTime = BestTimeInfo(
            bestMonths = "September – March",
            weatherSummary = "Gentle climate, lush greenery, comfortable sightseeing",
            peakSeason = "October – January",
            offSeason = "April – May (Hotter plains climate)",
            expectedCrowd = "High",
            temperatureRange = "16°C – 29°C",
            suggestedDuration = "1–2 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-kushalnagar"),
        attractions = listOf(
            Attraction(
                id = "kushal-nisargadhama",
                destinationId = "karnataka-kushalnagar",
                name = "Kaveri Nisargadhama Island",
                description = "Enchanting 64-acre island formed by the River Cauvery accessed via a hanging rope bridge, featuring dense bamboo groves, deer park, and pedal boating.",
                category = "Nature & Island",
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
                bestTimeOfDay = "Morning or late afternoon",
                tips = "Children will love the deer feeding and wooden treehouse walkways."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-kushal-resort",
                destinationId = "karnataka-kushalnagar",
                name = "Amanvana Spa Resort",
                category = "Luxury Riverfront Spa Resort",
                minimumPrice = 11000,
                maximumPrice = 22000,
                rating = 4.7f,
                reviewCount = 1400,
                amenities = listOf("Private Courtyard Bungalows", "Sunken Garden Spa", "Riverside Reading Nooks"),
                approximatePrice = "Approx. ₹12,500 / night (verify before travel)",
                phone = "+91 8276 279 353",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Steamed Tibetan Momos & Thukpa",
                    isVegetarian = false,
                    description = "Freshly steamed dough dumplings stuffed with spiced vegetables/chicken, served with fiery garlic-chilli dip and hot noodle soup.",
                    popularAt = "Bylakuppe Camp 1 Tibetan eateries"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Bengaluru" to 220, "Mysuru" to 88, "Madikeri" to 30),
            drivingTimes = mapOf("Bengaluru" to "3h 45m", "Mysuru" to "1h 45m"),
            roadTripRoute = "On NH275 between Hunsur and Madikeri.",
            tollAndParkingNotes = "Flat highway driving with multiple highway food courts.",
            nearestRailwayStation = "Mysuru (88 km) / Hassan (78 km)",
            nearestAirport = "Mysore Airport (95 km) / Bengaluru (250 km)",
            busTrainFlightOptions = "All buses headed between Bengaluru/Mysuru and Coorg pass through Kushalnagar."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3200,
            foodEstimatePerDay = 1000,
            activitiesTotal = 500,
            travelEstimate = 1600,
            totalEstimateMin = 7500,
            totalEstimateMax = 18000
        )
    )

    val dubare = Destination(
        id = "karnataka-dubare",
        name = "Dubare",
        state = "Karnataka",
        district = "Kodagu",
        tagline = "The Cauvery Elephant Camp & River Rafting Haven",
        description = "Situated on the banks of the River Cauvery, Dubare is a historic elephant training center of the Mysore King era where visitors learn about elephant conservation, join in river bathing, and experience monsoon river rafting.",
        rating = 4.6f,
        reviewCount = 6100,
        coverResId = null,
        categories = listOf(TravelCategory.WILDLIFE, TravelCategory.FAMILY_FRIENDLY, TravelCategory.ADVENTURE),
        bestTime = BestTimeInfo(
            bestMonths = "September – March",
            weatherSummary = "Pleasant river breezes, clear shallow waters for river crossing",
            peakSeason = "October – February",
            offSeason = "July – August (Heavy river swelling)",
            expectedCrowd = "High (Morning bathing time)",
            temperatureRange = "16°C – 28°C",
            suggestedDuration = "1 Day"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-dubare"),
        attractions = listOf(
            Attraction(
                id = "dubare-elephant-camp",
                destinationId = "karnataka-dubare",
                name = "Dubare Elephant Camp & River Bathing",
                description = "Forest Department eco-camp across the Cauvery where travelers can observe mahouts scrubbing elephants in the river, assist in feeding ragi mudde balls, and attend educational sessions.",
                category = "Wildlife Conservation",
                openingTime = "09:00 AM – 11:00 AM & 04:30 PM – 05:30 PM",
                closingTime = "05:30 PM",
                entryFeeAdult = "Boat crossing ₹30, Elephant interaction ₹100",
                entryFeeChild = "₹50",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹40",
                difficultyLevel = "Easy to Moderate (Boat crossing over Cauvery)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 08:45 AM for bathing session",
                tips = "Arrive before 08:30 AM to catch the morning river bathing session. Cross the river via motorboat or rocky shallows."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-dubare-jungle-lodge",
                destinationId = "karnataka-dubare",
                name = "Jungle Lodges Dubare Elephant Camp",
                category = "Government Eco-Resort",
                minimumPrice = 5500,
                maximumPrice = 9000,
                rating = 4.4f,
                reviewCount = 780,
                amenities = listOf("Cottages on the Island", "Elephant Activities Included", "Coracle Ride", "All Meals Buffet"),
                approximatePrice = "Approx. ₹6,500 / person (all-inclusive)",
                website = "https://junglelodges.com",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Buffet Country Meals",
                    isVegetarian = false,
                    description = "Wholesome Kodava style chicken curry, fresh vegetables, sambar, rasam, and payasam.",
                    popularAt = "Jungle Lodges dining gol ghar"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Bengaluru" to 235, "Mysuru" to 100, "Madikeri" to 28),
            drivingTimes = mapOf("Bengaluru" to "4h 15m", "Mysuru" to "2h 0m"),
            roadTripRoute = "Turn south from Kushalnagar towards Siddapur on SH91.",
            tollAndParkingNotes = "Paved village road leading through coffee estates to Cauvery riverbank.",
            nearestRailwayStation = "Mysuru (100 km)",
            nearestAirport = "Kannur (95 km) / Bengaluru (265 km)",
            busTrainFlightOptions = "Drive from Kushalnagar or hire an auto/taxi (14 km)."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 4000,
            foodEstimatePerDay = 1000,
            activitiesTotal = 800,
            travelEstimate = 1800,
            totalEstimateMin = 6500,
            totalEstimateMax = 16000
        )
    )

    val talacauvery = Destination(
        id = "karnataka-talacauvery",
        name = "Talacauvery",
        state = "Karnataka",
        district = "Kodagu",
        tagline = "The Sacred Origin of River Cauvery & Brahmagiri Peak",
        description = "Situated at 1,276 meters on the slopes of the Brahmagiri hill, Talacauvery is the revered birthplace of the holy River Cauvery, featuring a holy spring pond and a panoramic high-altitude summit trek.",
        rating = 4.7f,
        reviewCount = 5400,
        coverResId = null,
        categories = listOf(TravelCategory.SPIRITUAL, TravelCategory.MOUNTAINS, TravelCategory.NATURE),
        bestTime = BestTimeInfo(
            bestMonths = "September – March",
            weatherSummary = "Cool windy mountain climate, heavy rains during monsoon",
            peakSeason = "October (Tula Sankramana holy tirthodbhava festival) – January",
            offSeason = "June – August",
            expectedCrowd = "High",
            temperatureRange = "11°C – 23°C",
            suggestedDuration = "1 Day"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-talacauvery"),
        attractions = listOf(
            Attraction(
                id = "tala-kundike",
                destinationId = "karnataka-talacauvery",
                name = "Talacauvery Holy Spring & Temple",
                description = "Sacred shrine built around a perennial spring pond (Kundike) where the River Cauvery emerges before flowing underground down the hillside.",
                category = "Spiritual Shrine",
                openingTime = "06:00 AM",
                closingTime = "06:30 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = false,
                bestTimeOfDay = "Morning 07:00 AM – 09:30 AM",
                tips = "Strict dress code applies: traditional attire required. Carry warm shawls due to high winds."
            ),
            Attraction(
                id = "tala-brahmagiri-peak",
                destinationId = "karnataka-talacauvery",
                name = "Brahmagiri Peak Trek (Talacauvery Steps)",
                description = "A steep 360-step stairway ascent starting from behind the temple leading to a spectacular 360-degree viewpoint overlooking the green layers of Karnataka and Kerala.",
                category = "Scenic Viewpoint & Trek",
                openingTime = "06:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "Included in temple visit",
                recommendedDurationMinutes = 75,
                parkingAvailable = true,
                difficultyLevel = "Moderate (Steep stepped climb)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Morning before clouds envelop the summit",
                tips = "Wind gusts can be exceptionally strong at the summit; hold railings firmly."
            )
        ),
        stays = emptyList(),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Temple Prasada & Filter Coffee",
                    isVegetarian = true,
                    description = "Sacred sweet payasam and piping hot South Indian filter coffee in cool mountain winds.",
                    popularAt = "Bhagamandala temple canteens"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Madikeri" to 44, "Bengaluru" to 295, "Mysuru" to 165),
            drivingTimes = mapOf("Madikeri" to "1h 15m", "Bengaluru" to "6h 0m"),
            roadTripRoute = "From Madikeri via Bhagamandala (Triveni Sangama) ascending to Talacauvery.",
            tollAndParkingNotes = "Winding scenic mountain road flanked by thick shola forests.",
            nearestRailwayStation = "Subrahmanya Road (65 km) / Mysuru (165 km)",
            nearestAirport = "Kannur (110 km)",
            busTrainFlightOptions = "Regular KSRTC buses run between Madikeri and Bhagamandala/Talacauvery."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 700,
            activitiesTotal = 200,
            travelEstimate = 1200,
            totalEstimateMin = 3500,
            totalEstimateMax = 8000
        )
    )

    val nagarhole = Destination(
        id = "karnataka-nagarhole",
        name = "Nagarhole",
        state = "Karnataka",
        district = "Kodagu & Mysuru",
        tagline = "Rajiv Gandhi National Park & Tiger Biosphere",
        description = "One of India's premier tiger reserves nestled under the Nilgiri Biosphere, Nagarhole boasts dense teak forests, the meandering Kabini river, and one of the highest densities of Asian elephants and Bengal tigers.",
        rating = 4.8f,
        reviewCount = 7400,
        coverResId = null,
        categories = listOf(TravelCategory.WILDLIFE, TravelCategory.ADVENTURE, TravelCategory.FAMILY_FRIENDLY),
        bestTime = BestTimeInfo(
            bestMonths = "October – May",
            weatherSummary = "Dry months (March-May) optimal for waterhole sightings; post-monsoon (Oct-Feb) lush and cool",
            peakSeason = "November – April",
            offSeason = "July – August (Heavy monsoon)",
            expectedCrowd = "High (Safari slots sell out fast)",
            temperatureRange = "15°C – 32°C",
            suggestedDuration = "2–3 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-nagarhole"),
        attractions = listOf(
            Attraction(
                id = "nagar-jeep-safari",
                destinationId = "karnataka-nagarhole",
                name = "Nagarhole Jungle Jeep & Canter Safari",
                description = "Deep 2.5-hour forest drive through designated core safari zones with expert naturalists to spot tigers, leopards, herds of elephants, wild dogs (dhole), and gaur.",
                category = "Wildlife Safari",
                openingTime = "06:00 AM – 09:00 AM & 03:00 PM – 06:00 PM",
                closingTime = "06:00 PM",
                entryFeeAdult = "₹500 (Canter), ₹2,000+ (Gypsy Safari)",
                recommendedDurationMinutes = 150,
                parkingAvailable = true,
                parkingFee = "₹50",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "06:00 AM sunrise safari or 03:30 PM",
                tips = "Book safari tickets well in advance on the official Karnataka Forest Department portal or through Jungle Lodges."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-nagar-kings-sanctuary",
                destinationId = "karnataka-nagarhole",
                name = "The Kings Sanctuary",
                category = "Eco Wildlife Resort",
                minimumPrice = 8500,
                maximumPrice = 16000,
                rating = 4.6f,
                reviewCount = 920,
                amenities = listOf("Jungle Villas", "Swimming Pool", "Safari Desk", "Nature Treks"),
                approximatePrice = "Approx. ₹9,500 / night (verify before travel)",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Forest Style Country Chicken Curry",
                    isVegetarian = false,
                    description = "Freshly pounded coriander, black pepper, and coconut curry served with steamed rice.",
                    popularAt = "Jungle lodges and eco-resorts"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Bengaluru" to 225, "Mysuru" to 85, "Coorg" to 75),
            drivingTimes = mapOf("Bengaluru" to "4h 30m", "Mysuru" to "1h 45m"),
            roadTripRoute = "From Mysuru via Hunsur or HD Kote towards Nanachi / Veeranahosahalli forest gate.",
            tollAndParkingNotes = "Forest checkposts enforce strict speed limits (30 km/h) and no-stopping rules inside sanctuary corridors.",
            nearestRailwayStation = "Mysuru Junction (85 km)",
            nearestAirport = "Mysore Airport (90 km) / Kannur (120 km) / Bengaluru (260 km)",
            busTrainFlightOptions = "Best reached by private car or cab from Mysuru or Bengaluru."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 6500,
            foodEstimatePerDay = 1500,
            activitiesTotal = 2500,
            travelEstimate = 2000,
            totalEstimateMin = 16000,
            totalEstimateMax = 38000
        )
    )

    val kabini = Destination(
        id = "karnataka-kabini",
        name = "Kabini",
        state = "Karnataka",
        district = "Mysuru",
        tagline = "India's Black Panther Capital & River Boat Safaris",
        description = "Flanking the majestic Kabini river reservoir between Nagarhole and Bandipur, Kabini is famed as one of Asia's most spectacular wildlife arenas, home to the rare melanistic black panther (Saya), massive elephant congregations, and legendary boat safaris.",
        rating = 4.9f,
        reviewCount = 6800,
        coverResId = null,
        categories = listOf(TravelCategory.WILDLIFE, TravelCategory.COUPLES, TravelCategory.ADVENTURE),
        bestTime = BestTimeInfo(
            bestMonths = "October – May",
            weatherSummary = "Summer (March-May) witnesses world's largest gathering of Asian elephants on backwater banks; winters are cool and misty",
            peakSeason = "November – April",
            offSeason = "July – August",
            expectedCrowd = "Moderate to High",
            temperatureRange = "16°C – 33°C",
            suggestedDuration = "2–3 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-kabini"),
        attractions = listOf(
            Attraction(
                id = "kabini-boat-safari",
                destinationId = "karnataka-kabini",
                name = "Kabini River Boat Safari",
                description = "Peaceful motorboat cruise along the quiet backwaters watching herds of elephants swimming, marsh crocodiles basking on sandbanks, and osprey diving for fish.",
                category = "Water Safari",
                openingTime = "06:30 AM – 09:00 AM & 03:30 PM – 06:00 PM",
                closingTime = "06:00 PM",
                entryFeeAdult = "₹1,800 – ₹2,500 (Usually part of resort safari package)",
                recommendedDurationMinutes = 150,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Evening 04:00 PM for sunset elephant herds",
                tips = "Carry high-zoom telephoto lenses (300mm+) for stunning riverfront bird and predator photography."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-kabini-orange-county",
                destinationId = "karnataka-kabini",
                name = "Evolve Back Kabini (Kuruba Safari Lodge)",
                category = "Ultra Luxury Safari Resort",
                minimumPrice = 29000,
                maximumPrice = 58000,
                rating = 4.9f,
                reviewCount = 2100,
                amenities = listOf("Traditional Tribal Huts with Private Pools", "Infinity Pool on Backwaters", "Ayurvedic Spa", "Bespoke Wildlife Dining"),
                approximatePrice = "Approx. ₹34,000 / night (verify before travel)",
                phone = "+91 80 4191 1122",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-kabini-jungle-lodges",
                destinationId = "karnataka-kabini",
                name = "Kabini River Lodge (Jungle Lodges & Resorts)",
                category = "Colonial Hunting Lodge & Safaris",
                minimumPrice = 12000,
                maximumPrice = 24000,
                rating = 4.8f,
                reviewCount = 3200,
                amenities = listOf("Former Viceroy Hunting Estate", "Guaranteed Forest Safari Permits", "All-Inclusive Dining", "Naturalist Talks"),
                approximatePrice = "Approx. ₹14,500 / person (all-inclusive)",
                website = "https://junglelodges.com",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Kabini Fish Fry & Country Style Curries",
                    isVegetarian = false,
                    description = "Freshwater fish marinated in ginger, garlic, and freshly crushed black pepper, pan-seared to perfection.",
                    popularAt = "Riverfront lodge buffets"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Bengaluru" to 220, "Mysuru" to 80, "Hyderabad" to 790, "Chennai" to 565),
            drivingTimes = mapOf("Bengaluru" to "4h 15m", "Mysuru" to "1h 45m"),
            roadTripRoute = "From Mysuru via HD Kote and Handpost junction towards Karapura / Antharasanthe.",
            tollAndParkingNotes = "Paved state highway with quiet village reaches and sugar cane farms.",
            nearestRailwayStation = "Mysuru Junction (80 km)",
            nearestAirport = "Mysore Airport (75 km) / Bengaluru (255 km)",
            busTrainFlightOptions = "Chauffeur-driven cab or self-drive from Mysuru or Bengaluru is recommended."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 12000,
            foodEstimatePerDay = 2000,
            activitiesTotal = 3500,
            travelEstimate = 2500,
            totalEstimateMin = 26000,
            totalEstimateMax = 65000
        )
    )

    val allBengaluruMysuruDestinations = listOf(
        bengaluru,
        nandiHills,
        skandagiri,
        savandurga,
        bannerghatta,
        ramanagara,
        kanakapura,
        mysuru,
        coorg,
        madikeri,
        kushalnagar,
        dubare,
        talacauvery,
        nagarhole,
        kabini
    )
}
