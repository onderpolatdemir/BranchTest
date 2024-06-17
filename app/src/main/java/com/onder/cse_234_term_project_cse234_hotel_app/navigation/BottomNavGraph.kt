package com.onder.cse_234_term_project_cse234_hotel_app.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.onder.cse_234_term_project_cse234_hotel_app.BookingsPage
import com.onder.cse_234_term_project_cse234_hotel_app.FavoritesPage
import com.onder.cse_234_term_project_cse234_hotel_app.HomePage
import com.onder.cse_234_term_project_cse234_hotel_app.LoginPage
import com.onder.cse_234_term_project_cse234_hotel_app.ProfilePage

@Composable
fun BottomNavGraph(navController: NavHostController ) {
    //modifier: Modifier = Modifier
    NavHost(
        navController = navController,
        startDestination = BottomNavbarScreen.Home.route
    ) {
        composable(route = BottomNavbarScreen.Home.route) {
            HomePage(navController = navController)
        }
        composable(route = BottomNavbarScreen.Favorites.route) {
            FavoritesPage()
        }
        composable(route = BottomNavbarScreen.Bookings.route) {
            BookingsPage()
        }
        composable(route = BottomNavbarScreen.Profile.route) {
            ProfilePage()
        }
    }
}