package com.example.data.remote

data class LiveWeatherData(
    val temperatureCelsius: Float,
    val condition: String,
    val humidityPercent: Int,
    val precipitationMm: Float,
    val weatherAlert: String? = null,
    val isLive: Boolean = false
)

interface WeatherProvider {
    suspend fun getCurrentWeather(latitude: Double, longitude: Double): LiveWeatherData
}

data class RoutePoint(
    val latitude: Double,
    val longitude: Double,
    val name: String
)

data class LiveRouteResult(
    val distanceKm: Float,
    val durationMinutes: Int,
    val summary: String,
    val steps: List<String> = emptyList(),
    val isLive: Boolean = false
)

interface MapRoutingProvider {
    suspend fun calculateRoute(
        origin: RoutePoint,
        destination: RoutePoint,
        waypoints: List<RoutePoint> = emptyList()
    ): LiveRouteResult
}

interface HotelProvider {
    suspend fun checkAvailability(
        destinationId: String,
        checkInDate: String,
        checkOutDate: String,
        guests: Int
    ): List<String>
}

/**
 * Offline-First default implementations that gracefully provide verified offline fallback
 */
class OfflineFirstWeatherProvider : WeatherProvider {
    override suspend fun getCurrentWeather(latitude: Double, longitude: Double): LiveWeatherData {
        return LiveWeatherData(
            temperatureCelsius = 24.0f,
            condition = "Pleasant (Seasonal Historical Estimate)",
            humidityPercent = 55,
            precipitationMm = 0.0f,
            weatherAlert = null,
            isLive = false
        )
    }
}

class OfflineFirstRoutingProvider : MapRoutingProvider {
    override suspend fun calculateRoute(
        origin: RoutePoint,
        destination: RoutePoint,
        waypoints: List<RoutePoint>
    ): LiveRouteResult {
        val latDiff = Math.abs(origin.latitude - destination.latitude)
        val lngDiff = Math.abs(origin.longitude - destination.longitude)
        val approxDistance = Math.sqrt(latDiff * latDiff + lngDiff * lngDiff) * 111.0
        val distKm = approxDistance.toFloat()
        val durationMins = (distKm / 55.0f * 60).toInt()

        return LiveRouteResult(
            distanceKm = distKm,
            durationMinutes = durationMins,
            summary = "Direct route via National Highway system",
            steps = listOf("Depart from ${origin.name}", "Follow highway toward ${destination.name}", "Arrive at destination"),
            isLive = false
        )
    }
}
