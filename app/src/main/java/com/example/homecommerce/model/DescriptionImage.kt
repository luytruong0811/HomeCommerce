package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName

data class DescriptionImage(
    @SerializedName("height")
    val height: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)