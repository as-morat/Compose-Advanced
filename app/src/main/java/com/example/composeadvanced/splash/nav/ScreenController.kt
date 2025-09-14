package com.example.composeadvanced.splash.nav

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composeadvanced.splash.main.AnimatedSplashScreen

@Composable
fun ScreenNavController(navController: NavHostController) {
    NavHost(
        navController,
        Screen.Splash.route
    ) {
        composable(Screen.Splash.route){
            AnimatedSplashScreen(navController)
        }
        composable(Screen.Home.route){
            Modifier.fillMaxSize()
        }
    }
}