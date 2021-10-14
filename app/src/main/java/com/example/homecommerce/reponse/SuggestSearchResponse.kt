package com.example.homecommerce.reponse

import com.example.homecommerce.model.HomePage
import com.google.gson.annotations.SerializedName

/**
 * Created by pvduc9773 on 27/05/2021.
 */
data class PopularKeywordSearchSystem(

    @SerializedName("top_keyword")
    val topKeyword: List<HomePage.TopKeywordHomePage>,

    @SerializedName("system_category")
    val systemCategory: List<HomePage.SystemCategory>

)

data class PopularKeywordSearchShop(

    @SerializedName("top_keyword_shop")
    val topKeywordShop: List<String>

)

