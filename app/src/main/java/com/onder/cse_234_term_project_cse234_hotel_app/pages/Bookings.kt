package com.onder.cse_234_term_project_cse234_hotel_app.pages

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.onder.cse_234_term_project_cse234_hotel_app.R
import com.onder.cse_234_term_project_cse234_hotel_app.SimpleTopBar
import com.onder.cse_234_term_project_cse234_hotel_app.TopBar


@Composable
fun BookingsPage(navController: NavHostController){

    val bookings = listOf(
        Booking("Belek Resort",
            "Antalya, Türkiye",
            "1000 ₺",
            4.5,
            "https://example.com/image.jpg",
            "30 June",
            "32 May"),
        Booking("Xanadu Resort",
            "Antalya, Türkiye",
            "1000 ₺",
            4.5,
            "https://example.com/image.jpg",
            "30 June",
            "32 May"),
        Booking("Xanadu Resort",
            "Antalya, Türkiye",
            "1000 ₺",
            4.5,
            "https://example.com/image.jpg",
            "30 June",
            "32 May"),
        Booking("Xanadu Resort",
            "Antalya, Türkiye",
            "1000 ₺",
            4.5,
            "https://example.com/image.jpg",
            "30 June",
            "32 May"),
        Booking("Xanadu Resort",
            "Antalya, Türkiye",
            "1000 ₺",
            4.5,
            "https://example.com/image.jpg",
            "30 June",
            "32 May"),
        Booking("Xanadu Resort",
            "Antalya, Türkiye",
            "1000 ₺",
            4.5,
            "https://example.com/image.jpg",
            "30 June",
            "32 May"),
        Booking("Xanadu Resort",
            "Antalya, Türkiye",
            "1000 ₺",
            4.5,
            "https://example.com/image.jpg",
            "30 June",
            "32 May"),
        Booking("Xanadu Resort",
            "Antalya, Türkiye",
            "1000 ₺",
            4.5,
            "https://example.com/image.jpg",
            "30 June",
            "32 May"),
        Booking("Xanadu Resort",
            "Antalya, Türkiye",
            "1000 ₺",
            4.5,
            "https://example.com/image.jpg",
            "30 June",
            "32 May"),
        Booking("Xanadu Resort",
            "Antalya, Türkiye",
            "1000 ₺",
            4.5,
            "https://example.com/image.jpg",
            "30 June",
            "32 May"),
    )

    Column(modifier = Modifier.fillMaxSize()) {
        SimpleTopBar(
            title = "",
            title2 = "My Bookings",
            onBackClick = { navController.navigateUp() }
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(bookings) { booking ->
                BookingCard(booking = booking)
            }
        }
    }
}

@Composable
fun BookingCard(booking: Booking) {
    var showDialog by remember { mutableStateOf(false) }
    var showSuccessMessage by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Sure want to cancel?") },
            text = { Text("Are you sure you want to cancel the booking?") },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                        showSuccessMessage = true
                    }
                ) {
                    Text("Yes")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showDialog = false }
                ) {
                    Text("No")
                }
            }
        )
    }

    if (showSuccessMessage) {
        Snackbar(
            action = {
                TextButton(onClick = { showSuccessMessage = false }) {
                    Text("Dismiss")
                }
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Your cancel is successful!")
        }
    }


    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .background(color = colorResource(id = R.color.primary_Color).copy(alpha = 0.28f))
                .padding(16.dp)
        ) {
            val imagePainter = painterResource(id = R.drawable.card_image)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = imagePainter,
                    contentDescription = booking.hotelName,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(RoundedCornerShape(8.dp))
                )

                Spacer(modifier = Modifier.width(48.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = booking.hotelName,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = booking.location,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = booking.price,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )

                        Spacer(modifier = Modifier.width(4.dp))


                        Box(
                            modifier = Modifier
                                .background(
                                    color = colorResource(id = R.color.purple_200).copy(alpha = 0.4f),
                                    shape = RoundedCornerShape(32.dp)
                                )
                        )  {
                            Row(
                                modifier = Modifier.padding(4.dp),
                                verticalAlignment = Alignment.CenterVertically

                            ) {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = "Rating",
                                    tint = colorResource(id = R.color.primary_Soft),
                                    modifier = Modifier.size(16.dp),
                                )
                                Text(
                                    text = booking.rating.toString(),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp
                                )
                            }

                        }
                    }
                }

                Button(
                    onClick = { showDialog = true },
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF7E57C2)),
                    modifier = Modifier.size(width = 80.dp, height = 48.dp) // Adjust button size
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Cancel", color = Color.White, fontSize = 12.sp)
                        Text(text = "Booking", color = Color.White, fontSize = 12.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Check-in", fontSize = 14.sp, color = Color.Gray)
                    Text(text = booking.checkInDate, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }

                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "To")

                Column {
                    Text(text = "Check-out", fontSize = 14.sp, color = Color.Gray)
                    Text(text = booking.checkOutDate, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }
        }
    }
}

data class Booking(
    val hotelName: String,
    val location: String,
    val price: String,
    val rating: Double,
    val imageUrl: String,
    val checkInDate: String,
    val checkOutDate: String
)