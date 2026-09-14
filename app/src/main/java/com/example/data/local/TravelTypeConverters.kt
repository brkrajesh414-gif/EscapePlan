package com.example.data.local

import androidx.room.TypeConverter
import com.example.data.model.DiscoveryLevel
import com.example.data.model.StateType
import com.example.data.model.TravelCategory
import com.example.data.model.VerificationLevel
import org.json.JSONArray
import java.time.Instant
import java.util.Date

/**
 * Type converters for Room Database to safely persist and retrieve
 * complex types, collections, dates, and enums used across the India travel catalog.
 */
class TravelTypeConverters {

    // --- List<String> Converters ---
    @TypeConverter
    fun fromStringList(list: List<String>?): String {
        if (list.isNullOrEmpty()) return "[]"
        val jsonArray = JSONArray()
        for (item in list) {
            jsonArray.put(item)
        }
        return jsonArray.toString()
    }

    @TypeConverter
    fun toStringList(data: String?): List<String> {
        if (data.isNullOrBlank() || data == "[]") return emptyList()
        return try {
            val jsonArray = JSONArray(data)
            val result = ArrayList<String>(jsonArray.length())
            for (i in 0 until jsonArray.length()) {
                result.add(jsonArray.getString(i))
            }
            result
        } catch (e: Exception) {
            // Fallback: parse comma-separated string if data was stored in legacy CSV format
            data.split(",").map { it.trim() }.filter { it.isNotEmpty() }
        }
    }

    // --- List<Int> Converters ---
    @TypeConverter
    fun fromIntList(list: List<Int>?): String {
        if (list.isNullOrEmpty()) return "[]"
        val jsonArray = JSONArray()
        for (item in list) {
            jsonArray.put(item)
        }
        return jsonArray.toString()
    }

    @TypeConverter
    fun toIntList(data: String?): List<Int> {
        if (data.isNullOrBlank() || data == "[]") return emptyList()
        return try {
            val jsonArray = JSONArray(data)
            val result = ArrayList<Int>(jsonArray.length())
            for (i in 0 until jsonArray.length()) {
                result.add(jsonArray.getInt(i))
            }
            result
        } catch (e: Exception) {
            data.split(",").mapNotNull { it.trim().toIntOrNull() }
        }
    }

    // --- TravelCategory Enum & List Converters ---
    @TypeConverter
    fun fromTravelCategory(category: TravelCategory?): String? {
        return category?.name
    }

    @TypeConverter
    fun toTravelCategory(value: String?): TravelCategory? {
        if (value.isNullOrBlank()) return null
        return try {
            TravelCategory.valueOf(value.uppercase())
        } catch (e: Exception) {
            null
        }
    }

    @TypeConverter
    fun fromTravelCategoryList(categories: List<TravelCategory>?): String {
        if (categories.isNullOrEmpty()) return "[]"
        val jsonArray = JSONArray()
        for (cat in categories) {
            jsonArray.put(cat.name)
        }
        return jsonArray.toString()
    }

    @TypeConverter
    fun toTravelCategoryList(data: String?): List<TravelCategory> {
        if (data.isNullOrBlank() || data == "[]") return emptyList()
        return try {
            val jsonArray = JSONArray(data)
            val result = ArrayList<TravelCategory>(jsonArray.length())
            for (i in 0 until jsonArray.length()) {
                val catName = jsonArray.getString(i)
                try {
                    result.add(TravelCategory.valueOf(catName.uppercase()))
                } catch (ignored: Exception) {
                }
            }
            result
        } catch (e: Exception) {
            data.split(",").mapNotNull { name ->
                try {
                    TravelCategory.valueOf(name.trim().uppercase())
                } catch (ignored: Exception) {
                    null
                }
            }
        }
    }

    // --- StateType Enum Converters ---
    @TypeConverter
    fun fromStateType(type: StateType?): String? {
        return type?.name
    }

    @TypeConverter
    fun toStateType(value: String?): StateType {
        if (value.isNullOrBlank()) return StateType.STATE
        return try {
            StateType.valueOf(value.uppercase())
        } catch (e: Exception) {
            StateType.STATE
        }
    }

    // --- DiscoveryLevel Enum Converters ---
    @TypeConverter
    fun fromDiscoveryLevel(level: DiscoveryLevel?): String? {
        return level?.name
    }

    @TypeConverter
    fun toDiscoveryLevel(value: String?): DiscoveryLevel {
        if (value.isNullOrBlank()) return DiscoveryLevel.POPULAR
        return try {
            DiscoveryLevel.valueOf(value.uppercase())
        } catch (e: Exception) {
            DiscoveryLevel.POPULAR
        }
    }

    // --- VerificationLevel Enum Converters ---
    @TypeConverter
    fun fromVerificationLevel(level: VerificationLevel?): String? {
        return level?.name
    }

    @TypeConverter
    fun toVerificationLevel(value: String?): VerificationLevel {
        if (value.isNullOrBlank()) return VerificationLevel.UNVERIFIED
        return try {
            VerificationLevel.valueOf(value.uppercase())
        } catch (e: Exception) {
            VerificationLevel.UNVERIFIED
        }
    }

    // --- Date Converters ---
    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return timestamp?.let { Date(it) }
    }

    // --- Instant Converters ---
    @TypeConverter
    fun fromInstant(instant: Instant?): Long? {
        return instant?.toEpochMilli()
    }

    @TypeConverter
    fun toInstant(epochMilli: Long?): Instant? {
        return epochMilli?.let { Instant.ofEpochMilli(it) }
    }
}
