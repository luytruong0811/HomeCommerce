package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class TopLivestream(
    @SerializedName("_id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("products")
    val homes: List<HomeX>,
    @SerializedName("user")
    val user: User,
)