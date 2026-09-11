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

object KarnatakaCoastalHeritageData {

    val mangaluru = Destination(
        id = "karnataka-mangaluru",
        name = "Mangaluru",
        state = "Karnataka",
        district = "Dakshina Kannada",
        tagline = "The Port City of Flavors, Golden Sands & Coastal Temples",
        description = "Nestled between the Arabian Sea and the Western Ghats, Mangaluru is a coastal cultural capital famed for its distinct Tuluva heritage, legendary seafood institutions, Mangalorean Ghee Roast, Kudroli temple, and sun-kissed beaches.",
        rating = 4.7f,
        reviewCount = 14200,
        coverResId = null,
        categories = listOf(TravelCategory.BEACHES, TravelCategory.FAMILY_FRIENDLY, TravelCategory.HERITAGE, TravelCategory.ROAD_TRIPS),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Warm tropical sea breezes, clear blue skies, delightful evenings",
            peakSeason = "November – February",
            offSeason = "June – August (Heavy coastal southwest monsoon)",
            expectedCrowd = "Moderate to High",
            temperatureRange = "21°C – 32°C",
            suggestedDuration = "2–3 Days"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("karnataka-mangaluru"),
        attractions = listOf(
            Attraction(
                id = "mng-panambur-beach",
                destinationId = "karnataka-mangaluru",
                name = "Panambur Beach & Water Sports",
                description = "Clean, certified coastal beach known for thrilling jet-skiing, parasailing, international kite festivals, and striking sunsets over the Arabian Sea port breakwaters.",
                category = "Beaches & Watersports",
                openingTime = "06:00 AM",
                closingTime = "08:00 PM",
                entryFeeAdult = "Free (Watersports ₹300 – ₹800)",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹40",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "04:30 PM – 06:45 PM for sunset",
                tips = "Equipped with dedicated trained lifeguards. Camel and horse rides available for children."
            ),
            Attraction(
                id = "mng-kudroli-temple",
                destinationId = "karnataka-mangaluru",
                name = "Kudroli Gokarnanatheshwara Temple",
                description = "Consecrated in 1912 by social reformer Narayana Guru, featuring radiant golden Chola-style architecture, a grand Nataraja water fountain, and dazzling Navratri Dasara illuminations.",
                category = "Spiritual & Heritage",
                openingTime = "06:00 AM",
                closingTime = "08:30 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 75,
                parkingAvailable = true,
                parkingFee = "₹20",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Evening 06:30 PM when the entire complex is illuminated",
                tips = "Mangaluru Dasara celebrations here rival Mysuru with grand processions."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-mng-vivanta",
                destinationId = "karnataka-mangaluru",
                name = "Vivanta Mangalore Oldport Road",
                category = "Luxury Waterfront Hotel",
                minimumPrice = 6500,
                maximumPrice = 14000,
                rating = 4.6f,
                reviewCount = 2200,
                amenities = listOf("Harbour View Rooms", "Outdoor Pool", "Coastal Specialties Dining", "Fitness Center"),
                approximatePrice = "Approx. ₹7,200 / night (verify before travel)",
                phone = "+91 824 666 0420",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Mangalore Ghee Roast (Chicken / Prawn)",
                    isVegetarian = false,
                    description = "World-famous Kundapur red chilli paste roasted in generous pure country ghee with curry leaves and spices, coating tender chicken or king prawns.",
                    popularAt = "Maharaja Restaurant (Bunsiens Complex), Giri Manja's"
                ),
                FoodItem(
                    name = "Ideal's 'Gadbad' Ice Cream",
                    isVegetarian = true,
                    description = "Legendary layered sundae in a tall glass featuring strawberry, vanilla, and kesar ice cream scoops, crushed dry fruits, fruit jelly, and fresh cut fruits.",
                    popularAt = "Pabbas (Lalbagh) & Ideal Ice Cream Parlours"
                ),
                FoodItem(
                    name = "Kori Rotti with Kori Gassi",
                    isVegetarian = false,
                    description = "Crisp paper-thin sun-dried rice wafers soaked in fiery coconut-based coastal chicken curry.",
                    popularAt = "Hotel Narayana, Giri Manja's"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Giri Manja's",
                    cuisine = "Legendary Coastal Seafood",
                    rating = 4.7f,
                    isVegFriendly = false,
                    signatureDish = "Tawa Anjal (Kingfish Fry) & Ghee Squid Roast",
                    priceForTwo = "₹650",
                    distance = "Car Street, Bhavathi"
                ),
                RestaurantItem(
                    name = "Pabbas Ice Cream",
                    cuisine = "Iconic Dessert Parlour",
                    rating = 4.8f,
                    isVegFriendly = true,
                    signatureDish = "Gadbad & Tiramisu Cup",
                    priceForTwo = "₹250",
                    distance = "Lalbagh, Mangaluru"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Hyderabad" to 780, "Bengaluru" to 350, "Chennai" to 695, "Mumbai" to 890,
                "Pune" to 750, "Delhi" to 2280, "Kolkata" to 2150, "Visakhapatnam" to 1340,
                "Vijayawada" to 990, "Kochi" to 420, "Coimbatore" to 380, "Madurai" to 520
            ),
            drivingTimes = mapOf(
                "Bengaluru" to "6h 45m via Hassan NH75 & Shiradi Ghat", "Udupi" to "1h 0m", "Goa" to "5h 30m"
            ),
            roadTripRoute = "Via NH75 from Bengaluru through Kunigal, Hassan, and Sakleshpur, descending Shiradi Ghat into Mangaluru.",
            tollAndParkingNotes = "FASTag tolls on NH75. Shiradi Ghat is fully concreted four-lane with smooth transit.",
            nearestRailwayStation = "Mangaluru Central (MAQ) / Mangaluru Junction (MAJN)",
            nearestAirport = "Mangaluru International Airport (IXE - Bajpe, 12 km)",
            busTrainFlightOptions = "Vande Bharat Express to Madgaon (Goa) and Bengaluru; high-frequency flights to Mumbai, Bengaluru, Chennai, and Gulf hubs."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3200,
            foodEstimatePerDay = 1100,
            activitiesTotal = 600,
            travelEstimate = 1800,
            totalEstimateMin = 8500,
            totalEstimateMax = 22000
        )
    )

    val udupi = Destination(
        id = "karnataka-udupi",
        name = "Udupi",
        state = "Karnataka",
        district = "Udupi",
        tagline = "The Cradle of Krishna Bhakti & South Indian Vegetarian Dining",
        description = "World-renowned spiritual and culinary epicenter founded by saint Madhvacharya in the 13th century, famous for the Sri Krishna Matha with its Kanakana Kindi window, pure vegetarian Udupi cuisine, and golden coastal beaches.",
        rating = 4.8f,
        reviewCount = 15800,
        coverResId = null,
        categories = listOf(TravelCategory.SPIRITUAL, TravelCategory.BEACHES, TravelCategory.FAMILY_FRIENDLY),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Pleasant coastal temperatures, active temple festivities (Paryaya in Jan every 2 years)",
            peakSeason = "November – February",
            offSeason = "June – August",
            expectedCrowd = "Very High (Temple hours)",
            temperatureRange = "21°C – 32°C",
            suggestedDuration = "2–3 Days"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("karnataka-udupi"),
        attractions = listOf(
            Attraction(
                id = "udupi-krishna-matha",
                destinationId = "karnataka-udupi",
                name = "Sri Krishna Matha & Kanakana Kindi",
                description = "Historic 13th-century monastery where Lord Krishna is viewed exclusively through the sacred nine-holed silver-plated 'Kanakana Kindi' window, accompanied by the holy Madhva Sarovara pond.",
                category = "Spiritual Sanctuary",
                openingTime = "05:00 AM",
                closingTime = "09:30 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = false,
                bestTimeOfDay = "06:30 AM or 07:00 PM for temple chariot procession",
                tips = "Men must remove their shirts before entering the sanctum. The Anna Brahma hall serves divine free satvik lunch to all pilgrims."
            ),
            Attraction(
                id = "udupi-malpe-beach",
                destinationId = "karnataka-udupi",
                name = "Malpe Beach & Sea Walk",
                description = "Scenic white-sand coastal beach with an 800-meter paved Sea Walk breakwater into the Arabian Sea and regular ferry connections to St. Mary's Island.",
                category = "Beaches & Leisure",
                openingTime = "06:00 AM",
                closingTime = "08:30 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹40",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "05:00 PM – 06:45 PM",
                tips = "Stroll along the Sea Walk for panoramic views of fishing trawlers returning against the sunset."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-udupi-country-inn",
                destinationId = "karnataka-udupi",
                name = "Country Inn & Suites by Radisson Manipal",
                category = "Premium Modern Hotel",
                minimumPrice = 4200,
                maximumPrice = 8500,
                rating = 4.6f,
                reviewCount = 2100,
                amenities = listOf("Rooftop Pool", "Spa", "Central AC", "Multi-cuisine Restaurant"),
                approximatePrice = "Approx. ₹4,800 / night (verify before travel)",
                phone = "+91 820 662 2555",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Original Udupi Masala Dosa & Goli Baje",
                    isVegetarian = true,
                    description = "Golden crisp rice crepe layered with signature spiced potato bhaji and fresh coconut chutney, followed by crispy golden maida-curd fritters.",
                    popularAt = "Mitra Samaj (Car Street, Sri Krishna Temple complex)"
                ),
                FoodItem(
                    name = "Udupi Temple Satvik Prasada Meal",
                    isVegetarian = true,
                    description = "Steaming rice, aromatic drumstick sambar, sweet pineapple gojju, rasam, and creamy payasam served on banana leaf without onion or garlic.",
                    popularAt = "Bhojana Shaala inside Sri Krishna Matha"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Mitra Samaj",
                    cuisine = "Century-Old Satvik Vegetarian",
                    rating = 4.7f,
                    isVegFriendly = true,
                    signatureDish = "Goli Baje, Masala Dosa & Badam Halwa",
                    priceForTwo = "₹180",
                    distance = "Car Street, Sri Krishna Temple"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Bengaluru" to 400, "Mangaluru" to 55, "Gokarna" to 175, "Goa" to 290, "Hyderabad" to 770
            ),
            drivingTimes = mapOf("Mangaluru" to "1h 0m via NH66 4-lane", "Bengaluru" to "7h 30m"),
            roadTripRoute = "Via NH66 coastal 4-lane highway connecting Mangaluru, Udupi, and Kundapura.",
            tollAndParkingNotes = "Hejamadi and Sasthan tolls on NH66 (~₹65 each). Spacious parking at Sri Krishna Matha south lot.",
            nearestRailwayStation = "Udupi (UD - 3 km)",
            nearestAirport = "Mangaluru International (55 km)",
            busTrainFlightOptions = "Vande Bharat Express stops at Udupi; Konkan Railway connects to Mumbai, Goa, and Kerala."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2800,
            foodEstimatePerDay = 800,
            activitiesTotal = 400,
            travelEstimate = 1600,
            totalEstimateMin = 7000,
            totalEstimateMax = 18000
        )
    )

    val stMarysIsland = Destination(
        id = "karnataka-st-marys-island",
        name = "St. Mary's Island",
        state = "Karnataka",
        district = "Udupi",
        tagline = "National Geological Monument of Columnar Hexagonal Basalt",
        description = "A set of four small rocky islands in the Arabian Sea off Malpe, designated as a National Geological Monument for their rare vertical hexagonal columnar basaltic lava formations formed 88 million years ago when Madagascar split from India.",
        rating = 4.7f,
        reviewCount = 9200,
        coverResId = null,
        categories = listOf(TravelCategory.BEACHES, TravelCategory.NATURE, TravelCategory.FAMILY_FRIENDLY),
        bestTime = BestTimeInfo(
            bestMonths = "October – May",
            weatherSummary = "Clear turquoise Arabian sea waters, sunny island breeze",
            peakSeason = "November – March",
            offSeason = "June – September (Boats suspended during monsoon)",
            expectedCrowd = "High",
            temperatureRange = "22°C – 32°C",
            suggestedDuration = "Half Day"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("karnataka-st-marys-island"),
        attractions = listOf(
            Attraction(
                id = "st-mary-hexagonal-rocks",
                destinationId = "karnataka-st-marys-island",
                name = "Columnar Basaltic Rock Formations & Shell Beach",
                description = "Geometric polygonal basalt pillars rising up to 10 meters out of turquoise waters, accompanied by unique beaches composed entirely of crushed seashells.",
                category = "Geological Wonder",
                openingTime = "09:30 AM",
                closingTime = "05:30 PM (Ferry operations weather permitting)",
                entryFeeAdult = "Ferry ticket ₹400 per person round trip",
                entryFeeChild = "₹200",
                recommendedDurationMinutes = 150,
                parkingAvailable = true,
                difficultyLevel = "Easy (Short boat transfer)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 10:00 AM or 03:00 PM ferry",
                tips = "Single-use plastics strictly banned on the island. Swimming is prohibited near basalt rocks due to strong underwater surges."
            )
        ),
        stays = emptyList(),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Fresh Tender Coconut & Fruit Pops",
                    isVegetarian = true,
                    description = "Refreshing sweet tender coconut water enjoyed on breezy rock platforms.",
                    popularAt = "Island snack kiosks"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Malpe" to 6, "Udupi" to 11, "Mangaluru" to 60),
            drivingTimes = mapOf("Malpe" to "20m boat transfer", "Udupi" to "35m"),
            roadTripRoute = "Drive to Malpe Harbour jetty, then board authorized high-speed passenger ferries.",
            tollAndParkingNotes = "Secure vehicle parking at Malpe beach jetty lot.",
            nearestRailwayStation = "Udupi (11 km)",
            nearestAirport = "Mangaluru (60 km)",
            busTrainFlightOptions = "Autos and local town buses run between Udupi bus stand and Malpe port."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 600,
            activitiesTotal = 500,
            travelEstimate = 800,
            totalEstimateMin = 2500,
            totalEstimateMax = 6000
        )
    )

    val kaup = Destination(
        id = "karnataka-kaup",
        name = "Kaup (Kapu)",
        state = "Karnataka",
        district = "Udupi",
        tagline = "The Century-Old Lighthouse on Rugged Sea Rocks",
        description = "Located 13 km south of Udupi, Kaup is famous for its 1901 British-built 27-meter stone lighthouse perched on a massive black granite outcrop jutting into the Arabian Sea, golden sands, and scuba diving centers.",
        rating = 4.6f,
        reviewCount = 6100,
        coverResId = null,
        categories = listOf(TravelCategory.BEACHES, TravelCategory.COUPLES, TravelCategory.HERITAGE),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Breezy coastal afternoons, spectacular sunset views from lighthouse balcony",
            peakSeason = "November – February",
            offSeason = "June – August (Monsoon closure)",
            expectedCrowd = "Moderate",
            temperatureRange = "22°C – 32°C",
            suggestedDuration = "Half Day"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("karnataka-kaup"),
        attractions = listOf(
            Attraction(
                id = "kaup-lighthouse",
                destinationId = "karnataka-kaup",
                name = "Kaup Lighthouse & Sunset Outcrop",
                description = "Historical 1901 stone lighthouse offering sweeping 360-degree views of the coastline, palm-fringed villages, and endless Arabian Sea horizons.",
                category = "Heritage Lighthouse",
                openingTime = "04:00 PM – 06:30 PM (Lighthouse ascent hours)",
                closingTime = "06:30 PM",
                entryFeeAdult = "₹25 (Lighthouse stairs entry)",
                entryFeeChild = "₹10",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy (Spiral steps inside lighthouse)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "05:00 PM – 06:15 PM for sunset",
                tips = "Ascend the spiral staircase right around 05:15 PM to watch the beacon lens rotate at dusk."
            )
        ),
        stays = emptyList(),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Crispy Bonda Soup & Filter Coffee",
                    isVegetarian = true,
                    description = "Lentil bondas submerged in hot spiced lentil soup, served at roadside tiffin stalls.",
                    popularAt = "Kaup junction cafes"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Udupi" to 13, "Mangaluru" to 42, "Bengaluru" to 390),
            drivingTimes = mapOf("Udupi" to "20m", "Mangaluru" to "45m"),
            roadTripRoute = "Directly along NH66 between Padubidri and Udupi.",
            tollAndParkingNotes = "Ample parking directly behind the beach sand dunes.",
            nearestRailwayStation = "Udupi (15 km)",
            nearestAirport = "Mangaluru (45 km)",
            busTrainFlightOptions = "All Mangaluru-Udupi express buses stop at Kaup junction."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 600,
            activitiesTotal = 200,
            travelEstimate = 800,
            totalEstimateMin = 2200,
            totalEstimateMax = 5500
        )
    )

    val maravanthe = Destination(
        id = "karnataka-maravanthe",
        name = "Maravanthe",
        state = "Karnataka",
        district = "Udupi",
        tagline = "The Arabian Sea on the Left, Souparnika River on the Right",
        description = "One of the most spectacular coastal highway drives in the world: a narrow 2-km strip of land where NH66 runs with the roaring Arabian Sea on one side and the calm emerald waters of Souparnika River on the other.",
        rating = 4.7f,
        reviewCount = 5800,
        coverResId = null,
        categories = listOf(TravelCategory.ROAD_TRIPS, TravelCategory.BEACHES, TravelCategory.NATURE),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Sunny coastal highway driving, pristine sunset over the sea, tranquil river reflections",
            peakSeason = "November – February",
            offSeason = "June – August",
            expectedCrowd = "Moderate",
            temperatureRange = "22°C – 32°C",
            suggestedDuration = "1 Day"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("karnataka-maravanthe"),
        attractions = listOf(
            Attraction(
                id = "maravanthe-marine-drive",
                destinationId = "karnataka-maravanthe",
                name = "Maravanthe Beach & Souparnika River Drive",
                description = "Iconic stretch of coastal highway featuring panoramic beach pullouts, gentle waves, and river boating with Kodachadri mountain backdrop.",
                category = "Scenic Highway & Beach",
                openingTime = "24 Hours (Beach stops 06:00 AM – 07:00 PM)",
                closingTime = "07:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Late afternoon 05:00 PM for sunset over the sea",
                tips = "Park only in designated highway lay-bys for photography. River coracle rides available on the Souparnika side."
            )
        ),
        stays = emptyList(),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Coastal Kane (Ladyfish) Fry",
                    isVegetarian = false,
                    description = "Fresh ladyfish coated in semolina and chilli paste, pan-fried on coastal tawa.",
                    popularAt = "Highway dhabas near Kundapura"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Kundapura" to 15, "Udupi" to 50, "Gokarna" to 125, "Bengaluru" to 445),
            drivingTimes = mapOf("Udupi" to "50m", "Kundapura" to "15m"),
            roadTripRoute = "Straight along NH66 between Kundapura and Byndoor.",
            tollAndParkingNotes = "Smooth 4-lane divided highway with ocean-view promenade.",
            nearestRailwayStation = "Kundapura (18 km) / Byndoor Mookambika Road (20 km)",
            nearestAirport = "Mangaluru (105 km)",
            busTrainFlightOptions = "Express buses connecting Mangaluru/Udupi to Bhatkal and Karwar drive directly through Maravanthe."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 700,
            activitiesTotal = 200,
            travelEstimate = 1200,
            totalEstimateMin = 3000,
            totalEstimateMax = 7000
        )
    )

    val gokarna = Destination(
        id = "karnataka-gokarna",
        name = "Gokarna",
        state = "Karnataka",
        district = "Uttara Kannada",
        tagline = "Sacred Atmalinga Sanctuary & Bohemian Beach Cliff Treks",
        description = "Where ancient mythology meets laid-back coastal beauty: Gokarna is home to the revered Mahabaleshwar Temple enshrining the sacred Atmalinga of Lord Shiva, alongside world-famous five pristine beaches—Gokarna Beach, Kudle, Om Beach, Half Moon, and Paradise Beach—interlinked by scenic cliffside hiking trails.",
        rating = 4.8f,
        reviewCount = 18600,
        coverResId = null,
        categories = listOf(TravelCategory.BEACHES, TravelCategory.ADVENTURE, TravelCategory.SPIRITUAL, TravelCategory.COUPLES),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Golden sunny beach days, cool sea breeze, vibrant beach cafe vibes",
            peakSeason = "November – February",
            offSeason = "June – August (Monsoon swells)",
            expectedCrowd = "High",
            temperatureRange = "20°C – 32°C",
            suggestedDuration = "3–4 Days"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("karnataka-gokarna"),
        attractions = listOf(
            Attraction(
                id = "gokarna-om-beach",
                destinationId = "karnataka-gokarna",
                name = "Om Beach & Namaste Cafe",
                description = "Legendary naturally contoured beach shaped precisely like the sacred Hindu 'Om' (ॐ) symbol, featuring twin crescent coves, rocky bluffs, jet-skiing, and beachfront shacks.",
                category = "Beaches & Watersports",
                openingTime = "06:00 AM",
                closingTime = "08:00 PM",
                entryFeeAdult = "Free (Speedboat rides ₹300 – ₹600)",
                recommendedDurationMinutes = 180,
                parkingAvailable = true,
                parkingFee = "₹50",
                difficultyLevel = "Easy to Moderate",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Late afternoon for beach stroll and sunset",
                tips = "Climb the rocky outcrop between the two curves of the 'Om' symbol for the best panoramic view."
            ),
            Attraction(
                id = "gokarna-beach-trek",
                destinationId = "karnataka-gokarna",
                name = "Five-Beach Cliff Trek (Kudle to Paradise Beach)",
                description = "Iconic 7 km coastal hiking trail traversing headlands, secret coves, and cliffs from Kudle Beach through Om Beach and Half Moon Beach to the secluded Paradise Beach.",
                category = "Adventure Trek",
                openingTime = "06:00 AM",
                closingTime = "06:30 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 240,
                parkingAvailable = true,
                difficultyLevel = "Moderate (Rocky cliff paths)",
                familyFriendly = false,
                childrenFriendly = false,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Start early by 07:00 AM or 03:00 PM",
                tips = "Wear sturdy footwear. Fishing boats ferry trekkers back to Om Beach from Paradise Beach for ~₹200 per person."
            ),
            Attraction(
                id = "gokarna-mahabaleshwar",
                destinationId = "karnataka-gokarna",
                name = "Mahabaleshwar Temple & Kotiteertha Tank",
                description = "4th-century CE classical Dravidian stone temple enshrining the Pranalinga (Atmalinga) gifted by Lord Shiva to Ravana, accompanied by the holy Kotiteertha temple tank.",
                category = "Spiritual & Heritage",
                openingTime = "06:00 AM – 12:30 PM & 05:00 PM – 08:30 PM",
                closingTime = "08:30 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = false,
                bestTimeOfDay = "Morning 06:30 AM",
                tips = "Traditional attire mandatory: men in dhoti/mundu (no shirts inside sanctum); women in sarees/salwar."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-gokarna-cghearth",
                destinationId = "karnataka-gokarna",
                name = "SwaSwara - CGH Earth",
                category = "Luxury Wellness & Yoga Retreat",
                minimumPrice = 24000,
                maximumPrice = 45000,
                rating = 4.9f,
                reviewCount = 1200,
                amenities = listOf("Om Beach Direct Access", "Ayurvedic Spa", "Daily Yoga & Meditation", "Satvik Seafood Dining"),
                approximatePrice = "Approx. ₹26,000 / night (all-inclusive wellness)",
                phone = "+91 484 426 1710",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-gokarna-kudle-resort",
                destinationId = "karnataka-gokarna",
                name = "Kudle Beach View Resort & Spa",
                category = "Mid-Range Beach Resort",
                minimumPrice = 3800,
                maximumPrice = 7500,
                rating = 4.4f,
                reviewCount = 2400,
                amenities = listOf("Swimming Pool overlooking Kudle Beach", "Ayurveda", "Multi-cuisine Cafe"),
                approximatePrice = "Approx. ₹4,500 / night (verify before travel)",
                phone = "+91 8386 257 044",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Nutella Banana Crepes & Wood-Fired Pizza",
                    isVegetarian = true,
                    description = "Thin-crust sourdough pizza and fresh fruit crepes served right on the beach sand.",
                    popularAt = "Namaste Cafe (Om Beach) & Cafe 1984 (Kudle)"
                ),
                FoodItem(
                    name = "Fresh Catch Kingfish Masala Fry",
                    isVegetarian = false,
                    description = "Freshly hooked Arabian Sea kingfish marinated in coastal kokum-chilli masala and pan-fried.",
                    popularAt = "Chez Christophe & Kudle beach shacks"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Namaste Cafe",
                    cuisine = "Beachfront Continental & Indian",
                    rating = 4.5f,
                    isVegFriendly = true,
                    signatureDish = "Seafood Platter & Shakshuka",
                    priceForTwo = "₹850",
                    distance = "Om Beach"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Hyderabad" to 680, "Bengaluru" to 485, "Chennai" to 770, "Mumbai" to 690,
                "Pune" to 550, "Delhi" to 2050, "Kolkata" to 2080, "Visakhapatnam" to 1290,
                "Vijayawada" to 920, "Kochi" to 620, "Coimbatore" to 540, "Madurai" to 680
            ),
            drivingTimes = mapOf(
                "Bengaluru" to "8h 30m via Tumakuru & Shivamogga", "Goa" to "3h 0m", "Hubballi" to "3h 15m"
            ),
            roadTripRoute = "From Bengaluru via NH48 to Chitradurga, then through Ranebennur, Sirsi, and Mirjan on NH66.",
            tollAndParkingNotes = "FASTag tolls on expressway sections. Om Beach parking can fill by 04:00 PM on weekends.",
            nearestRailwayStation = "Gokarna Road (GOK - 8 km) / Kumta (30 km)",
            nearestAirport = "Goa International Dabolim / Mopa (140 km) / Hubballi (150 km)",
            busTrainFlightOptions = "Konkan Railway Matsyagandha Express and daily KSRTC sleeper buses connect Bengaluru, Mumbai, and Mangaluru."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3200,
            foodEstimatePerDay = 1100,
            activitiesTotal = 600,
            travelEstimate = 2000,
            totalEstimateMin = 9500,
            totalEstimateMax = 24000
        )
    )

    val murudeshwar = Destination(
        id = "karnataka-murudeshwar",
        name = "Murudeshwar",
        state = "Karnataka",
        district = "Uttara Kannada",
        tagline = "World's Second Tallest Shiva Statue & 20-Storey Gopuram",
        description = "Perched dramatically on Kanduka Hill surrounded on three sides by the Arabian Sea, Murudeshwar features a colossal 123-foot (37m) statue of Lord Shiva, a soaring 249-foot 20-storey Raja Gopuram with elevator viewing gallery, and Netrani Island scuba diving.",
        rating = 4.8f,
        reviewCount = 17500,
        coverResId = null,
        categories = listOf(TravelCategory.SPIRITUAL, TravelCategory.BEACHES, TravelCategory.FAMILY_FRIENDLY),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Breezy coastal weather, crystal clear waters for scuba diving at Netrani Island",
            peakSeason = "November – February",
            offSeason = "June – August (Monsoon sea swells)",
            expectedCrowd = "Very High",
            temperatureRange = "21°C – 32°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("karnataka-murudeshwar"),
        attractions = listOf(
            Attraction(
                id = "muru-shiva-statue",
                destinationId = "karnataka-murudeshwar",
                name = "123-Foot Lord Shiva Statue & Cave Museum",
                description = "Majestic silver-coated monolithic statue of Lord Shiva seated in padmasana against the sapphire Arabian Sea backdrop, with an underground diorama museum depicting the Atmalinga legend.",
                category = "Iconic Monument",
                openingTime = "06:00 AM",
                closingTime = "08:30 PM",
                entryFeeAdult = "Free (Cave museum ₹10)",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹40",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 07:30 AM or lit up in golden light at sunset",
                tips = "Take the elevator to the 18th floor of the Raja Gopuram (₹20) for breathtaking bird's-eye views of the Shiva statue and sea."
            ),
            Attraction(
                id = "muru-netrani-island",
                destinationId = "karnataka-murudeshwar",
                name = "Netrani Island Scuba Diving (Pigeon Island)",
                description = "Heart-shaped coral island 19 km off the Murudeshwar coast, celebrated as India's premier continental scuba diving destination with coral reefs, whale sharks, and manta rays.",
                category = "Scuba Diving & Marine Life",
                openingTime = "07:30 AM – 03:30 PM (October – May only)",
                closingTime = "03:30 PM",
                entryFeeAdult = "Discovery Scuba Dive ₹3,500 – ₹5,000 per person (with boat transfer & gear)",
                recommendedDurationMinutes = 300,
                parkingAvailable = true,
                difficultyLevel = "Moderate (Boat ride and open water dive)",
                familyFriendly = true,
                childrenFriendly = false,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 08:00 AM boat departure",
                tips = "PADI certified instructors guide first-time divers; underwater photos and videos are included."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-muru-rn-residence",
                destinationId = "karnataka-murudeshwar",
                name = "RNS Residency Sea View",
                category = "Oceanfront Hotel",
                minimumPrice = 3800,
                maximumPrice = 7500,
                rating = 4.4f,
                reviewCount = 3800,
                amenities = listOf("Direct Panoramic Shiva Statue Views", "Sea-facing Balconies", "Veg Restaurant", "Swimming Pool"),
                approximatePrice = "Approx. ₹4,400 / night (verify before travel)",
                phone = "+91 8385 268 901",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "South Indian Thali & Coastal Fish Curry",
                    isVegetarian = true,
                    description = "Pure vegetarian temple thalis at temple complex and fresh coastal seafood at beach promenade.",
                    popularAt = "Naveen Beach Restaurant (suspended on sea rocks)"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Naveen Beach Restaurant",
                    cuisine = "Sea-Facing Coastal & Multi-Cuisine",
                    rating = 4.3f,
                    isVegFriendly = true,
                    signatureDish = "Tawa Surmai Fry & North Indian Platters",
                    priceForTwo = "₹650",
                    distance = "Near Temple Beach"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Bengaluru" to 480, "Mangaluru" to 155, "Gokarna" to 78, "Goa" to 200, "Hyderabad" to 710
            ),
            drivingTimes = mapOf("Mangaluru" to "3h 0m via NH66", "Gokarna" to "1h 30m", "Bengaluru" to "8h 30m"),
            roadTripRoute = "Directly along NH66 4-lane coastal highway.",
            tollAndParkingNotes = "Shiroda and Bhatkal tolls on NH66. Massive multi-level parking at temple entrance.",
            nearestRailwayStation = "Murdeshwar (MRDW - 2 km)",
            nearestAirport = "Mangaluru (160 km) / Goa (195 km)",
            busTrainFlightOptions = "All Konkan Railway express trains and KSRTC Rajahamsa buses connect Murudeshwar directly."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3000,
            foodEstimatePerDay = 900,
            activitiesTotal = 1500,
            travelEstimate = 1800,
            totalEstimateMin = 8500,
            totalEstimateMax = 22000
        )
    )

    val karwar = Destination(
        id = "karnataka-karwar",
        name = "Karwar",
        state = "Karnataka",
        district = "Uttara Kannada",
        tagline = "Rabindranath Tagore's Coastal Muse & Kali River Estuary",
        description = "Situated at the mouth of the Kali river near the Goa border, Karwar inspired Nobel laureate Rabindranath Tagore to pen his first dramatic poem. Famed for Tagore Beach, INS Chapal Warship Museum, Devbagh Island, and delicious Karwari seafood.",
        rating = 4.6f,
        reviewCount = 6500,
        coverResId = null,
        categories = listOf(TravelCategory.BEACHES, TravelCategory.HERITAGE, TravelCategory.FAMILY_FRIENDLY),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Breezy coastal weather, calm blue waters in Kali estuary",
            peakSeason = "November – February",
            offSeason = "June – August",
            expectedCrowd = "Moderate",
            temperatureRange = "22°C – 32°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("karnataka-karwar"),
        attractions = listOf(
            Attraction(
                id = "karwar-warship-museum",
                destinationId = "karnataka-karwar",
                name = "INS Chapal Warship Museum (K94)",
                description = "Decommissioned 1971 Indo-Pak war missile boat turned into a walk-through museum on the sands of Tagore Beach, displaying torpedoes, missiles, and naval history.",
                category = "Maritime Museum",
                openingTime = "10:00 AM – 01:00 PM & 04:30 PM – 07:30 PM",
                closingTime = "07:30 PM",
                entryFeeAdult = "₹25",
                entryFeeChild = "₹15",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                parkingFee = "₹20",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Late afternoon 05:00 PM",
                tips = "Climb to the bridge deck to see original navigation dials and radar controls."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-karwar-devbagh",
                destinationId = "karnataka-karwar",
                name = "Devbagh Beach Resort (Jungle Lodges)",
                category = "Island Beach Resort",
                minimumPrice = 5500,
                maximumPrice = 11000,
                rating = 4.4f,
                reviewCount = 950,
                amenities = listOf("Log Huts under Casuarina Groves", "Water Sports", "Dolphin Spotting Cruises", "Buffet Meals"),
                approximatePrice = "Approx. ₹6,500 / person (all-inclusive)",
                website = "https://junglelodges.com",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Karwari Tisrya (Clam) Sukka",
                    isVegetarian = false,
                    description = "Fresh estuary clams cooked with grated coconut, fennel seeds, and kokum, served with hot rice.",
                    popularAt = "Swetha Lunch Home (Karwar)"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Goa (Panaji)" to 90, "Gokarna" to 60, "Bengaluru" to 520, "Mumbai" to 650),
            drivingTimes = mapOf("Goa" to "1h 45m", "Gokarna" to "1h 15m"),
            roadTripRoute = "Directly along NH66 on the Karnataka-Goa border.",
            tollAndParkingNotes = "Wide bridge over the Kali river provides scenic river estuary panoramas.",
            nearestRailwayStation = "Karwar (KAWR - 6 km)",
            nearestAirport = "Goa Dabolim Airport (85 km) / Mopa (130 km)",
            busTrainFlightOptions = "Konkan Railway trains connect Karwar to Mumbai, Goa, and Mangaluru."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3000,
            foodEstimatePerDay = 900,
            activitiesTotal = 500,
            travelEstimate = 1800,
            totalEstimateMin = 7500,
            totalEstimateMax = 18000
        )
    )

    val dandeli = Destination(
        id = "karnataka-dandeli",
        name = "Dandeli",
        state = "Karnataka",
        district = "Uttara Kannada",
        tagline = "The White-Water Rafting & Hornbill Sanctuary Capital",
        description = "Flanked by the untamed rapids of the River Kali and thick teak canopy of the Anshi National Park, Dandeli is South India's premier adventure destination for Grade 3 white-water rafting, natural rock jacuzzis, coracle safaris, and Great Hornbill birding.",
        rating = 4.7f,
        reviewCount = 12400,
        coverResId = null,
        categories = listOf(TravelCategory.ADVENTURE, TravelCategory.WILDLIFE, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "October – May",
            weatherSummary = "River Kali water release ensures thrilling rafting rapids; winter is prime for birdwatching",
            peakSeason = "November – March",
            offSeason = "July – August (Heavy monsoon river surges)",
            expectedCrowd = "High (Weekends)",
            temperatureRange = "16°C – 32°C",
            suggestedDuration = "2–3 Days"
        ),
        seasons = RegionalSeasonalHelper.createWesternGhatsSeasons("karnataka-dandeli"),
        attractions = listOf(
            Attraction(
                id = "dandeli-kali-rafting",
                destinationId = "karnataka-dandeli",
                name = "River Kali White-Water Rafting",
                description = "Thrilling 9.5 km river run navigating 8 exhilarating Grade 2 and Grade 3 rapids with names like Adi's Beard and Stanley's Squeeze under trained river guides.",
                category = "Adventure & River",
                openingTime = "08:30 AM – 03:30 PM",
                closingTime = "03:30 PM",
                entryFeeAdult = "₹1,400 – ₹1,800 per person (Long run 9 km)",
                recommendedDurationMinutes = 180,
                parkingAvailable = true,
                difficultyLevel = "Moderate to Challenging (Safety gear & briefings included)",
                familyFriendly = true,
                childrenFriendly = false,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Morning batch 09:00 AM",
                tips = "Life jackets and helmets provided. Rafting depends on daily dam water release schedule."
            ),
            Attraction(
                id = "dandeli-syntheri-rocks",
                destinationId = "karnataka-dandeli",
                name = "Syntheri Rocks & Kaner River Gorge",
                description = "Colossal 300-foot monolithic granite rock hollowed by the rushing Kaner river over millions of years, home to thousands of rock pigeons and wild bee hives.",
                category = "Geological Wonder",
                openingTime = "09:00 AM",
                closingTime = "05:00 PM",
                entryFeeAdult = "₹20",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Moderate (200 paved steps down into gorge)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "10:30 AM",
                tips = "Swimming is strictly banned due to deep underwater caves and swirling torrents."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-dandeli-bison-river",
                destinationId = "karnataka-dandeli",
                name = "Bison River Resort",
                category = "Riverside Adventure Resort",
                minimumPrice = 4200,
                maximumPrice = 8500,
                rating = 4.5f,
                reviewCount = 1700,
                amenities = listOf("Cottages Facing Kali River Rapids", "In-House Rafting Desk", "Campfire", "Kayaking"),
                approximatePrice = "Approx. ₹4,800 / person (including meals & activities)",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Malnad Bamboo Shoot & Pepper Chicken",
                    isVegetarian = false,
                    description = "Freshly harvested forest bamboo shoots cooked with local wild black pepper and tender country chicken.",
                    popularAt = "Adventure camp dining gol ghars"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Hyderabad" to 580, "Bengaluru" to 460, "Hubballi" to 75, "Goa" to 125, "Pune" to 440, "Mumbai" to 580
            ),
            drivingTimes = mapOf(
                "Hubballi" to "1h 45m", "Goa" to "2h 45m", "Bengaluru" to "8h 0m via NH48 & Dharwad"
            ),
            roadTripRoute = "From Bengaluru via NH48 through Tumakuru, Chitradurga, and Dharwad, then SH34 into Dandeli forest reserve.",
            tollAndParkingNotes = "Fast 6-lane toll expressway till Dharwad; dense jungle canopy road onwards.",
            nearestRailwayStation = "Alnavar Junction (32 km) / Londa (35 km) / Dharwad (55 km)",
            nearestAirport = "Hubballi Airport (HBX - 75 km) / Goa Dabolim (130 km)",
            busTrainFlightOptions = "KSRTC runs daily executive sleeper buses directly from Bengaluru, Mysuru, and Pune to Dandeli."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3800,
            foodEstimatePerDay = 1000,
            activitiesTotal = 2000,
            travelEstimate = 1800,
            totalEstimateMin = 9500,
            totalEstimateMax = 24000
        )
    )

    val hampi = Destination(
        id = "karnataka-hampi",
        name = "Hampi",
        state = "Karnataka",
        district = "Vijayanagara",
        tagline = "UNESCO World Heritage & The Golden Vijayanagara Empire",
        description = "One of the most awe-inspiring archaeological landscapes on Earth, Hampi was the 14th-century capital of the Vijayanagara Empire—once the second-largest city in the medieval world. Spread across 4,100 hectares of colossal granite boulders and Tungabhadra riverbanks, it features over 1,600 surviving monuments.",
        rating = 4.9f,
        reviewCount = 28400,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.ADVENTURE, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Pleasant winter weather, clear sunny skies for walking through open-air stone ruins, Hampi Utsav in January",
            peakSeason = "November – February",
            offSeason = "April – June (Scorching Deccan summer >40°C on exposed rocks)",
            expectedCrowd = "High",
            temperatureRange = "15°C – 31°C",
            suggestedDuration = "3–4 Days"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("karnataka-hampi"),
        attractions = listOf(
            Attraction(
                id = "hampi-vittala-temple",
                destinationId = "karnataka-hampi",
                name = "Vittala Temple & Iconic Stone Chariot",
                description = "The pinnacle of Vijayanagara artistic genius featuring the world-famous monolithic Stone Chariot (depicted on the ₹50 banknote) and the Ranga Mandapa with 56 musical pillars that chime musical notes when struck.",
                category = "UNESCO World Heritage",
                openingTime = "08:30 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "₹40 (Indians), ₹600 (Foreigners) - covers Zenana Enclosure on same day",
                entryFeeChild = "Free below 15 years",
                recommendedDurationMinutes = 150,
                parkingAvailable = true,
                parkingFee = "Electric buggy transfer ₹20",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "08:30 AM or 04:00 PM for golden hour lighting on stone carvings",
                tips = "Electric buggies transport visitors 1 km from the vehicle parking to the temple gate."
            ),
            Attraction(
                id = "hampi-virupaksha",
                destinationId = "karnataka-hampi",
                name = "Virupaksha Temple & Hampi Bazaar",
                description = "The oldest operating temple in Hampi functioning continuously since the 7th century CE, featuring a soaring 50-meter eastern gopuram, temple elephant Lakshmi, and an inverted pinhole camera reflection of the tower inside.",
                category = "Spiritual & Heritage",
                openingTime = "06:00 AM – 01:00 PM & 05:00 PM – 09:00 PM",
                closingTime = "09:00 PM",
                entryFeeAdult = "₹5 (Temple inner sanctum)",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Early morning 06:30 AM for aarti or evening",
                tips = "Witness the pinhole camera effect in the dark chamber on the northern rear wall."
            ),
            Attraction(
                id = "hampi-matanga-hill",
                destinationId = "karnataka-hampi",
                name = "Matanga Hill Sunrise / Sunset",
                description = "The highest point in central Hampi offering an incomparable 360-degree panoramic view across the boulder-strewn landscape, the winding Tungabhadra river, and the towers of Virupaksha Temple.",
                category = "Scenic Viewpoint & Trek",
                openingTime = "05:30 AM",
                closingTime = "06:30 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                difficultyLevel = "Moderate (Steep rock staircase and stepped path)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Sunrise 06:00 AM or sunset 05:30 PM",
                tips = "Carry a flashlight/phone light for the descent after sunset."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-hampi-evolve-back",
                destinationId = "karnataka-hampi",
                name = "Evolve Back Kamalapura Palace Hampi",
                category = "Ultra Luxury Palace Resort",
                minimumPrice = 26000,
                maximumPrice = 52000,
                rating = 4.9f,
                reviewCount = 2800,
                amenities = listOf("Vijayanagara Imperial Architecture", "Private Jacuzzis & Pools", "Olympic Sized Pool", "Curated History Walks"),
                approximatePrice = "Approx. ₹30,000 / night (verify before travel)",
                phone = "+91 80 4191 1122",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-hampi-heritage-resort",
                destinationId = "karnataka-hampi",
                name = "Heritage Resort Hampi",
                category = "Eco Heritage Resort",
                minimumPrice = 5500,
                maximumPrice = 11000,
                rating = 4.6f,
                reviewCount = 1900,
                amenities = listOf("Organic Farm Setting", "Swimming Pool", "Ayurvedic Spa", "Bicycle Rental"),
                approximatePrice = "Approx. ₹6,500 / night (verify before travel)",
                phone = "+91 8394 240 002",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "North Karnataka Jolada Rotti Oota",
                    isVegetarian = true,
                    description = "Thin, unleavened jowar (sorghum) flatbread served with fiery brinjal curry (enne gai), spicy shenga (peanut) chutney powder, raw onions, and churned white butter.",
                    popularAt = "Mango Tree Restaurant (Near Kamalapur) & local Khanavalis"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Mango Tree Restaurant",
                    cuisine = "Eclectic Backpackers & Regional Indian",
                    rating = 4.7f,
                    isVegFriendly = true,
                    signatureDish = "Special Thali, Falafel Platters & Banana Lassi",
                    priceForTwo = "₹550",
                    distance = "Kamalapur Road"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Hyderabad" to 370, "Bengaluru" to 345, "Chennai" to 580, "Mumbai" to 740,
                "Pune" to 570, "Delhi" to 1890, "Kolkata" to 1750, "Visakhapatnam" to 890,
                "Vijayawada" to 510, "Kochi" to 840, "Coimbatore" to 680, "Madurai" to 780
            ),
            drivingTimes = mapOf(
                "Bengaluru" to "5h 45m via NH48 & Chitradurga (NH50)", "Hyderabad" to "7h 0m via Mahabubnagar & Raichur", "Hubballi" to "3h 0m"
            ),
            roadTripRoute = "From Bengaluru via NH48 to Chitradurga, then 4-lane NH50 directly to Hosapete / Hampi.",
            tollAndParkingNotes = "FASTag tolls on NH48 and NH50. Ample parking lots near Kamalapur archaeological museum and Hampi Bazaar.",
            nearestRailwayStation = "Hosapete Junction (HPT - 12 km)",
            nearestAirport = "Jindal Vidyanagar Airport, Toranagallu (VDY - 35 km) / Hubballi (145 km) / Bengaluru (350 km)",
            busTrainFlightOptions = "Hampi Express runs daily overnight from KSR Bengaluru to Hosapete; direct flights connect Bengaluru and Hyderabad to Jindal Vidyanagar Airport."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3500,
            foodEstimatePerDay = 1000,
            activitiesTotal = 800,
            travelEstimate = 1800,
            totalEstimateMin = 9500,
            totalEstimateMax = 25000
        )
    )

    val badami = Destination(
        id = "karnataka-badami",
        name = "Badami",
        state = "Karnataka",
        district = "Bagalkot",
        tagline = "Chalukya Rock-Cut Cave Temples & Agastya Lake",
        description = "The ancient capital of the Early Chalukyas from 540 to 757 CE (formerly Vatapi), Badami is celebrated for four magnificent 6th-century rock-cut cave temples hewn into dramatic red sandstone cliffs overlooking the sacred Agastya Lake and Bhutanatha temple.",
        rating = 4.7f,
        reviewCount = 9800,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.WEEKEND_GETAWAYS, TravelCategory.ADVENTURE),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Pleasant winter days, crisp golden lighting on sandstone cliffs",
            peakSeason = "November – February",
            offSeason = "April – June (Hot Deccan summer)",
            expectedCrowd = "Moderate to High",
            temperatureRange = "16°C – 32°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("karnataka-badami"),
        attractions = listOf(
            Attraction(
                id = "badami-caves",
                destinationId = "karnataka-badami",
                name = "Badami Rock-Cut Cave Temples (Caves 1–4)",
                description = "Masterpiece 6th-century rock-cut shrines carved into sheer red sandstone cliffs: Cave 1 (18-armed dancing Nataraja), Cave 2 (Vishnu Trivikrama), Cave 3 (colossal Vishnu Varaha), and Cave 4 (Jain Tirthankaras).",
                category = "Archaeological Wonder",
                openingTime = "09:00 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "₹25 (Indians), ₹300 (Foreigners)",
                recommendedDurationMinutes = 150,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Moderate (Stepped rock walkways)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "09:30 AM or late afternoon 04:00 PM",
                tips = "Monkeys on the cave stairs can snatch open food items; keep bags securely zipped."
            ),
            Attraction(
                id = "badami-bhutanatha",
                destinationId = "karnataka-badami",
                name = "Bhutanatha Temple & Agastya Lake",
                description = "Iconic 7th-century sandstone temple complex extending directly into the serene green waters of Agastya Lake against towering red cliffs.",
                category = "Heritage & Lake",
                openingTime = "06:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 75,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Sunset 05:15 PM for glowing red rock reflections in the water",
                tips = "One of India's most evocative architectural photography locations."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-badami-court",
                destinationId = "karnataka-badami",
                name = "Badami Court Hotel",
                category = "Heritage Standard Hotel",
                minimumPrice = 3200,
                maximumPrice = 5800,
                rating = 4.3f,
                reviewCount = 1100,
                amenities = listOf("Swimming Pool", "Multi-Cuisine Restaurant", "Garden Lawn"),
                approximatePrice = "Approx. ₹3,600 / night (verify before travel)",
                phone = "+91 8357 220 210",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Badami Jolada Rotti with Shenga Chutney",
                    isVegetarian = true,
                    description = "Fresh jowar rotis served with spicy peanut powder and curd.",
                    popularAt = "Local eateries near bus stand"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Hubballi" to 105, "Bengaluru" to 450, "Hyderabad" to 420, "Goa" to 240),
            drivingTimes = mapOf("Hubballi" to "2h 15m", "Bengaluru" to "7h 30m via NH48"),
            roadTripRoute = "From Hubballi via Navalgund and Nargund on NH218 / NH52.",
            tollAndParkingNotes = "Two-lane well-paved state highway through sunflower and cotton fields.",
            nearestRailwayStation = "Badami (BDM - 4 km)",
            nearestAirport = "Hubballi Airport (105 km)",
            busTrainFlightOptions = "Trains connect Badami to Bengaluru, Hubballi, Bijapur, and Solapur."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2800,
            foodEstimatePerDay = 800,
            activitiesTotal = 400,
            travelEstimate = 1600,
            totalEstimateMin = 6500,
            totalEstimateMax = 16000
        )
    )

    val aihole = Destination(
        id = "karnataka-aihole",
        name = "Aihole",
        state = "Karnataka",
        district = "Bagalkot",
        tagline = "The Cradle of Indian Hindu Temple Architecture",
        description = "Described as the laboratory of Indian temple architecture, Aihole boasts over 120 stone and rock-cut temples dating from the 5th to 12th centuries CE, where Chalukyan artisans experimented with and developed classical Nagara and Dravidian architectural forms.",
        rating = 4.6f,
        reviewCount = 6100,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.FAMILY_FRIENDLY),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Pleasant winter weather, comfortable for exploring open-air temple monuments",
            peakSeason = "November – February",
            offSeason = "April – June",
            expectedCrowd = "Moderate",
            temperatureRange = "16°C – 32°C",
            suggestedDuration = "1 Day"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("karnataka-aihole"),
        attractions = listOf(
            Attraction(
                id = "aihole-durga-temple",
                destinationId = "karnataka-aihole",
                name = "Durga Temple Complex (Apsidal Plan)",
                description = "Iconic late 7th-century apsidal temple featuring a unique semi-circular sanctum echoing Buddhist chaitya halls, adorned with stunning stone relief sculptures of Mahishasuramardini and Narasimha.",
                category = "Archaeological Marvel",
                openingTime = "09:00 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "₹25 (Indians), ₹300 (Foreigners)",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 10:00 AM",
                tips = "Explore the ASI Archaeological Museum within the complex housing rare Chalukya sculptures."
            )
        ),
        stays = emptyList(),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "North Karnataka Veg Meals",
                    isVegetarian = true,
                    description = "Jowar rotis, dal saaru, vegetable palya, and buttermilk.",
                    popularAt = "KSTDC Mayura restaurant near monument gate"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Badami" to 34, "Pattadakal" to 14, "Bengaluru" to 470),
            drivingTimes = mapOf("Badami" to "45m", "Pattadakal" to "20m"),
            roadTripRoute = "Direct country highway connecting Badami, Pattadakal, and Aihole.",
            tollAndParkingNotes = "Paved rural road with roadside agricultural landscapes.",
            nearestRailwayStation = "Badami (34 km) / Bagalkot (40 km)",
            nearestAirport = "Hubballi (135 km)",
            busTrainFlightOptions = "Combine Badami, Pattadakal, and Aihole into a seamless 2-day circuit by private car or auto."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 600,
            activitiesTotal = 300,
            travelEstimate = 1000,
            totalEstimateMin = 4000,
            totalEstimateMax = 9000
        )
    )

    val pattadakal = Destination(
        id = "karnataka-pattadakal",
        name = "Pattadakal",
        state = "Karnataka",
        district = "Bagalkot",
        tagline = "UNESCO World Heritage & Royal Coronation Sanctuary",
        description = "Designated as a UNESCO World Heritage site, Pattadakal was the holy ceremonial ground where Early Chalukyan kings were crowned. The temple complex represents the harmonious culmination of northern Nagara and southern Dravidian architectural styles on the Malaprabha riverbanks.",
        rating = 4.8f,
        reviewCount = 8900,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.FAMILY_FRIENDLY),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Sunny winter days, cool mornings, crisp photo illumination on stone carvings",
            peakSeason = "November – February",
            offSeason = "April – June",
            expectedCrowd = "Moderate to High",
            temperatureRange = "16°C – 32°C",
            suggestedDuration = "Half Day"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("karnataka-pattadakal"),
        attractions = listOf(
            Attraction(
                id = "patta-virupaksha-temple",
                destinationId = "karnataka-pattadakal",
                name = "Virupaksha & Mallikarjuna Temples",
                description = "Magnificent 8th-century temple built by Queen Lokamahadevi in 740 CE to commemorate King Vikramaditya II's victory over the Pallavas, featuring intricate Ramayana, Mahabharata, and Panchatantra narrative stone friezes.",
                category = "UNESCO World Heritage",
                openingTime = "09:00 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "₹40 (Indians), ₹600 (Foreigners)",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy (Manicured lawns and paved paths)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "03:30 PM – 05:30 PM for warm golden lighting",
                tips = "Compare the Dravidian Virupaksha temple directly beside the northern curvilinear Nagara-style Papanatha temple."
            )
        ),
        stays = emptyList(),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Tender Coconut & Mirchi Bajji",
                    isVegetarian = true,
                    description = "Crisp deep-fried stuffed chilli fritters and sweet coconut water outside monument gate.",
                    popularAt = "Local stalls outside Pattadakal gate"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Badami" to 22, "Aihole" to 14, "Hubballi" to 125),
            drivingTimes = mapOf("Badami" to "30m", "Hubballi" to "2h 45m"),
            roadTripRoute = "Via Badami-Pattadakal state highway.",
            tollAndParkingNotes = "Spacious parking lot directly opposite the ASI ticket counter.",
            nearestRailwayStation = "Badami (22 km)",
            nearestAirport = "Hubballi (125 km)",
            busTrainFlightOptions = "Easily reached via taxi or auto-rickshaw from Badami."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 600,
            activitiesTotal = 300,
            travelEstimate = 800,
            totalEstimateMin = 3500,
            totalEstimateMax = 8000
        )
    )

    val bijapur = Destination(
        id = "karnataka-bijapur",
        name = "Bijapur (Vijayapura)",
        state = "Karnataka",
        district = "Vijayapura",
        tagline = "The City of Domes, Gol Gumbaz & Adil Shahi Grandeur",
        description = "The historic capital of the Adil Shahi dynasty from 1489 to 1686, Bijapur is celebrated for the Gol Gumbaz—possessing the world's second-largest unsupported dome with a whispering gallery that repeats sounds 11 times—and the elegant Ibrahim Rauza.",
        rating = 4.6f,
        reviewCount = 10400,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.FAMILY_FRIENDLY),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Mild winter temperatures, pleasant for monument exploration",
            peakSeason = "November – February",
            offSeason = "April – June (Summers reach 42°C)",
            expectedCrowd = "Moderate to High",
            temperatureRange = "15°C – 31°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("karnataka-bijapur"),
        attractions = listOf(
            Attraction(
                id = "bija-gol-gumbaz",
                destinationId = "karnataka-bijapur",
                name = "Gol Gumbaz & Whispering Gallery",
                description = "The massive 1656 CE mausoleum of Mohammed Adil Shah featuring a colossal 44-meter diameter dome unsupported by pillars, with an acoustic whispering gallery where the faintest whisper carries 40 meters and echoes up to 11 times.",
                category = "Acoustic & Architectural Wonder",
                openingTime = "06:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "₹25 (Indians), ₹300 (Foreigners)",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Moderate (Steep spiral stairs to the whispering gallery dome)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Early morning 06:30 AM before tourist crowds test acoustic echoes",
                tips = "Visit right at 06:00 AM opening to experience the pristine acoustic whisper without overlapping loud echoes."
            ),
            Attraction(
                id = "bija-ibrahim-rauza",
                destinationId = "karnataka-bijapur",
                name = "Ibrahim Rauza (The Black Taj of the Deccan)",
                description = "Exquisite 1626 CE mausoleum and mosque complex built on a single stone slab, renowned for delicate minarets, cupolas, stone tracery windows, and calligraphic Quranic inscriptions.",
                category = "Indo-Islamic Heritage",
                openingTime = "06:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "₹25 (Indians), ₹300 (Foreigners)",
                recommendedDurationMinutes = 75,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Late afternoon 04:30 PM",
                tips = "Said to have served as an architectural inspiration for the Taj Mahal's minarets."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-bija-kstdc",
                destinationId = "karnataka-bijapur",
                name = "KSTDC Hotel Mayura Adil Shahi",
                category = "Government Heritage Stay",
                minimumPrice = 2000,
                maximumPrice = 3600,
                rating = 4.0f,
                reviewCount = 820,
                amenities = listOf("Central Location near Gol Gumbaz", "Restaurant", "Garden"),
                approximatePrice = "Approx. ₹2,400 / night (verify before travel)",
                website = "https://kstdc.co",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Bijapur Shenga Chutney & Jowar Rotti",
                    isVegetarian = true,
                    description = "Famous dry roasted peanut chutney powder with red garlic and spices, paired with soft jowar rotis.",
                    popularAt = "Local Khanavalis and Gandhi Chowk"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Hyderabad" to 380, "Bengaluru" to 530, "Solapur" to 100, "Pune" to 340, "Mumbai" to 480
            ),
            drivingTimes = mapOf("Solapur" to "1h 45m via NH52", "Hyderabad" to "7h 15m", "Bengaluru" to "9h 0m"),
            roadTripRoute = "Via NH52 connecting Solapur, Vijayapura, and Hubballi.",
            tollAndParkingNotes = "FASTag tolls on NH52 4-lane highway.",
            nearestRailwayStation = "Vijayapura (BJP - 2 km)",
            nearestAirport = "Vijayapura Airport (recently inaugurated) / Belagavi (200 km) / Hubballi (200 km)",
            busTrainFlightOptions = "Direct trains connect Vijayapura to Bengaluru (Gol Gumbaz Express), Mumbai, and Hyderabad."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 700,
            activitiesTotal = 300,
            travelEstimate = 1600,
            totalEstimateMin = 6000,
            totalEstimateMax = 14000
        )
    )

    val chitradurga = Destination(
        id = "karnataka-chitradurga",
        name = "Chitradurga",
        state = "Karnataka",
        district = "Chitradurga",
        tagline = "The Stone Fort of Seven Rounds & Valour of Onake Obavva",
        description = "Dominated by the formidable Chitradurga Fort (Kallina Kote)—a massive 1,500-acre stone citadel constructed with 19 gateway arches, 38 postern doorways, 35 secret entrances, and 7 concentric defensive wall tiers spanning several centuries of Nayaka ruler history.",
        rating = 4.6f,
        reviewCount = 8900,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.ADVENTURE, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Brisk breezes on boulder hilltops, clear blue skies",
            peakSeason = "November – February",
            offSeason = "April – June (Hot sun on bare stone boulders)",
            expectedCrowd = "Moderate to High",
            temperatureRange = "17°C – 32°C",
            suggestedDuration = "1 Day"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("karnataka-chitradurga"),
        attractions = listOf(
            Attraction(
                id = "chitra-kallina-kote",
                destinationId = "karnataka-chitradurga",
                name = "Chitradurga Fort & Onake Obavvana Kindi",
                description = "Legendary stone fort featuring ancient rain-harvesting rock reservoirs, the Hidimbeshwara temple, and the narrow rock crevice (kindi) where folk heroine Onake Obavva single-handedly fought off invading troops using a wooden pestle.",
                category = "Fortress & History",
                openingTime = "06:00 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "₹25 (Indians), ₹300 (Foreigners)",
                recommendedDurationMinutes = 180,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Moderate (Stepped and bouldered walking)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = false,
                photographyAllowed = true,
                bestTimeOfDay = "Early morning 07:00 AM – 10:00 AM",
                tips = "Look out for famed local rock climber 'Kothi Raju' (Monkey King) demonstrating bare-hand climbing on fort walls."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-chitra-clarks-inn",
                destinationId = "karnataka-chitradurga",
                name = "Clarks Inn Chitradurga",
                category = "Modern Business Hotel",
                minimumPrice = 2800,
                maximumPrice = 5200,
                rating = 4.3f,
                reviewCount = 950,
                amenities = listOf("Central AC", "Multi-Cuisine Restaurant", "Close to Highway"),
                approximatePrice = "Approx. ₹3,200 / night (verify before travel)",
                phone = "+91 8194 235 555",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Hot Benne Dosa & Kadabu",
                    isVegetarian = true,
                    description = "Crispy butter dosas and steamed cylindrical rice cakes served with spicy chutney.",
                    popularAt = "Lakshmi Tiffin Room near fort entrance"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Bengaluru" to 200, "Hubballi" to 200, "Hampi" to 145, "Hyderabad" to 510),
            drivingTimes = mapOf("Bengaluru" to "3h 15m via NH48", "Hampi" to "2h 30m via NH50"),
            roadTripRoute = "Directly on the 6-lane NH48 expressway midway between Bengaluru and Hubballi.",
            tollAndParkingNotes = "FASTag expressways; fort has dedicated municipal parking.",
            nearestRailwayStation = "Chitradurga (CTA - 2 km)",
            nearestAirport = "Jindal Vidyanagar (105 km) / Bengaluru (200 km)",
            busTrainFlightOptions = "All buses and trains along the Bengaluru-Hubballi corridor stop at Chitradurga."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 700,
            activitiesTotal = 300,
            travelEstimate = 1200,
            totalEstimateMin = 5000,
            totalEstimateMax = 12000
        )
    )

    val belur = Destination(
        id = "karnataka-belur",
        name = "Belur",
        state = "Karnataka",
        district = "Hassan",
        tagline = "UNESCO World Heritage & Exquisite Hoysala Soapstone Art",
        description = "Inscribed on the UNESCO World Heritage list as part of the Sacred Ensembles of the Hoysalas, Belur was the early capital of the Hoysala Empire. The 1117 CE Chennakeshava Temple is celebrated worldwide for its unparalleled intricate chloritic schist (soapstone) filigree carvings and celestial dancer bracket figures (Madanikas).",
        rating = 4.8f,
        reviewCount = 13200,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.FAMILY_FRIENDLY, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Mild sunny days, pleasant temperatures, comfortable for temple exploration",
            peakSeason = "November – February",
            offSeason = "April – May (Warmer afternoons)",
            expectedCrowd = "Moderate to High",
            temperatureRange = "16°C – 30°C",
            suggestedDuration = "1 Day"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("karnataka-belur"),
        attractions = listOf(
            Attraction(
                id = "belur-chennakeshava",
                destinationId = "karnataka-belur",
                name = "Chennakeshava Temple (Hoysala Masterpiece)",
                description = "Commissioned by King Vishnuvardhana in 1117 CE to celebrate victory over the Cholas, featuring a star-shaped platform, 42 exquisite bracket figures of dancing celestial maidens (Madanikas), and tiered friezes of 650 unique charging elephants.",
                category = "UNESCO World Heritage",
                openingTime = "07:30 AM",
                closingTime = "07:30 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 08:30 AM or late afternoon 04:00 PM for slanted lighting",
                tips = "Hire an authorized ASI certified guide to decode the intricate symbolism of the Madanika dancers and rotating stone pillars."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-belur-kstdc",
                destinationId = "karnataka-belur",
                name = "KSTDC Hotel Mayura Velapuri Belur",
                category = "Government Temple Stay",
                minimumPrice = 2200,
                maximumPrice = 3800,
                rating = 4.1f,
                reviewCount = 780,
                amenities = listOf("Walking Distance to Temple", "Restaurant", "Parking"),
                approximatePrice = "Approx. ₹2,600 / night (verify before travel)",
                website = "https://kstdc.co",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "South Indian Thali & Filter Kaapi",
                    isVegetarian = true,
                    description = "Traditional pure vegetarian Karnataka meals served on fresh banana leaf.",
                    popularAt = "Hotel Samrat Belur"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Hassan" to 38, "Bengaluru" to 220, "Chikkamagaluru" to 25, "Mysuru" to 145),
            drivingTimes = mapOf("Bengaluru" to "3h 45m via NH75 & Hassan", "Chikkamagaluru" to "30m"),
            roadTripRoute = "From Bengaluru via NH75 to Hassan, then 4-lane SH57 directly to Belur.",
            tollAndParkingNotes = "FASTag tolls on NH75. Large parking lot directly behind the temple complex.",
            nearestRailwayStation = "Hassan Junction (38 km)",
            nearestAirport = "Mangaluru (150 km) / Bengaluru (240 km)",
            busTrainFlightOptions = "Buses run every 15 minutes between Hassan, Belur, and Chikkamagaluru."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 700,
            activitiesTotal = 300,
            travelEstimate = 1400,
            totalEstimateMin = 5000,
            totalEstimateMax = 12000
        )
    )

    val halebidu = Destination(
        id = "karnataka-halebidu",
        name = "Halebidu",
        state = "Karnataka",
        district = "Hassan",
        tagline = "UNESCO World Heritage & The Gem of Hoysaleswara",
        description = "The regal capital of the Hoysala Empire in the 12th century (originally Dorasamudra), Halebidu houses the Hoysaleswara and Shantaleswara twin temples, adorned with uninterrupted outer friezes depicting scenes from the Mahabharata, Ramayana, and celestial cosmos in breathtaking micro-carved soapstone.",
        rating = 4.8f,
        reviewCount = 11800,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.FAMILY_FRIENDLY),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Pleasant sunny winter days, ideal for exploring exterior relief carvings",
            peakSeason = "November – February",
            offSeason = "April – May",
            expectedCrowd = "Moderate to High",
            temperatureRange = "16°C – 30°C",
            suggestedDuration = "Half Day"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("karnataka-halebidu"),
        attractions = listOf(
            Attraction(
                id = "halebidu-hoysaleswara",
                destinationId = "karnataka-halebidu",
                name = "Hoysaleswara Temple & Monolithic Nandi",
                description = "Stupendous 12th-century twin temple on a star-shaped platform adorned with over 20,000 soapstone sculptures, two colossal monolithic black granite Nandi bulls, and an archaeological museum.",
                category = "UNESCO World Heritage",
                openingTime = "06:30 AM",
                closingTime = "06:30 PM",
                entryFeeAdult = "Free (Museum ₹10)",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 09:00 AM or late afternoon",
                tips = "Located just 16 km from Belur; both are easily covered together in a single memorable day."
            )
        ),
        stays = emptyList(),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Karnataka Thali & Coffee",
                    isVegetarian = true,
                    description = "Freshly prepared vegetarian meals and hot chicory-rich filter coffee.",
                    popularAt = "KSTDC Mayura Shantala restaurant near gate"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Belur" to 16, "Hassan" to 32, "Bengaluru" to 215),
            drivingTimes = mapOf("Belur" to "20m", "Hassan" to "40m"),
            roadTripRoute = "Via the Belur-Halebidu connecting highway.",
            tollAndParkingNotes = "Paved road with ample parking directly facing the temple garden gate.",
            nearestRailwayStation = "Hassan (32 km)",
            nearestAirport = "Bengaluru (235 km)",
            busTrainFlightOptions = "Local buses ply frequently between Belur, Halebidu, and Hassan."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 600,
            activitiesTotal = 200,
            travelEstimate = 800,
            totalEstimateMin = 3500,
            totalEstimateMax = 8000
        )
    )

    val srirangapatna = Destination(
        id = "karnataka-srirangapatna",
        name = "Srirangapatna",
        state = "Karnataka",
        district = "Mandya",
        tagline = "The Island Citadel of Tipu Sultan & Sri Ranganathaswamy",
        description = "An egg-shaped island enclosed by the bifurcating arms of the River Cauvery, Srirangapatna is steeped in monumental history as the fortress capital of Hyder Ali and Tipu Sultan, home to the revered 9th-century Sri Ranganathaswamy temple, Dariya Daulat Bagh summer palace, and Tipu's Gumbaz mausoleum.",
        rating = 4.7f,
        reviewCount = 12100,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.SPIRITUAL, TravelCategory.FAMILY_FRIENDLY),
        bestTime = BestTimeInfo(
            bestMonths = "September – March",
            weatherSummary = "Gentle river breezes, pleasant sunny days",
            peakSeason = "October – January",
            offSeason = "April – May",
            expectedCrowd = "High (Weekends & Pilgrimage days)",
            temperatureRange = "17°C – 31°C",
            suggestedDuration = "1 Day"
        ),
        seasons = RegionalSeasonalHelper.createDeccanHeritageSeasons("karnataka-srirangapatna"),
        attractions = listOf(
            Attraction(
                id = "sri-ranganatha-temple",
                destinationId = "karnataka-srirangapatna",
                name = "Sri Ranganathaswamy Temple (Adi Ranga)",
                description = "Ancient 9th-century temple complex dedicated to Lord Vishnu reclining on the serpent Adisesha, marking the first of three sacred island shrines along the course of the Cauvery.",
                category = "Spiritual Sanctuary",
                openingTime = "06:00 AM – 01:00 PM & 04:00 PM – 08:30 PM",
                closingTime = "08:30 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 75,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = false,
                bestTimeOfDay = "Morning 07:30 AM",
                tips = "Traditional attire recommended. Visit the bathing ghats on the Cauvery riverbank outside."
            ),
            Attraction(
                id = "sri-dariya-daulat",
                destinationId = "karnataka-srirangapatna",
                name = "Dariya Daulat Bagh (Tipu's Summer Palace)",
                description = "Built in 1784 almost entirely of teakwood in Indo-Saracenic style, set amidst formal Mughal charbagh gardens with interior walls painted in vivid fresco murals depicting Anglo-Mysore battle scenes.",
                category = "Palace & Museum",
                openingTime = "09:00 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "₹25 (Indians), ₹300 (Foreigners)",
                recommendedDurationMinutes = 75,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = false,
                bestTimeOfDay = "10:30 AM",
                tips = "The museum contains Tipu Sultan's original oil paintings, silver coins, and battlefield war weapons."
            ),
            Attraction(
                id = "sri-ranganathittu",
                destinationId = "karnataka-srirangapatna",
                name = "Ranganathittu Bird Sanctuary",
                description = "Picturesque sanctuary comprising six tiny islets on the River Cauvery, home to nesting painted storks, spoonbills, and mugger crocodiles, explored via guided boat tours.",
                category = "Bird Sanctuary & River",
                openingTime = "09:00 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "₹70 entry, Boat ride ₹100",
                entryFeeChild = "₹30",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹50",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 09:00 AM for bird activity",
                tips = "Located just 4 km from Srirangapatna town; boat guides take you within meters of nesting storks."
            )
        ),
        stays = emptyList(),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Hot Mysore Pak & Fresh Sugarcane Juice",
                    isVegetarian = true,
                    description = "Freshly pressed cold sugarcane juice seasoned with ginger and lime, paired with melt-in-mouth Mysore Pak.",
                    popularAt = "Highway fruit stalls near Srirangapatna bridge"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Mysuru" to 15, "Bengaluru" to 125, "Hyderabad" to 695),
            drivingTimes = mapOf("Mysuru" to "20m", "Bengaluru" to "1h 30m via Expressway"),
            roadTripRoute = "Directly on the 10-lane Bengaluru-Mysuru Expressway (NH275).",
            tollAndParkingNotes = "Srirangapatna exit toll on expressway. Ample parking at temple, summer palace, and bird sanctuary.",
            nearestRailwayStation = "Srirangapatna (S) / Mysuru (15 km)",
            nearestAirport = "Mysore Airport (28 km) / Bengaluru (165 km)",
            busTrainFlightOptions = "All passenger and express trains and KSRTC buses running between Bengaluru and Mysuru stop at Srirangapatna."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 2500,
            foodEstimatePerDay = 700,
            activitiesTotal = 400,
            travelEstimate = 1000,
            totalEstimateMin = 4500,
            totalEstimateMax = 11000
        )
    )

    val allCoastalHeritageDestinations = listOf(
        mangaluru,
        udupi,
        stMarysIsland,
        kaup,
        maravanthe,
        gokarna,
        murudeshwar,
        karwar,
        dandeli,
        hampi,
        badami,
        aihole,
        pattadakal,
        bijapur,
        chitradurga,
        belur,
        halebidu,
        srirangapatna
    )
}
