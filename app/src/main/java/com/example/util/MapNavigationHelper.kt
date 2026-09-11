package com.example.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

object MapNavigationHelper {

    /**
     * Launches turn-by-turn navigation to target coordinates using Google Maps or default map app.
     * URI: google.navigation:q=lat,lng
     * Fallback: geo:lat,lng?q=lat,lng(label)
     * Web fallback: https://www.google.com/maps/dir/?api=1&destination=lat,lng
     */
    fun startNavigation(
        context: Context,
        latitude: Double,
        longitude: Double,
        label: String
    ) {
        if (latitude == 0.0 && longitude == 0.0) {
            openSearchOnMap(context, label)
            return
        }

        val navUri = Uri.parse("google.navigation:q=$latitude,$longitude")
        val navIntent = Intent(Intent.ACTION_VIEW, navUri).apply {
            setPackage("com.google.android.apps.maps")
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        try {
            if (navIntent.resolveActivity(context.packageManager) != null) {
                context.startActivity(navIntent)
                return
            }
        } catch (e: Exception) {
            // Continue to fallback
        }

        // General geo intent fallback
        val geoUri = Uri.parse("geo:$latitude,$longitude?q=$latitude,$longitude(${Uri.encode(label)})")
        val geoIntent = Intent(Intent.ACTION_VIEW, geoUri).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        try {
            if (geoIntent.resolveActivity(context.packageManager) != null) {
                context.startActivity(geoIntent)
                return
            }
        } catch (e: Exception) {
            // Continue to web fallback
        }

        // Web Maps URL fallback
        val webUri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=$latitude,$longitude")
        val webIntent = Intent(Intent.ACTION_VIEW, webUri).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        try {
            context.startActivity(webIntent)
        } catch (e: Exception) {
            Toast.makeText(context, "No map application or browser available", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Opens Route view from Origin to Destination (optionally with waypoints) in Google Maps
     */
    fun openRoute(
        context: Context,
        originName: String?,
        originLat: Double? = null,
        originLng: Double? = null,
        destLat: Double,
        destLng: Double,
        destName: String,
        waypoints: List<Pair<Double, Double>> = emptyList()
    ) {
        val baseUrl = StringBuilder("https://www.google.com/maps/dir/?api=1")
        if (originLat != null && originLng != null && originLat != 0.0) {
            baseUrl.append("&origin=$originLat,$originLng")
        } else if (!originName.isNullOrBlank()) {
            baseUrl.append("&origin=${Uri.encode(originName)}")
        }

        if (destLat != 0.0 && destLng != 0.0) {
            baseUrl.append("&destination=$destLat,$destLng")
        } else {
            baseUrl.append("&destination=${Uri.encode(destName)}")
        }

        if (waypoints.isNotEmpty()) {
            val wpString = waypoints.joinToString("|") { "${it.first},${it.second}" }
            baseUrl.append("&waypoints=${Uri.encode(wpString)}")
        }

        baseUrl.append("&travelmode=driving")

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(baseUrl.toString())).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        try {
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Could not open route navigation", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Opens a query search on Maps
     */
    fun openSearchOnMap(context: Context, query: String) {
        val uri = Uri.parse("geo:0,0?q=${Uri.encode(query)}")
        val intent = Intent(Intent.ACTION_VIEW, uri).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        try {
            context.startActivity(intent)
        } catch (e: Exception) {
            val webUri = Uri.parse("https://www.google.com/maps/search/?api=1&query=${Uri.encode(query)}")
            val webIntent = Intent(Intent.ACTION_VIEW, webUri).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            try {
                context.startActivity(webIntent)
            } catch (ex: Exception) {
                Toast.makeText(context, "Cannot open map search", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
