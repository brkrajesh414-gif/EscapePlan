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

object KeralaBackwatersCoastData {

    val kochi = Destination(
        id = "kerala-kochi",
        name = "Kochi (Cochin)",
        state = "Kerala",
        district = "Ernakulam",
        tagline = "Queen of the Arabian Sea & Historic Spice Gateway",
        description = "A vibrant harbor city where 600 years of global trade history live on: giant cantilevered Chinese fishing nets framing Arabian Sea sunsets, colonial Portuguese bungalows in Fort Kochi, 450-year-old Paradesi Synagogue in Jew Town, vibrant Mattancherry Palace murals, and the renowned Kochi-Muziris Biennale.",
        rating = 4.8f,
        reviewCount = 21200,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.BEACHES, TravelCategory.FAMILY_FRIENDLY, TravelCategory.COUPLES),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Pleasant coastal breeze, Cochin Carnival in December, Kochi-Muziris Biennale season",
            peakSeason = "December – February",
            offSeason = "June – August (Monsoon season - great for Ayurveda)",
            expectedCrowd = "High",
            temperatureRange = "23°C – 31°C",
            suggestedDuration = "2–3 Days"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("kerala-kochi"),
        attractions = listOf(
            Attraction(
                id = "kochi-chinese-nets",
                destinationId = "kerala-kochi",
                name = "Chinese Fishing Nets (Cheena Vala)",
                description = "Iconic 10-meter-high cantilevered shore-operated fishing nets introduced by Chinese explorer Zheng He's court in the 14th century, silhouetted against the sunset over the Arabian Sea entrance.",
                category = "Heritage & Waterfront",
                openingTime = "24 Hours (Best viewed at sunrise/sunset)",
                closingTime = "24 Hours",
                entryFeeAdult = "Free (Voluntary tip to fishermen ₹50 if helping haul nets)",
                recommendedDurationMinutes = 60,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "05:30 PM – 06:45 PM for magical golden hour reflections",
                tips = "Buy fresh catch directly from local fishermen stalls on the walkway; nearby beach cafes will cook it to order."
            ),
            Attraction(
                id = "kochi-jew-town",
                destinationId = "kerala-kochi",
                name = "Jew Town & Paradesi Synagogue (Mattancherry)",
                description = "India's oldest active synagogue built in 1568 featuring hand-painted 18th-century Chinese porcelain floor tiles, Belgian crystal chandeliers, a golden pulpit, and surrounding antique spice bazaars.",
                category = "Heritage & Culture",
                openingTime = "10:00 AM – 01:00 PM & 02:00 PM – 05:00 PM (Closed Saturdays & Jewish Holidays)",
                closingTime = "05:00 PM",
                entryFeeAdult = "₹10",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = false,
                bestTimeOfDay = "Morning 10:30 AM",
                tips = "Modest dress required: bare shoulders and shorts not permitted inside the synagogue."
            ),
            Attraction(
                id = "kochi-kathakali-centre",
                destinationId = "kerala-kochi",
                name = "Kerala Kathakali Centre (Fort Kochi)",
                description = "Renowned performing arts venue where travelers observe the elaborate 90-minute facial makeup transformation using natural mineral pigments, followed by classical Kathakali dance-drama and Kalaripayattu martial arts.",
                category = "Cultural Performing Arts",
                openingTime = "Makeup viewing 05:00 PM, Performance 06:00 PM – 07:30 PM",
                closingTime = "08:30 PM",
                entryFeeAdult = "₹400 – ₹500",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Arrive at 05:00 PM to watch actors apply traditional mineral chutti makeup",
                tips = "Book seats in the morning during peak winter months."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-kochi-brunton-boatyard",
                destinationId = "kerala-kochi",
                name = "Brunton Boatyard - CGH Earth",
                category = "Colonial Waterfront Luxury Resort",
                minimumPrice = 14000,
                maximumPrice = 30000,
                rating = 4.8f,
                reviewCount = 2400,
                amenities = listOf("Harbour-Facing Rooms", "History of Fort Kochi Cuisine", "Sunset Cruise", "Ayurvedic Spa"),
                approximatePrice = "Approx. ₹16,000 / night (verify before travel)",
                phone = "+91 484 426 1710",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-kochi-old-harbour-hotel",
                destinationId = "kerala-kochi",
                name = "Old Harbour Hotel",
                category = "300-Year-Old Dutch Heritage Hotel",
                minimumPrice = 9000,
                maximumPrice = 19000,
                rating = 4.7f,
                reviewCount = 1800,
                amenities = listOf("Garden Swimming Pool", "Open-Air Seafood Dining", "Steps from Chinese Fishing Nets"),
                approximatePrice = "Approx. ₹10,500 / night (verify before travel)",
                phone = "+91 484 221 8075",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Kerala Karimeen Pollichathu",
                    isVegetarian = false,
                    description = "Fresh pearl spot fish marinated in shallot-chilli-ginger paste, wrapped in banana leaf and slow-roasted on a griddle.",
                    popularAt = "Armoury Cafe (Brunton Boatyard) & Fort Kochi seafood restaurants"
                ),
                FoodItem(
                    name = "Appam with Vegetable / Mutton Stew (Ishtu)",
                    isVegetarian = false,
                    description = "Lacy fermented rice-and-coconut hoppers with soft spongy centers, paired with fragrant mild coconut milk stew with whole spices.",
                    popularAt = "Kashi Art Cafe & Grand Hotel (MG Road)"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Kashi Art Cafe",
                    cuisine = "Art Gallery European Cafe",
                    rating = 4.6f,
                    isVegFriendly = true,
                    signatureDish = "Cold Brew Coffee & Warm Chocolate Cake",
                    priceForTwo = "₹700",
                    distance = "Burgher Street, Fort Kochi"
                ),
                RestaurantItem(
                    name = "Oceanos Restaurant",
                    cuisine = "Kerala Coastal Seafood",
                    rating = 4.7f,
                    isVegFriendly = true,
                    signatureDish = "Tiger Prawns in Coconut Mango Curry",
                    priceForTwo = "₹1,200",
                    distance = "Elphinstone Road, Fort Kochi"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Bengaluru" to 540, "Chennai" to 690, "Hyderabad" to 1100, "Mumbai" to 1380,
                "Munnar" to 130, "Alappuzha" to 55, "Thekkady" to 155, "Trivandrum" to 200
            ),
            drivingTimes = mapOf(
                "Alappuzha" to "1h 30m via NH66", "Munnar" to "3h 45m via NH85", "Thekkady" to "4h 0m via SH40"
            ),
            roadTripRoute = "Directly connected via NH66 (coastal corridor) and NH544 (to Coimbatore/Salem/Bengaluru).",
            tollAndParkingNotes = "FASTag tolls on NH544. Fort Kochi street parking is limited; paid lots available near Parade Ground.",
            nearestRailwayStation = "Ernakulam Junction (ERS - South) / Ernakulam Town (ERN - North)",
            nearestAirport = "Cochin International Airport (COK - Nedumbassery, 38 km from Fort Kochi)",
            busTrainFlightOptions = "COK is India's first 100% solar-powered international airport with global connectivity; Kochi Water Metro ferries connect mainland to islands."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 4000,
            foodEstimatePerDay = 1200,
            activitiesTotal = 700,
            travelEstimate = 1800,
            totalEstimateMin = 9500,
            totalEstimateMax = 24000
        )
    )

    val alappuzha = Destination(
        id = "kerala-alappuzha",
        name = "Alappuzha (Alleppey)",
        state = "Kerala",
        district = "Alappuzha",
        tagline = "The Venice of the East & Backwater Houseboat Capital",
        description = "Referred to by Lord Curzon as the 'Venice of the East', Alappuzha is the epicenter of Kerala's backwaters: an intricate labyrinth of palm-fringed canals, vast Vembanad Lake, paddy fields below sea level (Kuttanad), luxury thatched Kettuvallam houseboats, and the electrifying Nehru Trophy Snake Boat Race.",
        rating = 4.9f,
        reviewCount = 25400,
        coverResId = null,
        categories = listOf(TravelCategory.LAKES, TravelCategory.COUPLES, TravelCategory.FAMILY_FRIENDLY, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Delightful backwater breeze, calm lake waters; August hosts the legendary Nehru Trophy Boat Race",
            peakSeason = "November – January",
            offSeason = "June – August (Monsoon backwaters have lush romantic appeal)",
            expectedCrowd = "Very High",
            temperatureRange = "22°C – 32°C",
            suggestedDuration = "2–3 Days"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("kerala-alappuzha"),
        attractions = listOf(
            Attraction(
                id = "alap-houseboat-cruise",
                destinationId = "kerala-alappuzha",
                name = "Overnight Kettuvallam Houseboat Cruise",
                description = "Cruising through narrow rural canals and expansive Vembanad Lake aboard traditional eco-friendly thatched houseboats equipped with air-conditioned bedrooms, private sundeck, personal chef, and fresh catch meals.",
                category = "Signature Backwater Experience",
                openingTime = "Check-in 12:00 PM, Check-out 09:00 AM",
                closingTime = "Cruising anchors at 05:30 PM per inland fishery laws",
                entryFeeAdult = "Deluxe Houseboat ₹8,000 – ₹16,000 per night (includes all meals)",
                recommendedDurationMinutes = 1260,
                parkingAvailable = true,
                parkingFee = "₹100 (At boarding jetty)",
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Afternoon lunch cruise and sunset over Vembanad Lake",
                tips = "Government-approved boats carry green/gold DTPC license plaques. Cruising halts at 05:30 PM to allow local fishermen to lay nets."
            ),
            Attraction(
                id = "alap-kuttanad-kayak",
                destinationId = "kerala-alappuzha",
                name = "Kuttanad Village Canoe & Kayak Tour",
                description = "Guided glide through ultra-narrow inland canals inaccessible to houseboats, witnessing life in the 'Rice Bowl of Kerala' where farming is practiced up to 3 meters below sea level.",
                category = "Eco Adventure & Village Life",
                openingTime = "06:30 AM – 10:00 AM & 03:30 PM – 06:30 PM",
                closingTime = "06:30 PM",
                entryFeeAdult = "Canoe tour ₹500 – ₹800 per person",
                recommendedDurationMinutes = 180,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Sunrise 06:30 AM for active village life, bird sightings, and lotus blooms",
                tips = "Take the government SWTD public water bus ferry (₹15 – ₹40) for an authentic budget backwater experience."
            ),
            Attraction(
                id = "alap-marari-beach",
                destinationId = "kerala-alappuzha",
                name = "Marari Beach (Mararikulam)",
                description = "Pristine white-sand beach lined with endless swaying coconut palms and traditional fishing catamarans, located 14 km north of Alleppey town away from tourist crowds.",
                category = "Beaches & Sunset",
                openingTime = "24 Hours",
                closingTime = "24 Hours",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "05:00 PM – 06:45 PM for spectacular sunset into the Arabian Sea",
                tips = "Ideal spot for quiet beach walks and yoga; watch fishermen pull shore-seine nets at dawn."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-alap-marari-beach-cghearth",
                destinationId = "kerala-alappuzha",
                name = "Marari Beach Resort - CGH Earth",
                category = "Luxury Eco Beachfront Resort",
                minimumPrice = 16000,
                maximumPrice = 35000,
                rating = 4.9f,
                reviewCount = 2800,
                amenities = listOf("Thatched Seaside Cottages", "Organic Farm-to-Table Dining", "Ayurvedic Wellness", "Butterfly Garden"),
                approximatePrice = "Approx. ₹18,500 / night (verify before travel)",
                phone = "+91 484 426 1710",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-alap-punnamada-resort",
                destinationId = "kerala-alappuzha",
                name = "Punnamada Resort",
                category = "Heritage Lakefront Resort",
                minimumPrice = 7500,
                maximumPrice = 16000,
                rating = 4.6f,
                reviewCount = 1900,
                amenities = listOf("Lakefront Facing Villas", "Ayurvedic Centre", "Houseboat Dock", "Swimming Pool"),
                approximatePrice = "Approx. ₹8,800 / night (verify before travel)",
                phone = "+91 477 223 3690",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Alappuzha Fish Curry & Tapioca (Kappa Meen Curry)",
                    isVegetarian = false,
                    description = "Steamed tapioca root paired with fiery red fish curry simmered in earthenware pots with Kudampuli (Malabar kokum tamarind) and coconut oil.",
                    popularAt = "Traditional Toddy Shops (Shaaps) like Mullakkal & Kuttanad toddy shops"
                ),
                FoodItem(
                    name = "Houseboat Fresh Catch Karimeen Fry",
                    isVegetarian = false,
                    description = "Crispy spiced pearl spot fish freshly fried by the on-board private chef, served on banana leaves with red matta rice.",
                    popularAt = "Served fresh on all licensed Alleppey houseboats"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Thaff Delicacy",
                    cuisine = "Kerala & Malabar Cuisine",
                    rating = 4.5f,
                    isVegFriendly = true,
                    signatureDish = "Kerala Porotta with Beef Roast & Appam",
                    priceForTwo = "₹500",
                    distance = "Near General Hospital Junction"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Kochi" to 55, "Trivandrum" to 148, "Bengaluru" to 595, "Munnar" to 175, "Kovalam" to 160
            ),
            drivingTimes = mapOf("Kochi" to "1h 30m via NH66", "Trivandrum" to "3h 30m via NH66"),
            roadTripRoute = "Via NH66 coastal highway directly linking Kochi, Alappuzha, Kollam, and Thiruvananthapuram.",
            tollAndParkingNotes = "Houseboat boarding points are at Punnamada Jetty, Finishing Point, and Pallathuruthy with secure paid day/night parking.",
            nearestRailwayStation = "Alappuzha (ALLP - 3 km)",
            nearestAirport = "Cochin International Airport (COK - 85 km)",
            busTrainFlightOptions = "Frequent KSRTC fast-passenger buses run every 15 minutes between Ernakulam KSRTC and Alappuzha."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 5500,
            foodEstimatePerDay = 1200,
            activitiesTotal = 1500,
            travelEstimate = 1600,
            totalEstimateMin = 12000,
            totalEstimateMax = 32000
        )
    )

    val kumarakom = Destination(
        id = "kerala-kumarakom",
        name = "Kumarakom",
        state = "Kerala",
        district = "Kottayam",
        tagline = "Luxury Lakefront Sanctuaries & Kumarakom Bird Sanctuary",
        description = "Set on the eastern banks of Vembanad Lake—India's longest freshwater lake—Kumarakom is an upscale paradise of five-star heritage backwater resorts, private plunge pools, world-class Ayurvedic wellness sanctuaries, and a 14-acre bird sanctuary visited by migratory Siberian cranes.",
        rating = 4.8f,
        reviewCount = 14200,
        coverResId = null,
        categories = listOf(TravelCategory.LAKES, TravelCategory.COUPLES, TravelCategory.NATURE, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Breezy lake climate, migratory bird season (November to February)",
            peakSeason = "November – January",
            offSeason = "June – August",
            expectedCrowd = "Moderate (Exclusive retreat atmosphere)",
            temperatureRange = "22°C – 32°C",
            suggestedDuration = "2–3 Days"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("kerala-kumarakom"),
        attractions = listOf(
            Attraction(
                id = "kuma-bird-sanctuary",
                destinationId = "kerala-kumarakom",
                name = "Kumarakom Bird Sanctuary",
                description = "Sprawling 14-acre protected wetland on the banks of Kavanar River offering walking trails and watchtowers to spot herons, egrets, darters, kingfishers, and winter migratory waterfowl.",
                category = "Bird Sanctuary & Nature",
                openingTime = "06:00 AM",
                closingTime = "06:00 PM",
                entryFeeAdult = "₹50",
                entryFeeChild = "₹25",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy (Walking trail)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Early morning 06:30 AM for peak bird activity and soft morning light",
                tips = "Binoculars are strongly recommended; hire a local naturalist guide at the gate."
            ),
            Attraction(
                id = "kuma-vembnad-sunset",
                destinationId = "kerala-kumarakom",
                name = "Vembanad Lake Sunset Shikara Ride",
                description = "Quiet cruise on small wooden open-sided shikaras gliding past water hyacinth meadows and rural fishing hamlets into the expanse of Vembanad Lake.",
                category = "Lake Cruise",
                openingTime = "06:00 AM – 06:30 PM",
                closingTime = "06:30 PM",
                entryFeeAdult = "₹600 – ₹1,000 per hour per boat",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "05:00 PM – 06:30 PM",
                tips = "Shikaras are much quieter and can access narrower channels than large houseboats."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-kuma-kumarakom-lake-resort",
                destinationId = "kerala-kumarakom",
                name = "Kumarakom Lake Resort",
                category = "Ultra-Luxury Heritage Backwater Resort",
                minimumPrice = 22000,
                maximumPrice = 55000,
                rating = 4.9f,
                reviewCount = 3800,
                amenities = listOf("250-Meter Meandering Pool", "Heritage Villas with Open-to-Sky Baths", "Ayurmana Centre", "Vembanad Seafood Bar"),
                approximatePrice = "Approx. ₹25,000 / night (verify before travel)",
                phone = "+91 481 252 4900",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-kuma-coconut-lagoon",
                destinationId = "kerala-kumarakom",
                name = "Coconut Lagoon - CGH Earth",
                category = "Luxury Eco Heritage Resort",
                minimumPrice = 14000,
                maximumPrice = 28000,
                rating = 4.8f,
                reviewCount = 2600,
                amenities = listOf("Boat-Only Accessible Island", "Restored Tharavadu Mansions", "Sunset Flute Recitals", "Ayurveda"),
                approximatePrice = "Approx. ₹16,500 / night (verify before travel)",
                phone = "+91 484 426 1710",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Kottayam Style Fish Curry & Duck Roast",
                    isVegetarian = false,
                    description = "Tender country duck simmered in thick roasted coconut paste with green peppercorns, alongside fiery red kokum fish curry.",
                    popularAt = "Ettukettu Dining Hall (Kumarakom Lake Resort) & local family toddy shops"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Kottayam" to 14, "Kochi" to 50, "Alappuzha" to 32),
            drivingTimes = mapOf("Kottayam" to "25m", "Kochi" to "1h 20m"),
            roadTripRoute = "From Kochi via Tripunithura and Vaikom, or from Kottayam via SH1.",
            tollAndParkingNotes = "Paved 2-lane roads; resorts have private guest boat pickup jetties.",
            nearestRailwayStation = "Kottayam (KTYM - 14 km)",
            nearestAirport = "Cochin International Airport (75 km)",
            busTrainFlightOptions = "Kottayam is a major railhead on the Trivandrum-Ernakulam line with express trains to all Indian metros."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 6500,
            foodEstimatePerDay = 1400,
            activitiesTotal = 1000,
            travelEstimate = 1600,
            totalEstimateMin = 14000,
            totalEstimateMax = 38000
        )
    )

    val kovalam = Destination(
        id = "kerala-kovalam",
        name = "Kovalam",
        state = "Kerala",
        district = "Thiruvananthapuram",
        tagline = "The Crescent Beaches & Vizhinjam Lighthouse",
        description = "One of India's oldest and most renowned beach destinations, Kovalam comprises three adjacent crescent-shaped beaches separated by rocky promontories: Lighthouse Beach with its iconic 30-meter candy-striped lighthouse, Hawah Beach, and tranquil Samudra Beach.",
        rating = 4.7f,
        reviewCount = 18900,
        coverResId = null,
        categories = listOf(TravelCategory.BEACHES, TravelCategory.COUPLES, TravelCategory.FAMILY_FRIENDLY, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Gentle sea surf, calm swimming waters, balmy sunny afternoons",
            peakSeason = "November – February",
            offSeason = "June – August (Monsoon surfing & rejuvenation Ayurveda)",
            expectedCrowd = "High",
            temperatureRange = "23°C – 32°C",
            suggestedDuration = "2–3 Days"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("kerala-kovalam"),
        attractions = listOf(
            Attraction(
                id = "kova-lighthouse-beach",
                destinationId = "kerala-kovalam",
                name = "Vizhinjam Lighthouse & Lighthouse Beach",
                description = "Historic 30-meter red-and-white spiraled lighthouse atop Kurumkal rocky cliff, offering spiral staircase/elevator access to 360-degree views across Kovalam crescent bays and Vizhinjam International Seaport.",
                category = "Beaches & Lighthouse",
                openingTime = "Lighthouse 10:00 AM – 01:00 PM & 03:00 PM – 06:00 PM (Closed Mondays)",
                closingTime = "06:00 PM",
                entryFeeAdult = "Beach Free, Lighthouse ₹20 (Indians), ₹50 (Foreigners)",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                parkingFee = "₹40",
                difficultyLevel = "Easy (Elevator available inside lighthouse)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "04:30 PM for lighthouse panorama, followed by sunset on the beach",
                tips = "The beach promenade is lined with multi-cuisine open-air cafes displaying the evening's fresh catch on crushed ice."
            ),
            Attraction(
                id = "kova-hawah-beach",
                destinationId = "kerala-kovalam",
                name = "Hawah Beach (Eve's Beach)",
                description = "Sheltered crescent cove known for calm blue waters ideal for swimming, morning catamarans setting sail, and evening sunset walks under high rocky headlands.",
                category = "Beaches & Swimming",
                openingTime = "24 Hours",
                closingTime = "24 Hours",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Morning 07:00 AM or sunset 05:30 PM",
                tips = "Lifeguards are stationed along the beach; obey red warning flags during strong swells."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-kova-leela-kovalam",
                destinationId = "kerala-kovalam",
                name = "The Leela Kovalam, a Raviz Hotel",
                category = "5-Star Cliff-Top Luxury Resort",
                minimumPrice = 15000,
                maximumPrice = 38000,
                rating = 4.8f,
                reviewCount = 3600,
                amenities = listOf("Perched on Cliff Edge", "Private Beach Access", "Infinity Pools", "Ayurvedic Aveda Spa"),
                approximatePrice = "Approx. ₹17,000 / night (verify before travel)",
                phone = "+91 471 305 1234",
                lastVerifiedDate = "2024-2025"
            ),
            Accommodation(
                id = "stay-kova-turtle-on-the-beach",
                destinationId = "kerala-kovalam",
                name = "Turtle on the Beach",
                category = "Boutique Beach Resort",
                minimumPrice = 5500,
                maximumPrice = 11000,
                rating = 4.5f,
                reviewCount = 1700,
                amenities = listOf("Sea-Facing Balconies", "Swimming Pool", "Spa", "Lounge Bar"),
                approximatePrice = "Approx. ₹6,500 / night (verify before travel)",
                phone = "+91 471 251 4000",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Grilled Red Snapper with Garlic Lemon Butter",
                    isVegetarian = false,
                    description = "Freshly caught Arabian Sea fish marinated in mild herbs and grilled over charcoal, served with French fries and garden salad.",
                    popularAt = "Fusion Restaurant & German Bakery on the promenade"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Bait (The Leela Kovalam)",
                    cuisine = "Fine-Dining Alfresco Seafood",
                    rating = 4.8f,
                    isVegFriendly = true,
                    signatureDish = "Grilled Lobster & Tawa Tiger Prawns",
                    priceForTwo = "₹3,500",
                    distance = "Lighthouse Beach Road"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Trivandrum" to 16, "Kanyakumari" to 85, "Alappuzha" to 160, "Kochi" to 215, "Bengaluru" to 680
            ),
            drivingTimes = mapOf("Trivandrum" to "30m via Kovalam Bypass", "Kanyakumari" to "2h 15m"),
            roadTripRoute = "Via NH66 bypass directly connecting Trivandrum city center and airport to Kovalam.",
            tollAndParkingNotes = "Wide 4-lane bypass; paid municipal car park available at Lighthouse Beach junction.",
            nearestRailwayStation = "Thiruvananthapuram Central (TVC - 15 km)",
            nearestAirport = "Trivandrum International Airport (TRV - 14 km)",
            busTrainFlightOptions = "Air-conditioned city low-floor buses and prepaid taxis connect TRV airport directly to Kovalam."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 4500,
            foodEstimatePerDay = 1200,
            activitiesTotal = 600,
            travelEstimate = 1500,
            totalEstimateMin = 10000,
            totalEstimateMax = 26000
        )
    )

    val varkala = Destination(
        id = "kerala-varkala",
        name = "Varkala",
        state = "Kerala",
        district = "Thiruvananthapuram",
        tagline = "The Red Laterite Cliffs & Sacred Papanasam Beach",
        description = "Where dramatic red laterite tertiary cliffs plunge directly into the roaring Arabian Sea, Varkala is unique in South India. Known for Papanasam Beach (where holy waters cleanse sins), clifftop bohemian cafes, surf schools, yoga retreats, and the 2,000-year-old Janardhana Swamy Temple.",
        rating = 4.8f,
        reviewCount = 16800,
        coverResId = null,
        categories = listOf(TravelCategory.BEACHES, TravelCategory.ADVENTURE, TravelCategory.SPIRITUAL, TravelCategory.COUPLES),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Breezy cliff evenings, lively cliffside cafe vibe, gentle waves for beginner surfing",
            peakSeason = "December – February",
            offSeason = "June – August (Monsoons - powerful ocean waves)",
            expectedCrowd = "High",
            temperatureRange = "23°C – 32°C",
            suggestedDuration = "2–3 Days"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("kerala-varkala"),
        attractions = listOf(
            Attraction(
                id = "vark-north-cliff",
                destinationId = "kerala-varkala",
                name = "Varkala North Cliff Walk & Cafes",
                description = "Scenic 2-kilometer paved footpath atop sheer geological cliffs overlooking the Arabian Sea, lined with handicraft shops, yoga studios, ayurvedic massage parlours, and open-air cafes.",
                category = "Cliff Promenade & Lifestyle",
                openingTime = "24 Hours (Most vibrant 04:00 PM – 11:00 PM)",
                closingTime = "11:00 PM",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹30 (Near Helipad)",
                difficultyLevel = "Easy (Steps down to beach)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "05:00 PM – 07:00 PM for sunset over the ocean",
                tips = "Steps cut into the red cliff lead directly down to the sandy beach below."
            ),
            Attraction(
                id = "vark-papanasam-beach",
                destinationId = "kerala-varkala",
                name = "Papanasam Beach & Natural Mineral Springs",
                description = "Sacred golden-sand beach where natural mountain springs bubble out of the cliff face, believed to cleanse worldly sins when bathing in the holy surf.",
                category = "Beaches & Spiritual",
                openingTime = "24 Hours",
                closingTime = "24 Hours",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Early morning 06:30 AM or late afternoon",
                tips = "Visit the 2,000-year-old Janardhana Swamy Temple situated on the hill adjacent to the beach."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-vark-gateway-ihcl",
                destinationId = "kerala-varkala",
                name = "Gateway Varkala - IHCL SeleQtions",
                category = "Cliff-Top Luxury Hotel",
                minimumPrice = 8500,
                maximumPrice = 18000,
                rating = 4.7f,
                reviewCount = 1800,
                amenities = listOf("Clifftop Pool overlooking Sea", "Ayurvedic Centre", "Tennis Court", "Direct Beach Pathway"),
                approximatePrice = "Approx. ₹9,800 / night (verify before travel)",
                phone = "+91 470 667 3300",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Tandoori Seer Fish & Israeli Shakshuka",
                    isVegetarian = false,
                    description = "Fresh Arabian sea fish roasted on charcoal, alongside global backpacker favorites like poached egg shakshuka.",
                    popularAt = "Cafe del Mar & Darjeeling Cafe on North Cliff"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Cafe del Mar",
                    cuisine = "Seafood & Continental",
                    rating = 4.6f,
                    isVegFriendly = true,
                    signatureDish = "Grilled Calamari & Wood-Fired Pizza",
                    priceForTwo = "₹800",
                    distance = "North Cliff"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Trivandrum" to 45, "Kollam" to 35, "Kochi" to 170),
            drivingTimes = mapOf("Trivandrum" to "1h 15m via NH66", "Kollam" to "50m"),
            roadTripRoute = "Via NH66 turning off at Kallambalam/Parippally onto the coastal road to Varkala.",
            tollAndParkingNotes = "Helipad parking ground accommodates cars on the North Cliff.",
            nearestRailwayStation = "Varkala Sivagiri (VAK - 3 km)",
            nearestAirport = "Trivandrum International Airport (TRV - 42 km)",
            busTrainFlightOptions = "Almost all express trains on the Trivandrum-Kollam mainline halt at Varkala Sivagiri."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3500,
            foodEstimatePerDay = 1000,
            activitiesTotal = 500,
            travelEstimate = 1400,
            totalEstimateMin = 8500,
            totalEstimateMax = 20000
        )
    )

    val bekal = Destination(
        id = "kerala-bekal",
        name = "Bekal",
        state = "Kerala",
        district = "Kasaragod",
        tagline = "The Giant Sea Fort & Untamed Malabar Coastline",
        description = "Spanning 40 acres of headland projecting into the Arabian Sea, Bekal is home to Kerala's largest and best-preserved fort built in 1650 by Shivappa Nayaka. Renowned for its keyhole-shaped observation tower, zig-zag defense ramps, backwaters of Valiyaparamba, and unspoiled beaches.",
        rating = 4.7f,
        reviewCount = 8900,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.BEACHES, TravelCategory.FAMILY_FRIENDLY),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Pleasant sea breeze, comfortable for walking along fort ramparts",
            peakSeason = "November – February",
            offSeason = "June – August (Drenching coastal rains)",
            expectedCrowd = "Moderate",
            temperatureRange = "22°C – 32°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("kerala-bekal"),
        attractions = listOf(
            Attraction(
                id = "bekal-fort",
                destinationId = "kerala-bekal",
                name = "Bekal Fort & Observation Tower",
                description = "Mammoth 40-acre laterite coastal fort rising directly above the waves with no administrative palaces inside—purely military fortress engineering featuring underground tunnels, magazine vaults, and sea-view bastions.",
                category = "Heritage Fortification",
                openingTime = "08:00 AM",
                closingTime = "05:30 PM",
                entryFeeAdult = "₹25 (Indians), ₹300 (Foreigners)",
                recommendedDurationMinutes = 120,
                parkingAvailable = true,
                parkingFee = "₹30",
                difficultyLevel = "Easy to Moderate (Walking on ramparts)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "04:00 PM – 05:30 PM for glowing evening sunset over the sea ramparts",
                tips = "Climb the circular observation tower in the center of the fort for a bird's-eye view of the crashing sea on three sides."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-bekal-taj-bekal",
                destinationId = "kerala-bekal",
                name = "Taj Bekal Resort & Spa, Kerala",
                category = "Luxury Backwater & Beach Resort",
                minimumPrice = 14000,
                maximumPrice = 32000,
                rating = 4.8f,
                reviewCount = 2100,
                amenities = listOf("Kettuvallam Inspired Architecture", "Private Plunge Pools", "Jiva Spa", "Backwater Kayaking"),
                approximatePrice = "Approx. ₹16,500 / night (verify before travel)",
                phone = "+91 467 661 6611",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Malabar Neychoru (Ghee Rice) & Kasaragod Chicken Curry",
                    isVegetarian = false,
                    description = "Fragrant kaima rice cooked in pure ghee with whole spices, paired with rich coconut-based chicken gravy.",
                    popularAt = "Local dining rooms in Kasaragod and Bekal"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Mangaluru" to 65, "Kannur" to 85, "Kozhikode" to 175, "Bengaluru" to 380),
            drivingTimes = mapOf("Mangaluru" to "1h 45m via NH66", "Kannur" to "2h 15m"),
            roadTripRoute = "Via NH66 coastal highway connecting Mangaluru (Karnataka) to Kasaragod/Bekal.",
            tollAndParkingNotes = "FASTag tolls on NH66. Paved parking area at the Bekal Fort entrance.",
            nearestRailwayStation = "Kasaragod (KGQ - 16 km) / Kanhangad (12 km)",
            nearestAirport = "Mangalore International Airport (IXE - 75 km)",
            busTrainFlightOptions = "All express trains on the Konkan Railway / Malabar route halt at Kasaragod or Kanhangad."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 4500,
            foodEstimatePerDay = 1100,
            activitiesTotal = 400,
            travelEstimate = 1600,
            totalEstimateMin = 9500,
            totalEstimateMax = 24000
        )
    )

    val kannur = Destination(
        id = "kerala-kannur",
        name = "Kannur",
        state = "Kerala",
        district = "Kannur",
        tagline = "The Land of Looms & Lores & Sacred Theyyam Rituals",
        description = "Known for its ancient handlooms and sacred folk spirit dances (Theyyam), Kannur features Asia's longest drive-in beach at Muzhappilangad (4 km), the 1505 CE Portuguese St. Angelo Fort, and pristine uncommercialized Malabar coastlines.",
        rating = 4.6f,
        reviewCount = 8200,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.BEACHES, TravelCategory.ROAD_TRIPS),
        bestTime = BestTimeInfo(
            bestMonths = "October – March (Theyyam season runs Nov – May)",
            weatherSummary = "Pleasant coastal weather; overnight Theyyam rituals in ancestral village shrines (Kavus)",
            peakSeason = "December – February",
            offSeason = "June – August",
            expectedCrowd = "Moderate",
            temperatureRange = "23°C – 32°C",
            suggestedDuration = "2–3 Days"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("kerala-kannur"),
        attractions = listOf(
            Attraction(
                id = "kan-muzhappilangad",
                destinationId = "kerala-kannur",
                name = "Muzhappilangad Drive-in Beach (4 km)",
                description = "Asia's longest natural drive-in beach where visitors can drive cars and motorcycles directly along the hard-packed sand shores accompanied by crashing surf.",
                category = "Beaches & Driving Adventure",
                openingTime = "06:00 AM",
                closingTime = "07:30 PM",
                entryFeeAdult = "Vehicle toll ₹50",
                recommendedDurationMinutes = 90,
                parkingAvailable = true,
                difficultyLevel = "Easy (Drive along the wet hard sand)",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "05:00 PM – 06:30 PM for sunset drive",
                tips = "Drive only on the dark, hard-packed wet sand near the water line; avoid loose dry sand where tires can sink."
            ),
            Attraction(
                id = "kan-theyyam",
                destinationId = "kerala-kannur",
                name = "Sacred Theyyam Performance (Village Kavu)",
                description = "Over 1,500-year-old ritual shamanistic dance where performers transform into living deities through elaborate face paintings, towering headdresses (Mudi), and walking on embers.",
                category = "Sacred Living Heritage",
                openingTime = "Typically overnight 09:00 PM – 06:00 AM or early morning",
                closingTime = "08:00 AM",
                entryFeeAdult = "Free (Sacred temple ritual)",
                recommendedDurationMinutes = 180,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "Night or dawn depending on the specific deity invocation",
                tips = "Show respect: remove footwear at the temple grounds; photography is welcomed without flash during dance."
            )
        ),
        stays = emptyList(),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Thalassery Dum Biryani & Kallummakkaya (Mussels)",
                    isVegetarian = false,
                    description = "Aromatic short-grain jeerakasala rice slow-cooked with tender meat and mild whole spices, alongside spicy stuffed fried mussels.",
                    popularAt = "Paris Restaurant (Thalassery) & Ondens (Kannur)"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Kozhikode" to 90, "Mangaluru" to 140, "Bengaluru" to 310),
            drivingTimes = mapOf("Kozhikode" to "2h 15m via NH66", "Bengaluru" to "6h 30m via Virajpet"),
            roadTripRoute = "From Bengaluru via Mysuru, Virajpet, and descending the scenic Makutta ghat.",
            tollAndParkingNotes = "Ghat road through Bramhagiri/Makutta forest has speed limits.",
            nearestRailwayStation = "Kannur Main (CAN - 1 km)",
            nearestAirport = "Kannur International Airport (CNN - Mattannur, 26 km)",
            busTrainFlightOptions = "Kannur Airport operates direct international flights to Gulf countries and domestic flights to Bengaluru and Mumbai."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3000,
            foodEstimatePerDay = 900,
            activitiesTotal = 300,
            travelEstimate = 1400,
            totalEstimateMin = 7000,
            totalEstimateMax = 16000
        )
    )

    val kollam = Destination(
        id = "kerala-kollam",
        name = "Kollam (Quilon)",
        state = "Kerala",
        district = "Kollam",
        tagline = "Gateway to Ashtamudi Lake & Munroe Island Canals",
        description = "Historic international spice trading port on the Arabian Sea, Kollam is the southern gateway to Kerala's backwaters, centered around the 8-branched Ashtamudi Lake, the 8-hour National Waterway cruise to Alleppey, and the tranquil canal village of Munroe Island.",
        rating = 4.6f,
        reviewCount = 7600,
        coverResId = null,
        categories = listOf(TravelCategory.LAKES, TravelCategory.NATURE, TravelCategory.WEEKEND_GETAWAYS),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Breezy lakeside climate, excellent for canoe touring through mangrove creeks",
            peakSeason = "November – February",
            offSeason = "June – August",
            expectedCrowd = "Moderate",
            temperatureRange = "23°C – 32°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("kerala-kollam"),
        attractions = listOf(
            Attraction(
                id = "kol-munroe-island",
                destinationId = "kerala-kollam",
                name = "Munroe Island Country Canoe Tour",
                description = "Cluster of eight delta islands formed at the confluence of Ashtamudi Lake and Kallada River, explored via quiet hand-paddled wooden canoes under low bridges and coconut palms.",
                category = "Eco Canoe & Backwaters",
                openingTime = "06:00 AM – 06:00 PM",
                closingTime = "06:00 PM",
                entryFeeAdult = "Canoe tour ₹600 – ₹1,000 for 2 persons",
                recommendedDurationMinutes = 150,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "06:30 AM sunrise or 04:30 PM sunset",
                tips = "Watch village women spinning golden coir yarn from coconut husks along the canal banks."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-kol-raviz-ashtamudi",
                destinationId = "kerala-kollam",
                name = "The Raviz Ashtamudi",
                category = "5-Star Lakefront Luxury Palace Resort",
                minimumPrice = 8500,
                maximumPrice = 22000,
                rating = 4.7f,
                reviewCount = 2100,
                amenities = listOf("Lake-Facing Luxury Villas", "Traditional Kerala Wooden Architecture", "Ayurvedic Spa", "Lake Cruise"),
                approximatePrice = "Approx. ₹9,800 / night (verify before travel)",
                phone = "+91 474 275 1111",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "Kollam Cashew Curry & Fresh Crab Roast",
                    isVegetarian = false,
                    description = "Fresh whole local cashews cooked in spiced coconut gravy, alongside fiery red crab masala.",
                    popularAt = "The Raviz Ashtamudi & local lakefront diners"
                )
            ),
            restaurants = emptyList()
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf("Trivandrum" to 65, "Alappuzha" to 85, "Kochi" to 140),
            drivingTimes = mapOf("Trivandrum" to "1h 30m via NH66", "Alappuzha" to "2h 0m"),
            roadTripRoute = "Via NH66 coastal highway.",
            tollAndParkingNotes = "Smooth 4-lane bypass around Kollam city.",
            nearestRailwayStation = "Kollam Junction (QLN - 3 km)",
            nearestAirport = "Trivandrum International Airport (68 km)",
            busTrainFlightOptions = "Daily tourist boat runs between Kollam and Alappuzha (8-hour scenic cruise) via DTPC."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3500,
            foodEstimatePerDay = 1000,
            activitiesTotal = 600,
            travelEstimate = 1400,
            totalEstimateMin = 8000,
            totalEstimateMax = 18000
        )
    )

    val kozhikode = Destination(
        id = "kerala-kozhikode",
        name = "Kozhikode (Calicut)",
        state = "Kerala",
        district = "Kozhikode",
        tagline = "The City of Spices, Historic Zamorins & Culinary Capital",
        description = "Where Portuguese navigator Vasco da Gama landed in 1498 at Kappad Beach, Kozhikode was the historic capital of the powerful Zamorins. Today celebrated as UNESCO's City of Literature, renowned for legendary Paragon Dum Biryani, Sweet Meat Street (SM Street) black halwa, and sunset breezes along Kozhikode Beach.",
        rating = 4.7f,
        reviewCount = 14800,
        coverResId = null,
        categories = listOf(TravelCategory.HERITAGE, TravelCategory.BEACHES, TravelCategory.FAMILY_FRIENDLY),
        bestTime = BestTimeInfo(
            bestMonths = "October – March",
            weatherSummary = "Pleasant coastal climate, bustling evening street-food culture",
            peakSeason = "November – February",
            offSeason = "June – August",
            expectedCrowd = "High",
            temperatureRange = "23°C – 32°C",
            suggestedDuration = "2 Days"
        ),
        seasons = RegionalSeasonalHelper.createCoastalSeasons("kerala-kozhikode"),
        attractions = listOf(
            Attraction(
                id = "kozh-sm-street",
                destinationId = "kerala-kozhikode",
                name = "Sweet Meat Street (Mittai Theruvu) & Halwa Making",
                description = "Centuries-old pedestrian heritage shopping street famous for traditional confectionery shops churning glistening black and multi-flavored Kozhikodan Halwa in massive brass urulis with pure coconut oil.",
                category = "Heritage Market & Food Trail",
                openingTime = "10:00 AM",
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
                bestTimeOfDay = "05:00 PM – 08:30 PM",
                tips = "Sample the traditional black halwa made of jaggery, and thin crisp banana chips fried in fresh coconut oil."
            ),
            Attraction(
                id = "kozh-beach",
                destinationId = "kerala-kozhikode",
                name = "Kozhikode Beach & Old Sea Pier",
                description = "Historical beach promenade featuring century-old collapsed iron shipping piers extending into the sea, lighthouse, open-air stages, and street stalls serving pickled fruits (Uppilittathu) and ice orathis.",
                category = "Beaches & Promenade",
                openingTime = "24 Hours",
                closingTime = "24 Hours",
                entryFeeAdult = "Free",
                recommendedDurationMinutes = 75,
                parkingAvailable = true,
                difficultyLevel = "Easy",
                familyFriendly = true,
                childrenFriendly = true,
                seniorCitizenFriendly = true,
                photographyAllowed = true,
                bestTimeOfDay = "05:00 PM – 07:00 PM for cool sea breeze and street food",
                tips = "Try the famous Kozhikode 'Sulaimani' (cardamom-spiced black tea with lemon) at beach stalls."
            )
        ),
        stays = listOf(
            Accommodation(
                id = "stay-kozh-gateway-ihcl",
                destinationId = "kerala-kozhikode",
                name = "The Gateway Hotel Beach Road Calicut",
                category = "Premium City Beachfront Hotel",
                minimumPrice = 4800,
                maximumPrice = 9500,
                rating = 4.6f,
                reviewCount = 2100,
                amenities = listOf("Outdoor Swimming Pool", "Ayurvedic Spa", "Cape Comorin Multi-Cuisine Restaurant"),
                approximatePrice = "Approx. ₹5,400 / night (verify before travel)",
                phone = "+91 495 661 3000",
                lastVerifiedDate = "2024-2025"
            )
        ),
        foodGuide = FoodGuide(
            localSpecialties = listOf(
                FoodItem(
                    name = "World-Famous Calicut Paragon Mutton / Chicken Biryani",
                    isVegetarian = false,
                    description = "Voted among the world's most legendary dining experiences: tender meat layered with fragrant kaima rice, fried cashews, sultanas, and mild Malabar spices.",
                    popularAt = "Paragon Restaurant (CH Flyover Junction - since 1939)"
                ),
                FoodItem(
                    name = "Kozhikodan Black Halwa & Banana Chips",
                    isVegetarian = true,
                    description = "Glossy, chewy halwa cooked from flour, jaggery syrup, and pure coconut oil, sprinkled with crunchy cashews.",
                    popularAt = "Sankaran Bakery & SM Street sweet shops"
                )
            ),
            restaurants = listOf(
                RestaurantItem(
                    name = "Paragon Restaurant",
                    cuisine = "Legendary Malabar Cuisine",
                    rating = 4.8f,
                    isVegFriendly = true,
                    signatureDish = "Malabar Dum Biryani, Fish Mango Curry & Appam",
                    priceForTwo = "₹600",
                    distance = "CH Flyover Junction"
                )
            )
        ),
        travelRoute = TravelRouteInfo(
            originDistances = mapOf(
                "Kochi" to 175, "Bengaluru" to 350, "Wayanad" to 85, "Mangaluru" to 230, "Chennai" to 630
            ),
            drivingTimes = mapOf("Wayanad" to "2h 30m via Thamarassery ghat", "Kochi" to "4h 30m via NH66"),
            roadTripRoute = "Via NH66 coastal highway or NH766 from Bengaluru/Mysuru via Gundlupet and Wayanad.",
            tollAndParkingNotes = "FASTag tolls on NH66. Paid car park available at beach promenade.",
            nearestRailwayStation = "Kozhikode Main (CLT - 1.5 km)",
            nearestAirport = "Calicut International Airport (CCJ - Karipur, 28 km)",
            busTrainFlightOptions = "Vande Bharat Express connects Kozhikode to Trivandrum, Ernakulam, and Kasaragod."
        ),
        budget = BudgetBreakdown(
            stayEstimatePerNight = 3200,
            foodEstimatePerDay = 1000,
            activitiesTotal = 400,
            travelEstimate = 1500,
            totalEstimateMin = 7500,
            totalEstimateMax = 18000
        )
    )

    val allBackwatersCoastDestinations = listOf(
        kochi,
        alappuzha,
        kumarakom,
        kovalam,
        varkala,
        bekal,
        kannur,
        kollam,
        kozhikode
    )
}
