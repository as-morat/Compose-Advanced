package com.example.composeadvanced.navigation.bottomnav.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text

@Composable
fun SettingScreen(modifier: Modifier = Modifier) {
    Box(
        modifier.fillMaxSize(),
        Alignment.Center
    ){
        Text(
            "Setting",
            fontSize = 56.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Blue
        )
    }
}