
package dev.harryakbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.harryakbar.quran.Surah
import dev.harryakbar.quran.SurahListScreen
import dev.harryakbar.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val dummySurahs = listOf(
                    Surah(1, "Al-Fatihah", "The Opening", "The Opening", 7, "Meccan"),
                    Surah(2, "Al-Baqarah", "The Cow", "The Cow", 286, "Medinan"),
                    Surah(3, "Ali 'Imran", "Family of Imran", "Family of Imran", 200, "Medinan"),
                    Surah(4, "An-Nisa", "The Women", "The Women", 176, "Medinan"),
                    Surah(5, "Al-Ma'idah", "The Table Spread", "The Table Spread", 120, "Medinan")
                )
                SurahListScreen(surahs = dummySurahs)
            }
        }
    }
}
