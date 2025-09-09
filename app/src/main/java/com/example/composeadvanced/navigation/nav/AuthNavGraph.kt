package com.example.composeadvanced.navigation.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.composeadvanced.navigation.Graph
import com.example.composeadvanced.navigation.Screen
import com.example.composeadvanced.navigation.screen.LoginScreen
import com.example.composeadvanced.navigation.screen.SignUpScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        startDestination = Screen.Login.route,
        route = Graph.AUTH
    ) {
        composable(route = Screen.Login.route) {
            LoginScreen(
                navController
            )
        }
        composable(route = Screen.SignUp.route) {
            SignUpScreen(
                navController
            )
        }
    }
}