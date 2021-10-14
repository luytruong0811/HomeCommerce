package com.example.homecommerce.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 2/22/21.
 */
@Parcelize
data class CategoryOption(

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("type")
    var type: String? = null,

    @SerializedName("category_id")
    var categoryId: String? = null,

    @SerializedName("list_option")
    var options: List<String>? = null

) : Parcelable