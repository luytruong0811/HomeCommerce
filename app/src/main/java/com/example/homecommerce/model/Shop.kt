package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName

data class Shop(
    @SerializedName("country")
    val country: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("shop_type")
    val shopType: Int,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("user_id")
    val userId: String
)