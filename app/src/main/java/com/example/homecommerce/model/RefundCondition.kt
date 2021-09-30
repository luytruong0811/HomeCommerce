package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName

data class RefundCondition(
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("code")
    val code: Int,
    @SerializedName("en_name")
    val enName: String,
    @SerializedName("ko_name")
    val koName: String,
    @SerializedName("vn_name")
    val vnName: String
)