package com.acmetech.peliharain.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.acmetech.peliharain.ui.screen.authLanding.SplashScreen

fun NavGraphBuilder.splashNavGraph(
    navController: NavController
) {
    navigation(startDestination = PetScreen.Splashscreen.route, route = SPLASH_GRAPH_ROUTE) {

        composable(route = PetScreen.Splashscreen.route) {
            SplashScreen(
                navController = navController)
        }
    }
}