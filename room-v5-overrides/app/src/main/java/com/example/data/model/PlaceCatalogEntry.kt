package com.example.data.model

import kotlinx.serialization.Serializable

@Serializable
data class HotelInfo(val name: String, val priceTier: String, val location: String)

@Serializable
data class FoodInfo(val dishOrCuisine: String, val recommendedSpot: String)

@Serializable
data class PlaceCatalogEntry(
    val id: String,
    val name: String,
    val aliases: List<String> = emptyList(),
    val categories: List<String>,
    val state: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val bestTimeToVisit: String? = null,
    val nearestAirport: String? = null,
    val nearestRailwayStation: String? = null,
    val popularHotels: List<HotelInfo> = emptyList(),
    val popularFoodSpots: List<FoodInfo> = emptyList(),
    val topAttractions: List<String> = emptyList(),
    val description: String? = null,
    val sourceUrl: String? = null
)
