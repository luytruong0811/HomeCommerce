package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("size_infos")
    val sizeInfos: List<SizeInfo>,
    @SerializedName("type_size")
    val typeSize: String
)