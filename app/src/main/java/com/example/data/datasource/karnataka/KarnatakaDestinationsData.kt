package com.example.data.datasource.karnataka

import com.example.data.model.Destination

object KarnatakaDestinationsData {

    val allDestinations: List<Destination> = 
        KarnatakaBengaluruMysuruData.allBengaluruMysuruDestinations +
        KarnatakaChikkamagaluruNatureData.allChikkamagaluruNatureDestinations +
        KarnatakaCoastalHeritageData.allCoastalHeritageDestinations

    fun getById(id: String): Destination? = allDestinations.find { it.id.equals(id, ignoreCase = true) }
}
