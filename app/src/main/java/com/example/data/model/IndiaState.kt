package com.example.data.model

enum class StateType(val displayName: String) {
    STATE("State"),
    UNION_TERRITORY("Union Territory")
}

data class IndiaState(
    val id: String,
    val stateCode: String,
    val name: String,
    val type: StateType,
    val capital: String,
    val description: String,
    val latitude: Double,
    val longitude: Double,
    val tourismSummary: String,
    val majorRegions: List<String>,
    val bestTravelMonths: String,
    val imageUrl: String = ""
)

object IndiaStatesMaster {
    val allStatesAndUTs: List<IndiaState> = listOf(
        // 28 States
        IndiaState(
            id = "andhra-pradesh",
            stateCode = "AP",
            name = "Andhra Pradesh",
            type = StateType.STATE,
            capital = "Amaravati",
            description = "Known for historic temples, eastern ghat hills, the scenic coast, and the grand canyon of Gandikota.",
            latitude = 15.9129,
            longitude = 79.7400,
            tourismSummary = "Araku Valley, Tirupati Balaji, Gandikota gorge, Borra Caves, and pristine coastal trails.",
            majorRegions = listOf("Rayalaseema", "Coastal Andhra", "Uttarandhra"),
            bestTravelMonths = "October to March"
        ),
        IndiaState(
            id = "arunachal-pradesh",
            stateCode = "AR",
            name = "Arunachal Pradesh",
            type = StateType.STATE,
            capital = "Itanagar",
            description = "Land of the Dawn-Lit Mountains with mist-shrouded valleys, high-altitude passes, and Tibetan monasteries.",
            latitude = 28.2180,
            longitude = 94.7278,
            tourismSummary = "Tawang Monastery, Ziro Valley music & paddy fields, Namdapha national park, and Sela Pass.",
            majorRegions = listOf("Tawang", "West Kameng", "Ziro Valley", "Siang Valley"),
            bestTravelMonths = "October to April"
        ),
        IndiaState(
            id = "assam",
            stateCode = "AS",
            name = "Assam",
            type = StateType.STATE,
            capital = "Dispur",
            description = "Gateway to Northeast India, famous for one-horned rhinos, emerald tea gardens, and the Brahmaputra River.",
            latitude = 26.2006,
            longitude = 92.9376,
            tourismSummary = "Kaziranga National Park, Majuli river island, Kamakhya Temple, and Manas Tiger Reserve.",
            majorRegions = listOf("Brahmaputra Valley", "Barak Valley", "Upper Assam"),
            bestTravelMonths = "November to April"
        ),
        IndiaState(
            id = "bihar",
            stateCode = "BR",
            name = "Bihar",
            type = StateType.STATE,
            capital = "Patna",
            description = "Cradle of Buddhism and Jainism, home to ancient Nalanda University and Mahabodhi Temple.",
            latitude = 25.0961,
            longitude = 85.3131,
            tourismSummary = "Bodh Gaya, Nalanda archaeological ruins, Rajgir ropeway & hot springs, and Vaishali.",
            majorRegions = listOf("Magadh", "Mithila", "Bhojpur", "Anga"),
            bestTravelMonths = "October to March"
        ),
        IndiaState(
            id = "chhattisgarh",
            stateCode = "CG",
            name = "Chhattisgarh",
            type = StateType.STATE,
            capital = "Raipur",
            description = "Dense tribal heartland with spectacular horseshoe waterfalls, unexplored limestone caves, and ancient temples.",
            latitude = 21.2787,
            longitude = 81.8661,
            tourismSummary = "Chitrakote Falls (Niagara of India), Tirathgarh Falls, Bastar tribal craft, and Kanger Valley.",
            majorRegions = listOf("Bastar", "Surguja", "Raipur Plains"),
            bestTravelMonths = "October to March"
        ),
        IndiaState(
            id = "goa",
            stateCode = "GA",
            name = "Goa",
            type = StateType.STATE,
            capital = "Panaji",
            description = "Coastal paradise blending Portuguese architecture, golden sand beaches, spice farms, and jungle waterfalls.",
            latitude = 15.2993,
            longitude = 74.1240,
            tourismSummary = "Dudhsagar Falls, Fontainhas Latin Quarter, hidden South Goa coves, and Netravali bubbling lake.",
            majorRegions = listOf("North Goa", "South Goa", "Western Ghats Hinterland"),
            bestTravelMonths = "November to March"
        ),
        IndiaState(
            id = "gujarat",
            stateCode = "GJ",
            name = "Gujarat",
            type = StateType.STATE,
            capital = "Gandhinagar",
            description = "Vibrant state of the Great Rann white desert, Asiatic lions, stepwells, and rich textile traditions.",
            latitude = 22.2587,
            longitude = 71.1924,
            tourismSummary = "Gir National Park, Rann of Kutch, Rani ki Vav stepwell, Dwarka, and Somnath.",
            majorRegions = listOf("Kutch", "Saurashtra", "North Gujarat", "South Gujarat"),
            bestTravelMonths = "October to March"
        ),
        IndiaState(
            id = "haryana",
            stateCode = "HR",
            name = "Haryana",
            type = StateType.STATE,
            capital = "Chandigarh",
            description = "Historic land of Kurukshetra, sacred sarovars, Yadavindra Mughal gardens, and birding wetlands.",
            latitude = 29.0588,
            longitude = 76.0856,
            tourismSummary = "Sultanpur Bird Sanctuary, Kurukshetra Brahma Sarovar, Pinjore Gardens, and Morni Hills.",
            majorRegions = listOf("Shivalik Belt", "NCR Region", "Central Plains"),
            bestTravelMonths = "October to March"
        ),
        IndiaState(
            id = "himachal-pradesh",
            stateCode = "HP",
            name = "Himachal Pradesh",
            type = StateType.STATE,
            capital = "Shimla",
            description = "Land of the snowy peaks, pine-clad valleys, apple orchards, high passes, and mountain adventures.",
            latitude = 31.1048,
            longitude = 77.1734,
            tourismSummary = "Spiti Valley, Manali, Kasol, Jibhi, Dharamshala, Dalhousie, and Great Himalayan National Park.",
            majorRegions = listOf("Kullu & Manali", "Kangra Valley", "Lahaul & Spiti", "Shimla Hills"),
            bestTravelMonths = "March to June & September to December"
        ),
        IndiaState(
            id = "jharkhand",
            stateCode = "JH",
            name = "Jharkhand",
            type = StateType.STATE,
            capital = "Ranchi",
            description = "Land of forests, tiered waterfalls, sacred Jain hills, and tranquil plateaus.",
            latitude = 23.6102,
            longitude = 85.2799,
            tourismSummary = "Hundru Falls, Jonha Falls, Betla National Park, Netarhat hill sunrise, and Parasnath Shikharji.",
            majorRegions = listOf("Chota Nagpur Plateau", "Santhal Parganas", "Kolhan"),
            bestTravelMonths = "October to March"
        ),
        IndiaState(
            id = "karnataka",
            stateCode = "KA",
            name = "Karnataka",
            type = StateType.STATE,
            capital = "Bengaluru",
            description = "Diverse terrain encompassing UNESCO ruins, Western Ghats coffee highlands, and golden Arabian shores.",
            latitude = 15.3173,
            longitude = 75.7139,
            tourismSummary = "Hampi, Coorg, Chikkamagaluru, Gokarna, Badami, Kabini, and Mysuru Palace.",
            majorRegions = listOf("Malnad", "Coastal Karavali", "Old Mysuru", "Kalyana Karnataka"),
            bestTravelMonths = "September to March"
        ),
        IndiaState(
            id = "kerala",
            stateCode = "KL",
            name = "Kerala",
            type = StateType.STATE,
            capital = "Thiruvananthapuram",
            description = "God's Own Country, famed for serene backwaters, rolling tea estates, spice plantations, and Ayurvedic retreats.",
            latitude = 10.8505,
            longitude = 76.2711,
            tourismSummary = "Alappuzha houseboats, Munnar tea hills, Wayanad rainforests, Kochi Fort, and Varkala cliffs.",
            majorRegions = listOf("Malabar", "Central Backwaters", "Travancore", "High Ranges"),
            bestTravelMonths = "September to March"
        ),
        IndiaState(
            id = "madhya-pradesh",
            stateCode = "MP",
            name = "Madhya Pradesh",
            type = StateType.STATE,
            capital = "Bhopal",
            description = "Heart of India, rich in premier tiger reserves, Khajuraho erotic temple sculptures, and ancient stupas.",
            latitude = 22.9734,
            longitude = 78.6569,
            tourismSummary = "Kanha & Bandhavgarh, Khajuraho temples, Sanchi Stupa, Pachmarhi hill retreat, and Bhedaghat marble rocks.",
            majorRegions = listOf("Malwa", "Bundelkhand", "Baghelkhand", "Mahakoshal"),
            bestTravelMonths = "October to March"
        ),
        IndiaState(
            id = "maharashtra",
            stateCode = "MH",
            name = "Maharashtra",
            type = StateType.STATE,
            capital = "Mumbai",
            description = "Land of the Sahyadri mountains, ancient rock-cut caves, Maratha sea forts, and hidden monsoon waterfalls.",
            latitude = 19.7515,
            longitude = 75.7139,
            tourismSummary = "Devkund Waterfall, Lonavala, Kaas Plateau, Ajanta & Ellora, Malshej Ghat, Tadoba, and Bhandardara.",
            majorRegions = listOf("Konkan Coast", "Western Ghats (Sahyadris)", "Marathwada", "Vidarbha", "Desh"),
            bestTravelMonths = "July to February"
        ),
        IndiaState(
            id = "manipur",
            stateCode = "MN",
            name = "Manipur",
            type = StateType.STATE,
            capital = "Imphal",
            description = "Jeweled land renowned for the floating phumdis of Loktak Lake and vibrant classical dance traditions.",
            latitude = 24.6637,
            longitude = 93.9063,
            tourismSummary = "Loktak Lake & Keibul Lamjao national park, Kangla Fort, Ima Keithel women market, and Ukhrul hills.",
            majorRegions = listOf("Imphal Valley", "Churachandpur", "Ukhrul"),
            bestTravelMonths = "October to March"
        ),
        IndiaState(
            id = "meghalaya",
            stateCode = "ML",
            name = "Meghalaya",
            type = StateType.STATE,
            capital = "Shillong",
            description = "Abode of the Clouds, featuring living root bridges, crystal clear rivers, and roaring waterfalls.",
            latitude = 25.4670,
            longitude = 91.3662,
            tourismSummary = "Cherrapunji, Nohkalikai Falls, Dawki Umngot river, Mawlynnong clean village, and double decker root bridge.",
            majorRegions = listOf("Khasi Hills", "Jaintia Hills", "Garo Hills"),
            bestTravelMonths = "October to April"
        ),
        IndiaState(
            id = "mizoram",
            stateCode = "MZ",
            name = "Mizoram",
            type = StateType.STATE,
            capital = "Aizawl",
            description = "Land of rolling emerald hills, bamboo forests, blue mountain peaks, and warm tribal hospitality.",
            latitude = 23.1645,
            longitude = 92.9376,
            tourismSummary = "Phawngpui Blue Mountain, Vantawng Falls, Tamdil Lake, and Reiek Tlang cliff viewpoint.",
            majorRegions = listOf("Aizawl Region", "Lunglei", "Champhai"),
            bestTravelMonths = "October to March"
        ),
        IndiaState(
            id = "nagaland",
            stateCode = "NL",
            name = "Nagaland",
            type = StateType.STATE,
            capital = "Kohima",
            description = "Land of vibrant tribal festivals, pristine valleys of flowers, and dramatic hill crests.",
            latitude = 26.1584,
            longitude = 94.5624,
            tourismSummary = "Hornbill Festival at Kisama, Dzukou Valley trek, Kohima War Cemetery, and Khonoma green village.",
            majorRegions = listOf("Kohima", "Mokokchung", "Mon", "Wokha"),
            bestTravelMonths = "October to May"
        ),
        IndiaState(
            id = "odisha",
            stateCode = "OD",
            name = "Odisha",
            type = StateType.STATE,
            capital = "Bhubaneswar",
            description = "Sacred temple architecture, Chilika lake dolphin lagoon, Konark sun chariot, and tribal art.",
            latitude = 20.9517,
            longitude = 85.0985,
            tourismSummary = "Puri Jagannath Temple, Konark Sun Temple, Chilika Lake lagoon, Simlipal Tiger Reserve, and Dhauli.",
            majorRegions = listOf("Coastal Odisha", "Northern Plateau", "Western Hills"),
            bestTravelMonths = "October to March"
        ),
        IndiaState(
            id = "punjab",
            stateCode = "PB",
            name = "Punjab",
            type = StateType.STATE,
            capital = "Chandigarh",
            description = "Land of five rivers, sacred Golden Temple, vibrant mustard fields, and rich culinary hospitality.",
            latitude = 31.1471,
            longitude = 75.3412,
            tourismSummary = "Amritsar Golden Temple, Wagah Border ceremony, Jallianwala Bagh, and Patiala heritage palaces.",
            majorRegions = listOf("Majha", "Doaba", "Malwa"),
            bestTravelMonths = "October to March"
        ),
        IndiaState(
            id = "rajasthan",
            stateCode = "RJ",
            name = "Rajasthan",
            type = StateType.STATE,
            capital = "Jaipur",
            description = "Land of Maharajas, imposing desert forts, palace lakes, vibrant bazaars, and sand dunes.",
            latitude = 27.0238,
            longitude = 74.2179,
            tourismSummary = "Jaipur Pink City, Udaipur Lake Palace, Jodhpur Blue City, Jaisalmer dunes, and Kumbhalgarh Fort.",
            majorRegions = listOf("Mewar", "Marwar", "Shekhawati", "Dhundhar", "Hadoti"),
            bestTravelMonths = "October to March"
        ),
        IndiaState(
            id = "sikkim",
            stateCode = "SK",
            name = "Sikkim",
            type = StateType.STATE,
            capital = "Gangtok",
            description = "Himalayan kingdom dominated by Mount Kanchenjunga, sacred alpine lakes, and rhododendron valleys.",
            latitude = 27.5330,
            longitude = 88.5122,
            tourismSummary = "Tsomgo Lake, Nathula Pass, Yumthang Valley of Flowers, Gurudongmar Lake, and Rumtek Monastery.",
            majorRegions = listOf("East Sikkim", "West Sikkim", "North Sikkim", "South Sikkim"),
            bestTravelMonths = "March to May & October to December"
        ),
        IndiaState(
            id = "tamil-nadu",
            stateCode = "TN",
            name = "Tamil Nadu",
            type = StateType.STATE,
            capital = "Chennai",
            description = "Dravidian heritage powerhouse with soaring temple gopurams, misty Nilgiri tea hills, and Bay of Bengal shores.",
            latitude = 11.1271,
            longitude = 78.6569,
            tourismSummary = "Meenakshi Temple Madurai, Brihadisvara Thanjavur, Ooty, Kodaikanal, Mahabalipuram, and Dhanushkodi.",
            majorRegions = listOf("Chola Heartland", "Pandya Country", "Kongu Nadu", "Nilgiris & Western Ghats"),
            bestTravelMonths = "October to March"
        ),
        IndiaState(
            id = "telangana",
            stateCode = "TG",
            name = "Telangana",
            type = StateType.STATE,
            capital = "Hyderabad",
            description = "Land of Kakatiya stonework, Nizam palaces, iconic Biryani, dramatic reservoirs, and Ananthagiri hills.",
            latitude = 18.1124,
            longitude = 79.0193,
            tourismSummary = "Charminar, Golconda Fort, Ramappa Temple (UNESCO), Warangal, Kuntala Falls, and Nagarjuna Sagar.",
            majorRegions = listOf("Hyderabad Metropolis", "Northern Telangana", "Southern Telangana"),
            bestTravelMonths = "October to March"
        ),
        IndiaState(
            id = "tripura",
            stateCode = "TR",
            name = "Tripura",
            type = StateType.STATE,
            capital = "Agartala",
            description = "Enchanting kingdom of floating water palaces, sacred rock sculptures, and green bamboo valleys.",
            latitude = 23.9408,
            longitude = 91.9882,
            tourismSummary = "Neermahal Water Palace, Ujjayanta Palace, Unakoti rock carvings, and Jampui Hills.",
            majorRegions = listOf("Agartala Plains", "Jampui Range", "South Tripura"),
            bestTravelMonths = "October to March"
        ),
        IndiaState(
            id = "uttar-pradesh",
            stateCode = "UP",
            name = "Uttar Pradesh",
            type = StateType.STATE,
            capital = "Lucknow",
            description = "Spiritual epicentre along the sacred Ganges, home to the Taj Mahal, Varanasi ghats, and Awadhi culture.",
            latitude = 26.8467,
            longitude = 80.9462,
            tourismSummary = "Taj Mahal Agra, Varanasi Ghats, Ayodhya Ram Mandir, Lucknow Imambara, and Prayagraj Triveni Sangam.",
            majorRegions = listOf("Awadh", "Braj", "Purvanchal", "Bundelkhand", "Rohilkhand"),
            bestTravelMonths = "October to March"
        ),
        IndiaState(
            id = "uttarakhand",
            stateCode = "UK",
            name = "Uttarakhand",
            type = StateType.STATE,
            capital = "Dehradun",
            description = "Devbhoomi (Land of the Gods), featuring Himalayan pilgrimages, river rafting, and alpine meadows.",
            latitude = 30.0668,
            longitude = 79.0193,
            tourismSummary = "Rishikesh yoga & rafting, Valley of Flowers, Kedarnath & Badrinath, Chopta Tungnath, and Jim Corbett.",
            majorRegions = listOf("Garhwal", "Kumaon"),
            bestTravelMonths = "March to June & September to November"
        ),
        IndiaState(
            id = "west-bengal",
            stateCode = "WB",
            name = "West Bengal",
            type = StateType.STATE,
            capital = "Kolkata",
            description = "Spanning from the snowline of Darjeeling Himalayas to the mangrove tiger forests of the Sundarbans.",
            latitude = 22.9868,
            longitude = 87.8550,
            tourismSummary = "Darjeeling Himalayan Railway, Sundarbans mangrove safari, Kolkata colonial heritage, and Kalimpong.",
            majorRegions = listOf("North Bengal Hills", "Rarh Region", "Sundarbans Delta", "Kolkata Urban"),
            bestTravelMonths = "October to March"
        ),

        // 8 Union Territories
        IndiaState(
            id = "andaman-and-nicobar-islands",
            stateCode = "AN",
            name = "Andaman and Nicobar Islands",
            type = StateType.UNION_TERRITORY,
            capital = "Port Blair",
            description = "Tropical island archipelago of turquoise lagoons, bioluminescent night waters, coral reefs, and Cellular Jail.",
            latitude = 11.7401,
            longitude = 92.6586,
            tourismSummary = "Havelock (Swaraj Dweep) Radhanagar Beach, Neil Island, Cellular Jail sound & light, and scuba diving.",
            majorRegions = listOf("South Andaman", "Havelock & Neil", "North & Middle Andaman"),
            bestTravelMonths = "October to May"
        ),
        IndiaState(
            id = "chandigarh",
            stateCode = "CH",
            name = "Chandigarh",
            type = StateType.UNION_TERRITORY,
            capital = "Chandigarh",
            description = "India's premier planned modernist city designed by Le Corbusier, famous for the Nek Chand Rock Garden.",
            latitude = 30.7333,
            longitude = 76.7794,
            tourismSummary = "Rock Garden, Sukhna Lake boating, Zakir Hussain Rose Garden, and Capitol Complex.",
            majorRegions = listOf("City Centre", "Sukhna Lake Belt"),
            bestTravelMonths = "October to March"
        ),
        IndiaState(
            id = "dadra-and-nagar-haveli-and-daman-and-diu",
            stateCode = "DN",
            name = "Dadra and Nagar Haveli and Daman and Diu",
            type = StateType.UNION_TERRITORY,
            capital = "Daman",
            description = "Former Portuguese coastal enclaves featuring historic sea forts, quiet casuarina beaches, and forest gardens.",
            latitude = 20.4283,
            longitude = 72.8397,
            tourismSummary = "Diu Fort, Naida Caves, Nagoa Beach, Daman Moti Fort, and Silvassa tribal museum.",
            majorRegions = listOf("Daman", "Diu Island", "Dadra & Nagar Haveli"),
            bestTravelMonths = "October to March"
        ),
        IndiaState(
            id = "delhi",
            stateCode = "DL",
            name = "Delhi",
            type = StateType.UNION_TERRITORY,
            capital = "New Delhi",
            description = "National capital region spanning eight centuries of Mughal, Sultanate, and colonial monumental architecture.",
            latitude = 28.7041,
            longitude = 77.1025,
            tourismSummary = "Qutub Minar, Red Fort, Humayun Tomb, India Gate, Chandni Chowk food walks, and Akshardham.",
            majorRegions = listOf("Old Delhi", "New Delhi Lutyens", "South Delhi Heritage"),
            bestTravelMonths = "October to March"
        ),
        IndiaState(
            id = "jammu-and-kashmir",
            stateCode = "JK",
            name = "Jammu and Kashmir",
            type = StateType.UNION_TERRITORY,
            capital = "Srinagar (Summer) / Jammu (Winter)",
            description = "Paradise on Earth with Dal Lake shikaras, floating gardens, snow meadows of Gulmarg, and saffron fields.",
            latitude = 33.7782,
            longitude = 76.5762,
            tourismSummary = "Dal Lake Srinagar, Gulmarg gondola, Pahalgam Betaab Valley, Sonamarg, and Vaishno Devi shrine.",
            majorRegions = listOf("Kashmir Valley", "Jammu Foothills", "Pir Panjal"),
            bestTravelMonths = "March to October & December to February (Snow)"
        ),
        IndiaState(
            id = "ladakh",
            stateCode = "LA",
            name = "Ladakh",
            type = StateType.UNION_TERRITORY,
            capital = "Leh",
            description = "High-altitude desert kingdom with stark moonscapes, turquoise glacial lakes, and cliffside gompas.",
            latitude = 34.1526,
            longitude = 77.5771,
            tourismSummary = "Pangong Tso, Nubra Valley sand dunes & Bactrian camels, Khardung La pass, and Thiksey Monastery.",
            majorRegions = listOf("Leh Valley", "Nubra Valley", "Changthang Lake Belt", "Zanskar"),
            bestTravelMonths = "May to September"
        ),
        IndiaState(
            id = "lakshadweep",
            stateCode = "LD",
            name = "Lakshadweep",
            type = StateType.UNION_TERRITORY,
            capital = "Kavaratti",
            description = "Pristine coral atoll archipelago in the Arabian Sea with transparent lagoons and rich marine ecology.",
            latitude = 10.5667,
            longitude = 72.6417,
            tourismSummary = "Agatti Island coral reef, Bangaram lagoon, Kavaratti lighthouse, and snorkeling safaris.",
            majorRegions = listOf("Agatti & Bangaram", "Kavaratti", "Minicoy"),
            bestTravelMonths = "October to mid-May"
        ),
        IndiaState(
            id = "puducherry",
            stateCode = "PY",
            name = "Puducherry",
            type = StateType.UNION_TERRITORY,
            capital = "Puducherry",
            description = "Charming French colonial quarter with bougainvillea-lined avenues, Auroville international township, and beaches.",
            latitude = 11.9416,
            longitude = 79.8083,
            tourismSummary = "White Town French Quarter, Auroville Matrimandir, Promenade Beach, and Paradise Beach boat cruise.",
            majorRegions = listOf("White Town & Promenade", "Auroville", "Karaikal"),
            bestTravelMonths = "October to March"
        )
    )

    fun getStateByName(name: String): IndiaState? {
        return allStatesAndUTs.find { it.name.equals(name, ignoreCase = true) }
    }

    fun getStateByCode(code: String): IndiaState? {
        return allStatesAndUTs.find { it.stateCode.equals(code, ignoreCase = true) }
    }

    fun getAllNames(): List<String> {
        return allStatesAndUTs.map { it.name }
    }
}
