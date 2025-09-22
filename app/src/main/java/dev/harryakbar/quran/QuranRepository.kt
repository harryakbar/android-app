
package dev.harryakbar.quran

import dev.harryakbar.quran.network.QuranApi

class QuranRepository {

    suspend fun getSurahs(): List<Surah> {
        return QuranApi.retrofitService.getSurahs().chapters
    }
}
