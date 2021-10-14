package com.example.homecommerce.model

import android.os.Parcelable
import com.example.homecommerce.ext.getDefault
import com.example.homecommerce.utils.PriceUtils
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 22/08/2021.
 */
@Parcelize
class Voucher(

    @SerializedName("_id")
    val id: String? = null,

    val target: String? = null,

    val type: String? = null,

    val value: Float? = null,

    @SerializedName("max_discount_value")
    val maxDiscountValue: Float? = null,

    @SerializedName("display_mode")
    val displayMode: String? = null,

    val products: List<String>? = null,

    val shops: List<String>? = null,

    @SerializedName("shop_id")
    val shopId: String? = null,

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
    val minOrderValue: Float? = null,

    @SerializedName("max_budget")
    val maxBudget: Float? = null,

    val classify: String? = null,

    @SerializedName("discount_by_range_price")
    val discountByRangePrice: List<DiscountByRangePrice>? = null,

    val conditions: Conditions? = null,

    val available: Boolean? = null,

    @SerializedName("discount_for_this_shop")
    val discountForThisShop: Long? = null,

    @SerializedName("created_at")
    val createdAt: String? = null,

    @SerializedName("updated_at")
    val updatedAt: String? = null

) : Parcelable {

    enum class TypeClassify(val value: String) {
        FREE_SHIPPING("free_shipping"),
        DISCOUNT("discount")
    }

    enum class TypeVoucher(val value: String) {
        PERCENT("percent"),
        PRICE("price")
    }

    enum class TypeTarget(val value: String) {
        SHOP("shop"),
        SYSTEM("system")
    }

    fun getTypeClassify(): TypeClassify? {
        return TypeClassify.values().find { it.value == classify }
    }

    fun getTypeTarget(): TypeTarget? {
        return TypeTarget.values().find { it.value == target }
    }

    fun getType(): TypeVoucher? {
        return TypeVoucher.values().find { it.value == type }
    }

    fun getVoucherValueString(): String {
        return when (getType()) {
            TypeVoucher.PERCENT -> {
                "-${value.toString()}%"
            }
            else -> {
                "-${PriceUtils.convertToKPrice(value.getDefault().toLong())}"
            }
        }
    }

    @Parcelize
    class DiscountByRangePrice(
        val from: Float? = null,
        val to: Float? = null,
        val value: Float? = null
    ) : Parcelable

    @Parcelize
    class Conditions(

        @SerializedName("shipping_method")
        val shippingMethod: List<String>? = null,

        @SerializedName("payment_method")
        val paymentMethod: List<String>? = null,

        @SerializedName("limit_per_user")
        val limitPerUser: Int? = null

    ) : Parcelable

}
