package com.acmetech.peliharain.ui.screen.authLanding.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acmetech.peliharain.data.auth.AuthRepository
import com.acmetech.peliharain.ui.screen.authLanding.login.SignInState
import com.acmetech.peliharain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    val _signUpState  = Channel<SignInState>()
    val signUpState  = _signUpState.receiveAsFlow()


    fun registerUser(email:String, password:String) = viewModelScope.launch {
        repository.registerUser(email, password).collect{result ->
            when(result){
                is Resource.Success ->{
                    _signUpState.send(SignInState(isSuccess = "Sign Up Success "))
                }
                is Resource.Loading ->{
                    _signUpState.send(SignInState(isLoading = true))
                }
                is Resource.Error ->{

                    _signUpState.send(SignInState(isError = result.message))
                }

                else -> {
                    _signUpState.send(SignInState(isError = "Unknown Error"))
                }
            }

        }
    }

}