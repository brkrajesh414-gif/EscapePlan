package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TripDao {

    @Query("SELECT * FROM saved_trips ORDER BY savedAt DESC")
    fun getAllSavedTrips(): Flow<List<SavedTripEntity>>

    @Query("SELECT * FROM saved_trips WHERE id = :id LIMIT 1")
    suspend fun getSavedTripById(id: String): SavedTripEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrip(trip: SavedTripEntity)

    @Query("DELETE FROM saved_trips WHERE id = :id")
    suspend fun deleteTrip(id: String)

    @Query("SELECT * FROM favorite_destinations ORDER BY addedAt DESC")
    fun getAllFavorites(): Flow<List<FavoriteDestinationEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(fav: FavoriteDestinationEntity)

    @Query("DELETE FROM favorite_destinations WHERE destinationId = :destinationId")
    suspend fun removeFavorite(destinationId: String)

    @Query("SELECT EXISTS(SELECT 1 FROM favorite_destinations WHERE destinationId = :destinationId)")
    fun isFavorite(destinationId: String): Flow<Boolean>

    @Query("SELECT * FROM saved_hidden_gems ORDER BY addedAt DESC")
    fun getAllSavedHiddenGems(): Flow<List<SavedHiddenGemEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHiddenGem(gem: SavedHiddenGemEntity)

    @Query("DELETE FROM saved_hidden_gems WHERE id = :id")
    suspend fun removeHiddenGem(id: String)
}
