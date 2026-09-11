package com.example.data.datasource.tamilnadu

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

object TamilNaduChennaiHeritageData {

    val chennai = Destination(
        id = "tamilnadu-chennai",
        name = "Chennai",
        state = "Tamil Nadu",
        district = "Chennai",
        tagline = "The Gateway to South India & Cultural Soul of Tamil Heritage",
        description = "Tamil Nadu's bustling coastal capital blends classical Carnatic music and Bharatanatyam traditions with colonial heritage, world's second-longest natural urban beach (Marina Beach), 7th-century Dravidian temples, and authentic South Indian filter coffee institutions.",
        rating = 4.7f,
        reviewCount = 17800,
        coverResId = null,
        categories = listOf(TravelCategory.BEACHES, TravelCategory.HERITAGE, TravelCategory.FAMILY_FRIENDLY),
        bestTime = BestTimeInfo(
            bestMonths = "November – February",
            weatherSummary = "Comfortable coastal breeze, festive Margazhi music festival in December, relief from summer humidity",
            peakSeason = "December – February",
            offSeason = "April – June (High heat and humidity >38°C)",
            expectedCrowd = "High",
            temperatureRange = "21°C – 30°C",
            suggestedDuration = "2–3 Days"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("tamilnadu-chennai"),
        attractions = listOf(
            Attraction(
                id = "chn-kapaleeshwarar",
                destinationId = "tamilnadu-chennai",
                name = "Kapaleeshwarar Temple (Mylapore)",
                description = "Magnificent 7th-century Dravidian temple dedicated to Lord Shiva and Goddess Karpagambal, renowned for its 37-meter rainbow gopuram, stone pillared mandapams, and sacred temple tank.",
                category = "Spiritual & Heritage",
                openingTime = "06:00 AM – 12:30 PM & 04:00 PM – 09:30 PM",
                closingTime = "09:30 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Early morning 06:30 AM or 06:30 PM for deeparadhana aarti",
                tips = "Explore the Mylapore tank bazaar surrounding the temple for bronze handicrafts and brass lamps."
            ),
            Attraction(
                id = "chn-marina-beach",
                destinationId = "tamilnadu-chennai",
                name = "Marina Beach & Lighthouse",
                description = "The world's second-longest natural urban beach spanning 13 km along the Bay of Bengal, featuring historical statues, horse rides, fresh fish fry stalls, and an operational lighthouse with elevator views.",
                category = "Beaches & Promenade",
                openingTime = "24 Hours (Lighthouse 10:00 AM – 01:00 PM & 03:00 PM – 05:30 PM)",
                closingTime = "08:30 PM",
                entryFeeAdult = "Free (Lighthouse ₹20)",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹40",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "05:00 PM – 07:00 PM for cool sea breeze and street food",
                tips = "Swimming is strictly banned due to treacherous undercurrents. Stroll along the wide paved promenade."
            ),
            Attraction(
                id = "chn-san-thome",
                destinationId = "tamilnadu-chennai",
                name = "San Thome Cathedral Basilica",
                description = "Neo-Gothic 16th-century Catholic cathedral built by Portuguese explorers over the tomb of St. Thomas the Apostle—one of only three churches in the world built directly over the tomb of an apostle of Jesus.",
                category = "Heritage & Church",
                openingTime = "06:00 AM",
                closingTime = "09:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning or late afternoon",
                tips = "Visit the crypt museum beneath the altar holding relics of St. Thomas."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-chn-taj-coromandel",
                destinationId = "tamilnadu-chennai",
                name = "Taj Coromandel",
                category = "Luxury Heritage Hotel",
                minimumPrice = 9500,
                maximumPrice = 22000,
                rating = 4.8f,
                reviewCount = 3100,
                amenities = listOf("Southern Spice Award-Winning Dining", "Jiva Spa", "Outdoor Pool", "Central Location"),
                approximatePrice = "Approx. ₹11,000 / night (verify before travel)",
                phone = "+91 44 6600 2827",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-chn-radisson-blu",
                destinationId = "tamilnadu-chennai",
                name = "Radisson Blu Hotel Chennai City Centre",
                category = "Upscale City Hotel",
                minimumPrice = 4500,
                maximumPrice = 8500,
                rating = 4.5f,
                reviewCount = 2400,
                amenities = listOf("Central AC", "Swimming Pool", "The Great Kabab Factory"),
                approximatePrice = "Approx. ₹5,200 / night (verify before travel)",
                phone = "+91 44 3040 3040",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Authentic Madras Degree Filter Kaapi",
                    isVegetarian = true,
                    description = "Freshly decocted chicory-laced peaberry coffee served piping hot in traditional brass dabarah and tumbler with rich frothy crown.",
                    popularAt = "Rayar's Mess (Mylapore), Ratna Cafe (Triplicane)"
                ),
                FoodItem(
                    name = "Crispy Ghee Roast Dosa with Vadacurry",
                    isVegetarian = true,
                    description = "Paper-thin golden crepe roasted in pure ghee paired with unique spiced Bengal gram fritter gravy (Vadacurry).",
                    popularAt = "Murugan Idli Shop, Ratna Cafe"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Murugan Idli Shop",
                    cuisine = "Authentic South Indian Tiffin",
                    rating = 4.6f,
                    isVegFriendly = true,
                    signatureDish = "Melt-in-mouth Podi Idli with 4 varieties of Chutney",
                    priceForTwo = "₹300",
                    distance = "GN Chetty Road, T. Nagar"
                ),
                RestaurantItem(
                    name = "Southern Spice (Taj Coromandel)",
                    cuisine = "Fine-Dining South Indian Heritage",
                    rating = 4.9f,
                    isVegFriendly = true,
                    signatureDish = "Chettinad Kozhi Biryani & Banana Flower Vada",
                    priceForTwo = "₹3,500",
                    distance = "Nungambakkam High Road"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Hyderabad" to 625, "Bengaluru" to 345, "Chennai" to 0, "Mumbai" to 1330,
                "Pune" to 1190, "Delhi" to 2180, "Kolkata" to 1660, "Visakhapatnam" to 790,
                "Vijayawada" to 450, "Kochi" to 690, "Coimbatore" to 500, "Madurai" to 460
            ),
            drivingTimes = mapOf(
                "Bengaluru" to "6h 0m via NH48", "Hyderabad" to "10h 30m via NH16", "Puducherry" to "2h 45m via ECR"
            ),
            roadTripRoute = "National Highway hub connecting NH16 (Kolkata-Chennai), NH48 (Bengaluru-Chennai), and the scenic East Coast Road (ECR).",
            tollAndParkingNotes = "FASTag tolls on all highways. Heavy inner-city traffic in T. Nagar, Mount Road, and George Town.",
            nearestRailwayStation = "Chennai Central (MAS) / Chennai Egmore (MS)",
            nearestAirport = "Chennai International Airport (MAA - Meenambakkam)",
            busTrainFlightOptions = "Extensive global and domestic flights; Vande Bharat Express to Mysuru, Bengaluru, Coimbatore, and Vijayawada."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3500,
            foodEstimatePerDay = 1100,
            activitiesTotal = 600,
            travelEstimate = 1500,
            totalEstimateMin = 8500,
            totalEstimateMax = 22000
        )
    )

    val mahabalipuram = Destination(
        id = "tamilnadu-mahabalipuram",
        name = "Mahabalipuram (Mamallapuram)",
        state = "Tamil Nadu",
        district = "Chengalpattu",
        tagline = "UNESCO World Heritage & 7th-Century Pallava Rock Architecture",
        description = "The ancient port city of the 7th-century Pallava dynasty, renowned for monolithic rock-cut cave temples, the ocean-facing Shore Temple, Arjuna's Penance—the world's largest open-air stone relief bas-relief, and gravity-defying Krishna's Butter Ball.",
        rating = 4.8f,
        reviewCount = 16900,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.BEACHES, TravelCategory.FAMILY_FRIENDLY, TravelCategory.ROAD_TRIPS),
        bestTime = BestTimeInfo(
            bestMonths = "November – February",
            weatherSummary = "Pleasant coastal temperatures, cool ocean breeze, annual Indian Dance Festival in Dec/Jan",
            peakSeason = "December – January",
            offSeason = "April – June (Intense coastal heat)",
            expectedCrowd = "High",
            temperatureRange = "21°C – 31°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("tamilnadu-mahabalipuram"),
        attractions = listOf(
            Attraction(
                id = "maha-shore-temple",
                destinationId = "tamilnadu-mahabalipuram",
                name = "Shore Temple (Bay of Bengal)",
                description = "8th-century CE granite structural temple standing sentinel over the crashing waves of the Bay of Bengal, built by Narasimhavarman II with twin spires dedicated to Lord Shiva and reclining Vishnu.",
                category = "UNESCO World Heritage",
                openingTime = "06:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "₹40 (Indians), ₹600 (Foreigners) - covers Pancha Rathas on same ticket",
                entryFeeChild = "Free below 15 years",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹40",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Sunrise 06:00 AM or late afternoon 04:30 PM",
                tips = "The sunrise behind the granite spires against the Bay of Bengal is a photographer's dream."
            ),
            Attraction(
                id = "maha-pancha-rathas",
                destinationId = "tamilnadu-mahabalipuram",
                name = "Pancha Rathas (Five Chariots)",
                description = "Five monolithic stone processional chariots named after the Pandavas and Draupadi, each carved out of a single continuous granite boulder in distinct architectural styles.",
                category = "Monolithic Architecture",
                openingTime = "06:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "Included in Shore Temple ASI ticket",
                recommendedDurationMinutes = 75,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 08:30 AM",
                tips = "Admire the life-sized monolithic stone elephant standing beside the Nakula-Sahadeva ratha."
            ),
            Attraction(
                id = "maha-arjunas-penance",
                destinationId = "tamilnadu-mahabalipuram",
                name = "Arjuna's Penance & Krishna's Butter Ball",
                description = "A massive 96 x 43 ft rock relief depicting the descent of the sacred River Ganges from the heavens with over 100 carved gods and celestial beasts, flanked by the 250-ton precarious boulder known as Krishna's Butter Ball.",
                category = "Archaeological Marvel",
                openingTime = "06:00 AM",
                closingTime = "06:30 PM",
                entryFeeAdult = "Free (Open park)",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "03:30 PM – 05:30 PM",
                tips = "Try posing as if pushing the 250-ton spherical boulder balancing on a 45-degree rock slope."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-maha-radisson-temple-bay",
                destinationId = "tamilnadu-mahabalipuram",
                name = "Radisson Blu Resort Temple Bay Mamallapuram",
                category = "Luxury Beachfront Resort",
                minimumPrice = 9500,
                maximumPrice = 22000,
                rating = 4.7f,
                reviewCount = 3800,
                amenities = listOf("27,000 sq ft Meandering Pool", "Sea-Facing Chalets", "Ayurvedic Spa", "Beachfront Dining"),
                approximatePrice = "Approx. ₹11,500 / night (verify before travel)",
                phone = "+91 44 2744 0100",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-maha-chariot-resort",
                destinationId = "tamilnadu-mahabalipuram",
                name = "Chariot Beach Resort",
                category = "Beach Resort",
                minimumPrice = 4500,
                maximumPrice = 8500,
                rating = 4.3f,
                reviewCount = 1800,
                amenities = listOf("Direct Beach Access", "Swimming Pool", "Seafood Restaurant"),
                approximatePrice = "Approx. ₹5,200 / night (verify before travel)",
                phone = "+91 44 2742 5000",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Fresh Bay of Bengal Grilled Fish & Prawns",
                    isVegetarian = false,
                    description = "Catch of red snapper, jumbo prawns, or crab grilled with garlic, butter, and lemon pepper.",
                    popularAt = "Moonrakers Restaurant & Santana Beach Shack"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Moonrakers",
                    cuisine = "Fresh Coastal Seafood & Multi-Cuisine",
                    rating = 4.5f,
                    isVegFriendly = true,
                    signatureDish = "Butter Garlic Prawns & Tawa Seer Fish",
                    priceForTwo = "₹900",
                    distance = "Othavadai Street"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Chennai" to 55, "Puducherry" to 95, "Bengaluru" to 345),
            drivingTimes = mapOf("Chennai" to "1h 15m via ECR", "Puducherry" to "1h 45m"),
            roadTripRoute = "Via the world-renowned East Coast Road (SH49 - ECR) hugging the scenic Bay of Bengal coastline.",
            tollAndParkingNotes = "FASTag toll at Uthandi (~₹60). Ample parking near Shore Temple and Five Rathas.",
            nearestRailwayStation = "Chengalpattu Junction (CGL - 29 km)",
            nearestAirport = "Chennai International Airport (52 km)",
            busTrainFlightOptions = "Air-conditioned AC Volvo buses (599, 588) depart every 20 minutes from CMBT and Adyar to Mahabalipuram."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3800,
            foodEstimatePerDay = 1200,
            activitiesTotal = 500,
            travelEstimate = 1200,
            totalEstimateMin = 7500,
            totalEstimateMax = 18000
        )
    )

    val kanchipuram = Destination(
        id = "tamilnadu-kanchipuram",
        name = "Kanchipuram",
        state = "Tamil Nadu",
        district = "Kanchipuram",
        tagline = "The City of A Thousand Temples & Silk Capital of India",
        description = "One of India's seven sacred Moksha-bestowing cities (Saptapuri), Kanchipuram was the golden capital of the Pallavas and Cholas, famed for monumental 8th-century stone architecture—Kailasanathar, Ekambareswarar, and Varadharaja Perumal—and world-famous pure mulberry silk sarees with real gold zari borders.",
        rating = 4.7f,
        reviewCount = 11400,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.SPIRITUAL, TravelCategory.FAMILY_FRIENDLY),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Pleasant daytime weather, ideal for visiting temple complexes and weaver co-operatives",
            peakSeason = "November – February",
            offSeason = "April – June (Summers can cross 40°C)",
            expectedCrowd = "High (Festive days & Brahmotsavam)",
            temperatureRange = "20°C – 32°C",
            suggestedDuration = "1–2 Days"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("tamilnadu-kanchipuram"),
        attractions = listOf(
            Attraction(
                id = "kanchi-kailasanathar",
                destinationId = "tamilnadu-kanchipuram",
                name = "Kailasanathar Temple (Oldest Stone Structure)",
                description = "Oldest surviving stone temple in Kanchipuram built in 705 CE by Pallava King Rajasimha, featuring 58 miniature shrines around a perimeter courtyard adorned with exquisite sandstone relief carvings of Shiva and Parvati.",
                category = "Archaeological Masterpiece",
                openingTime = "06:00 AM – 12:00 PM & 04:00 PM – 07:30 PM",
                closingTime = "07:30 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Early morning 07:00 AM or golden hour 04:30 PM",
                tips = "Walk through the narrow circumambulatory passage around the sanctum symbolising life, rebirth, and liberation."
            ),
            Attraction(
                id = "kanchi-ekambareswarar",
                destinationId = "tamilnadu-kanchipuram",
                name = "Ekambareswarar Temple (Earth Prithvi Sthalam)",
                description = "Colossal 25-acre temple representing the Earth element among the Pancha Bhoota Sthalams, featuring a towering 59-meter southern gopuram and a 3,500-year-old sacred mango tree bearing four varieties of mangoes.",
                category = "Spiritual Sanctuary",
                openingTime = "06:00 AM – 12:30 PM & 04:00 PM – 08:30 PM",
                closingTime = "08:30 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "06:30 AM",
                tips = "Men must remove shirts to enter the inner sanctum. Explore the 1,000-pillared hall inside."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-kanchi-grt-regency",
                destinationId = "tamilnadu-kanchipuram",
                name = "Regency Kanchipuram by GRT Hotels",
                category = "Premium Comfort Hotel",
                minimumPrice = 3600,
                maximumPrice = 6500,
                rating = 4.4f,
                reviewCount = 1600,
                amenities = listOf("Central AC", "Multi-Cuisine Veg/Non-Veg Restaurant", "Silk Boutique Desk"),
                approximatePrice = "Approx. ₹4,200 / night (verify before travel)",
                phone = "+91 44 2722 5250",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Original Kanchipuram Idli (Kovil Idli)",
                    isVegetarian = true,
                    description = "Cylindrical spiced steamed rice cake seasoned with dried ginger powder, cumin seeds, black pepper, and curry leaves, wrapped in fragrant Bauhinia leaves.",
                    popularAt = "Sri Krishna Vilas & Varadharaja Perumal Temple Madapalli"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Saravana Bhavan (Gandhi Road)",
                    cuisine = "Pure Vegetarian South Indian",
                    rating = 4.4f,
                    isVegFriendly = true,
                    signatureDish = "Kanchipuram Idli & Ghee Mini Tiffin",
                    priceForTwo = "₹350",
                    distance = "Gandhi Road, Near Bus Stand"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Chennai" to 75, "Bengaluru" to 280, "Vellore" to 70),
            drivingTimes = mapOf("Chennai" to "1h 45m via NH48", "Bengaluru" to "4h 45m"),
            roadTripRoute = "Via NH48 6-lane expressway through Sriperumbudur.",
            tollAndParkingNotes = "FASTag tolls on NH48. Street parking near Gandhi Road silk co-operatives.",
            nearestRailwayStation = "Kanchipuram (CJ - 2 km)",
            nearestAirport = "Chennai International Airport (65 km)",
            busTrainFlightOptions = "Direct express buses depart every 10 minutes from CMBT Chennai to Kanchipuram."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2800,
            foodEstimatePerDay = 800,
            activitiesTotal = 300,
            travelEstimate = 1200,
            totalEstimateMin = 5500,
            totalEstimateMax = 14000
        )
    )

    val thanjavur = Destination(
        id = "tamilnadu-thanjavur",
        name = "Thanjavur",
        state = "Tamil Nadu",
        district = "Thanjavur",
        tagline = "UNESCO World Heritage & The Great Chola Living Temple",
        description = "The imperial capital of the Chola Empire, Thanjavur is home to the architectural triumph of ancient India: the 1,000-year-old Brihadisvara Temple (Peruvudaiyar Kovil / Big Temple), renowned for its 66-meter granite vimana crowned with an 80-ton monolithic stone cupola, Saraswathi Mahal Library, and exquisite Tanjore gold-leaf paintings.",
        rating = 4.9f,
        reviewCount = 18600,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.FAMILY_FRIENDLY, TravelCategory.SPIRITUAL),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Pleasant winter sunshine, cool breeze over the Cauvery delta, Mahashivratri festivities",
            peakSeason = "November – February",
            offSeason = "April – June (Summers heat up to 39°C)",
            expectedCrowd = "High",
            temperatureRange = "19°C – 31°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("tamilnadu-thanjavur"),
        attractions = listOf(
            Attraction(
                id = "than-brihadisvara",
                destinationId = "tamilnadu-thanjavur",
                name = "Brihadisvara Temple (The Big Temple)",
                description = "Consecrated in 1010 CE by Emperor Rajaraja Chola I, this UNESCO World Heritage marvel was the first complete granite temple in the world, featuring an astronomical 216-foot vimana, a 20-ton monolithic Nandi bull, and exquisite Chola fresco murals.",
                category = "UNESCO World Heritage",
                openingTime = "06:00 AM – 12:30 PM & 04:00 PM – 08:30 PM",
                closingTime = "08:30 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 150,
                parkingAvailable = true,
                parkingFee = "₹40",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "06:30 AM or late afternoon 04:30 PM for glowing golden granite lighting",
                tips = "Notice that the shadow of the main vimana tower does not fall outside the temple grounds at noon."
            ),
            Attraction(
                id = "than-maratha-palace",
                destinationId = "tamilnadu-thanjavur",
                name = "Thanjavur Maratha Palace & Saraswathi Mahal Library",
                description = "Complex built by Nayak and Maratha rulers containing the Bell Tower, Arsenal Tower, Art Gallery with priceless Chola bronze sculptures, and one of Asia's oldest medieval manuscript libraries.",
                category = "Palace & Museum",
                openingTime = "09:00 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "₹50",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "10:30 AM",
                tips = "The Royal Art Gallery houses the celebrated 11th-century Chola Nataraja in cosmic dance pose."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-than-sivathee",
                destinationId = "tamilnadu-thanjavur",
                name = "Svatma - A Luxury Heritage Hotel",
                category = "Luxury Tamil Heritage Hotel",
                minimumPrice = 11000,
                maximumPrice = 24000,
                rating = 4.9f,
                reviewCount = 1400,
                amenities = listOf("Restored Tamil Mansion", "Carnatic Chamber Concerts", "Siddha Wellness Spa", "Pure Vegetarian Fine Dining"),
                approximatePrice = "Approx. ₹12,500 / night (verify before travel)",
                phone = "+91 4362 273 222",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-than-great-ashok",
                destinationId = "tamilnadu-thanjavur",
                name = "Hotel Gnanam",
                category = "City Hotel",
                minimumPrice = 2400,
                maximumPrice = 4500,
                rating = 4.2f,
                reviewCount = 1800,
                amenities = listOf("Central AC", "Vegetarian Restaurant", "Near Railway Station"),
                approximatePrice = "Approx. ₹2,800 / night (verify before travel)",
                phone = "+91 4362 278 501",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Thanjavur Ashoka Halwa",
                    isVegetarian = true,
                    description = "Glistening golden sweet confection made of roasted moong dal, sugar, ghee, and cardamom, garnished with fried cashews.",
                    popularAt = "Sri Krishna Sweets & local sweet stalls near palace"
                ),
                FoodItem(
                    name = "Tanjore Traditional Banana Leaf Meals",
                    isVegetarian = true,
                    description = "Steamed ponni rice, drumstick more kuzhambu, kootu, poriyal, pepper rasam, appalam, and semiya payasam.",
                    popularAt = "Hotel Gnanam & Sathars"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Santhosh Restaurant",
                    cuisine = "Authentic South Indian Vegetarian",
                    rating = 4.5f,
                    isVegFriendly = true,
                    signatureDish = "Special Meals with Paruppu Podi & Ghee",
                    priceForTwo = "₹350",
                    distance = "Near Old Bus Stand"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Chennai" to 345, "Trichy" to 58, "Madurai" to 190, "Bengaluru" to 390, "Kumbakonam" to 40
            ),
            drivingTimes = mapOf("Trichy" to "1h 0m via 4-lane NH83", "Chennai" to "6h 0m via Vikravandi"),
            roadTripRoute = "From Trichy via NH83 smooth 4-lane expressway; or from Chennai via NH32 / NH36.",
            tollAndParkingNotes = "FASTag expressway from Trichy. Large paid vehicle lot directly outside the Big Temple north gate.",
            nearestRailwayStation = "Thanjavur Junction (TJ - 1.5 km)",
            nearestAirport = "Tiruchirappalli International Airport (TRZ - 55 km)",
            busTrainFlightOptions = "Regular express trains connect Chennai Egmore, Tiruchirappalli, and Madurai directly to Thanjavur."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2800,
            foodEstimatePerDay = 800,
            activitiesTotal = 350,
            travelEstimate = 1400,
            totalEstimateMin = 6500,
            totalEstimateMax = 16000
        )
    )

    val kumbakonam = Destination(
        id = "tamilnadu-kumbakonam",
        name = "Kumbakonam",
        state = "Tamil Nadu",
        district = "Thanjavur",
        tagline = "The Cambridge of South India & Cauvery Temple Hub",
        description = "Encircled by the rivers Cauvery and Arasalar, Kumbakonam is home to 188 ancient temples, the sacred Mahamaham tank (where millions bathe once every 12 years during the southern Kumbh Mela), UNESCO-listed Airavatesvara Temple at Darasuram, and legendary Degree Coffee.",
        rating = 4.7f,
        reviewCount = 9800,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.SPIRITUAL, TravelCategory.FAMILY_FRIENDLY),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Gentle river breezes, delightful morning temple aartis",
            peakSeason = "November – February",
            offSeason = "April – June",
            expectedCrowd = "High (Pilgrimage periods)",
            temperatureRange = "20°C – 32°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("tamilnadu-kumbakonam"),
        attractions = listOf(
            Attraction(
                id = "kumba-airavatesvara",
                destinationId = "tamilnadu-kumbakonam",
                name = "Airavatesvara Temple (Darasuram)",
                description = "12th-century UNESCO World Heritage Chola temple built by Rajaraja Chola II, designed like a celestial chariot pulled by stone horses and elephants, renowned for musical singing steps and exquisite miniature filigree sculptures.",
                category = "UNESCO World Heritage",
                openingTime = "06:30 AM – 12:30 PM & 04:00 PM – 08:30 PM",
                closingTime = "08:30 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Late afternoon 04:30 PM",
                tips = "Inspect the stone steps near the entrance that produce seven musical swaras (notes) when tapped."
            ),
            Attraction(
                id = "kumba-mahamaham-tank",
                destinationId = "tamilnadu-kumbakonam",
                name = "Mahamaham Tank & Sarangapani Temple",
                description = "Sprawling 6.2-acre sacred stone tank flanked by 16 ornate pillared pavilions, accompanied by the majestic 12-storey Sarangapani temple with chariot-shaped mandapam.",
                category = "Spiritual & Heritage",
                openingTime = "06:00 AM – 09:00 PM",
                closingTime = "09:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Early morning or illuminated evening",
                tips = "Stroll around the perimeter tank in the quiet morning hours."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-kumba-paradise-resort",
                destinationId = "tamilnadu-kumbakonam",
                name = "Paradise Resort Kumbakonam",
                category = "Eco Heritage Resort",
                minimumPrice = 3800,
                maximumPrice = 7500,
                rating = 4.5f,
                reviewCount = 1200,
                amenities = listOf("Traditional Thatched Cottages", "Riverfront Setting", "Ayurveda", "Veg Restaurant"),
                approximatePrice = "Approx. ₹4,400 / night (verify before travel)",
                phone = "+91 435 241 6469",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Original Kumbakonam Degree Coffee",
                    isVegetarian = true,
                    description = "Pristine chicory-free fresh cow's milk coffee brewed through drip filters, served hot and foaming.",
                    popularAt = "Kumbakonam Degree Coffee outlets along highway & town center"
                ),
                FoodItem(
                    name = "Kumbakonam Kadappa",
                    isVegetarian = true,
                    description = "Mild, velvety moong dal and potato stew seasoned with fennel, garlic, and coconut, served with hot steaming idlis.",
                    popularAt = "Venkataramana Hotel"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Thanjavur" to 40, "Trichy" to 90, "Chennai" to 295),
            drivingTimes = mapOf("Thanjavur" to "45m", "Trichy" to "1h 45m"),
            roadTripRoute = "Via NH36 / SH64 through the fertile Cauvery agricultural delta.",
            tollAndParkingNotes = "Paved state highway with lush paddy fields on either side.",
            nearestRailwayStation = "Kumbakonam (KMU - 1 km)",
            nearestAirport = "Tiruchirappalli International (95 km)",
            busTrainFlightOptions = "Frequent passenger and express trains connect Kumbakonam to Chennai, Mayiladuthurai, and Thanjavur."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2800,
            foodEstimatePerDay = 800,
            activitiesTotal = 300,
            travelEstimate = 1200,
            totalEstimateMin = 5500,
            totalEstimateMax = 14000
        )
    )

    val madurai = Destination(
        id = "tamilnadu-madurai",
        name = "Madurai",
        state = "Tamil Nadu",
        district = "Madurai",
        tagline = "The Athens of the East & The City That Never Sleeps (Thoonga Nagaram)",
        description = "Continuously inhabited for over 2,500 years on the Vaigai river, Madurai is Tamil Nadu's spiritual soul, centered around the colossal Meenakshi Amman Temple with 14 gopurams and 33,000 sculptures, the 17th-century Thirumalai Nayakkar Mahal, vibrant street-food bazaars, and Jigarthanda.",
        rating = 4.9f,
        reviewCount = 22400,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.SPIRITUAL, TravelCategory.FAMILY_FRIENDLY),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Pleasant winter weather, comfortable for exploring stone temple corridors",
            peakSeason = "November – February",
            offSeason = "April – June (Summers can reach 40°C)",
            expectedCrowd = "Very High",
            temperatureRange = "20°C – 32°C",
            suggestedDuration = "2–3 Days"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("tamilnadu-madurai"),
        attractions = listOf(
            Attraction(
                id = "madu-meenakshi-temple",
                destinationId = "tamilnadu-madurai",
                name = "Meenakshi Amman Temple & 1,000-Pillar Hall",
                description = "Iconic 14-acre Dravidian masterpiece featuring 14 soaring gopurams reaching up to 52 meters, the sacred Golden Lotus tank (Porthamarai Kulam), and the Hall of 1,000 Pillars with musical stone columns and exquisite Nataraja sculptures.",
                category = "Spiritual & Architectural Wonder",
                openingTime = "05:00 AM – 12:30 PM & 04:00 PM – 10:00 PM",
                closingTime = "10:00 PM (Palliarai procession at 09:30 PM)",
                entryFeeAdult = "Free (1,000-Pillar Hall ₹50)",
                recommendedDurationMinutes = 180,
                parkingAvailable = true,
                parkingFee = "₹50",
                difficultyLevel = "Easy (Extensive stone-floor walking)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = false,
                bestTimeOfDay = "06:00 AM for quiet darshan or 09:15 PM for the royal night procession",
                tips = "Strict dress code applies: traditional attire mandatory. Mobile phones and cameras strictly prohibited inside; deposit at the outer locker counter."
            ),
            Attraction(
                id = "madu-thirumalai-nayakkar",
                destinationId = "tamilnadu-madurai",
                name = "Thirumalai Nayakkar Mahal",
                description = "1636 CE royal palace blending Dravidian and Islamic architectural styles, renowned for its massive 82-foot circular pillars, grand courtyard, and nightly English/Tamil sound & light show.",
                category = "Palace & Heritage",
                openingTime = "09:00 AM – 05:00 PM (Light & Sound show 06:45 PM)",
                closingTime = "08:00 PM",
                entryFeeAdult = "₹10 (Day visit), ₹50 (Sound & Light show)",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "11:00 AM or 06:45 PM for the sound and light show",
                tips = "Notice the stucco-work friezes and European-style painted arches along the royal throne hall."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-madu-heritage-madurai",
                destinationId = "tamilnadu-madurai",
                name = "Heritage Madurai",
                category = "Luxury Heritage Resort",
                minimumPrice = 8500,
                maximumPrice = 18000,
                rating = 4.7f,
                reviewCount = 2900,
                amenities = listOf("Temple Tank Inspired Swimming Pool", "Geoffrey Bawa Architecture", "Ayurvedic Spa", "Banyan Tree Courtyards"),
                approximatePrice = "Approx. ₹9,500 / night (verify before travel)",
                phone = "+91 452 245 8041",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-madu-courtyard-marriott",
                destinationId = "tamilnadu-madurai",
                name = "Courtyard by Marriott Madurai",
                category = "Upscale Modern Hotel",
                minimumPrice = 5200,
                maximumPrice = 9500,
                rating = 4.6f,
                reviewCount = 2200,
                amenities = listOf("Outdoor Pool", "Fitness Center", "Multi-Cuisine Buffet", "Central Location"),
                approximatePrice = "Approx. ₹5,800 / night (verify before travel)",
                phone = "+91 452 252 5555",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Famous Madurai Jigarthanda",
                    isVegetarian = true,
                    description = "Legendary cooling beverage made of condensed milk syrup, almond gum (badam pisin), nannari root syrup, and a generous scoop of artisanal cream ice cream.",
                    popularAt = "Famous Jigarthanda (East Marret Street - original shop since 1977)"
                ),
                FoodItem(
                    name = "Madurai Bun Parotta & Mutton Sukka",
                    isVegetarian = false,
                    description = "Crispy, flaky parotta shaped like a fluffy sweet bun, fried in ghee and paired with spicy pepper mutton fry and rich salna.",
                    popularAt = "Madurai Simmakkal Konar Mess, Hotel Sri Sabarees"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Murugan Idli Shop (West Masi Street)",
                    cuisine = "Authentic South Indian Vegetarian",
                    rating = 4.6f,
                    isVegFriendly = true,
                    signatureDish = "Ghee Podi Idli & Onion Uttapam",
                    priceForTwo = "₹350",
                    distance = "West Masi Street"
                ),
                RestaurantItem(
                    name = "Famous Jigarthanda",
                    cuisine = "Iconic Dessert Parlour",
                    rating = 4.8f,
                    isVegFriendly = true,
                    signatureDish = "Special Jigarthanda with Basundi",
                    priceForTwo = "₹160",
                    distance = "East Marret Street"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Hyderabad" to 990, "Bengaluru" to 435, "Chennai" to 460, "Mumbai" to 1380,
                "Pune" to 1240, "Delhi" to 2580, "Kolkata" to 2090, "Visakhapatnam" to 1230,
                "Vijayawada" to 890, "Kochi" to 260, "Coimbatore" to 215, "Rameswaram" to 175
            ),
            drivingTimes = mapOf(
                "Bengaluru" to "7h 0m via NH44 4-lane", "Chennai" to "7h 30m via NH45", "Kochi" to "5h 30m", "Rameswaram" to "3h 0m"
            ),
            roadTripRoute = "Directly connected by the 4-lane north-south corridor NH44 (Kashmir to Kanyakumari).",
            tollAndParkingNotes = "FASTag tolls on NH44. Madurai municipal multi-level parking lot available near Meenakshi Amman Temple East Tower.",
            nearestRailwayStation = "Madurai Junction (MDU - 1.5 km)",
            nearestAirport = "Madurai International Airport (IXM - 12 km)",
            busTrainFlightOptions = "Vande Bharat Express connects Madurai to Chennai Egmore and Bengaluru; flights to Chennai, Mumbai, Bengaluru, Dubai, and Singapore."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3200,
            foodEstimatePerDay = 1000,
            activitiesTotal = 500,
            travelEstimate = 1800,
            totalEstimateMin = 8500,
            totalEstimateMax = 22000
        )
    )

    val tiruchirappalli = Destination(
        id = "tamilnadu-tiruchirappalli",
        name = "Tiruchirappalli (Trichy)",
        state = "Tamil Nadu",
        district = "Tiruchirappalli",
        tagline = "The Citadel of Rockfort & Island Temple of Srirangam",
        description = "Dominated by the 83-meter ancient Rockfort temple rising dramatically above the Kaveri plains and the mammoth Sri Ranganathaswamy Temple at Srirangam—the largest functioning Hindu temple complex in the world covering 156 acres with 21 magnificent gopurams.",
        rating = 4.8f,
        reviewCount = 14200,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.SPIRITUAL, TravelCategory.FAMILY_FRIENDLY),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Mild pleasant days, Vaikunta Ekadasi celebrations in Dec/Jan at Srirangam",
            peakSeason = "November – February",
            offSeason = "April – June",
            expectedCrowd = "High",
            temperatureRange = "20°C – 32°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("tamilnadu-tiruchirappalli"),
        attractions = listOf(
            Attraction(
                id = "trichy-srirangam",
                destinationId = "tamilnadu-tiruchirappalli",
                name = "Sri Ranganathaswamy Temple (Srirangam)",
                description = "World's largest functioning temple complex spanning 156 acres across 7 concentric enclosures (prakarams) with 21 soaring gopurams, including the mammoth 73-meter Rajagopuram, dedicated to reclining Vishnu.",
                category = "World's Largest Temple Complex",
                openingTime = "06:00 AM – 01:00 PM & 03:30 PM – 09:00 PM",
                closingTime = "09:00 PM",
                entryFeeAdult = "Free (Special quick darshan ₹100 – ₹250)",
                recommendedDurationMinutes = 180,
                parkingAvailable = true,
                parkingFee = "₹40",
                difficultyLevel = "Easy to Moderate (Expansive walking grounds)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Early morning 06:30 AM or late afternoon",
                tips = "Ascend the rooftop viewpoint of the temple (₹20) to admire the panoramic sea of gopurams and the golden dome."
            ),
            Attraction(
                id = "trichy-rockfort",
                destinationId = "tamilnadu-tiruchirappalli",
                name = "Rockfort Ucchi Pillayar Temple",
                description = "A 3.8-billion-year-old bare quartz rock monolith older than the Himalayas rising 83 meters above the city, reached by climbing 437 steps carved into the stone to a Ganesh shrine with panoramic vistas.",
                category = "Geological & Spiritual Marvel",
                openingTime = "06:00 AM – 12:00 PM & 04:00 PM – 08:30 PM",
                closingTime = "08:30 PM",
                entryFeeAdult = "₹5",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Moderate (437 stone steps ascent)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Sunrise 06:00 AM or sunset 05:30 PM for panoramic city view",
                tips = "Explore the rock-cut cave temples of the Pallava and Nayaka eras carved halfway up the cliff."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-trichy-srm-hotel",
                destinationId = "tamilnadu-tiruchirappalli",
                name = "SRM Hotel Tiruchirappalli",
                category = "Upscale City Resort",
                minimumPrice = 3800,
                maximumPrice = 7200,
                rating = 4.5f,
                reviewCount = 1900,
                amenities = listOf("Outdoor Pool", "Landscaped Gardens", "Multi-Cuisine Dining"),
                approximatePrice = "Approx. ₹4,400 / night (verify before travel)",
                phone = "+91 431 242 1303",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Trichy Banana Leaf Thali & Poli",
                    isVegetarian = true,
                    description = "Wholesome South Indian meals served on freshly cut plantain leaves, followed by warm sweet coconut/lentil flatbread (Poli).",
                    popularAt = "Vasantha Bhavan & Sri Sangeethas"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Sri Sangeethas",
                    cuisine = "South Indian Pure Vegetarian",
                    rating = 4.6f,
                    isVegFriendly = true,
                    signatureDish = "Ghee Mini Tiffin & Parotta Kurma",
                    priceForTwo = "₹350",
                    distance = "Opposite Central Bus Stand"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Chennai" to 330, "Madurai" to 135, "Bengaluru" to 345, "Thanjavur" to 58, "Coimbatore" to 215
            ),
            drivingTimes = mapOf("Chennai" to "5h 0m via NH45", "Madurai" to "2h 0m", "Thanjavur" to "1h 0m"),
            roadTripRoute = "Directly connected by NH45 (Grand Southern Trunk Road) and NH83.",
            tollAndParkingNotes = "FASTag tolls along NH45. Dedicated parking lots at both Rockfort base and Srirangam temple.",
            nearestRailwayStation = "Tiruchirappalli Junction (TPJ - 3 km)",
            nearestAirport = "Tiruchirappalli International Airport (TRZ - 6 km)",
            busTrainFlightOptions = "TRZ connects to Singapore, Dubai, Kuala Lumpur, and Colombo; high-speed trains connect Trichy to all major Indian cities."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2800,
            foodEstimatePerDay = 800,
            activitiesTotal = 350,
            travelEstimate = 1400,
            totalEstimateMin = 6500,
            totalEstimateMax = 16000
        )
    )

    val rameswaram = Destination(
        id = "tamilnadu-rameswaram",
        name = "Rameswaram",
        state = "Tamil Nadu",
        district = "Ramanathapuram",
        tagline = "The Sacred Island of 22 Theerthams, Pamban Bridge & Dhanushkodi",
        description = "One of India's four sacred Char Dham pilgrimage sites, Rameswaram is situated on Pamban Island in the Gulf of Mannar, connected to mainland India by the engineering marvel of Pamban Sea Bridge. Famous for the Ramanathaswamy Temple featuring the world's longest pillared corridor, 22 holy water wells, and the ghost town of Dhanushkodi where the Bay of Bengal meets the Indian Ocean.",
        rating = 4.8f,
        reviewCount = 19800,
        coverResId = null,
        categories = listOf(TravelCategory.SPIRITUAL, TravelCategory.BEACHES, TravelCategory.HERITAGE, TravelCategory.ROAD_TRIPS),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Refreshing sea breezes, comfortable sunshine, clear calm waters for holy baths",
            peakSeason = "November – February",
            offSeason = "May – June (High summer heat)",
            expectedCrowd = "High",
            temperatureRange = "22°C – 31°C",
            suggestedDuration = "2–3 Days"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("tamilnadu-rameswaram"),
        attractions = listOf(
            Attraction(
                id = "ram-ramanathaswamy",
                destinationId = "tamilnadu-rameswaram",
                name = "Ramanathaswamy Temple & 22 Theerthams",
                description = "Revered Char Dham temple dedicated to Lord Shiva with a 1.2-km outer corridor supported by 1,212 ornately carved stone pillars—the longest pillared corridor in the world—and 22 sacred freshwater wells inside the salt-sea island.",
                category = "Char Dham Holy Shrine",
                openingTime = "05:00 AM – 01:00 PM & 03:00 PM – 09:00 PM",
                closingTime = "09:00 PM",
                entryFeeAdult = "Free (22 Theertham holy bath fee ₹25)",
                recommendedDurationMinutes = 180,
                parkingAvailable = true,
                parkingFee = "₹50",
                difficultyLevel = "Easy to Moderate",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = false,
                bestTimeOfDay = "Early morning 05:30 AM starting at Agniteertham sea beach",
                tips = "Take the traditional sea dip at Agniteertham first, then proceed inside to bathe at each of the 22 sacred theertham wells before changing into dry clothes for darshan."
            ),
            Attraction(
                id = "ram-pamban-bridge",
                destinationId = "tamilnadu-rameswaram",
                name = "Pamban Bridge (Rail & Road Sea Cantilever)",
                description = "India's first sea bridge constructed in 1914 spanning 2.06 km across the turbulent Palk Strait, accompanied by the new state-of-the-art vertical lift railway bridge and road bridge with panoramic sea vistas.",
                category = "Engineering Marvel",
                openingTime = "24 Hours",
                closingTime = "24 Hours",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 45,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Sunset or sunrise for breathtaking views of fishing boats and open waters",
                tips = "Pedestrian walkways on the road bridge allow stunning views of trains crossing the open sea."
            ),
            Attraction(
                id = "ram-dhanushkodi",
                destinationId = "tamilnadu-rameswaram",
                name = "Dhanushkodi Ghost Town & Arichal Munai",
                description = "The abandoned ghost town submerged by the 1964 cyclone, ending at Arichal Munai—the dramatic land's end where the calm waters of Bay of Bengal merge with the roaring waves of the Indian Ocean, just 18 miles from Sri Lanka.",
                category = "Land's End & Heritage",
                openingTime = "06:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹40",
                difficultyLevel = "Easy (Paved coastal road to the tip)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "07:00 AM – 10:00 AM or 03:30 PM",
                tips = "Explore the haunting ruins of the railway station, church, and school. Observe the contrasting colors where the two seas meet."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-ram-daiwik-hotel",
                destinationId = "tamilnadu-rameswaram",
                name = "Daiwik Hotels Rameswaram",
                category = "Pilgrim Specialty Hotel",
                minimumPrice = 3600,
                maximumPrice = 6500,
                rating = 4.4f,
                reviewCount = 2800,
                amenities = listOf("Theertham Changing Facility", "Pure Veg Dining", "Pilgrim Assistance Desk"),
                approximatePrice = "Approx. ₹4,200 / night (verify before travel)",
                phone = "+91 4573 221 777",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Fresh Seafood Meals & Filter Coffee",
                    isVegetarian = false,
                    description = "Crisp fish fry and seafood curries near Agniteertham, alongside pure vegetarian pilgrim tiffin.",
                    popularAt = "Hotel Saravana & Sri Murugan Mess"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Madurai" to 175, "Chennai" to 560, "Kanyakumari" to 310, "Bengaluru" to 600, "Trichy" to 230
            ),
            drivingTimes = mapOf("Madurai" to "3h 0m via NH87", "Trichy" to "4h 0m", "Chennai" to "9h 30m"),
            roadTripRoute = "Via NH87 from Madurai through Ramanathapuram directly crossing Pamban road bridge into the island.",
            tollAndParkingNotes = "FASTag tolls on NH87. Paved coastal highway all the way to Arichal Munai (Dhanushkodi).",
            nearestRailwayStation = "Rameswaram (RMM - 1 km) / Mandapam (18 km)",
            nearestAirport = "Madurai International Airport (175 km)",
            busTrainFlightOptions = "Express trains connect Rameswaram to Chennai, Hyderabad, Bengaluru, Varanasi, and Delhi."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3000,
            foodEstimatePerDay = 900,
            activitiesTotal = 400,
            travelEstimate = 1800,
            totalEstimateMin = 7500,
            totalEstimateMax = 18000
        )
    )

    val kanyakumari = Destination(
        id = "tamilnadu-kanyakumari",
        name = "Kanyakumari",
        state = "Tamil Nadu",
        district = "Kanyakumari",
        tagline = "The Confluence of Three Oceans & Southernmost Tip of India",
        description = "Where the Arabian Sea, the Bay of Bengal, and the Indian Ocean converge in a sacred Triveni Sangam: Kanyakumari is the southernmost tip of mainland India, celebrated for simultaneous sunrise and sunset over the sea, the iconic offshore Vivekananda Rock Memorial, and the 133-foot stone statue of Tamil sage poet Thiruvalluvar.",
        rating = 4.8f,
        reviewCount = 21500,
        coverResId = null,
        categories = listOf(TravelCategory.BEACHES, TravelCategory.SPIRITUAL, TravelCategory.FAMILY_FRIENDLY, TravelCategory.ROAD_TRIPS),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Brisk cool ocean breezes, crystal clear horizon, spectacular full moon evenings (Chitra Pournami)",
            peakSeason = "November – January",
            offSeason = "June – August (Monsoon sea surges)",
            expectedCrowd = "Very High",
            temperatureRange = "22°C – 32°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("tamilnadu-kanyakumari"),
        attractions = listOf(
            Attraction(
                id = "kanya-vivekananda-rock",
                destinationId = "tamilnadu-kanyakumari",
                name = "Vivekananda Rock Memorial & Dhyana Mandapam",
                description = "Historic stone monument erected in 1970 on a rocky island 500 meters offshore where Swami Vivekananda meditated for three days in 1892, featuring a quiet meditation hall and the footprint rock of Goddess Kanya Kumari.",
                category = "Iconic Island Memorial",
                openingTime = "08:00 AM – 04:00 PM",
                closingTime = "04:00 PM",
                entryFeeAdult = "Ferry ticket ₹50, Entry ₹20",
                entryFeeChild = "₹25",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹40",
                difficultyLevel = "Easy (Short ferry crossing and steps on rock)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "First morning ferry at 08:00 AM to avoid long afternoon queues",
                tips = "Life jackets are mandatory on the 5-minute ferry transfer."
            ),
            Attraction(
                id = "kanya-thiruvalluvar",
                destinationId = "tamilnadu-kanyakumari",
                name = "Thiruvalluvar Statue (133 Feet)",
                description = "Colossal 133-foot stone statue of saint-poet Thiruvalluvar standing on an adjacent rock island, symbolising the 133 chapters of his masterpiece treatise Tirukkural.",
                category = "Monolithic Monument",
                openingTime = "08:00 AM – 04:00 PM",
                closingTime = "04:00 PM",
                entryFeeAdult = "Included in ferry ticket",
                recommendedDurationMinutes = 45,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning alongside Vivekananda Memorial",
                tips = "You can climb inside the pedestal of the statue to see the 38-foot base representing the Virtue section of the Tirukkural."
            ),
            Attraction(
                id = "kanya-sunset-viewpoint",
                destinationId = "tamilnadu-kanyakumari",
                name = "Sunset Point & Triveni Sangam",
                description = "Unique vantage point where visitors witness the sun setting into the horizon of three merging oceans, with the full moon simultaneously rising during full moon days.",
                category = "Natural Spectacle",
                openingTime = "05:30 AM – 07:00 PM",
                closingTime = "07:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Sunrise 05:45 AM and sunset 06:15 PM",
                tips = "Gather at the eastern bathing ghat for sunrise and the western beach deck for sunset."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-kanya-sparsha-resort",
                destinationId = "tamilnadu-kanyakumari",
                name = "Sparsa Resort Kanyakumari",
                category = "Eco Beach Resort",
                minimumPrice = 4500,
                maximumPrice = 9000,
                rating = 4.6f,
                reviewCount = 2200,
                amenities = listOf("Direct Ocean Views", "Swimming Pool", "Multi-Cuisine Dining", "Ayurveda"),
                approximatePrice = "Approx. ₹5,200 / night (verify before travel)",
                phone = "+91 4652 247 041",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-kanya-sea-view",
                destinationId = "tamilnadu-kanyakumari",
                name = "Hotel Sea View",
                category = "Sea-Facing Modern Hotel",
                minimumPrice = 3200,
                maximumPrice = 6500,
                rating = 4.4f,
                reviewCount = 3100,
                amenities = listOf("Sunrise Balconies Facing Vivekananda Rock", "AC Restaurant", "Bar"),
                approximatePrice = "Approx. ₹3,800 / night (verify before travel)",
                phone = "+91 4652 247 841",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Nagercoil Nendran Chips & Pazham Pori",
                    isVegetarian = true,
                    description = "Thin crisp raw banana chips fried in fresh pure coconut oil, alongside golden battered ripe banana fritters.",
                    popularAt = "Beach promenade snack stalls"
                ),
                FoodItem(
                    name = "Coastal Seafood Thali",
                    isVegetarian = false,
                    description = "Fresh seer fish curry cooked with coconut paste, tamarind, and green chillies, served with red boiled rice.",
                    popularAt = "The Sea View Restaurant"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Madurai" to 245, "Trivandrum" to 90, "Chennai" to 705, "Bengaluru" to 665, "Kochi" to 290
            ),
            drivingTimes = mapOf(
                "Trivandrum" to "2h 15m via NH66", "Madurai" to "4h 0m via NH44", "Bengaluru" to "11h 0m"
            ),
            roadTripRoute = "The southern terminal point of National Highway 44 (NH44), connected with seamless 4-lane expressway from Madurai.",
            tollAndParkingNotes = "FASTag tolls on NH44. Ample parking lots near the ferry boarding jetty.",
            nearestRailwayStation = "Kanniyakumari (CAPE - 1 km) / Nagercoil Junction (18 km)",
            nearestAirport = "Trivandrum International Airport (TRV - 95 km)",
            busTrainFlightOptions = "Long-distance trains like the Vivek Express and Himsagar Express connect Kanyakumari directly across the length of India."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3200,
            foodEstimatePerDay = 900,
            activitiesTotal = 400,
            travelEstimate = 1800,
            totalEstimateMin = 7500,
            totalEstimateMax = 18000
        )
    )

    val tiruvannamalai = Destination(
        id = "tamilnadu-tiruvannamalai",
        name = "Tiruvannamalai",
        state = "Tamil Nadu",
        district = "Tiruvannamalai",
        tagline = "The Fire Lingam (Agni Sthalam) & Holy Mount Arunachala",
        description = "One of India's most venerated spiritual centers, Tiruvannamalai is the Agni Sthalam (Fire element) among the Pancha Bhootas, where Lord Shiva manifested as the sacred Mount Arunachala. Famed for the 25-acre Annamalaiyar Temple, the 14-km barefoot Girivalam circumambulation during full moons, and Sri Ramana Maharshi Ashram.",
        rating = 4.8f,
        reviewCount = 16200,
        coverResId = null,
        categories = listOf(TravelCategory.SPIRITUAL, TravelCategory.HERITAGE, TravelCategory.MOUNTAINS),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Pleasant winter weather, deep spiritual atmosphere, annual Karthigai Deepam festival in Nov/Dec",
            peakSeason = "November – January",
            offSeason = "April – June (Summers can reach 40°C)",
            expectedCrowd = "Very High (Chitra Pournami & Karthigai Deepam attract 2 million+ pilgrims)",
            temperatureRange = "19°C – 32°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("tamilnadu-tiruvannamalai"),
        attractions = listOf(
            Attraction(
                id = "tiru-annamalaiyar-temple",
                destinationId = "tamilnadu-tiruvannamalai",
                name = "Annamalaiyar Temple (Agni Sthalam)",
                description = "One of India's largest temple complexes covering 25 acres at the foot of Mount Arunachala, featuring four towering gopurams including the 66-meter eastern Rajagopuram, 1,000-pillared hall, and sacred Sivaganga tank.",
                category = "Pancha Bhoota Holy Sthalam",
                openingTime = "05:30 AM – 12:30 PM & 03:30 PM – 09:30 PM",
                closingTime = "09:30 PM",
                entryFeeAdult = "Free (Special darshan ₹50 – ₹100)",
                recommendedDurationMinutes = 150,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = false,
                bestTimeOfDay = "Early morning 06:00 AM or evening twilight",
                tips = "Traditional attire mandatory. The Karthigai Deepam flame lit atop Mount Arunachala is visible for 30 km."
            ),
            Attraction(
                id = "tiru-girivalam-trail",
                destinationId = "tamilnadu-tiruvannamalai",
                name = "Girivalam Path (14 km Mount Arunachala Walk)",
                description = "Sacred 14-kilometer pilgrimage footpath encircling the holy Arunachala hill passing eight guardian Ashta Lingams (Indra, Agni, Yama, Niruthi, Varuna, Vayu, Kubera, and Esanya).",
                category = "Pilgrim Trail",
                openingTime = "24 Hours (Best during full moon nights)",
                closingTime = "24 Hours",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 240,
                parkingAvailable = true,
                difficultyLevel = "Moderate (14 km flat barefoot or shod walk)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Evening 06:00 PM to night or early morning 04:30 AM",
                tips = "Devotees traditionally walk barefoot along the left side of the road with the sacred hill on their right."
            ),
            Attraction(
                id = "tiru-ramana-ashram",
                destinationId = "tamilnadu-tiruvannamalai",
                name = "Sri Ramanasramam (Ramana Maharshi Ashram)",
                description = "Serene meditation ashram where revered sage Sri Ramana Maharshi lived, taught Advaita Vedanta, and attained Mahanirvana, featuring the quiet samadhi hall, peacocks, and trail up to Virupaksha Cave.",
                category = "Meditation Sanctuary",
                openingTime = "05:00 AM – 12:30 PM & 02:00 PM – 09:00 PM",
                closingTime = "09:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                difficultyLevel = "Easy (Virupaksha cave requires gentle hill hike)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = false,
                bestTimeOfDay = "Morning 06:30 AM or 05:00 PM for deep silence meditation",
                tips = "Maintain complete silence inside the Samadhi Hall and old meditation room."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-tiru-sparsha",
                destinationId = "tamilnadu-tiruvannamalai",
                name = "Sparsa Resort Thiruvannamalai",
                category = "Eco Spiritual Resort",
                minimumPrice = 4500,
                maximumPrice = 8500,
                rating = 4.6f,
                reviewCount = 1800,
                amenities = listOf("Direct Views of Mount Arunachala", "Ayurvedic Centre", "Pure Veg Satvik Cuisine", "Yoga Shala"),
                approximatePrice = "Approx. ₹5,200 / night (verify before travel)",
                phone = "+91 4175 236 911",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Satvik South Indian Meals & Pongal",
                    isVegetarian = true,
                    description = "Piping hot ghee ven pongal seasoned with whole black pepper and cashews, paired with fresh coconut chutney.",
                    popularAt = "Hotel Ramakrishna & Sri Akshaya Bhavan"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Chennai" to 195, "Bengaluru" to 205, "Puducherry" to 105, "Vellore" to 85),
            drivingTimes = mapOf("Chennai" to "4h 0m via Tindivanam", "Bengaluru" to "4h 15m via Krishnagiri"),
            roadTripRoute = "From Chennai via NH32 to Tindivanam, then SH4 to Tiruvannamalai; from Bengaluru via NH44 to Krishnagiri then NH77.",
            tollAndParkingNotes = "State highways are scenic two-lane roads; avoid driving in town during peak full-moon days due to pedestrian zones.",
            nearestRailwayStation = "Tiruvannamalai (TNM - 2 km) / Katpadi Junction (90 km)",
            nearestAirport = "Chennai International Airport (185 km)",
            busTrainFlightOptions = "Buses run round-the-clock from Chennai (CMBT), Bengaluru (Shantinagar), and Vellore."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 700,
            activitiesTotal = 200,
            travelEstimate = 1200,
            totalEstimateMin = 4800,
            totalEstimateMax = 12000
        )
    )

    val chidambaram = Destination(
        id = "tamilnadu-chidambaram",
        name = "Chidambaram",
        state = "Tamil Nadu",
        district = "Cuddalore",
        tagline = "The Cosmic Dance of Nataraja & Akasha Sthalam",
        description = "Representing the Sky/Space element (Akasha Sthalam) among the Pancha Bhootas, Chidambaram is the sacred abode of Lord Nataraja—the cosmic dancer. Renowned for its golden-roofed sanctum (Kanaka Sabha), the mystical Chidambara Rahasyam, and nearby Pichavaram—the world's second-largest mangrove forest.",
        rating = 4.7f,
        reviewCount = 11200,
        coverResId = null,
        categories = listOf(TravelCategory.SPIRITUAL, TravelCategory.HERITAGE, TravelCategory.NATURE),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Pleasant coastal temperatures, Natyanjali Dance Festival in Feb/March during Mahashivratri",
            peakSeason = "November – February",
            offSeason = "April – June",
            expectedCrowd = "High",
            temperatureRange = "21°C – 32°C",
            suggestedDuration = "1–2 Days"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("tamilnadu-chidambaram"),
        attractions = listOf(
            Attraction(
                id = "chidam-nataraja-temple",
                destinationId = "tamilnadu-chidambaram",
                name = "Thillai Nataraja Temple & Golden Roof",
                description = "Ancient 40-acre temple complex where Shiva is worshipped in his cosmic dance posture (Ananda Tandava), featuring the gold-tiled Kanaka Sabha roof adorned with 21,600 golden tiles, and four towering 9-storey gopurams depicting all 108 Bharatanatyam dance karanas.",
                category = "Cosmic Shiva Sanctuary",
                openingTime = "06:00 AM – 12:00 PM & 05:00 PM – 10:00 PM",
                closingTime = "10:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = false,
                bestTimeOfDay = "Morning 07:00 AM or evening 06:00 PM for deeparadhana aarti",
                tips = "Observe the golden bilva leaf curtain concealing the 'Chidambara Rahasyam' (secret of formless space)."
            ),
            Attraction(
                id = "chidam-pichavaram",
                destinationId = "tamilnadu-chidambaram",
                name = "Pichavaram Mangrove Forest",
                description = "The second largest mangrove forest ecosystem in the world spread across 1,100 hectares with 4,400 large and small waterways, explored via motorized boat and rowboat rides under lush canopy tunnels.",
                category = "Nature & Mangroves",
                openingTime = "08:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "Rowboat ₹200 – ₹400, Motorboat ₹1,200 – ₹1,800",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹40",
                difficultyLevel = "Easy (Boat ride)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 08:30 AM before the sun gets high",
                tips = "Located 15 km from Chidambaram town; rowboats can enter the narrow natural tunnel channels that motorboats cannot access."
            )
        ),
        stays = emptyList(),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Chidambaram Kothsu & Idli",
                    isVegetarian = true,
                    description = "Tangy, spiced brinjal and tamarind mash seasoned with roasted lentils and curry leaves, paired with steaming idlis.",
                    popularAt = "Sri Krishna Vilas (Near Temple South Gate)"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Puducherry" to 65, "Chennai" to 220, "Thanjavur" to 110),
            drivingTimes = mapOf("Puducherry" to "1h 30m via ECR", "Chennai" to "4h 30m"),
            roadTripRoute = "Via NH32 (East Coast Road) from Puducherry through Cuddalore to Chidambaram.",
            tollAndParkingNotes = "Smooth coastal highway with shaded tree-lined avenues.",
            nearestRailwayStation = "Chidambaram (CDM - 1.5 km)",
            nearestAirport = "Puducherry Airport (65 km) / Tiruchirappalli (135 km) / Chennai (215 km)",
            busTrainFlightOptions = "All buses connecting Chennai/Puducherry to Karaikal, Thanjavur, and Kumbakonam stop at Chidambaram."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 700,
            activitiesTotal = 500,
            travelEstimate = 1200,
            totalEstimateMin = 5000,
            totalEstimateMax = 12000
        )
    )

    val chettinad = Destination(
        id = "tamilnadu-chettinad",
        name = "Chettinad (Karaikudi)",
        state = "Tamil Nadu",
        district = "Sivaganga",
        tagline = "Grand Palatial Mansions, Athangudi Tiles & Legendary Spice Cuisine",
        description = "The ancestral realm of the prosperous mercantile Nattukottai Chettiars, Chettinad is a cultural treasure trove of lavish 19th-century palatial mansions constructed with Burmese teak, Italian marble, and Belgian mirrors, alongside handmade geometric Athangudi tiles and India's most celebrated fiery spice cuisine.",
        rating = 4.8f,
        reviewCount = 8900,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.FAMILY_FRIENDLY, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Mild sunny days, pleasant evenings, comfortable for mansion walking tours",
            peakSeason = "November – February",
            offSeason = "April – June (Dry inland heat up to 40°C)",
            expectedCrowd = "Moderate",
            temperatureRange = "20°C – 32°C",
            suggestedDuration = "2–3 Days"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("tamilnadu-chettinad"),
        attractions = listOf(
            Attraction(
                id = "chet-kanadukathan-palace",
                destinationId = "tamilnadu-chettinad",
                name = "Chettinad Palace (Kanadukathan)",
                description = "Masterpiece 1912 mansion built by Dr. Annamalai Chettiyar showcasing an expansive central courtyard, carved Burmese teakwood pillars, crystal chandeliers, and Portuguese floor tiles.",
                category = "Heritage Palace",
                openingTime = "09:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "₹100",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 10:00 AM",
                tips = "Take a walking tour of Kanadukathan village to observe dozens of vintage Chettiar heritage facades."
            ),
            Attraction(
                id = "chet-athangudi-tiles",
                destinationId = "tamilnadu-chettinad",
                name = "Athangudi Tile-Making Workshop",
                description = "Artisanal heritage village where skilled craftsmen handcraft bespoke terracotta and glass-moulded tiles using local soil, cement, and vibrant mineral dyes in traditional geometric patterns.",
                category = "Artisanal Craft",
                openingTime = "09:00 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "Free (Donations to artisans welcomed)",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 11:00 AM when casting and setting is active",
                tips = "Watch the mesmerizing process where artisans pour colored liquid cement into brass stencils by hand."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-chet-visalam-cghearth",
                destinationId = "tamilnadu-chettinad",
                name = "Visalam - CGH Earth (Kanadukathan)",
                category = "Luxury Restored Chettiar Mansion",
                minimumPrice = 9500,
                maximumPrice = 18000,
                rating = 4.8f,
                reviewCount = 1100,
                amenities = listOf("100-Year-Old Authentic Mansion", "Art Deco Swimming Pool", "Masterclass Chettinad Cooking", "Bullock Cart Rides"),
                approximatePrice = "Approx. ₹11,000 / night (verify before travel)",
                phone = "+91 484 426 1710",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-chet-chidambara-vilas",
                destinationId = "tamilnadu-chettinad",
                name = "Chidambara Vilas - A Luxury Heritage Resort",
                category = "Palatial Heritage Hotel",
                minimumPrice = 8500,
                maximumPrice = 16000,
                rating = 4.8f,
                reviewCount = 980,
                amenities = listOf("110-Year-Old Palace", "Fine Dining Chettinad Banana Leaf Feast", "Heritage Walks"),
                approximatePrice = "Approx. ₹9,500 / night (verify before travel)",
                phone = "+91 4578 245 444",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Chettinad Kozhi Milagu Varuval (Pepper Chicken)",
                    isVegetarian = false,
                    description = "Country chicken tossed in freshly dry-roasted kalpaasi (black stone flower), star anise, fennel, and coarse black pepper.",
                    popularAt = "The Bangala (Karaikudi) & Visalam Dining Hall"
                ),
                FoodItem(
                    name = "Kuzhi Paniyaram & Seeyam",
                    isVegetarian = true,
                    description = "Crisp, spongy dumplings fried in special cast-iron indentation pans, served savory with spicy tomato chutney or sweet with jaggery.",
                    popularAt = "Traditional home kitchens and street tiffin stalls"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "The Bangala",
                    cuisine = "World-Famous Chettinad Fine Dining",
                    rating = 4.9f,
                    isVegFriendly = true,
                    signatureDish = "Traditional 7-Course Chettinad Banana Leaf Feast",
                    priceForTwo = "₹2,200 (Advance reservation recommended)",
                    distance = "Senjai, Karaikudi"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Madurai" to 85, "Trichy" to 90, "Chennai" to 415, "Bengaluru" to 425),
            drivingTimes = mapOf("Madurai" to "1h 30m via NH383", "Trichy" to "1h 30m via NH336"),
            roadTripRoute = "Via NH336 from Trichy through Pudukkottai to Karaikudi / Kanadukathan.",
            tollAndParkingNotes = "Quiet, smooth state highways through scenic scrubland and historic village tanks.",
            nearestRailwayStation = "Karaikkudi Junction (KKDI - 4 km) / Kanadukathan (1 km)",
            nearestAirport = "Tiruchirappalli International Airport (85 km) / Madurai (90 km)",
            busTrainFlightOptions = "Trains like the Rameswaram Express connect Karaikudi directly to Chennai Egmore."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 4500,
            foodEstimatePerDay = 1400,
            activitiesTotal = 600,
            travelEstimate = 1600,
            totalEstimateMin = 9500,
            totalEstimateMax = 24000
        )
    )

    val allChennaiHeritageDestinations = listOf(
        chennai,
        mahabalipuram,
        kanchipuram,
        thanjavur,
        kumbakonam,
        madurai,
        tiruchirappalli,
        rameswaram,
        kanyakumari,
        tiruvannamalai,
        chidambaram,
        chettinad
    )
}
