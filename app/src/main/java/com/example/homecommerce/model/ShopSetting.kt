package com.example.homecommerce.model

import com.google.gson.annotations.SerializedName

class ShopSetting(
    val shopType: Int? = null,
    @SerializedName("refund_money_mode")
    val refundMoneyMode: Boolean? = null,
    @SerializedName("pause_mode")
    val pauseMode: Boolean? = null,
    val refund_max: Long? = null,
    val regulations: String? = null
)