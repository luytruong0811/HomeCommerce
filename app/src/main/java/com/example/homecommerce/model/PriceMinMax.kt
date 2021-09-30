package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName

data class PriceMinMax(
    @SerializedName("max")
    val max: Int,
    @SerializedName("min")
    val min: Int
)