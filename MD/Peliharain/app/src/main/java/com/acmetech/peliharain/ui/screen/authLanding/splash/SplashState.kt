package com.acmetech.peliharain.ui.screen.authLanding.splash

data class SplashState (
    val isLoading : Boolean = false,
    val success : Int = -1,
    val error : String = "",
    val internet :  Boolean = false
)