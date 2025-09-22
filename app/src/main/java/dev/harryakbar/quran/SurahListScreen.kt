
package dev.harryakbar.quran

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SurahListScreen(viewModel: SurahViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    when (uiState) {
        is SurahUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is SurahUiState.Success -> {
            SurahList(surahs = (uiState as SurahUiState.Success).surahs)
        }
        is SurahUiState.Error -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Error fetching data")
            }
        }
    }
}

@Composable
fun SurahList(surahs: List<Surah>) {
    LazyColumn {
        items(surahs) { surah ->
            Text(text = surah.nameSimple)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SurahListPreview() {
    val dummySurahs = listOf(
        Surah(
            id = 1,
            revelationPlace = "makkah",
            nameSimple = "Al-Fatihah",
            nameArabic = "الفاتحة",
            versesCount = 7,
            pages = listOf(1, 1),
            translatedName = TranslatedName(languageName = "english", name = "The Opening")
        ),
        Surah(
            id = 2,
            revelationPlace = "madinah",
            nameSimple = "Al-Baqarah",
            nameArabic = "البقرة",
            versesCount = 286,
            pages = listOf(2, 49),
            translatedName = TranslatedName(languageName = "english", name = "The Cow")
        )
    )
    SurahList(surahs = dummySurahs)
}
