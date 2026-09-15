package com.example.data.local

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.data.datasource.DestinationsDataSource
import com.example.data.model.IndiaStatesMaster
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

typealias IndiaTravelDatabase = AppDatabase

/**
 * Main Room Database for the India-Wide Travel Application.
 *
 * Persists and indexes:
 * - User Trips and Itineraries ([SavedTripEntity])
 * - Favorite Destinations ([FavoriteDestinationEntity])
 * - Bookmarked Hidden Gems ([SavedHiddenGemEntity])
 * - Indian States & Union Territories ([StateEntity])
 * - Comprehensive Destinations ([DestinationEntity])
 * - Attractions / Sightseeing Points ([AttractionEntity])
 * - Regional Cuisines and Delicacies ([FoodEntity])
 * - Accommodations / Hotels ([HotelEntity])
 */
@Database(
    entities = [
        SavedTripEntity::class,
        FavoriteDestinationEntity::class,
        SavedHiddenGemEntity::class,
        StateEntity::class,
        DestinationEntity::class,
        AttractionEntity::class,
        FoodEntity::class,
        HotelEntity::class
    ],
    version = 4,
    exportSchema = false
)
@TypeConverters(TravelTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun tripDao(): TripDao
    abstract fun stateDao(): StateDao
    abstract fun destinationDao(): DestinationDao
    abstract fun attractionDao(): AttractionDao
    abstract fun foodDao(): FoodDao
    abstract fun hotelDao(): HotelDao

    companion object {
        const val DATABASE_NAME = "trip_planner_database"
        private const val TAG = "AppDatabase"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        /**
         * Migration from version 1 to 2:
         * Adds `saved_hidden_gems` table for bookmarked offbeat points of interest.
         */
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    """
                    CREATE TABLE IF NOT EXISTS `saved_hidden_gems` (
                        `id` TEXT NOT NULL,
                        `destinationId` TEXT NOT NULL,
                        `name` TEXT NOT NULL,
                        `category` TEXT NOT NULL,
                        `stateName` TEXT NOT NULL,
                        `district` TEXT NOT NULL,
                        `addedAt` INTEGER NOT NULL,
                        PRIMARY KEY(`id`)
                    )
                    """.trimIndent()
                )
            }
        }

        /**
         * Migration from version 2 to 3:
         * Adds foundational tables for India-wide catalog:
         * `destinations`, `attractions`, `foods`, and `hotels`.
         */
        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    """
                    CREATE TABLE IF NOT EXISTS `destinations` (
                        `id` TEXT NOT NULL,
                        `stateId` TEXT NOT NULL DEFAULT '',
                        `name` TEXT NOT NULL,
                        `state` TEXT NOT NULL,
                        `district` TEXT NOT NULL,
                        `tagline` TEXT NOT NULL,
                        `description` TEXT NOT NULL,
                        `rating` REAL NOT NULL,
                        `reviewCount` INTEGER NOT NULL,
                        `coverImageUrl` TEXT NOT NULL,
                        `coverResId` INTEGER NOT NULL,
                        `categoriesCsv` TEXT NOT NULL,
                        `discoveryLevel` TEXT NOT NULL,
                        `latitude` REAL NOT NULL,
                        `longitude` REAL NOT NULL,
                        `altitudeMeters` INTEGER NOT NULL,
                        `bestMonths` TEXT NOT NULL,
                        `weatherSummary` TEXT NOT NULL,
                        `peakSeason` TEXT NOT NULL,
                        `offSeason` TEXT NOT NULL,
                        `expectedCrowd` TEXT NOT NULL,
                        `temperatureRange` TEXT NOT NULL,
                        `suggestedDuration` TEXT NOT NULL,
                        `budgetStayPerNight` INTEGER NOT NULL,
                        `budgetFoodPerDay` INTEGER NOT NULL,
                        `budgetMin` INTEGER NOT NULL,
                        `budgetMax` INTEGER NOT NULL,
                        `nearestAirport` TEXT NOT NULL,
                        `nearestRailway` TEXT NOT NULL,
                        `nearestHighway` TEXT NOT NULL,
                        `isCustom` INTEGER NOT NULL,
                        `createdAt` INTEGER NOT NULL,
                        PRIMARY KEY(`id`)
                    )
                    """.trimIndent()
                )
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_destinations_stateId` ON `destinations` (`stateId`)")
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_destinations_state` ON `destinations` (`state`)")
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_destinations_district` ON `destinations` (`district`)")
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_destinations_discoveryLevel` ON `destinations` (`discoveryLevel`)")

                db.execSQL(
                    """
                    CREATE TABLE IF NOT EXISTS `attractions` (
                        `id` TEXT NOT NULL,
                        `destinationId` TEXT NOT NULL,
                        `name` TEXT NOT NULL,
                        `category` TEXT NOT NULL,
                        `description` TEXT NOT NULL,
                        `highlight` TEXT NOT NULL,
                        `distanceFromDestinationKm` REAL NOT NULL,
                        `suggestedDurationHours` TEXT NOT NULL,
                        `entryFeeAdult` TEXT NOT NULL,
                        `entryFeeChild` TEXT NOT NULL,
                        `openingTime` TEXT NOT NULL,
                        `closingTime` TEXT NOT NULL,
                        `bestTimeOfDay` TEXT NOT NULL,
                        `latitude` REAL NOT NULL,
                        `longitude` REAL NOT NULL,
                        `parkingAvailable` INTEGER NOT NULL,
                        `parkingFee` TEXT NOT NULL,
                        `difficultyLevel` TEXT NOT NULL,
                        `familyFriendly` INTEGER NOT NULL,
                        `childrenFriendly` INTEGER NOT NULL,
                        `seniorCitizenFriendly` INTEGER NOT NULL,
                        `photographyAllowed` INTEGER NOT NULL,
                        `trekDistanceKm` REAL NOT NULL,
                        `trekDurationMinutes` INTEGER NOT NULL,
                        `safetyNotes` TEXT NOT NULL,
                        `insiderTip` TEXT NOT NULL,
                        `imageUrl` TEXT NOT NULL,
                        `discoveryLevel` TEXT NOT NULL,
                        PRIMARY KEY(`id`)
                    )
                    """.trimIndent()
                )
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_attractions_destinationId` ON `attractions` (`destinationId`)")
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_attractions_category` ON `attractions` (`category`)")

                db.execSQL(
                    """
                    CREATE TABLE IF NOT EXISTS `foods` (
                        `id` TEXT NOT NULL,
                        `destinationId` TEXT NOT NULL,
                        `name` TEXT NOT NULL,
                        `cuisine` TEXT NOT NULL,
                        `description` TEXT NOT NULL,
                        `isVegetarian` INTEGER NOT NULL,
                        `spiceLevel` TEXT NOT NULL,
                        `priceRange` TEXT NOT NULL,
                        `popularAt` TEXT NOT NULL,
                        `whereToTry` TEXT NOT NULL,
                        `bestTimeToTry` TEXT NOT NULL,
                        `imageUrl` TEXT NOT NULL,
                        PRIMARY KEY(`id`)
                    )
                    """.trimIndent()
                )
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_foods_destinationId` ON `foods` (`destinationId`)")
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_foods_cuisine` ON `foods` (`cuisine`)")
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_foods_isVegetarian` ON `foods` (`isVegetarian`)")

                db.execSQL(
                    """
                    CREATE TABLE IF NOT EXISTS `hotels` (
                        `id` TEXT NOT NULL,
                        `destinationId` TEXT NOT NULL,
                        `name` TEXT NOT NULL,
                        `category` TEXT NOT NULL,
                        `description` TEXT NOT NULL,
                        `rating` REAL NOT NULL,
                        `reviewCount` INTEGER NOT NULL,
                        `pricePerNight` INTEGER NOT NULL,
                        `priceCategory` TEXT NOT NULL,
                        `distanceFromAttractions` TEXT NOT NULL,
                        `amenitiesCsv` TEXT NOT NULL,
                        `contactPhone` TEXT NOT NULL,
                        `websiteUrl` TEXT NOT NULL,
                        `bookingUrl` TEXT NOT NULL,
                        `address` TEXT NOT NULL,
                        `isVerified` INTEGER NOT NULL,
                        `imageUrl` TEXT NOT NULL,
                        PRIMARY KEY(`id`)
                    )
                    """.trimIndent()
                )
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_hotels_destinationId` ON `hotels` (`destinationId`)")
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_hotels_priceCategory` ON `hotels` (`priceCategory`)")
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_hotels_rating` ON `hotels` (`rating`)")
            }
        }

        /**
         * Migration from version 3 to 4:
         * Adds `states` table representing 28 States and 8 UTs of India,
         * and ensures `stateId` column in `destinations` with indexing.
         */
        val MIGRATION_3_4 = object : Migration(3, 4) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    """
                    CREATE TABLE IF NOT EXISTS `states` (
                        `id` TEXT NOT NULL,
                        `stateCode` TEXT NOT NULL,
                        `name` TEXT NOT NULL,
                        `type` TEXT NOT NULL,
                        `capital` TEXT NOT NULL,
                        `description` TEXT NOT NULL,
                        `latitude` REAL NOT NULL,
                        `longitude` REAL NOT NULL,
                        `tourismSummary` TEXT NOT NULL,
                        `majorRegionsCsv` TEXT NOT NULL,
                        `bestTravelMonths` TEXT NOT NULL,
                        `imageUrl` TEXT NOT NULL,
                        PRIMARY KEY(`id`)
                    )
                    """.trimIndent()
                )
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_states_name` ON `states` (`name`)")
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_states_stateCode` ON `states` (`stateCode`)")
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_states_type` ON `states` (`type`)")

                try {
                    db.execSQL("ALTER TABLE `destinations` ADD COLUMN `stateId` TEXT NOT NULL DEFAULT ''")
                } catch (ignored: Exception) {
                    // Column may already exist
                }
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_destinations_stateId` ON `destinations` (`stateId`)")
            }
        }

        /**
         * Safely pre-populates initial master travel data (States, Destinations, Attractions,
         * Regional Foods, and Accommodations) asynchronously without blocking the UI thread.
         */
        suspend fun preseedCatalogData(database: AppDatabase) {
            try {
                // 1. Preseed States & UTs
                if (database.stateDao().getStateCount() == 0) {
                    val stateEntities = IndiaStatesMaster.allStatesAndUTs.map { it.toEntity() }
                    database.stateDao().insertStates(stateEntities)
                    Log.d(TAG, "Preseeded ${stateEntities.size} Indian States & UTs.")
                }

                // 2. Preseed Initial Destinations, Attractions, Foods, and Hotels
                if (database.destinationDao().getDestinationCount() == 0) {
                    val destinations = DestinationsDataSource.destinations
                    val destEntities = ArrayList<DestinationEntity>(destinations.size)
                    val attrEntities = ArrayList<AttractionEntity>()
                    val foodEntities = ArrayList<FoodEntity>()
                    val hotelEntities = ArrayList<HotelEntity>()

                    for (dest in destinations) {
                        val entity = dest.toEntity()
                        destEntities.add(entity)

                        for (attr in dest.attractions) {
                            attrEntities.add(attr.toEntity(entity.id))
                        }
                        for (food in dest.foodGuide.localSpecialties) {
                            foodEntities.add(food.toEntity(entity.id))
                        }
                        for (stay in dest.stays) {
                            hotelEntities.add(stay.toEntity(entity.id))
                        }
                    }

                    database.destinationDao().insertDestinations(destEntities)
                    if (attrEntities.isNotEmpty()) database.attractionDao().insertAttractions(attrEntities)
                    if (foodEntities.isNotEmpty()) database.foodDao().insertFoods(foodEntities)
                    if (hotelEntities.isNotEmpty()) database.hotelDao().insertHotels(hotelEntities)
                    Log.d(TAG, "Preseeded ${destEntities.size} Destinations with details.")
                }
            } catch (e: Exception) {
                Log.e(TAG, "Failed to preseed initial India travel catalog", e)
            }
        }

        /**
         * Room Database initialization callback to perform safe initial data seeding
         * when the database is created or opened.
         */
        private fun createDatabaseCallback(context: Context): Callback {
            return object : Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    Log.d(TAG, "AppDatabase created. Scheduling initial catalog seeding.")
                    CoroutineScope(Dispatchers.IO).launch {
                        val instance = getInstance(context)
                        preseedCatalogData(instance)
                    }
                }

                override fun onOpen(db: SupportSQLiteDatabase) {
                    super.onOpen(db)
                    CoroutineScope(Dispatchers.IO).launch {
                        val instance = getInstance(context)
                        if (instance.stateDao().getStateCount() == 0 ||
                            instance.destinationDao().getDestinationCount() == 0
                        ) {
                            preseedCatalogData(instance)
                        }
                    }
                }
            }
        }

        /**
         * Singleton accessor for [AppDatabase].
         */
        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        /**
         * Builds a configured instance of [AppDatabase] with all migrations,
         * type converters, and safe initialization callbacks.
         */
        fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DATABASE_NAME
            )
                .addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4)
                .addCallback(createDatabaseCallback(context))
                .fallbackToDestructiveMigrationOnDowngrade(true)
                .build()
        }

        /**
         * Helper to construct an in-memory database instance for testing.
         */
        fun buildInMemory(context: Context): AppDatabase {
            return Room.inMemoryDatabaseBuilder(
                context.applicationContext,
                AppDatabase::class.java
            )
                .allowMainThreadQueries()
                .build()
        }
    }
}
