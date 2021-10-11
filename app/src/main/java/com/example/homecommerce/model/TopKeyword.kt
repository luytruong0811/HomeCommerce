package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class TopKeyword(
    @SerializedName("avatar")
    val avatar: String ?= null,
    @SerializedName("count_number")
    val countNumber: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("keyword")
    val keyword: String,
    @SerializedName("shop_id")
    val shopId: Any,
    @SerializedName("total_product")
    val totalProduct: Int,
    @SerializedName("updated_at")
    val updatedAt: String
)