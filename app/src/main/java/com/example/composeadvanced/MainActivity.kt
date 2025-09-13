package com.example.composeadvanced

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.composeadvanced.searchbar.ModernSearchScreen
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
//                MainScreen()
                ModernSearchScreen()
            }
        }
    }
}