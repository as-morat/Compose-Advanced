package com.example.composeadvanced

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.composeadvanced.navigation.bottomnav.MainScreen
import com.example.composeadvanced.navigation.nav.NavGraph
import com.example.composeadvanced.ui.theme.ComposeAdvancedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeAdvancedTheme {
//                RunPass()
//                RunPrev()
//                HomeScreen()
//                DetailScreen()
//                val navController = rememberNavController()
//                NavGraph(navController = navController)
                MainScreen()
            }
        }
    }
}