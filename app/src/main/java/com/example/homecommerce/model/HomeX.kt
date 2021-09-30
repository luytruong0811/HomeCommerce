package com.example.homecommerce.model


import OptionType
import com.google.gson.annotations.SerializedName

data class HomeX(
    @SerializedName("allow_refund")
    val allowRefund: Boolean,
    @SerializedName("allow_to_sell")
    val allowToSell: Boolean,
    @SerializedName("before_sale_price")
    val beforeSalePrice: Int,
    @SerializedName("category")
    val category: Any,
    @SerializedName("category_id")
    val categoryId: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("deleted_at")
    val deletedAt: Any,
    @SerializedName("delivery_information")
    val deliveryInformation: Any,
    @SerializedName("delivery_instruction")
    val deliveryInstruction: Any,
    @SerializedName("description")
    val description: String,
    @SerializedName("description_images")
    val descriptionImages: List<DescriptionImage>,
    @SerializedName("detail_size")
    val detailSize: List<DetailSizeX>,
    @SerializedName("discount_percent")
    val discountPercent: Any,
    @SerializedName("duration_refund")
    val durationRefund: Any,
    @SerializedName("exchange_information")
    val exchangeInformation: Any,
    @SerializedName("friendly_url")
    val friendlyUrl: String,
    @SerializedName("height")
    val height: Any,
    @SerializedName("_id")
    val id: String,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("is_approved")
    val isApproved: String,
    @SerializedName("is_bookmarked")
    val isBookmarked: Boolean,
    @SerializedName("is_pre_order")
    val isPreOrder: Boolean,
    @SerializedName("length")
    val length: Any,
    @SerializedName("limit_sale_price_order")
    val limitSalePriceOrder: Int,
    @SerializedName("list_category_id")
    val listCategoryId: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("option_types")
    val optionTypes: List<OptionType>,
    @SerializedName("order_items")
    val orderItems: Any,
    @SerializedName("price_min_max")
    val priceMinMax: PriceMinMax,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("refund_conditions")
    val refundConditions: List<RefundCondition>,
    @SerializedName("sale_price")
    val salePrice: Int,
    @SerializedName("sale_price_order_available")
    val salePriceOrderAvailable: Int,
    @SerializedName("shipping_information")
    val shippingInformation: Any,
    @SerializedName("shop")
    val shop: Any,
    @SerializedName("shop_id")
    val shopId: String,
    @SerializedName("short_description")
    val shortDescription: Any,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("variants")
    val variants: List<Variant>,
    @SerializedName("weight")
    val weight: Int,
    @SerializedName("width")
    val width: Any
)