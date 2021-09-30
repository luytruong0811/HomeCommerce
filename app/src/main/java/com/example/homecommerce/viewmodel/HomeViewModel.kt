package com.example.homecommerce.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homecommerce.model.Data
import com.example.homecommerce.model.Home
import com.example.homecommerce.usecase.HomeUseCase

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel @ViewModelInject constructor(
    private val homeUseCase: HomeUseCase
) : ViewModel() {

    private val _home = MutableLiveData<HomeState>()
    val home : LiveData<HomeState> = _home

    fun getHomeViewModel(){
        homeUseCase.excute()
            ?.enqueue(object : Callback<Home>{
                override fun onResponse(call: Call<Home>, response: Response<Home>) {
                    _home.postValue(response.body()?.data?.let { HomeState.Success(it) })
                }

                override fun onFailure(call: Call<Home>, t: Throwable) {
                    _home.postValue(HomeState.Error(t.message.toString()))
                }

            })
    }

    sealed class HomeState{
        class Success(var items: Data) : HomeState()
        class Error(var message: String) : HomeState()
    }
}
