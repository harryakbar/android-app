
package dev.harryakbar.quran

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun QuranNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "surahs",
        modifier = modifier
    ) {
        composable("surahs") {
            SurahListScreen(
                onSurahClick = { surahId ->
                    navController.navigate("surah/$surahId")
                }
            )
        }
        composable(
            route = "surah/{surahId}",
            arguments = listOf(navArgument("surahId") { type = NavType.IntType })
        ) {
            SurahDetailScreen(navController = navController)
        }
    }
}
