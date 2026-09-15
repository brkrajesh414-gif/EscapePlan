package com.example

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.data.datasource.DestinationsDataSource
import com.example.data.local.AppDatabase
import com.example.data.local.AttractionEntity
import com.example.data.local.DestinationEntity
import com.example.data.local.FoodEntity
import com.example.data.local.HotelEntity
import com.example.data.local.StateEntity
import com.example.data.local.TravelTypeConverters
import com.example.data.local.toDomain
import com.example.data.local.toEntity
import com.example.data.model.DiscoveryLevel
import com.example.data.model.IndiaStatesMaster
import com.example.data.model.StateType
import com.example.data.model.TravelCategory
import com.example.data.model.VerificationLevel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.time.Instant
import java.util.Date
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class RoomTravelCatalogTest {

    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun testInsertAndRetrieveDestination() = runBlocking {
        val dest = DestinationEntity(
            id = "araku-valley",
            name = "Araku Valley",
            state = "Andhra Pradesh",
            district = "Alluri Sitharama Raju",
            tagline = "Misty Coffee Plantations & Eastern Ghats",
            description = "Scenic valley with coffee estates and Borra caves.",
            rating = 4.7f,
            reviewCount = 2100,
            categoriesCsv = "MOUNTAINS,NATURE,ROAD_TRIPS",
            discoveryLevel = "POPULAR",
            latitude = 18.3273,
            longitude = 82.8775,
            bestMonths = "October to March"
        )

        db.destinationDao().insertDestination(dest)

        val retrieved = db.destinationDao().getDestinationByIdDirect("araku-valley")
        assertNotNull("Destination must be retrieved", retrieved)
        assertEquals("Araku Valley", retrieved?.name)
        assertEquals("Andhra Pradesh", retrieved?.state)
        assertEquals(1, db.destinationDao().getDestinationCount())

        val byState = db.destinationDao().getDestinationsByState("Andhra Pradesh").first()
        assertEquals(1, byState.size)
        assertEquals("Araku Valley", byState[0].name)

        val searchResult = db.destinationDao().searchDestinations("coffee").first()
        assertEquals(1, searchResult.size)
    }

    @Test
    fun testAttractionsDaoOperations() = runBlocking {
        val destinationId = "araku-valley"
        val attr1 = AttractionEntity(
            id = "borra-caves",
            destinationId = destinationId,
            name = "Borra Caves",
            category = "Natural Wonder",
            description = "Subterranean limestone karst caves",
            distanceFromDestinationKm = 36.0f,
            entryFeeAdult = "₹80"
        )
        val attr2 = AttractionEntity(
            id = "katiki-waterfalls",
            destinationId = destinationId,
            name = "Katiki Waterfalls",
            category = "Waterfall",
            description = "Perennial cascade on the Gosthani River",
            distanceFromDestinationKm = 39.0f,
            entryFeeAdult = "Free"
        )

        db.attractionDao().insertAttractions(listOf(attr1, attr2))

        val attractions = db.attractionDao().getAttractionsForDestinationDirect(destinationId)
        assertEquals(2, attractions.size)
        assertEquals("Borra Caves", attractions[0].name)
        assertEquals("Katiki Waterfalls", attractions[1].name)
        assertEquals(2, db.attractionDao().getAttractionCount())
    }

    @Test
    fun testFoodDaoOperations() = runBlocking {
        val destinationId = "hyderabad"
        val food1 = FoodEntity(
            id = "hyd_biryani",
            destinationId = destinationId,
            name = "Hyderabadi Dum Biryani",
            cuisine = "Nizami / Hyderabadi",
            description = "Kacchi gosht style slow-cooked rice & aromatic spices",
            isVegetarian = false,
            spiceLevel = "Spicy",
            priceRange = "₹250 - ₹450"
        )
        val food2 = FoodEntity(
            id = "hyd_mirchi_ka_salan",
            destinationId = destinationId,
            name = "Mirchi Ka Salan",
            cuisine = "Hyderabadi",
            description = "Green chili gravy with sesame, peanuts & tamarind",
            isVegetarian = true,
            spiceLevel = "Medium",
            priceRange = "₹120 - ₹200"
        )

        db.foodDao().insertFoods(listOf(food1, food2))

        val allFoods = db.foodDao().getFoodsForDestinationDirect(destinationId)
        assertEquals(2, allFoods.size)

        val vegFoods = db.foodDao().getVegetarianFoodsForDestination(destinationId).first()
        assertEquals(1, vegFoods.size)
        assertEquals("Mirchi Ka Salan", vegFoods[0].name)
    }

    @Test
    fun testHotelDaoOperations() = runBlocking {
        val destinationId = "coorg"
        val hotel1 = HotelEntity(
            id = "coorg_plantation_stay",
            destinationId = destinationId,
            name = "Evolve Back Kabini/Coorg",
            category = "Heritage Resort",
            pricePerNight = 12000,
            priceCategory = "Luxury",
            rating = 4.8f
        )
        val hotel2 = HotelEntity(
            id = "coorg_homestay",
            destinationId = destinationId,
            name = "Estate Heritage Homestay",
            category = "Homestay",
            pricePerNight = 2500,
            priceCategory = "Budget",
            rating = 4.4f
        )

        db.hotelDao().insertHotels(listOf(hotel1, hotel2))

        val allHotels = db.hotelDao().getHotelsForDestinationDirect(destinationId)
        assertEquals(2, allHotels.size)

        val budgetHotels = db.hotelDao().getHotelsWithinBudget(destinationId, 3000).first()
        assertEquals(1, budgetHotels.size)
        assertEquals("Estate Heritage Homestay", budgetHotels[0].name)
    }

    @Test
    fun testRelationalDestinationWithDetails() = runBlocking {
        val dest = DestinationEntity(
            id = "hampi",
            name = "Hampi",
            state = "Karnataka",
            tagline = "UNESCO Vijayanagara Empire Ruins",
            description = "Boulder-strewn capital of the Vijayanagara Empire",
            rating = 4.8f,
            discoveryLevel = "POPULAR"
        )
        db.destinationDao().insertDestination(dest)

        val attr = AttractionEntity(
            id = "virupaksha-temple",
            destinationId = "hampi",
            name = "Virupaksha Temple",
            category = "Heritage"
        )
        db.attractionDao().insertAttraction(attr)

        val food = FoodEntity(
            id = "hampi_thali",
            destinationId = "hampi",
            name = "North Karnataka Jowar Roti Thali",
            cuisine = "Kannada",
            isVegetarian = true
        )
        db.foodDao().insertFood(food)

        val hotel = HotelEntity(
            id = "hampi_heritage_resort",
            destinationId = "hampi",
            name = "Heritage Resort Hampi",
            pricePerNight = 5000
        )
        db.hotelDao().insertHotel(hotel)

        val details = db.destinationDao().getDestinationWithDetailsDirect("hampi")
        assertNotNull("DestinationWithDetails must not be null", details)
        assertEquals("Hampi", details?.destination?.name)
        assertEquals(1, details?.attractions?.size)
        assertEquals("Virupaksha Temple", details?.attractions?.get(0)?.name)
        assertEquals(1, details?.foods?.size)
        assertEquals("North Karnataka Jowar Roti Thali", details?.foods?.get(0)?.name)
        assertEquals(1, details?.hotels?.size)
        assertEquals("Heritage Resort Hampi", details?.hotels?.get(0)?.name)
    }

    @Test
    fun testDomainModelToEntityConversion() = runBlocking {
        val ooty = DestinationsDataSource.getDestinationById("tamilnadu-ooty")
        assertNotNull("Ooty must exist in catalog", ooty)

        val ootyEntity = ooty!!.toEntity()
        assertEquals("tamilnadu-ooty", ootyEntity.id)
        assertEquals("Ooty (Udhagamandalam)", ootyEntity.name)
        assertEquals("Tamil Nadu", ootyEntity.state)

        if (ooty.attractions.isNotEmpty()) {
            val attrEntity = ooty.attractions.first().toEntity(ootyEntity.id)
            assertEquals(ootyEntity.id, attrEntity.destinationId)
            assertTrue(attrEntity.name.isNotBlank())
        }

        if (ooty.stays.isNotEmpty()) {
            val hotelEntity = ooty.stays.first().toEntity(ootyEntity.id)
            assertEquals(ootyEntity.id, hotelEntity.destinationId)
            assertTrue(hotelEntity.name.isNotBlank())
        }
    }

    @Test
    fun testStateDaoOperations() = runBlocking {
        val state1 = StateEntity(
            id = "kerala",
            stateCode = "KL",
            name = "Kerala",
            type = "STATE",
            capital = "Thiruvananthapuram",
            description = "God's Own Country, famed for serene backwaters and tea estates.",
            latitude = 10.8505,
            longitude = 76.2711,
            tourismSummary = "Munnar hills, Alleppey backwaters, and Wayanad rainforests.",
            majorRegionsCsv = "Malabar, Central Travancore, Wayanad",
            bestTravelMonths = "September to March"
        )
        val state2 = StateEntity(
            id = "ladakh",
            stateCode = "LA",
            name = "Ladakh",
            type = "UNION_TERRITORY",
            capital = "Leh",
            description = "High-altitude desert and monasteries.",
            latitude = 34.1526,
            longitude = 77.5771,
            tourismSummary = "Pangong Tso, Nubra Valley, Khardung La.",
            majorRegionsCsv = "Leh, Nubra, Zanskar",
            bestTravelMonths = "June to September"
        )

        db.stateDao().insertStates(listOf(state1, state2))

        val allStates = db.stateDao().getAllStatesDirect()
        assertEquals(2, allStates.size)

        val retrievedKerala = db.stateDao().getStateByIdDirect("kerala")
        assertNotNull("Kerala must exist", retrievedKerala)
        assertEquals("Kerala", retrievedKerala?.name)
        assertEquals("KL", retrievedKerala?.stateCode)

        val retrievedByCode = db.stateDao().getStateByCode("LA")
        assertNotNull("Ladakh must exist by code", retrievedByCode)
        assertEquals("Ladakh", retrievedByCode?.name)

        val unionTerritories = db.stateDao().getStatesByType("UNION_TERRITORY").first()
        assertEquals(1, unionTerritories.size)
        assertEquals("Ladakh", unionTerritories[0].name)

        val searchResult = db.stateDao().searchStates("backwaters").first()
        assertEquals(1, searchResult.size)
        assertEquals("Kerala", searchResult[0].name)
    }

    @Test
    fun testStateWithDestinationsRelationship() = runBlocking {
        val state = StateEntity(
            id = "karnataka",
            stateCode = "KA",
            name = "Karnataka",
            type = "STATE",
            capital = "Bengaluru"
        )
        db.stateDao().insertState(state)

        val dest1 = DestinationEntity(
            id = "coorg",
            stateId = "karnataka",
            name = "Coorg (Kodagu)",
            state = "Karnataka",
            tagline = "Scotland of India"
        )
        val dest2 = DestinationEntity(
            id = "hampi",
            stateId = "karnataka",
            name = "Hampi",
            state = "Karnataka",
            tagline = "UNESCO World Heritage Site"
        )
        db.destinationDao().insertDestinations(listOf(dest1, dest2))

        val stateWithDests = db.stateDao().getStateWithDestinationsDirect("karnataka")
        assertNotNull("StateWithDestinations must not be null", stateWithDests)
        assertEquals("Karnataka", stateWithDests?.state?.name)
        assertEquals(2, stateWithDests?.destinations?.size)
        assertTrue(stateWithDests?.destinations?.any { it.name.startsWith("Coorg") } == true)
        assertTrue(stateWithDests?.destinations?.any { it.name == "Hampi" } == true)
    }

    @Test
    fun testStateWithCompleteDetailsNestedRelationship() = runBlocking {
        val state = StateEntity(
            id = "himachal-pradesh",
            stateCode = "HP",
            name = "Himachal Pradesh",
            type = "STATE",
            capital = "Shimla"
        )
        db.stateDao().insertState(state)

        val dest = DestinationEntity(
            id = "manali",
            stateId = "himachal-pradesh",
            name = "Manali",
            state = "Himachal Pradesh",
            tagline = "Valley of the Gods"
        )
        db.destinationDao().insertDestination(dest)

        val attr = AttractionEntity(
            id = "solang-valley",
            destinationId = "manali",
            name = "Solang Valley",
            category = "Adventure / Snow"
        )
        db.attractionDao().insertAttraction(attr)

        val food = FoodEntity(
            id = "siddu",
            destinationId = "manali",
            name = "Siddu",
            cuisine = "Himachali Pahari",
            isVegetarian = true
        )
        db.foodDao().insertFood(food)

        val hotel = HotelEntity(
            id = "manali_resort",
            destinationId = "manali",
            name = "Span Resort & Spa",
            pricePerNight = 8500
        )
        db.hotelDao().insertHotel(hotel)

        val completeDetails = db.stateDao().getStateWithCompleteDetailsDirect("himachal-pradesh")
        assertNotNull("StateWithCompleteDetails must not be null", completeDetails)
        assertEquals("Himachal Pradesh", completeDetails?.state?.name)
        assertEquals(1, completeDetails?.destinationsWithDetails?.size)

        val destDetails = completeDetails?.destinationsWithDetails?.first()
        assertEquals("Manali", destDetails?.destination?.name)
        assertEquals(1, destDetails?.attractions?.size)
        assertEquals("Solang Valley", destDetails?.attractions?.first()?.name)
        assertEquals(1, destDetails?.foods?.size)
        assertEquals("Siddu", destDetails?.foods?.first()?.name)
        assertEquals(1, destDetails?.hotels?.size)
        assertEquals("Span Resort & Spa", destDetails?.hotels?.first()?.name)
    }

    @Test
    fun testStateModelToEntityConversion() {
        val tnState = IndiaStatesMaster.allStatesAndUTs.first { it.id == "tamil-nadu" }
        val entity = tnState.toEntity()

        assertEquals("tamil-nadu", entity.id)
        assertEquals("TN", entity.stateCode)
        assertEquals("Tamil Nadu", entity.name)
        assertEquals("STATE", entity.type)
        assertEquals("Chennai", entity.capital)

        val restoredDomain = entity.toDomain()
        assertEquals(tnState.id, restoredDomain.id)
        assertEquals(tnState.stateCode, restoredDomain.stateCode)
        assertEquals(tnState.name, restoredDomain.name)
        assertEquals(StateType.STATE, restoredDomain.type)
        assertEquals(tnState.capital, restoredDomain.capital)
    }

    @Test
    fun testTravelTypeConverters() {
        val converters = TravelTypeConverters()

        // List<String>
        val sampleList = listOf("Malabar", "Travancore", "Wayanad")
        val jsonList = converters.fromStringList(sampleList)
        val deserializedList = converters.toStringList(jsonList)
        assertEquals(sampleList, deserializedList)
        assertEquals(emptyList<String>(), converters.toStringList(null))
        assertEquals(listOf("A", "B"), converters.toStringList("A, B"))

        // List<Int>
        val intList = listOf(100, 250, 500)
        val jsonIntList = converters.fromIntList(intList)
        val deserializedIntList = converters.toIntList(jsonIntList)
        assertEquals(intList, deserializedIntList)
        assertEquals(emptyList<Int>(), converters.toIntList(null))

        // TravelCategory
        assertEquals("MOUNTAINS", converters.fromTravelCategory(TravelCategory.MOUNTAINS))
        assertEquals(TravelCategory.BEACHES, converters.toTravelCategory("BEACHES"))
        assertNull(converters.toTravelCategory("NON_EXISTING_CAT"))

        // List<TravelCategory>
        val catList = listOf(TravelCategory.MOUNTAINS, TravelCategory.HERITAGE, TravelCategory.FOOD)
        val jsonCatList = converters.fromTravelCategoryList(catList)
        val deserializedCatList = converters.toTravelCategoryList(jsonCatList)
        assertEquals(catList, deserializedCatList)

        // StateType
        assertEquals("STATE", converters.fromStateType(StateType.STATE))
        assertEquals("UNION_TERRITORY", converters.fromStateType(StateType.UNION_TERRITORY))
        assertEquals(StateType.STATE, converters.toStateType("STATE"))
        assertEquals(StateType.UNION_TERRITORY, converters.toStateType("UNION_TERRITORY"))

        // DiscoveryLevel & VerificationLevel
        assertEquals("HIDDEN_GEM", converters.fromDiscoveryLevel(DiscoveryLevel.HIDDEN_GEM))
        assertEquals(DiscoveryLevel.HIDDEN_GEM, converters.toDiscoveryLevel("HIDDEN_GEM"))
        assertEquals("TRUSTED", converters.fromVerificationLevel(VerificationLevel.TRUSTED))
        assertEquals(VerificationLevel.TRUSTED, converters.toVerificationLevel("TRUSTED"))

        // Date & Instant
        val now = Date()
        val timeLong = converters.fromDate(now)
        val restoredDate = converters.toDate(timeLong)
        assertEquals(now.time, restoredDate?.time)

        val nowInstant = Instant.now()
        val instantMillis = converters.fromInstant(nowInstant)
        val restoredInstant = converters.toInstant(instantMillis)
        assertEquals(nowInstant.toEpochMilli(), restoredInstant?.toEpochMilli())
    }

    @Test
    fun testAppDatabaseSafePreseedInitialization() = runBlocking {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val freshDb = AppDatabase.buildInMemory(context)

        assertEquals(0, freshDb.stateDao().getStateCount())
        assertEquals(0, freshDb.destinationDao().getDestinationCount())

        // Execute safe preseed
        AppDatabase.preseedCatalogData(freshDb)

        val stateCount = freshDb.stateDao().getStateCount()
        assertTrue("All states & UTs should be preseeded", stateCount >= 36)

        val destCount = freshDb.destinationDao().getDestinationCount()
        assertTrue("Destinations should be preseeded", destCount > 0)

        val attractionCount = freshDb.attractionDao().getAttractionCount()
        assertTrue("Attractions should be preseeded", attractionCount > 0)

        // Verify idempotency: running preseed again should not duplicate rows
        AppDatabase.preseedCatalogData(freshDb)
        assertEquals(stateCount, freshDb.stateDao().getStateCount())
        assertEquals(destCount, freshDb.destinationDao().getDestinationCount())

        freshDb.close()
    }
}

