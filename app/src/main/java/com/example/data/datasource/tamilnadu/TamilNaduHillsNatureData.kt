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

object TamilNaduHillsNatureData {

    val ooty = Destination(
        id = "tamilnadu-ooty",
        name = "Ooty (Udhagamandalam)",
        state = "Tamil Nadu",
        district = "The Nilgiris",
        tagline = "The Queen of Hill Stations & Nilgiri Mountain Toy Train",
        description = "Perched at 2,240 meters amidst the Blue Mountains (Nilgiris), Ooty was established as the summer capital of the Madras Presidency. Renowned for the UNESCO-inscribed Nilgiri Mountain Railway steam toy train, century-old Government Botanical Garden, Ooty Lake, Doddabetta Peak, and eucalyptus and tea plantations.",
        rating = 4.8f,
        reviewCount = 24600,
        coverResId = null,
        categories = listOf(TravelCategory.MOUNTAINS, TravelCategory.COUPLES, TravelCategory.FAMILY_FRIENDLY, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "October – May",
            weatherSummary = "Crisp, chilly mountain climate (temperatures drop to 5°C in Dec/Jan); May hosts the annual Summer Flower Show",
            peakSeason = "April – June & December – January",
            offSeason = "July – August (Heavy monsoon downpours)",
            expectedCrowd = "Very High",
            temperatureRange = "6°C – 20°C",
            suggestedDuration = "3–4 Days"
        ),
        seasons = RegionalSeasonalHelper.createHighAltitudeSeasons("tamilnadu-ooty"),
        attractions = listOf(
            Attraction(
                id = "ooty-toy-train",
                destinationId = "tamilnadu-ooty",
                name = "Nilgiri Mountain Railway (Toy Train)",
                description = "UNESCO World Heritage 1,000 mm meter-gauge rack-and-pinion steam railway built in 1908 navigating 16 tunnels, 250 bridges, and 208 curves through breathtaking Nilgiri cliffs between Mettupalayam and Ooty.",
                category = "UNESCO World Heritage Rail",
                openingTime = "Departures 07:10 AM & 02:00 PM (Subject to schedule)",
                closingTime = "06:00 PM",
                entryFeeAdult = "First Class ₹205 – ₹600, Second Class ₹30",
                recommendedDurationMinutes = 240,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 07:10 AM departure from Mettupalayam or 02:00 PM from Ooty to Coonoor",
                tips = "Book tickets on IRCTC 120 days in advance; tickets sell out within minutes of opening."
            ),
            Attraction(
                id = "ooty-botanical-garden",
                destinationId = "tamilnadu-ooty",
                name = "Government Botanical Garden & Rose Garden",
                description = "Sprawling 55-acre terraced garden established in 1848 by the Marquess of Tweeddale, featuring over 1,000 exotic plant species, Italian gardens, a 20-million-year-old fossilized tree trunk, and Asia's largest collection of roses.",
                category = "Botanical Garden",
                openingTime = "07:00 AM",
                closingTime = "06:30 PM",
                entryFeeAdult = "₹40",
                entryFeeChild = "₹20",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹50",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "09:30 AM before midday crowds",
                tips = "Visit during May to witness the spectacular Annual Ooty Flower Show featuring flower sculptures."
            ),
            Attraction(
                id = "ooty-doddabetta-peak",
                destinationId = "tamilnadu-ooty",
                name = "Doddabetta Peak (2,637 Meters)",
                description = "The highest summit in the Nilgiri Hills offering telescope house views across the Chamundi Hills of Mysore, Coimbatore plains, and layers of blue shola valleys.",
                category = "High Mountain Peak",
                openingTime = "09:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "₹10 (Telescope house ₹5)",
                recommendedDurationMinutes = 75,
                parkingAvailable = true,
                parkingFee = "₹50",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 09:30 AM before midday fog rolls in",
                tips = "Warm jackets and caps are essential due to biting high-altitude winds."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-ooty-savoy-ihcl",
                destinationId = "tamilnadu-ooty",
                name = "Savoy - IHCL SeleQtions",
                category = "Colonial Heritage Luxury Resort",
                minimumPrice = 14000,
                maximumPrice = 32000,
                rating = 4.8f,
                reviewCount = 2600,
                amenities = listOf("180-Year-Old English Country Estate", "Fireplaces in Rooms", "High Tea on Lawns", "Jiva Spa"),
                approximatePrice = "Approx. ₹16,500 / night (verify before travel)",
                phone = "+91 423 222 5500",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-ooty-gem-park",
                destinationId = "tamilnadu-ooty",
                name = "Hotel Gem Park Ooty",
                category = "Premium Valley View Hotel",
                minimumPrice = 5200,
                maximumPrice = 9800,
                rating = 4.5f,
                reviewCount = 3100,
                amenities = listOf("Panoramic Valley Views", "Indoor Heated Pool", "Multi-Cuisine Dining"),
                approximatePrice = "Approx. ₹5,800 / night (verify before travel)",
                phone = "+91 423 244 1761",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Handmade Ooty Dark Chocolates & Fudge",
                    isVegetarian = true,
                    description = "Freshly tempered artisanal milk and dark chocolates with roasted hazelnuts, almonds, rum-raisins, and rich chocolate fudge.",
                    popularAt = "King Star Confectionery (Commercial Road - since 1942), Modern Stores"
                ),
                FoodItem(
                    name = "Ooty Varkey with Nilgiri Black Tea",
                    isVegetarian = true,
                    description = "Crumbly, layered baked puff pastry biscuits with subtle sweet and salty notes, traditionally dipped in hot aromatic Nilgiri tea.",
                    popularAt = "West Coast Bakery, Commercial Road bakeries"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Earl's Secret (Kings Cliff)",
                    cuisine = "Colonial Continental & Anglo-Indian",
                    rating = 4.7f,
                    isVegFriendly = true,
                    signatureDish = "Roast Chicken, Shepherd's Pie & Chocolate Fondant",
                    priceForTwo = "₹1,400",
                    distance = "Havelock Road"
                ),
                RestaurantItem(
                    name = "Shinkow's Chinese Restaurant",
                    cuisine = "Historic Authentic Chinese",
                    rating = 4.5f,
                    isVegFriendly = true,
                    signatureDish = "Chilli Chicken, Wonton Soup & Hakka Noodles",
                    priceForTwo = "₹750",
                    distance = "Commissioner's Road"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Coimbatore" to 85, "Bengaluru" to 275, "Mysuru" to 125, "Chennai" to 540, "Kochi" to 280
            ),
            drivingTimes = mapOf(
                "Coimbatore" to "2h 45m via Mettupalayam & Coonoor ghat",
                "Mysuru" to "3h 30m via Bandipur & Mudumalai (36 hairpin bends)",
                "Bengaluru" to "6h 0m via Mysuru Expressway & Bandipur"
            ),
            roadTripRoute = "From Bengaluru/Mysuru via NH766 through Bandipur/Mudumalai Tiger Reserves ascending Kalhatty ghat (36 hairpins) or via Gudalur.",
            tollAndParkingNotes = "Night travel (09:00 PM – 06:00 AM) through Bandipur/Mudumalai forest is strictly banned. FASTag at state borders.",
            nearestRailwayStation = "Udhagamandalam (Ooty - 1 km) / Mettupalayam (52 km)",
            nearestAirport = "Coimbatore International Airport (CJB - 88 km)",
            busTrainFlightOptions = "Regular KSRTC and SETC buses run from Bengaluru, Mysuru, Coimbatore, and Chennai."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 4200,
            foodEstimatePerDay = 1200,
            activitiesTotal = 800,
            travelEstimate = 2000,
            totalEstimateMin = 12000,
            totalEstimateMax = 30000
        )
    )

    val coonoor = Destination(
        id = "tamilnadu-coonoor",
        name = "Coonoor",
        state = "Tamil Nadu",
        district = "The Nilgiris",
        tagline = "The Tea Garden Capital of the Nilgiris & Sim's Park",
        description = "Nestled at 1,850 meters amidst rolling emerald tea slopes, Coonoor is the second largest hill station in the Nilgiris, quieter and warmer than Ooty. Renowned for Sim's Park botanical haven, Highfield Tea Factory, Lamb's Rock, and Dolphin's Nose viewpoints.",
        rating = 4.7f,
        reviewCount = 11200,
        coverResId = null,
        categories = listOf(TravelCategory.MOUNTAINS, TravelCategory.COUPLES, TravelCategory.NATURE, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "October – May",
            weatherSummary = "Delightfully pleasant climate, fresh tea aromas, morning mists",
            peakSeason = "April – June & December – January",
            offSeason = "July – August",
            expectedCrowd = "Moderate to High",
            temperatureRange = "10°C – 22°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createHighAltitudeSeasons("tamilnadu-coonoor"),
        attractions = listOf(
            Attraction(
                id = "coonoor-sims-park",
                destinationId = "tamilnadu-coonoor",
                name = "Sim's Park",
                description = "Unusual 12-hectare botanical garden laid out in 1874 combining natural shola ravines with Japanese garden landscaping, exotic pine trees, and an annual fruit show.",
                category = "Botanical Garden",
                openingTime = "09:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "₹30",
                entryFeeChild = "₹15",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹40",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 10:00 AM",
                tips = "Children can enjoy pedal boating on the small lake inside the park."
            ),
            Attraction(
                id = "coonoor-dolphins-nose",
                destinationId = "tamilnadu-coonoor",
                name = "Dolphin's Nose & Catherine Falls View",
                description = "Dramatic rocky promontory projecting 1,000 meters above sea level shaped like a dolphin's snout, providing spectacular vistas across the Catherine Falls canyon.",
                category = "Scenic Viewpoint",
                openingTime = "09:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "₹15",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 09:30 AM before valley mist obscures Catherine Falls",
                tips = "Drive through scenic tea estates of Tiger Hill on the way to the viewpoint."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-coonoor-gateway-ihcl",
                destinationId = "tamilnadu-coonoor",
                name = "The Gateway Hotel Church Road Coonoor",
                category = "Luxury Tea Plantation Hotel",
                minimumPrice = 8500,
                maximumPrice = 18000,
                rating = 4.7f,
                reviewCount = 1800,
                amenities = listOf("Colonial Architecture", "Ayurvedic Centre", "Tea Estate Walks", "Fireplace Bar"),
                approximatePrice = "Approx. ₹9,800 / night (verify before travel)",
                phone = "+91 423 222 5400",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Fresh Nilgiri Orthodox Orange Pekoe Tea",
                    isVegetarian = true,
                    description = "Golden, aromatic highland black tea with brisk floral notes, brewed fresh from estate leaves.",
                    popularAt = "Highfield Tea Factory & local tea tasting bars"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Ooty" to 18, "Coimbatore" to 70, "Bengaluru" to 290),
            drivingTimes = mapOf("Ooty" to "35m", "Coimbatore" to "2h 15m"),
            roadTripRoute = "Via NH181 from Coimbatore through Mettupalayam ascending the Coonoor ghat road.",
            tollAndParkingNotes = "Well-maintained 2-lane mountain road; watch for Nilgiri toy train level crossings.",
            nearestRailwayStation = "Coonoor (ONR - 1 km on toy train line)",
            nearestAirport = "Coimbatore International (70 km)",
            busTrainFlightOptions = "Nilgiri toy train runs between Coonoor and Ooty three times daily."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3800,
            foodEstimatePerDay = 1100,
            activitiesTotal = 500,
            travelEstimate = 1600,
            totalEstimateMin = 9500,
            totalEstimateMax = 22000
        )
    )

    val kotagiri = Destination(
        id = "tamilnadu-kotagiri",
        name = "Kotagiri",
        state = "Tamil Nadu",
        district = "The Nilgiris",
        tagline = "The Oldest & Most Peaceful Nilgiri Tea Haven",
        description = "Sitting at 1,793 meters, Kotagiri is the oldest of the three Nilgiri hill stations, chosen by the first British collector John Sullivan for its world's second-best climate. Famed for Catherine Falls, Kodanad Viewpoint overlooking the Moyar river canyon, and tranquil tea estates free from commercial crowds.",
        rating = 4.6f,
        reviewCount = 6800,
        coverResId = null,
        categories = listOf(TravelCategory.MOUNTAINS, TravelCategory.COUPLES, TravelCategory.NATURE),
        bestTime = BestTimeInfo(
            bestMonths = "October – May",
            weatherSummary = "Mild year-round climate, gentle sunny afternoons, cool evenings",
            peakSeason = "April – May & December – January",
            offSeason = "July – August",
            expectedCrowd = "Low to Moderate (Peaceful getaway)",
            temperatureRange = "11°C – 23°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createHighAltitudeSeasons("tamilnadu-kotagiri"),
        attractions = listOf(
            Attraction(
                id = "kota-kodanad-view",
                destinationId = "tamilnadu-kotagiri",
                name = "Kodanad Viewpoint",
                description = "Spectacular cliff-edge balcony providing panoramic bird's-eye views across the Mysore plateau, Bhavanisagar dam, Moyar river gorge, and the green slopes of Nilgiri Biosphere.",
                category = "Scenic Viewpoint",
                openingTime = "09:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "₹10",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 10:00 AM",
                tips = "Drive passes through manicured tea estates and the historic Kodanad estate bungalow."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-kota-tea-homestay",
                destinationId = "tamilnadu-kotagiri",
                name = "Teanest Kotagiri by Nature Resorts",
                category = "Heritage Tea Estate Homestay",
                minimumPrice = 4500,
                maximumPrice = 8500,
                rating = 4.7f,
                reviewCount = 890,
                amenities = listOf("Colonial Tea Bungalow", "Tea-Infused 7-Course Dinner", "Birdwatching Walks"),
                approximatePrice = "Approx. ₹5,200 / night (verify before travel)",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Toda Tribal Embroidered Honey & Hot Tea",
                    isVegetarian = true,
                    description = "Pure wild cliff honey harvested by indigenous Toda tribes, sweetened into fresh black tea.",
                    popularAt = "Shalom Ooty/Kotagiri tribal outlets"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Ooty" to 28, "Coonoor" to 21, "Coimbatore" to 65),
            drivingTimes = mapOf("Ooty" to "50m", "Coimbatore" to "2h 0m via Mettupalayam"),
            roadTripRoute = "Via SH15 from Mettupalayam direct to Kotagiri bypass.",
            tollAndParkingNotes = "Less congested than Ooty ghat road; very smooth driving.",
            nearestRailwayStation = "Mettupalayam (33 km)",
            nearestAirport = "Coimbatore International (65 km)",
            busTrainFlightOptions = "Buses run from Mettupalayam, Coonoor, and Ooty."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3500,
            foodEstimatePerDay = 1000,
            activitiesTotal = 400,
            travelEstimate = 1600,
            totalEstimateMin = 8500,
            totalEstimateMax = 20000
        )
    )

    val kodaikanal = Destination(
        id = "tamilnadu-kodaikanal",
        name = "Kodaikanal",
        state = "Tamil Nadu",
        district = "Dindigul",
        tagline = "The Princess of Hill Stations & The Star Lake",
        description = "Perched at 2,133 meters in the Palani Hills, Kodaikanal ('Gift of the Forest') is celebrated for its star-shaped man-made lake, Coaker's Walk cliff promenade, 122-meter Pillar Rocks, serene pine forests, blooming Kurinji flowers (blooming once every 12 years), and artisanal homemade chocolates.",
        rating = 4.8f,
        reviewCount = 22100,
        coverResId = null,
        categories = listOf(TravelCategory.MOUNTAINS, TravelCategory.COUPLES, TravelCategory.FAMILY_FRIENDLY, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "September – May",
            weatherSummary = "Cool misty climate, clear views in winter, flower blossoms in April-May",
            peakSeason = "April – June & December – January",
            offSeason = "July – August",
            expectedCrowd = "High",
            temperatureRange = "8°C – 21°C",
            suggestedDuration = "3–4 Days"
        ),
        seasons = RegionalSeasonalHelper.createHighAltitudeSeasons("tamilnadu-kodaikanal"),
        attractions = listOf(
            Attraction(
                id = "kodai-star-lake",
                destinationId = "tamilnadu-kodaikanal",
                name = "Kodaikanal Star Lake & Promenade",
                description = "Iconic 60-acre star-shaped artificial lake created in 1863, surrounded by a 5-km paved cycling pathway, rowboats, pedal boats, and pony rides.",
                category = "Lakes & Boating",
                openingTime = "06:00 AM",
                closingTime = "06:30 PM",
                entryFeeAdult = "Free (Boating ₹150 – ₹400)",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹50",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 07:00 AM for bicycle ride around the lake or 04:30 PM for boating",
                tips = "Bicycle rentals (single and tandem) available along the lake promenade."
            ),
            Attraction(
                id = "kodai-coakers-walk",
                destinationId = "tamilnadu-kodaikanal",
                name = "Coaker's Walk & Telescope House",
                description = "Pedestrian pathway winding along the edge of a steep 2,000-meter drop constructed in 1872 by Lt. Coaker, providing panoramic views across the Pambar river valley and Madurai plains.",
                category = "Cliff Promenade",
                openingTime = "07:00 AM",
                closingTime = "07:00 PM",
                entryFeeAdult = "₹30",
                entryFeeChild = "₹15",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                difficultyLevel = "Easy (Flat paved stroll)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 07:30 AM or 05:00 PM",
                tips = "On lucky misty afternoons, look out for the rare atmospheric optical phenomenon 'Brocken Spectre' (your shadow projected onto clouds with a rainbow halo)."
            ),
            Attraction(
                id = "kodai-pillar-rocks",
                destinationId = "tamilnadu-kodaikanal",
                name = "Pillar Rocks & Pine Forest",
                description = "Three vertical granite rock pillars standing 122 meters (400 feet) tall surrounded by deep mist-filled chasms, followed by cinematic groves of towering California pine trees.",
                category = "Geological Wonder & Forest",
                openingTime = "09:00 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "₹10",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹40",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "10:30 AM when morning mist clears to reveal the monoliths",
                tips = "Great location for shooting nature and portrait photos among the pine needle forest floors."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-kodai-tamara",
                destinationId = "tamilnadu-kodaikanal",
                name = "The Tamara Kodai",
                category = "Luxury Heritage Resort",
                minimumPrice = 16000,
                maximumPrice = 35000,
                rating = 4.9f,
                reviewCount = 2800,
                amenities = listOf("Restored 1840s French Monastic Property", "Heated Swimming Pool", "Elevation Spa", "Fine Dining"),
                approximatePrice = "Approx. ₹18,000 / night (verify before travel)",
                phone = "+91 80 7107 7700",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-kodai-carltons",
                destinationId = "tamilnadu-kodaikanal",
                name = "The Carlton, Kodaikanal",
                category = "5-Star Lakefront Resort",
                minimumPrice = 9500,
                maximumPrice = 22000,
                rating = 4.7f,
                reviewCount = 3400,
                amenities = listOf("Direct Kodaikanal Lakefront Lawns", "Spa", "Children's Play Area", "Multi-Cuisine Buffet"),
                approximatePrice = "Approx. ₹11,000 / night (verify before travel)",
                phone = "+91 4542 240 056",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Handmade Roasted Almond Chocolates",
                    isVegetarian = true,
                    description = "Rich artisanal dark chocolates packed with fresh whole roasted Nilgiri almonds and butterscotch.",
                    popularAt = "Potter's Shed & Chocolate Factory (PT Road)"
                ),
                FoodItem(
                    name = "Hot Tibetan Momos & Thukpa",
                    isVegetarian = false,
                    description = "Fresh steamed dumplings and hot noodle soup in crisp mountain air.",
                    popularAt = "Tibetan Kitchen near Coaker's Walk"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Cloud Street",
                    cuisine = "Wood-Fired Pizza & European Cafe",
                    rating = 4.6f,
                    isVegFriendly = true,
                    signatureDish = "Wood-Fired Quattrostagioni Pizza & Lemon Cake",
                    priceForTwo = "₹850",
                    distance = "PT Road"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Madurai" to 115, "Coimbatore" to 170, "Bengaluru" to 465, "Chennai" to 525, "Trichy" to 195
            ),
            drivingTimes = mapOf(
                "Madurai" to "3h 0m via Batlagundu", "Coimbatore" to "4h 15m via Palani", "Bengaluru" to "8h 0m via NH44"
            ),
            roadTripRoute = "Via NH44 to Dindigul, then SH36 through Batlagundu and ascending the scenic Kodai Ghat Road.",
            tollAndParkingNotes = "FASTag tolls on NH44. Well-paved 2-lane mountain road with wide overtaking bays.",
            nearestRailwayStation = "Kodai Road (KQN - 80 km) / Dindigul Junction (95 km)",
            nearestAirport = "Madurai International Airport (IXM - 130 km) / Coimbatore (175 km)",
            busTrainFlightOptions = "Direct KSRTC and SETC sleeper buses run nightly from Bengaluru, Chennai, and Coimbatore to Kodaikanal."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 4500,
            foodEstimatePerDay = 1300,
            activitiesTotal = 800,
            travelEstimate = 2200,
            totalEstimateMin = 13000,
            totalEstimateMax = 32000
        )
    )

    val yercaud = Destination(
        id = "tamilnadu-yercaud",
        name = "Yercaud",
        state = "Tamil Nadu",
        district = "Salem",
        tagline = "The Jewel of the South & Shevaroy Hill Retreat",
        description = "Nestled at 1,515 meters in the Shevaroy Hills, Yercaud ('Lake Forest') is a serene, pocket-friendly hill station famous for its emerald Emerald Lake, Killiyur Falls, orange and coffee plantations, 20-hairpin scenic ghat road, and pleasant round-the-year climate.",
        rating = 4.6f,
        reviewCount = 10800,
        coverResId = null,
        categories = listOf(TravelCategory.MOUNTAINS, TravelCategory.WEEKEND_GETAWAYS, TravelCategory.FAMILY_FRIENDLY, TravelCategory.ROAD_TRIPS),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Refreshing cool breeze, post-monsoon waterfalls flowing vigorously",
            peakSeason = "November – February & May Summer Festival",
            offSeason = "July – August",
            expectedCrowd = "Moderate to High (Weekends from Bengaluru/Chennai)",
            temperatureRange = "12°C – 25°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createHighAltitudeSeasons("tamilnadu-yercaud"),
        attractions = listOf(
            Attraction(
                id = "yerc-emerald-lake",
                destinationId = "tamilnadu-yercaud",
                name = "Yercaud Big Lake (Emerald Lake) & Anna Park",
                description = "Picturesque natural lake situated in the heart of town flanked by deer park and landscaped gardens, featuring rowboats, pedal boats, and flower gardens.",
                category = "Lakes & Leisure",
                openingTime = "08:30 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "Free (Boating ₹100 – ₹250)",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 09:30 AM or late afternoon",
                tips = "Take a peaceful stroll through the adjacent Anna Park with Japanese rockeries."
            ),
            Attraction(
                id = "yerc-killiyur-falls",
                destinationId = "tamilnadu-yercaud",
                name = "Killiyur Falls",
                description = "Stunning 90-meter cascade plunging into the deep Shevaroy valley, reached via an adventurous 300-step hike through forest trails and coffee estates.",
                category = "Waterfalls & Trek",
                openingTime = "08:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                difficultyLevel = "Moderate (Steep stepped descent and climb back)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "10:30 AM",
                tips = "Carry drinking water; best visited between October and January after the monsoon."
            ),
            Attraction(
                id = "yerc-pagoda-point",
                destinationId = "tamilnadu-yercaud",
                name = "Pagoda Point (Pyramid Point)",
                description = "East-facing vantage point named after four stone pyramid cairns built by indigenous tribes, offering panoramic vistas across the Salem plains and tribal hamlets.",
                category = "Scenic Viewpoint",
                openingTime = "06:00 AM",
                closingTime = "06:30 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 45,
                parkingAvailable = true,
                parkingFee = "₹20",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Sunrise 06:15 AM or illuminated evening city lights",
                tips = "Night view of glowing Salem city lights from the cliff edge is mesmerizing."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-yerc-great-trails-grt",
                destinationId = "tamilnadu-yercaud",
                name = "Great Trails Yercaud by GRT Hotels",
                category = "Luxury Valley View Eco Resort",
                minimumPrice = 6500,
                maximumPrice = 13000,
                rating = 4.6f,
                reviewCount = 2100,
                amenities = listOf("Skywalk Glass Bridge", "Infinity Pool overlooking Salem Valley", "Adventure Zone", "Fine Dining"),
                approximatePrice = "Approx. ₹7,200 / night (verify before travel)",
                phone = "+91 4281 222 700",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Salem Mango Kulfi & Filter Coffee",
                    isVegetarian = true,
                    description = "Rich artisanal ice cream made with regional Salem Alphonso/Malgova mango pulp, followed by freshly roasted estate coffee.",
                    popularAt = "Town lakefront cafes"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Salem" to 30, "Bengaluru" to 225, "Chennai" to 365, "Coimbatore" to 195),
            drivingTimes = mapOf("Salem" to "50m via 20 hairpin bends", "Bengaluru" to "4h 30m via NH44"),
            roadTripRoute = "From Bengaluru via NH44 to Salem, then ascending the 20-hairpin Yercaud Ghat Road (SH188).",
            tollAndParkingNotes = "Ghat road is well-engineered with paved 2-lane surface and protective parapet walls.",
            nearestRailwayStation = "Salem Junction (SA - 32 km)",
            nearestAirport = "Salem Airport (SXV - 45 km) / Tiruchirappalli (165 km) / Bengaluru (245 km)",
            busTrainFlightOptions = "TNSTC buses leave every 15 minutes from Salem Central Bus Stand to Yercaud."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3200,
            foodEstimatePerDay = 900,
            activitiesTotal = 400,
            travelEstimate = 1400,
            totalEstimateMin = 7500,
            totalEstimateMax = 18000
        )
    )

    val yelagiri = Destination(
        id = "tamilnadu-yelagiri",
        name = "Yelagiri",
        state = "Tamil Nadu",
        district = "Tirupattur",
        tagline = "The Quick Mountain Escape & Paragliding Hub",
        description = "Clusters of 14 tribal villages perched at 1,110 meters in the Eastern Ghats, Yelagiri is a peaceful, quick weekend retreat from Bengaluru and Chennai known for 14 hairpin bends named after Tamil poets, Swamimalai hill trek, Punganur Lake, and paragliding festivals.",
        rating = 4.4f,
        reviewCount = 7400,
        coverResId = null,
        categories = listOf(TravelCategory.WEEKEND_GETAWAYS, TravelCategory.MOUNTAINS, TravelCategory.ADVENTURE),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Mild hill climate, cool breezy evenings",
            peakSeason = "November – February",
            offSeason = "May – June (Warmer afternoons)",
            expectedCrowd = "Moderate",
            temperatureRange = "15°C – 28°C",
            suggestedDuration = "1–2 Days"
        ),
        seasons = RegionalSeasonalHelper.createHighAltitudeSeasons("tamilnadu-yelagiri"),
        attractions = listOf(
            Attraction(
                id = "yela-punganur-lake",
                destinationId = "tamilnadu-yelagiri",
                name = "Punganur Lake & Nature Park",
                description = "Man-made lake featuring pedal and row boating, a walking trail along the banks, and a children's play park with musical fountains.",
                category = "Lakes & Boating",
                openingTime = "08:30 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "₹20 (Boating ₹100)",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning or late afternoon",
                tips = "Rent a pedal boat for a relaxing float on the lake."
            ),
            Attraction(
                id = "yela-swamimalai-trek",
                destinationId = "tamilnadu-yelagiri",
                name = "Swamimalai Hill Trek (4,338 Feet)",
                description = "Highest peak in Yelagiri shaped like a cake, offering a popular 3 km trail through forest tracks to an ancient Shiva temple on the summit.",
                category = "Adventure Trek",
                openingTime = "06:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 180,
                parkingAvailable = true,
                difficultyLevel = "Moderate (Stepped and rock track climb)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Early morning 06:30 AM before sunrise heat",
                tips = "Stairs cut into the rock make the final ascent easy. Spectacular view of green valleys."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-yela-sterling-resort",
                destinationId = "tamilnadu-yelagiri",
                name = "Sterling Yelagiri",
                category = "Hillside Family Resort",
                minimumPrice = 3800,
                maximumPrice = 7500,
                rating = 4.3f,
                reviewCount = 1400,
                amenities = listOf("Swimming Pool", "Bonfire", "Adventure Activities", "Buffet Dining"),
                approximatePrice = "Approx. ₹4,400 / night (verify before travel)",
                phone = "+91 4179 245 427",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Forest Honey & Country Chicken Biryani",
                    isVegetarian = false,
                    description = "Pure wild honey collected from cliff hives, paired with spicy wood-fired country chicken biryani.",
                    popularAt = "Local eateries near Athanavur"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Bengaluru" to 150, "Chennai" to 225, "Vellore" to 90),
            drivingTimes = mapOf("Bengaluru" to "3h 15m via NH44", "Chennai" to "4h 30m via NH48"),
            roadTripRoute = "Via NH44 from Bengaluru towards Krishnagiri and Vaniyambadi, then ascending the 14-hairpin Ponneri ghat road.",
            tollAndParkingNotes = "FASTag tolls on NH44. The 14 hairpin bends offer designated pullout viewpoints.",
            nearestRailwayStation = "Jolarpettai Junction (JTJ - 21 km)",
            nearestAirport = "Bengaluru Kempegowda (185 km) / Chennai (220 km)",
            busTrainFlightOptions = "Trains on the Chennai-Bengaluru line stop at Jolarpettai, where taxis and local buses connect to Yelagiri."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2800,
            foodEstimatePerDay = 800,
            activitiesTotal = 300,
            travelEstimate = 1200,
            totalEstimateMin = 5500,
            totalEstimateMax = 12000
        )
    )

    val kolliHills = Destination(
        id = "tamilnadu-kolli-hills",
        name = "Kolli Hills (Kolli Malai)",
        state = "Tamil Nadu",
        district = "Namakkal",
        tagline = "The Mountain of Death & 70 Continuous Hairpin Bends",
        description = "Reaching 1,300 meters in the Eastern Ghats, Kolli Hills is legendary among driving enthusiasts for its 70 continuous, numbered hairpin bends along a single breathtaking ghat ascent. Renowned for the 300-foot Agaya Gangai waterfall, ancient Arapaleeswarar temple, herbal spices, and untouched wilderness.",
        rating = 4.6f,
        reviewCount = 5900,
        coverResId = null,
        categories = listOf(TravelCategory.ADVENTURE, TravelCategory.ROAD_TRIPS, TravelCategory.WATERFALLS, TravelCategory.MOUNTAINS),
        bestTime = BestTimeInfo(
            bestMonths = "September – March",
            weatherSummary = "Brisk cool air, thrilling misty ghat driving, high waterfall plunge",
            peakSeason = "October – February",
            offSeason = "April – June",
            expectedCrowd = "Low to Moderate",
            temperatureRange = "14°C – 26°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createHighAltitudeSeasons("tamilnadu-kolli-hills"),
        attractions = listOf(
            Attraction(
                id = "kolli-70-hairpins",
                destinationId = "tamilnadu-kolli-hills",
                name = "70 Hairpin Bends Road Trip",
                description = "India's most thrilling continuous hairpin ghat road: 70 steep, numbered switchback curves ascending through tropical rainforests with panoramic valley views.",
                category = "Adventure Road Trip",
                openingTime = "24 Hours (Daytime driving recommended)",
                closingTime = "24 Hours",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                difficultyLevel = "Moderate to Challenging (Requires skilled driving & low gears)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 07:00 AM – 09:30 AM",
                tips = "Use engine braking in 2nd gear on descent; sound horn at every blind hairpin curve."
            ),
            Attraction(
                id = "kolli-agaya-gangai",
                destinationId = "tamilnadu-kolli-hills",
                name = "Agaya Gangai Waterfalls (Ganges of the Sky)",
                description = "Magnificent 300-foot waterfall roaring into a rocky jungle pool, reached by descending 1,050 steep concrete steps down into the gorge.",
                category = "Waterfalls & Trek",
                openingTime = "07:00 AM",
                closingTime = "04:30 PM",
                entryFeeAdult = "₹20",
                recommendedDurationMinutes = 180,
                parkingAvailable = true,
                difficultyLevel = "Challenging (1,050 steep steps descent and climb back)",
                familyFriendly = false,
                childrenFriendly = false,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 08:30 AM",
                tips = "Take breaks while climbing back up the 1,050 steps; carry glucose and water."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-kolli-silverline",
                destinationId = "tamilnadu-kolli-hills",
                name = "Silverline Retreat Hotel",
                category = "Hilltop Nature Hotel",
                minimumPrice = 2400,
                maximumPrice = 4800,
                rating = 4.2f,
                reviewCount = 680,
                amenities = listOf("Panoramic Valley Views", "Restaurant", "Campfire"),
                approximatePrice = "Approx. ₹2,800 / night (verify before travel)",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Fresh Hill Pineapple & Jackfruit",
                    isVegetarian = true,
                    description = "Naturally sweet organic mountain pineapples, jackfruits, and pure medicinal forest honey.",
                    popularAt = "Roadside fruit stalls at Solakkadu"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Salem" to 85, "Namakkal" to 55, "Bengaluru" to 280, "Trichy" to 125),
            drivingTimes = mapOf("Namakkal" to "1h 45m via 70 hairpins", "Salem" to "2h 30m"),
            roadTripRoute = "From Namakkal via Karavalli checkpost where the 70 hairpin bends begin.",
            tollAndParkingNotes = "Well-paved two-lane mountain road; check brakes before ascending.",
            nearestRailwayStation = "Namakkal (55 km) / Salem (85 km)",
            nearestAirport = "Tiruchirappalli International Airport (125 km)",
            busTrainFlightOptions = "TNSTC buses connect Namakkal and Salem to Semmedu (Kolli Hills central town)."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 700,
            activitiesTotal = 300,
            travelEstimate = 1600,
            totalEstimateMin = 5500,
            totalEstimateMax = 12000
        )
    )

    val valparai = Destination(
        id = "tamilnadu-valparai",
        name = "Valparai",
        state = "Tamil Nadu",
        district = "Coimbatore",
        tagline = "The Untouched Anamalai Tea Plateau & Hornbill Eden",
        description = "Perched at 1,100 meters within the Anamalai Tiger Reserve, Valparai is reached via 40 exhilarating hairpin bends through pristine rainforests. Renowned for boundless tea plantations, endangered Lion-tailed Macaques, Great Hornbills, and the massive Sholayar Dam.",
        rating = 4.7f,
        reviewCount = 6900,
        coverResId = null,
        categories = listOf(TravelCategory.MOUNTAINS, TravelCategory.WILDLIFE, TravelCategory.NATURE, TravelCategory.ROAD_TRIPS),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Cool tea estate weather, mist rolling over reservoirs, active wildlife spotting",
            peakSeason = "November – February",
            offSeason = "June – August (Heavy monsoon downpours)",
            expectedCrowd = "Low to Moderate (Peaceful haven)",
            temperatureRange = "15°C – 25°C",
            suggestedDuration = "2–3 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("tamilnadu-valparai"),
        attractions = listOf(
            Attraction(
                id = "valp-sholayar-dam",
                destinationId = "tamilnadu-valparai",
                name = "Upper Sholayar Dam & Reservoir",
                description = "One of Asia's deepest masonry dams set amidst dense emerald tea estates and rainforest reserves, with dramatic water reflections and sunset vistas.",
                category = "Lakes & Dam",
                openingTime = "08:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Late afternoon 04:30 PM",
                tips = "Watch for Lion-tailed Macaques foraging in the canopy trees along the estate roads."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-valp-briar-bungalow",
                destinationId = "tamilnadu-valparai",
                name = "Briar Tea Bungalows Valparai",
                category = "Colonial Tea Estate Bungalow",
                minimumPrice = 5500,
                maximumPrice = 11000,
                rating = 4.7f,
                reviewCount = 640,
                amenities = listOf("Private British Planter Bungalow", "Tea Factory Visit", "Estate Walks", "Home-Cooked Dining"),
                approximatePrice = "Approx. ₹6,500 / night (verify before travel)",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Fresh Black Pepper Tea & Hot Mirchi Bajji",
                    isVegetarian = true,
                    description = "Fresh single-origin orthodox tea spiced with freshly harvested green pepper.",
                    popularAt = "Estate tea shops on Valparai main road"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Pollachi" to 65, "Coimbatore" to 105, "Kochi" to 150),
            drivingTimes = mapOf("Pollachi" to "2h 15m via 40 hairpin bends", "Coimbatore" to "3h 30m"),
            roadTripRoute = "From Pollachi through Aliyar Dam checkpost ascending the 40-hairpin Valparai ghat road.",
            tollAndParkingNotes = "Forest checkpost closes at 06:00 PM; transit must begin before 04:30 PM.",
            nearestRailwayStation = "Pollachi Junction (POY - 65 km) / Coimbatore (105 km)",
            nearestAirport = "Coimbatore International (110 km) / Kochi (150 km)",
            busTrainFlightOptions = "TNSTC buses ply every 30 minutes from Pollachi to Valparai."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3500,
            foodEstimatePerDay = 900,
            activitiesTotal = 400,
            travelEstimate = 1800,
            totalEstimateMin = 8500,
            totalEstimateMax = 20000
        )
    )

    val pollachi = Destination(
        id = "tamilnadu-pollachi",
        name = "Pollachi",
        state = "Tamil Nadu",
        district = "Coimbatore",
        tagline = "Coconut Capital & Gateway to Anamalai Tiger Reserve",
        description = "Set against the blue ramparts of the Western Ghats, Pollachi is famed for coconut groves, jaggery markets, and authentic Tamil village tourism, serving as the launchpad for Topslip, Parambikulam Tiger Reserve, and Aliyar Dam.",
        rating = 4.6f,
        reviewCount = 6100,
        coverResId = null,
        categories = listOf(TravelCategory.NATURE, TravelCategory.FAMILY_FRIENDLY, TravelCategory.WILDLIFE),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Pleasant countryside climate, scenic coconut plantations",
            peakSeason = "November – February",
            offSeason = "April – May",
            expectedCrowd = "Moderate",
            temperatureRange = "19°C – 31°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("tamilnadu-pollachi"),
        attractions = listOf(
            Attraction(
                id = "pol-topslip",
                destinationId = "tamilnadu-pollachi",
                name = "Topslip Elephant Camp (Anamalai Tiger Reserve)",
                description = "Forest eco-tourism center on the mountain crest featuring elephant safaris, van safaris through teak woodlands, and tracking herds of wild gaur and spotted deer.",
                category = "Wildlife Safari",
                openingTime = "07:00 AM – 04:00 PM",
                closingTime = "04:00 PM",
                entryFeeAdult = "Forest entry ₹50, Safari ₹200",
                recommendedDurationMinutes = 180,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 07:30 AM",
                tips = "Forest checkpost at Sethumadai closes entry by 03:00 PM."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-pol-coco-resort",
                destinationId = "tamilnadu-pollachi",
                name = "Coco Lagoon by Great Mount Resort",
                category = "Luxury Coconut Plantation Resort",
                minimumPrice = 5200,
                maximumPrice = 11000,
                rating = 4.6f,
                reviewCount = 1400,
                amenities = listOf("Villas amidst Coconut Groves", "Ayurvedic Spa", "Swimming Pool", "Village Cycles"),
                approximatePrice = "Approx. ₹5,800 / night (verify before travel)",
                phone = "+91 4259 297 057",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Kongu Nadu Mutton Chinthamani & Elaneer Payasam",
                    isVegetarian = false,
                    description = "Tender mutton pan-roasted with hand-broken red chillies, followed by chilled tender coconut pulp pudding.",
                    popularAt = "Traditional Kongu eateries in Pollachi"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Coimbatore" to 42, "Madurai" to 175, "Bengaluru" to 400),
            drivingTimes = mapOf("Coimbatore" to "1h 0m via 4-lane NH83", "Madurai" to "3h 30m"),
            roadTripRoute = "Via NH83 4-lane expressway from Coimbatore.",
            tollAndParkingNotes = "FASTag tolls on NH83.",
            nearestRailwayStation = "Pollachi Junction (POY - 1 km)",
            nearestAirport = "Coimbatore International Airport (48 km)",
            busTrainFlightOptions = "Buses leave every 10 minutes from Gandhipuram bus stand, Coimbatore."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3200,
            foodEstimatePerDay = 900,
            activitiesTotal = 500,
            travelEstimate = 1200,
            totalEstimateMin = 7000,
            totalEstimateMax = 16000
        )
    )

    val mudumalai = Destination(
        id = "tamilnadu-mudumalai",
        name = "Mudumalai",
        state = "Tamil Nadu",
        district = "The Nilgiris",
        tagline = "Tiger Reserve, Moyar Canyon & Theppakadu Elephant Camp",
        description = "Forming part of the Nilgiri Biosphere Reserve on the borders of Karnataka and Kerala, Mudumalai Tiger Reserve is home to Bengal tigers, Indian leopards, over 600 wild Asian elephants, the Oscar-winning Theppakadu Elephant Camp (The Elephant Whisperers), and dramatic Moyar River gorge.",
        rating = 4.7f,
        reviewCount = 8900,
        coverResId = null,
        categories = listOf(TravelCategory.WILDLIFE, TravelCategory.ADVENTURE, TravelCategory.FAMILY_FRIENDLY),
        bestTime = BestTimeInfo(
            bestMonths = "October – May",
            weatherSummary = "Active waterhole sightings in summer; lush green post-monsoon woods in winter",
            peakSeason = "November – April",
            offSeason = "July – August",
            expectedCrowd = "High",
            temperatureRange = "16°C – 32°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("tamilnadu-mudumalai"),
        attractions = listOf(
            Attraction(
                id = "mudu-theppakadu",
                destinationId = "tamilnadu-mudumalai",
                name = "Theppakadu Elephant Camp (The Elephant Whisperers)",
                description = "Asia's oldest elephant camp established in 1927 where mahouts and cavadis care for orphaned elephants, as featured in the Academy Award-winning documentary 'The Elephant Whisperers'.",
                category = "Wildlife Conservation",
                openingTime = "08:30 AM – 09:30 AM & 05:30 PM – 06:30 PM",
                closingTime = "06:30 PM",
                entryFeeAdult = "₹30",
                entryFeeChild = "₹20",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "08:30 AM for morning feeding session",
                tips = "Watch mahouts feed massive spiced ragi mudde balls to the resident elephants."
            ),
            Attraction(
                id = "mudu-safari",
                destinationId = "tamilnadu-mudumalai",
                name = "Mudumalai Forest Department Safari",
                description = "Guided bus and jeep safaris traversing deep bamboo forests and riverine habitats with opportunities to encounter tigers, gaur herds, dholes, and sloth bears.",
                category = "Wildlife Safari",
                openingTime = "06:30 AM – 09:00 AM & 03:30 PM – 06:00 PM",
                closingTime = "06:00 PM",
                entryFeeAdult = "Bus Safari ₹350, Jeep Safari ₹1,500 – ₹2,500",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "06:30 AM early morning safari",
                tips = "Tickets can be booked at Theppakadu forest reception counter."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-mudu-jungle-retreat",
                destinationId = "tamilnadu-mudumalai",
                name = "Jungle Retreat Masinagudi",
                category = "Eco Wildlife Lodge",
                minimumPrice = 5800,
                maximumPrice = 11000,
                rating = 4.7f,
                reviewCount = 1400,
                amenities = listOf("Natural Swimming Pool", "Cottages Facing Nilgiri Slopes", "Guided Nature Treks"),
                approximatePrice = "Approx. ₹6,800 / night (verify before travel)",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "South Indian Forest Buffet",
                    isVegetarian = true,
                    description = "Freshly prepared wholesome meals served at eco-lodges.",
                    popularAt = "Jungle Retreat dining hall"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Ooty" to 36, "Mysuru" to 90, "Bengaluru" to 235),
            drivingTimes = mapOf("Ooty" to "1h 15m via 36 hairpins", "Mysuru" to "2h 15m via Bandipur"),
            roadTripRoute = "On NH766 between Bandipur and Gudalur/Ooty.",
            tollAndParkingNotes = "Night transit strictly prohibited between 09:00 PM and 06:00 AM.",
            nearestRailwayStation = "Udhagamandalam (Ooty - 36 km) / Mysuru (90 km)",
            nearestAirport = "Coimbatore (125 km) / Mysuru (95 km)",
            busTrainFlightOptions = "Buses between Mysuru and Ooty pass directly through Theppakadu junction."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 4000,
            foodEstimatePerDay = 1000,
            activitiesTotal = 800,
            travelEstimate = 1600,
            totalEstimateMin = 8500,
            totalEstimateMax = 20000
        )
    )

    val meghamalai = Destination(
        id = "tamilnadu-meghamalai",
        name = "Meghamalai (Highwavys)",
        state = "Tamil Nadu",
        district = "Theni",
        tagline = "The Cloud Mountain & Secret Tea Wilderness",
        description = "Known as the 'Highwavys' or 'Cloud Mountain' at 1,500 meters in the Western Ghats, Meghamalai is an offbeat sanctuary of misty tea plantations, cardamom estates, roaring Suruli Falls, and the newly declared Srivilliputhur-Megamalai Tiger Reserve.",
        rating = 4.6f,
        reviewCount = 4200,
        coverResId = null,
        categories = listOf(TravelCategory.MOUNTAINS, TravelCategory.NATURE, TravelCategory.COUPLES),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Perpetual clouds, misty mountain mornings, cool breezes",
            peakSeason = "November – February",
            offSeason = "June – August",
            expectedCrowd = "Low (Untouched offbeat paradise)",
            temperatureRange = "12°C – 23°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("tamilnadu-meghamalai"),
        attractions = listOf(
            Attraction(
                id = "megha-highwavys-lake",
                destinationId = "tamilnadu-meghamalai",
                name = "Highwavys Lake & Cloud Mountain Viewpoint",
                description = "Tranquil mountain lake surrounded by rolling private tea estates where low-hanging monsoon clouds brush across the water surface.",
                category = "Scenic Lake & Mountains",
                openingTime = "06:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 07:30 AM or late afternoon",
                tips = "Look out for wild elephants visiting the reservoir banks at dusk."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-megha-briar",
                destinationId = "tamilnadu-meghamalai",
                name = "Briar Tea Bungalows Meghamalai",
                category = "Heritage Tea Planter Bungalow",
                minimumPrice = 4800,
                maximumPrice = 8500,
                rating = 4.5f,
                reviewCount = 380,
                amenities = listOf("British Colonial Estate", "Estate Nature Walks", "Home-Cooked Food"),
                approximatePrice = "Approx. ₹5,500 / night (verify before travel)",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Estate Cardamom Tea",
                    isVegetarian = true,
                    description = "Freshly brewed highland black tea spiced with freshly harvested green cardamom pods.",
                    popularAt = "Highwavys tea stalls"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Theni" to 50, "Madurai" to 125, "Kochi" to 180),
            drivingTimes = mapOf("Theni" to "2h 0m via 18 hairpin bends", "Madurai" to "3h 30m"),
            roadTripRoute = "From Theni via Chinnamanur ascending the winding mountain ghat road.",
            tollAndParkingNotes = "Forest checkpost operates at Chinnamanur base; entry closed after dark.",
            nearestRailwayStation = "Theni (50 km) / Madurai Junction (125 km)",
            nearestAirport = "Madurai International Airport (130 km)",
            busTrainFlightOptions = "TNSTC buses run from Chinnamanur and Theni to Meghamalai."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3200,
            foodEstimatePerDay = 800,
            activitiesTotal = 300,
            travelEstimate = 1800,
            totalEstimateMin = 7500,
            totalEstimateMax = 16000
        )
    )

    val hogenakkal = Destination(
        id = "tamilnadu-hogenakkal",
        name = "Hogenakkal",
        state = "Tamil Nadu",
        district = "Dharmapuri",
        tagline = "The Niagara of India & Smokin' Rocks of River Cauvery",
        description = "Where the River Cauvery splits into dozens of roaring cascades over ancient carbonatite rocks (among the oldest in South Asia), Hogenakkal ('Smoky Rocks') is world-famous for spinning circular coracle boat rides into the canyon spray, fresh fried river fish, and traditional Ayurvedic herbal massages.",
        rating = 4.6f,
        reviewCount = 13800,
        coverResId = null,
        categories = listOf(TravelCategory.WATERFALLS, TravelCategory.ADVENTURE, TravelCategory.FAMILY_FRIENDLY, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "September – March",
            weatherSummary = "Thunderous waterfall volume, clear river pools, pleasant winter sunshine",
            peakSeason = "October – January",
            offSeason = "June – July (Heavy flood currents may restrict boating)",
            expectedCrowd = "High (Weekends)",
            temperatureRange = "19°C – 32°C",
            suggestedDuration = "1–2 Days"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("tamilnadu-hogenakkal"),
        attractions = listOf(
            Attraction(
                id = "hoge-coracle-ride",
                destinationId = "tamilnadu-hogenakkal",
                name = "Cauvery Gorge Coracle Boat Safari",
                description = "Exhilarating ride in traditional circular woven-bamboo coracles (parisal) piloted by skilled boatmen right beneath roaring waterfall sheets into deep rocky gorges.",
                category = "River Adventure",
                openingTime = "08:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "Government fixed rate ₹750 per coracle (up to 4 persons)",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹40",
                difficultyLevel = "Easy to Moderate",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 08:30 AM before afternoon sun",
                tips = "Life jackets are mandatory for all passengers. Waterproof pouches for mobile phones are sold by boatmen."
            ),
            Attraction(
                id = "hoge-hanging-bridge",
                destinationId = "tamilnadu-hogenakkal",
                name = "Hogenakkal Hanging Bridge & Watchtower",
                description = "Suspension footbridge spanning over raging torrents of the Cauvery offering magnificent wide-angle panoramic views of multiple cascading branches.",
                category = "Bridge & Viewpoint",
                openingTime = "08:00 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "₹10",
                recommendedDurationMinutes = 45,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning or late afternoon",
                tips = "Breathtaking mist spray rises from the gorge during post-monsoon months."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-hoge-ttdc",
                destinationId = "tamilnadu-hogenakkal",
                name = "Hotel Tamil Nadu - TTDC Hogenakkal",
                category = "Government Riverside Hotel",
                minimumPrice = 2000,
                maximumPrice = 3800,
                rating = 4.0f,
                reviewCount = 1100,
                amenities = listOf("Walking Distance to Falls", "Restaurant", "Garden"),
                approximatePrice = "Approx. ₹2,400 / night (verify before travel)",
                website = "https://ttdconline.com",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Fresh Cauvery River Tawa Fish Fry",
                    isVegetarian = false,
                    description = "Freshly caught freshwater carp or catla marinated in fiery red chilli-garlic masala and fried crisp on large iron tawas.",
                    popularAt = "Stalls near the coracle boarding ghats"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Bengaluru" to 145, "Salem" to 85, "Dharmapuri" to 46, "Chennai" to 340),
            drivingTimes = mapOf("Bengaluru" to "3h 30m via Hosur & Rayakottai", "Dharmapuri" to "1h 0m"),
            roadTripRoute = "From Bengaluru via NH44 to Krishnagiri/Dharmapuri, then SH60 to Hogenakkal.",
            tollAndParkingNotes = "FASTag tolls on NH44. Large municipal parking ground near TTDC hotel.",
            nearestRailwayStation = "Dharmapuri (46 km) / Marandahalli (35 km)",
            nearestAirport = "Bengaluru Kempegowda (175 km) / Salem (85 km)",
            busTrainFlightOptions = "Buses run every 30 minutes between Dharmapuri and Hogenakkal."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 800,
            activitiesTotal = 600,
            travelEstimate = 1200,
            totalEstimateMin = 5000,
            totalEstimateMax = 12000
        )
    )

    val courtallam = Destination(
        id = "tamilnadu-courtallam",
        name = "Courtallam (Kutralam)",
        state = "Tamil Nadu",
        district = "Tenkasi",
        tagline = "The Spa of South India & Medicinal Herbal Falls",
        description = "Nestled amidst the Agasthyamalai hills of the Western Ghats, Courtallam is renowned as the 'Spa of South India' for its nine waterfalls—including Main Falls, Five Falls (Aintharuvi), and Old Courtallam—whose waters flow through dense forests of medicinal herbs and ayurvedic plants.",
        rating = 4.6f,
        reviewCount = 9800,
        coverResId = null,
        categories = listOf(TravelCategory.WATERFALLS, TravelCategory.FAMILY_FRIENDLY, TravelCategory.NATURE),
        bestTime = BestTimeInfo(
            bestMonths = "July – October (The 'Courtallam Season')",
            weatherSummary = "Brisk drizzling breezes ('Saaral' season), gushing herbal waterfalls",
            peakSeason = "July – September",
            offSeason = "March – May (Dry cascades)",
            expectedCrowd = "Very High during Season",
            temperatureRange = "21°C – 30°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("tamilnadu-courtallam"),
        attractions = listOf(
            Attraction(
                id = "court-main-falls",
                destinationId = "tamilnadu-courtallam",
                name = "Main Falls (Peraruvi) & Kutralanathar Temple",
                description = "The principal 60-meter waterfall crashing down natural rock shelves believed to possess medicinal properties, located directly beside the ancient Chola shrine of Lord Thirukutralanathar.",
                category = "Waterfalls & Heritage",
                openingTime = "06:00 AM",
                closingTime = "07:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 07:00 AM",
                tips = "Designated separate bathing enclosures for men and women with stainless-steel safety handrails."
            ),
            Attraction(
                id = "court-five-falls",
                destinationId = "tamilnadu-courtallam",
                name = "Five Falls (Aintharuvi)",
                description = "Unique cascade splitting into five distinct streams across rocky ledges resembling the five heads of a hooded serpent.",
                category = "Waterfalls",
                openingTime = "06:00 AM",
                closingTime = "06:30 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 75,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "09:00 AM",
                tips = "Located 4 km from Main Falls; very popular for family bathing under gentle streams."
            )
        ),
        stays = emptyList(),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Courtallam Border Parotta & Pepper Salna",
                    isVegetarian = false,
                    description = "Famous crispy flaky parottas shredded and soaked in spicy country chicken pepper salna.",
                    popularAt = "Original Courtallam Border Rahmath Parotta Stall"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Tenkasi" to 6, "Tirunelveli" to 55, "Madurai" to 160, "Trivandrum" to 105),
            drivingTimes = mapOf("Tenkasi" to "15m", "Madurai" to "3h 15m"),
            roadTripRoute = "Via NH744 through Rajapalayam and Tenkasi.",
            tollAndParkingNotes = "Paved highways; town parking fills fast during peak July-August season.",
            nearestRailwayStation = "Tenkasi Junction (TSI - 6 km)",
            nearestAirport = "Tuticorin Airport (85 km) / Trivandrum (105 km) / Madurai (160 km)",
            busTrainFlightOptions = "Trains on the Kollam-Sengottai-Madurai line stop at Tenkasi, 6 km from Courtallam."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 700,
            activitiesTotal = 200,
            travelEstimate = 1200,
            totalEstimateMin = 4800,
            totalEstimateMax = 11000
        )
    )

    val allHillsNatureDestinations = listOf(
        ooty,
        coonoor,
        kotagiri,
        kodaikanal,
        yercaud,
        yelagiri,
        kolliHills,
        valparai,
        pollachi,
        mudumalai,
        meghamalai,
        hogenakkal,
        courtallam
    )
}
