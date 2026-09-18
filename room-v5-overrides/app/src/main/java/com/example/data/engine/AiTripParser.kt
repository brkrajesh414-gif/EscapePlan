package com.example.data.engine

import com.example.data.model.ParsedTravelQuery
import com.example.data.model.TravelRequest

object AiTripParser {

    private val KNOWN_CITIES = listOf(
        "Hyderabad", "Warangal", "Karimnagar", "Nizamabad", "Khammam",
        "Bengaluru", "Bangalore", "Mysuru", "Mysore", "Mangaluru", "Mangalore", "Hubballi", "Hubli", "Belagavi", "Udupi", "Madikeri",
        "Chennai", "Madurai", "Tiruchirappalli", "Trichy", "Salem", "Tirunelveli", "Thanjavur", "Coimbatore",
        "Kochi", "Cochin", "Thiruvananthapuram", "Trivandrum", "Kozhikode", "Calicut", "Alappuzha", "Alleppey", "Kollam", "Kannur", "Palakkad", "Thrissur",
        "Visakhapatnam", "Vizag", "Vijayawada", "Tirupati",
        "Pune", "Mumbai", "Delhi", "Kolkata"
    )

    /**
     * Parses free-form user travel requests into structured parameters and ranked destination matches
     */
    fun parseQuery(prompt: String): ParsedTravelQuery {
        val lower = prompt.lowercase()

        // 1. Detect Origin City
        var origin = "Hyderabad"
        for (city in KNOWN_CITIES) {
            if (lower.contains(city.lowercase())) {
                origin = when (city.lowercase()) {
                    "bangalore" -> "Bengaluru"
                    "vizag" -> "Visakhapatnam"
                    "mysore" -> "Mysuru"
                    "mangalore" -> "Mangaluru"
                    "hubli" -> "Hubballi"
                    "trichy" -> "Tiruchirappalli"
                    "trivandrum" -> "Thiruvananthapuram"
                    "calicut" -> "Kozhikode"
                    "alleppey" -> "Alappuzha"
                    "cochin" -> "Kochi"
                    else -> city
                }
                break
            }
        }

        // 2. Detect Budget
        var budget = 20000
        val kRegex = Regex("""(?:₹|rs\.?|inr)?\s*(\d+)\s*k\b""", RegexOption.IGNORE_CASE)
        val kMatch = kRegex.find(prompt)
        if (kMatch != null) {
            val num = kMatch.groupValues[1].toIntOrNull()
            if (num != null) budget = num * 1000
        } else {
            val numRegex = Regex("""(?:₹|rs\.?|inr)?\s*(\d{1,2}[,\d]{3,})\b""", RegexOption.IGNORE_CASE)
            val numMatch = numRegex.find(prompt)
            if (numMatch != null) {
                val clean = numMatch.groupValues[1].replace(",", "").toIntOrNull()
                if (clean != null && clean in 2000..500000) budget = clean
            }
        }

        // 3. Detect Duration in Days (Support 1-day through 7-day)
        var days = 3
        val daysRegex = Regex("""(\d+)\s*[-–]?\s*(?:days?|day)\b""", RegexOption.IGNORE_CASE)
        val daysMatch = daysRegex.find(prompt)
        if (daysMatch != null) {
            val d = daysMatch.groupValues[1].toIntOrNull()
            if (d != null && d in 1..15) days = d
        } else if (lower.contains("weekend")) {
            days = 2
        } else if (lower.contains("day trip") || lower.contains("one day") || lower.contains("1 day") || lower.contains("single day")) {
            days = 1
        }

        // 4. Detect Traveller Type
        var travellerType = "Couple"
        if (lower.contains("wife") || lower.contains("husband") || lower.contains("partner") || lower.contains("couple") || lower.contains("girlfriend") || lower.contains("boyfriend")) {
            travellerType = "Couple"
        } else if (lower.contains("solo") || lower.contains("alone") || lower.contains("myself")) {
            travellerType = "Solo"
        } else if (lower.contains("family") || lower.contains("kids") || lower.contains("children") || lower.contains("parents")) {
            travellerType = "Family"
        } else if (lower.contains("friends") || lower.contains("buddies") || lower.contains("colleagues") || lower.contains("gang") || lower.contains("group")) {
            travellerType = "Friends"
        }

        // 5. Detect Transport Mode (Bike, Car, Train, Bus, Flight)
        var transportMode = "Car"
        if (lower.contains("bike") || lower.contains("motorcycle") || lower.contains("bullet") || lower.contains("two wheeler")) {
            transportMode = "Bike"
        } else if (lower.contains("train") || lower.contains("railway") || lower.contains("express")) {
            transportMode = "Train"
        } else if (lower.contains("bus") || lower.contains("tsrtc") || lower.contains("sleeper bus")) {
            transportMode = "Bus"
        } else if (lower.contains("flight") || lower.contains("fly") || lower.contains("air")) {
            transportMode = "Flight"
        } else {
            transportMode = "Car"
        }

        // 6. Detect Preferred Experiences
        val experiences = mutableListOf<String>()
        if (lower.contains("peace") || lower.contains("quiet") || lower.contains("calm") || lower.contains("serene") || lower.contains("relax")) {
            experiences.add("Peaceful")
        }
        if (lower.contains("scenery") || lower.contains("view") || lower.contains("scenic") || lower.contains("landscape")) {
            experiences.add("Scenery")
        }
        if (lower.contains("food") || lower.contains("cuisine") || lower.contains("culinary") || lower.contains("eat") || lower.contains("biryani")) {
            experiences.add("Food")
        }
        if (lower.contains("nature") || lower.contains("forest") || lower.contains("green") || lower.contains("trees") || lower.contains("flora")) {
            experiences.add("Nature")
        }
        if (lower.contains("temple") || lower.contains("spiritual") || lower.contains("darshan") || lower.contains("pilgrimage") || lower.contains("puja")) {
            experiences.add("Spiritual")
        }
        if (lower.contains("heritage") || lower.contains("fort") || lower.contains("history") || lower.contains("ancient") || lower.contains("monument") || lower.contains("unesco")) {
            experiences.add("Heritage")
        }
        if (lower.contains("adventure") || lower.contains("trek") || lower.contains("camp") || lower.contains("hike") || lower.contains("rock")) {
            experiences.add("Adventure")
        }
        if (lower.contains("waterfall") || lower.contains("falls") || lower.contains("cascade")) {
            experiences.add("Waterfalls")
        }
        if (lower.contains("lake") || lower.contains("boat") || lower.contains("water") || lower.contains("island")) {
            experiences.add("Lakes")
        }
        if (lower.contains("wildlife") || lower.contains("tiger") || lower.contains("safari") || lower.contains("birds") || lower.contains("deer")) {
            experiences.add("Wildlife")
        }
        if (lower.contains("beach") || lower.contains("sea") || lower.contains("coast") || lower.contains("ocean") || lower.contains("sand") || lower.contains("backwater")) {
            experiences.add("Beaches")
        }
        if (lower.contains("mountain") || lower.contains("hill") || lower.contains("ghat") || lower.contains("peak") || lower.contains("valley") || lower.contains("plantation")) {
            experiences.add("Mountains")
        }
        if (experiences.isEmpty()) {
            experiences.add("Nature")
            experiences.add("Heritage")
        }

        // 7. Detect Food Preference
        val foodPreference = if (lower.contains("pure veg") || lower.contains("vegetarian")) {
            "Vegetarian"
        } else if (lower.contains("non-veg") || lower.contains("chicken") || lower.contains("mutton")) {
            "Non-Vegetarian"
        } else {
            "Any"
        }

        // 8. Detect Pace
        val pace = if (lower.contains("relaxed") || lower.contains("slow") || lower.contains("peaceful") || lower.contains("chill")) {
            "Relaxed"
        } else if (lower.contains("fast") || lower.contains("packed") || lower.contains("cover everything")) {
            "Fast-paced"
        } else {
            "Balanced"
        }

        // 9. Weather Preference
        val weatherPreference = if (lower.contains("cold") || lower.contains("chilly") || lower.contains("fog")) {
            "Cold"
        } else if (lower.contains("monsoon") || lower.contains("rain")) {
            "Monsoon"
        } else {
            "Pleasant"
        }

        // 10. Accommodation Preference
        val accommodationPreference = if (lower.contains("resort")) {
            "Resort"
        } else if (lower.contains("homestay")) {
            "Homestay"
        } else if (lower.contains("luxury") || lower.contains("5 star") || lower.contains("heritage hotel")) {
            "Luxury"
        } else if (lower.contains("budget") || lower.contains("cheap") || lower.contains("dorm")) {
            "Budget"
        } else {
            "Mid-Range"
        }

        val travelRequest = TravelRequest(
            origin = origin,
            budget = budget,
            durationDays = days,
            travellerType = travellerType,
            transportMode = transportMode,
            experiences = experiences,
            foodPreference = foodPreference,
            pace = pace,
            weatherPreference = weatherPreference,
            accommodationPreference = accommodationPreference
        )

        // Rank candidate destinations using the 7-factor scoring engine
        val allRanked = DestinationEngine.rankDestinations(
            originCity = origin,
            budget = budget,
            durationDays = days,
            partyType = travellerType,
            preferredVibes = experiences,
            transportMode = transportMode
        )

        // If the user prompt explicitly mentions specific destinations, prioritize them at the top
        val allDestinations = DestinationEngine.getAllDestinations()
        val explicitDestinations = allDestinations.filter { dest ->
            val cleanName = dest.name.substringBefore("(").trim().lowercase()
            val aliasName = if (dest.name.contains("(")) dest.name.substringAfter("(").substringBefore(")").trim().lowercase() else ""
            (cleanName.length >= 3 && lower.contains(cleanName)) ||
            (aliasName.length >= 3 && lower.contains(aliasName)) ||
            lower.contains(dest.name.lowercase()) ||
            (dest.district.isNotBlank() && dest.district.length >= 3 && lower.contains(dest.district.lowercase()))
        }

        val prioritizedCandidates = mutableListOf<com.example.data.model.DestinationMatch>()
        for (explicit in explicitDestinations) {
            val existing = allRanked.find { it.destination.id == explicit.id }
            if (existing != null) {
                prioritizedCandidates.add(existing.copy(matchPercentage = maxOf(95, existing.matchPercentage)))
            } else {
                prioritizedCandidates.add(
                    com.example.data.model.DestinationMatch(
                        destination = explicit,
                        matchPercentage = 95,
                        matchingReasons = listOf("Specifically requested by traveler"),
                        distanceFromOriginKm = explicit.travelRoute.originDistances[origin] ?: 200,
                        estimatedTripCost = budget
                    )
                )
            }
        }

        // Check for hidden gem preference
        val prefersHiddenGems = lower.contains("hidden") ||
                                lower.contains("gem") ||
                                lower.contains("offbeat") ||
                                lower.contains("less crowded") ||
                                lower.contains("not crowded") ||
                                lower.contains("unexplored") ||
                                lower.contains("secret") ||
                                lower.contains("quiet")

        val requestedState = when {
            lower.contains("maharashtra") -> "Maharashtra"
            lower.contains("goa") -> "Goa"
            lower.contains("rajasthan") -> "Rajasthan"
            lower.contains("himachal") -> "Himachal Pradesh"
            lower.contains("uttarakhand") -> "Uttarakhand"
            lower.contains("karnataka") -> "Karnataka"
            lower.contains("tamil nadu") || lower.contains("tamilnadu") -> "Tamil Nadu"
            lower.contains("kerala") -> "Kerala"
            lower.contains("telangana") -> "Telangana"
            lower.contains("andhra") -> "Andhra Pradesh"
            else -> null
        }

        // If user requested hidden gems, sort destinations with DiscoveryLevel.HIDDEN_GEM or OFFBEAT to the front
        val candidateSource = if (prefersHiddenGems) {
            allRanked.sortedByDescending {
                when (it.destination.discoveryLevel) {
                    com.example.data.model.DiscoveryLevel.HIDDEN_GEM -> 100
                    com.example.data.model.DiscoveryLevel.LOCAL_SECRET -> 95
                    com.example.data.model.DiscoveryLevel.OFFBEAT -> 85
                    com.example.data.model.DiscoveryLevel.MODERATE -> 50
                    else -> 20
                }
            }
        } else {
            allRanked
        }

        if (requestedState != null) {
            for (ranked in candidateSource.filter { it.destination.state.equals(requestedState, ignoreCase = true) }) {
                if (prioritizedCandidates.none { it.destination.id == ranked.destination.id }) {
                    prioritizedCandidates.add(ranked)
                }
            }
        }

        for (ranked in candidateSource) {
            if (prioritizedCandidates.none { it.destination.id == ranked.destination.id }) {
                prioritizedCandidates.add(ranked)
            }
        }

        val maxKm = Regex("""(?i)\b(\d+)\s*km\b""").find(prompt)?.groupValues?.get(1)?.toIntOrNull()
        val candidates = prioritizedCandidates.filter { match ->
            maxKm == null || match.destination.travelRoute.originDistances[origin]?.let { it <= maxKm } == true
        }.take(5)

        return ParsedTravelQuery(
            originCity = origin,
            budget = budget,
            durationDays = days,
            partyType = travellerType,
            preferredVibes = experiences,
            candidateMatches = candidates,
            travelRequest = travelRequest
        )
    }
}
