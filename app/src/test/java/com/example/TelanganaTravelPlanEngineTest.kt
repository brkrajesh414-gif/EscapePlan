package com.example

import com.example.data.datasource.DestinationsDataSource
import com.example.data.datasource.telangana.TelanganaDestinationsData
import com.example.data.engine.AiTripParser
import com.example.data.engine.DestinationEngine
import com.example.data.engine.ItineraryPlannerEngine
import com.example.data.engine.TravelCostEngine
import com.example.data.model.Destination
import org.junit.Assert.*
import org.junit.Test

class TelanganaTravelPlanEngineTest {

    private val sampleDestination = TelanganaDestinationsData.getDestinationById("telangana-ramappa")
        ?: TelanganaDestinationsData.allTelanganaDestinations.first()

    // -------------------------------------------------------------
    // 1. ITINERARY GENERATION TESTS (1 to 7 Days)
    // -------------------------------------------------------------

    @Test
    fun testItineraryGeneration_SingleDay() {
        val days = ItineraryPlannerEngine.generateDaysPlan(
            destination = sampleDestination,
            originCity = "Hyderabad",
            durationDays = 1,
            transportMode = "Car"
        )

        assertEquals("1-day trip must generate exactly 1 day", 1, days.size)
        val day1 = days[0]
        assertEquals(1, day1.dayNumber)
        assertTrue("Day 1 should have stops", day1.stops.isNotEmpty())
        assertTrue("Day 1 title should mention express or day 1", day1.dayTitle.contains("Day 1") || day1.dayTitle.contains("Express"))
    }

    @Test
    fun testItineraryGeneration_TwoDays() {
        val days = ItineraryPlannerEngine.generateDaysPlan(
            destination = sampleDestination,
            originCity = "Hyderabad",
            durationDays = 2,
            transportMode = "Car"
        )

        assertEquals("2-day trip must generate exactly 2 days", 2, days.size)
        assertEquals(1, days[0].dayNumber)
        assertEquals(2, days[1].dayNumber)
        assertTrue("Final day should have stops", days[1].stops.isNotEmpty())
    }

    @Test
    fun testItineraryGeneration_ThreeDays() {
        val days = ItineraryPlannerEngine.generateDaysPlan(
            destination = sampleDestination,
            originCity = "Hyderabad",
            durationDays = 3,
            transportMode = "Car"
        )

        assertEquals("3-day trip must generate exactly 3 days", 3, days.size)
        for (i in 1..3) {
            assertEquals(i, days[i - 1].dayNumber)
            assertTrue("Day $i must have stops", days[i - 1].stops.isNotEmpty())
        }
    }

    @Test
    fun testItineraryGeneration_FourDays() {
        val days = ItineraryPlannerEngine.generateDaysPlan(
            destination = sampleDestination,
            originCity = "Hyderabad",
            durationDays = 4,
            transportMode = "Car"
        )

        assertEquals("4-day trip must generate exactly 4 days", 4, days.size)
        assertEquals(4, days[3].dayNumber)
    }

    @Test
    fun testItineraryGeneration_FiveDays() {
        val days = ItineraryPlannerEngine.generateDaysPlan(
            destination = sampleDestination,
            originCity = "Hyderabad",
            durationDays = 5,
            transportMode = "Car"
        )

        assertEquals("5-day trip must generate exactly 5 days", 5, days.size)
        assertEquals(5, days[4].dayNumber)
    }

    @Test
    fun testItineraryGeneration_SixDays() {
        val days = ItineraryPlannerEngine.generateDaysPlan(
            destination = sampleDestination,
            originCity = "Hyderabad",
            durationDays = 6,
            transportMode = "Car"
        )

        assertEquals("6-day trip must generate exactly 6 days", 6, days.size)
        assertEquals(6, days[5].dayNumber)
    }

    @Test
    fun testItineraryGeneration_SevenDays() {
        val days = ItineraryPlannerEngine.generateDaysPlan(
            destination = sampleDestination,
            originCity = "Hyderabad",
            durationDays = 7,
            transportMode = "Car"
        )

        assertEquals("7-day trip must generate exactly 7 days", 7, days.size)
        for (i in 1..7) {
            assertEquals("Day index check for day $i", i, days[i - 1].dayNumber)
            assertTrue("Day $i stops should not be empty", days[i - 1].stops.isNotEmpty())
        }
    }

    // -------------------------------------------------------------
    // 2. TRAVEL COST ENGINE TESTS & SCENARIOS
    // -------------------------------------------------------------

    @Test
    fun testTravelCostEngine_Scenarios() {
        // Solo Traveler
        val soloCost = TravelCostEngine.estimateCompleteTrip(
            destination = sampleDestination,
            originCity = "Hyderabad",
            days = 2,
            partyType = "Solo",
            tier = "Budget",
            transportMode = "Bike"
        )
        assertTrue("Solo total cost should be positive", (soloCost["total"] ?: 0) > 0)

        // Family Traveler with Car
        val familyCost = TravelCostEngine.estimateCompleteTrip(
            destination = sampleDestination,
            originCity = "Hyderabad",
            days = 3,
            partyType = "Family",
            tier = "Mid-Range",
            transportMode = "Car"
        )
        assertTrue("Family total cost should exceed solo budget cost", (familyCost["total"] ?: 0) > (soloCost["total"] ?: 0))
        assertTrue("Family cost should include stay, food, activities, travel",
            familyCost.containsKey("stay") && familyCost.containsKey("food") &&
            familyCost.containsKey("activities") && familyCost.containsKey("travel"))

        // Edge Case: Extreme Low Budget
        val extremeLowTier = TravelCostEngine.estimateCompleteTrip(
            destination = sampleDestination,
            originCity = "Hyderabad",
            days = 1,
            partyType = "Solo",
            tier = "Budget",
            transportMode = "Bus"
        )
        assertTrue("Day trip with bus should be very affordable", (extremeLowTier["total"] ?: 0) < 5000)

        // Edge Case: Luxury Trip
        val luxuryTier = TravelCostEngine.estimateCompleteTrip(
            destination = sampleDestination,
            originCity = "Hyderabad",
            days = 5,
            partyType = "Group",
            tier = "Luxury",
            transportMode = "Car"
        )
        assertTrue("5-day Luxury group trip cost should be substantial", (luxuryTier["total"] ?: 0) > 25000)
    }

    // -------------------------------------------------------------
    // 3. DESTINATION ENGINE RANKING & SCORING TESTS
    // -------------------------------------------------------------

    @Test
    fun testDestinationEngine_ScoringAndFiltering() {
        val ranked = DestinationEngine.rankDestinations(
            originCity = "Hyderabad",
            budget = 20000,
            durationDays = 2,
            partyType = "Couple",
            preferredVibes = listOf("Heritage", "Culture")
        )

        assertFalse("Ranked destinations should not be empty", ranked.isEmpty())
        assertTrue("Top destination score should be positive", ranked.first().score > 0)

        // Verify distance filter
        val nearby = DestinationEngine.getDestinationsWithinDistance("Hyderabad", 250)
        assertFalse("Destinations within 250km should exist", nearby.isEmpty())
        for (dest in nearby) {
            val dist = dest.travelRoute.originDistances["Hyderabad"] ?: Int.MAX_VALUE
            assertTrue("Destination ${dest.name} should be <= 250km, was $dist", dist <= 250)
        }
    }

    // -------------------------------------------------------------
    // 4. AI TRIP PARSER NATURAL LANGUAGE EXTRACTION TESTS
    // -------------------------------------------------------------

    @Test
    fun testAiTripParser_QueryExtraction() {
        val query = "Plan a 3-day family weekend trip to Ramappa and Laknavaram starting from Hyderabad with a budget of 18000"
        val parsed = AiTripParser.parseQuery(query)

        assertEquals("Hyderabad", parsed.originCity)
        assertEquals("Family", parsed.partyType)
        assertEquals(3, parsed.durationDays)
        assertEquals(18000, parsed.budget)
        assertFalse("Candidate matches should contain destinations", parsed.candidateMatches.isEmpty())

        val destNames = parsed.candidateMatches.map { it.destination.name.lowercase() }
        assertTrue("Should detect Ramappa or Laknavaram", destNames.any { it.contains("ramappa") || it.contains("laknavaram") })
    }

    // -------------------------------------------------------------
    // 5. TELANGANA DATASET COMPREHENSIVE INTEGRITY TESTS
    // -------------------------------------------------------------

    @Test
    fun testTelanganaDataset_Completeness() {
        val telanganaList = TelanganaDestinationsData.allTelanganaDestinations
        assertEquals("Telangana destination catalog must contain exactly 42 destinations", 42, telanganaList.size)

        for (dest in telanganaList) {
            assertEquals("State must be Telangana", "Telangana", dest.state)
            assertTrue("District must not be blank for ${dest.name}", dest.district.isNotBlank())
            assertTrue("Tagline must not be blank for ${dest.name}", dest.tagline.isNotBlank())
            assertTrue("Latitude must be valid for ${dest.name}", dest.latitude in 15.0..21.0)
            assertTrue("Longitude must be valid for ${dest.name}", dest.longitude in 77.0..82.0)
            assertTrue("Attractions should not be empty for ${dest.name}", dest.attractions.isNotEmpty())
            assertTrue("Origin distances should contain Hyderabad for ${dest.name}", dest.travelRoute.originDistances.containsKey("Hyderabad"))
        }

        // Verify key destinations exist
        val ids = telanganaList.map { it.id }.toSet()
        val expectedKeys = listOf(
            "telangana-hyderabad",
            "telangana-warangal",
            "telangana-ramappa",
            "telangana-laknavaram",
            "telangana-bogatha",
            "telangana-kuntala",
            "telangana-vikarabad",
            "telangana-yadagirigutta",
            "telangana-basara",
            "telangana-bhadrachalam",
            "telangana-alampur",
            "telangana-nagarjunasagar"
        )
        for (key in expectedKeys) {
            assertTrue("Dataset must contain $key", ids.contains(key))
        }
    }
}
