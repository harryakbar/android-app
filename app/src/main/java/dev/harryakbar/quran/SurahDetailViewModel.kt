
package dev.harryakbar.quran

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface VerseUiState {
    data class Success(val verses: List<Verse>) : VerseUiState
    object Error : VerseUiState
    object Loading : VerseUiState
}

class SurahDetailViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val chapterNumber: Int = checkNotNull(savedStateHandle["surahId"])

    private val _uiState = MutableStateFlow<VerseUiState>(VerseUiState.Loading)
    val uiState: StateFlow<VerseUiState> = _uiState.asStateFlow()

    private val repository = QuranRepository()

    init {
        getVerses()
    }

    private fun getVerses() {
        viewModelScope.launch {
            _uiState.value = VerseUiState.Loading
            _uiState.value = try {
                VerseUiState.Success(repository.getVerses(chapterNumber))
            } catch (e: IOException) {
                VerseUiState.Error
            }
        }
    }
}
