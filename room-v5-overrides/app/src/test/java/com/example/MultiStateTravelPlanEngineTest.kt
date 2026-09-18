package com.example

import com.example.data.datasource.DestinationsDataSource
import com.example.data.datasource.karnataka.KarnatakaDestinationsData
import com.example.data.datasource.kerala.KeralaDestinationsData
import com.example.data.datasource.tamilnadu.TamilNaduDestinationsData
import com.example.data.engine.AiTripParser
import com.example.data.engine.DestinationEngine
import com.example.data.engine.ItineraryPlannerEngine
import com.example.data.engine.TravelCostEngine
import org.junit.Assert.*
import org.junit.Test

class MultiStateTravelPlanEngineTest {

    // -------------------------------------------------------------
    // 1. DATA CATALOG & STATE AGGREGATION TESTS
    // -------------------------------------------------------------

    @Test
    fun testAllStatesIncludedInCatalog() {
        val states = DestinationsDataSource.getAvailableStates()
        assertTrue("States should contain Karnataka", states.contains("Karnataka"))
        assertTrue("States should contain Tamil Nadu", states.contains("Tamil Nadu"))
        assertTrue("States should contain Kerala", states.contains("Kerala"))
        assertTrue("States should contain Telangana", states.contains("Telangana"))
        assertTrue("States should contain All option", states.contains("All"))
    }

    @Test
    fun testKarnatakaDestinationsPopulated() {
        val karnatakaDestinations = DestinationEngine.getDestinationsByState("Karnataka")
        assertTrue("Karnataka should have at least 10 destinations", karnatakaDestinations.size >= 10)

        val coorg = DestinationsDataSource.getDestinationById("karnataka-coorg")
        assertTrue("Legacy ID must resolve to a visible destination", coorg in karnatakaDestinations)
        assertNotNull("Coorg destination must exist", coorg)
        assertTrue("Coorg must have attractions", coorg!!.attractions.isNotEmpty())
        assertTrue("Coorg must have stays", coorg.stays.isNotEmpty())
        assertTrue("Coorg must have 12 months season data", coorg.seasons.size == 12)

        val hampi = karnatakaDestinations.find { it.id == "karnataka-hampi" }
        assertNotNull("Hampi destination must exist", hampi)
        assertEquals("Hampi state must be Karnataka", "Karnataka", hampi!!.state)
    }

    @Test
    fun testTamilNaduDestinationsPopulated() {
        val tnDestinations = DestinationEngine.getDestinationsByState("Tamil Nadu")
        assertTrue("Tamil Nadu should have at least 15 destinations", tnDestinations.size >= 15)

        val ooty = tnDestinations.find { it.id == "tamilnadu-ooty" }
        assertNotNull("Ooty destination must exist", ooty)
        assertTrue("Ooty must have attractions", ooty!!.attractions.isNotEmpty())
        assertTrue("Ooty must have 12 months season data", ooty.seasons.size == 12)

        val madurai = tnDestinations.find { it.id == "tamilnadu-madurai" }
        assertNotNull("Madurai destination must exist", madurai)
        assertEquals("Madurai state must be Tamil Nadu", "Tamil Nadu", madurai!!.state)
    }

    @Test
    fun testKeralaDestinationsPopulated() {
        val keralaDestinations = DestinationEngine.getDestinationsByState("Kerala")
        assertTrue("Kerala should have at least 10 destinations", keralaDestinations.size >= 10)

        val munnar = DestinationsDataSource.getDestinationById("kerala-munnar")
        assertTrue("Legacy ID must resolve to a visible destination", munnar in keralaDestinations)
        assertNotNull("Munnar destination must exist", munnar)
        assertTrue("Munnar must have attractions", munnar!!.attractions.isNotEmpty())
        assertTrue("Munnar must have 12 months season data", munnar.seasons.size == 12)

        val alleppey = keralaDestinations.find { it.id == "kerala-alappuzha" }
        assertNotNull("Alappuzha destination must exist", alleppey)
        assertEquals("Alappuzha state must be Kerala", "Kerala", alleppey!!.state)
    }

    // -------------------------------------------------------------
    // 2. ITINERARY GENERATION TESTS ACROSS STATES (1 to 7 Days)
    // -------------------------------------------------------------

    @Test
    fun testKarnatakaItinerary_1To7Days() {
        val coorg = KarnatakaDestinationsData.getById("karnataka-coorg")!!

        for (days in 1..7) {
            val plan = ItineraryPlannerEngine.generateDaysPlan(
                destination = coorg,
                originCity = "Bengaluru",
                durationDays = days,
                transportMode = "Car"
            )
            assertEquals("Plan for $days days must have $days items", days, plan.size)
            for (d in plan) {
                assertTrue("Day ${d.dayNumber} must have stops", d.stops.isNotEmpty())
                assertFalse("Day title should not be blank", d.dayTitle.isBlank())
            }
        }
    }

    @Test
    fun testTamilNaduItinerary_1To7Days() {
        val ooty = TamilNaduDestinationsData.getById("tamilnadu-ooty")!!

        for (days in 1..7) {
            val plan = ItineraryPlannerEngine.generateDaysPlan(
                destination = ooty,
                originCity = "Chennai",
                durationDays = days,
                transportMode = "Train"
            )
            assertEquals("Plan for $days days must have $days items", days, plan.size)
            for (d in plan) {
                assertTrue("Day ${d.dayNumber} must have stops", d.stops.isNotEmpty())
            }
        }
    }

    @Test
    fun testKeralaItinerary_1To7Days() {
        val munnar = KeralaDestinationsData.getById("kerala-munnar")!!

        for (days in 1..7) {
            val plan = ItineraryPlannerEngine.generateDaysPlan(
                destination = munnar,
                originCity = "Kochi",
                durationDays = days,
                transportMode = "Car"
            )
            assertEquals("Plan for $days days must have $days items", days, plan.size)
            for (d in plan) {
                assertTrue("Day ${d.dayNumber} must have stops", d.stops.isNotEmpty())
            }
        }
    }

    // -------------------------------------------------------------
    // 3. AI TRIP PARSER NLP TESTS
    // -------------------------------------------------------------

    @Test
    fun testAiTripParser_KarnatakaWeekend() {
        val query = AiTripParser.parseQuery("Plan a 2-day weekend trip to Coorg from Bangalore for a couple with 15k budget by car")

        assertEquals("Bengaluru", query.originCity)
        assertEquals(2, query.durationDays)
        assertEquals("Couple", query.partyType)
        assertEquals(15000, query.budget)
        assertEquals("Car", query.travelRequest.transportMode)
        assertTrue("Candidates should contain Coorg", query.candidateMatches.any { it.destination.name.contains("Coorg") })
    }

    @Test
    fun testAiTripParser_KeralaFamilyTrip() {
        val query = AiTripParser.parseQuery("Looking for a 4 days family trip to Munnar from Kochi with kids and 30k budget")

        assertEquals("Kochi", query.originCity)
        assertEquals(4, query.durationDays)
        assertEquals("Family", query.partyType)
        assertEquals(30000, query.budget)
        assertTrue("Candidates should contain Munnar", query.candidateMatches.any { it.destination.name.contains("Munnar") })
    }

    @Test
    fun testAiTripParser_TamilNaduSpiritualTour() {
        val query = AiTripParser.parseQuery("3 days temple and heritage spiritual trip to Madurai from Chennai by train for 20000 rs")

        assertEquals("Chennai", query.originCity)
        assertEquals(3, query.durationDays)
        assertEquals("Train", query.travelRequest.transportMode)
        assertEquals(20000, query.budget)
        assertTrue("Candidates should contain Madurai", query.candidateMatches.any { it.destination.name.contains("Madurai") })
    }

    @Test
    fun testAiTripParser_StateAwarePrioritization() {
        val query = AiTripParser.parseQuery("Suggest a nice hill station in Kerala for 3 days with 25000 budget")

        assertEquals(3, query.durationDays)
        assertEquals(25000, query.budget)
        assertTrue("Top candidates should be from Kerala", query.candidateMatches.any { it.destination.state == "Kerala" })
    }

    // -------------------------------------------------------------
    // 4. BUDGET & COST CALCULATION ENGINE TESTS
    // -------------------------------------------------------------

    @Test
    fun testTransportCostEngine_DifferentModes() {
        val distance = 300 // km

        val carCost = TravelCostEngine.calculateTransportCost(distance, "Car", 2)
        val bikeCost = TravelCostEngine.calculateTransportCost(distance, "Bike", 1)
        val trainCost = TravelCostEngine.calculateTransportCost(distance, "Train", 2)
        val busCost = TravelCostEngine.calculateTransportCost(distance, "Bus", 2)

        assertTrue("Bike cost should be less than car cost", bikeCost < carCost)
        assertTrue("Car cost should include fuel and toll", carCost > 3000)
        assertTrue("Train cost should be reasonable", trainCost in 500..8000)
        assertTrue("Bus cost should be positive", busCost > 500)
    }

    @Test
    fun testCompleteTripCostEstimation_AcrossTiers() {
        val munnar = KeralaDestinationsData.getById("kerala-munnar")!!

        val budgetCost = TravelCostEngine.estimateCompleteTrip(munnar, "Kochi", 3, "Couple", "Budget", "Car")
        val luxuryCost = TravelCostEngine.estimateCompleteTrip(munnar, "Kochi", 3, "Couple", "Luxury", "Car")

        val budgetTotal = budgetCost["total"] ?: 0
        val luxuryTotal = luxuryCost["total"] ?: 0

        assertTrue("Budget trip should be less expensive than luxury trip", budgetTotal < luxuryTotal)
        assertTrue("Budget total should be greater than zero", budgetTotal > 5000)
    }

    // -------------------------------------------------------------
    // 5. EXISTING TELANGANA DATA PRESERVATION VERIFICATION
    // -------------------------------------------------------------

    @Test
    fun testTelanganaDataPreservedAndIntact() {
        val telanganaDestinations = DestinationEngine.getDestinationsByState("Telangana")
        assertTrue("Telangana destinations must be preserved", telanganaDestinations.isNotEmpty())

        val ramappa = telanganaDestinations.find { it.id == "telangana-ramappa" }
        assertNotNull("Ramappa temple destination must still exist intact", ramappa)

        val hyderabad = telanganaDestinations.find { it.id == "telangana-hyderabad" }
        assertNotNull("Hyderabad destination must still exist intact", hyderabad)
    }

    @Test
    fun testPrintExactDataCounts() {
        val allDests = DestinationsDataSource.destinations
        val totalDestinations = allDests.size
        val totalAttractions = allDests.sumOf { it.attractions.size }
        val totalHiddenGems = allDests.sumOf { it.hiddenGems.size }
        val totalStays = allDests.sumOf { it.stays.size }
        val totalFoods = allDests.sumOf { it.foodGuide.localSpecialties.size }
        val totalRestaurants = allDests.sumOf { it.foodGuide.restaurants.size }
        val totalSeasons = allDests.sumOf { it.seasons.size }
        val allStatesInDests = allDests.map { it.state }.distinct()
        val allMasterStates = com.example.data.model.IndiaStatesMaster.allStatesAndUTs.filter { it.type == com.example.data.model.StateType.STATE }
        val allMasterUTs = com.example.data.model.IndiaStatesMaster.allStatesAndUTs.filter { it.type == com.example.data.model.StateType.UNION_TERRITORY }

        println("AUDIT_COUNT: Destinations = $totalDestinations")
        println("AUDIT_COUNT: Attractions = $totalAttractions")
        println("AUDIT_COUNT: HiddenGems = $totalHiddenGems")
        println("AUDIT_COUNT: Stays = $totalStays")
        println("AUDIT_COUNT: LocalSpecialties = $totalFoods")
        println("AUDIT_COUNT: Restaurants = $totalRestaurants")
        println("AUDIT_COUNT: SeasonEntries = $totalSeasons")
        println("AUDIT_COUNT: StatesInDestinations = ${allStatesInDests.size} ($allStatesInDests)")
        println("AUDIT_COUNT: MasterStates = ${allMasterStates.size}")
        println("AUDIT_COUNT: MasterUTs = ${allMasterUTs.size}")
    }
}
