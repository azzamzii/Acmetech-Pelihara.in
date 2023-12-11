package com.acmetech.peliharain.ui.screen.authLanding.login

data class SignInState(
    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)