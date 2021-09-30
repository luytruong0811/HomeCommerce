package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName

data class DetailSizeHistoryX(
    @SerializedName("data")
    val data: List<DataX>,
    @SerializedName("fashion_type")
    val fashionType: Int
)