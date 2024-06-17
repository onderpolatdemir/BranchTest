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
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Favorites : BottomNavbarScreen(
        route = "favorites",
        title = "Favorites",
        icon = Icons.Default.Favorite
    )

    object Bookings : BottomNavbarScreen(
        route = "my bookings",
        title = "My Bookings",
        icon = Icons.Default.Settings
    )

    object Profile : BottomNavbarScreen(
        route = "my bookings",
        title = "My Bookings",
        icon = Icons.Default.Person
    )
}