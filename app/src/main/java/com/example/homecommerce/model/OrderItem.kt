package com.example.homecommerce.model

import com.google.gson.annotations.SerializedName

data class OrderItem(
    @SerializedName("sold")
    val sold: Int
)