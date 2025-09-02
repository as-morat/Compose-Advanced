package com.example.composeadvanced.card

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Run() {
    var expandableState by remember { mutableStateOf(false) }

    // Rotate animation for arrow
    val rotationState by animateFloatAsState(
        targetValue = if (expandableState) 180f else 0f
    )

    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 80,
                        easing = LinearOutSlowInEasing
                    )
                ),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            ),
            onClick = { expandableState = !expandableState }
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.linearGradient(
                            listOf(Color.Blue, Color.Cyan)
                        )
                    )
                    .padding(12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Hey Ash.",
                        modifier = Modifier.weight(6f),
                        fontSize = 32.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )

                    IconButton(
                        modifier = Modifier
                            .alpha(.84f)
                            .weight(1f)
                            .rotate(rotationState),
                        onClick = { expandableState = !expandableState }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "DropDown Icon",
                            tint = Color.White
                        )
                    }
                }

                if (expandableState) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "This is expandable content!",
                        fontSize = 18.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}
