

package com.acmetech.peliharain

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.acmetech.peliharain.ui.components.PeliharainScaffold
import com.acmetech.peliharain.ui.components.Peliharainbar
import com.acmetech.peliharain.ui.screen.dashboard.HomeSections
import com.acmetech.peliharain.ui.screen.dashboard.PeliharainBottomBar
import com.acmetech.peliharain.ui.screen.dashboard.addHomeGraph
import com.acmetech.peliharain.ui.screen.detail_page.PetCareDetailCat
import com.acmetech.peliharain.ui.theme.PeliharainTheme


@Composable
fun PeliharainApp(navController: NavController) {
    PeliharainTheme() {
        val appState = rememberPeliharainAppState()
        PeliharainScaffold(
            bottomBar = {
                if (appState.shouldShowBottomBar) {
                    PeliharainBottomBar(
                        tabs = appState.bottomBarTabs,
                        currentRoute = appState.currentRoute!!,
                        navigateToRoute = appState::navigateToBottomBarRoute
                    )
                }
            },
            snackbarHost = {
                SnackbarHost(
                    hostState = it,
                    modifier = Modifier.systemBarsPadding(),
                    snackbar = { snackbarData -> Peliharainbar(snackbarData) }
                )
            },
            scaffoldState = appState.scaffoldState
        ) { innerPaddingModifier ->
            NavHost(
                navController = appState.navController,
                startDestination = MainDestinations.HOME_ROUTE,
                modifier = Modifier.padding(innerPaddingModifier)
            ) {
                jetsnackNavGraph(
                    onSnackSelected = appState::navigateToPetCareDetail,
                    upPress = appState::upPress,
                    navController = navController
                )
            }
        }
    }
}

private fun NavGraphBuilder.jetsnackNavGraph(
    onSnackSelected: (Long, NavBackStackEntry) -> Unit,
   // onSnackSelected: (Long, NavBackStackEntry, LifecycleOwner) -> Unit,
    upPress: () -> Unit,
    navController: NavController
) {
    navigation(
        route = MainDestinations.HOME_ROUTE,
        startDestination = HomeSections.FEED.route
    ) {
        addHomeGraph(navController,onSnackSelected)
    }
    composable(
        "${MainDestinations.SNACK_DETAIL_ROUTE}/{${MainDestinations.SNACK_ID_KEY}}",
        arguments = listOf(navArgument(MainDestinations.SNACK_ID_KEY) { type = NavType.LongType })
    ) { backStackEntry ->
        val arguments = requireNotNull(backStackEntry.arguments)
        val snackId = arguments.getLong(MainDestinations.SNACK_ID_KEY)
        PetCareDetailCat(snackId, upPress)
    }

}
