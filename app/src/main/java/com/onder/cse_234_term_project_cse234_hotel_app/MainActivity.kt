package com.onder.cse_234_term_project_cse234_hotel_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.relay.compose.RelayVector
import com.onder.cse_234_term_project_cse234_hotel_app.buttonlarge.ButtonLarge
import com.onder.cse_234_term_project_cse234_hotel_app.labelbox.LabelBox
import com.onder.cse_234_term_project_cse234_hotel_app.navigation.Screen
import com.onder.cse_234_term_project_cse234_hotel_app.ui.theme.Cse234termprojectcse234_hotel_AppTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //NavGraph()
//            Cse234termprojectcse234_hotel_AppTheme {
//
//            }
//https://github.com/onderpolatdemir/BranchTest.git

            //newbranch features
            val a: Int
            //secondd branch feature
            val b: String
            MainApp()
            //third branch feature
            val c : Int
            //master changes parallel to fourth branch
            val e:Int
            //fourth branch feature
            val d:Int
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    NavGraph(navController = navController)
}

@Composable
fun NavGraph(navController: NavHostController){
    //val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Main.route) {
        composable(route = Screen.Main.route) {
            MainPage(navController = navController)
        }
        composable(route = Screen.Login.route) {
            LoginPage(navController = navController)
        }
        composable(route = Screen.SignUp.route) {
            SignUpPage(navController = navController)
        }
        composable(route = Screen.HomePage.route) {
            HomePage(navController = navController)
        }
//        composable(Screen.Main.route) { MainPage(navController) }
//        composable(Screen.Login.route) { LoginPage(navController) }
//        composable(Screen.SignUp.route) { SignUpPage(navController) }
        //composable(Screen.ReservationPage.route) { HomePage(navController) }
        //composable(Screen.startHomePage.route) { startHomePage(navController)}
    }
}

@Composable
fun MainPage(navController: NavHostController) {

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

            // Overlaying content
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f)) // Adding a semi-transparent overlay to enhance text visibility
                    .padding(16.dp)
            ) {


                Spacer(modifier = Modifier.height(200.dp))

                Text(
                    text = "Welcome to Our App",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                Spacer(modifier = Modifier.height(150.dp))

                // Login Button
                ButtonLarge(
                    onClick = { navController.navigate(Screen.Login.route)  },
                    text = "Login",
                    design = com.onder.cse_234_term_project_cse234_hotel_app.buttonlarge.Design.Primary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp,)
                        .clip(RoundedCornerShape(50))
                )

                Spacer(modifier = Modifier.height(28.dp))

                //Sign Up
                ButtonLarge(
                    onClick = { navController.navigate(Screen.SignUp.route)  },
                    text = "Sign Up",
                    design = com.onder.cse_234_term_project_cse234_hotel_app.buttonlarge.Design.Outlined,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                        .clip(RoundedCornerShape(50))
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    title2: String,
    additionalTitle: String = "",
    colorPrimary: Color = colorResource(id = R.color.primary_Color),
    onBackClick: () -> Unit
) {
    TopAppBar(
        title = {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = title,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black,
                        modifier = Modifier
//                        .fillMaxWidth()
                            .wrapContentSize(Alignment.Center)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = title2,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = colorPrimary,
                        modifier = Modifier
//                        .fillMaxWidth()
                            .wrapContentSize(Alignment.Center)
                    )
                }

//                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = additionalTitle,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                        modifier = Modifier
//                        .fillMaxWidth()
                            .wrapContentSize(Alignment.Center)
                    )
                }
            }
        },
        colors = topAppBarColors(
        colorResource(id = R.color.backgroundLight)
        ),
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    //painter = painterResource(id = R.drawable.ic_back), // Replace with your back icon
                    contentDescription = "Back",
                    tint = colorPrimary
                )
            }
        }
    )
}


//@Composable
//fun BottomNavigationBar(navController: NavHostController) {
//    BottomNavigation(
//        backgroundColor = Color.White,
//        contentColor = Color(0xFF6200EE)
//    ) {
//        BottomNavigationItem(
//            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") },
//            label = { Text("Home") },
//            selected = false,
//            onClick = { navController.navigate("mainScreen") }
//        )
//        BottomNavigationItem(
//            icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorites") },
//            label = { Text("Favorites") },
//            selected = false,
//            onClick = { /* Handle Favorites click */ }
//        )
//        BottomNavigationItem(
//            icon = { Icon(imageVector = Icons.Default.DateRange, contentDescription = "My Bookings") },
//            label = { Text("My Bookings") },
//            selected = false,
//            onClick = { /* Handle My Bookings click */ }
//        )
//        BottomNavigationItem(
//            icon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Profile") },
//            label = { Text("Profile") },
//            selected = false,
//            onClick = { /* Handle Profile click */ }
//        )
//    }
//}


@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    leadingIcon: Painter,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder) },
        leadingIcon = { Icon(painter = leadingIcon, contentDescription = null) },
        visualTransformation = visualTransformation,
        singleLine = true,
        keyboardOptions = keyboardOptions,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 15.dp)
            .padding(horizontal = 12.dp)
            .shadow(4.dp, RoundedCornerShape(8.dp))
            .background(Color.White, RoundedCornerShape(8.dp))
    )
}

