package com.example.homecommerce.model

import android.os.Parcelable
import com.example.homecommerce.model.user.User
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 3/12/21.
 */
@Parcelize
data class Order(

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("order_number")
    var orderNumber: String? = null,

    @SerializedName("total_price")
    var totalPrice: Long? = null,

    @SerializedName("payment_status")
    var paymentStatus: String? = null,

    @SerializedName("shipping_status")
    var shippingStatus: String? = null,

    @SerializedName("payment_method_id")
    var paymentMethodId: String? = null,

    @SerializedName("payment_method")
    var paymentMethod: PaymentMethod? = null,

    @SerializedName("shipping_method_id")
    var shippingMethodId: String? = null,

    @SerializedName("shipping_method")
    var shippingMethod: ShippingMethod? = null,

    @SerializedName("handle_by")
    var handleBy: String? = null,

    @SerializedName("user_id")
    var userId: String? = null,

    @SerializedName("user")
    var user: User? = null,

    @SerializedName("shop_id")
    var shopId: String? = null,

    @SerializedName("shop")
    var shop: Shop? = null,

    @SerializedName("address")
    var address: Address? = null,

    @SerializedName("pick_address")
    var pickAddress: Address? = null,

    @SerializedName("total_value_items")
    var totalValueItems: Long? = null,

    @SerializedName("shipping_fee")
    var shippingFee: Long? = null,

    @SerializedName("shipping_discount")
    var shippingDiscount: Long? = null,

    @SerializedName("voucher_discount")
    var voucherDiscount: Long? = null,

    @SerializedName("note")
    var note: String? = null,

    @SerializedName("group_order_id")
    var groupOrderId: String? = null,

    @SerializedName("created_at")
    var createdAt: String? = null,

    @SerializedName("updated_at")
    var updatedAt: String? = null,

    @SerializedName("deleted_at")
    var deletedAt: String? = null,

    @SerializedName("order_items")
    var orderItems: List<OrderItem>? = null,

    @SerializedName("cancel_reason")
    var cancelReason: String? = null,

    @SerializedName("cancel_type")
    var cancelType: String? = null,

    @SerializedName("cancel_by")
    var cancelBy: String? = null,

    @SerializedName("cancel_time")
    var cancelTime: String? = null,

    @SerializedName("seller_note")
    var sellerNote: String? = null,

    @SerializedName("is_feedbacked_user")
    var isFeedbackedUser: Boolean? = null,

    @SerializedName("payment_info")
    var paymentInfo: PaymentInfo? = null,

    @SerializedName("order_shipping")
    var orderShipping: OrderShipping? = null,

    @SerializedName("system_vouchers")
    var systemVouchers: List<VoucherOrder>? = null,

    @SerializedName("shop_vouchers")
    var shopVouchers: List<VoucherOrder>? = null,

    @SerializedName("total_price_customer_pay")
    var totalPriceCustomerPay: Long? = null,

    @SerializedName("refund_information")
    var refundInformation: List<ReturnInformation>? = null,

    @SerializedName("refund_status")
    var refundStatus: String? = null

) : Parcelable

@Parcelize
class OrderShipping(

    @SerializedName("_id")
    val id: String? = null,

    @SerializedName("shipping_info")
    val shippingInfo: ShippingInfo? = null,

    @SerializedName("user_confirm_shipped_time")
    val userConfirmShippedTime: String? = null,

    @SerializedName("assign_to_shipping_unit_time")
    val assignToShippingUnitTime: String? = null,

    @SerializedName("history")
    val history: List<ShippingHistory>? = null,

    @SerializedName("order_id")
    val orderId: String? = null,

    @SerializedName("user_id")
    val userId: String? = null,

    @SerializedName("shop_id")
    val shopId: String? = null,

    @SerializedName("created_at")
    val createdAt: String? = null,

    @SerializedName("updated_at")
    val updatedAt: String? = null

) : Parcelable

@Parcelize
data class ShippingInfo(

    @SerializedName("partner_id")
    var partnerId: String? = null,

    @SerializedName("label")
    var label: String? = null,

    @SerializedName("area")
    var area: String? = null,

    @SerializedName("fee")
    var fee: String? = null,

    @SerializedName("status_id")
    var statusId: String? = null,

    @SerializedName("insurance_fee")
    var insuranceFee: String? = null,

    @SerializedName("estimated_pick_time")
    var estimatedPickTime: String? = null,

    @SerializedName("estimated_deliver_time")
    var estimatedDeliverTime: String? = null,

    @SerializedName("tracking_id")
    var trackingId: Int? = null,

    @SerializedName("sorting_code")
    var sortingCode: String? = null,

    @SerializedName("shipping_status")
    var shippingStatus: String? = null

) : Parcelable

@Parcelize
class ShippingHistory(

    @SerializedName("partner_id")
    var partnerId: String? = null,

    @SerializedName("label_id")
    var labelId: String? = null,

    @SerializedName("status_id")
    var statusId: Int? = null,

    @SerializedName("action_time")
    var actionTime: String? = null,

    @SerializedName("reason_code")
    var reason_code: String? = null,

    @SerializedName("reason")
    var reason: String? = null,

    @SerializedName("weight")
    var weight: Double? = null,

    @SerializedName("fee")
    var fee: Long? = null,

    @SerializedName("pick_money")
    var pickMoney: Double? = null,

    @SerializedName("return_part_package")
    var returnPartPackage: Int? = null,

    @SerializedName("shipping_status")
    var shippingStatus: String? = null,

    @SerializedName("reason_code_shipping")
    var reasonCodeShipping: String? = null

) : Parcelable


@Parcelize
class VoucherOrder(

    @SerializedName("classify")
    val classify: String? = null,

    @SerializedName("discount")
    val discount: Int? = null,

    @SerializedName("id")
    val id: String? = null

) : Parcelable {

    fun getClassify(): TypeClassify? {
        return TypeClassify.values().find { it.value == classify }
    }

    enum class TypeClassify(val value: String) { DISCOUNT("discount"), FREE_SHIPPING("free_shipping") }
}

@Parcelize
data class ShippingDetail(

    @SerializedName("textStatus")
    var textStatus: String

) : Parcelable

@Parcelize
data class OrderItem(

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("quantity")
    var quantity: Int? = null,

    @SerializedName("images")
    var images: List<String>? = null,

    @SerializedName("order_id")
    var orderId: String? = null,

    @SerializedName("product_id")
    var productId: String? = null,

    @SerializedName("product")
    var product: Product? = null,

    @SerializedName("sale_price")
    var salePrice: Long? = null,

    @SerializedName("variant")
    var variant: Variation? = null,

    @SerializedName("is_feedback")
    var isFeedback: Boolean? = null,

    @SerializedName("feedback")
    var feedback: Feedback? = null

) : Parcelable

@Parcelize
data class PaymentInfo(

    @SerializedName("total_price_product")
    var totalPriceProduct: Long? = null,

    @SerializedName("shipping_fee")
    var shippingFee: Long? = null,

    @SerializedName("shipping_discount")
    var shippingDiscount: Long? = null,

    @SerializedName("transaction_fee")
    var transactionFee: Long? = null,

    @SerializedName("total_voucher_discount")
    var totalVoucherDiscount: Long? = null,

    @SerializedName("total_price")
    var totalPrice: Long? = null,

    @SerializedName("paid_time")
    var paidTime: String? = null

) : Parcelable

@Parcelize
data class ReturnInformation(

    @SerializedName("item_id")
    var itemId: String? = null,

    @SerializedName("refund_quantity")
    var refundQuantity: Int? = null,

    @SerializedName("status")
    var status: String? = null,

    @SerializedName("opening_time")
    var openingTime: String? = null,

    @SerializedName("canceled_time")
    var canceledTime: String? = null,

    @SerializedName("closed_time")
    var closedTime: String? = null,

    @SerializedName("request_info")
    var requestInfo: RequestInfo? = null,

    @SerializedName("shop_review")
    var shopReview: ShopReview? = null,

    @SerializedName("admin_review")
    var adminReview: ShopReview? = null,

    @SerializedName("refund_money")
    var refundMoney: RefundMoney? = null

) : Parcelable

@Parcelize
data class RequestInfo(

    @SerializedName("address")
    var address: Address? = null,

    @SerializedName("reasons")
    var reasons: List<ReasonReturn>? = null,

    @SerializedName("images")
    var images: List<String>? = null,

    @SerializedName("video")
    var video: String? = null,

    @SerializedName("note")
    var note: String? = null,

    @SerializedName("email")
    var email: String? = null,

    @SerializedName("phone_number")
    var phone: String? = null,

    @SerializedName("time")
    var time: String? = null

) : Parcelable


@Parcelize
data class ShopReview(

    @SerializedName("status")
    var status: String? = null,

    @SerializedName("reason")
    var reasons: List<String>? = null,

    @SerializedName("images")
    var images: List<String>? = null,

    @SerializedName("video")
    var video: String? = null,

    @SerializedName("note")
    var note: String? = null,

    @SerializedName("email")
    var email: String? = null,

    @SerializedName("phone_number")
    var phone: String? = null,

    @SerializedName("seller_confirm_received_time")
    var sellerConfirmReceivedTime: String? = null

) : Parcelable

@Parcelize
data class AdminReview(

    @SerializedName("status")
    var status: String? = null,

    @SerializedName("reason")
    var reasons: List<String>? = null,

    @SerializedName("images")
    var images: List<String>? = null,

    @SerializedName("video")
    var video: String? = null,

    @SerializedName("note")
    var note: String? = null,

    @SerializedName("time")
    var time: String? = null

) : Parcelable


@Parcelize
data class RefundMoney(

    @SerializedName("status")
    var status: String? = null,

    @SerializedName("value")
    var value: Long? = null,

    @SerializedName("completed_time")
    var completedTime: String? = null

) : Parcelable