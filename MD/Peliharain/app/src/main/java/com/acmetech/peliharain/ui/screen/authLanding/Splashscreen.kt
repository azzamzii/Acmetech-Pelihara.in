package com.acmetech.peliharain.ui.screen.authLanding

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.acmetech.peliharain.R
import com.acmetech.peliharain.ui.navigation.AUTH_GRAPH_ROUTE
import com.acmetech.peliharain.ui.navigation.PetScreen
import com.acmetech.peliharain.ui.screen.authLanding.splash.SplashViewModel
import com.acmetech.peliharain.ui.screen.authLanding.splash.hasInternetPermission
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
) {

    val viewModel = SplashViewModel()
    val state = viewModel.state.value
    val context = LocalContext.current


    // ON PROOGRESS
    when (state.success) {
        0 -> {
            LaunchedEffect(key1 = Unit) {
                delay(5000L)
                navController.navigate(AUTH_GRAPH_ROUTE) {
                    popUpTo(AUTH_GRAPH_ROUTE) {
                        inclusive = true
                    }
                }
            }
        }

        1 -> {
            LaunchedEffect(key1 = Unit) {
                delay(5000L)
                navController.navigate(PetScreen.Home.route)
            }
        }
    }

    when (hasInternetPermission(context)) {
        true -> {
            LaunchedEffect(key1 = Unit) {
                delay(5000L)
                Toast.makeText(context, "Internet Connected", Toast.LENGTH_LONG).show()
                navController.navigate(AUTH_GRAPH_ROUTE) {
                    popUpTo(AUTH_GRAPH_ROUTE) {
                        inclusive = true
                    }
                }
            }
        }

        false -> {
            LaunchedEffect(key1 = Unit) {
                delay(5000L)
                Toast.makeText(context, "No Internet Connected", Toast.LENGTH_LONG).show()
                navController.navigate(AUTH_GRAPH_ROUTE) {
                    popUpTo(AUTH_GRAPH_ROUTE) {
                        inclusive = true
                    }
                }
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.splashlogo),
            contentDescription = "logo1",
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(
        navController = NavController(LocalContext.current))
}


