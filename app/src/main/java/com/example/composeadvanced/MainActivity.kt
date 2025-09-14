package com.example.composeadvanced

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeadvanced.shimmer.AnimatedShimmer
import com.example.composeadvanced.ui.theme.ComposeAdvancedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeAdvancedTheme {
                Column(Modifier.padding(vertical = 10.dp)) {
                    repeat( 10 ){
                        AnimatedShimmer()
                    }
                }
            }
        }
    }
}