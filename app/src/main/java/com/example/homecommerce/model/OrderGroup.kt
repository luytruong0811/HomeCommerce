package com.example.homecommerce.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 5/3/21.
 */
@Parcelize
data class OrderGroup(

    @SerializedName("group_order_id")
    var groupOrderId: String,

    @SerializedName("user_id")
    var userId: String,

    @SerializedName("orders")
    var orders: List<Order>,

    @SerializedName("total_price")
    var totalPrice: Long

) : Parcelable