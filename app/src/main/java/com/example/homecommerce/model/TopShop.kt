package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName

data class TopShop(
    @SerializedName("change")
    val change: Change,
    @SerializedName("_id")
    val id: String,
    @SerializedName("shop")
    val shop: ShopXXX,
    @SerializedName("totalRevenue")
    val totalRevenue: Int
)