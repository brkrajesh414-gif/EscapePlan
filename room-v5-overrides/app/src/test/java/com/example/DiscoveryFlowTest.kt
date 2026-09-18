package com.example

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.ui.screens.UnifiedExploreScreen
import com.example.ui.screens.UserProfileScreen
import com.example.ui.theme.MyApplicationTheme
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class DiscoveryFlowTest {
    @get:Rule val compose = createComposeRule()

    @Test fun partialSearchOpensSrisailamInformation() {
        compose.setContent {
            MyApplicationTheme {
                UnifiedExploreScreen({}, {}, {}, {})
            }
        }
        compose.onNodeWithText("Place, state or interest").performTextInput("sris")
        compose.waitUntil(15000) { compose.onAllNodesWithText("Srisailam").fetchSemanticsNodes().isNotEmpty() }
        compose.onNodeWithText("Travel information").performClick()
        compose.onNodeWithText("Official visitor information").assertExists()
        compose.onNodeWithText("Directions & nearby places").assertExists()
        compose.onNodeWithText("Close").performClick()
        compose.onNodeWithText("Clear").performClick()
        compose.onNodeWithText("Place, state or interest").performTextInput("Kashi")
        compose.waitUntil(15000) { compose.onAllNodesWithText("Varanasi").fetchSemanticsNodes().isNotEmpty() }
    }

    @Test fun guestCanContinueWhenFirebaseMissing() {
        var continued = false
        compose.setContent {
            MyApplicationTheme { UserProfileScreen(onLocation = {}, onExplore = { continued = true }) }
        }
        compose.waitUntil(15000) { compose.onAllNodesWithText("Continue as guest").fetchSemanticsNodes().isNotEmpty() }
        compose.onNodeWithText("Continue as guest").performClick()
        assertTrue(continued)
        compose.onNodeWithText("Firebase is not configured. Add google-services.json.").assertDoesNotExist()
    }
}
