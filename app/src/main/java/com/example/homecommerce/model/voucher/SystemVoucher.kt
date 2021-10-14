package com.example.homecommerce.model.voucher

import android.os.Parcelable
import com.example.homecommerce.ext.getDefault
import com.example.homecommerce.utils.PriceUtils
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class SystemVoucher(

    val classify: String, // free_shipping, discount

    val items: List<ItemVoucher>

) : Parcelable {

    @Parcelize
    class ItemVoucher(

        @SerializedName("_id")
        val id: String? = null,

        val target: String? = null,

        val type: String? = null,

        val value: Int? = null,

        @SerializedName("max_discount_value")
        val maxDiscountValue: Int? = null,

        @SerializedName("display_mode")
        val displayMode: String? = null,

        val products: List<String>? = null,

        val shops: List<String>? = null,

        // val users: List<Any>? = null,

        // val labels: List<Any>? = null,

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

        @SerializedName("discount_by_range_price")
        val discountByRangePrice: List<DiscountByRangePrice>? = null,

        @SerializedName("min_order_value")
        val minOrderValue: Int? = null,

        val classify: String? = null,

        val conditions: Conditions? = null,

        @SerializedName("created_at")
        val createdAt: String? = null,

        @SerializedName("updated_at")
        val updatedAt: String? = null,

        val available: Boolean? = null,

        @SerializedName("discount_for_this_cart")
        val discountForThisCart: Long? = null

    ) : Parcelable {

        @Parcelize
        class Conditions(

            @SerializedName("shipping_method")
            val shippingMethod: List<String>? = null,

            @SerializedName("payment_method")
            val paymentMethod: List<String>? = null,

            val limitPerUser: Int? = null

        ) : Parcelable

        @Parcelize
        class DiscountByRangePrice(
            val from: Long,
            val to: Long,
            val value: Long
        ) : Parcelable

        enum class TypeEnum(val value: String) {
            PERCENT("percent"),
            PRICE("price")
        }

        fun getType(): TypeEnum? {
            return TypeEnum.values().find { it.value == type }
        }

        fun getVoucherValueString(): String {
            return when (getType()) {
                TypeEnum.PERCENT -> {
                    "-${value.toString()}%"
                }
                else -> {
                    "-${PriceUtils.convertToKPrice(value?.toLong().getDefault())}"
                }
            }
        }

        fun getValueDiscountForThisCart(): String {
            return "-${PriceUtils.convertToKPrice(discountForThisCart.getDefault())}"
        }

        fun getClassify(): ClassifyEnum? {
            return ClassifyEnum.values().find { it.value == classify }
        }

        fun getDiscountTarget(): DiscountTargetEnum? {
            return DiscountTargetEnum.values().find { it.value == target }
        }

        enum class DiscountTargetEnum(val value: String) {
            Shop("shop"),
            System("system")
        }
    }

    fun getClassify(): ClassifyEnum? {
        return ClassifyEnum.values().find { it.value == classify }
    }

    enum class ClassifyEnum(val value: String) {
        DISCOUNT("discount"),
        FREE_SHIPPING("free_shipping")
    }
}