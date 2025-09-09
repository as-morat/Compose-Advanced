package com.example.composeadvanced.navigation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composeadvanced.navigation.Graph
import com.example.composeadvanced.navigation.Screen

@Composable
fun HomeScreen(
    navController: NavController? = null
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Home",
            modifier = Modifier.clickable {
                navController?.navigate(Screen.Detail.createRoute("Rafat", 22))
            },
            color = Color.Blue,
            fontSize = 56.sp,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            modifier = Modifier
                .padding(top = 150.dp)
                .clickable { navController?.navigate(Graph.AUTH) },
            text = "Login/Sign Up",
            fontSize = 28.sp,
            fontWeight = FontWeight.Medium
        )
    }
}