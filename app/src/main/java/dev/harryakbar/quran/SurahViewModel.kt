
package dev.harryakbar.quran

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SurahViewModel(application: Application) : AndroidViewModel(application) {

    private val _surahs = MutableStateFlow<List<Surah>>(emptyList())
    val surahs: StateFlow<List<Surah>> = _surahs

    private val repository = QuranRepository(application)

    init {
        viewModelScope.launch {
            _surahs.value = repository.getSurahs()
        }
    }
}
