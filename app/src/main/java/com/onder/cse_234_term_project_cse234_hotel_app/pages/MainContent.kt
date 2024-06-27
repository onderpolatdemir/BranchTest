package com.onder.cse_234_term_project_cse234_hotel_app.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.onder.cse_234_term_project_cse234_hotel_app.R
import com.onder.cse_234_term_project_cse234_hotel_app.buttonlarge.ButtonLarge
import com.onder.cse_234_term_project_cse234_hotel_app.buttonlarge.Design


@Composable
fun MainContent(
    onClick: () -> Unit,
    onSignUpClick: () -> Unit,
) {

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = Color.Transparent,
        darkIcons = true
    )

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars),
        color = Color.Transparent
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.main_photo),
                contentDescription = "Background Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .padding(16.dp)
            ) {

                Spacer(modifier = Modifier.height(200.dp))

                Text(
                    text = "Welcome to StaySafeHotel",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                Spacer(modifier = Modifier.height(150.dp))

                // Login Button
                ButtonLarge(
                    onClick = {onClick()},
                    text = "Login",
                    design = Design.Primary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp,)
                        .clip(RoundedCornerShape(50))
                )

                Spacer(modifier = Modifier.height(28.dp))

                //Sign Up
                ButtonLarge(
                    onClick = {onSignUpClick()},
                    text = "Sign Up",
                    design = Design.Outlined,
                    modifier = Modifier
                        .clickable { onSignUpClick() }
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                        .clip(RoundedCornerShape(50))
                )
            }
        }
    }
}
