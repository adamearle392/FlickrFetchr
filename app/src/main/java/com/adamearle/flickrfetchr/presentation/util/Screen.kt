package com.adamearle.flickrfetchr.presentation.util

sealed class Screen(val route: String) {
    object Home : Screen("Home")
    object Detail : Screen("Detail")
    object Tag : Screen("Tag")
}