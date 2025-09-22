
package dev.harryakbar.quran

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SurahListScreen(
    modifier: Modifier = Modifier,
    viewModel: SurahViewModel = viewModel(),
    onSurahClick: (Int) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    when (uiState) {
        is SurahUiState.Loading -> {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is SurahUiState.Success -> {
            SurahList(
                surahs = (uiState as SurahUiState.Success).surahs,
                modifier = modifier,
                onSurahClick = onSurahClick
            )
        }
        is SurahUiState.Error -> {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Error fetching data")
            }
        }
    }
}

@Composable
fun SurahList(
    surahs: List<Surah>,
    modifier: Modifier = Modifier,
    onSurahClick: (Int) -> Unit
) {
    LazyColumn(modifier = modifier.padding(horizontal = 8.dp)) {
        items(surahs) { surah ->
            SurahListItem(
                surah = surah,
                onClick = { onSurahClick(surah.id) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SurahListItem(surah: Surah, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "${surah.id}.",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(end = 16.dp)
                )
                Column {
                    Text(text = surah.nameSimple, style = MaterialTheme.typography.bodyLarge)
                    Text(
                        text = surah.translatedName.name,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                }
            }
            Text(
                text = surah.nameArabic,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.End
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SurahListPreview() {
    val dummySurah = Surah(
        id = 1,
        revelationPlace = "makkah",
        nameSimple = "Al-Fatihah",
        nameArabic = "الفاتحة",
        versesCount = 7,
        pages = listOf(1, 1),
        translatedName = TranslatedName(languageName = "english", name = "The Opening")
    )
    SurahListItem(surah = dummySurah, onClick = {})
}
