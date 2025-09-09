package com.example.composeadvanced.navigation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composeadvanced.navigation.Screen

@Composable
fun DetailScreen(
    navController: NavController? = null,
    name: String,
    age: Int
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Detail",
                modifier = Modifier.clickable { // Clear backstack up to home
                    navController?.popBackStack(Screen.Home.route, inclusive = false) },
                color = Color.Red,
                fontSize = 56.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            color = Color.Blue,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    ) {
                        append("Name: ")
                    }
                    withStyle(
                        SpanStyle(
                            color = Color.LightGray,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    ) {
                        append(name)
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            color = Color.Blue,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    ) {
                        append("Age: ")
                    }
                    withStyle(
                        SpanStyle(
                            color = Color.LightGray,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    ) {
                        append(age.toString())
                    }
                }
            )
        }
    }
}