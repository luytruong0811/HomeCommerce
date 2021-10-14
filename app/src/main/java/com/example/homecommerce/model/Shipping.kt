package com.example.homecommerce.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 4/28/21.
 */
@Parcelize
data class Shipping(

    @SerializedName("shipping_method_id")
    var id: String? = null,

    @SerializedName("shipping_fee")
    var shippingFee: Long? = null

) : Parcelable