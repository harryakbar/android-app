
package dev.harryakbar.quran

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SurahsResponse(
    val chapters: List<Surah>
)

@Serializable
data class Surah(
    val id: Int,
    @SerialName("revelation_place")
    val revelationPlace: String,
    @SerialName("name_simple")
    val nameSimple: String,
    @SerialName("name_arabic")
    val nameArabic: String,
    @SerialName("verses_count")
    val versesCount: Int,
    val pages: List<Int>,
    @SerialName("translated_name")
    val translatedName: TranslatedName
)

@Serializable
data class TranslatedName(
    @SerialName("language_name")
    val languageName: String,
    val name: String
)
