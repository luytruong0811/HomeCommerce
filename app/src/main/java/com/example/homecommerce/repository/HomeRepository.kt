package com.example.homecommerce.repository

import com.example.homecommerce.di.HomeService
import com.example.homecommerce.model.Home
import retrofit2.Call
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val homeService: HomeService
) {
    fun getHome() : Call<Home> {
        return homeService.getHomeService()
    }
}
