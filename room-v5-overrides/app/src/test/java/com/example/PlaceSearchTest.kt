package com.example

import com.example.data.engine.PlaceSearch
import org.junit.Assert.*
import org.junit.Test

class PlaceSearchTest {
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
