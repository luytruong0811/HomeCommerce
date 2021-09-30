package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName

data class SizeInfo(
    @SerializedName("max")
    val max: Int,
    @SerializedName("min")
    val min: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("unit")
    val unit: String
)