package com.example.homecommerce.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 3/7/21.
 */
@Parcelize
data class CategorySearch(
    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("parent_id")
    var parentId: String? = null,

    @SerializedName("level")
    var level: Int? = null,

    @SerializedName("childs")
    var childs: Int? = null

) : Parcelable