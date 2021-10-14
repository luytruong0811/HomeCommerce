package com.example.homecommerce.base

import androidx.hilt.Assisted
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.example.homecommerce.prefs.UserPref
import com.example.homecommerce.prefs.isLogged

abstract class BaseEcommerceViewModel(
    @Assisted savedStateHandle: SavedStateHandle,
    private val userPref: UserPref
) : BaseViewModel(savedStateHandle) {
    sealed class AuthenticationState {
        object RequestLogin : AuthenticationState()
    }

    private val _authenticationObs = MutableLiveData<AuthenticationState>()
    val authenticationObs: LiveData<AuthenticationState> = _authenticationObs

    fun onCheckAuthentication(): Boolean {
        return userPref.isLogged()
    }

    fun onCheckAuthenticationRequirements(): Boolean {
        return if (userPref.isLogged()) {
            true
        } else {
            _authenticationObs.postValue(AuthenticationState.RequestLogin)
            false
        }
    }
}