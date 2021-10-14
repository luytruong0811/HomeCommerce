package com.example.homecommerce.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 2/20/21.
 */
@Parcelize
data class Category(

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("image_url")
    var image: String? = null,

    @SerializedName("is_active")
    var isActive: Boolean? = false,

    @SerializedName("priority")
    var priority: Int? = null,

    @SerializedName("permalink")
    var permalink: String? = null,

    @SerializedName("shop_id")
    val shopId: String? = null,

    @SerializedName("parent_id")
    var parentId: String? = null,

    @SerializedName("childs")
    var childs: List<Category>? = null,

    @SerializedName("created_at")
    var createdAt: String? = null,

    @SerializedName("updated_at")
    var updatedAt: String? = null,

    @SerializedName("products")
    var products: List<Product>? = null,

    @SerializedName("product_numbers")
    var productNumbers: Int? = null

) : Parcelable