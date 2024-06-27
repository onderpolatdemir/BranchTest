package com.onder.cse_234_term_project_cse234_hotel_app.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ReviewPage(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Reviews") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(20.dp)
                    .background(Color.White)
            ) {
                // Reviews header
                Text("4.5", )
                Row {
                    repeat(4) {
                        Icon(Icons.Filled.Star, contentDescription = "Star", tint = Color.Yellow)
                    }
                    Icon(Icons.Filled.Star, contentDescription = "Half Star", tint = Color.Yellow)
                }

                Spacer(modifier = Modifier.height(16.dp))

//                // Reviews list
//                LazyColumn {
//                    items(sampleReviews) { review ->
//                        Row(verticalAlignment = Alignment.CenterVertically) {
//                            CircleAvatar(imageUrl = review.avatarUrl, size = 40.dp)
//                            Column(modifier = Modifier.padding(start = 8.dp)) {
//                                Text(review.name, style = MaterialTheme.typography.body1)
//                                Text(review.comment, style = MaterialTheme.typography.body2)
//                            }
//                            Spacer(modifier = Modifier.weight(1f))
//                            Text("${review.rating}", style = MaterialTheme.typography.body1)
//                        }
//                        Divider()
//                    }
//                }

                Spacer(modifier = Modifier.height(16.dp))

                // Add a Comment button
                Button(
                    onClick = { /* Handle add comment navigation */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                        .clip(RoundedCornerShape(50))
                ) {
                    Text("Add a Comment +")
                }
            }
        }
    )
}

// Sample data class for reviews
data class Review(val name: String, val comment: String, val rating: Float, val avatarUrl: String)
val sampleReviews = listOf(
    Review("Ayse Yavuz", "Amazing. The room is good than the picture", 4.0f, "URL_TO_AVATAR"),
    Review("Baris Ayhan", "Amazing. The room is good than the picture", 5.0f, "URL_TO_AVATAR"),
    // Add more sample reviews
)
