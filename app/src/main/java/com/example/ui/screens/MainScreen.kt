package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.model.Destination
import com.example.ui.viewmodel.AiPlannerViewModel
import com.example.ui.viewmodel.ExploreViewModel
import com.example.ui.viewmodel.SavedTripsViewModel

sealed class ScreenNav {
    object Main : ScreenNav()
    data class DestinationDetail(val destination: Destination) : ScreenNav()
}

@Composable
fun MainScreen(
    exploreViewModel: ExploreViewModel = viewModel(),
    aiPlannerViewModel: AiPlannerViewModel = viewModel(),
    savedTripsViewModel: SavedTripsViewModel = viewModel()
) {
    var currentScreen by remember { mutableStateOf<ScreenNav>(ScreenNav.Main) }
    var selectedBottomTab by remember { mutableIntStateOf(0) }

    val exploreUiState by exploreViewModel.uiState.collectAsState()

    BackHandler(enabled = currentScreen is ScreenNav.DestinationDetail) {
        currentScreen = ScreenNav.Main
    }

    AnimatedContent(
        targetState = currentScreen,
        transitionSpec = {
            if (targetState is ScreenNav.DestinationDetail) {
                slideInHorizontally { width -> width } togetherWith slideOutHorizontally { width -> -width / 3 }
            } else {
                slideInHorizontally { width -> -width / 3 } togetherWith slideOutHorizontally { width -> width }
            }
        },
        label = "ScreenTransition"
    ) { screen ->
        when (screen) {
            is ScreenNav.DestinationDetail -> {
                val dest = screen.destination
                val isFav = exploreUiState.favoriteIds.contains(dest.id)

                DestinationDetailScreen(
                    destination = dest,
                    originCity = exploreUiState.originCity,
                    isFavorite = isFav,
                    onToggleFavorite = { exploreViewModel.toggleFavorite(dest) },
                    onBackClick = { currentScreen = ScreenNav.Main },
                    onPlanWithAiClick = { destination ->
                        aiPlannerViewModel.setOriginCity(exploreUiState.originCity)
                        aiPlannerViewModel.setExperience(
                            destination.categories.firstOrNull()?.displayName ?: "Nature & Scenery"
                        )
                        aiPlannerViewModel.setFreeformPrompt(
                            "Trip to ${destination.name}, ${destination.state} from ${exploreUiState.originCity} for 3 days"
                        )
                        aiPlannerViewModel.generateTripFromPrompt(
                            "Plan a 3-day trip to ${destination.name} from ${exploreUiState.originCity} with best sights, stays, and budget"
                        )
                        selectedBottomTab = 1
                        currentScreen = ScreenNav.Main
                    }
                )
            }

            is ScreenNav.Main -> {
                Scaffold(
                    bottomBar = {
                        NavigationBar(
                            containerColor = MaterialTheme.colorScheme.surface,
                            contentColor = MaterialTheme.colorScheme.primary
                        ) {
                            NavigationBarItem(
                                selected = selectedBottomTab == 0,
                                onClick = { selectedBottomTab = 0 },
                                icon = { Icon(imageVector = Icons.Default.Explore, contentDescription = "Explore") },
                                label = { Text("Explore", fontWeight = FontWeight.SemiBold) },
                                modifier = Modifier.testTag("nav_explore"),
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = MaterialTheme.colorScheme.primary,
                                    selectedTextColor = MaterialTheme.colorScheme.primary,
                                    indicatorColor = MaterialTheme.colorScheme.primaryContainer
                                )
                            )

                            NavigationBarItem(
                                selected = selectedBottomTab == 1,
                                onClick = { selectedBottomTab = 1 },
                                icon = { Icon(imageVector = Icons.Default.AutoAwesome, contentDescription = "AI Planner") },
                                label = { Text("AI Planner", fontWeight = FontWeight.SemiBold) },
                                modifier = Modifier.testTag("nav_ai_planner"),
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = MaterialTheme.colorScheme.primary,
                                    selectedTextColor = MaterialTheme.colorScheme.primary,
                                    indicatorColor = MaterialTheme.colorScheme.primaryContainer
                                )
                            )

                            NavigationBarItem(
                                selected = selectedBottomTab == 2,
                                onClick = { selectedBottomTab = 2 },
                                icon = { Icon(imageVector = Icons.Default.Bookmark, contentDescription = "My Trips") },
                                label = { Text("My Trips", fontWeight = FontWeight.SemiBold) },
                                modifier = Modifier.testTag("nav_my_trips"),
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = MaterialTheme.colorScheme.primary,
                                    selectedTextColor = MaterialTheme.colorScheme.primary,
                                    indicatorColor = MaterialTheme.colorScheme.primaryContainer
                                )
                            )
                        }
                    }
                ) { innerPadding ->
                    androidx.compose.foundation.layout.Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        when (selectedBottomTab) {
                            0 -> ExploreScreen(
                                viewModel = exploreViewModel,
                                onDestinationClick = { dest ->
                                    currentScreen = ScreenNav.DestinationDetail(dest)
                                },
                                onNavigateToAiPlanner = {
                                    selectedBottomTab = 1
                                }
                            )

                            1 -> AiPlannerScreen(
                                viewModel = aiPlannerViewModel,
                                onViewDestinationDetails = { destId ->
                                    val destination = exploreViewModel.uiState.value.filteredDestinations.find { it.id == destId }
                                        ?: exploreViewModel.uiState.value.filteredDestinations.firstOrNull()
                                    if (destination != null) {
                                        currentScreen = ScreenNav.DestinationDetail(destination)
                                    }
                                }
                            )

                            2 -> SavedTripsScreen(
                                viewModel = savedTripsViewModel,
                                onDestinationClick = { dest ->
                                    currentScreen = ScreenNav.DestinationDetail(dest)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
