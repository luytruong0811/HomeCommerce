package com.example.homecommerce.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Discount(

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("code")
    var code: String? = null,

    @SerializedName("target")
    var target: String? = null,

    @SerializedName("user")
    var user: String? = null,

    @SerializedName("start_time")
    var startTime: String? = null,

    @SerializedName("end_time")
    var endTime: String? = null,

    @SerializedName("save_quantity")
    var saveQuantity: Int? = null,

    @SerializedName("use_quantity")
    var useQuantity: Int? = null,

    @SerializedName("available_quantity")
    var availableQuantity: Int? = null,

    @SerializedName("type")
    var discountType: String? = null,

    @SerializedName("value")
    var discountValue: Int? = null,

    @SerializedName("max_discount_value")
    var maxDiscountValue: Long? = null,

    @SerializedName("display_mode")
    var displayMode: String? = null,

    @SerializedName("min_order_value")
    var minOrderValue: Long? = null,

    @SerializedName("shop_id")
    var shopId: String? = null,

    @SerializedName("product_ids")
    var products: List<String>? = null,

    @SerializedName("approve_status")
    var approveStatus: String? = null,

    @SerializedName("created_at")
    var createdAt: String? = null,

    @SerializedName("updated_at")
    var updatedAt: String? = null,

    @SerializedName("used")
    var usedQuantity: Int = 0

) : Parcelable {

    fun getDiscountTypeEnum(): DiscountTypeEnum? {
        return DiscountTypeEnum.values().find { it.value == discountType }
    }

    fun getDiscountTargetEnum(): DiscountTargetEnum? {
        return DiscountTargetEnum.values().find { it.value == target }
    }

    fun getDisplayModeEnum(): DisplayModeEnum? {
        return DisplayModeEnum.values().find { it.value == displayMode }
    }

    enum class DiscountTypeEnum(val value: String) { Amount("price"), Percentage("percent") }
    enum class DiscountTargetEnum(val value: String) { Shop("shop"), Product("product") }
    enum class DisplayModeEnum(val value: String) { All("all"), None("none") }
}