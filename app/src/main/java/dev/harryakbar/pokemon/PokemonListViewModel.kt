
package dev.harryakbar.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface PokemonListUiState {
    data class Success(val pokemon: List<PokemonResult>) : PokemonListUiState
    object Error : PokemonListUiState
    object Loading : PokemonListUiState
}

class PokemonListViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<PokemonListUiState>(PokemonListUiState.Loading)
    val uiState: StateFlow<PokemonListUiState> = _uiState.asStateFlow()

    private val repository = PokemonRepository()

    init {
        getPokemonList()
    }

    private fun getPokemonList() {
        viewModelScope.launch {
            _uiState.value = PokemonListUiState.Loading
            _uiState.value = try {
                PokemonListUiState.Success(repository.getPokemonList())
            } catch (e: IOException) {
                PokemonListUiState.Error
            }
        }
    }
}
