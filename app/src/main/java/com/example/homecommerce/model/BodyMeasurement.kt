package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName

data class BodyMeasurement(
    @SerializedName("bustSize")
    val bustSize: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("highHipSize")
    val highHipSize: Int,
    @SerializedName("hipSize")
    val hipSize: Int,
    @SerializedName("waistSize")
    val waistSize: Int,
    @SerializedName("weight")
    val weight: Int
)