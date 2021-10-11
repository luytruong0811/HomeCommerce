package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class SystemCategory(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("pdfAvatar")
    val pdfAvatar: String,
)