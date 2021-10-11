package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class ImageAd(
    @SerializedName("detail")
    val detail: String,
    @SerializedName("lang")
    val lang: String,
    @SerializedName("middle")
    val middle: String,
    @SerializedName("top")
    val top: String
)