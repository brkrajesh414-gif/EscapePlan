package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface DestinationDao {

    @Query("SELECT * FROM destinations ORDER BY rating DESC, name ASC")
    fun getAllDestinations(): Flow<List<DestinationEntity>>

    @Query("SELECT * FROM destinations ORDER BY rating DESC, name ASC")
    suspend fun getAllDestinationsDirect(): List<DestinationEntity>

    @Query("SELECT * FROM destinations WHERE id = :id LIMIT 1")
    fun getDestinationById(id: String): Flow<DestinationEntity?>

    @Query("SELECT * FROM destinations WHERE id = :id LIMIT 1")
    suspend fun getDestinationByIdDirect(id: String): DestinationEntity?

    @Query("SELECT * FROM destinations WHERE state = :state ORDER BY rating DESC")
    fun getDestinationsByState(state: String): Flow<List<DestinationEntity>>

    @Query("SELECT * FROM destinations WHERE discoveryLevel = :discoveryLevel ORDER BY rating DESC")
    fun getDestinationsByDiscoveryLevel(discoveryLevel: String): Flow<List<DestinationEntity>>

    @Query("""
        SELECT * FROM destinations 
        WHERE name LIKE '%' || :query || '%' 
           OR district LIKE '%' || :query || '%' 
           OR state LIKE '%' || :query || '%'
           OR tagline LIKE '%' || :query || '%'
        ORDER BY rating DESC
    """)
    fun searchDestinations(query: String): Flow<List<DestinationEntity>>

    @Query("SELECT COUNT(*) FROM destinations")
    suspend fun getDestinationCount(): Int

    @Transaction
    @Query("SELECT * FROM destinations WHERE id = :id LIMIT 1")
    fun getDestinationWithDetails(id: String): Flow<DestinationWithDetails?>

    @Transaction
    @Query("SELECT * FROM destinations WHERE id = :id LIMIT 1")
    suspend fun getDestinationWithDetailsDirect(id: String): DestinationWithDetails?

    @Transaction
    @Query("SELECT * FROM destinations WHERE state = :state ORDER BY rating DESC")
    fun getDestinationsWithDetailsByState(state: String): Flow<List<DestinationWithDetails>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDestination(destination: DestinationEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDestinations(destinations: List<DestinationEntity>)

    @Query("DELETE FROM destinations WHERE id = :id")
    suspend fun deleteDestinationById(id: String)

    @Query("DELETE FROM destinations")
    suspend fun clearAllDestinations()
}

@Dao
interface AttractionDao {

    @Query("SELECT * FROM attractions WHERE destinationId = :destinationId ORDER BY distanceFromDestinationKm ASC")
    fun getAttractionsForDestination(destinationId: String): Flow<List<AttractionEntity>>

    @Query("SELECT * FROM attractions WHERE destinationId = :destinationId ORDER BY distanceFromDestinationKm ASC")
    suspend fun getAttractionsForDestinationDirect(destinationId: String): List<AttractionEntity>

    @Query("SELECT * FROM attractions WHERE id = :id LIMIT 1")
    fun getAttractionById(id: String): Flow<AttractionEntity?>

    @Query("SELECT * FROM attractions WHERE id = :id LIMIT 1")
    suspend fun getAttractionByIdDirect(id: String): AttractionEntity?

    @Query("SELECT * FROM attractions WHERE destinationId = :destinationId AND category = :category")
    fun getAttractionsByCategory(destinationId: String, category: String): Flow<List<AttractionEntity>>

    @Query("SELECT COUNT(*) FROM attractions")
    suspend fun getAttractionCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAttraction(attraction: AttractionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAttractions(attractions: List<AttractionEntity>)

    @Query("DELETE FROM attractions WHERE destinationId = :destinationId")
    suspend fun deleteAttractionsForDestination(destinationId: String)

    @Query("DELETE FROM attractions WHERE id = :id")
    suspend fun deleteAttractionById(id: String)

    @Query("DELETE FROM attractions")
    suspend fun clearAllAttractions()
}

@Dao
interface FoodDao {

    @Query("SELECT * FROM foods WHERE destinationId = :destinationId ORDER BY isVegetarian DESC, name ASC")
    fun getFoodsForDestination(destinationId: String): Flow<List<FoodEntity>>

    @Query("SELECT * FROM foods WHERE destinationId = :destinationId ORDER BY isVegetarian DESC, name ASC")
    suspend fun getFoodsForDestinationDirect(destinationId: String): List<FoodEntity>

    @Query("SELECT * FROM foods WHERE destinationId = :destinationId AND isVegetarian = 1")
    fun getVegetarianFoodsForDestination(destinationId: String): Flow<List<FoodEntity>>

    @Query("SELECT * FROM foods WHERE id = :id LIMIT 1")
    suspend fun getFoodById(id: String): FoodEntity?

    @Query("SELECT COUNT(*) FROM foods")
    suspend fun getFoodCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood(food: FoodEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoods(foods: List<FoodEntity>)

    @Query("DELETE FROM foods WHERE destinationId = :destinationId")
    suspend fun deleteFoodsForDestination(destinationId: String)

    @Query("DELETE FROM foods WHERE id = :id")
    suspend fun deleteFoodById(id: String)

    @Query("DELETE FROM foods")
    suspend fun clearAllFoods()
}

@Dao
interface HotelDao {

    @Query("SELECT * FROM hotels WHERE destinationId = :destinationId ORDER BY rating DESC, pricePerNight ASC")
    fun getHotelsForDestination(destinationId: String): Flow<List<HotelEntity>>

    @Query("SELECT * FROM hotels WHERE destinationId = :destinationId ORDER BY rating DESC, pricePerNight ASC")
    suspend fun getHotelsForDestinationDirect(destinationId: String): List<HotelEntity>

    @Query("SELECT * FROM hotels WHERE destinationId = :destinationId AND pricePerNight <= :maxBudget ORDER BY pricePerNight ASC")
    fun getHotelsWithinBudget(destinationId: String, maxBudget: Int): Flow<List<HotelEntity>>

    @Query("SELECT * FROM hotels WHERE destinationId = :destinationId AND priceCategory = :category")
    fun getHotelsByCategory(destinationId: String, category: String): Flow<List<HotelEntity>>

    @Query("SELECT * FROM hotels WHERE id = :id LIMIT 1")
    suspend fun getHotelById(id: String): HotelEntity?

    @Query("SELECT COUNT(*) FROM hotels")
    suspend fun getHotelCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHotel(hotel: HotelEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHotels(hotels: List<HotelEntity>)

    @Query("DELETE FROM hotels WHERE destinationId = :destinationId")
    suspend fun deleteHotelsForDestination(destinationId: String)

    @Query("DELETE FROM hotels WHERE id = :id")
    suspend fun deleteHotelById(id: String)

    @Query("DELETE FROM hotels")
    suspend fun clearAllHotels()
}

@Dao
interface StateDao {

    @Query("SELECT * FROM states ORDER BY name ASC")
    fun getAllStates(): Flow<List<StateEntity>>

    @Query("SELECT * FROM states ORDER BY name ASC")
    suspend fun getAllStatesDirect(): List<StateEntity>

    @Query("SELECT * FROM states WHERE type = :type ORDER BY name ASC")
    fun getStatesByType(type: String): Flow<List<StateEntity>>

    @Query("SELECT * FROM states WHERE id = :id LIMIT 1")
    fun getStateById(id: String): Flow<StateEntity?>

    @Query("SELECT * FROM states WHERE id = :id LIMIT 1")
    suspend fun getStateByIdDirect(id: String): StateEntity?

    @Query("SELECT * FROM states WHERE stateCode = :code LIMIT 1")
    suspend fun getStateByCode(code: String): StateEntity?

    @Query("""
        SELECT * FROM states 
        WHERE name LIKE '%' || :query || '%' 
           OR capital LIKE '%' || :query || '%' 
           OR stateCode LIKE '%' || :query || '%' 
           OR tourismSummary LIKE '%' || :query || '%'
        ORDER BY name ASC
    """)
    fun searchStates(query: String): Flow<List<StateEntity>>

    @Query("SELECT COUNT(*) FROM states")
    suspend fun getStateCount(): Int

    @Transaction
    @Query("SELECT * FROM states WHERE id = :id LIMIT 1")
    fun getStateWithDestinations(id: String): Flow<StateWithDestinations?>

    @Transaction
    @Query("SELECT * FROM states WHERE id = :id LIMIT 1")
    suspend fun getStateWithDestinationsDirect(id: String): StateWithDestinations?

    @Transaction
    @Query("SELECT * FROM states ORDER BY name ASC")
    fun getAllStatesWithDestinations(): Flow<List<StateWithDestinations>>

    @Transaction
    @Query("SELECT * FROM states WHERE id = :id LIMIT 1")
    fun getStateWithCompleteDetails(id: String): Flow<StateWithCompleteDetails?>

    @Transaction
    @Query("SELECT * FROM states WHERE id = :id LIMIT 1")
    suspend fun getStateWithCompleteDetailsDirect(id: String): StateWithCompleteDetails?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertState(state: StateEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStates(states: List<StateEntity>)

    @Query("DELETE FROM states WHERE id = :id")
    suspend fun deleteStateById(id: String)

    @Query("DELETE FROM states")
    suspend fun clearAllStates()
}

