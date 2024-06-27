package com.onder.cse_234_term_project_cse234_hotel_app.navigation


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.onder.cse_234_term_project_cse234_hotel_app.model.AuthViewModel
import com.onder.cse_234_term_project_cse234_hotel_app.pages.LoginPage
import com.onder.cse_234_term_project_cse234_hotel_app.pages.MainContent
import com.onder.cse_234_term_project_cse234_hotel_app.pages.SignUpPage

fun NavGraphBuilder.authNavGraph(navController: NavHostController, authViewModel: AuthViewModel) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Main.route
    ) {
        composable(route = AuthScreen.Main.route) {
            MainContent(
                onClick = {
                    navController.navigate(AuthScreen.Login.route)
                },
                onSignUpClick = {
                    navController.navigate(AuthScreen.SignUp.route)
                }
            )
        }
        composable(route = AuthScreen.Login.route) {
            LoginPage(
                navController = navController,
                authViewModel = authViewModel
            )
        }
        composable(route = AuthScreen.SignUp.route) {
            SignUpPage(navController = navController, authViewModel = authViewModel)
        }
        /*composable(route = AuthScreen.Forgot.route) {
            ScreenContent(name = AuthScreen.Forgot.route) {}
        }*/
    }
}

sealed class AuthScreen(val route: String) {
    object Main : AuthScreen(route = "MAIN")
    object Login : AuthScreen(route = "LOGIN")
    object SignUp : AuthScreen(route = "SIGN_UP")
    object Forgot : AuthScreen(route = "FORGOT")
}