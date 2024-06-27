package com.onder.cse_234_term_project_cse234_hotel_app.pages

import android.annotation.SuppressLint
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.onder.cse_234_term_project_cse234_hotel_app.CustomTextField
import com.onder.cse_234_term_project_cse234_hotel_app.R
import com.onder.cse_234_term_project_cse234_hotel_app.SimpleTopBar
import com.onder.cse_234_term_project_cse234_hotel_app.navigation.Graph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ConfirmPage(navController: NavHostController) {
    Scaffold(
        topBar = {
            SimpleTopBar(
                title = "",
                title2 = "Payment",
                onBackClick = { navController.popBackStack() },
            )
        },
    ) {
        ConfirmScreen(navController = navController)
    }
}
@Composable
fun ConfirmScreen(navController: NavHostController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(
                    color = colorResource(id = R.color.backgroundLight)
                ),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.black)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(
                    color = colorResource(id = R.color.primary_Color).copy(alpha = 0.3f)
                ),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Congratulations!",
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold,
                color = colorResource(id = R.color.primary_Color)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "Your accomodation is\n" +
                        "approved. Thank you for \n" +
                        "choosing us. we wish you \n" +
                        "a pleasant vacation",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp,)
                .clip(RoundedCornerShape(50))
                .height(61.dp),
            onClick = {
                navController.navigate(Graph.HOME)
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.primary_Color),
                contentColor = Color.White
            ),
        ) {
            Text(
                "Go Back to Home",
                fontSize = 24.sp
            )
        }
    }
}