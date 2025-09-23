
package dev.harryakbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.CatchingPokemon
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Quran : BottomNavItem(
        route = "quran",
        title = "Quran",
        icon = Icons.Default.Book
    )

    object Pokemon : BottomNavItem(
        route = "pokemon",
        title = "Pokemon",
        icon = Icons.Default.CatchingPokemon
    )
}
