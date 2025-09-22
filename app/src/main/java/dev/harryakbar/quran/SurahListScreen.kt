
package dev.harryakbar.quran

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SurahListScreen(surahs: List<Surah>) {
    LazyColumn {
        items(surahs) { surah ->
            Text(text = surah.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SurahListScreenPreview() {
    val dummySurahs = listOf(
        Surah(1, "Al-Fatihah", "The Opening", "The Opening", 7, "Meccan"),
        Surah(2, "Al-Baqarah", "The Cow", "The Cow", 286, "Medinan")
    )
    SurahListScreen(surahs = dummySurahs)
}
