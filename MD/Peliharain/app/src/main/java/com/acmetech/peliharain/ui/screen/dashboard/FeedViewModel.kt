package com.acmetech.peliharain.ui.screen.dashboard

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acmetech.peliharain.data.network.RetroInstance
import com.acmetech.peliharain.data.response.ResponseCatItem
import com.acmetech.peliharain.data.response.ResponseDogItem
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {
    private val _isLoadingCat: MutableState<Boolean> = mutableStateOf(false)
    val isLoadingCat: State<Boolean> = _isLoadingCat

    private val _isLoadingDog: MutableState<Boolean> = mutableStateOf(false)
    val isLoadingDog: State<Boolean> = _isLoadingDog

    private val _isErrorCat: MutableState<Boolean> = mutableStateOf(false)
    val isErrorCat: State<Boolean> = _isErrorCat

    private val _isErrorDog: MutableState<Boolean> = mutableStateOf(false)
    val isErrorDog: State<Boolean> = _isErrorDog

    var catListResponse: List<ResponseCatItem> by mutableStateOf(listOf())
    var dogListResponse: List<ResponseDogItem> by mutableStateOf(listOf())

    fun getNewsCat() {
        viewModelScope.launch {
            try {
                _isLoadingCat.value = true
                catListResponse = RetroInstance.getRetroInstance().getNewsCat()
            } catch (e: Exception) {
                Log.d("TAG", e.stackTraceToString())
            } finally {
                _isLoadingCat.value = false
            }
        }
    }

    fun getNewsDog() {
        viewModelScope.launch {
            try {
                _isLoadingDog.value = true
                dogListResponse = RetroInstance.getRetroInstance().getNewsDog()
            } catch (e: Exception) {
                Log.d("TAG", e.stackTraceToString())
            } finally {
                _isLoadingDog.value = false
            }
        }
    }
}