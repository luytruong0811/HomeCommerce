package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName

data class Stream(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("description")
    val description: Any,
    @SerializedName("hls_link")
    val hlsLink: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("rtmp_link")
    val rtmpLink: String,
    @SerializedName("shop_id")
    val shopId: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("user_id")
    val userId: String
)