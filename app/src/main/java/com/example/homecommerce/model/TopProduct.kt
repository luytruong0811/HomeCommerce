package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class TopProduct(
    @SerializedName("before_sale_price")
    val beforeSalePrice: Any,
    @SerializedName("_id")
    val id: String,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("is_bookmarked")
    var isBookmarked: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("price_min_max")
    val priceMinMax: PriceMinMax,
    @SerializedName("sale_price")
    val salePrice: Int,
    @SerializedName("shop_id")
    val shopId: String,
    @SerializedName("sold")
    val sold: Int,
    @SerializedName("variants")
    val variants: List<VariantX>,
    @SerializedName("discount_percent")
    val discount_percent: Int
)