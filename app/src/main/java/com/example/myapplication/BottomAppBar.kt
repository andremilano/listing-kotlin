package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.pastelBrown

@Composable
fun BottomApp() {
    BottomAppBar(
        containerColor = pastelBrown, // Warna latar belakang BottomAppBar
        contentColor = Color.White, // Warna konten (ikon)
        modifier = Modifier.height(56.dp) // Tinggi BottomAppBar
    ) {
        // Row untuk mengatur ikon di dalam BottomAppBar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly, // Membagi ruang secara merata
            verticalAlignment = Alignment.CenterVertically // Menjaga ikon tetap sejajar di tengah
        ) {
            IconButton(onClick = { /* Handle Home button click */ }) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home Icon", tint = Color.White)
            }
            IconButton(onClick = { /* Handle Search button click */ }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon", tint = Color.White)
            }
            IconButton(onClick = { /* Handle Account button click */ }) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Account Icon", tint = Color.White)
            }
        }
    }
}
