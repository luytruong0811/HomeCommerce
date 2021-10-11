package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class OptionValue(
    @SerializedName("_id")
    val id: String,
    @SerializedName("image")
    val image: Any,
    @SerializedName("name")
    val name: String
)