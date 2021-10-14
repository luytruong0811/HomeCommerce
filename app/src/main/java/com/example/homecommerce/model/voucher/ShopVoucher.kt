package com.example.homecommerce.model.voucher

import android.os.Parcelable
import com.example.homecommerce.ext.getDefault
import com.example.homecommerce.utils.PriceUtils
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class ShopVoucher(

    @SerializedName("_id")
    val id: String? = null,

    val target: String? = null,

    val type: String? = null, // percent, price

    val value: Long? = null,

    @SerializedName("max_discount_value")
    val maxDiscountValue: Long? = null,

    @SerializedName("display_mode")
    val displayMode: String? = null,

    val products: List<String>? = null,

    val shops: List<String>? = null,

    @SerializedName("approve_status")
    val approveStatus: String? = null,

    val name: String? = null,

    val code: String? = null,

    @SerializedName("start_time")
    val startTime: String? = null,

    @SerializedName("end_time")
    val endTime: String? = null,

    @SerializedName("save_quantity")
    val saveQuantity: Int? = null,

    @SerializedName("use_quantity")
    val useQuantity: Int? = null,

    @SerializedName("available_quantity")
    val availableQuantity: Int? = null,

    @SerializedName("min_order_value")
    val minOrderValue: Int? = null,

    @SerializedName("max_budget")
    val maxBudget: Long? = null,

    @SerializedName("shop_id")
    val shopId: String? = null,

    @SerializedName("created_at")
    val createdAt: String? = null,

    @SerializedName("updated_at")
    val updatedAt: String? = null,

    val available: Boolean? = null,

    @SerializedName("discount_for_this_shop")
    val discountForThisShop: Long? = null

) : Parcelable {

    enum class TypeEnum(val value: String) { PERCENT("percent"), PRICE("price") }

    fun getType(): TypeEnum? {
        return TypeEnum.values().find { it.value == type }
    }

    fun getVoucherValueString(): String {
        return when (getType()) {
            TypeEnum.PERCENT -> {
                "-${value.toString()}%"
            }
            else -> {
                "-${PriceUtils.convertToKPrice(value.getDefault())}"
            }
        }
    }

    fun getValueDiscountForThisShop(): String {
        return "-${PriceUtils.convertToKPrice(discountForThisShop.getDefault())}"
    }

    fun getDiscountTarget(): DiscountTargetEnum? {
        return DiscountTargetEnum.values().find { it.value == target }
    }

    enum class DiscountTargetEnum(val value: String) { Shop("shop"), System("system") }
}