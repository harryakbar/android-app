
package dev.harryakbar.quran

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface SurahUiState {
    data class Success(val surahs: List<Surah>) : SurahUiState
    object Error : SurahUiState
    object Loading : SurahUiState
}

class SurahViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<SurahUiState>(SurahUiState.Loading)
    val uiState: StateFlow<SurahUiState> = _uiState.asStateFlow()

    private val repository = QuranRepository()

    init {
        getSurahs()
    }

    fun getSurahs() {
        viewModelScope.launch {
            _uiState.value = SurahUiState.Loading
            _uiState.value = try {
                SurahUiState.Success(repository.getSurahs())
            } catch (e: IOException) {
                SurahUiState.Error
            }
        }
    }
}
