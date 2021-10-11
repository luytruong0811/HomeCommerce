package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName

data class Home(
    @SerializedName("data")
    val homePage: HomePage,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)