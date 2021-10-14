package com.example.homecommerce.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 3/9/21.
 */
@Parcelize
class Banner(

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("promo_link")
    var promoLink: String? = null,

    @SerializedName("is_active")
    var isActive: Boolean? = null,

    @SerializedName("image")
    var image: String? = null,

    @SerializedName("start_time")
    var startTime: Long? = null, // second

    @SerializedName("end_time")
    var endTime: Long? = null, // second

    @SerializedName("products")
    var products: List<Product>? = null

) : Parcelable