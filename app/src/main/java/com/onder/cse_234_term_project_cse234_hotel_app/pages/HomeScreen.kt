package com.onder.cse_234_term_project_cse234_hotel_app.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.onder.cse_234_term_project_cse234_hotel_app.CustomTextField
import com.onder.cse_234_term_project_cse234_hotel_app.DateTextField
import com.onder.cse_234_term_project_cse234_hotel_app.R
import com.onder.cse_234_term_project_cse234_hotel_app.buttonlarge.ButtonLarge
import com.onder.cse_234_term_project_cse234_hotel_app.buttonlarge.Design
import com.onder.cse_234_term_project_cse234_hotel_app.navigation.BottomNavbarScreen
import com.onder.cse_234_term_project_cse234_hotel_app.navigation.Graph


@Composable
fun HomeScreen(navController: NavHostController){
    var location by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var date2 by remember { mutableStateOf("") }
    var counter by remember { mutableStateOf(1) }

    val isButtonEnabled = location.isNotEmpty() && date.isNotEmpty() && date2.isNotEmpty()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .windowInsetsPadding(WindowInsets.systemBars),
    ) {
        val imagePainter = painterResource(id = R.drawable.card_image)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Image(
                painter = imagePainter,
                contentDescription = "Background Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
        ) {
            Text(
                text = "Welcome, plan your journey!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.primary_Color)
            )

            Spacer(modifier = Modifier.height(48.dp))

            CustomTextField(
                value = location,
                onValueChange = { location = it},
                placeholder = "Example: Antalya",
                leadingIcon = painterResource(id = R.drawable.textbox_short_vector),
                label = "Where?",
                textcolor = Color.Black,
                labelFontWeight = FontWeight.ExtraBold,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DateTextField(
                    value = date,
                    onValueChange = { date = it },
                    placeholder = "DD/MM/YY",
                    leadingIcon = painterResource(id = R.drawable.textbox_short_vector),
                    label = "Check-in",
                    textcolor = Color.Black,
                    labelFontWeight = FontWeight.ExtraBold,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )

                DateTextField(
                    value = date2,
                    onValueChange = { date2 = it },
                    placeholder = "DD/MM/YY",
                    leadingIcon = painterResource(id = R.drawable.textbox_short_vector),
                    label = "Check-out",
                    textcolor = Color.Black,
                    labelFontWeight = FontWeight.ExtraBold,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            CustomCounterTextField(
                counter = counter,
                onValueChange = { counter = it }
            )

            Spacer(modifier = Modifier.height(64.dp))

            Button(
                onClick = {
                    if (isButtonEnabled) {
                        navController.navigate(Graph.DETAILS) {
                            popUpTo(BottomNavbarScreen.Home.route) {
                                inclusive = false
                            }
                        }
                    }
                },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.primary_Color)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .clip(RoundedCornerShape(50)),
                enabled = isButtonEnabled
            ){
                Text(
                    text = "Find",
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 28.sp
                )
            }
        }
    }
}

@Composable
fun CustomCounterTextField(counter: Int, onValueChange: (Int) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colors.surface, RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, colorResource(id = R.color.primary_Color), shape = RoundedCornerShape(8.dp))
                .shadow(4.dp, RoundedCornerShape(8.dp))
                .background(Color.White, RoundedCornerShape(8.dp)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { if (counter > 0) onValueChange(counter - 1) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Decrease")
            }
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = counter.toString(),
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold
                )
            }
            IconButton(onClick = { onValueChange(counter + 1) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Increase")
            }
        }
    }
}
