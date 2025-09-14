package com.example.composeadvanced.splash.nav

sealed class Screen(val route: String) {
    data object Splash: Screen("splash")
    data object Home: Screen("home")
}