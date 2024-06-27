package com.onder.cse_234_term_project_cse234_hotel_app.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
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
import com.onder.cse_234_term_project_cse234_hotel_app.TopBar
import com.onder.cse_234_term_project_cse234_hotel_app.navigation.DetailsScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FindHotelScreen(navController: NavHostController){
    Scaffold(
        topBar = {
            SimpleTopBar(
                title = "",
                title2 = "Hotels",
                onBackClick = { navController.popBackStack() },
            )
        },
    ) {
        MainPage(navController = navController)
    }
}

@Composable
fun MainPage(navController: NavHostController) {
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

@Composable
fun IconTextItem(icon: ImageVector, text: String) {
    Row(
        //horizontalAlignment = Alignment.CenterHorizontally,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = Color.Black)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text, fontSize = 14.sp)
    }
}

data class Hotel(
    val name: String,
    val location: String,
    val rating: Double,
    val imageUrl: String,
    val price: String
)

@Composable
fun HotelCard(hotel: Hotel, navController: NavHostController, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate(DetailsScreen.HotelDetails.route)
            }
    ) {
        Column {
            val imagePainter = painterResource(id = R.drawable.card_image)
            Image(
                painter = imagePainter,
                contentDescription = hotel.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .shadow(elevation = 12.dp, shape = RoundedCornerShape(8.dp))
            )
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
                    Text(
                        text = hotel.rating.toString(),
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
            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = hotel.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Row {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Rating",
                        tint = Color.Gray
                    )
                    Text(
                        text = hotel.location,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
                Text(
                    text = hotel.price,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.primary_Color))
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewMainPage() {
    FindHotelScreen(navController = rememberNavController())
}
