package com.example.homecommerce.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 27/08/2021.
 */
@Parcelize
class MessageMetaData(

    @SerializedName("type")
    val type: String? = null,

    @SerializedName("id")
    val id: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("image")
    val image: String? = null,

    @SerializedName("sale_price")
    val salePrice: Float? = null,

    @SerializedName("before_sale_price")
    val beforeSalePrice: Float? = null,

    @SerializedName("discount_percent")
    val discountPercent: Int? = null

) : Parcelable {

    enum class MetaData(val value: String) {
        TYPE_PRODUCT("product")
    }

}