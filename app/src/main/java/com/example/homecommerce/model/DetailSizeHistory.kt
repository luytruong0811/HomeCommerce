package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName

data class DetailSizeHistory(
    @SerializedName("data")
    val `data`: List<Any>,
    @SerializedName("fashion_type")
    val fashionType: Int
)