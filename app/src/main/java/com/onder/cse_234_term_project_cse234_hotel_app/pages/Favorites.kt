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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.onder.cse_234_term_project_cse234_hotel_app.CustomTextField
import com.onder.cse_234_term_project_cse234_hotel_app.R
import com.onder.cse_234_term_project_cse234_hotel_app.SimpleTopBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FavoritesPage(navController: NavHostController){
    Scaffold(
        topBar = {
            SimpleTopBar(
                title = "",
                title2 = "Favorites",
                onBackClick = { navController.popBackStack() },
            )
        },
    ) {
        FavoritePage(navController = navController)
    }
}


@Composable
fun FavoritePage(navController: NavHostController) {
    var searchQuery by remember { mutableStateOf("") }
    val hotels = listOf(
        Hotel("Xanadu Resort", "Antalya, Türkiye", 4.5, "https://example.com/image.jpg", "500 ₺"),
        Hotel("Royal Seginus", "Antalya, Türkiye", 4.8, "https://example.com/image.jpg", "600 ₺"),
        Hotel("Xanadu Resort", "Antalya, Türkiye", 4.5, "https://example.com/image.jpg", "500 ₺"),
        Hotel("Royal Seginus", "Antalya, Türkiye", 4.8, "https://example.com/image.jpg", "600 ₺"),
        Hotel("Xanadu Resort", "Antalya, Türkiye", 4.5, "https://example.com/image.jpg", "500 ₺"),
        Hotel("Royal Seginus", "Antalya, Türkiye", 4.8, "https://example.com/image.jpg", "600 ₺"),
        Hotel("Xanadu Resort", "Antalya, Türkiye", 4.5, "https://example.com/image.jpg", "500 ₺"),
        Hotel("Royal Seginus", "Antalya, Türkiye", 4.8, "https://example.com/image.jpg", "600 ₺")
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(100.dp))
        }

        item {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Location",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Antalya, Türkiye",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = colorResource(id = R.color.primary_Color)
                )
                Spacer(modifier = Modifier.height(16.dp)
                )
            }
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                        .background(
                            color = colorResource(id = R.color.primary_Soft).copy(alpha = 0.4f),
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    IconTextItem(
                        icon = Icons.Default.DateRange,
                        text = "22 May - 23 May"
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                        .background(
                            color = colorResource(id = R.color.primary_Soft).copy(alpha = 0.4f),
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    IconTextItem(
                        icon = Icons.Default.Person,
                        text = "2 Guests"
                    )
                }
            }
        }


        item {
            CustomTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = "Search",
                leadingIcon = painterResource(id = R.drawable.search),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        items(hotels.chunked(2)) { rowHotels ->
            Row(modifier = Modifier.fillMaxWidth()) {
                rowHotels.forEach { hotel ->
                    HotelCard(
                        hotel = hotel,
                        navController = navController,
                        modifier = Modifier
                        .weight(1f)
                        .padding(4.dp))
                }
                if (rowHotels.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewFavoritePage() {
    FavoritesPage(navController = rememberNavController())
}
