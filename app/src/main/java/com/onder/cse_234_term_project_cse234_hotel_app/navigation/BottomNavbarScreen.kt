package com.onder.cse_234_term_project_cse234_hotel_app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavbarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomNavbarScreen(
        route = "HOME",
        title = "HOME",
        icon = Icons.Default.Home
    )

    object Favorites : BottomNavbarScreen(
        route = "FAVORITES",
        title = "FAVORITES",
        icon = Icons.Default.Favorite
    )

    object Bookings : BottomNavbarScreen(
        route = "BOOKINGS",
        title = "BOOKINGS",
        icon = Icons.Default.Settings
    )

    object Profile : BottomNavbarScreen(
        route = "PROFILE",
        title = "PROFILE",
        icon = Icons.Default.Person
    )
}