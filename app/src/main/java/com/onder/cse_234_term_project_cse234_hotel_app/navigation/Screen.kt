package com.onder.cse_234_term_project_cse234_hotel_app.navigation

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object Login : Screen("login")
    object SignUp : Screen("signup")
    object HomePage : Screen("mainscreen")
    //object startHomePage : Screen("startmainscreen")
}