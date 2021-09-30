package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName

data class Change(
    @SerializedName("type")
    val type: String,
    @SerializedName("value")
    val value: Int
)