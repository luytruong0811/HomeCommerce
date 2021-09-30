package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName

data class NameOrganizer(
    @SerializedName("unsigneduserName")
    val unsigneduserName: String,
    @SerializedName("userName")
    val userName: String
)