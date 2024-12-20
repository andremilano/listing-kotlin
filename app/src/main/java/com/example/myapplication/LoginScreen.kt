package com.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Welcome to Login Screen",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary
                )

                // Tombol Back to Home
                Button(
                    onClick = { navController.navigate("home") }, // Navigasi kembali ke Home
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "Back to Home")
                }

//                tombol register
                Button(
                    onClick = { navController.navigate("register") }, // Navigasi ke halaman register
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Register",
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                }
            }
        }
    }
}
