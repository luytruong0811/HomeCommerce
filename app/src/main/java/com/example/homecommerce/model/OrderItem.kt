package com.example.homecommerce.model

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class OrderItem(
    @SerializedName("sold")
    val sold: Int
)