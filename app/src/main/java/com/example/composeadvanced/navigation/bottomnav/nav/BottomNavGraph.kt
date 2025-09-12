package com.example.composeadvanced.navigation.bottomnav.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composeadvanced.navigation.bottomnav.bottomclass.BottomBarScreen
import com.example.composeadvanced.navigation.bottomnav.screen.HomeScreen
import com.example.composeadvanced.navigation.bottomnav.screen.ProfileScreen
import com.example.composeadvanced.navigation.bottomnav.screen.SettingScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(BottomBarScreen.Home.route) { HomeScreen() }
        composable(BottomBarScreen.Profile.route) { ProfileScreen() }
        composable(BottomBarScreen.Setting.route) { SettingScreen() }
    }
}