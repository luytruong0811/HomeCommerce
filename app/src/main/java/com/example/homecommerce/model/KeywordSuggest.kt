package com.example.homecommerce.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 31/05/2021.
 */
@Parcelize
class KeywordSuggest(

    @SerializedName("_id")
    val id: String? = null,

    @SerializedName("count_number")
    val countNumber: Int? = null,

    @SerializedName("keyword")
    val keyword: String? = null,

    @SerializedName("shop_id")
    val shopId: String? = null

) : Parcelable