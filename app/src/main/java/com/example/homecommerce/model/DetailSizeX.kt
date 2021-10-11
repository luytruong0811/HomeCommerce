package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class DetailSizeX(
    @SerializedName("size_infos")
    val sizeInfos: List<SizeInfo>,
    @SerializedName("type_size")
    val typeSize: String
)