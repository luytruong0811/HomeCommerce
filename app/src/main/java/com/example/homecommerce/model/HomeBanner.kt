package com.example.homecommerce.model

import com.example.homecommerce.model.voucher.SystemVoucher
import com.google.gson.annotations.SerializedName

class HomeBanner(
    @SerializedName("_id")
    val id: String? = null,

    val name: String? = null,

    val image: String? = null,

    @SerializedName("detail_image")
    val detailImage: String? = null,

    @SerializedName("mobileVNURL")
    var mobileVNURL: String? = null,

    @SerializedName("mobileKOURL")
    var mobileKOURL: String? = null,

    @SerializedName("detail_image_VN")
    var detailImageVN: String? = null,

    @SerializedName("detail_image_KO")
    var detailImageKO: String? = null,

    val vouchers: List<SystemVoucher>? = null,

    val products: List<Product>? = null
) {
    fun getFreeShippingVoucher(): List<SystemVoucher.ItemVoucher> {
        return vouchers.orEmpty().find { it.classify == SystemVoucher.ClassifyEnum.FREE_SHIPPING.value }?.items.orEmpty()
    }

    fun getDiscountVoucher(): List<SystemVoucher.ItemVoucher> {
        return vouchers.orEmpty().find { it.classify == SystemVoucher.ClassifyEnum.DISCOUNT.value }?.items.orEmpty()
    }
}