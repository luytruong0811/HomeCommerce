package com.example.homecommerce.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 4/28/21.
 */
@Parcelize
data class ShippingMethod(

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("type")
    var type: String? = null,

    @SerializedName("shipping_fee")
    var shippingFee: Long? = null,

    @SerializedName("name_query")
    var nameQuery: String? = null

) : Parcelable