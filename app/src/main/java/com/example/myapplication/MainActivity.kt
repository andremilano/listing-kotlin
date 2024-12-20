package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.*
import com.example.myapplication.LoginScreen
import com.example.myapplication.RegisterScreen
import com.example.myapplication.DetailsCard
import com.example.myapplication.MyCard

val montserrat = FontFamily(
    Font(R.font.mlight, FontWeight.Light),
    Font(R.font.mmedium, FontWeight.Medium),
)

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "My TopBar",
                                    color = Color.Black,
                                    fontFamily = montserrat
                                )
                            },
                            actions = {
                                Button(
                                    onClick = { navController.navigate("login") }, // Navigasi ke halaman login
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    Text(
                                        text = "Login",
                                        color = MaterialTheme.colorScheme.onPrimary,
                                        fontFamily = montserrat,
                                    )
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = pastelBrown,
                                titleContentColor = MaterialTheme.colorScheme.onPrimary
                            )
                        )
                    },
                    bottomBar = {
                        BottomAppBar(
                            containerColor = pastelBrown,
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "BottomBar Content",
                                    color = Color.White,
                                    fontFamily = montserrat
                                )
                            }
                        }
                    },
                    content = { padding ->
                        NavigationHost(navController = navController, padding = padding)
                    }
                )
            }
        }
    }
}

@Composable
fun NavigationHost(navController: NavHostController, padding: PaddingValues) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController = navController, padding = padding)}
        composable("login") { LoginScreen(navController = navController) } // Rute untuk LoginScreen
        composable("register") { RegisterScreen(navController = navController) } // Rute untuk RegisterScreen
        composable("details") { DetailsCard(navController = navController) } // Rute untuk DetailCard
    }
}

@Composable
fun HomeScreen(navController: NavController, padding: PaddingValues) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(16.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        MyCard(content = "Ini adalah Card pertama!", navController = navController)
        MyCard(content = "Ini adalah Card kedua!", navController = navController)
        MyCard(content = "Ini adalah Card ketiga!", navController = navController)
        MyCard(content = "Ini adalah Card keempat!", navController = navController)
    }
}
// Preview
@Preview(showBackground = true)
@Composable
fun MyCardPreview() {
    MyApplicationTheme {
        MyCard(content = "Ini adalah Card Preview", navController = rememberNavController())
    }
}