package com.example

import com.example.data.engine.PlaceSearch
import org.junit.Assert.*
import org.junit.Test

class PlaceSearchTest {
    @Test fun distanceLimitUsesRecordedDistances() {
        val parsed = com.example.data.engine.AiTripParser.parseQuery("Within 200 km of Hyderabad for 2 days")
        assertTrue(parsed.candidateMatches.isNotEmpty())
        assertTrue(parsed.candidateMatches.all { (it.destination.travelRoute.originDistances["Hyderabad"] ?: Int.MAX_VALUE) <= 200 })
    }
    @Test fun partialPlaceAndStateMatch() {
        assertTrue(PlaceSearch.matches("sris", "Srisailam Andhra Pradesh"))
        assertTrue(PlaceSearch.matches("ANDHRA sris", "Srisailam Andhra Pradesh"))
        assertFalse(PlaceSearch.matches("sris Kerala", "Srisailam Andhra Pradesh"))
    }
    @Test fun whitespacePunctuationAndAccents() {
        assertTrue(PlaceSearch.matches("  sri-sailam  ", "Sri Sailam"))
        assertTrue(PlaceSearch.matches("cafe", "Café"))
        assertTrue(PlaceSearch.matches("", "Srisailam"))
    }
}
