
package dev.harryakbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.harryakbar.quran.SurahDetailScreen
import dev.harryakbar.quran.SurahListScreen
import dev.harryakbar.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "surahs",
                        modifier = Modifier.padding(innerPadding)
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
            }
        }
    }
}
