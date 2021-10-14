package com.example.homecommerce.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 3/25/21.
 */
@Parcelize
data class Location(

    @SerializedName("Id")
    var id: String? = null,

    @SerializedName("Name")
    var name: String? = null

) : Parcelable