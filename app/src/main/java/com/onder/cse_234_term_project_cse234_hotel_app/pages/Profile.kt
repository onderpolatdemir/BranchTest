package com.onder.cse_234_term_project_cse234_hotel_app.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.onder.cse_234_term_project_cse234_hotel_app.CustomTextField
import com.onder.cse_234_term_project_cse234_hotel_app.R
import com.onder.cse_234_term_project_cse234_hotel_app.SimpleTopBar
import com.onder.cse_234_term_project_cse234_hotel_app.buttonlarge.ButtonLarge
import com.onder.cse_234_term_project_cse234_hotel_app.buttonlarge.Design
import com.onder.cse_234_term_project_cse234_hotel_app.model.AuthState
import com.onder.cse_234_term_project_cse234_hotel_app.model.AuthViewModel
import com.onder.cse_234_term_project_cse234_hotel_app.navigation.AuthScreen
import com.onder.cse_234_term_project_cse234_hotel_app.navigation.DetailsScreen
import com.onder.cse_234_term_project_cse234_hotel_app.navigation.Graph


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfilePage(navController: NavHostController, authViewModel: AuthViewModel) {
    Scaffold(
        topBar = {
            SimpleTopBar(
                title = "",
                title2 = "Profile",
                onBackClick = { navController.popBackStack() },
            )
        },
    ) {
        ProfileScreen(navController = navController)
    }
}


@Composable
fun ProfileScreen(navController: NavHostController){
    var email by remember { mutableStateOf("onder123@hotmail.com") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(32.dp)
    ) {

        Spacer(modifier = Modifier.height(100.dp))
        // Profile Icon
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.component_1_vector),
                contentDescription = "Profile Image",
                modifier = Modifier
                    //.size(100.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            )
        }

        Spacer(modifier = Modifier.height(100.dp))

        // Email Field
        CustomTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = "Email",
            label = "Email",
            textcolor = Color.Black,
            leadingIcon = painterResource(id = R.drawable.label_box_vector), // Replace with your email icon
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            labelFontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(100.dp))

        // Log out Button
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp,)
                .clip(RoundedCornerShape(50))
                .height(61.dp),
            onClick = {
                navController.navigate(DetailsScreen.Confirm.route)
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.primary_Color),
                contentColor = Color.White
            ),
        ) {
            Text(
                "Log Out",
                fontSize = 16.sp
            )
        }
    }
}



//@Composable
//fun ProfilePage(navController: NavHostController, authViewModel: AuthViewModel){
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//
//    //val authState = authViewModel.authState.observeAsState()
//    val authState = authViewModel.authState.observeAsState()
//
//// Remember the latest auth state for navigation
//
////    LaunchedEffect(Unit) {
////        authViewModel.checkAuthStatus()
////    }
//
//    LaunchedEffect(authState.value) {
//        when (authState.value) {
//            is AuthState.Unauthenticated -> {
//                navController.navigate(AuthScreen.Main.route) {
//                    popUpTo(Graph.ROOT) { inclusive = true }
//                }
//            }
//            else -> Unit
//        }
//    }
//
//    LaunchedEffect(authState.value) {
//        when (authState.value) {
//            is AuthState.Unauthenticated -> {
//                navController.navigate(AuthScreen.Main.route)
//            }
//            else -> Unit
//        }
//    }
//
////    LaunchedEffect(authState.value) {
////        when (authState.value) {
////            is AuthState.Unauthenticated -> {
////                navController.navigate(AuthScreen.Login.route) {
////                    popUpTo(0) { inclusive = true } // Clear the backstack
////                }
////            }
////            else -> Unit
////        }
////    }
//
//    Scaffold(
//        topBar = {
//            SimpleTopBar(
//                title = "",
//                title2 = "Profile",
//                onBackClick = { navController.popBackStack() },
//                additionalTitle = ""
//            )
//        },
//        content = { padding ->
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(padding)
//                    .padding(20.dp)
//                    .background(Color.White),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//
//
//                Spacer(modifier = Modifier.height(250.dp))
//
//                ButtonLarge(
//                    onClick = {
//                        authViewModel.signOut()
//                        //navController.navigate(AuthScreen.Login.route)
//                    },
//                    text = "Log Out",
//                    design = Design.Primary,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 32.dp,)
//                        .clip(RoundedCornerShape(50))
//                )
//
//                Spacer(modifier = Modifier.height(8.dp))
//
//            }
//        }
//    )
//}