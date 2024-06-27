package com.onder.cse_234_term_project_cse234_hotel_app.pages

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.onder.cse_234_term_project_cse234_hotel_app.R
import com.onder.cse_234_term_project_cse234_hotel_app.TopBar
import com.onder.cse_234_term_project_cse234_hotel_app.buttonlarge.ButtonLarge
import com.onder.cse_234_term_project_cse234_hotel_app.buttonlarge.Design
import com.onder.cse_234_term_project_cse234_hotel_app.navigation.BottomNavbarScreen
import com.onder.cse_234_term_project_cse234_hotel_app.navigation.DetailsScreen
import com.onder.cse_234_term_project_cse234_hotel_app.navigation.Graph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HotelDetailsPage(navController: NavHostController) {
    val isFavorited = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopBar(
                title = "Hotel",
                title2 = "Details",
                onBackClick = { navController.popBackStack() },
                isFavorited = isFavorited.value,
                onFavoriteClick = { isFavorited.value = !isFavorited.value }
            )
        },
    ) {
        DetailsPage(navController = navController)
    }
}

@Composable
fun DetailsPage(navController: NavHostController) {

    val imagePainter = painterResource(id = R.drawable.card_image)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .windowInsetsPadding(WindowInsets.systemBars),
    ) {

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


        Spacer(modifier = Modifier.height(16.dp))

        // Hotel name, location, and description
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Column(

            ) {
                Text("Xanadu Resort", fontSize = 32.sp, fontWeight = FontWeight.ExtraBold)

                Spacer(modifier = Modifier.height(8.dp))

                Row {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Rating",
                        tint = colorResource(id = R.color.primary_Soft)
                    )
                    Text("Kermer, Antalya, Türkiye", fontSize = 20.sp)
                }


                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .background(
                            color = colorResource(id = R.color.purple_200).copy(alpha = 0.4f),
                            shape = RoundedCornerShape(32.dp)
                        )
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        androidx.compose.material3.Text(
                            text = "5",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            modifier = Modifier
                                .padding(end = 4.dp)
                                .padding(horizontal = 4.dp, vertical = 2.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Rating",
                            tint = colorResource(id = R.color.primary_Soft)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text("Description", fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    "Lorem Ipsum is simply dummy text of the printing" +
                            "and typesetting industry. Lorem Ipsum has been" +
                            "the industrys standard dummy text ever since " +
                            "the 1500s, when an unknown printer took a galley of " +
                            "type and scrambled it to make a type specimen book.  " +
                            "It has survived not only  five centuries, but also the leap into electronic ",
                    style = MaterialTheme.typography.body1
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Reviews button
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Review", fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)

                    TextButton(
                        onClick = {
                            navController.navigate(DetailsScreen.Review.route)
                        }) {
                        Text("See All")
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding()
                            //horizontal = 16.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "500 TL",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = colorResource(id = R.color.primary_Color)
                        )
                        Text(
                            text = "/ per night",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = { navController.navigate(DetailsScreen.BookingSummary.route) },
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = colorResource(id = R.color.primary_Color)
                            ),
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = "Book Now", color = Color.White, fontSize = 20.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}