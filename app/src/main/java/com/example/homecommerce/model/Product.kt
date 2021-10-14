package com.example.homecommerce.model

import android.os.Parcelable
import com.example.homecommerce.model.localized.getLocalized
import com.example.homecommerce.model.user.User
import com.example.homecommerce.prefs.AppLanguage
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 2/24/21.
 */
@Parcelize
data class Product(

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("images")
    var images: List<String>? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("description_images")
    var descriptionImages: List<ImageDescription>? = null,

    @SerializedName("short_description")
    var shortDescription: String? = null,

    @SerializedName("friendly_url")
    var friendlyUrl: String? = null,

    @SerializedName("weight")
    var weight: String? = null,

    @SerializedName("width")
    var width: String? = null,

    @SerializedName("height")
    var height: String? = null,

    @SerializedName("before_sale_price")
    var beforeSalePrice: Long? = null,

    @SerializedName("sale_price")
    var salePrice: Long? = null,

    @SerializedName("quantity")
    var quantity: Int? = null,

    @SerializedName("allow_to_sell")
    var allowToSell: Boolean = false,

    // "approved" or "reject"
    @SerializedName("is_approved")
    var isApproved: String? = null,

    @SerializedName("is_pre_order")
    var isPreOrder: Boolean = false,

    @SerializedName("shop_id")
    var shopId: String? = null,

    @SerializedName("shop")
    var shop: Shop? = null,

    @SerializedName("category_id")
    var categoryId: String? = null,

    @SerializedName("category")
    var category: Category? = null,

    @SerializedName("last_category")
    var lastCategory: Category? = null,

    @SerializedName("list_category_id")
    var categoryIds: List<String>? = null,

    @SerializedName("product_detail_infos")
    var informations: List<ProductInfo>? = null,

    @SerializedName("option_types")
    var optionTypes: List<OptionType>? = null,

    @SerializedName("variants")
    var variants: List<Variation>? = null,

    @SerializedName("price_min_max")
    var priceMinMax: PriceMinMax? = null,

    @SerializedName("createdAt")
    var createdAt: String? = null,

    @SerializedName("updatedAt")
    var updatedAt: String? = null,

    @SerializedName("deletedAt")
    var deletedAt: String? = null,

    @SerializedName("info_more")
    var infoMore: InfoMore? = null,

    @SerializedName("is_bookmarked")
    var isBookmarked: Boolean = false,

    @SerializedName("feedbacks")
    var feedbacks: Feedbacks? = null,

    @SerializedName("variant")
    var variant: Variation? = null,

    @SerializedName("sold")
    var sold: Int? = null,

    @SerializedName("shipping_information")
    var shippingInformation: String? = null,

    @SerializedName("delivery_instruction")
    var deliveryInstruction: String? = null,

    @SerializedName("exchange_information")
    var exchangeInformation: String? = null,

    @SerializedName("detail_size")
    var detailSize: List<DetailSize?>? = null,

    @SerializedName("allow_refund")
    var allowRefund: Boolean? = null,

    @SerializedName("duration_refund")
    var durationRefund: Int? = null,

    @SerializedName("refund_conditions")
    var refundConditions: List<ReasonReturn>? = null,

    @SerializedName("time_prepare_orders")
    var timePrepareOrders: List<TimePrepareOrder>? = null,

    @SerializedName("simillarProducts")
    var similarProducts: List<Product>? = null,

    @SerializedName("suggestProduct")
    var suggestProduct: List<Product>? = null,

    @SerializedName("discount_percent")
    var discountPercent: Int? = null,

    @SerializedName("expected_shipping_fee")
    var expectedShippingFee: List<ExpectedShippingFee>? = null,

    @SerializedName("max_voucher_discount")
    var maxVoucherDiscount: Float? = null,

    @SerializedName("vouchers")
    var vouchers: List<Voucher>? = null

) : Parcelable {
    fun isRejected(): Boolean {
        return isApproved == "reject"
    }
}

@Parcelize
class ExpectedShippingFee(

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("min")
    var min: Float? = null,

    @SerializedName("max")
    var max: Float? = null

) : Parcelable

@Parcelize
class ProductInfo(

    @SerializedName("category_info_id")
    var id: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("value")
    var value: String? = null,

    @SerializedName("category_info")
    var categoryInfo: CategoryInfo? = null

) : Parcelable

@Parcelize
class CategoryInfo(

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("is_required")
    var isRequired: Boolean? = false

) : Parcelable

@Parcelize
class OptionType(

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("option_values")
    var optionValues: List<OptionValue>? = null

) : Parcelable

@Parcelize
class OptionValue(

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("image")
    var image: String? = null,

    @SerializedName("info_more")
    var infoMore: String? = null

) : Parcelable

@Parcelize
class Variation(
    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("option_values")
    var optionValues: List<OptionValue>? = null,

    @SerializedName("before_sale_price")
    var beforeSalePrice: Long? = null,

    @SerializedName("sale_price")
    var salePrice: Long? = null,

    @SerializedName("quantity")
    var quantity: Int? = null,

    @SerializedName("is_master")
    var isMaster: Boolean = false

) : Parcelable {

    fun getValue(): String {
        val variationValue = StringBuilder()
        val optionValues = optionValues.orEmpty()
        val firstOption = if (optionValues.isNotEmpty()) optionValues[0] else null
        val secondOption = if (optionValues.size >= 2) optionValues[1] else null
        if (firstOption != null) {
            variationValue.append(firstOption.name)
        }
        if (secondOption != null) {
            variationValue.append(" ")
            variationValue.append(secondOption.name)
        }
        return variationValue.toString()
    }

    fun getValue(appLanguage: AppLanguage): String {
        val variationValue = StringBuilder()
        val optionValues = optionValues.orEmpty()
        val firstOption = if (optionValues.isNotEmpty()) optionValues[0] else null
        val secondOption = if (optionValues.size >= 2) optionValues[1] else null
        if (firstOption != null) {
            variationValue.append(firstOption.name?.getLocalized(appLanguage))
        }
        if (secondOption != null) {
            variationValue.append(" ")
            variationValue.append(secondOption.name?.getLocalized(appLanguage))
        }
        return variationValue.toString()
    }

}

@Parcelize
class PriceMinMax(
    val min: Long? = null,
    val max: Long? = null
) : Parcelable


@Parcelize
class InfoMore(

    @SerializedName("satisfied")
    var satisfied: Int? = null,

    @SerializedName("like")
    var like: Int? = null,

    @SerializedName("view_in_month")
    var viewInMonth: Int? = null

) : Parcelable


@Parcelize
class Feedbacks(

    @SerializedName("averageFeedbackRate")
    var averageFeedbackRate: Float? = null,

    @SerializedName("totalFeedback")
    var totalFeedback: Int? = null,

    @SerializedName("totalByMedia")
    var totalByMedia: Int? = null,

    @SerializedName("totalByComment")
    var totalByComment: Int? = null,

    @SerializedName("feedbackMedias")
    var feedbackMedias: List<String>? = null,

    @SerializedName("totalByStar")
    var totalByStar: List<TotalByStar>? = null,

    @SerializedName("satisfactionRate")
    var satisfactionRate: Float? = null,

    @SerializedName("feedbacks")
    var feedbacks: List<Feedback>? = null

) : Parcelable

@Parcelize
class TotalByStar(

    @SerializedName("vote_star")
    var voteStar: Int? = null,

    @SerializedName("total")
    var total: Int? = null

) : Parcelable


@Parcelize
class Feedback(

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("medias")
    var medias: List<String>? = null,

    @SerializedName("is_approved")
    var isApproved: Boolean? = false,

    @SerializedName("is_public")
    var isPublic: Boolean? = false,

    @SerializedName("content")
    var content: String? = null,

    @SerializedName("vote_star")
    var voteStar: Int? = null,

    @SerializedName("target_type")
    var targetType: String? = null,

    @SerializedName("target_id")
    var targetId: String? = null,

    @SerializedName("user_id")
    var userId: String? = null,

    @SerializedName("shop_id")
    var shopId: String? = null,

    @SerializedName("shop")
    var shop: Shop? = null,

    @SerializedName("user")
    var user: User? = null,

    @SerializedName("created_at")
    var createdAt: String? = null,

    @SerializedName("update_at")
    var updatedAt: String? = null,

    @SerializedName("ordered_item")
    var orderedItem: OrderItem? = null,

    @SerializedName("order_items")
    var orderItems: List<OrderItem>? = null,

    @SerializedName("shop_feedback")
    var shopFeedback: ShopFeedback? = null,

    @SerializedName("buyer_feedback")
    var buyerFeedback: ShopFeedback? = null,

    @SerializedName("variant")
    var variant: Variation? = null

) : Parcelable {

    @Parcelize
    class ShopFeedback(
        val content: String,
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("updated_at")
        val updatedAt: String
    ) : Parcelable
}

@Parcelize
data class DetailSize(

    @SerializedName("type_size")
    var typeSize: String? = null,

    @SerializedName("size_infos")
    var sizeInfos: List<SizeInfo>? = null

) : Parcelable

@Parcelize
data class SizeInfo(

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("min")
    var min: Int? = null,

    @SerializedName("max")
    var max: Int? = null,

    @SerializedName("unit")
    var unit: String? = null

) : Parcelable

/**
 * get type media [Product.images]
 * [MediaType.TYPE_VIDEO]: "mp4", "mov"
 * [MediaType.TYPE_IMAGE]: other
 */
fun getTypeMedia(path: String): MediaType {
    return if (path.contains("mp4") || path.contains("mov")) {
        MediaType.TYPE_VIDEO
    } else {
        MediaType.TYPE_IMAGE
    }
}

enum class MediaType(val value: Int) {
    TYPE_IMAGE(0),
    TYPE_VIDEO(1)
}

@Parcelize
data class ImageDescription(
    var url: String? = null,
    var width: Long? = null,
    var height: Long? = null
) : Parcelable

@Parcelize
data class TimePrepareOrder(
    var day: String? = null,
    var value: Float? = null,
    var unit: String? = null
) : Parcelable {

    companion object {
        const val KEY_1_DAY = "1"
        const val KEY_2_DAY = "2"
        const val KEY_3_DAY = "3"
        const val KEY_4_DAY = "4"
        const val KEY_THAN_4_DAY = "> 4"
    }

}