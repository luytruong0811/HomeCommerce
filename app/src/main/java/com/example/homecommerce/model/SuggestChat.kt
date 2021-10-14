package com.example.homecommerce.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 7/25/21.
 */
@Parcelize
data class SuggestChat(

    @SerializedName("buyer_chat")
    var buyerChat: List<String>,

    @SerializedName("seller_chat")
    var sellerChat: List<String>

): Parcelable