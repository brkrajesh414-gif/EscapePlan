package com.example.data.model

import java.util.UUID

enum class TravelCategory(val displayName: String, val icon: String) {
    MOUNTAINS("Mountains", "🏔️"),
    BEACHES("Beaches", "🏖️"),
    NATURE("Nature", "🌳"),
    HERITAGE("Heritage", "🏛️"),
    TEMPLES("Temples", "🛕"),
    ADVENTURE("Adventure", "🏕️"),
    FAMILY("Family", "👨‍👩‍👧"),
    COUPLES("Couples", "💑"),
    ROAD_TRIPS("Road Trips", "🚗"),
    WILDLIFE("Wildlife", "🐅"),
    FOOD("Food", "🍲"),
    SPIRITUAL("Spiritual", "🕉️"),
    WATERFALLS("Waterfalls", "🌊"),
    LAKES("Lakes", "🛶"),
    WEEKEND_GETAWAYS("Weekend Getaways", "🧳");

    companion object {
        val FAMILY_FRIENDLY: TravelCategory get() = FAMILY
    }
}

enum class DiscoveryLevel(val displayName: String, val badge: String) {
    ICONIC("Iconic", "👑"),
    POPULAR("Popular", "⭐"),
    MODERATE("Moderate", "✨"),
    OFFBEAT("Offbeat", "🌿"),
    HIDDEN_GEM("Hidden Gem", "💎"),
    LOCAL_SECRET("Local Secret", "🗝️")
}

enum class VerificationLevel(val displayName: String) {
    OFFICIAL("Official"),
    GOVERNMENT("Government"),
    TRUSTED("Trusted"),
    COMMUNITY("Community"),
    UNVERIFIED("Unverified")
}

data class HiddenGem(
    val id: String,
    val destinationId: String = "",
    val name: String,
    val description: String,
    val whyItIsSpecial: String,
    val category: String, // Hidden Waterfall, Secret Viewpoint, Lesser-Known Temple, Offbeat Village, Unknown Beach, Forest Trail, Cave, Small Lake, etc.
    val location: String = "",
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val bestMonths: String = "Monsoon to Winter",
    val crowdLevel: String = "Low", // Low, Moderate
    val difficulty: String = "Moderate", // Easy, Moderate, Strenuous
    val accessibility: String = "Trek Required",
    val recommendedDuration: String = "3-4 Hours",
    val entryFee: String = "Free / Nominal",
    val parking: String = "Available",
    val safetyNotes: String = "",
    val localTips: String = "",
    val nearbyPlaces: List<String> = emptyList(),
    val imageUrl: String = "",
    val source: String = "State Tourism / Local Forest Department",
    val sourceUrl: String = "",
    val lastVerifiedDate: String = "2024-2025",
    val verificationLevel: VerificationLevel = VerificationLevel.TRUSTED
)

data class LocalExperience(
    val id: String = UUID.randomUUID().toString(),
    val destinationId: String = "",
    val name: String,
    val description: String,
    val duration: String = "2 Hours",
    val approximateCost: String = "₹200 - ₹500",
    val bestMonths: String = "All Year",
    val familyFriendly: Boolean = true,
    val bookingRequired: Boolean = false,
    val source: String = "Local community"
)

data class ScenicRoute(
    val id: String = UUID.randomUUID().toString(),
    val origin: String,
    val destination: String,
    val routeName: String,
    val distanceKm: Int,
    val estimatedTime: String,
    val scenicRating: Float = 4.8f,
    val attractionsAlongRoute: List<String> = emptyList(),
    val viewpoints: List<String> = emptyList(),
    val waterfalls: List<String> = emptyList(),
    val restaurants: List<String> = emptyList(),
    val fuelStops: List<String> = emptyList(),
    val parking: String = "Available at viewpoints",
    val roadCondition: String = "Scenic winding ghat road",
    val recommendedVehicle: String = "Car / SUV / Bike",
    val bestSeason: String = "Monsoon / Winter",
    val notes: String = ""
)

data class MonthlyWeather(
    val month: String,
    val avgTempCelsius: String,
    val rainfall: String,
    val crowdLevel: String, // Low, Moderate, High, Peak
    val bestActivities: String
)

data class SeasonInfo(
    val destinationId: String = "",
    val month: String,
    val minimumTemperature: String,
    val maximumTemperature: String,
    val rainfall: String,
    val crowdLevel: String, // "Low", "Moderate", "High", "Very High"
    val hotelPriceLevel: String = "Moderate", // "Budget", "Moderate", "Peak"
    val travelCondition: String = "Good", // "Excellent", "Good", "Moderate", "Avoid if possible"
    val bestActivities: List<String> = emptyList(),
    val recommendation: String = "Recommended"
)

data class BestTimeInfo(
    val bestMonths: String,
    val weatherSummary: String,
    val peakSeason: String,
    val offSeason: String,
    val expectedCrowd: String,
    val temperatureRange: String,
    val suggestedDuration: String,
    val monthlyBreakdown: List<MonthlyWeather> = emptyList()
)

data class Attraction(
    val id: String,
    val destinationId: String = "",
    val name: String,
    val description: String,
    val category: String,
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val openingTime: String = "09:00 AM",
    val closingTime: String = "05:30 PM",
    val entryFeeAdult: String = "Check locally",
    val entryFeeChild: String = "Check locally",
    val recommendedDurationMinutes: Int = 90,
    val distanceFromDestinationKm: Float = 0f,
    val parkingAvailable: Boolean = true,
    val parkingFee: String = "Check locally",
    val difficultyLevel: String = "Easy",
    val familyFriendly: Boolean = true,
    val childrenFriendly: Boolean = true,
    val seniorCitizenFriendly: Boolean = true,
    val photographyAllowed: Boolean = true,
    val bestTimeOfDay: String = "Morning / Evening",
    val tips: String = "",
    val imageUrl: String = "",
    // Compatibility fields with existing views:
    val distanceKmFromCenter: Float = distanceFromDestinationKm,
    val distanceToNextAttraction: String = "",
    val suggestedDurationHours: String = "${recommendedDurationMinutes / 60.0} Hours",
    val highlight: String = "",
    val entryFee: String = entryFeeAdult,
    val insiderTip: String = tips,
    val photographyAdvice: String = if (photographyAllowed) "Photography allowed" else "Photography restricted",
    val familySuitability: String = if (familyFriendly) "Family friendly" else "Check suitability",
    val seniorAccessibility: String = if (seniorCitizenFriendly) "Senior friendly" else "Difficult terrain",
    val nearbySpots: List<String> = emptyList(),
    val discoveryLevel: DiscoveryLevel = DiscoveryLevel.POPULAR,
    val trekDistanceKm: Float = 0f,
    val trekDurationMinutes: Int = 0,
    val swimmingAllowed: Boolean = false,
    val campingAllowed: Boolean = false,
    val safetyNotes: String = "",
    val verificationLevel: VerificationLevel = VerificationLevel.TRUSTED
)

data class Accommodation(
    val id: String,
    val destinationId: String = "",
    val name: String,
    val category: String = "Standard", // Budget, Standard, Premium, Luxury, Resort, Homestay, Eco Stay, Government Tourism, Forest Stay
    val minimumPrice: Int = 0,
    val maximumPrice: Int = 0,
    val rating: Float = 4.0f,
    val reviewCount: Int = 0,
    val amenities: List<String> = emptyList(),
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val distanceFromDestinationKm: Float = 0f,
    val distanceFromMajorAttractionsKm: Float = 0f,
    val phone: String? = null,
    val website: String? = null,
    val bookingUrl: String? = null,
    val approximatePrice: String = "Approximate — verify before travel",
    val lastVerifiedDate: String = "2024-2025",
    // Compatibility fields:
    val type: String = category,
    val pricePerNight: Int = if (minimumPrice > 0) minimumPrice else 1500,
    val reviewsCount: Int = reviewCount,
    val distanceFromAttractions: String = "$distanceFromMajorAttractionsKm km",
    val highlights: String = category,
    val contactPhone: String = phone ?: "",
    val websiteUrl: String = website ?: "",
    val categoryType: String = category
)

data class FoodSpecialty(
    val id: String,
    val destinationId: String = "",
    val name: String,
    val description: String,
    val vegOrNonVeg: String = "Veg", // "Veg", "Non-Veg"
    val cuisine: String = "Telangana",
    val spiceLevel: String = "Medium", // "Mild", "Medium", "Spicy"
    val priceRange: String = "₹100 - ₹300",
    val bestTimeToTry: String = "Lunch / Dinner",
    val whereToTry: String = "Check locally",
    val imageUrl: String = ""
)

data class FoodItem(
    val name: String,
    val isVegetarian: Boolean,
    val description: String,
    val popularAt: String,
    val priceRange: String = "₹150 - ₹350",
    val whereToTry: String = ""
)

data class Restaurant(
    val id: String,
    val destinationId: String = "",
    val name: String,
    val cuisine: String,
    val rating: Float = 4.0f,
    val priceRange: String = "₹₹",
    val vegetarianAvailable: Boolean = true,
    val nonVegetarianAvailable: Boolean = true,
    val signatureDishes: List<String> = emptyList(),
    val address: String = "Check locally",
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val phone: String? = null,
    val website: String? = null,
    val distanceFromDestinationKm: Float = 0f
)

data class RestaurantItem(
    val name: String,
    val cuisine: String,
    val rating: Float,
    val isVegFriendly: Boolean,
    val signatureDish: String,
    val priceForTwo: String,
    val distance: String
)

data class FoodGuide(
    val localSpecialties: List<FoodItem> = emptyList(),
    val restaurants: List<RestaurantItem> = emptyList()
)

data class TravelRoute(
    val id: String,
    val origin: String,
    val destinationId: String,
    val distanceKm: Int,
    val estimatedDrivingTime: String,
    val fuelEstimate: Int,
    val tollEstimate: Int,
    val parkingEstimate: Int = 100,
    val roadCondition: String = "Good",
    val recommendedDepartureTime: String = "06:00 AM",
    val recommendedStops: List<String> = emptyList(),
    val notes: String = ""
)

data class TravelRouteInfo(
    val originDistances: Map<String, Int>, // City -> km
    val drivingTimes: Map<String, String>, // City -> "12h 30m"
    val roadTripRoute: String,
    val tollAndParkingNotes: String = "Toll approx ₹150-₹400; parking available at base and scenic viewpoints",
    val nearestRailwayStation: String,
    val nearestAirport: String,
    val busTrainFlightOptions: String = "Regular State Transport (MSRTC/KSRTC/APSRTC) and private overnight sleepers available",
    val fuelEstimateCar: Map<String, Int> = emptyMap(),
    val tollEstimate: Map<String, Int> = emptyMap(),
    val roadCondition: String = "Smooth 4-lane highway with scenic hill approaches"
)

data class BudgetTier(
    val tierName: String, // "Budget", "Mid-Range", "Luxury"
    val soloCost: Int,
    val coupleCost: Int,
    val familyCost: Int,
    val friendsCost: Int
)

data class DestinationBudget(
    val destinationId: String,
    val travelStyle: String, // "Budget", "Mid Range", "Premium"
    val travellerType: String, // "Solo", "Couple", "Family", "Friends"
    val accommodationPerNight: Int,
    val foodPerDay: Int,
    val activities: Int,
    val localTransport: Int,
    val fuel: Int,
    val toll: Int,
    val parking: Int,
    val estimatedTotalPerPerson: Int,
    val notes: String = ""
)

data class BudgetBreakdown(
    val stayEstimatePerNight: Int,
    val foodEstimatePerDay: Int,
    val activitiesTotal: Int,
    val travelEstimate: Int,
    val totalEstimateMin: Int,
    val totalEstimateMax: Int,
    val tiers: List<BudgetTier> = emptyList()
)

data class ItineraryActivity(
    val time: String,
    val activity: String,
    val attractionId: String? = null,
    val durationMinutes: Int = 60,
    val estimatedCost: Int = 0,
    val notes: String = ""
)

data class DayStop(
    val timeOfDay: String, // Morning, Afternoon, Evening
    val title: String,
    val placeOrActivity: String,
    val duration: String,
    val foodSuggestion: String? = null,
    val tip: String? = null
)

data class ItineraryDay(
    val id: String = UUID.randomUUID().toString(),
    val itineraryId: String = "",
    val dayNumber: Int,
    val dayTitle: String = "",
    val title: String = dayTitle,
    val routeHighlight: String = "",
    val stops: List<DayStop> = emptyList(),
    val activities: List<ItineraryActivity> = emptyList()
)

data class ItineraryTemplate(
    val id: String,
    val destinationId: String,
    val durationDays: Int,
    val title: String,
    val description: String,
    val travelStyle: String = "Mid-Range",
    val travellerType: String = "Couple",
    val estimatedCost: Int = 0,
    val days: List<ItineraryDay> = emptyList()
)

data class Destination(
    val id: String,
    val name: String,
    val state: String,
    val district: String = "",
    val mandal: String = "",
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val tagline: String = "",
    val description: String = "",
    val shortDescription: String = tagline,
    val fullDescription: String = description,
    val bestDurationMinDays: Int = 1,
    val bestDurationMaxDays: Int = 3,
    val altitude: String = "Check locally",
    val destinationTypes: List<String> = emptyList(),
    val bestMonths: String = "",
    val recommendedFor: List<String> = emptyList(),
    val heroImage: String = "",
    val status: String = "Active",
    val rating: Float = 4.5f,
    val reviewCount: Int = 1000,
    val coverResId: Int? = null,
    val categories: List<TravelCategory> = emptyList(),
    val bestTime: BestTimeInfo = BestTimeInfo(
        bestMonths = if (bestMonths.isNotBlank()) bestMonths else "October to March",
        weatherSummary = "Pleasant winter weather",
        peakSeason = "November – February",
        offSeason = "April – June",
        expectedCrowd = "Moderate",
        temperatureRange = "18°C – 32°C",
        suggestedDuration = "$bestDurationMinDays–$bestDurationMaxDays Days"
    ),
    val attractions: List<Attraction> = emptyList(),
    val stays: List<Accommodation> = emptyList(),
    val foodGuide: FoodGuide = FoodGuide(),
    val travelRoute: TravelRouteInfo = TravelRouteInfo(
        originDistances = mapOf("Hyderabad" to 150),
        drivingTimes = mapOf("Hyderabad" to "3 Hours"),
        roadTripRoute = "Direct highway route",
        tollAndParkingNotes = "Standard toll and parking apply",
        nearestRailwayStation = "Local Railway Station",
        nearestAirport = "Rajiv Gandhi International Airport, Hyderabad (HYD)",
        busTrainFlightOptions = "Regular TSRTC bus services available"
    ),
    val budget: BudgetBreakdown = BudgetBreakdown(
        stayEstimatePerNight = 2000,
        foodEstimatePerDay = 1000,
        activitiesTotal = 800,
        travelEstimate = 2000,
        totalEstimateMin = 5800,
        totalEstimateMax = 12000
    ),
    val timedScheduleTemplate: List<DayStop> = emptyList(),
    val seasons: List<SeasonInfo> = emptyList(),
    val foodSpecialties: List<FoodSpecialty> = emptyList(),
    val restaurantsList: List<Restaurant> = emptyList(),
    val travelRoutesList: List<TravelRoute> = emptyList(),
    val budgetPlans: List<DestinationBudget> = emptyList(),
    val itineraryTemplates: List<ItineraryTemplate> = emptyList(),
    val stateCode: String = "",
    val subDistrict: String = "",
    val taluk: String = "",
    val village: String = "",
    val discoveryLevel: DiscoveryLevel = DiscoveryLevel.POPULAR,
    val hiddenGems: List<HiddenGem> = emptyList(),
    val localExperiences: List<LocalExperience> = emptyList(),
    val scenicRoutes: List<ScenicRoute> = emptyList(),
    val safetyNotes: String = "",
    val verificationLevel: VerificationLevel = VerificationLevel.TRUSTED,
    val contentVersion: Int = 1
)

data class DestinationMatch(
    val destination: Destination,
    val matchPercentage: Int,
    val matchingReasons: List<String>,
    val distanceFromOriginKm: Int,
    val estimatedTripCost: Int,
    val score: Int = matchPercentage
)

data class TravelRequest(
    val origin: String = "Hyderabad",
    val budget: Int = 20000,
    val durationDays: Int = 3,
    val travellerType: String = "Couple", // Solo, Couple, Family, Friends
    val transportMode: String = "Car", // Car, Bike, Train, Bus, Flight
    val experiences: List<String> = emptyList(),
    val foodPreference: String = "Any",
    val pace: String = "Balanced", // Relaxed, Balanced, Fast-paced
    val weatherPreference: String = "Pleasant",
    val accommodationPreference: String = "Mid-Range"
)

data class ParsedTravelQuery(
    val originCity: String,
    val budget: Int,
    val durationDays: Int,
    val partyType: String, // "Solo", "Couple", "Family", "Friends"
    val preferredVibes: List<String>,
    val candidateMatches: List<DestinationMatch>,
    val travelRequest: TravelRequest = TravelRequest(
        origin = originCity,
        budget = budget,
        durationDays = durationDays,
        travellerType = partyType,
        experiences = preferredVibes
    )
)

data class GeneratedItinerary(
    val id: String,
    val title: String,
    val destinationName: String,
    val originCity: String,
    val durationDays: Int,
    val tripType: String,
    val transportMode: String,
    val estimatedBudget: Int,
    val stayCost: Int,
    val foodCost: Int,
    val activitiesCost: Int,
    val travelCost: Int,
    val summary: String,
    val days: List<ItineraryDay>,
    val packingAndTravelTips: List<String>,
    val createdTimestamp: Long = System.currentTimeMillis()
)
