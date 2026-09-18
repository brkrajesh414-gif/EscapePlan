package com.example.data.engine

import java.text.Normalizer
import java.util.Locale

object PlaceSearch {
    fun normalized(value: String): String = Normalizer.normalize(value, Normalizer.Form.NFD)
        .replace(Regex("\\p{M}+"), "").lowercase(Locale.ROOT)
        .replace(Regex("[^\\p{L}\\p{N}]+"), " ").trim()

    fun matches(query: String, searchable: String): Boolean {
        val text = normalized(searchable)
        return normalized(query).split(' ').filter { it.isNotBlank() }.all { text.contains(it) }
    }
}
