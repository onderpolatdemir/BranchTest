package com.onder.cse_234_term_project_cse234_hotel_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.onder.cse_234_term_project_cse234_hotel_app.navigation.BottomNavGraph
import com.onder.cse_234_term_project_cse234_hotel_app.navigation.BottomNavbarScreen
import com.onder.cse_234_term_project_cse234_hotel_app.navigation.Screen


@Composable
fun LoginPage(navController: NavHostController) {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopBar(
                title = "Welcome",
                title2 = "Back",
                onBackClick = { navController.popBackStack() },
                additionalTitle = "Log in to continue your adventure with us"
                //navController.popBackStack()
            )
        },
        content = { padding ->

            Text("Log in to continue your adventure with us")

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomTextField(
                    value = userName,
                    onValueChange = { userName = it },
                    placeholder = "User Name",
                    leadingIcon = painterResource(id = R.drawable.component_1_vector) // Replace with your user icon
                )


                CustomTextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = "Password",
                    leadingIcon = painterResource(id = R.drawable.component_1_vector2), // Replace with your lock icon
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Next
                    )
                )

                TextButton(onClick = { /* Handle terms and conditions click */ }) {
                    Text(
                        "Forgot Password?",
                        color = colorResource(id = R.color.primary_Color),
                        fontStyle = FontStyle.Italic)
                }


                Spacer(modifier = Modifier.height(80.dp))



                Button(
                    onClick = { navController.navigate(Screen.HomePage.route) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Log In", fontSize = 32.sp)
                }

                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Text("Don't have an account?")
                    TextButton(onClick = { navController.navigate(Screen.SignUp.route) }) {
                        //navController.navigate(Screen.SignUp.route)
                        Text("Create", color = colorResource(id = R.color.primary_Color))
                    }
                }
            }
        }
    )
}


//@Composable
//fun startHomePage(navController: NavHostController) {
//    //val navController = rememberNavController()
//    Scaffold(
//        bottomBar = { BottomBar(navController = navController) }
//    ) { padding ->
//        BottomNavGraph(navController = navController)
//        //HomePage()
//    }
//}