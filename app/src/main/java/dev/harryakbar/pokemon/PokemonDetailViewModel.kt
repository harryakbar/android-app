
package dev.harryakbar.pokemon

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface PokemonDetailUiState {
    data class Success(val pokemon: Pokemon) : PokemonDetailUiState
    object Error : PokemonDetailUiState
    object Loading : PokemonDetailUiState
}

class PokemonDetailViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val pokemonName: String = checkNotNull(savedStateHandle["pokemonName"])

    private val _uiState = MutableStateFlow<PokemonDetailUiState>(PokemonDetailUiState.Loading)
    val uiState: StateFlow<PokemonDetailUiState> = _uiState.asStateFlow()

    private val repository = PokemonRepository()

    init {
        getPokemonDetail()
    }

    private fun getPokemonDetail() {
        viewModelScope.launch {
            _uiState.value = PokemonDetailUiState.Loading
            _uiState.value = try {
                PokemonDetailUiState.Success(repository.getPokemonDetail(pokemonName))
            } catch (e: IOException) {
                PokemonDetailUiState.Error
            }
        }
    }
}
