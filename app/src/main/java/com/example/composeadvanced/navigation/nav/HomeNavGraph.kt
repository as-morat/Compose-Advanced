package com.example.composeadvanced.navigation.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.composeadvanced.navigation.Graph
import com.example.composeadvanced.navigation.NavParams
import com.example.composeadvanced.navigation.Screen
import com.example.composeadvanced.navigation.screen.DetailScreen
import com.example.composeadvanced.navigation.screen.HomeScreen

fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {
    navigation(
        startDestination = Screen.Home.route,
        route = Graph.HOME
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(NavParams.NAME) {
                    type = NavType.StringType
                },
                navArgument(NavParams.AGE) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString(NavParams.NAME) ?: ""
            val age = backStackEntry.arguments?.getInt(NavParams.AGE) ?: 0

            DetailScreen(
                navController = navController,
                name = name,
                age = age
            )
        }
    }
}