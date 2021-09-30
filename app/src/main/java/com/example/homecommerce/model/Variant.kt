package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName

data class Variant(
    @SerializedName("before_sale_price")
    val beforeSalePrice: Int,
    @SerializedName("_id")
    val id: String,
    @SerializedName("is_master")
    val isMaster: Any,
    @SerializedName("option_values")
    val optionValues: List<OptionValueX>,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("sale_price")
    val salePrice: Int
)