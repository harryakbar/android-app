
package dev.harryakbar.pokemon

import dev.harryakbar.pokemon.network.PokemonApi

class PokemonRepository {

    suspend fun getPokemonList(): List<PokemonResult> {
        return PokemonApi.retrofitService.getPokemonList().results
    }

    suspend fun getPokemonDetail(name: String): Pokemon {
        return PokemonApi.retrofitService.getPokemonDetail(name)
    }
}
