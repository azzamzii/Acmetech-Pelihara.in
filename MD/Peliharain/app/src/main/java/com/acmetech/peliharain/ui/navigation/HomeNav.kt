@file:JvmName("HomeNavKt")

package com.acmetech.peliharain.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.acmetech.peliharain.PeliharainApp
import com.acmetech.peliharain.ui.components.Pet.PetFormPage
import com.acmetech.peliharain.ui.components.Pet.PetShopPage

fun NavGraphBuilder.scaffoldNavGraph(
    navController: NavController
) {
    navigation(startDestination = PetScreen.Home.route, route = SCAFFOLD_GRAPH_ROUTE) {

        composable(route = PetScreen.Home.route) {
            PeliharainApp(navController = navController)
        }

        composable(route = PetScreen.PetForm.route) {
            PetFormPage(navController = navController)
        }

        composable(route = PetScreen.PetShop.route) {
            PetShopPage(navController = navController)
        }
    }
}