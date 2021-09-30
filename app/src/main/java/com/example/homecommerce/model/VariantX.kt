package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName

data class VariantX(
    @SerializedName("before_sale_price")
    val beforeSalePrice: Int,
    @SerializedName("_id")
    val id: String,
    @SerializedName("is_master")
    val isMaster: Any,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("sale_price")
    val salePrice: Int
)