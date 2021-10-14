package com.example.homecommerce.model

import android.os.Parcelable
import com.example.homecommerce.model.voucher.ShopVoucher
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 4/26/21.
 */
@Parcelize
data class Cart(

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("items")
    var items: List<ItemCart>? = null,

    @SerializedName("shop")
    var shop: Shop? = null,

    @SerializedName("shop_id")
    var shopId: String? = null,

    @SerializedName("shipping_method")
    var shippingMethod: ShippingMethod? = null,

    @SerializedName("shipping")
    var shipping: Shipping? = null,

    @SerializedName("voucher")
    var voucher: ShopVoucher? = null,

    @SerializedName("shipping_fee")
    var shippingFee: Long? = null,

    @SerializedName("shipping_fee_discount")
    var shippingFeeDiscount: Long? = null,

    @SerializedName("shop_merchandise_total")
    var shopMerchandiseTotal: Long? = null,

    @SerializedName("shop_total")
    var shopTotal: Long? = null,

    @SerializedName("note")
    var note: String? = null

) : Parcelable


@Parcelize
data class ItemCart(

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("product_id")
    var productId: String? = null,

    @SerializedName("quantity")
    var quantity: Int? = null,

    @SerializedName("variant_id")
    var variantId: String? = null,

    @SerializedName("user_id")
    var userId: String? = null,

    @SerializedName("product")
    var product: Product? = null

) : Parcelable

