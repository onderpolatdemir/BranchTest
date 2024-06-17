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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.onder.cse_234_term_project_cse234_hotel_app.navigation.Screen


//@Preview(
//    showBackground = true,
//    showSystemUi = true
//)
@Composable
fun SignUpPage(navController: NavHostController) {
    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var termsAccepted by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopBar(
                title = "Create",
                title2 = "Account",
                onBackClick = { navController.popBackStack() },
                additionalTitle = "Fill your information below"
                //navController.popBackStack()
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(20.dp)
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                //Text("Fill your information below")
                CustomTextField(
                    value = userName,
                    onValueChange = { userName = it },
                    placeholder = "User Name",
                    leadingIcon = painterResource(id = R.drawable.component_1_vector) // Replace with your user icon
                )

                CustomTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = "E mail",
                    leadingIcon = painterResource(id = R.drawable.component_1_vector1), // Replace with your email icon
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    )
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

                CustomTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    placeholder = "Confirm Password",
                    leadingIcon = painterResource(id = R.drawable.component_1_vector2), // Replace with your lock icon
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    )
                )

                Spacer(modifier = Modifier.height(80.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Checkbox(
                        checked = termsAccepted,
                        onCheckedChange = { termsAccepted = it }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "I read and agree to",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                    TextButton(onClick = { /* Handle terms and conditions click */ }) {
                        Text("Term&Conditions", color = colorResource(id = R.color.primary_Color))
                    }
                }

                Button(
                    onClick = { navController.navigate(Screen.Login.route) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Create", fontSize = 32.sp)
                }

                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Text("Already have an account?")
                    TextButton(onClick = { navController.navigate(Screen.Login.route) }) {
                        //navController.navigate(Screen.Login.route)
                        Text("Log In", color = colorResource(id = R.color.primary_Color))
                    }
                }
            }
        }
    )
}
