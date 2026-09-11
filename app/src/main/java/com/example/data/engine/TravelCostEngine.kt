package com.example.data.engine

import com.example.data.model.Destination
import kotlin.math.roundToInt

object TravelCostEngine {

    /**
     * Calculates estimated fuel cost using the exact formula:
     * fuelCost = (distance × 2 ÷ mileage) × fuelPrice
     */
    fun calculateFuelCost(
        distanceKm: Int,
        fuelPricePerLitre: Double = 106.0,
        mileageKmpl: Double = 14.5
    ): Int {
        val totalDistanceKm = distanceKm * 2.0 // Round trip
        val litresNeeded = totalDistanceKm / mileageKmpl
        return (litresNeeded * fuelPricePerLitre).roundToInt()
    }

    /**
     * Estimates highway toll charges based on one-way distance
     */
    fun calculateTollCost(distanceKm: Int): Int {
        // Average NHAI toll in South India is approximately ₹1.4 - ₹1.8 per km
        val oneWayToll = (distanceKm * 1.5).roundToInt()
        return oneWayToll * 2 // Round trip
    }

    /**
     * Comprehensive Transport Cost Engine supporting Bike, Car, Train, Bus, and Flight
     */
    fun calculateTransportCost(
        distanceKm: Int,
        transportMode: String = "Car",
        travellers: Int = 2,
        fuelPrice: Double = 106.0,
        mileageOverride: Double? = null,
        tollOverride: Int? = null,
        parkingEstimate: Int = 100
    ): Int {
        return when (transportMode.lowercase().trim()) {
            "bike", "motorcycle" -> {
                val bikeMileage = mileageOverride ?: 38.0
                val fuel = calculateFuelCost(distanceKm, fuelPrice, bikeMileage)
                // Bikes are exempt from standard NHAI highway tolls in India
                val bikeParking = 40
                fuel + bikeParking
            }
            "car", "self-drive", "road trip", "taxi" -> {
                val carMileage = mileageOverride ?: 14.5
                val fuel = calculateFuelCost(distanceKm, fuelPrice, carMileage)
                val toll = tollOverride ?: calculateTollCost(distanceKm)
                fuel + toll + parkingEstimate
            }
            "train" -> {
                // Average round trip ticket per person based on distance (Sleeper/3AC)
                val oneWayFare = (distanceKm * 1.4).roundToInt().coerceIn(180, 1800)
                val roundTripFare = oneWayFare * 2
                (roundTripFare * travellers) + (parkingEstimate / 2)
            }
            "bus" -> {
                // TSRTC Super Luxury / Rajadhani / Garuda round trip fare per person
                val oneWayFare = (distanceKm * 1.6).roundToInt().coerceIn(150, 1600)
                val roundTripFare = oneWayFare * 2
                (roundTripFare * travellers) + 50
            }
            "flight" -> {
                // Domestic flight round trip estimate per person
                val flightRoundTrip = if (distanceKm < 300) 4500 else 6800
                flightRoundTrip * travellers
            }
            else -> {
                val carMileage = mileageOverride ?: 14.5
                val fuel = calculateFuelCost(distanceKm, fuelPrice, carMileage)
                val toll = tollOverride ?: calculateTollCost(distanceKm)
                fuel + toll + parkingEstimate
            }
        }
    }

    /**
     * Calculates accommodation cost based on destination, nights, party size, and tier
     */
    fun calculateStayCost(
        destination: Destination,
        nights: Int,
        tier: String = "Mid-Range",
        partyType: String = "Couple"
    ): Int {
        val roomsMultiplier = when (partyType.lowercase()) {
            "solo" -> 1
            "couple" -> 1
            "family" -> 1 // 1 suite/family room or 2 rooms
            "friends" -> 2 // Quad sharing 2 rooms
            else -> 1
        }

        val basePricePerNight = when (tier.lowercase()) {
            "budget" -> (destination.budget.stayEstimatePerNight * 0.65).roundToInt().coerceAtLeast(800)
            "luxury", "premium" -> (destination.budget.stayEstimatePerNight * 1.8).roundToInt()
            else -> destination.budget.stayEstimatePerNight
        }

        return maxOf(1, nights) * basePricePerNight * roomsMultiplier
    }

    /**
     * Calculates daily food expenditure
     */
    fun calculateFoodCost(
        destination: Destination,
        days: Int,
        partyType: String = "Couple",
        tier: String = "Mid-Range"
    ): Int {
        val personCount = when (partyType.lowercase()) {
            "solo" -> 1
            "couple" -> 2
            "family" -> 3 // 2 adults + child average
            "friends" -> 4
            else -> 2
        }

        val baseFoodPerPersonPerDay = when (tier.lowercase()) {
            "budget" -> 350
            "luxury", "premium" -> 1200
            else -> maxOf(400, destination.budget.foodEstimatePerDay / 2)
        }

        return days * personCount * baseFoodPerPersonPerDay
    }

    /**
     * Calculates activities, permits, guide fees, and entry tickets
     */
    fun calculateActivitiesCost(
        destination: Destination,
        days: Int,
        partyType: String = "Couple"
    ): Int {
        val personCount = when (partyType.lowercase()) {
            "solo" -> 1
            "couple" -> 2
            "family" -> 3
            "friends" -> 4
            else -> 2
        }
        val perPersonActivities = maxOf(250, destination.budget.activitiesTotal / 2)
        return (perPersonActivities * personCount * (days / 2.0).coerceAtLeast(1.0)).roundToInt()
    }

    /**
     * Generates a comprehensive cost breakdown for a proposed trip
     */
    fun estimateCompleteTrip(
        destination: Destination,
        originCity: String,
        days: Int,
        partyType: String = "Couple",
        tier: String = "Mid-Range",
        transportMode: String = "Car",
        travellerCountOverride: Int? = null
    ): Map<String, Int> {
        val nights = maxOf(1, days - 1)
        val distanceKm = destination.travelRoute.originDistances[originCity] ?: 250

        val travellers = travellerCountOverride ?: when (partyType.lowercase()) {
            "solo" -> 1
            "couple" -> 2
            "family" -> 3
            "friends" -> 4
            else -> 2
        }

        val travelCost = calculateTransportCost(
            distanceKm = distanceKm,
            transportMode = transportMode,
            travellers = travellers
        )

        val stayCost = calculateStayCost(destination, nights, tier, partyType)
        val foodCost = calculateFoodCost(destination, days, partyType, tier)
        val activitiesCost = calculateActivitiesCost(destination, days, partyType)

        val total = travelCost + stayCost + foodCost + activitiesCost

        return mapOf(
            "travel" to travelCost,
            "stay" to stayCost,
            "food" to foodCost,
            "activities" to activitiesCost,
            "total" to total
        )
    }
}
