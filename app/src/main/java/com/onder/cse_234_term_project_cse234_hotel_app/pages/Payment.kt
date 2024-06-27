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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
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
import androidx.compose.ui.modifier.modifierLocalConsumer
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
import com.onder.cse_234_term_project_cse234_hotel_app.buttonlarge.ButtonLarge
import com.onder.cse_234_term_project_cse234_hotel_app.buttonlarge.Design
import com.onder.cse_234_term_project_cse234_hotel_app.navigation.DetailsScreen
import com.onder.cse_234_term_project_cse234_hotel_app.navigation.Graph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PaymentPage(navController: NavHostController) {
    Scaffold(
        topBar = {
            SimpleTopBar(
                title = "",
                title2 = "Payment",
                onBackClick = { navController.popBackStack() },
            )
        },
    ) {
        PaymentScreen(navController = navController)
    }
}
@Composable
fun PaymentScreen(navController: NavHostController) {

    var cardHolderName by remember { mutableStateOf("") }
    var cardNumber by remember { mutableStateOf("") }
    var expiryDate by remember { mutableStateOf("") }
    var cvv by remember { mutableStateOf("") }

    val isButtonEnabled = cardHolderName.isNotEmpty() &&
            cardNumber.length == 16 &&
            expiryDate.matches(Regex("""\d{2}/\d{2}""")) &&
            cvv.length == 3

    val creditCardOffsetMapping = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 3) return offset
            if (offset <= 7) return offset + 1
            if (offset <= 11) return offset + 2
            if (offset <= 16) return offset + 3
            return 19
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <= 4) return offset
            if (offset <= 9) return offset - 1
            if (offset <= 14) return offset - 2
            if (offset <= 19) return offset - 3
            return 16
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .background(
                    color = colorResource(id = R.color.primary_Color).copy(alpha = 0.3f)
                ),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Total Price ₺500",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.black)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))


        CustomTextField(
            value = cardHolderName,
            onValueChange = { cardHolderName = it },
            placeholder = "Your Name",
            label = "Card Holder Name",
            textcolor = Color.Black,
            leadingIcon = painterResource(id = R.drawable.label_box_vector), // Replace with your email icon
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            labelFontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(32.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "Card Number",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(
                value = cardNumber,
                onValueChange = {
                    cardNumber = it.take(16)
                },
                visualTransformation = object : VisualTransformation {
                    override fun filter(text: AnnotatedString): TransformedText {
                        val trimmed = if (text.text.length >= 16) text.text.substring(0..15) else text.text
                        var out = ""

                        for (i in trimmed.indices) {
                            out += trimmed[i]
                            if (i % 4 == 3 && i != 15) out += "-"
                        }
                        return TransformedText(
                            AnnotatedString(out),
                            creditCardOffsetMapping
                        )
                    }
                },
                placeholder = { Text("**** **** **** ****") }, // Placeholder text
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF6200EA), // Purple color when focused
                    unfocusedBorderColor = Color(0xFF6200EA) // Purple color when not focused
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ExpiryDateTextField(
                value = expiryDate,
                onValueChange = { expiryDate = it },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            CVVTextField(
                value = cvv,
                onValueChange = { cvv = it },
                modifier = Modifier.weight(1f)
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
                navController.navigate(DetailsScreen.Confirm.route)
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.primary_Color),
                contentColor = Color.White
            ),
        ) {
            Text(
                "Pay",
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun ExpiryDateTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier
) {
    CustomTextField(
        value = value,
        onValueChange = { newValue ->
            val digitsOnly = newValue.filter { it.isDigit() }
            val formattedValue = when {
                digitsOnly.length >= 3 -> digitsOnly.substring(0, 2) + "/" + digitsOnly.substring(2, digitsOnly.length.coerceAtMost(4))
                else -> digitsOnly
            }
            if (formattedValue.length <= 5) {
                onValueChange(formattedValue)
            }
        },
        placeholder = "MM/YY",
        label = "Expiry Date",
        textcolor = Color.Black,
        labelFontWeight = FontWeight.ExtraBold,
        leadingIcon = painterResource(id = R.drawable.component_1_vector2),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        modifier = modifier
    )
}

@Composable
fun CVVTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier
) {
    CustomTextField(
        value = value,
        onValueChange = { newValue ->
            if (newValue.length <= 3) {
                onValueChange(newValue.filter { it.isDigit() })
            }
        },
        placeholder = "***",
        label = "CVV",
        textcolor = Color.Black,
        leadingIcon = painterResource(id = R.drawable.component_1_vector2),
        labelFontWeight = FontWeight.ExtraBold,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        modifier = modifier
    )
}
