package com.example.data.repository

import android.content.Context
import com.example.core.operation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable data class RegionalSection(val label: String, val text: String)
@Serializable data class RegionalGuide(val id: String, val name: String, val sections: List<RegionalSection>)

suspend fun loadRegionalGuides(context: Context): Result<List<RegionalGuide>> = operation {
    withContext(Dispatchers.IO) {
        context.assets.open("regional_guides.json").bufferedReader().use {
            Json.decodeFromString<List<RegionalGuide>>(it.readText())
        }.also { guides ->
            require(guides.map { it.id }.distinct().size == guides.size)
            require(guides.all { it.name.isNotBlank() && it.sections.isNotEmpty() &&
                it.sections.all { section -> section.label.isNotBlank() && section.text.isNotBlank() } })
        }
    }
}
