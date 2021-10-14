package com.example.homecommerce.model

import com.google.gson.annotations.SerializedName

data class Report(
    @SerializedName("_id")
    var id: String? = null,
    var content: String? = null,
    var isInputContent: Boolean = false
)