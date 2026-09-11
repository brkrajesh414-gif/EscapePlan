package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_trips")
data class SavedTripEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val destinationName: String,
    val originCity: String,
    val durationDays: Int,
    val totalBudget: Int,
    val tripType: String,
    val summary: String,
    val itineraryJson: String,
    val savedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "favorite_destinations")
data class FavoriteDestinationEntity(
    @PrimaryKey
    val destinationId: String,
    val name: String,
    val state: String,
    val rating: Float,
    val addedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "saved_hidden_gems")
data class SavedHiddenGemEntity(
    @PrimaryKey
    val id: String,
    val destinationId: String,
    val name: String,
    val category: String,
    val stateName: String,
    val district: String,
    val addedAt: Long = System.currentTimeMillis()
)

