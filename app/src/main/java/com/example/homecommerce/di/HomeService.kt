package com.example.homecommerce.di

import com.example.homecommerce.base.BaseResponse
import com.example.homecommerce.model.*
import com.example.homecommerce.model.ranking.ShopRanking
import com.example.homecommerce.reponse.PopularKeywordSearchSystem
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface HomeService {
    @GET("v2/mobile/home")
    fun getHomeService(): Call<Home>


    @GET("v2/mobile/categories/{id}/products-of-system-category")
    fun getCategoryFromHomePage(
        @Path("id") id: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Observable<BaseResponse<HomeCategory>>
}