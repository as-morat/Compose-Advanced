package com.example.composeadvanced.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")

    data object Detail : Screen("detail/{name}/{age}") {
        fun createRoute(name: String, age: Int) = "detail/$name/$age"
    }

    data object Login: Screen(route = "login")
    data object SignUp: Screen(route = "signup")
}

// Graph routes for nested navigation
data object Graph {
    const val HOME = "home_graph"
    const val AUTH = "auth_graph"
}

// Parameter keys for type safety
data object NavParams {
    const val NAME = "name"
    const val AGE = "age"
}