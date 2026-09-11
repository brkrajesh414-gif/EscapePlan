package com.example.data.datasource.common

import com.example.data.model.SeasonInfo

object RegionalSeasonalHelper {

    private val MONTHS = listOf(
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    )

    /**
     * Western Ghats Hill & Plantation Region (Coorg, Chikkamagaluru, Wayanad, Sakleshpur, Agumbe)
     * Heavy monsoon June-August, chilly crisp winters, pleasant springs.
     */
    fun createWesternGhatsSeasons(destId: String): List<SeasonInfo> {
        return MONTHS.map { month ->
            when (month) {
                "January" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "12°C",
                    maximumTemperature = "24°C",
                    rainfall = "5 mm (Dry)",
                    crowdLevel = "High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Coffee plantation walks", "Mullayanagiri trek", "Campfires", "Bird watching"),
                    recommendation = "Excellent"
                )
                "February" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "14°C",
                    maximumTemperature = "26°C",
                    rainfall = "8 mm (Dry)",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Estate tours", "Sunrise viewpoints", "Spice shopping", "Outdoor hikes"),
                    recommendation = "Excellent"
                )
                "March" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "17°C",
                    maximumTemperature = "29°C",
                    rainfall = "20 mm (White coffee blossoms)",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Good",
                    bestActivities = listOf("Coffee blossom fragrance trails", "Temple visits", "River rafting start"),
                    recommendation = "Good"
                )
                "April" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "19°C",
                    maximumTemperature = "31°C",
                    rainfall = "45 mm (Pre-monsoon showers)",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Good",
                    bestActivities = listOf("High-altitude tea estates", "Evening viewpoints", "Resort leisure"),
                    recommendation = "Good"
                )
                "May" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "20°C",
                    maximumTemperature = "30°C",
                    rainfall = "90 mm (Thunderstorms)",
                    crowdLevel = "High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Good",
                    bestActivities = listOf("Summer escape from cities", "Valley drives", "Wildlife sanctuaries"),
                    recommendation = "Good"
                )
                "June" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "18°C",
                    maximumTemperature = "24°C",
                    rainfall = "350 mm (Heavy southwest monsoon)",
                    crowdLevel = "Low",
                    hotelPriceLevel = "Budget",
                    travelCondition = "Moderate",
                    bestActivities = listOf("Monsoon magic", "Swollen waterfalls", "Ayurvedic stays", "Misty porch reading"),
                    recommendation = "Moderate"
                )
                "July" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "17°C",
                    maximumTemperature = "23°C",
                    rainfall = "520 mm (Peak torrential downpours)",
                    crowdLevel = "Low",
                    hotelPriceLevel = "Budget",
                    travelCondition = "Avoid if possible",
                    bestActivities = listOf("Indoor plantation retreats", "Waterfall roar viewing from safe decks"),
                    recommendation = "Avoid if possible"
                )
                "August" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "18°C",
                    maximumTemperature = "23°C",
                    rainfall = "410 mm (Lush green landscapes)",
                    crowdLevel = "Low",
                    hotelPriceLevel = "Budget",
                    travelCondition = "Moderate",
                    bestActivities = listOf("Gushing streams", "Verdant photography", "Coffee farm stays"),
                    recommendation = "Moderate"
                )
                "September" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "17°C",
                    maximumTemperature = "25°C",
                    rainfall = "180 mm (Post-monsoon freshness)",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Post-monsoon waterfalls", "Nature trekking", "River crossings"),
                    recommendation = "Excellent"
                )
                "October" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "16°C",
                    maximumTemperature = "26°C",
                    rainfall = "140 mm (Occasional evening rain)",
                    crowdLevel = "High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Dussehra celebrations", "Peak greenery vistas", "Trekking to peak summits"),
                    recommendation = "Excellent"
                )
                "November" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "14°C",
                    maximumTemperature = "25°C",
                    rainfall = "40 mm (Pleasant winter onset)",
                    crowdLevel = "High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Coffee berry harvesting", "Sunrise fog photography", "Scenic ghat drives"),
                    recommendation = "Excellent"
                )
                else -> SeasonInfo( // December
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "11°C",
                    maximumTemperature = "23°C",
                    rainfall = "10 mm (Crisp winter)",
                    crowdLevel = "Very High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Year-end celebrations", "Chilly morning hikes", "Campfires under stars"),
                    recommendation = "Excellent"
                )
            }
        }
    }

    /**
     * High Altitude Nilgiris / Cardamom Hills (Ooty, Kodaikanal, Munnar, Coonoor)
     * Cool mountain climate year-round, frost in Dec-Jan, pleasant summers.
     */
    fun createHighAltitudeSeasons(destId: String): List<SeasonInfo> = createHighAltitudeHillSeasons(destId)

    fun createHighAltitudeHillSeasons(destId: String): List<SeasonInfo> {
        return MONTHS.map { month ->
            when (month) {
                "January" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "5°C",
                    maximumTemperature = "19°C",
                    rainfall = "12 mm (Frosty & crisp)",
                    crowdLevel = "High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Toy train ride", "Botanical garden strolls", "Tea tasting", "Lake boating"),
                    recommendation = "Excellent"
                )
                "February" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "7°C",
                    maximumTemperature = "21°C",
                    rainfall = "15 mm",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Pine forest walks", "Valley viewpoints", "Chocolates & homemade pastries"),
                    recommendation = "Excellent"
                )
                "March" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "9°C",
                    maximumTemperature = "23°C",
                    rainfall = "25 mm",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Trekking", "Doddabetta summit view", "Tea museum tours"),
                    recommendation = "Excellent"
                )
                "April" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "12°C",
                    maximumTemperature = "24°C",
                    rainfall = "65 mm",
                    crowdLevel = "High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Summer flower festivals", "Lake cycling", "Rose garden visits"),
                    recommendation = "Excellent"
                )
                "May" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "13°C",
                    maximumTemperature = "25°C",
                    rainfall = "110 mm",
                    crowdLevel = "Very High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Good",
                    bestActivities = listOf("Annual fruit/flower show", "Boating on lake", "Horse riding"),
                    recommendation = "Good"
                )
                "June" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "11°C",
                    maximumTemperature = "18°C",
                    rainfall = "220 mm (Monsoon mist)",
                    crowdLevel = "Low",
                    hotelPriceLevel = "Budget",
                    travelCondition = "Moderate",
                    bestActivities = listOf("Misty rolling tea valleys", "Cozy fireplace stays", "Hot homemade chocolates"),
                    recommendation = "Moderate"
                )
                "July" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "11°C",
                    maximumTemperature = "17°C",
                    rainfall = "310 mm (Heavy rains)",
                    crowdLevel = "Low",
                    hotelPriceLevel = "Budget",
                    travelCondition = "Moderate",
                    bestActivities = listOf("Indoor spa", "Gushing pykara falls viewing", "Tea tasting"),
                    recommendation = "Moderate"
                )
                "August" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "11°C",
                    maximumTemperature = "18°C",
                    rainfall = "240 mm",
                    crowdLevel = "Low",
                    hotelPriceLevel = "Budget",
                    travelCondition = "Moderate",
                    bestActivities = listOf("Emerald lake photography", "Lush rolling pastures"),
                    recommendation = "Moderate"
                )
                "September" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "10°C",
                    maximumTemperature = "20°C",
                    rainfall = "130 mm",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Clear post-monsoon valley vistas", "Botanical walks", "Mountain bicycling"),
                    recommendation = "Excellent"
                )
                "October" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "9°C",
                    maximumTemperature = "20°C",
                    rainfall = "160 mm (Northeast monsoon showers)",
                    crowdLevel = "High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Good",
                    bestActivities = listOf("Autumn foliage", "Tea plucking sessions", "Scenic ghat drives"),
                    recommendation = "Good"
                )
                "November" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "7°C",
                    maximumTemperature = "19°C",
                    rainfall = "80 mm",
                    crowdLevel = "High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Pleasant chill", "Avalanche valley day trip", "Sunset at needle rock"),
                    recommendation = "Excellent"
                )
                else -> SeasonInfo( // December
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "4°C",
                    maximumTemperature = "18°C",
                    rainfall = "30 mm (Sub-zero ground frost)",
                    crowdLevel = "Very High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Winter holidays", "Woolen markets", "Bonfire barbecues"),
                    recommendation = "Excellent"
                )
            }
        }
    }

    /**
     * Coastal Karnataka & Malabar Coast (Gokarna, Udupi, Mangaluru, Kannur, Bekal, Karwar)
     * Warm tropical beach climate, heavy monsoon June-August, ideal Oct-March.
     */
    fun createCoastalSeasons(destId: String): List<SeasonInfo> {
        return MONTHS.map { month ->
            when (month) {
                "January" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "20°C",
                    maximumTemperature = "31°C",
                    rainfall = "2 mm",
                    crowdLevel = "High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Sunset beach treks", "Scuba diving & watersports", "Seafood shacks", "Temple visits"),
                    recommendation = "Excellent"
                )
                "February" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "21°C",
                    maximumTemperature = "32°C",
                    rainfall = "3 mm",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Surfing lessons", "Fort exploration", "Island boat excursions"),
                    recommendation = "Excellent"
                )
                "March" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "23°C",
                    maximumTemperature = "34°C",
                    rainfall = "8 mm",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Good",
                    bestActivities = listOf("Morning beach yoga", "Coastal drives", "Dolphin spotting"),
                    recommendation = "Good"
                )
                "April" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "25°C",
                    maximumTemperature = "35°C",
                    rainfall = "30 mm",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Moderate",
                    bestActivities = listOf("Evening swimming", "Sunset cliff photography", "Cashew shopping"),
                    recommendation = "Moderate"
                )
                "May" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "26°C",
                    maximumTemperature = "34°C",
                    rainfall = "140 mm (Humid & early storms)",
                    crowdLevel = "Low",
                    hotelPriceLevel = "Budget",
                    travelCondition = "Moderate",
                    bestActivities = listOf("Resort relaxation", "Fresh seafood dining"),
                    recommendation = "Moderate"
                )
                "June" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "23°C",
                    maximumTemperature = "29°C",
                    rainfall = "780 mm (Ferocious Arabian Sea monsoon)",
                    crowdLevel = "Low",
                    hotelPriceLevel = "Budget",
                    travelCondition = "Avoid if possible",
                    bestActivities = listOf("Sea watching from cliff safe spots", "Ayurvedic rejuvenating therapies"),
                    recommendation = "Avoid if possible"
                )
                "July" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "23°C",
                    maximumTemperature = "28°C",
                    rainfall = "980 mm (Peak coastal monsoon)",
                    crowdLevel = "Low",
                    hotelPriceLevel = "Budget",
                    travelCondition = "Avoid if possible",
                    bestActivities = listOf("Indoor wellness retreats", "Monsoon photography from room balconies"),
                    recommendation = "Avoid if possible"
                )
                "August" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "23°C",
                    maximumTemperature = "29°C",
                    rainfall = "620 mm",
                    crowdLevel = "Low",
                    hotelPriceLevel = "Budget",
                    travelCondition = "Moderate",
                    bestActivities = listOf("Lush green coastal hinterlands", "Rain-washed temple architectures"),
                    recommendation = "Moderate"
                )
                "September" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "23°C",
                    maximumTemperature = "30°C",
                    rainfall = "240 mm",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Good",
                    bestActivities = listOf("Reopening beach cafes", "Coastal boat cruises", "Scenic NH66 marine drive"),
                    recommendation = "Good"
                )
                "October" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "23°C",
                    maximumTemperature = "32°C",
                    rainfall = "160 mm",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Kite flying on beaches", "Water sports resuming", "Temple car festivals"),
                    recommendation = "Excellent"
                )
                "November" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "22°C",
                    maximumTemperature = "32°C",
                    rainfall = "45 mm",
                    crowdLevel = "High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Surfing, paddle-boarding", "Om Beach to Half-Moon trek", "St. Mary's Island boats"),
                    recommendation = "Excellent"
                )
                else -> SeasonInfo( // December
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "20°C",
                    maximumTemperature = "31°C",
                    rainfall = "8 mm",
                    crowdLevel = "Very High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("New Year beach gatherings", "Parasailing", "Deep sea angling", "Night markets"),
                    recommendation = "Excellent"
                )
            }
        }
    }

    /**
     * Kerala Backwaters & Tropical Plains (Alleppey, Kumarakom, Kochi, Kollam, Varkala)
     * Lush backwater cruises, Onam season, Ayurvedic monsoon, peak winter tourism.
     */
    fun createKeralaBackwaterSeasons(destId: String): List<SeasonInfo> {
        return MONTHS.map { month ->
            when (month) {
                "January" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "21°C",
                    maximumTemperature = "31°C",
                    rainfall = "10 mm",
                    crowdLevel = "Very High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Houseboat day & night cruises", "Village canoe trails", "Kathakali & Kalaripayattu", "Sunset lagoon dining"),
                    recommendation = "Excellent"
                )
                "February" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "22°C",
                    maximumTemperature = "32°C",
                    rainfall = "18 mm",
                    crowdLevel = "High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Bird sanctuary spotting", "Paddy field cycling", "Karimeen fish tasting"),
                    recommendation = "Excellent"
                )
                "March" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "24°C",
                    maximumTemperature = "34°C",
                    rainfall = "40 mm",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Good",
                    bestActivities = listOf("Morning canal kayaking", "Coir-making village experiences", "Heritage walking tours"),
                    recommendation = "Good"
                )
                "April" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "25°C",
                    maximumTemperature = "34°C",
                    rainfall = "90 mm",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Good",
                    bestActivities = listOf("Vishu celebrations", "Early morning shikara rides", "Ayurvedic massage"),
                    recommendation = "Good"
                )
                "May" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "25°C",
                    maximumTemperature = "33°C",
                    rainfall = "220 mm (Summer showers)",
                    crowdLevel = "Low",
                    hotelPriceLevel = "Budget",
                    travelCondition = "Moderate",
                    bestActivities = listOf("Resort spa retreats", "Sunset viewing over Vembanad Lake"),
                    recommendation = "Moderate"
                )
                "June" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "23°C",
                    maximumTemperature = "29°C",
                    rainfall = "550 mm (Monsoon onset - Edavappathi)",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Budget",
                    travelCondition = "Good",
                    bestActivities = listOf("Traditional Ayurvedic Panchakarma treatment", "Monsoon houseboat stays"),
                    recommendation = "Good"
                )
                "July" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "23°C",
                    maximumTemperature = "29°C",
                    rainfall = "480 mm",
                    crowdLevel = "Low",
                    hotelPriceLevel = "Budget",
                    travelCondition = "Moderate",
                    bestActivities = listOf("Rejuvenation wellness therapies", "Rains drumming on thatch roofs"),
                    recommendation = "Moderate"
                )
                "August" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "23°C",
                    maximumTemperature = "29°C",
                    rainfall = "360 mm (Snake boat race season)",
                    crowdLevel = "High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Nehru Trophy Boat Race on Punnamada Lake", "Onam grand sadya feasts"),
                    recommendation = "Excellent"
                )
                "September" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "23°C",
                    maximumTemperature = "30°C",
                    rainfall = "220 mm",
                    crowdLevel = "High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Onam festivities", "Pookkalam flower carpets", "Backwater photography"),
                    recommendation = "Excellent"
                )
                "October" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "23°C",
                    maximumTemperature = "31°C",
                    rainfall = "280 mm (Thulam monsoon showers)",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Good",
                    bestActivities = listOf("Spice market visits", "Canoe safari through tranquil canals"),
                    recommendation = "Good"
                )
                "November" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "22°C",
                    maximumTemperature = "31°C",
                    rainfall = "120 mm",
                    crowdLevel = "High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Houseboat cruises", "Migratory duck & bird sightings", "Fish market auctions"),
                    recommendation = "Excellent"
                )
                else -> SeasonInfo( // December
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "21°C",
                    maximumTemperature = "31°C",
                    rainfall = "25 mm",
                    crowdLevel = "Very High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Cochin Carnival", "Christmas festivities", "Backwater sunset champagne cruises"),
                    recommendation = "Excellent"
                )
            }
        }
    }

    /**
     * Tamil Nadu Plains, Heritage & Temple Capitals (Thanjavur, Madurai, Kanchipuram, Tiruchirappalli, Rameswaram, Chennai)
     * Warm/hot summers, pleasant winters, northeast monsoon in Oct-Nov.
     */
    fun createTamilNaduHeritageSeasons(destId: String): List<SeasonInfo> {
        return MONTHS.map { month ->
            when (month) {
                "January" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "19°C",
                    maximumTemperature = "29°C",
                    rainfall = "15 mm",
                    crowdLevel = "Very High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Pongal harvest festivals", "Temple gopuram photography", "Chettinad cuisine trail", "Classical music season"),
                    recommendation = "Excellent"
                )
                "February" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "20°C",
                    maximumTemperature = "31°C",
                    rainfall = "10 mm",
                    crowdLevel = "High",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Brihadisvara temple architecture tour", "Silk weaving workshops", "Heritage walks"),
                    recommendation = "Excellent"
                )
                "March" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "22°C",
                    maximumTemperature = "34°C",
                    rainfall = "12 mm",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Good",
                    bestActivities = listOf("Early morning temple darshans", "Panguni Uthiram temple festivals", "Bronze casting demonstrations"),
                    recommendation = "Good"
                )
                "April" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "25°C",
                    maximumTemperature = "37°C",
                    rainfall = "20 mm (Hot summer)",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Budget",
                    travelCondition = "Moderate",
                    bestActivities = listOf("Chithirai festival in Madurai", "Evening monument walks", "Jigarthanda cold beverages"),
                    recommendation = "Moderate"
                )
                "May" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "27°C",
                    maximumTemperature = "39°C (Agni Nakshatram peak heat)",
                    rainfall = "40 mm",
                    crowdLevel = "Low",
                    hotelPriceLevel = "Budget",
                    travelCondition = "Avoid if possible",
                    bestActivities = listOf("Indoor museum galleries", "Air-conditioned palace visits"),
                    recommendation = "Avoid if possible"
                )
                "June" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "26°C",
                    maximumTemperature = "37°C",
                    rainfall = "50 mm",
                    crowdLevel = "Low",
                    hotelPriceLevel = "Budget",
                    travelCondition = "Moderate",
                    bestActivities = listOf("Evening street food exploration", "Temple rituals after sunset"),
                    recommendation = "Moderate"
                )
                "July" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "25°C",
                    maximumTemperature = "36°C",
                    rainfall = "65 mm",
                    crowdLevel = "Low",
                    hotelPriceLevel = "Budget",
                    travelCondition = "Moderate",
                    bestActivities = listOf("Aadi festival temple car celebrations", "Heritage mansion stays"),
                    recommendation = "Moderate"
                )
                "August" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "24°C",
                    maximumTemperature = "35°C",
                    rainfall = "85 mm",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Good",
                    bestActivities = listOf("Cauvery river ceremonies", "Kumbakonam brassware shopping"),
                    recommendation = "Good"
                )
                "September" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "24°C",
                    maximumTemperature = "34°C",
                    rainfall = "110 mm",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Good",
                    bestActivities = listOf("Navratri golu displays", "Temple illumination viewing"),
                    recommendation = "Good"
                )
                "October" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "23°C",
                    maximumTemperature = "31°C",
                    rainfall = "240 mm (Northeast monsoon)",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Moderate",
                    bestActivities = listOf("Cooling rains over granite temple towers", "Deepavali celebrations"),
                    recommendation = "Moderate"
                )
                "November" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "21°C",
                    maximumTemperature = "29°C",
                    rainfall = "280 mm (Monsoon showers)",
                    crowdLevel = "High",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Good",
                    bestActivities = listOf("Thiruvannamalai Karthigai Deepam mega beacon", "Pleasant evening temperatures"),
                    recommendation = "Good"
                )
                else -> SeasonInfo( // December
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "19°C",
                    maximumTemperature = "28°C",
                    rainfall = "70 mm",
                    crowdLevel = "Very High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Vaikunta Ekadashi at Srirangam", "Margazhi music & dance festival", "Chilly morning temple walks"),
                    recommendation = "Excellent"
                )
            }
        }
    }

    /**
     * Deccan Plateau Heritage & Stone Architecture (Hampi, Badami, Pattadakal, Aihole, Bijapur)
     * Crisp dry winter, hot summers, mild monsoon.
     */
    fun createDeccanSeasons(destId: String): List<SeasonInfo> = createDeccanHeritageSeasons(destId)

    fun createDeccanHeritageSeasons(destId: String): List<SeasonInfo> {
        return MONTHS.map { month ->
            when (month) {
                "January" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "14°C",
                    maximumTemperature = "29°C",
                    rainfall = "2 mm",
                    crowdLevel = "High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Hampi Utsav cultural festival", "Boulder scrambling & cycling", "Coracle boat rides on Tungabhadra", "Sunset at Matanga Hill"),
                    recommendation = "Excellent"
                )
                "February" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "16°C",
                    maximumTemperature = "32°C",
                    rainfall = "3 mm",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Badami cave temples climbing", "Pattadakal UNESCO complex exploration", "Rock climbing"),
                    recommendation = "Excellent"
                )
                "March" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "20°C",
                    maximumTemperature = "36°C",
                    rainfall = "8 mm",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Good",
                    bestActivities = listOf("Early morning Virupaksha darshan", "Evening boulder photography"),
                    recommendation = "Good"
                )
                "April" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "24°C",
                    maximumTemperature = "39°C (Hot Deccan summer)",
                    rainfall = "15 mm",
                    crowdLevel = "Low",
                    hotelPriceLevel = "Budget",
                    travelCondition = "Avoid if possible",
                    bestActivities = listOf("Indoor museum visits", "Gol Gumbaz acoustic dome whispering chamber"),
                    recommendation = "Avoid if possible"
                )
                "May" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "25°C",
                    maximumTemperature = "40°C",
                    rainfall = "30 mm",
                    crowdLevel = "Low",
                    hotelPriceLevel = "Budget",
                    travelCondition = "Avoid if possible",
                    bestActivities = listOf("Air-conditioned heritage stays", "Star-gazing at night"),
                    recommendation = "Avoid if possible"
                )
                "June" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "23°C",
                    maximumTemperature = "33°C",
                    rainfall = "70 mm",
                    crowdLevel = "Low",
                    hotelPriceLevel = "Budget",
                    travelCondition = "Good",
                    bestActivities = listOf("Green moss on ancient stone monuments", "Scenic Tungabhadra dam river flow"),
                    recommendation = "Good"
                )
                "July" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "22°C",
                    maximumTemperature = "30°C",
                    rainfall = "90 mm",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Good",
                    bestActivities = listOf("Overcast skies ideal for day-long monument walks without scorching sun", "Pattadakal temple reflections"),
                    recommendation = "Good"
                )
                "August" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "22°C",
                    maximumTemperature = "30°C",
                    rainfall = "85 mm",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Good",
                    bestActivities = listOf("Vibrant paddy fields bordering red sandstone ruins", "Coracle safari"),
                    recommendation = "Good"
                )
                "September" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "21°C",
                    maximumTemperature = "31°C",
                    rainfall = "110 mm",
                    crowdLevel = "Moderate",
                    hotelPriceLevel = "Moderate",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Post-monsoon freshness", "Archaeological photography", "Rural village cycle rides"),
                    recommendation = "Excellent"
                )
                "October" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "20°C",
                    maximumTemperature = "31°C",
                    rainfall = "65 mm",
                    crowdLevel = "High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Dussehra temple festivities", "Anjaneya Hill sunrise trek"),
                    recommendation = "Excellent"
                )
                "November" -> SeasonInfo(
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "16°C",
                    maximumTemperature = "30°C",
                    rainfall = "15 mm",
                    crowdLevel = "High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Stone Chariot photography", "Vittala musical pillars tour", "Hippies island cafe culture"),
                    recommendation = "Excellent"
                )
                else -> SeasonInfo( // December
                    destinationId = destId,
                    month = month,
                    minimumTemperature = "13°C",
                    maximumTemperature = "28°C",
                    rainfall = "5 mm",
                    crowdLevel = "Very High",
                    hotelPriceLevel = "Peak",
                    travelCondition = "Excellent",
                    bestActivities = listOf("Year-end backpacking", "Moped ride through ruins", "Sunset drum circles at sunset point"),
                    recommendation = "Excellent"
                )
            }
        }
    }
}
