package com.adamearle.flickrfetchr.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.adamearle.flickrfetchr.presentation.detail.DetailScreen
import com.adamearle.flickrfetchr.presentation.home.HomeScreen
import com.adamearle.flickrfetchr.presentation.tag.TagScreen
import com.adamearle.flickrfetchr.presentation.util.Screen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                navigateToDetailScreen = { photo_id ->
                    navController.navigate("${Screen.Detail.route}/$photo_id")
                }
            )
        }
        composable(
            "${Screen.Detail.route}/{photo_id}",
            arguments = listOf(navArgument("photo_id") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailScreen(
                photo_id = backStackEntry.arguments?.getString("photo_id")!!,
                navigateToTagScreen = { tag ->
                    navController.navigate("${Screen.Tag.route}/$tag")
                }
            )
        }
        composable(
            "${Screen.Tag.route}/{tag}",
            arguments = listOf(navArgument("tag") { type = NavType.StringType })
        ) { backStackEntry ->
            TagScreen(
                tag = backStackEntry.arguments?.getString("tag")!!
            )
        }
    }
}