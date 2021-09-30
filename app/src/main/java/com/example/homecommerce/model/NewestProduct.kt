package com.example.homecommerce.model

import com.google.gson.annotations.SerializedName

data class NewestProduct(
    @SerializedName("before_sale_price")
    val beforeSalePrice: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("list_category_id")
    val listCategoryId: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("shop")
    val shop: Shop,
    @SerializedName("shop_id")
    val shopId: String)
