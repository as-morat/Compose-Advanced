package com.example.composeadvanced.box

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Run() {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier =   Modifier
                .padding(10.dp)
                .size(350.dp, 55.dp)
                .shadow(12.dp, RoundedCornerShape(18))
                .clip(RoundedCornerShape(18))
                .background(
                    brush = Brush.linearGradient(
                        listOf(
                            Color.Magenta,
                            Color.Cyan
                        )
                    )
                )
                .verticalScroll(rememberScrollState())
                .horizontalScroll(rememberScrollState())
        ){
            Column (Modifier.padding(5.dp)){
                Text(
                    "Hello World",
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
                Text(
                    "It's me Ash.",
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    "Welcome me to the app world...",
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}