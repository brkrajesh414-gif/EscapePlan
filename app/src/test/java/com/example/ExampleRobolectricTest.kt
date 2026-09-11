package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.datasource.DestinationsDataSource
import com.example.data.repository.TravelRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("Trip Planner", appName)
  }

  @Test
  fun `verify destinations data source contains Araku Valley`() {
    val araku = DestinationsDataSource.getDestinationById("araku-valley")
    assertNotNull(araku)
    assertEquals("Araku Valley", araku?.name)
    assertEquals("Andhra Pradesh", araku?.state)
    assertTrue(araku?.attractions?.isNotEmpty() == true)
    assertTrue(araku?.stays?.isNotEmpty() == true)
    assertTrue(araku?.foodGuide?.localSpecialties?.isNotEmpty() == true)
  }

  @Test
  fun `verify AI trip planner generates structured itinerary`() = runBlocking {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val repository = TravelRepository(context)
    val itinerary = repository.generateAiTrip(
        originCity = "Hyderabad",
        budget = 20000,
        tripType = "Couple",
        durationDays = 3,
        transportMode = "Car",
        experience = "Nature & Scenery",
        customPrompt = "I'm in Hyderabad. I have ₹20,000 and 3 days. I want a peaceful trip with my wife, good food and nice scenery. Where should I go?"
    )

    assertNotNull(itinerary)
    assertTrue("Destination name should be non-empty", itinerary.destinationName.isNotBlank())
    assertEquals(3, itinerary.durationDays)
    assertTrue(itinerary.estimatedBudget in 10000..30000)
    assertTrue(itinerary.days.isNotEmpty())
    assertTrue(itinerary.packingAndTravelTips.isNotEmpty())
  }
}
