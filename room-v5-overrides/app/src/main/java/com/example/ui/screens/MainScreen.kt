package com.example.ui.screens

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import androidx.navigation.toRoute
import com.example.data.datasource.DestinationsDataSource
import com.example.ui.components.EmptyStateView
import com.example.ui.components.PaywallBottomSheet
import com.example.ui.viewmodel.AiPlannerViewModel
import com.example.ui.viewmodel.BillingViewModel
import com.example.ui.viewmodel.ExploreViewModel
import com.example.ui.viewmodel.SavedTripsViewModel
import kotlinx.serialization.Serializable

@Serializable data object HomeRoute
@Serializable data object ExploreRoute
@Serializable data object PlaceCatalogRoute
@Serializable data class HiddenPlaceRoute(val id: String)
@Serializable data class PlannerRoute(val prompt: String = "")
@Serializable data object MapRoute
@Serializable data object SavedRoute
@Serializable data object LegacySavedRoute
@Serializable data object ProfileRoute
@Serializable data object OfflinePlannerRoute
@Serializable data class DestinationRoute(val destinationId: String)
@Serializable data class TripRoute(val tripId: String)

private data class BottomItem(val route: Any, val label: String, val icon: ImageVector, val tag: String, val central: Boolean = false)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    exploreViewModel: ExploreViewModel = viewModel(),
    aiPlannerViewModel: AiPlannerViewModel = viewModel(),
    savedTripsViewModel: SavedTripsViewModel = viewModel(),
    billing: BillingViewModel = viewModel()
) {
    val nav = rememberNavController()
    val entry by nav.currentBackStackEntryAsState()
    val explore by exploreViewModel.uiState.collectAsStateWithLifecycle()
    val entitlement by billing.state.collectAsStateWithLifecycle()
    val legacyTrips by savedTripsViewModel.savedTrips.collectAsStateWithLifecycle()
    var showPaywall by remember { mutableStateOf(false) }
    val items = remember {
        listOf(
            BottomItem(HomeRoute, "Home", Icons.Default.Home, "nav_home"),
            BottomItem(ExploreRoute, "Explore", Icons.Default.Explore, "nav_explore"),
            BottomItem(PlannerRoute(), "Plan", Icons.Default.Bolt, "nav_ai_planner", central = true),
            BottomItem(SavedRoute, "Saved", Icons.Outlined.FavoriteBorder, "nav_my_trips"),
            BottomItem(ProfileRoute, "Me", Icons.Default.Person, "nav_profile")
        )
    }
    val rootRoute = entry?.destination?.let { destination ->
        destination.hasRoute<HomeRoute>() || destination.hasRoute<ExploreRoute>() || destination.hasRoute<PlannerRoute>() ||
            destination.hasRoute<SavedRoute>() || destination.hasRoute<ProfileRoute>()
    } == true
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            if (!rootRoute) TopAppBar(
                title = { Text("EscapePlan") },
                navigationIcon = {
                    if (nav.previousBackStackEntry != null) IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                },
                actions = {
                    TextButton(onClick = { showPaywall = true; billing.repository.refresh() }) {
                        Text(if (entitlement.premium) "Premium" else "Upgrade")
                    }
                }
            )
        },
        bottomBar = {
            if (rootRoute) NavigationBar(containerColor = MaterialTheme.colorScheme.surface, tonalElevation = 4.dp) {
                items.forEach { item ->
                    val selected = when (item.route) {
                        HomeRoute -> entry?.destination?.hasRoute<HomeRoute>() == true
                        ExploreRoute -> entry?.destination?.hasRoute<ExploreRoute>() == true
                        SavedRoute -> entry?.destination?.hasRoute<SavedRoute>() == true
                        ProfileRoute -> entry?.destination?.hasRoute<ProfileRoute>() == true
                        else -> entry?.destination?.hasRoute<PlannerRoute>() == true
                    }
                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            nav.navigate(item.route) {
                                popUpTo(nav.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            if (item.central) Surface(
                                shape = CircleShape,
                                color = MaterialTheme.colorScheme.primary,
                                contentColor = Color.White,
                                modifier = Modifier.size(58.dp).offset(y = (-8).dp)
                            ) { Box(contentAlignment = Alignment.Center) { Icon(item.icon, item.label, Modifier.size(30.dp)) } }
                            else Icon(item.icon, item.label)
                        },
                        label = { if (!item.central) Text(item.label) },
                        modifier = Modifier.testTag(item.tag)
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = nav,
            startDestination = HomeRoute,
            modifier = Modifier.fillMaxSize().padding(padding),
            enterTransition = { slideInHorizontally { it / 4 } + fadeIn() },
            exitTransition = { fadeOut() },
            popEnterTransition = { fadeIn() },
            popExitTransition = { slideOutHorizontally { it / 4 } + fadeOut() }
        ) {
            composable<HomeRoute> {
                HomeScreen(
                    onPlace = { nav.navigate(HiddenPlaceRoute(it)) },
                    onMap = { nav.navigate(MapRoute) },
                    onCategories = { nav.navigate(PlaceCatalogRoute) }
                )
            }
            composable<ExploreRoute> {
                UnifiedExploreScreen(
                    onDestination = { nav.navigate(DestinationRoute(it)) },
                    onHidden = { nav.navigate(HiddenPlaceRoute(it)) },
                    onPlan = { nav.navigate(PlannerRoute(it)) },
                    budgetContent = { ExploreScreen(exploreViewModel, onDestinationClick = { nav.navigate(DestinationRoute(it.id)) }) }
                )
            }
            composable<PlaceCatalogRoute> {
                PlaceCatalogScreen(onOpenGuide = { nav.navigate(DestinationRoute(it)) }, onPlan = { nav.navigate(PlannerRoute(it)) })
            }
            composable<HiddenPlaceRoute> { backStack ->
                HiddenPlaceDetailScreen(backStack.toRoute<HiddenPlaceRoute>().id) { nav.navigate(PlannerRoute(it)) }
            }
            composable<PlannerRoute> { backStack ->
                val context = androidx.compose.ui.platform.LocalContext.current
                if (com.google.firebase.FirebaseApp.getApps(context).isEmpty()) {
                    androidx.compose.runtime.LaunchedEffect(backStack) {
                        val prompt = backStack.toRoute<PlannerRoute>().prompt
                        if (prompt.isNotBlank()) { aiPlannerViewModel.setFreeformPrompt(prompt); aiPlannerViewModel.setActiveTab(1) }
                    }
                    AiPlannerScreen(aiPlannerViewModel, onViewDestinationDetails = { nav.navigate(DestinationRoute(it)) })
                } else ItineraryPlannerScreen(
                    initialPrompt = backStack.toRoute<PlannerRoute>().prompt,
                    onLegacyPlanner = { nav.navigate(OfflinePlannerRoute) },
                    canExport = entitlement::canExport,
                    onPremium = { showPaywall = true },
                    onTripOpened = billing.repository::refresh
                )
            }
            composable<TripRoute>(deepLinks = listOf(navDeepLink { uriPattern = "escapeplan://trip/{tripId}" })) { backStack ->
                val id = backStack.toRoute<TripRoute>().tripId
                if (Regex("[a-fA-F0-9-]{36}").matches(id)) ItineraryPlannerScreen(
                    tripId = id,
                    onLegacyPlanner = { nav.navigate(OfflinePlannerRoute) },
                    canExport = entitlement::canExport,
                    onPremium = { showPaywall = true },
                    onTripOpened = billing.repository::refresh
                ) else EmptyStateView("Invalid trip link", "Open a saved trip from the planner.")
            }
            composable<OfflinePlannerRoute> {
                AiPlannerScreen(aiPlannerViewModel, onViewDestinationDetails = { nav.navigate(DestinationRoute(it)) })
            }
            composable<MapRoute> {
                DestinationSearchScreen(
                    onAddToTrip = { nav.navigate(PlannerRoute(it)) },
                    premiumPins = entitlement.premium,
                    onPremium = { showPaywall = true }
                )
            }
            composable<ProfileRoute> { UserProfileScreen(onLocation = { nav.navigate(MapRoute) }, onExplore = { nav.navigate(ExploreRoute) }) }
            composable<SavedRoute> {
                MyTripsScreen(
                    onPlan = { nav.navigate(PlannerRoute()) },
                    onOpen = { nav.navigate(TripRoute(it)) },
                    hasLegacyTrips = legacyTrips.isNotEmpty(),
                    onLegacyTrips = { nav.navigate(LegacySavedRoute) }
                )
            }
            composable<LegacySavedRoute> {
                SavedTripsScreen(savedTripsViewModel, onDestinationClick = { nav.navigate(DestinationRoute(it.id)) })
            }
            composable<DestinationRoute> { backStack ->
                val destination = DestinationsDataSource.getDestinationById(backStack.toRoute<DestinationRoute>().destinationId)
                if (destination == null) EmptyStateView("Destination not found", "Return to Explore and select a destination.")
                else DestinationDetailScreen(
                    destination,
                    explore.originCity,
                    explore.favoriteIds.contains(destination.id),
                    onToggleFavorite = { exploreViewModel.toggleFavorite(destination) },
                    onBackClick = { if (nav.previousBackStackEntry != null) nav.popBackStack() },
                    onPlanWithAiClick = { nav.navigate(PlannerRoute("Plan a trip to ${it.name} from ${explore.originCity}")) }
                )
            }
        }
    }
    if (showPaywall) PaywallBottomSheet(billing) { showPaywall = false }
}
