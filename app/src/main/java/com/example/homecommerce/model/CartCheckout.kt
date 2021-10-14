package com.example.homecommerce.model

import android.os.Parcelable
import com.example.homecommerce.model.voucher.SystemVoucher
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 4/28/21.
 */
@Parcelize
data class CartCheckout(

    @SerializedName("address")
    var address: Address? = null,

    @SerializedName("list_item")
    var listItem: List<Cart>? = null,

    @SerializedName("system_free_shipping_voucher")
    var systemFreeShippingVoucher: SystemVoucher.ItemVoucher? = null,

    @SerializedName("system_discount_voucher")
    var systemDiscountVoucher: SystemVoucher.ItemVoucher? = null,

    @SerializedName("payment_method")
    var paymentMethod: PaymentMethod? = null,

    @SerializedName("merchandise_subtotal")
    var merchandiseSubtotal: Long? = null,

    @SerializedName("shipping_subtotal")
    var shippingSubtotal: Long? = null,

    @SerializedName("shipping_total")
    var shippingTotal: Long? = null,

    @SerializedName("shipping_total_discount")
    var shippingTotalDiscount: Long? = null,

    @SerializedName("total_discount")
    var totalDiscount: Long? = null,

    @SerializedName("total_payment")
    var totalPayment: Long? = null

) : Parcelable