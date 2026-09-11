package com.example.data.datasource.kerala

import com.example.data.model.Destination

object KeralaDestinationsData {

    val allDestinations: List<Destination> =
        KeralaBackwatersCoastData.allBackwatersCoastDestinations +
        KeralaHighlandsWildData.allHighlandsWildDestinations

    fun getById(id: String): Destination? = allDestinations.find { it.id.equals(id, ignoreCase = true) }
}
