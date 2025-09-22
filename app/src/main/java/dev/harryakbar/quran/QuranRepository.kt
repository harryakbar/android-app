
package dev.harryakbar.quran

import android.content.Context
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString

class QuranRepository(private val context: Context) {

    fun getSurahs(): List<Surah> {
        val jsonString = context.assets.open("surahs.json").bufferedReader().use { it.readText() }
        return Json.decodeFromString<List<Surah>>(jsonString)
    }
}
