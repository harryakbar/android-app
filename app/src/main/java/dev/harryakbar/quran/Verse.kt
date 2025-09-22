
package dev.harryakbar.quran

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VersesResponse(
    val verses: List<Verse>
)

@Serializable
data class Verse(
    val id: Int,
    @SerialName("verse_number")
    val verseNumber: Int,
    @SerialName("text_uthmani")
    val textUthmani: String,
    val translations: List<Translation>? = null
)

@Serializable
data class Translation(
    val id: Int,
    @SerialName("resource_id")
    val resourceId: Int,
    val text: String
)
