package com.example.data.datasource.tamilnadu

import com.example.data.model.Destination

object TamilNaduDestinationsData {

    val allDestinations: List<Destination> =
        TamilNaduChennaiHeritageData.allChennaiHeritageDestinations +
        TamilNaduHillsNatureData.allHillsNatureDestinations

    fun getById(id: String): Destination? = allDestinations.find { it.id.equals(id, ignoreCase = true) }
}
