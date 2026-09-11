package com.example.data.datasource.telangana

import com.example.data.model.Destination

object TelanganaDestinationsData {

    val allTelanganaDestinations: List<Destination> by lazy {
        (TelanganaHeritageData.allHeritageDestinations +
         TelanganaLakesWaterfallsData.allLakesWaterfallsDestinations +
         TelanganaWildlifeNatureData.allWildlifeNatureDestinations +
         TelanganaSpiritualData.allSpiritualDestinations).distinctBy { it.id }
    }

    fun getDestinationById(id: String): Destination? {
        return allTelanganaDestinations.find { it.id.equals(id, ignoreCase = true) }
    }
}
