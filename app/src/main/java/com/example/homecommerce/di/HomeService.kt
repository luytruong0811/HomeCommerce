package com.example.homecommerce.di

import com.example.homecommerce.model.Home
import retrofit2.Call
import retrofit2.http.GET

interface HomeService {
    @GET("v2/mobile/home")
    fun getHomeService(): Call<Home>
}