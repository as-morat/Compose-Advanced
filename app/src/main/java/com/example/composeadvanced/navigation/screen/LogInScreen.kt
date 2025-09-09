package com.example.composeadvanced.navigation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
fun LoginScreen(
    navController: NavController ?= null,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.clickable { navController?.navigate(Screen.SignUp.route) },
            text = "Login",
            color = Color.Magenta,
            fontSize = 56.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            modifier = Modifier.clickable { navController?.popBackStack() },
            text = "Go Back",
            color = Color.Gray,
            fontSize = 24.sp
        )

        Text(
            modifier = Modifier
                .padding(top = 150.dp)
                .clickable {
                    // Navigate to detail and clear auth backstack
                    navController?.navigate(Screen.Detail.createRoute("Morat", 22)) {
                        popUpTo(Graph.AUTH) { inclusive = true }
                    }
                },
            text = "Open Detail Screen",
            fontSize = 28.sp,
            fontWeight = FontWeight.Medium
        )
    }
}