package com.example.homecommerce.repository

import com.example.homecommerce.base.BaseRepository
import com.example.homecommerce.di.HomeService
import com.example.homecommerce.ext.getDefault
import com.example.homecommerce.ext.getDefaultToString
import com.example.homecommerce.ext.toStringValue
import com.example.homecommerce.model.*
import com.example.homecommerce.model.ranking.ShopRanking
import com.example.homecommerce.paramaters.SearchParameters
import com.example.homecommerce.reponse.PopularKeywordSearchSystem
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val homeService: HomeService
) {
    fun getHome() : Call<Home> {
        return homeService.getHomeService()
    }
    fun getCategoryFromHomePage(
        id: String,
        page: Int
    ): Observable<HomeCategory> {
        return homeService
            .getCategoryFromHomePage(id,  page, 20)
            .map { it.data }
    }
}