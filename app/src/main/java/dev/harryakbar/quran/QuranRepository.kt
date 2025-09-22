
package dev.harryakbar.quran

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import dev.harryakbar.quran.network.QuranApi
import dev.harryakbar.ui.theme.MyApplicationTheme

class QuranRepository {

    suspend fun getSurahs(): List<Surah> {
        return QuranApi.retrofitService.getSurahs().chapters
    }
}
