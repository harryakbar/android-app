
package dev.harryakbar.pokemon

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun PokemonNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "pokemon_list",
        modifier = modifier
    ) {
        composable("pokemon_list") {
            PokemonListScreen(
                onPokemonClick = { pokemonName ->
                    navController.navigate("pokemon_detail/$pokemonName")
                }
            )
        }
        composable(
            route = "pokemon_detail/{pokemonName}",
            arguments = listOf(navArgument("pokemonName") { type = NavType.StringType })
        ) {
            PokemonDetailScreen(navController = navController)
        }
    }
}
