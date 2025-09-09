package com.example.composeadvanced.navigation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.composeadvanced.navigation.Graph

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Graph.HOME
    ) {
        homeNavGraph(navController)
        authNavGraph(navController)
    }
}