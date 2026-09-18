package com.example.ui.screens

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.ui.components.ErrorBanner
import com.example.ui.components.LoadingShimmer
import com.example.ui.viewmodel.UserProfileViewModel
import kotlinx.serialization.json.Json

private val preferenceOptions = linkedMapOf(
    "Budget" to listOf("Budget", "Comfort", "Premium"),
    "Transport" to listOf("Flexible", "Public transport", "Car", "Bike", "Flight"),
    "Travel" to listOf("Flexible", "Solo", "Couple", "Family", "Friends", "Adventure"),
    "Food" to listOf("No preference", "Vegetarian", "Non-vegetarian", "Vegan", "Local cuisine")
)

@Composable
fun UserProfileScreen(
    onLocation: () -> Unit,
    onExplore: () -> Unit,
    model: UserProfileViewModel = viewModel()
) {
    val state by model.state.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val configured = com.google.firebase.FirebaseApp.getApps(context).isNotEmpty()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var selectionKey by remember { mutableStateOf<String?>(null) }
    var information by remember { mutableStateOf<String?>(null) }
    var notifications by rememberSaveable { mutableStateOf(true) }
    val storedPreferences = remember(state.profile?.updatedAt, state.user?.uid) {
        runCatching { Json.decodeFromString<List<String>>(state.profile?.preferencesJson ?: "[]") }.getOrDefault(emptyList())
    }
    var settings by remember(state.profile?.updatedAt, state.user?.uid) { mutableStateOf(profileSettings(storedPreferences)) }
    val displayName = state.profile?.name?.takeIf { it.isNotBlank() } ?: state.user?.name.orEmpty().ifBlank { "Traveller" }

    if (state.loading && state.user == null) { LoadingShimmer(); return }
    if (state.user == null) {
        Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(24.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            Text("Welcome to EscapePlan", fontSize = 34.sp, lineHeight = 40.sp, fontWeight = FontWeight.SemiBold)
            Text("Sign in to sync your profile and generate AI trips. Offline exploration remains available.", color = MaterialTheme.colorScheme.onSurfaceVariant)
            OutlinedButton(onClick = onExplore, modifier = Modifier.fillMaxWidth()) { Text("Continue as guest") }
            if (!configured) {
                Text("Sign-in is not available in this build yet. You can explore destination guides and create offline plans without an account.")
                return@Column
            }
            state.error?.let { ErrorBanner(it, model::refresh) }
            state.message?.let { Text(it) }
            OutlinedTextField(email, { email = it }, label = { Text("Email") }, singleLine = true, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(password, { password = it }, label = { Text("Password") }, singleLine = true, visualTransformation = PasswordVisualTransformation(), modifier = Modifier.fillMaxWidth())
            Button(enabled = !state.loading, onClick = { model.email(email.trim(), password, false) }, modifier = Modifier.fillMaxWidth()) { Text("Sign in") }
            OutlinedButton(enabled = !state.loading, onClick = { model.email(email.trim(), password, true) }, modifier = Modifier.fillMaxWidth()) { Text("Create account") }
            OutlinedButton(enabled = !state.loading && context is Activity && com.example.BuildConfig.GOOGLE_WEB_CLIENT_ID.isNotBlank(), onClick = { (context as? Activity)?.let(model::google) }, modifier = Modifier.fillMaxWidth()) { Text("Continue with Google") }
            TextButton(onClick = { model.resetPassword(email) }) { Text("Reset password") }
        }
        return
    }

    fun select(key: String, value: String) {
        val updated = settings + (key to value)
        settings = updated
        model.save(displayName, updated.map { (field, choice) -> "$field:$choice" }.toSet())
    }

    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 24.dp, vertical = 18.dp)) {
        state.error?.let { ErrorBanner(it, model::refresh) }
        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
                val avatar = state.user?.avatarUrl.orEmpty()
                if (avatar.isNotBlank()) AsyncImage(avatar, "Profile avatar", Modifier.size(86.dp).clip(CircleShape))
                else Surface(shape = CircleShape, color = MaterialTheme.colorScheme.primaryContainer, modifier = Modifier.size(86.dp)) {
                    Box(contentAlignment = Alignment.Center) { Text(displayName.take(1).uppercase(), fontSize = 34.sp, lineHeight = 40.sp, fontWeight = FontWeight.SemiBold) }
                }
                Text(displayName, fontSize = 29.sp, fontWeight = FontWeight.SemiBold)
                Text(state.user?.email.orEmpty(), color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
        SectionTitle("TRAVEL PREFERENCES")
        ProfileMenuRow(Icons.Default.AttachMoney, "Typical budget", settings.getValue("Budget")) { selectionKey = "Budget" }
        ProfileMenuRow(Icons.Default.LocalShipping, "Preferred transport", settings.getValue("Transport")) { selectionKey = "Transport" }
        ProfileMenuRow(Icons.Default.Groups, "Travel type", settings.getValue("Travel")) { selectionKey = "Travel" }
        ProfileMenuRow(Icons.Default.Restaurant, "Food preference", settings.getValue("Food")) { selectionKey = "Food" }
        SectionTitle("SETTINGS")
        ProfileMenuRow(Icons.Default.NotificationsNone, "Notifications", if (notifications) "On" else "Off", trailing = {
            Switch(checked = notifications, onCheckedChange = { notifications = it })
        }) { notifications = !notifications }
        ProfileMenuRow(Icons.Default.LocationOn, "Location", "Maps and nearby places", onClick = onLocation)
        ProfileMenuRow(Icons.Default.Security, "Privacy", "Data and account security") {
            information = "Firebase authentication protects your account. Profiles and trips are scoped to the signed-in user. App backup is disabled to protect encrypted local session data."
        }
        ProfileMenuRow(Icons.Default.HelpOutline, "Help & Support", "Setup and travel-data guidance") {
            information = "Search Explore by place, state or interest. Use the offline planner without an account. Check current opening hours and availability before booking."
        }
        if (state.profile?.pendingSync == true) Text("Saved on this device. Profile sync will retry when online.", color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.padding(vertical = 8.dp))
        OutlinedButton(onClick = model::signOut, modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp), shape = RoundedCornerShape(28.dp)) {
            Icon(Icons.AutoMirrored.Filled.Logout, null)
            Text("  Sign out", fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(vertical = 6.dp))
        }
    }

    selectionKey?.let { key ->
        SelectionDialog(key, preferenceOptions.getValue(key), settings.getValue(key), onDismiss = { selectionKey = null }) { value ->
            select(key, value)
            selectionKey = null
        }
    }
    information?.let { message ->
        AlertDialog(onDismissRequest = { information = null }, title = { Text("EscapePlan") }, text = { Text(message) }, confirmButton = {
            TextButton(onClick = { information = null }) { Text("OK") }
        })
    }
}

private fun profileSettings(values: List<String>): Map<String, String> {
    val keyed = values.mapNotNull { value -> value.substringBefore(":").takeIf { ':' in value }?.let { it to value.substringAfter(":") } }.toMap()
    val legacyTravel = values.firstOrNull { it in listOf("Solo", "Adventure", "Family") }
    return mapOf(
        "Budget" to (keyed["Budget"] ?: if ("Budget" in values) "Budget" else "Comfort"),
        "Transport" to (keyed["Transport"] ?: "Flexible"),
        "Travel" to (keyed["Travel"] ?: legacyTravel ?: "Flexible"),
        "Food" to (keyed["Food"] ?: "No preference")
    )
}

@Composable
private fun SectionTitle(value: String) {
    Text(value, letterSpacing = 1.2.sp, color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.padding(top = 28.dp, bottom = 8.dp))
}

@Composable
private fun ProfileMenuRow(
    icon: ImageVector,
    title: String,
    subtitle: String,
    trailing: (@Composable () -> Unit)? = null,
    onClick: () -> Unit
) {
    Row(Modifier.fillMaxWidth().clickable(onClick = onClick).padding(vertical = 4.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, null, modifier = Modifier.size(27.dp), tint = MaterialTheme.colorScheme.onSurfaceVariant)
        Column(Modifier.weight(1f).padding(horizontal = 18.dp, vertical = 14.dp)) {
            Text(title, fontSize = 18.sp)
            Text(subtitle, fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        if (trailing != null) trailing() else TextButton(onClick = onClick) { Icon(Icons.Default.ChevronRight, title) }
    }
    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
}

@Composable
private fun SelectionDialog(title: String, options: List<String>, selected: String, onDismiss: () -> Unit, onSelect: (String) -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title) },
        text = {
            Column {
                options.forEach { option ->
                    Row(Modifier.fillMaxWidth().padding(vertical = 4.dp), verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = option == selected, onClick = { onSelect(option) })
                        Text(option)
                    }
                }
            }
        },
        confirmButton = { TextButton(onClick = onDismiss) { Text("Cancel") } }
    )
}
