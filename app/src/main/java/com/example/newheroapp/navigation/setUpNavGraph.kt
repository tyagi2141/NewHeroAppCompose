package com.example.newheroapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.newheroapp.presentation.screen.home.Home
import com.example.newheroapp.presentation.screen.splash.SplashScreen
import com.example.newheroapp.presentation.screen.welcome.WelcomeScreen
import com.example.newheroapp.util.Constant.DETAIL_ARGUMENT_KEY

@Composable
fun setUpNavGraph(navController: NavHostController) {

   // val currentRoute = navController.currentBackStackEntry?.arguments?.getString(KEY_ROUTE)
    NavHost(navController = navController, startDestination = Screen.Splash.route) {

        composable(route = Screen.Splash.route) { SplashScreen(navController = navController) }
        composable(route = Screen.Welcome.route) { WelcomeScreen(navController = navController) }
        composable(route = Screen.Home.route) { Home(navController = navController)}
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(DETAIL_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {

        }
        composable(route = Screen.Search.route) {}
    }

}