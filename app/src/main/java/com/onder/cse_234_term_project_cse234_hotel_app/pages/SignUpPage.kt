package com.onder.cse_234_term_project_cse234_hotel_app.pages

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavHostController
import com.onder.cse_234_term_project_cse234_hotel_app.CustomTextField
import com.onder.cse_234_term_project_cse234_hotel_app.R
import com.onder.cse_234_term_project_cse234_hotel_app.SimpleTopBar
import com.onder.cse_234_term_project_cse234_hotel_app.TopBar
import com.onder.cse_234_term_project_cse234_hotel_app.buttonlarge.ButtonLarge
import com.onder.cse_234_term_project_cse234_hotel_app.buttonlarge.Design
import com.onder.cse_234_term_project_cse234_hotel_app.buttonlarge.fONTSPRINGDEMOOktahRoundMedium
import com.onder.cse_234_term_project_cse234_hotel_app.model.AuthState
import com.onder.cse_234_term_project_cse234_hotel_app.model.AuthViewModel
import com.onder.cse_234_term_project_cse234_hotel_app.navigation.AuthScreen


@Composable
fun SignUpPage(navController: NavHostController, authViewModel: AuthViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var termsAccepted by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current


    LaunchedEffect(Unit) {
        authViewModel.resetAuthState()
    }

    LaunchedEffect(authState.value) {
        when (authState.value){
            is AuthState.Authenticated -> navController.navigate(AuthScreen.Login.route)
            is AuthState.Error -> Toast.makeText(context,
                (authState.value as AuthState.Error).message, Toast.LENGTH_LONG).show()
            else -> Unit
        }
    }
    

    Scaffold(
        topBar = {
            SimpleTopBar(
                title = "Create ",
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

                Spacer(modifier = Modifier.height(80.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Checkbox(
                        checked = termsAccepted,
                        onCheckedChange = { termsAccepted = it },
                        enabled = false
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "I read and agree to",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                    TextButton(onClick = { showDialog = true }) {
                        Text("Term&Conditions", color = colorResource(id = R.color.primary_Color))
                    }
                }


                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp,)
                        .clip(RoundedCornerShape(50))
                        .height(61.dp),
                    onClick = {
                        authViewModel.signUp(email,password)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.primary_Color)
                    ),
                    enabled = termsAccepted && authState.value != AuthState.Loading
                ) {
                    Text(
                        text = "Create",
                        fontSize =  28.0.sp,
                        fontFamily = fONTSPRINGDEMOOktahRoundMedium,
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Text("Already have an account?")
                    TextButton(onClick = {
                        navController.navigate(AuthScreen.Login.route) {
                            popUpTo( AuthScreen.Main.route) { inclusive = false }
                        }
                    }) {
                        Text("Log In", color = colorResource(id = R.color.primary_Color))
                    }
                }
            }
        }
    )

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = {
                Text(text = "Terms & Conditions")
            },
            text = {
                Text("Please read and accept the terms and conditions to proceed.")
            },
            confirmButton = {
                Button(
                    onClick = {
                        termsAccepted = true
                        showDialog = false
                    }
                ) {
                    Text("Yes")
                }
            },
            dismissButton = {
                Button(
                    onClick = { showDialog = false }
                ) {
                    Text("No")
                }
            }
        )
    }
}
