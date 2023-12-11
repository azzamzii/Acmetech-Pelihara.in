package com.acmetech.peliharain.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.acmetech.peliharain.ui.screen.authLanding.register.RegisterPage

fun NavGraphBuilder.regisNavGraph(
    navController: androidx.navigation.NavController
) {
    navigation(startDestination = PetScreen.RegisPage.route, route = REGIST_GRAPH_ROUTE) {

        composable(route = PetScreen.RegisPage.route) {
            RegisterPage(navController = navController)
        }
    }
}