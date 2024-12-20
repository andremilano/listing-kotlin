package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.pastelBrown

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
                                    color = Color.White,
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
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Icon(
                                        imageVector = Icons.Filled.ExitToApp, // Gunakan icon Material
                                        contentDescription = "Login Icon",
                                        tint = MaterialTheme.colorScheme.onPrimary
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
                        BottomApp()
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
        MyCard(content = "Ini adalah Card kelima!", navController = navController)
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