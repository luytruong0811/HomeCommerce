package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName

data class Feedback(
    @SerializedName("averageFeedbackRate")
    val averageFeedbackRate: Float
)