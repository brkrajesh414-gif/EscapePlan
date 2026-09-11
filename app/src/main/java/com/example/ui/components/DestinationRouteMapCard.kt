package com.example.ui.components

import android.content.Context
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.LocalGasStation
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.LocalParking
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Terrain
import androidx.compose.material.icons.filled.Thunderstorm
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Destination
import com.example.data.model.DiscoveryLevel
import com.example.util.MapNavigationHelper

@Composable
fun DestinationRouteMapCard(
    destination: Destination,
    originCity: String = "Hyderabad",
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val route = destination.travelRoute
    val distanceKm = route.originDistances[originCity]
        ?: if (destination.name.contains("Devkund", ignoreCase = true)) 170 else 250
    val driveTime = route.drivingTimes[originCity]
        ?: if (destination.name.contains("Devkund", ignoreCase = true)) "~4 hrs*" else "~5 hrs*"
    val fuelEstimate = route.fuelEstimateCar[originCity]
        ?: if (destination.name.contains("Devkund", ignoreCase = true)) 1500 else (distanceKm * 9)
    val parkingStatus = if (destination.attractions.any { it.parkingAvailable } || destination.name.contains("Devkund", ignoreCase = true)) {
        "Available*"
    } else {
        "Limited"
    }

    val subtitle = buildString {
        append(destination.discoveryLevel.displayName)
        if (destination.categories.isNotEmpty()) {
            append(" • ")
            append(destination.categories.first().displayName)
        } else if (destination.destinationTypes.isNotEmpty()) {
            append(" • ")
            append(destination.destinationTypes.first())
        }
    }

    val isDevkund = destination.id.contains("devkund", ignoreCase = true) || destination.name.contains("Devkund", ignoreCase = true)
    val durationText = if (isDevkund) "3–4 hrs" else destination.bestTime.suggestedDuration
    val trekText = if (isDevkund || destination.attractions.any { it.trekDistanceKm > 0 }) "Required" else "Easy Walk"
    val bestSeasonText = if (isDevkund) "Monsoon" else destination.bestTime.peakSeason.take(15)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("destination_route_map_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        border = CardDefaults.outlinedCardBorder()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {

            // HEADER: 📍 DEVKUND | Hidden Gem • Waterfall
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f))
                    .padding(vertical = 14.dp, horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = destination.name.uppercase(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        letterSpacing = 1.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = subtitle,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            // MAP PREVIEW CANVAS
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .background(Color(0xFF0F172A))
                    .clickable {
                        MapNavigationHelper.openRoute(
                            context = context,
                            originName = originCity,
                            destLat = destination.latitude,
                            destLng = destination.longitude,
                            destName = destination.name
                        )
                    }
                    .testTag("map_preview_box")
            ) {
                // Render stylized visual topography / route path
                val primaryColor = MaterialTheme.colorScheme.primary
                val secondaryColor = MaterialTheme.colorScheme.tertiary
                Canvas(modifier = Modifier.fillMaxSize()) {
                    val w = size.width
                    val h = size.height

                    // Background grid/contour lines
                    val contourColor = Color.White.copy(alpha = 0.07f)
                    for (i in 1..4) {
                        drawLine(
                            color = contourColor,
                            start = Offset(0f, h * i / 5),
                            end = Offset(w, h * i / 5),
                            strokeWidth = 1f
                        )
                    }
                    for (i in 1..6) {
                        drawLine(
                            color = contourColor,
                            start = Offset(w * i / 7, 0f),
                            end = Offset(w * i / 7, h),
                            strokeWidth = 1f
                        )
                    }

                    // S-curved highway route line
                    val p1 = Offset(w * 0.15f, h * 0.75f)
                    val p2 = Offset(w * 0.45f, h * 0.40f)
                    val p3 = Offset(w * 0.82f, h * 0.30f)

                    val dashEffect = PathEffect.dashPathEffect(floatArrayOf(12f, 8f), 0f)
                    drawLine(
                        color = Color(0xFF38BDF8),
                        start = p1,
                        end = p2,
                        strokeWidth = 4f,
                        pathEffect = dashEffect
                    )
                    drawLine(
                        color = Color(0xFF38BDF8),
                        start = p2,
                        end = p3,
                        strokeWidth = 4f,
                        pathEffect = dashEffect
                    )

                    // Origin node
                    drawCircle(color = Color.White, radius = 6f, center = p1)
                    drawCircle(color = Color(0xFF0284C7), radius = 4f, center = p1)

                    // Waypoint node
                    drawCircle(color = Color.White, radius = 5f, center = p2)
                    drawCircle(color = Color(0xFFF59E0B), radius = 3.5f, center = p2)

                    // Destination node (pulsing pin)
                    drawCircle(color = Color(0xFFEF4444).copy(alpha = 0.3f), radius = 14f, center = p3)
                    drawCircle(color = Color.White, radius = 7f, center = p3)
                    drawCircle(color = Color(0xFFEF4444), radius = 5f, center = p3)
                }

                // Overlay labels
                Surface(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(8.dp),
                    shape = RoundedCornerShape(20.dp),
                    color = Color.Black.copy(alpha = 0.75f),
                    contentColor = Color.White
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Map,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = Color(0xFF38BDF8)
                        )
                        Text(
                            text = "MAP PREVIEW • TAP TO EXPLORE",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.8.sp
                        )
                    }
                }

                Text(
                    text = originCity.uppercase(),
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 16.dp, bottom = 10.dp)
                )

                Text(
                    text = destination.name.uppercase(),
                    color = Color(0xFFFCA5A5),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 16.dp, top = 10.dp)
                )
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            // METRICS GRID: Distance, Drive, Fuel, Parking
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    MetricItem(
                        icon = "📍",
                        label = "Distance",
                        value = "$distanceKm km",
                        modifier = Modifier.weight(1f)
                    )
                    MetricItem(
                        icon = "🚗",
                        label = "Drive",
                        value = driveTime,
                        modifier = Modifier.weight(1f)
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    MetricItem(
                        icon = "⛽",
                        label = "Fuel",
                        value = "₹${fuelEstimate}*",
                        modifier = Modifier.weight(1f)
                    )
                    MetricItem(
                        icon = "🅿️",
                        label = "Parking",
                        value = parkingStatus,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            // ACTION BUTTONS: [ 🗺 Open Route ] [ 🚗 Start Navigation ]
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OutlinedButton(
                    onClick = {
                        MapNavigationHelper.openRoute(
                            context = context,
                            originName = originCity,
                            destLat = destination.latitude,
                            destLng = destination.longitude,
                            destName = destination.name
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                        .testTag("btn_open_route"),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Map,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Open Route",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 13.sp
                    )
                }

                Button(
                    onClick = {
                        MapNavigationHelper.startNavigation(
                            context = context,
                            latitude = destination.latitude,
                            longitude = destination.longitude,
                            label = destination.name
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                        .testTag("btn_start_navigation"),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Navigation,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Start Navigation",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 13.sp
                    )
                }
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            // HIGHLIGHT BADGES: Hidden Gem, Best Season, Trek Required, Duration
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BadgeTag(emoji = "⭐", label = destination.discoveryLevel.displayName)
                BadgeTag(emoji = "🌧", label = "Best: $bestSeasonText")
                BadgeTag(emoji = "🥾", label = "Trek: $trekText")
                BadgeTag(emoji = "⏱", label = durationText)
            }

            // MULTI-STOP ROUTE CONNECTOR (Origin -> Destination -> Viewpoint -> Food -> Hotel -> Return)
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            MultiStopRouteFlow(destination = destination, originCity = originCity)
        }
    }
}

@Composable
private fun MetricItem(
    icon: String,
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = icon, fontSize = 14.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "$label: ",
            fontSize = 13.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
private fun BadgeTag(emoji: String, label: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(text = emoji, fontSize = 12.sp)
        Text(
            text = label,
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun MultiStopRouteFlow(
    destination: Destination,
    originCity: String,
    modifier: Modifier = Modifier
) {
    val isDevkund = destination.id.contains("devkund", ignoreCase = true) || destination.name.contains("Devkund", ignoreCase = true)

    val stops = if (isDevkund) {
        listOf(
            "HYDERABAD" to "Origin city departure via highway",
            "DEVKUND" to "Main emerald plunge waterfall trek",
            "NEARBY VIEWPOINT" to "Tamhini Ghat & Plus Valley panoramic overlook",
            "LOCAL FOOD" to "Bhira village authentic Pithla Bhakri meal",
            "HOTEL" to "Tamhini forest eco-resort / Bhira homestay",
            "HYDERABAD" to "Return journey"
        )
    } else {
        val viewpointName = destination.attractions.firstOrNull { it.category.contains("View", ignoreCase = true) }?.name
            ?: destination.attractions.firstOrNull()?.name ?: "Scenic Viewpoint"
        val foodName = destination.foodGuide.restaurants.firstOrNull()?.name ?: "Local Traditional Food"
        val hotelName = destination.stays.firstOrNull()?.name ?: "Verified Destination Stay"

        listOf(
            originCity.uppercase() to "Departure from city",
            destination.name.uppercase() to "Primary destination center",
            viewpointName.uppercase() to "Signature scenic viewpoint",
            foodName.uppercase() to "Authentic regional culinary stop",
            hotelName.uppercase() to "Recommended overnight stay",
            originCity.uppercase() to "Return journey"
        )
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(14.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "📍 FULL ROAD-TRIP ROUTE SEQUENCE",
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            letterSpacing = 0.8.sp,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(10.dp))

        stops.forEachIndexed { index, (stopName, desc) ->
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = if (index == 0 || index == stops.size - 1) {
                    MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                } else if (index == 1) {
                    MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f)
                } else {
                    MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
                },
                modifier = Modifier.fillMaxWidth(0.9f)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stopName,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = desc,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )
                }
            }

            if (index < stops.size - 1) {
                Text(
                    text = "↓",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(vertical = 2.dp)
                )
            }
        }
    }
}
