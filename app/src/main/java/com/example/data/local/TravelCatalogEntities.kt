package com.example.data.local

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.example.data.model.Accommodation
import com.example.data.model.Attraction
import com.example.data.model.Destination
import com.example.data.model.FoodItem
import com.example.data.model.IndiaState
import com.example.data.model.StateType
import com.example.data.model.TravelCategory

/**
 * Helper to generate normalized slug IDs for states.
 * Example: "Andhra Pradesh" -> "andhra-pradesh", "Tamil Nadu" -> "tamil-nadu".
 */
fun normalizeStateSlug(stateName: String): String {
    return stateName.trim().lowercase()
        .replace(Regex("[^a-z0-9]+"), "-")
        .trim('-')
}

/**
 * Foundational Room Entity for Indian States and Union Territories.
 * Models geographic, administrative, and tourism profiles for all 28 States & 8 UTs.
 */
@Entity(
    tableName = "states",
    indices = [
        Index(value = ["name"], unique = true),
        Index(value = ["stateCode"], unique = true),
        Index(value = ["type"])
    ]
)
data class StateEntity(
    @PrimaryKey
    val id: String, // Normalized slug e.g. "andhra-pradesh", "karnataka", "kerala", "tamil-nadu"
    val stateCode: String, // ISO / Regional code e.g. "AP", "KA", "KL", "TN"
    val name: String, // e.g. "Karnataka"
    val type: String = "STATE", // "STATE" or "UNION_TERRITORY"
    val capital: String = "",
    val description: String = "",
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val tourismSummary: String = "",
    val majorRegionsCsv: String = "", // Comma-separated list of major tourist circuits
    val bestTravelMonths: String = "",
    val imageUrl: String = ""
)

/**
 * Foundational Room Entity for Indian Destinations.
 * Stores comprehensive destination attributes including geographical coordinates,
 * state & district administration, seasonal weather profiles, and budgetary estimates.
 * Relates to [StateEntity] via foreign key [stateId].
 */
@Entity(
    tableName = "destinations",
    indices = [
        Index(value = ["stateId"]),
        Index(value = ["state"]),
        Index(value = ["district"]),
        Index(value = ["discoveryLevel"])
    ]
)
data class DestinationEntity(
    @PrimaryKey
    val id: String,
    val stateId: String = "", // Foreign key linking to StateEntity.id
    val name: String,
    val state: String,
    val district: String = "",
    val tagline: String = "",
    val description: String = "",
    val rating: Float = 4.5f,
    val reviewCount: Int = 0,
    val coverImageUrl: String = "",
    val coverResId: Int = 0,
    val categoriesCsv: String = "", // Comma-separated TravelCategory names
    val discoveryLevel: String = "POPULAR", // POPULAR, OFFBEAT, HIDDEN_GEM, SECRET_RETREAT
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val altitudeMeters: Int = 0,
    val bestMonths: String = "",
    val weatherSummary: String = "",
    val peakSeason: String = "",
    val offSeason: String = "",
    val expectedCrowd: String = "Moderate",
    val temperatureRange: String = "",
    val suggestedDuration: String = "2-3 Days",
    val budgetStayPerNight: Int = 2000,
    val budgetFoodPerDay: Int = 1000,
    val budgetMin: Int = 5000,
    val budgetMax: Int = 15000,
    val nearestAirport: String = "",
    val nearestRailway: String = "",
    val nearestHighway: String = "",
    val isCustom: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)

/**
 * Foundational Room Entity for Attractions / Points of Interest.
 * Linked to a Destination via [destinationId].
 */
@Entity(
    tableName = "attractions",
    indices = [
        Index(value = ["destinationId"]),
        Index(value = ["category"])
    ]
)
data class AttractionEntity(
    @PrimaryKey
    val id: String,
    val destinationId: String,
    val name: String,
    val category: String = "Heritage",
    val description: String = "",
    val highlight: String = "",
    val distanceFromDestinationKm: Float = 0f,
    val suggestedDurationHours: String = "2 Hours",
    val entryFeeAdult: String = "Free",
    val entryFeeChild: String = "Free",
    val openingTime: String = "09:00 AM",
    val closingTime: String = "06:00 PM",
    val bestTimeOfDay: String = "Morning / Evening",
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val parkingAvailable: Boolean = true,
    val parkingFee: String = "Check locally",
    val difficultyLevel: String = "Easy",
    val familyFriendly: Boolean = true,
    val childrenFriendly: Boolean = true,
    val seniorCitizenFriendly: Boolean = true,
    val photographyAllowed: Boolean = true,
    val trekDistanceKm: Float = 0f,
    val trekDurationMinutes: Int = 0,
    val safetyNotes: String = "",
    val insiderTip: String = "",
    val imageUrl: String = "",
    val discoveryLevel: String = "POPULAR"
)

/**
 * Foundational Room Entity for Regional Foods & Culinary Specialties.
 * Linked to a Destination via [destinationId].
 */
@Entity(
    tableName = "foods",
    indices = [
        Index(value = ["destinationId"]),
        Index(value = ["cuisine"]),
        Index(value = ["isVegetarian"])
    ]
)
data class FoodEntity(
    @PrimaryKey
    val id: String,
    val destinationId: String,
    val name: String,
    val cuisine: String = "Regional", // e.g. Telangana, Chettinad, Udupi, Malabar, Rajasthani
    val description: String = "",
    val isVegetarian: Boolean = true,
    val spiceLevel: String = "Medium", // Mild, Medium, Spicy
    val priceRange: String = "₹100 - ₹300",
    val popularAt: String = "",
    val whereToTry: String = "Check locally",
    val bestTimeToTry: String = "Lunch / Dinner",
    val imageUrl: String = ""
)

/**
 * Foundational Room Entity for Accommodations / Hotels / Homestays / Resorts.
 * Linked to a Destination via [destinationId].
 */
@Entity(
    tableName = "hotels",
    indices = [
        Index(value = ["destinationId"]),
        Index(value = ["priceCategory"]),
        Index(value = ["rating"])
    ]
)
data class HotelEntity(
    @PrimaryKey
    val id: String,
    val destinationId: String,
    val name: String,
    val category: String = "Hotel", // Heritage Resort, Homestay, Eco Lodge, Boutique, Budget
    val description: String = "",
    val rating: Float = 4.0f,
    val reviewCount: Int = 0,
    val pricePerNight: Int = 2000,
    val priceCategory: String = "Mid-range", // Budget, Mid-range, Luxury
    val distanceFromAttractions: String = "Central",
    val amenitiesCsv: String = "WiFi, Air Conditioning, Parking",
    val contactPhone: String = "",
    val websiteUrl: String = "",
    val bookingUrl: String = "",
    val address: String = "Check locally",
    val isVerified: Boolean = true,
    val imageUrl: String = ""
)

// ----------------------------------------------------------------------------
// Room Relationship Mappings (1-to-Many & Nested Hierarchies)
// ----------------------------------------------------------------------------

/**
 * 1-to-Many: An Indian State with all its registered Destinations.
 */
data class StateWithDestinations(
    @Embedded
    val state: StateEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "stateId"
    )
    val destinations: List<DestinationEntity> = emptyList()
)

/**
 * 1-to-Many: A Destination with its associated Attractions.
 */
data class DestinationWithAttractions(
    @Embedded
    val destination: DestinationEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "destinationId"
    )
    val attractions: List<AttractionEntity> = emptyList()
)

/**
 * 1-to-Many: A Destination with its associated Foods.
 */
data class DestinationWithFoods(
    @Embedded
    val destination: DestinationEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "destinationId"
    )
    val foods: List<FoodEntity> = emptyList()
)

/**
 * 1-to-Many: A Destination with its associated Hotels.
 */
data class DestinationWithHotels(
    @Embedded
    val destination: DestinationEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "destinationId"
    )
    val hotels: List<HotelEntity> = emptyList()
)

/**
 * Aggregate: A Destination with all its sub-entities (Attractions, Foods, Hotels).
 */
data class DestinationWithDetails(
    @Embedded
    val destination: DestinationEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "destinationId"
    )
    val attractions: List<AttractionEntity> = emptyList(),

    @Relation(
        parentColumn = "id",
        entityColumn = "destinationId"
    )
    val foods: List<FoodEntity> = emptyList(),

    @Relation(
        parentColumn = "id",
        entityColumn = "destinationId"
    )
    val hotels: List<HotelEntity> = emptyList()
)

/**
 * Complete Hierarchical Aggregate:
 * A State with all its Destinations, each with their nested Attractions, Foods, and Hotels.
 */
data class StateWithCompleteDetails(
    @Embedded
    val state: StateEntity,

    @Relation(
        entity = DestinationEntity::class,
        parentColumn = "id",
        entityColumn = "stateId"
    )
    val destinationsWithDetails: List<DestinationWithDetails> = emptyList()
)

// ----------------------------------------------------------------------------
// Conversion Extensions between Domain Models and Room Entities
// ----------------------------------------------------------------------------

fun IndiaState.toEntity(): StateEntity {
    return StateEntity(
        id = this.id,
        stateCode = this.stateCode,
        name = this.name,
        type = this.type.name,
        capital = this.capital,
        description = this.description,
        latitude = this.latitude,
        longitude = this.longitude,
        tourismSummary = this.tourismSummary,
        majorRegionsCsv = this.majorRegions.joinToString(","),
        bestTravelMonths = this.bestTravelMonths,
        imageUrl = this.imageUrl
    )
}

fun StateEntity.toDomain(): IndiaState {
    return IndiaState(
        id = this.id,
        stateCode = this.stateCode,
        name = this.name,
        type = try { StateType.valueOf(this.type) } catch (e: Exception) { StateType.STATE },
        capital = this.capital,
        description = this.description,
        latitude = this.latitude,
        longitude = this.longitude,
        tourismSummary = this.tourismSummary,
        majorRegions = this.majorRegionsCsv.split(",").map { it.trim() }.filter { it.isNotEmpty() },
        bestTravelMonths = this.bestTravelMonths,
        imageUrl = this.imageUrl
    )
}

fun Destination.toEntity(): DestinationEntity {
    val stateSlug = normalizeStateSlug(this.state)
    return DestinationEntity(
        id = this.id,
        stateId = stateSlug,
        name = this.name,
        state = this.state,
        district = this.district,
        tagline = this.tagline,
        description = this.description,
        rating = this.rating,
        reviewCount = this.reviewCount,
        coverImageUrl = this.heroImage,
        coverResId = this.coverResId ?: 0,
        categoriesCsv = this.categories.joinToString(",") { it.name },
        discoveryLevel = this.discoveryLevel.name,
        latitude = this.latitude,
        longitude = this.longitude,
        altitudeMeters = this.altitude.filter { it.isDigit() }.toIntOrNull() ?: 0,
        bestMonths = this.bestTime.bestMonths,
        weatherSummary = this.bestTime.weatherSummary,
        peakSeason = this.bestTime.peakSeason,
        offSeason = this.bestTime.offSeason,
        expectedCrowd = this.bestTime.expectedCrowd,
        temperatureRange = this.bestTime.temperatureRange,
        suggestedDuration = this.bestTime.suggestedDuration,
        budgetStayPerNight = this.budget.stayEstimatePerNight,
        budgetFoodPerDay = this.budget.foodEstimatePerDay,
        budgetMin = this.budget.totalEstimateMin,
        budgetMax = this.budget.totalEstimateMax,
        nearestAirport = this.travelRoute.nearestAirport,
        nearestRailway = this.travelRoute.nearestRailwayStation,
        nearestHighway = this.travelRoute.roadTripRoute,
        isCustom = false
    )
}

fun Attraction.toEntity(destinationId: String): AttractionEntity {
    return AttractionEntity(
        id = this.id,
        destinationId = destinationId,
        name = this.name,
        category = this.category,
        description = this.description,
        highlight = this.highlight,
        distanceFromDestinationKm = this.distanceFromDestinationKm,
        suggestedDurationHours = this.suggestedDurationHours,
        entryFeeAdult = this.entryFeeAdult,
        entryFeeChild = this.entryFeeChild,
        openingTime = this.openingTime,
        closingTime = this.closingTime,
        bestTimeOfDay = this.bestTimeOfDay,
        latitude = this.latitude,
        longitude = this.longitude,
        parkingAvailable = this.parkingAvailable,
        parkingFee = this.parkingFee,
        difficultyLevel = this.difficultyLevel,
        familyFriendly = this.familyFriendly,
        childrenFriendly = this.childrenFriendly,
        seniorCitizenFriendly = this.seniorCitizenFriendly,
        photographyAllowed = this.photographyAllowed,
        trekDistanceKm = this.trekDistanceKm,
        trekDurationMinutes = this.trekDurationMinutes,
        safetyNotes = this.safetyNotes,
        insiderTip = this.insiderTip,
        imageUrl = this.imageUrl,
        discoveryLevel = this.discoveryLevel.name
    )
}

fun FoodItem.toEntity(destinationId: String, id: String = "${destinationId}_food_${this.name.lowercase().replace(" ", "_")}"): FoodEntity {
    return FoodEntity(
        id = id,
        destinationId = destinationId,
        name = this.name,
        cuisine = "Regional",
        description = this.description,
        isVegetarian = this.isVegetarian,
        priceRange = this.priceRange,
        popularAt = this.popularAt,
        whereToTry = this.whereToTry
    )
}

fun Accommodation.toEntity(destinationId: String): HotelEntity {
    return HotelEntity(
        id = this.id,
        destinationId = destinationId,
        name = this.name,
        category = this.category,
        description = this.highlights,
        rating = this.rating,
        reviewCount = this.reviewsCount,
        pricePerNight = this.pricePerNight,
        priceCategory = this.categoryType,
        distanceFromAttractions = this.distanceFromAttractions,
        amenitiesCsv = this.amenities.joinToString(","),
        contactPhone = this.contactPhone,
        websiteUrl = this.websiteUrl,
        bookingUrl = this.bookingUrl ?: "",
        address = "Check locally",
        isVerified = true,
        imageUrl = ""
    )
}

