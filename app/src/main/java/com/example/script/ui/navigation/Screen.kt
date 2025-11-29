package com.example.script.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Reader : Screen("reader/{bookId}") {
        fun createRoute(bookId: Int) = "reader/$bookId"
    }
}
