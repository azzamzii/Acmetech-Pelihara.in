package com.acmetech.peliharain.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.acmetech.peliharain.ui.screen.authLanding.login.LoginPage

fun NavGraphBuilder.authNavGraph(
    navController: androidx.navigation.NavController
) {
    navigation(startDestination = PetScreen.LoginPage.route, route = AUTH_GRAPH_ROUTE) {

        composable(route = PetScreen.LoginPage.route) {
            LoginPage(navController = navController)
        }
    }
}