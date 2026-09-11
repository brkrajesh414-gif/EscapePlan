package com.example.data.datasource

import com.example.R
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

object DestinationsDataSource {

    val supportedOriginCities = listOf(
        "Hyderabad",
        "Bengaluru",
        "Chennai",
        "Kochi",
        "Coimbatore",
        "Visakhapatnam",
        "Mumbai",
        "Delhi",
        "Pune",
        "Kolkata"
    )

    private val baseDestinations: List<Destination> = listOf(
        Destination(
            id = "araku-valley",
            name = "Araku Valley",
            state = "Andhra Pradesh",
            tagline = "Misty Coffee Plantations & Eastern Ghats",
            description = "A serene hill station wrapped in mist, evergreen forests, and organic coffee estates. Famous for prehistoric Borra Caves, gushing waterfalls, indigenous tribal culture, and the scenic Vistadome railway through 58 mountain tunnels.",
            rating = 4.6f,
            reviewCount = 1840,
            coverResId = R.drawable.araku_valley_hero,
            categories = listOf(
                TravelCategory.MOUNTAINS,
                TravelCategory.NATURE,
                TravelCategory.COUPLES,
                TravelCategory.ROAD_TRIPS
            ),
            bestTime = BestTimeInfo(
                bestMonths = "October to February",
                weatherSummary = "Chilly mornings with rolling fog and crisp sunny afternoons",
                peakSeason = "December – January (tribal dance & coffee bloom)",
                offSeason = "April – June (warm summer)",
                expectedCrowd = "Moderate to Peaceful",
                temperatureRange = "12°C – 25°C",
                suggestedDuration = "2–3 Days"
            ),
            attractions = listOf(
                Attraction(
                    id = "borra-caves",
                    name = "Borra Caves",
                    category = "Natural Wonder",
                    distanceKmFromCenter = 36.0f,
                    distanceToNextAttraction = "15 km to Katiki Waterfalls",
                    suggestedDurationHours = "2 Hours",
                    description = "Million-year-old limestone caves featuring majestic stalactites, stalagmites, and vibrant atmospheric lighting in deep chambers.",
                    highlight = "Naturally formed Shiva Lingam & deep karstic formations",
                    entryFee = "₹80 / person"
                ),
                Attraction(
                    id = "katiki-waterfalls",
                    name = "Katiki Waterfalls",
                    category = "Waterfall & Trek",
                    distanceKmFromCenter = 39.0f,
                    distanceToNextAttraction = "35 km back to Araku Town",
                    suggestedDurationHours = "2.5 Hours",
                    description = "A 50-foot cascading waterfall accessed via exciting open-top 4x4 jeep safari and a short scenic jungle trek.",
                    highlight = "Cool plunge pool & roadside bamboo chicken stalls",
                    entryFee = "Jeep hire: ~₹300/person"
                ),
                Attraction(
                    id = "coffee-museum",
                    name = "Araku Coffee Museum",
                    category = "Heritage & Food",
                    distanceKmFromCenter = 1.0f,
                    distanceToNextAttraction = "1.5 km to Tribal Museum",
                    suggestedDurationHours = "1 Hour",
                    description = "Showcases the history of organic tribal coffee cultivation with live roasting and freshly brewed Arabica tastings.",
                    highlight = "Freshly roasted coffee chocolates & espresso shots",
                    entryFee = "₹20 / person"
                ),
                Attraction(
                    id = "tribal-museum",
                    name = "Araku Tribal Museum",
                    category = "Culture & Heritage",
                    distanceKmFromCenter = 1.5f,
                    distanceToNextAttraction = "14 km to Chaparai",
                    suggestedDurationHours = "1.5 Hours",
                    description = "Preserves the customs, clay lifestyle dioramas, handicrafts, and archery traditions of Eastern Ghats indigenous tribes.",
                    highlight = "Evening Dhimsa tribal dance performances",
                    entryFee = "₹40 / person"
                ),
                Attraction(
                    id = "chaparai",
                    name = "Chaparai Water Cascades",
                    category = "Scenic Picnic Spot",
                    distanceKmFromCenter = 15.0f,
                    distanceToNextAttraction = "20 km to Galikonda View Point",
                    suggestedDurationHours = "2 Hours",
                    description = "Smooth sloping rocky waterbeds surrounded by dense pine forests, ideal for wading in clear stream water.",
                    highlight = "Gentle natural water slide on smooth rocks",
                    entryFee = "₹10 / person"
                ),
                Attraction(
                    id = "galikonda-viewpoint",
                    name = "Galikonda View Point",
                    category = "Viewpoint",
                    distanceKmFromCenter = 20.0f,
                    distanceToNextAttraction = "On route to Vizag",
                    suggestedDurationHours = "45 Mins",
                    description = "Highest point in the Visakhapatnam hills at 1,500m elevation with panoramic valley views of coffee valleys.",
                    highlight = "Sunrise cloud bed and local hot ginger tea stalls",
                    entryFee = "Free"
                )
            ),
            stays = listOf(
                Accommodation(
                    id = "haritha-resort",
                    name = "Haritha Hill Resort (APTDC)",
                    type = "Hill Resort",
                    pricePerNight = 2800,
                    rating = 4.3f,
                    reviewsCount = 420,
                    distanceFromAttractions = "0.8 km from Coffee Museum",
                    amenities = listOf("Cottage View", "Free Parking", "In-house Dining", "Lawn"),
                    highlights = "State-run reliable resort nestled amidst lush trees"
                ),
                Accommodation(
                    id = "rahul-resorts",
                    name = "Rahul Valley View Resort",
                    type = "Resort",
                    pricePerNight = 3200,
                    rating = 4.2f,
                    reviewsCount = 210,
                    distanceFromAttractions = "2 km from town center",
                    amenities = listOf("Balcony View", "Bonfire", "Room Service", "Wi-Fi"),
                    highlights = "Excellent balcony valley views and campfire evenings"
                ),
                Accommodation(
                    id = "nature-nest-homestay",
                    name = "Nature's Nest Coffee Homestay",
                    type = "Homestay",
                    pricePerNight = 1900,
                    rating = 4.5f,
                    reviewsCount = 135,
                    distanceFromAttractions = "4 km from town center",
                    amenities = listOf("Home-cooked Meals", "Plantation Tour", "Pet Friendly"),
                    highlights = "Stay directly on a working organic coffee plantation"
                )
            ),
            foodGuide = FoodGuide(
                localSpecialties = listOf(
                    FoodItem(
                        name = "Bamboo Chicken (Bongu Kodi)",
                        isVegetarian = false,
                        description = "Tender chicken marinated in crushed green chillies, ginger-garlic and spices, stuffed inside raw green bamboo tubes and roasted over wood embers with zero oil.",
                        popularAt = "Near Katiki falls and Chaparai entry"
                    ),
                    FoodItem(
                        name = "Araku Arabica Coffee",
                        isVegetarian = true,
                        description = "Single-origin shade-grown organic coffee hand-picked by local Adivasi farmers with notes of chocolate and citrus.",
                        popularAt = "Araku Coffee Museum cafe"
                    ),
                    FoodItem(
                        name = "Madugula Halwa",
                        isVegetarian = true,
                        description = "Century-old heritage sweet made from wheat milk, pure ghee, and roasted cashew nuts that melts in your mouth.",
                        popularAt = "Highway pit-stops near Chodavaram"
                    ),
                    FoodItem(
                        name = "Bamboo Veg Biryani",
                        isVegetarian = true,
                        description = "Fragrant spiced basmati rice and vegetables cooked inside steamed bamboo culm.",
                        popularAt = "Tribal food huts around Chaparai"
                    )
                ),
                restaurants = listOf(
                    RestaurantItem(
                        name = "Vasu Bamboo Kitchen",
                        cuisine = "Andhra & Tribal Specialties",
                        rating = 4.5f,
                        isVegFriendly = true,
                        signatureDish = "Authentic Bongu Chicken & Ragi Mudda",
                        priceForTwo = "₹500",
                        distance = "1.2 km from town center"
                    ),
                    RestaurantItem(
                        name = "Coffee Museum Cafe",
                        cuisine = "Cafe & Beverages",
                        rating = 4.6f,
                        isVegFriendly = true,
                        signatureDish = "Hot Artisan Cappuccino & Coffee Truffles",
                        priceForTwo = "₹250",
                        distance = "Inside Coffee Museum"
                    ),
                    RestaurantItem(
                        name = "Haritha Restaurant",
                        cuisine = "South Indian Thali",
                        rating = 4.0f,
                        isVegFriendly = true,
                        signatureDish = "Traditional Andhra Veg Bhojanam",
                        priceForTwo = "₹400",
                        distance = "Near APTDC Resort"
                    )
                )
            ),
            travelRoute = TravelRouteInfo(
                originDistances = mapOf(
                    "Hyderabad" to 640,
                    "Visakhapatnam" to 115,
                    "Bengaluru" to 890,
                    "Chennai" to 750,
                    "Mumbai" to 1250,
                    "Delhi" to 1750,
                    "Kolkata" to 920,
                    "Pune" to 1180
                ),
                drivingTimes = mapOf(
                    "Hyderabad" to "12h 30m drive",
                    "Visakhapatnam" to "3h 15m scenic drive",
                    "Bengaluru" to "17h drive",
                    "Chennai" to "14h drive",
                    "Mumbai" to "23h drive",
                    "Delhi" to "32h drive",
                    "Kolkata" to "18h drive",
                    "Pune" to "22h drive"
                ),
                roadTripRoute = "Via NH16 from Vizag -> Srungavarapukota (S.Kota) -> Tyda -> Araku. Excellent tarmac with thrilling 45 km mountain ghat curves.",
                tollAndParkingNotes = "Toll approx ₹120 on highway; parking ₹30–₹50 at major tourist attractions.",
                nearestRailwayStation = "Araku (ARK) or Visakhapatnam (VSKP - 115 km)",
                nearestAirport = "Visakhapatnam International Airport (VTZ - 110 km)",
                busTrainFlightOptions = "Best Option: Take overnight train/flight to Vizag, then take the morning 08551 Vistadome Glass-roof train directly to Araku through 58 mountain tunnels!"
            ),
            budget = BudgetBreakdown(
                stayEstimatePerNight = 2500,
                foodEstimatePerDay = 1800,
                activitiesTotal = 1500,
                travelEstimate = 5500,
                totalEstimateMin = 14000,
                totalEstimateMax = 18000
            )
        ),
        Destination(
            id = "munnar-kerala",
            name = "Munnar",
            state = "Kerala",
            tagline = "Rolling Emerald Tea Hills & Cloud Forests",
            description = "God's own hill retreat carpeted in endless emerald tea plantations, spice aromas, misty waterfalls, and the endangered Nilgiri Tahr mountain goats.",
            rating = 4.8f,
            reviewCount = 3200,
            coverResId = R.drawable.munnar_tea_hills,
            categories = listOf(
                TravelCategory.MOUNTAINS,
                TravelCategory.NATURE,
                TravelCategory.COUPLES,
                TravelCategory.FAMILY
            ),
            bestTime = BestTimeInfo(
                bestMonths = "September to March",
                weatherSummary = "Pleasant cool breeze, mist rolling through tea plantations",
                peakSeason = "December – January & April – May",
                offSeason = "June – August (heavy monsoon)",
                expectedCrowd = "High in peak season, serene in off-season",
                temperatureRange = "10°C – 22°C",
                suggestedDuration = "3–4 Days"
            ),
            attractions = listOf(
                Attraction(
                    id = "eravikulam-national-park",
                    name = "Eravikulam National Park",
                    category = "Wildlife & Nature",
                    distanceKmFromCenter = 12.0f,
                    distanceToNextAttraction = "18 km to Mattupetty",
                    suggestedDurationHours = "3 Hours",
                    description = "Home to the rare Nilgiri Tahr and the highest peak in South India, Anamudi (2,695 m).",
                    highlight = "Nilgiri Tahr spotting along mist-covered walking tracks",
                    entryFee = "₹200 / person"
                ),
                Attraction(
                    id = "mattupetty-dam",
                    name = "Mattupetty Dam & Lake",
                    category = "Lake & Boating",
                    distanceKmFromCenter = 13.0f,
                    distanceToNextAttraction = "7 km to Kundala Lake",
                    suggestedDurationHours = "2 Hours",
                    description = "Storage concrete gravity dam with speed boat rides surrounded by rolling green hills.",
                    highlight = "Speed boating with wild elephant sightings on lake shores",
                    entryFee = "Boat ride ₹500"
                ),
                Attraction(
                    id = "tea-museum",
                    name = "KDHP Tea Museum",
                    category = "Factory Tour",
                    distanceKmFromCenter = 2.5f,
                    distanceToNextAttraction = "10 km to Attukad Falls",
                    suggestedDurationHours = "1.5 Hours",
                    description = "Century-old tea roller machinery, live tea factory processing, and artisanal tasting sessions.",
                    highlight = "Fresh high-grown green and black tea tea-tasting",
                    entryFee = "₹125 / person"
                ),
                Attraction(
                    id = "attukad-waterfalls",
                    name = "Attukad Waterfalls",
                    category = "Waterfalls",
                    distanceKmFromCenter = 9.0f,
                    distanceToNextAttraction = "8 km to Pothamedu View Point",
                    suggestedDurationHours = "1.5 Hours",
                    description = "Dramatic multi-tier waterfall rolling between steep hills and cardamom jungles.",
                    highlight = "Hanging bridge walk over gushing rapids",
                    entryFee = "Free"
                )
            ),
            stays = listOf(
                Accommodation(
                    id = "tea-county",
                    name = "Tea County Munnar (KTDC)",
                    type = "Resort",
                    pricePerNight = 4500,
                    rating = 4.6f,
                    reviewsCount = 780,
                    distanceFromAttractions = "Located right inside tea valley",
                    amenities = listOf("Ayurvedic Spa", "Tea Garden Walks", "Restaurant", "Wi-Fi"),
                    highlights = "Panoramic plantation views from private wooden balconies"
                ),
                Accommodation(
                    id = "cardamom-homestay",
                    name = "Misty Green Homestay",
                    type = "Homestay",
                    pricePerNight = 2200,
                    rating = 4.7f,
                    reviewsCount = 310,
                    distanceFromAttractions = "4 km from town",
                    amenities = listOf("Kerala Breakfast", "Campfire", "Spice Garden"),
                    highlights = "Warm family hospitality with homemade appam and stew"
                )
            ),
            foodGuide = FoodGuide(
                localSpecialties = listOf(
                    FoodItem(
                        name = "Kerala Appam with Vegetable / Chicken Stew",
                        isVegetarian = true,
                        description = "Soft fluffy fermented rice pancakes with coconut milk mild spiced stew.",
                        popularAt = "Rapsy Restaurant, Munnar town"
                    ),
                    FoodItem(
                        name = "Fresh Cardamom Masala Chai",
                        isVegetarian = true,
                        description = "Locally grown mountain tea infused with fresh green crushed cardamom.",
                        popularAt = "Plantation roadside stalls"
                    ),
                    FoodItem(
                        name = "Karimeen Pollichathu",
                        isVegetarian = false,
                        description = "Pearl spot fish marinated in shallots and red masala, wrapped in banana leaf and pan roasted.",
                        popularAt = "Saravana Bhavan / local Kerala eateries"
                    )
                ),
                restaurants = listOf(
                    RestaurantItem(
                        name = "Rapsy Restaurant",
                        cuisine = "Kerala & Indian",
                        rating = 4.4f,
                        isVegFriendly = true,
                        signatureDish = "Beef Fry / Chicken Biryani & Malabar Parotta",
                        priceForTwo = "₹350",
                        distance = "In Munnar Bazaar"
                    ),
                    RestaurantItem(
                        name = "Saravana Bhavan",
                        cuisine = "Pure Veg South Indian",
                        rating = 4.3f,
                        isVegFriendly = true,
                        signatureDish = "Ghee Roast Dosa & Filter Coffee",
                        priceForTwo = "₹250",
                        distance = "Munnar Main Road"
                    )
                )
            ),
            travelRoute = TravelRouteInfo(
                originDistances = mapOf(
                    "Bengaluru" to 475,
                    "Hyderabad" to 1050,
                    "Chennai" to 580,
                    "Mumbai" to 1420,
                    "Delhi" to 2580,
                    "Visakhapatnam" to 1350,
                    "Kolkata" to 2280,
                    "Pune" to 1300
                ),
                drivingTimes = mapOf(
                    "Bengaluru" to "9h 30m drive",
                    "Hyderabad" to "18h drive",
                    "Chennai" to "11h drive",
                    "Mumbai" to "26h drive",
                    "Delhi" to "42h drive",
                    "Visakhapatnam" to "24h drive",
                    "Kolkata" to "38h drive",
                    "Pune" to "24h drive"
                ),
                roadTripRoute = "Via Salem -> Dindigul -> Theni -> Gap Road Munnar. Breathtaking cliffside driving on newly widened Gap Road.",
                tollAndParkingNotes = "Toll approx ₹400; parking ₹50 at major viewpoints.",
                nearestRailwayStation = "Aluva (110 km) or Ernakulam (125 km)",
                nearestAirport = "Cochin International Airport (COK - 110 km)",
                busTrainFlightOptions = "Fly/Train to Kochi (Cochin), then 3.5 hour scenic cab/KSRTC bus climb through Cheeyappara waterfalls."
            ),
            budget = BudgetBreakdown(
                stayEstimatePerNight = 3200,
                foodEstimatePerDay = 1500,
                activitiesTotal = 1800,
                travelEstimate = 6000,
                totalEstimateMin = 18000,
                totalEstimateMax = 24000
            )
        ),
        Destination(
            id = "goa-beaches",
            name = "Goa",
            state = "Goa",
            tagline = "Sun, Golden Sands & Portuguese Heritage",
            description = "India's premier coastal haven offering vibrant beach shacks, historic forts, UNESCO baroque churches, water sports, and tranquil coconut-fringed backwaters.",
            rating = 4.7f,
            reviewCount = 8900,
            coverResId = R.drawable.goa_beach_sunset,
            categories = listOf(
                TravelCategory.BEACHES,
                TravelCategory.ADVENTURE,
                TravelCategory.HERITAGE,
                TravelCategory.COUPLES,
                TravelCategory.ROAD_TRIPS
            ),
            bestTime = BestTimeInfo(
                bestMonths = "October to March",
                weatherSummary = "Sunny beach days with balmy evening sea breezes",
                peakSeason = "November – February",
                offSeason = "June – September (lush monsoon)",
                expectedCrowd = "High around New Year, moderate in Feb",
                temperatureRange = "20°C – 32°C",
                suggestedDuration = "3–5 Days"
            ),
            attractions = listOf(
                Attraction(
                    id = "fort-aguada",
                    name = "Fort Aguada & Lighthouse",
                    category = "Historic Fortress",
                    distanceKmFromCenter = 15.0f,
                    distanceToNextAttraction = "9 km to Baga Beach",
                    suggestedDurationHours = "2 Hours",
                    description = "17th-century Portuguese fortress standing proudly over Sinquerim beach and Arabian sea.",
                    highlight = "Sunset panoramic view of Arabian sea coast",
                    entryFee = "₹50 / person"
                ),
                Attraction(
                    id = "palolem-beach",
                    name = "Palolem Beach (South Goa)",
                    category = "Serene Beach",
                    distanceKmFromCenter = 60.0f,
                    distanceToNextAttraction = "10 km to Agonda",
                    suggestedDurationHours = "Full Day",
                    description = "Crescent-shaped white sand beach famous for calm waters, kayaking, and dolphin spotting.",
                    highlight = "Sunset kayak to Butterfly Island",
                    entryFee = "Free (Kayaks ₹300/hr)"
                ),
                Attraction(
                    id = "basilica-bom-jesus",
                    name = "Basilica of Bom Jesus (Old Goa)",
                    category = "UNESCO Heritage",
                    distanceKmFromCenter = 10.0f,
                    distanceToNextAttraction = "1 km to Se Cathedral",
                    suggestedDurationHours = "1.5 Hours",
                    description = "Magnificent 400-year-old baroque church holding the sacred relics of St. Francis Xavier.",
                    highlight = "Intricate gilded golden altars",
                    entryFee = "Free"
                ),
                Attraction(
                    id = "dudhsagar-falls",
                    name = "Dudhsagar Waterfalls",
                    category = "Adventure & Waterfall",
                    distanceKmFromCenter = 65.0f,
                    distanceToNextAttraction = "Spice Plantations",
                    suggestedDurationHours = "Half Day",
                    description = "Four-tiered milky white waterfall towering 310m amidst lush Bhagwan Mahavir Sanctuary.",
                    highlight = "Thrilling forest stream jeep crossing",
                    entryFee = "Jeep safari: ₹600/person"
                )
            ),
            stays = listOf(
                Accommodation(
                    id = "beach-caba-resort",
                    name = "Santana Beach Resort",
                    type = "Beach Resort",
                    pricePerNight = 4200,
                    rating = 4.6f,
                    reviewsCount = 1120,
                    distanceFromAttractions = "Direct beach access Candolim",
                    amenities = listOf("Swimming Pool", "Beach Shack", "Bar", "Breakfast"),
                    highlights = "Direct foot access to golden Candolim beach"
                ),
                Accommodation(
                    id = "south-goa-homestay",
                    name = "Casa Da Palm Homestay",
                    type = "Portuguese Villa",
                    pricePerNight = 2500,
                    rating = 4.8f,
                    reviewsCount = 410,
                    distanceFromAttractions = "3 km from Benaulim beach",
                    amenities = listOf("Heritage Garden", "Scooter Rental", "Free Wi-Fi"),
                    highlights = "Restored 120-year-old Portuguese mansion"
                )
            ),
            foodGuide = FoodGuide(
                localSpecialties = listOf(
                    FoodItem(
                        name = "Goan Fish Curry Thali",
                        isVegetarian = false,
                        description = "Fresh Kingfish cooked in coconut milk, kokum and Kashmiri red chillies, served with red rice.",
                        popularAt = "Fisherman's Wharf / Ritz Classic Panaji"
                    ),
                    FoodItem(
                        name = "Bebinca Dessert",
                        isVegetarian = true,
                        description = "Traditional multi-layered Goan Indo-Portuguese pudding made from coconut milk, ghee, and egg yolks.",
                        popularAt = "Confeitaria 31 de Janeiro, Fontainhas"
                    ),
                    FoodItem(
                        name = "Prawn Balchão & Poi Bread",
                        isVegetarian = false,
                        description = "Fiery tangy prawn pickle curry paired with crusty warm local wood-fired poi bread.",
                        popularAt = "Vinayak Family Restaurant, Assagao"
                    )
                ),
                restaurants = listOf(
                    RestaurantItem(
                        name = "Ritz Classic",
                        cuisine = "Authentic Goan Seafood",
                        rating = 4.7f,
                        isVegFriendly = true,
                        signatureDish = "Special Fish Thali & Butter Garlic Crab",
                        priceForTwo = "₹800",
                        distance = "Panaji City Center"
                    ),
                    RestaurantItem(
                        name = "Fisherman's Wharf",
                        cuisine = "Coastal & Continental",
                        rating = 4.6f,
                        isVegFriendly = true,
                        signatureDish = "Goan Prawn Curry & Bebinca",
                        priceForTwo = "₹1400",
                        distance = "Cavelossim (Riverside)"
                    )
                )
            ),
            travelRoute = TravelRouteInfo(
                originDistances = mapOf(
                    "Hyderabad" to 650,
                    "Bengaluru" to 560,
                    "Mumbai" to 590,
                    "Pune" to 450,
                    "Chennai" to 910,
                    "Delhi" to 1890,
                    "Visakhapatnam" to 1250,
                    "Kolkata" to 2150
                ),
                drivingTimes = mapOf(
                    "Hyderabad" to "13h drive",
                    "Bengaluru" to "10h 30m drive",
                    "Mumbai" to "11h drive",
                    "Pune" to "8h 30m drive",
                    "Chennai" to "16h drive",
                    "Delhi" to "30h drive",
                    "Visakhapatnam" to "23h drive",
                    "Kolkata" to "35h drive"
                ),
                roadTripRoute = "From Hyd: NH65 to Raichur -> Bagalkot -> Chorla Ghat / Anmod Ghat into North Goa. Smooth highways with scenic Western Ghat drop.",
                tollAndParkingNotes = "Tolls approx ₹550; beach parking ₹50.",
                nearestRailwayStation = "Madgaon (MAO) or Thivim (THVM)",
                nearestAirport = "Mopa Goa International (GOX) or Dabolim (GOI)",
                busTrainFlightOptions = "Direct flights from all Indian metros; luxury sleeper buses run overnight from Hyderabad, Bangalore, Mumbai and Pune."
            ),
            budget = BudgetBreakdown(
                stayEstimatePerNight = 3500,
                foodEstimatePerDay = 2200,
                activitiesTotal = 3000,
                travelEstimate = 7000,
                totalEstimateMin = 19000,
                totalEstimateMax = 27000
            )
        ),
        Destination(
            id = "coorg-karnataka",
            name = "Coorg (Kodagu)",
            state = "Karnataka",
            tagline = "Scotland of India & Spices Sanctuary",
            description = "Gentle undulating hills rich in spice plantations, aroma of roasted coffee, cascading Abbey Falls, and the brave Kodava heritage.",
            rating = 4.7f,
            reviewCount = 2940,
            coverResId = null,
            categories = listOf(
                TravelCategory.MOUNTAINS,
                TravelCategory.NATURE,
                TravelCategory.FAMILY,
                TravelCategory.COUPLES,
                TravelCategory.ROAD_TRIPS
            ),
            bestTime = BestTimeInfo(
                bestMonths = "October to March",
                weatherSummary = "Refreshing climate with mist drifting over pepper vines",
                peakSeason = "November – February",
                offSeason = "June – August (heavy scenic monsoon)",
                expectedCrowd = "Comfortable",
                temperatureRange = "15°C – 26°C",
                suggestedDuration = "2–3 Days"
            ),
            attractions = listOf(
                Attraction(
                    id = "abbey-falls",
                    name = "Abbey Falls",
                    category = "Waterfall",
                    distanceKmFromCenter = 8.0f,
                    distanceToNextAttraction = "12 km to Raja's Seat",
                    suggestedDurationHours = "1.5 Hours",
                    description = "Stunning waterfall dropping between private coffee plantations and spice bushes.",
                    highlight = "Hanging suspension bridge view",
                    entryFee = "₹15 / person"
                ),
                Attraction(
                    id = "rajas-seat",
                    name = "Raja's Seat Madikeri",
                    category = "Sunset Point & Garden",
                    distanceKmFromCenter = 1.0f,
                    distanceToNextAttraction = "2 km to Madikeri Fort",
                    suggestedDurationHours = "1 Hour",
                    description = "Historical garden where Kodagu kings enjoyed sweeping valley sunsets.",
                    highlight = "Musical fountain and crimson valley twilight",
                    entryFee = "₹20 / person"
                ),
                Attraction(
                    id = "dubare-elephant-camp",
                    name = "Dubare Elephant Camp",
                    category = "Wildlife & River",
                    distanceKmFromCenter = 28.0f,
                    distanceToNextAttraction = "15 km to Golden Temple",
                    suggestedDurationHours = "3 Hours",
                    description = "Interact with elephants, assist in gentle river bathing, and river rafting.",
                    highlight = "Elephant interaction and Kaveri river crossing",
                    entryFee = "₹100 / person"
                ),
                Attraction(
                    id = "bylakuppe-golden-temple",
                    name = "Bylakuppe Namdroling Tibetan Monastery",
                    category = "Spiritual & Heritage",
                    distanceKmFromCenter = 34.0f,
                    distanceToNextAttraction = "On route from Mysore",
                    suggestedDurationHours = "2 Hours",
                    description = "Largest Tibetan settlement in South India with three 40-ft gilded golden Buddha statues.",
                    highlight = "Peaceful bell chants and Tibetan momo cafes",
                    entryFee = "Free"
                )
            ),
            stays = listOf(
                Accommodation(
                    id = "coffee-county-homestay",
                    name = "Kodagu Plantation Retreat",
                    type = "Homestay",
                    pricePerNight = 2400,
                    rating = 4.8f,
                    reviewsCount = 380,
                    distanceFromAttractions = "Inside 50-acre coffee estate",
                    amenities = listOf("Coffee Walk", "Campfire", "Home Food", "Wi-Fi"),
                    highlights = "Experience authentic Kodava family hospitality and estate walks"
                ),
                Accommodation(
                    id = "heritage-resort-coorg",
                    name = "Heritage Resort Coorg",
                    type = "Resort",
                    pricePerNight = 4800,
                    rating = 4.5f,
                    reviewsCount = 610,
                    distanceFromAttractions = "7 km from Madikeri",
                    amenities = listOf("Ayurvedic Spa", "Infinity Pool", "Billiards", "Restaurant"),
                    highlights = "Luxury hill cottages looking into Western Ghats valleys"
                )
            ),
            foodGuide = FoodGuide(
                localSpecialties = listOf(
                    FoodItem(
                        name = "Kadamputtu (Rice Dumplings)",
                        isVegetarian = true,
                        description = "Steamed spherical rice balls coated in cardamom fragrance, served with spicy curry.",
                        popularAt = "Coorg Cuisine, Madikeri"
                    ),
                    FoodItem(
                        name = "Pandi Curry (Kodava Pork Curry)",
                        isVegetarian = false,
                        description = "Signature dish of Coorg slow-cooked in Kachampuli (dark wild vinegar) and roasted spices.",
                        popularAt = "Tiger Tiger Restaurant"
                    ),
                    FoodItem(
                        name = "Bamboo Shoot Curry (Baimbale)",
                        isVegetarian = true,
                        description = "Tender monsoon bamboo shoots cooked with mustard, red chillies and coconut.",
                        popularAt = "Traditional homestays"
                    )
                ),
                restaurants = listOf(
                    RestaurantItem(
                        name = "Coorg Cuisine",
                        cuisine = "Kodava Specialty",
                        rating = 4.6f,
                        isVegFriendly = true,
                        signatureDish = "Pandi Curry & Akki Roti",
                        priceForTwo = "₹550",
                        distance = "Madikeri Town"
                    ),
                    RestaurantItem(
                        name = "Raintree Restaurant",
                        cuisine = "Multi-cuisine Fine Dine",
                        rating = 4.5f,
                        isVegFriendly = true,
                        signatureDish = "Chicken Ghee Roast & Kerala Parotta",
                        priceForTwo = "₹900",
                        distance = "Near Raja's Seat"
                    )
                )
            ),
            travelRoute = TravelRouteInfo(
                originDistances = mapOf(
                    "Bengaluru" to 250,
                    "Mysuru" to 120,
                    "Hyderabad" to 820,
                    "Chennai" to 590,
                    "Mumbai" to 980,
                    "Pune" to 840,
                    "Visakhapatnam" to 1420,
                    "Delhi" to 2400
                ),
                drivingTimes = mapOf(
                    "Bengaluru" to "5h drive via expressway",
                    "Mysuru" to "2h 30m drive",
                    "Hyderabad" to "14h drive",
                    "Chennai" to "11h drive",
                    "Mumbai" to "17h drive",
                    "Pune" to "15h drive",
                    "Visakhapatnam" to "24h drive",
                    "Delhi" to "38h drive"
                ),
                roadTripRoute = "Bengaluru -> Mysuru Expressway -> Hunsur -> Kushalnagar -> Madikeri. Extremely smooth 4-lane driving until the hill ascent.",
                tollAndParkingNotes = "Expressway toll ₹320; site parking ₹30.",
                nearestRailwayStation = "Mysuru Junction (120 km) or Hassan (115 km)",
                nearestAirport = "Kannur Airport (CNN - 90 km) or Bengaluru (BLR - 280 km)",
                busTrainFlightOptions = "KSRTC Airavat Club Class runs multiple daytime and overnight luxury buses from Bengaluru and Mysuru directly to Madikeri."
            ),
            budget = BudgetBreakdown(
                stayEstimatePerNight = 2800,
                foodEstimatePerDay = 1600,
                activitiesTotal = 1200,
                travelEstimate = 3500,
                totalEstimateMin = 12000,
                totalEstimateMax = 17000
            )
        ),
        Destination(
            id = "hampi-karnataka",
            name = "Hampi",
            state = "Karnataka",
            tagline = "Ruins of the Forgotten Vijayanagara Empire",
            description = "A surreal UNESCO World Heritage landscape of giant balancing granite boulders, ruined 14th-century royal palaces, musical pillars, and ancient riverside temples.",
            rating = 4.9f,
            reviewCount = 4120,
            coverResId = null,
            categories = listOf(
                TravelCategory.HERITAGE,
                TravelCategory.TEMPLES,
                TravelCategory.ADVENTURE,
                TravelCategory.ROAD_TRIPS
            ),
            bestTime = BestTimeInfo(
                bestMonths = "October to February",
                weatherSummary = "Crisp sunny winter days with cool boulder-breeze evenings",
                peakSeason = "November – January",
                offSeason = "April – June (high summer heat)",
                expectedCrowd = "Moderate",
                temperatureRange = "16°C – 30°C",
                suggestedDuration = "2–3 Days"
            ),
            attractions = listOf(
                Attraction(
                    id = "virupaksha-temple",
                    name = "Virupaksha Temple",
                    category = "Living Temple",
                    distanceKmFromCenter = 0.5f,
                    distanceToNextAttraction = "2.5 km to Vijaya Vittala",
                    suggestedDurationHours = "2 Hours",
                    description = "Sacred 7th-century active Shiva shrine with a soaring 50m gopuram and Lakshmi the temple elephant.",
                    highlight = "Inverted pinhole camera shadow effect inside inner sanctum",
                    entryFee = "₹25 / person"
                ),
                Attraction(
                    id = "vijaya-vittala",
                    name = "Vijaya Vittala & Stone Chariot",
                    category = "UNESCO Architectural Marvel",
                    distanceKmFromCenter = 3.0f,
                    distanceToNextAttraction = "4 km to Lotus Mahal",
                    suggestedDurationHours = "2.5 Hours",
                    description = "Iconic stone chariot shrine featured on the ₹50 banknote and hall of 56 musical stone pillars.",
                    highlight = "Acoustic musical pillars sounding Indian classical instruments",
                    entryFee = "₹40 / person (covers ASI monuments)"
                ),
                Attraction(
                    id = "matanga-hill",
                    name = "Matanga Hill Sunrise",
                    category = "Trek & Panorama",
                    distanceKmFromCenter = 1.0f,
                    distanceToNextAttraction = "Riverside Coracle point",
                    suggestedDurationHours = "1.5 Hours",
                    description = "Highest point in Hampi offering an awe-inspiring 360-degree panorama of boulder fields and ruins at sunrise.",
                    highlight = "Unforgettable golden hour over Tungabhadra river",
                    entryFee = "Free"
                ),
                Attraction(
                    id = "sanapur-lake",
                    name = "Sanapur Lake & Hippie Island",
                    category = "Adventure & Coracle",
                    distanceKmFromCenter = 14.0f,
                    distanceToNextAttraction = "Anjaneya Hill",
                    suggestedDurationHours = "2 Hours",
                    description = "Tranquil reservoir nestled amidst massive boulders with round traditional wicker coracle boat rides and cliff jumping.",
                    highlight = "Coracle boat spin on mirror-calm waters",
                    entryFee = "Coracle: ₹250/person"
                )
            ),
            stays = listOf(
                Accommodation(
                    id = "heritage-resort-hampi",
                    name = "Heritage Resort Hampi",
                    type = "Resort",
                    pricePerNight = 4500,
                    rating = 4.6f,
                    reviewsCount = 490,
                    distanceFromAttractions = "6 km from Virupaksha",
                    amenities = listOf("Organic Farm", "Pool", "Spa", "Bicycle Rental"),
                    highlights = "Traditional stone-tiled cottages on an organic fruit farm"
                ),
                Accommodation(
                    id = "kstdc-mayura",
                    name = "KSTDC Hotel Mayura Bhuvaneshwari",
                    type = "Heritage Hotel",
                    pricePerNight = 2200,
                    rating = 4.2f,
                    reviewsCount = 580,
                    distanceFromAttractions = "Kamalapur (adjacent to ASI Museum)",
                    amenities = listOf("Restaurant", "Large Parking", "Tour Guides"),
                    highlights = "Closest comfortable stay to the Royal Enclosure"
                )
            ),
            foodGuide = FoodGuide(
                localSpecialties = listOf(
                    FoodItem(
                        name = "North Karnataka Jolada Rotti Oota",
                        isVegetarian = true,
                        description = "Healthy sorghum flatbread served with brinjal curry (Yenne Gai), sprouted pulses, and spicy peanut chutney powder.",
                        popularAt = "Kamalapur Khanawali stalls"
                    ),
                    FoodItem(
                        name = "Wood-fired Thin Crust Pizza",
                        isVegetarian = true,
                        description = "Surprising traveler specialty perfected by Italian expats across the river.",
                        popularAt = "Mango Tree Restaurant"
                    ),
                    FoodItem(
                        name = "Banana Lassi & Herbal Chai",
                        isVegetarian = true,
                        description = "Thick curd whipped with mountain bananas and honey.",
                        popularAt = "Riverside chill-out cafes"
                    )
                ),
                restaurants = listOf(
                    RestaurantItem(
                        name = "Mango Tree Restaurant",
                        cuisine = "Indian & Continental",
                        rating = 4.7f,
                        isVegFriendly = true,
                        signatureDish = "Special Veg Thali & Wood-Fired Pizza",
                        priceForTwo = "₹500",
                        distance = "Near Hampi Bazaar"
                    ),
                    RestaurantItem(
                        name = "Suresh Khanavali",
                        cuisine = "Authentic Kannada Thali",
                        rating = 4.6f,
                        isVegFriendly = true,
                        signatureDish = "Jowar Roti with Stuffed Brinjal Curry",
                        priceForTwo = "₹200",
                        distance = "Kamalapur"
                    )
                )
            ),
            travelRoute = TravelRouteInfo(
                originDistances = mapOf(
                    "Bengaluru" to 340,
                    "Hyderabad" to 370,
                    "Goa" to 320,
                    "Mumbai" to 730,
                    "Pune" to 580,
                    "Chennai" to 680,
                    "Visakhapatnam" to 890,
                    "Delhi" to 1850
                ),
                drivingTimes = mapOf(
                    "Bengaluru" to "6h drive via NH48 & NH50",
                    "Hyderabad" to "7h drive via Mahbubnagar & Raichur",
                    "Goa" to "7h drive via Hubballi",
                    "Mumbai" to "13h drive",
                    "Pune" to "10h drive",
                    "Chennai" to "12h drive",
                    "Visakhapatnam" to "16h drive",
                    "Delhi" to "32h drive"
                ),
                roadTripRoute = "From Hyd: NH44 to Jadcherla -> Raichur -> Sindhanur -> Gangavathi -> Hampi. Great road with scenic rural Deccan scenery.",
                tollAndParkingNotes = "Toll ~₹350; parking ₹40 per monument.",
                nearestRailwayStation = "Hosapete Junction (HPT - 13 km)",
                nearestAirport = "Jindal Vidyanagar Airport (VDY - 35 km) or Hubballi (HBX - 160 km)",
                busTrainFlightOptions = "Hampi Express train runs overnight from Bengaluru; daily KSRTC and private sleeper coaches run from Hyderabad and Bengaluru directly to Hosapete."
            ),
            budget = BudgetBreakdown(
                stayEstimatePerNight = 2200,
                foodEstimatePerDay = 1200,
                activitiesTotal = 1000,
                travelEstimate = 3200,
                totalEstimateMin = 9500,
                totalEstimateMax = 14000
            )
        )
    )

    private val _customDestinations = mutableListOf<Destination>()

    val destinations: List<Destination>
        get() = (baseDestinations +
                 RegionalDestinationsData.allRegionalDestinations +
                 com.example.data.datasource.telangana.TelanganaDestinationsData.allTelanganaDestinations +
                 com.example.data.datasource.karnataka.KarnatakaDestinationsData.allDestinations +
                 com.example.data.datasource.tamilnadu.TamilNaduDestinationsData.allDestinations +
                 com.example.data.datasource.kerala.KeralaDestinationsData.allDestinations +
                 com.example.data.datasource.maharashtra.MaharashtraDestinationsData.destinations +
                 com.example.data.datasource.goa.GoaDestinationsData.destinations +
                 com.example.data.datasource.andhrapradesh.AndhraPradeshDestinationsData.destinations +
                 com.example.data.datasource.rajasthan.RajasthanDestinationsData.destinations +
                 com.example.data.datasource.himachal.HimachalDestinationsData.destinations +
                 _customDestinations).distinctBy { it.id }

    fun addCustomDestination(destination: Destination) {
        _customDestinations.removeAll { it.id == destination.id }
        _customDestinations.add(0, destination)
    }

    fun importCsvDestinations(csvText: String): Int {
        val imported = com.example.data.engine.DataImportEngine.importFromCsv(csvText)
        for (dest in imported) {
            addCustomDestination(dest)
        }
        return imported.size
    }

    fun getDestinationById(id: String): Destination? {
        return destinations.find { it.id == id } ?: destinations.firstOrNull()
    }

    fun getDestinationsByCategory(category: TravelCategory): List<Destination> {
        return destinations.filter { it.categories.contains(category) }
    }

    fun getDestinationsByState(state: String): List<Destination> {
        if (state.isBlank() || state.equals("All", ignoreCase = true)) return destinations
        return destinations.filter { it.state.contains(state, ignoreCase = true) }
    }

    fun getDestinationsByDiscoveryLevel(level: com.example.data.model.DiscoveryLevel): List<Destination> {
        return destinations.filter { it.discoveryLevel == level }
    }

    fun getAllHiddenGems(): List<com.example.data.model.HiddenGem> {
        return destinations.flatMap { it.hiddenGems }
    }

    fun getAvailableStates(): List<String> {
        val statesFromDest = destinations.map { it.state }
        val allMasterStates = com.example.data.model.IndiaStatesMaster.getAllNames()
        val combined = (statesFromDest + allMasterStates).distinct().sorted()
        return listOf("All") + combined
    }

    fun searchDestinations(query: String): List<Destination> {
        if (query.isBlank()) return destinations
        val q = query.trim().lowercase()
        return destinations.filter {
            it.name.lowercase().contains(q) ||
            it.state.lowercase().contains(q) ||
            it.district.lowercase().contains(q) ||
            it.tagline.lowercase().contains(q) ||
            it.attractions.any { a -> a.name.lowercase().contains(q) } ||
            it.categories.any { c -> c.displayName.lowercase().contains(q) } ||
            it.hiddenGems.any { g -> g.name.lowercase().contains(q) }
        }
    }
}
