package com.example.data.repository

import android.content.Context
import com.example.core.operation
import com.example.data.datasource.DestinationsDataSource
import com.example.data.model.Destination
import com.example.data.model.PlaceCatalogEntry
import java.util.Locale
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class PlaceCatalogRepository(context: Context) {
    private val assets = context.applicationContext.assets

    suspend fun load(): Result<List<PlaceCatalogEntry>> = operation {
        withContext(Dispatchers.IO) {
            val entries = assets.open("places_catalog.json").bufferedReader().use {
                Json.decodeFromString<List<PlaceCatalogEntry>>(it.readText())
            }
            val extra = assets.open("additional_places.json").bufferedReader().use {
                Json.decodeFromString<List<PlaceCatalogEntry>>(it.readText())
            }
            val allEntries = entries + extra
            require(allEntries.map { it.id }.distinct().size == allEntries.size) { "Duplicate catalog IDs" }
            allEntries.forEach {
                require(it.id.isNotBlank() && it.name.isNotBlank() && it.categories.isNotEmpty()) { "Incomplete catalog entry" }
                require((it.latitude == null) == (it.longitude == null)) { "Incomplete coordinates" }
                require(it.latitude == null || it.latitude in -90.0..90.0) { "Invalid latitude" }
                require(it.longitude == null || it.longitude in -180.0..180.0) { "Invalid longitude" }
            }
            allEntries.map { entry ->
                val guide = existingGuide(entry) ?: return@map entry
                entry.copy(
                    state = entry.state ?: guide.state,
                    bestTimeToVisit = entry.bestTimeToVisit ?: guide.bestTime.bestMonths,
                    nearestAirport = entry.nearestAirport ?: guide.travelRoute.nearestAirport,
                    nearestRailwayStation = entry.nearestRailwayStation ?: guide.travelRoute.nearestRailwayStation,
                    topAttractions = entry.topAttractions.ifEmpty { guide.attractions.map { it.name } },
                    popularHotels = entry.popularHotels.ifEmpty { guide.stays.map {
                        com.example.data.model.HotelInfo(it.name, it.category, guide.name)
                    } },
                    popularFoodSpots = entry.popularFoodSpots.ifEmpty { guide.foodGuide.localSpecialties.map {
                        com.example.data.model.FoodInfo(it.name, it.popularAt.ifBlank { "Ask locally" })
                    } }
                )
            }
        }
    }

    fun existingGuide(entry: PlaceCatalogEntry): Destination? {
        val names = (entry.aliases + entry.name).map(::normalized).toSet()
        val matches = DestinationsDataSource.destinations.filter {
            listOf(it.name, it.name.substringBefore("("), it.name.substringAfter("(", "").substringBefore(")"), it.id)
                .filter { name -> name.isNotBlank() }.any { name -> normalized(name) in names }
        }
        return matches.singleOrNull()
    }

    private fun normalized(value: String): String = com.example.data.engine.PlaceSearch.normalized(value)
}
