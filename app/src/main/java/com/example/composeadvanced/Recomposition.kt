package com.example.composeadvanced

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Recomposition() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        var value by remember { mutableStateOf(false) }

        // Gradient + rounded corner button with shadow
        Box(
            modifier = Modifier
                .size(150.dp, 80.dp)
                .shadow(12.dp, RoundedCornerShape(18.dp))
                .background(
                    brush = Brush.linearGradient(
                        listOf(
                            Color(0xFFFF1F50),
                            Color(0xFFFF5E1F),
                            Color(0xFFFFCE1F),
                        )
                    ),
                    shape = RoundedCornerShape(18.dp)
                )
                .clickable { value = !value }, // Clicking changes the state
            contentAlignment = Alignment.Center
        ) {
            Text(text = "$value",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp
            )
        }

        /*
        Recomposition Concept Notes:

        1. Only the UI parts that read the state 'value' will recompose when 'value' changes.
        2. Clicking the button changes 'value', which triggers recomposition.
        3. Other parts of the UI that do not depend on 'value' will not recompose.
        4. This is how Jetpack Compose efficiently updates only what is needed.
        */
    }
}
