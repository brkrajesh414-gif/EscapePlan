package com.example.data.datasource

import com.example.data.model.Accommodation
import com.example.data.model.Attraction
import com.example.data.model.BestTimeInfo
import com.example.data.model.BudgetBreakdown
import com.example.data.model.BudgetTier
import com.example.data.model.DayStop
import com.example.data.model.Destination
import com.example.data.model.FoodGuide
import com.example.data.model.FoodItem
import com.example.data.model.MonthlyWeather
import com.example.data.model.RestaurantItem
import com.example.data.model.TravelCategory
import com.example.data.model.TravelRouteInfo

object RegionalDestinationsData {

    val allRegionalDestinations: List<Destination> = listOf(
        // 1. VISAKHAPATNAM (VIZAG) - Andhra Pradesh
        Destination(
            id = "vizag-coastal",
            name = "Visakhapatnam (Vizag)",
            state = "Andhra Pradesh",
            district = "Visakhapatnam",
            latitude = 17.6868,
            longitude = 83.2185,
            tagline = "The City of Destiny • Golden Shores & Naval Heritage",
            description = "A dynamic coastal metropolis where Eastern Ghats verdant hills cascade into the turquoise Bay of Bengal. World-famous for the decommissioned submarine INS Kursura on RK Beach sands, Blue Flag Rushikonda beach, scenic Bheemili marine drives, and cliffside ropeway vistas at Kailasagiri.",
            rating = 4.7f,
            reviewCount = 3150,
            coverResId = null,
            categories = listOf(TravelCategory.BEACHES, TravelCategory.HERITAGE, TravelCategory.FAMILY, TravelCategory.ROAD_TRIPS),
            bestTime = BestTimeInfo(
                bestMonths = "October to March",
                weatherSummary = "Breezy coastal weather with pleasant sunny days and cool evening sea winds",
                peakSeason = "November – February",
                offSeason = "May – July",
                expectedCrowd = "Active & Lively",
                temperatureRange = "20°C – 30°C",
                suggestedDuration = "3 Days / 2 Nights",
                monthlyBreakdown = listOf(
                    MonthlyWeather("November", "25°C", "Dry & pleasant", "Moderate", "Submarine museum & sunset beach strolls"),
                    MonthlyWeather("December", "22°C", "Clear skies", "Peak", "Water sports, kayaking & Kailasagiri ropeway"),
                    MonthlyWeather("January", "21°C", "Crisp maritime breeze", "Peak", "Coastal marine drive to Bheemili Dutch fort")
                )
            ),
            attractions = listOf(
                Attraction(
                    id = "ins-kursura",
                    name = "INS Kursura Submarine Museum",
                    category = "Naval Museum",
                    distanceKmFromCenter = 2.0f,
                    distanceToNextAttraction = "1 km to TU-142 Aircraft Museum",
                    suggestedDurationHours = "1.5 Hours",
                    description = "A decommissioned Soviet-built Kalvari-class submarine preserved on RK Beach sands. Walk through narrow ballast tanks, sonar bays, and torpedo rooms guided by retired naval personnel.",
                    highlight = "Periscope view & torpedo launch bay",
                    entryFee = "₹70 / Adult, ₹40 / Child",
                    openingTime = "02:00 PM",
                    closingTime = "08:30 PM (Closed Mondays)",
                    insiderTip = "Arrive around 3:30 PM to combine with the TU-142 Aircraft Museum across the boulevard with minimal waiting.",
                    photographyAdvice = "Capture exterior silhouettes against sunset waves from the beachfront walkway.",
                    familySuitability = "Thrilling, educational walk for children and history enthusiasts.",
                    seniorAccessibility = "Narrow circular hatchways require bending and step navigation.",
                    nearbySpots = listOf("TU-142 Museum", "Victory at Sea Memorial", "RK Beach Promenade")
                ),
                Attraction(
                    id = "rushikonda-beach",
                    name = "Rushikonda Beach & Coastal Drive",
                    category = "Beach & Watersports",
                    distanceKmFromCenter = 12.0f,
                    distanceToNextAttraction = "6 km to Thotlakonda",
                    suggestedDurationHours = "3 Hours",
                    description = "Blue Flag certified beach with golden sands and gentle surf, flanked by rolling green hills. Renowned for sea kayaking, jet-skiing, speedboats, and beachside Andhra seafood.",
                    highlight = "Jet-skiing and freshly grilled spiced coastal prawns",
                    entryFee = "Free (Watersports ₹350 - ₹600)",
                    openingTime = "06:00 AM",
                    closingTime = "07:30 PM",
                    insiderTip = "Head to the quiet southern cove near the fishing hamlet for calm swimming away from jet-ski lanes.",
                    photographyAdvice = "Panoramic shots from the hill resort cliff terrace looking north over curved bays.",
                    familySuitability = "Lifeguards on duty with designated swimming zones.",
                    seniorAccessibility = "Paved promenade with shaded sea-facing concrete benches.",
                    nearbySpots = listOf("Thotlakonda Buddhist Complex", "Bheemili Beach")
                )
            ),
            stays = listOf(
                Accommodation(
                    id = "haritha-rushikonda",
                    name = "Haritha Beach Resort Rushikonda",
                    type = "Resort",
                    pricePerNight = 3200,
                    rating = 4.4f,
                    reviewsCount = 890,
                    distanceFromAttractions = "Directly on Rushikonda Beach",
                    amenities = listOf("Sea-Facing Balcony", "Seafood Restaurant", "Beach Access", "Parking"),
                    highlights = "Perched on a coastal cliff with 180-degree sunrise ocean vistas",
                    categoryType = "Mid-Range"
                ),
                Accommodation(
                    id = "novotel-vizag",
                    name = "Novotel Visakhapatnam Varun Beach",
                    type = "Hotel",
                    pricePerNight = 6800,
                    rating = 4.7f,
                    reviewsCount = 2400,
                    distanceFromAttractions = "RK Beach Front",
                    amenities = listOf("Infinity Pool", "Oceanfront Dining", "Spa", "Fitness Center"),
                    highlights = "Luxury property overlooking crashing waves with rooftop lounge",
                    categoryType = "Luxury"
                )
            ),
            foodGuide = FoodGuide(
                localSpecialties = listOf(
                    FoodItem(
                        name = "Vizag Royyala Vepudu (Prawn Fry)",
                        isVegetarian = false,
                        description = "Plump local tiger prawns tossed in crushed shallots, green chilies, curry leaves, and coastal Andhra garam masala.",
                        popularAt = "Coastal dhabas along Bheemili marine drive",
                        priceRange = "₹350 - ₹480",
                        whereToTry = "Sea Inn (Raju Gari Dhaba), Beach Road"
                    ),
                    FoodItem(
                        name = "Madugula Halwa",
                        isVegetarian = true,
                        description = "Centuries-old wheat milk fudge simmered slowly with pure ghee, sugar, and roasted cashews.",
                        popularAt = "Heritage sweet shops in Jagadamba center",
                        priceRange = "₹180 / 250g",
                        whereToTry = "Madugula Sweets counter, Jagadamba Junction"
                    )
                ),
                restaurants = listOf(
                    RestaurantItem(
                        name = "Sea Inn (Raju Gari Dhaba)",
                        cuisine = "Coastal Andhra & Seafood",
                        rating = 4.6f,
                        isVegFriendly = true,
                        signatureDish = "Crab Roast & Royyala Pulao",
                        priceForTwo = "₹750",
                        distance = "Bheemili Beach Road"
                    )
                )
            ),
            travelRoute = TravelRouteInfo(
                originDistances = mapOf("Hyderabad" to 615, "Vijayawada" to 350, "Bengaluru" to 990, "Chennai" to 790, "Visakhapatnam" to 0),
                drivingTimes = mapOf("Hyderabad" to "11h 00m", "Vijayawada" to "6h 15m", "Bengaluru" to "16h 30m"),
                roadTripRoute = "NH65 expressway to Vijayawada, then 6-lane NH16 via Rajahmundry directly to Visakhapatnam.",
                tollAndParkingNotes = "FASTag tolls ~₹800 one-way from Hyderabad; paid parking ₹30 at major beaches.",
                nearestRailwayStation = "Visakhapatnam Junction (VSKP) - Major Railway Hub",
                nearestAirport = "Visakhapatnam International Airport (VTZ) - in city",
                busTrainFlightOptions = "Vande Bharat Express daily from Secunderabad; multiple daily direct flights from Hyderabad, Bengaluru, Delhi.",
                fuelEstimateCar = mapOf("Hyderabad" to 8200, "Vijayawada" to 4800),
                tollEstimate = mapOf("Hyderabad" to 1600, "Vijayawada" to 850),
                roadCondition = "Superb 4-to-6 lane divided national highway with modern food plazas."
            ),
            budget = BudgetBreakdown(
                stayEstimatePerNight = 3200,
                foodEstimatePerDay = 1200,
                activitiesTotal = 1200,
                travelEstimate = 6000,
                totalEstimateMin = 11000,
                totalEstimateMax = 25000,
                tiers = listOf(
                    BudgetTier("Budget", 7000, 12000, 16500, 15000),
                    BudgetTier("Mid-Range", 11000, 18000, 25000, 22000),
                    BudgetTier("Luxury", 19000, 31000, 42000, 38000)
                )
            ),
            timedScheduleTemplate = listOf(
                DayStop("08:30 AM", "Coastal Breakfast", "Hot fluffy pesarattu with ginger chutney along RK beach", "1 hour"),
                DayStop("10:00 AM", "Naval Explorations", "INS Kursura Submarine & TU-142 Aircraft museums", "2.5 hours", tip = "Buy combo ticket at counter"),
                DayStop("01:00 PM", "Seafood Lunch", "Spicy prawn fry and crab curry at beachfront dhaba", "1.5 hours"),
                DayStop("03:30 PM", "Watersports & Surf", "Rushikonda Beach kayaking and jet skiing", "2.5 hours"),
                DayStop("06:30 PM", "Sunset Ropeway", "Kailasagiri Hilltop park panoramic coast sunset", "1.5 hours")
            )
        ),

        // 2. LAMBASINGI - Andhra Pradesh
        Destination(
            id = "lambasingi",
            name = "Lambasingi",
            state = "Andhra Pradesh",
            district = "Alluri Sitharama Raju",
            latitude = 17.8227,
            longitude = 82.5292,
            tagline = "The Kashmir of Andhra Pradesh • Winter Frost & Apple Orchards",
            description = "Perched at 1,000 meters altitude deep inside the Chintapalli forest range, Lambasingi is renowned as South India's only spot where winter temperatures plunge close to 0°C. Known for dawn cloud beds, apple and strawberry plantations, pine woods, and secluded waterfalls.",
            rating = 4.5f,
            reviewCount = 1480,
            coverResId = null,
            categories = listOf(TravelCategory.MOUNTAINS, TravelCategory.NATURE, TravelCategory.COUPLES, TravelCategory.ROAD_TRIPS),
            bestTime = BestTimeInfo(
                bestMonths = "November to January",
                weatherSummary = "Sub-zero to single digit mornings enveloped in dense white fog with sunny afternoons",
                peakSeason = "December – January",
                offSeason = "April – June",
                expectedCrowd = "High on winter weekends",
                temperatureRange = "2°C – 22°C",
                suggestedDuration = "2 Days / 1 Night",
                monthlyBreakdown = listOf(
                    MonthlyWeather("November", "14°C", "Dry & cool mist", "Moderate", "Strawberry farm visits & tent camping"),
                    MonthlyWeather("December", "5°C", "Chilling frost", "Peak", "Sunrise cloud bed viewing & bonfires"),
                    MonthlyWeather("January", "4°C", "Freezing mornings", "Peak", "Apple orchard tours & waterfall treks")
                )
            ),
            attractions = listOf(
                Attraction(
                    id = "lambasingi-sunrise",
                    name = "Sunrise View Point (Cloud Bed)",
                    category = "Scenic Peak",
                    distanceKmFromCenter = 2.5f,
                    distanceToNextAttraction = "6 km to Thajangi Reservoir",
                    suggestedDurationHours = "2 Hours",
                    description = "A breathtaking vantage point where visitors gather at dawn to witness the sun rise over a rolling ocean of clouds (Cloud Bed) filling the forested valley.",
                    highlight = "Sea of clouds at 06:00 AM",
                    entryFee = "Free",
                    openingTime = "05:00 AM",
                    closingTime = "09:00 AM",
                    insiderTip = "Reach before 05:45 AM. Wear thermal layers, beanies, and gloves as the morning wind chill is intense.",
                    photographyAdvice = "Time-lapse video of fog floating between hill ridges as orange sun rises.",
                    familySuitability = "Short walk from roadside; hot tea and maggi stalls available.",
                    seniorAccessibility = "Gentle slope; avoid climbing steep earthen berms in the dark.",
                    nearbySpots = listOf("Thajangi Reservoir", "Kothapalli Waterfalls")
                ),
                Attraction(
                    id = "thajangi-lake",
                    name = "Thajangi Reservoir & Adventure Hub",
                    category = "Lake & Adventure",
                    distanceKmFromCenter = 6.0f,
                    distanceToNextAttraction = "22 km to Kothapalli Falls",
                    suggestedDurationHours = "2 Hours",
                    description = "An emerald lake cradled by green mountains, offering thrilling zipline crossings over water, zorbing, and pedal boating in crisp hill air.",
                    highlight = "Zipline over the pristine lake",
                    entryFee = "Free (Zipline ~₹250)",
                    openingTime = "08:30 AM",
                    closingTime = "05:30 PM",
                    insiderTip = "Visit midday when the sun warms the water and breeze is gentle.",
                    photographyAdvice = "Reflections of pine-clad hills in the mirror-calm reservoir.",
                    familySuitability = "Zipline is safe with certified harnesses; great for kids 7+.",
                    seniorAccessibility = "Paved lakeside benches to enjoy the fresh mountain air.",
                    nearbySpots = listOf("Pine Forests", "Strawberry Farms")
                )
            ),
            stays = listOf(
                Accommodation(
                    id = "haritha-lambasingi",
                    name = "APTDC Haritha Hill Resort Lambasingi",
                    type = "Resort",
                    pricePerNight = 2500,
                    rating = 4.2f,
                    reviewsCount = 650,
                    distanceFromAttractions = "Central Lambasingi",
                    amenities = listOf("Heated Blankets", "Lawn Campfire", "Restaurant", "Parking"),
                    highlights = "Cozy Swiss wooden cottages designed for chilly winter nights",
                    categoryType = "Mid-Range"
                )
            ),
            foodGuide = FoodGuide(
                localSpecialties = listOf(
                    FoodItem(
                        name = "Organic Lambasingi Strawberries",
                        isVegetarian = true,
                        description = "Freshly harvested juicy strawberries from hillside agro farms.",
                        popularAt = "Roadside farm stalls near Thajangi",
                        priceRange = "₹100 - ₹150 / box",
                        whereToTry = "Directly at harvest agro-farms"
                    ),
                    FoodItem(
                        name = "Bongu Kodi & Hot Pepper Rasam",
                        isVegetarian = false,
                        description = "Tender country chicken cooked in green bamboo without oil, paired with steaming black-pepper rasam to warm up cold mornings.",
                        popularAt = "Village woodfire kitchens",
                        priceRange = "₹300 / portion",
                        whereToTry = "Chintapalli Junction Forest Dhaba"
                    )
                ),
                restaurants = listOf(
                    RestaurantItem(
                        name = "Prakruti Hill View Meals",
                        cuisine = "Andhra Homestyle",
                        rating = 4.3f,
                        isVegFriendly = true,
                        signatureDish = "Hot Steamed Rice with Ulavacharu & Ghee",
                        priceForTwo = "₹400",
                        distance = "Main Road"
                    )
                )
            ),
            travelRoute = TravelRouteInfo(
                originDistances = mapOf("Hyderabad" to 590, "Visakhapatnam" to 102, "Vijayawada" to 375, "Bengaluru" to 930),
                drivingTimes = mapOf("Hyderabad" to "11h 30m", "Visakhapatnam" to "2h 45m", "Vijayawada" to "7h 15m"),
                roadTripRoute = "NH16 to Tuni/Narsipatnam, then winding forest ghat road via Narsipatnam up to Lambasingi.",
                tollAndParkingNotes = "FASTag tolls ~₹500; roadside parking free.",
                nearestRailwayStation = "Narsipatnam Road (NRP - 35 km) or Anakapalle (AKP - 75 km)",
                nearestAirport = "Visakhapatnam Airport (VTZ - 100 km)",
                busTrainFlightOptions = "APSRTC buses connect Narsipatnam and Vizag to Lambasingi regularly.",
                fuelEstimateCar = mapOf("Hyderabad" to 7900, "Visakhapatnam" to 1400),
                tollEstimate = mapOf("Hyderabad" to 1500, "Visakhapatnam" to 180),
                roadCondition = "Scenic winding forest road through Narsipatnam ghats; drive carefully on morning fog."
            ),
            budget = BudgetBreakdown(
                stayEstimatePerNight = 2500,
                foodEstimatePerDay = 900,
                activitiesTotal = 800,
                travelEstimate = 5500,
                totalEstimateMin = 9500,
                totalEstimateMax = 18000,
                tiers = listOf(
                    BudgetTier("Budget", 6000, 10500, 14500, 13500),
                    BudgetTier("Mid-Range", 9500, 15500, 22000, 20000),
                    BudgetTier("Luxury", 15000, 24000, 34000, 30000)
                )
            ),
            timedScheduleTemplate = listOf(
                DayStop("05:30 AM", "Sunrise Cloud Bed", "Catch dawn over the floating mist at Sunrise Viewpoint", "2 hours", tip = "Thermal woolens mandatory"),
                DayStop("08:00 AM", "Village Chai & Tiffin", "Steaming ginger tea and hot idlis at local stalls", "45 mins"),
                DayStop("09:30 AM", "Berry Picking", "Tour agro farms and hand-pick sweet strawberries", "1.5 hours"),
                DayStop("11:30 AM", "Lake Adventure", "Thajangi Reservoir zipline and pedal boating", "2 hours"),
                DayStop("02:00 PM", "Bamboo Lunch", "Hot bamboo chicken and flavored rice", "1 hour"),
                DayStop("03:30 PM", "Waterfall Trek", "Trek down to Kothapalli Waterfalls", "2.5 hours"),
                DayStop("07:30 PM", "Campfire Night", "Cozy bonfire under cold starry skies", "2.5 hours")
            )
        ),

        // 3. HORSLEY HILLS - Andhra Pradesh
        Destination(
            id = "horsley-hills",
            name = "Horsley Hills",
            state = "Andhra Pradesh",
            district = "Chittoor",
            latitude = 13.6500,
            longitude = 78.4000,
            tagline = "Ooty of Andhra • Whispering Eucalyptus & Calm Breezes",
            description = "A serene, uncommercialized hill resort situated at 1,290 meters in Chittoor district. Wrapped in sprawling eucalyptus and gulmohar groves, famous for dramatic winds at Gali Bandalu, Kaigal Waterfalls, and 150-year-old giant eucalyptus trees planted by British collector W.D. Horsley.",
            rating = 4.5f,
            reviewCount = 1320,
            coverResId = null,
            categories = listOf(TravelCategory.MOUNTAINS, TravelCategory.NATURE, TravelCategory.COUPLES, TravelCategory.ROAD_TRIPS),
            bestTime = BestTimeInfo(
                bestMonths = "September to February",
                weatherSummary = "Consistently pleasant and breezy year-round; chilly winter evenings",
                peakSeason = "November – January",
                offSeason = "April – May",
                expectedCrowd = "Peaceful & Relaxed",
                temperatureRange = "15°C – 28°C",
                suggestedDuration = "2 Days / 1 Night",
                monthlyBreakdown = listOf(
                    MonthlyWeather("October", "21°C", "Post-monsoon lush green", "Moderate", "Kaigal falls & nature trails"),
                    MonthlyWeather("December", "16°C", "Crisp chilly breezes", "Peak", "Sunset winds at Gali Bandalu & campfires")
                )
            ),
            attractions = listOf(
                Attraction(
                    id = "gali-bandalu",
                    name = "Gali Bandalu (Windy Rock)",
                    category = "Natural Viewpoint",
                    distanceKmFromCenter = 1.0f,
                    distanceToNextAttraction = "2 km to Viewpoint",
                    suggestedDurationHours = "1.5 Hours",
                    description = "An expansive monolithic sloping rock face renowned for powerful gusts of cool wind blowing continuously throughout the year with sweeping 180-degree valley views.",
                    highlight = "Extreme mountain wind gusts & panoramic sunset",
                    entryFee = "Free",
                    openingTime = "06:00 AM",
                    closingTime = "06:30 PM",
                    insiderTip = "Hold on to hats and glasses; winds are remarkably strong at sunset.",
                    photographyAdvice = "Dramatic silhouette photos against evening orange skies.",
                    familySuitability = "Wide flat rock surface; hold hands of young kids near edges.",
                    seniorAccessibility = "Gentle walking incline from parking.",
                    nearbySpots = listOf("Kalyani Eucalyptus Tree", "Horsley Zoo")
                )
            ),
            stays = listOf(
                Accommodation(
                    id = "haritha-horsley",
                    name = "Haritha Hill Resort Horsley Hills",
                    type = "Resort",
                    pricePerNight = 2400,
                    rating = 4.2f,
                    reviewsCount = 780,
                    distanceFromAttractions = "Hilltop Central",
                    amenities = listOf("Swimming Pool", "Lawn Gardens", "Restaurant", "Campfire"),
                    highlights = "Historic British-era stone cottages framed by tall eucalyptus",
                    categoryType = "Mid-Range"
                )
            ),
            foodGuide = FoodGuide(
                localSpecialties = listOf(
                    FoodItem(
                        name = "Rayalaseema Ragi Sangati with Natukodi",
                        isVegetarian = false,
                        description = "Nutritious steamed finger-millet balls served with rich spicy country chicken gravy and dollops of pure ghee.",
                        popularAt = "Hilltop dhabas and Haritha restaurant",
                        priceRange = "₹220 - ₹320",
                        whereToTry = "Hilltop Family Dhaba"
                    ),
                    FoodItem(
                        name = "Wild Eucalyptus Honey",
                        isVegetarian = true,
                        description = "Pure, unadulterated forest honey harvested by local tribes from blossoming eucalyptus trees.",
                        popularAt = "Tribal cooperative stalls near viewpoints",
                        priceRange = "₹250 / 500g",
                        whereToTry = "Forest Department Gift Shop"
                    )
                ),
                restaurants = listOf(
                    RestaurantItem(
                        name = "Haritha Hilltop Restaurant",
                        cuisine = "Andhra & South Indian",
                        rating = 4.1f,
                        isVegFriendly = true,
                        signatureDish = "Rayalaseema Thali & Country Chicken",
                        priceForTwo = "₹500",
                        distance = "Inside Resort"
                    )
                )
            ),
            travelRoute = TravelRouteInfo(
                originDistances = mapOf("Bengaluru" to 145, "Chennai" to 260, "Hyderabad" to 520, "Tirupati" to 125),
                drivingTimes = mapOf("Bengaluru" to "3h 15m", "Chennai" to "5h 30m", "Hyderabad" to "9h 30m"),
                roadTripRoute = "From Bengaluru: Old Madras Road -> Hoskote -> Chintamani -> Madanapalle -> Horsley Hills (NH69 & NH42).",
                tollAndParkingNotes = "FASTag tolls ~₹120 from Bengaluru; resort parking free.",
                nearestRailwayStation = "Madanapalle Road (MPL - 14 km)",
                nearestAirport = "Bengaluru Kempegowda Airport (BLR - 135 km)",
                busTrainFlightOptions = "APSRTC and KSRTC direct buses connect Madanapalle with Bengaluru, Tirupati, and Chennai.",
                fuelEstimateCar = mapOf("Bengaluru" to 2100, "Hyderabad" to 7100),
                tollEstimate = mapOf("Bengaluru" to 240, "Hyderabad" to 950),
                roadCondition = "Excellent 4-lane highway till Madanapalle, followed by a picturesque, smooth 14-curve hill climb."
            ),
            budget = BudgetBreakdown(
                stayEstimatePerNight = 2400,
                foodEstimatePerDay = 900,
                activitiesTotal = 600,
                travelEstimate = 3500,
                totalEstimateMin = 7500,
                totalEstimateMax = 15000,
                tiers = listOf(
                    BudgetTier("Budget", 4500, 8000, 11500, 10500),
                    BudgetTier("Mid-Range", 7500, 12500, 17500, 16000),
                    BudgetTier("Luxury", 12000, 19500, 27000, 24000)
                )
            ),
            timedScheduleTemplate = listOf(
                DayStop("08:00 AM", "Scenic Drive from Bengaluru", "Road trip via Hoskote and Chintamani eucalyptus highway", "3 hours"),
                DayStop("11:30 AM", "Check-in & Giant Eucalyptus", "Visit the 150-year-old Kalyani Eucalyptus Tree", "1 hour"),
                DayStop("01:00 PM", "Rayalaseema Feast", "Ragi Sangati with country chicken and spicy gravy", "1 hour"),
                DayStop("03:30 PM", "Viewpoint Stroll", "Valley viewpoints and forest walking path", "2 hours"),
                DayStop("05:30 PM", "Sunset at Windy Rock", "Feel the mountain winds at Gali Bandalu during sunset", "1.5 hours"),
                DayStop("08:00 PM", "Campfire Dinner", "Lawn campfire under starry skies", "2 hours")
            )
        ),

        // 4. ANANTHAGIRI HILLS - Telangana
        Destination(
            id = "ananthagiri-hills",
            name = "Ananthagiri Hills",
            state = "Telangana",
            district = "Vikarabad",
            latitude = 17.3106,
            longitude = 77.8631,
            tagline = "Hyderabad's Nearest Hill Sanctuary • Forest Canopy & Musi Headwaters",
            description = "Located just 80 km from Hyderabad, Ananthagiri Hills is the birth place of the Musi River and Telangana's most popular green hill retreat. Characterized by dense deciduous forest trekking trails, the 400-year-old Sri Anantha Padmanabha Swamy temple, and tranquil kayaking on Kotepally lake.",
            rating = 4.5f,
            reviewCount = 2450,
            coverResId = null,
            categories = listOf(TravelCategory.NATURE, TravelCategory.MOUNTAINS, TravelCategory.ADVENTURE, TravelCategory.ROAD_TRIPS, TravelCategory.COUPLES),
            bestTime = BestTimeInfo(
                bestMonths = "July to February",
                weatherSummary = "Lush green and romantic during monsoons; breezy and cool in winter",
                peakSeason = "August – November",
                offSeason = "March – May",
                expectedCrowd = "High on weekends",
                temperatureRange = "16°C – 28°C",
                suggestedDuration = "2 Days / 1 Night (or Day Trip)",
                monthlyBreakdown = listOf(
                    MonthlyWeather("August", "24°C", "Monsoon mist & waterfalls", "Peak", "Jungle trekking & forest trails"),
                    MonthlyWeather("November", "20°C", "Fresh & cool", "Moderate", "Kotepally reservoir kayaking & camping"),
                    MonthlyWeather("January", "16°C", "Chilly nights", "Peak", "Campfires, stargazing & temple visit")
                )
            ),
            attractions = listOf(
                Attraction(
                    id = "padmanabha-temple",
                    name = "Sri Anantha Padmanabha Swamy Temple",
                    category = "Heritage & Temple",
                    distanceKmFromCenter = 1.0f,
                    distanceToNextAttraction = "3 km to Viewpoint",
                    suggestedDurationHours = "1 Hour",
                    description = "Historic temple built inside deep forest groves, dedicated to Lord Vishnu and visited by centuries of pilgrims.",
                    highlight = "Ancient forest banyan trees and holy water springs",
                    entryFee = "Free",
                    openingTime = "06:00 AM",
                    closingTime = "07:30 PM",
                    insiderTip = "Visit at 07:00 AM before city road-trippers arrive to enjoy bird songs and temple serenity.",
                    photographyAdvice = "Stone temple towers framed by morning mist and centuries-old banyan branches.",
                    familySuitability = "Spacious stone courtyards suitable for all generations.",
                    seniorAccessibility = "Ramp available near temple entrance; gentle terrain.",
                    nearbySpots = listOf("Vikarabad Forest Trail", "Nagasamudram Lake")
                ),
                Attraction(
                    id = "kotepally-kayaking",
                    name = "Kotepally Reservoir & Water Sports",
                    category = "Water & Adventure",
                    distanceKmFromCenter = 18.0f,
                    distanceToNextAttraction = "15 km to Hills Peak",
                    suggestedDurationHours = "2.5 Hours",
                    description = "A shimmering freshwater lake nestled between scrub hills offering tandem kayak rentals, pedal boating, and hot roasted corn by the water.",
                    highlight = "Tandem sea kayaking in tranquil waters",
                    entryFee = "Kayaking ~₹200 / 30 mins",
                    openingTime = "09:00 AM",
                    closingTime = "06:00 PM",
                    insiderTip = "Paddle into the quiet eastern cove away from the launch ramp for uninterrupted scenic reflections.",
                    photographyAdvice = "Late afternoon golden light illuminating ripples and kayakers.",
                    familySuitability = "Life jackets provided; safe and enjoyable for kids 6+.",
                    seniorAccessibility = "Shaded seating huts along the waterbank.",
                    nearbySpots = listOf("Grasslands Camp", "Buggabai Waterfalls")
                )
            ),
            stays = listOf(
                Accommodation(
                    id = "haritha-ananthagiri",
                    name = "TG Tourism Haritha Hill Resort",
                    type = "Resort",
                    pricePerNight = 2200,
                    rating = 4.1f,
                    reviewsCount = 890,
                    distanceFromAttractions = "Opposite Forest Trail",
                    amenities = listOf("Forest View Rooms", "Restaurant", "Garden Lawn", "Ample Parking"),
                    highlights = "Directly across the road from main forest trekking entry points",
                    categoryType = "Mid-Range"
                )
            ),
            foodGuide = FoodGuide(
                localSpecialties = listOf(
                    FoodItem(
                        name = "Telangana Pachi Pulusu & Jowar Roti",
                        isVegetarian = true,
                        description = "Tangy raw tamarind soup tempered with fire-roasted green chilies, onions and cumin, served with rustic handmade sorghum flatbreads.",
                        popularAt = "Highway dhabas between Chevella and Vikarabad",
                        priceRange = "₹120 - ₹200",
                        whereToTry = "Chevella Highway Family Dhabas"
                    ),
                    FoodItem(
                        name = "Vikarabad Natukodi Pulao",
                        isVegetarian = false,
                        description = "Country chicken cooked in home-pounded Telangana garam masala, layered with spiced fragrant rice.",
                        popularAt = "Local forest dhabas",
                        priceRange = "₹320 - ₹450",
                        whereToTry = "Ananthagiri Forest Dhabas"
                    )
                ),
                restaurants = listOf(
                    RestaurantItem(
                        name = "Haritha Hilltop Dining",
                        cuisine = "Telangana & South Indian",
                        rating = 4.2f,
                        isVegFriendly = true,
                        signatureDish = "Bagara Rice with Chicken Curry",
                        priceForTwo = "₹500",
                        distance = "Near Forest Gate"
                    )
                )
            ),
            travelRoute = TravelRouteInfo(
                originDistances = mapOf("Hyderabad" to 82, "Bengaluru" to 560, "Vijayawada" to 350, "Pune" to 510),
                drivingTimes = mapOf("Hyderabad" to "1h 50m", "Bengaluru" to "9h 30m"),
                roadTripRoute = "Hyderabad (Mehdipatnam) -> Appa Junction -> Chevella -> Manneguda -> Vikarabad -> Ananthagiri Hills.",
                tollAndParkingNotes = "No highway tolls on the Chevella route! Free parking throughout.",
                nearestRailwayStation = "Vikarabad Junction (VKB - 6 km, frequent trains from Secunderabad)",
                nearestAirport = "Hyderabad Rajiv Gandhi International Airport (HYD - 75 km)",
                busTrainFlightOptions = "Hourly express TSRTC buses from Hyderabad MGBS / Jubilee Bus Station directly to Vikarabad.",
                fuelEstimateCar = mapOf("Hyderabad" to 1200, "Bengaluru" to 7500),
                tollEstimate = mapOf("Hyderabad" to 0, "Bengaluru" to 900),
                roadCondition = "Smooth 2-lane tree-lined state highway through scenic Chevella farmlands."
            ),
            budget = BudgetBreakdown(
                stayEstimatePerNight = 2200,
                foodEstimatePerDay = 800,
                activitiesTotal = 600,
                travelEstimate = 1500,
                totalEstimateMin = 4500,
                totalEstimateMax = 10000,
                tiers = listOf(
                    BudgetTier("Budget", 2800, 5200, 7500, 6800),
                    BudgetTier("Mid-Range", 4500, 8500, 12000, 11000),
                    BudgetTier("Luxury", 7500, 14000, 19000, 17000)
                )
            ),
            timedScheduleTemplate = listOf(
                DayStop("07:00 AM", "Morning Drive", "Scenic drive from Hyderabad via Chevella road", "2 hours"),
                DayStop("09:00 AM", "Temple Darshan", "Sri Anantha Padmanabha Swamy Temple", "1 hour"),
                DayStop("10:30 AM", "Forest Canopy Trek", "Guided trek through Vikarabad nature trail", "2 hours"),
                DayStop("01:00 PM", "Telangana Lunch", "Bagara rice and spicy Natukodi at hilltop dhaba", "1.5 hours"),
                DayStop("03:30 PM", "Kayaking Adventure", "Kotepally Reservoir kayaking and lakeside relaxation", "2.5 hours"),
                DayStop("06:30 PM", "Sunset & Return", "Watch valley sunset and drive back to Hyderabad", "2 hours")
            )
        ),

        // 5. GANDIKOTA - Andhra Pradesh
        Destination(
            id = "gandikota",
            name = "Gandikota",
            state = "Andhra Pradesh",
            district = "YSR Kadapa",
            latitude = 14.8143,
            longitude = 78.2863,
            tagline = "The Grand Canyon of India • Erramala Gorge & Historic Fort",
            description = "A breathtaking natural spectacle where the Pennar River cuts a dramatic 300-foot deep red granite chasm through the Erramala hills. Crowned by a massive 12th-century stone fort complex featuring the Raghunatha Swamy temple, Madhavaraya temple, and grand granaries.",
            rating = 4.8f,
            reviewCount = 2100,
            coverResId = null,
            categories = listOf(TravelCategory.HERITAGE, TravelCategory.ADVENTURE, TravelCategory.NATURE, TravelCategory.ROAD_TRIPS),
            bestTime = BestTimeInfo(
                bestMonths = "October to March",
                weatherSummary = "Pleasant sunny winter days and chilly canyon breezes; stunning starry nights",
                peakSeason = "November – February",
                offSeason = "April – June (hot summers)",
                expectedCrowd = "Moderate on weekends",
                temperatureRange = "16°C – 32°C",
                suggestedDuration = "2 Days / 1 Night",
                monthlyBreakdown = listOf(
                    MonthlyWeather("November", "23°C", "Crisp breeze", "Moderate", "Gorge hiking, camping & rock climbing"),
                    MonthlyWeather("December", "18°C", "Cool canyon air", "Peak", "Sunset photography & campfire stargazing")
                )
            ),
            attractions = listOf(
                Attraction(
                    id = "gandikota-gorge",
                    name = "Pennar River Canyon Gorge Viewpoint",
                    category = "Natural Wonder",
                    distanceKmFromCenter = 0.5f,
                    distanceToNextAttraction = "1 km to Madhavaraya Temple",
                    suggestedDurationHours = "2.5 Hours",
                    description = "A massive 300-foot deep canyon of layered red sandstone boulders overlooking the shimmering blue Pennar River. Resembles the Grand Canyon of Arizona.",
                    highlight = "300-foot red sandstone canyon gorge at sunset",
                    entryFee = "Free",
                    openingTime = "Open 24 Hours",
                    closingTime = "Sunset recommended",
                    insiderTip = "Climb the boulder stacks directly behind the Raghunatha temple around 05:00 PM for the most dramatic angle.",
                    photographyAdvice = "Ultra-wide angle lens to capture canyon depth and serpentine river below.",
                    familySuitability = "Unfenced cliff edges; maintain cautious distance with young children.",
                    seniorAccessibility = "Uneven rocky paths near gorge rim; comfortable viewing areas near fort walls.",
                    nearbySpots = listOf("Belum Caves", "Mylavaram Dam")
                )
            ),
            stays = listOf(
                Accommodation(
                    id = "haritha-gandikota",
                    name = "Haritha Resort Gandikota",
                    type = "Resort",
                    pricePerNight = 2400,
                    rating = 4.3f,
                    reviewsCount = 920,
                    distanceFromAttractions = "Inside Fort Grounds",
                    amenities = listOf("Air Conditioned Rooms", "Restaurant", "Courtyard Lawn", "Parking"),
                    highlights = "Located walking distance from the canyon rim and temple ruins",
                    categoryType = "Mid-Range"
                )
            ),
            foodGuide = FoodGuide(
                localSpecialties = listOf(
                    FoodItem(
                        name = "Rayalaseema Ragi Mudda with Gongura Mutton",
                        isVegetarian = false,
                        description = "Hot finger-millet dumpling served with spicy, tangy sorrel leaves (Gongura) mutton curry and pure country ghee.",
                        popularAt = "Local eateries near fort gate",
                        priceRange = "₹250 - ₹350",
                        whereToTry = "Haritha Dining Hall and village messes"
                    )
                ),
                restaurants = listOf(
                    RestaurantItem(
                        name = "Freakouts Camp Dining",
                        cuisine = "South Indian & Barbecue",
                        rating = 4.4f,
                        isVegFriendly = true,
                        signatureDish = "Tandoori Chicken & Rayalaseema Meals",
                        priceForTwo = "₹550",
                        distance = "Near Gorge Rim"
                    )
                )
            ),
            travelRoute = TravelRouteInfo(
                originDistances = mapOf("Bengaluru" to 280, "Hyderabad" to 385, "Chennai" to 390, "Tirupati" to 220),
                drivingTimes = mapOf("Bengaluru" to "5h 45m", "Hyderabad" to "7h 15m", "Chennai" to "8h 00m"),
                roadTripRoute = "From Hyd: NH44 to Kurnool -> Dhone -> Banaganapalli (Belum Caves) -> Jammalamadugu -> Gandikota.",
                tollAndParkingNotes = "FASTag tolls ~₹350; free parking on fort grounds.",
                nearestRailwayStation = "Muddanuru (MOO - 28 km) or Jammalamadugu (JMDG - 15 km)",
                nearestAirport = "Kadapa Airport (CDP - 75 km); Bengaluru (BLR - 260 km)",
                busTrainFlightOptions = "Regular state buses run from Jammalamadugu to Gandikota; best visited as a road trip paired with Belum Caves.",
                fuelEstimateCar = mapOf("Bengaluru" to 3800, "Hyderabad" to 5400),
                tollEstimate = mapOf("Bengaluru" to 420, "Hyderabad" to 600),
                roadCondition = "Smooth 4-lane NH44 till Kurnool/Gooty, followed by good state highway through scenic rustic terrain."
            ),
            budget = BudgetBreakdown(
                stayEstimatePerNight = 2400,
                foodEstimatePerDay = 800,
                activitiesTotal = 700,
                travelEstimate = 4000,
                totalEstimateMin = 8500,
                totalEstimateMax = 17000,
                tiers = listOf(
                    BudgetTier("Budget", 5000, 9000, 13000, 12000),
                    BudgetTier("Mid-Range", 8000, 14000, 19500, 18000),
                    BudgetTier("Luxury", 13000, 21000, 29000, 26000)
                )
            ),
            timedScheduleTemplate = listOf(
                DayStop("07:00 AM", "Morning Drive", "Depart via scenic NH44 highway route", "4 hours"),
                DayStop("11:30 AM", "Subterranean Belum Caves", "Explore underground limestone caverns en route", "2.5 hours", tip = "Carry water bottle; humid inside"),
                DayStop("02:30 PM", "Check-in Gandikota", "Arrive and check in at cliffside camp/resort", "1 hour"),
                DayStop("04:30 PM", "Grand Canyon Sunset", "Witness setting sun casting fiery red hues over the gorge", "2.5 hours"),
                DayStop("07:30 PM", "Campfire & Stargazing", "Campfire overlooking the canyon breeze", "2.5 hours")
            )
        )
    )
}
