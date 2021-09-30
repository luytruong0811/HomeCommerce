package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName

data class Home(
    @SerializedName("data")
    val data: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)