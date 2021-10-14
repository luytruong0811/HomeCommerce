package com.example.homecommerce.model

import android.content.Context
import com.example.homecommerce.R
import com.example.homecommerce.ext.getDefault
import com.example.homecommerce.utils.DateTimeUtils
import com.example.homecommerce.utils.PriceUtils
import com.example.homecommerce.utils.getContainsListString

/**
 * Created by pvduc9773 on 3/7/21.
 */
class ProductModel(val product: Product) {
    fun getId(): String = product.id.orEmpty()

    fun getShopInfo(): Shop? = product.shop

    fun getImage(): String? = product.images?.firstOrNull()

    fun getName(): String = product.name.orEmpty()

    fun getDescription(): String = product.description.orEmpty()

    fun getDescriptionImage(): List<ImageDescription> = product.descriptionImages.orEmpty()

    fun getLocation(context: Context): String? {
        return product.shop?.getTypeShopCountry()?.let {
            when (it) {
                Shop.TypeShopCountry.KOREA -> {
                    context.getString(R.string.korea)
                }
                else -> {
                    context.getString(R.string.viet_nam)
                }
            }
        }
    }

    fun getShippingInfo(): String? = product.shippingInformation
    fun getDeliveryInstruction(): String? = product.deliveryInstruction
    fun getExchangeInfo(): String? = product.exchangeInformation

    fun getCategoryName(): String = product.category?.name.orEmpty()

    private fun getImages(): List<String> {
        return product.images?.filter { !it.contains("mp4") && !it.contains("mov") }.orEmpty()
    }

    private fun getVideos(): List<String> {
        return product.images?.filter { it.contains("mp4") || it.contains("mov") }.orEmpty()
    }

    fun getBanners(): List<String> {
        return mutableListOf<String>().apply {
            addAll(getVideos())
            addAll(getImages())
        }
    }

    fun getSoldPercentage(): Float {
        if (product.quantity.getDefault().toFloat() == 0f) {
            return 100f
        }
        return (product.sold.getDefault().toFloat() / product.quantity.getDefault().toFloat()) * 100
    }

    fun getBookmarkedState(): Boolean = product.isBookmarked

    fun isShowNewProduct(): Boolean {
        product.createdAt?.let {
            val createTime = DateTimeUtils.getDateFromTimeUTC(it)?.time ?: System.currentTimeMillis()
            val currentTime = System.currentTimeMillis()
            return currentTime - createTime <= 5 * 24 * 3600000 // new product request <= 5 day
        }
        return false
    }

    fun isShowBeforeSalePriceDetail(): Boolean {
        return product.discountPercent.getDefault() > 0
    }

    fun isShowBeforeSalePrice(): Boolean {
        return false // TODO not show BeforeSalePrice in item product
    }

    fun isShowDiscountPercent(): Boolean {
        return product.discountPercent.getDefault() > 0
    }

    fun getSalePriceValue(): Long {
        return when {
            product.priceMinMax?.min != null -> {
                val min = product.priceMinMax?.min.getDefault()
                val max = product.priceMinMax?.max.getDefault()
                if (min == max) min
                else min
            }
            product.salePrice != null -> {
                product.salePrice.getDefault()
            }
            else -> 0
        }
    }

    fun getBeforeSalePriceValue(): Long? {
        return product.beforeSalePrice
    }

    fun getBeforeSalePrice(): String {
        return when {
            product.beforeSalePrice.getDefault() > 0 -> {
                PriceUtils.convertLongToPrice(product.beforeSalePrice.getDefault())
            }
            !product.variants.isNullOrEmpty() -> {
                val min = product.variants.orEmpty().map { it.beforeSalePrice.getDefault() }
                    .minOrNull().getDefault()
                val max = product.variants.orEmpty().map { it.beforeSalePrice.getDefault() }
                    .maxOrNull().getDefault()
                if (min == max) PriceUtils.convertLongToPrice(min)
                else PriceUtils.convertLongToPrice(min)
            }
            else -> PriceUtils.convertLongToPrice(0)
        }
    }

    // Hiển thị ở product detail
    fun getSalePriceDetail(): String {
        return when {
            product.salePrice.getDefault() > 0 -> {
                PriceUtils.convertLongToPrice(product.salePrice.getDefault())
            }
            product.priceMinMax?.min.getDefault() > 0 || product.priceMinMax?.max.getDefault() > 0 -> {
                val min = product.priceMinMax?.min.getDefault()
                val max = product.priceMinMax?.max.getDefault()
                if (min == max) PriceUtils.convertLongToPrice(min)
                else "${PriceUtils.convertLongToPrice(min)} - ${PriceUtils.convertLongToPrice(max)}"
            }
            !product.variants.isNullOrEmpty() -> {
                val min = product.variants.orEmpty().map { it.salePrice.getDefault() }.minOrNull().getDefault()
                val max = product.variants.orEmpty().map { it.salePrice.getDefault() }.maxOrNull().getDefault()
                if (min == max) PriceUtils.convertLongToPrice(min)
                else "${PriceUtils.convertLongToPrice(min)} - ${PriceUtils.convertLongToPrice(max)}"
            }
            else -> PriceUtils.convertLongToPrice(0)
        }
    }

    // Hiển thị ở item product (nếu khoảng giá thì hiển thị min)
    fun getSalePrice(): String {
        return when {
            product.salePrice.getDefault() > 0 -> {
                PriceUtils.convertLongToPrice(product.salePrice.getDefault())
            }
            product.priceMinMax?.min.getDefault() > 0 || product.priceMinMax?.max.getDefault() > 0 -> {
                val min = product.priceMinMax?.min.getDefault()
                val max = product.priceMinMax?.max.getDefault()
                if (min == max) PriceUtils.convertLongToPrice(min)
                else PriceUtils.convertLongToPrice(min)
            }
            !product.variants.isNullOrEmpty() -> {
                val min = product.variants.orEmpty().map { it.salePrice.getDefault() }.minOrNull().getDefault()
                val max = product.variants.orEmpty().map { it.salePrice.getDefault() }.maxOrNull().getDefault()
                if (min == max) PriceUtils.convertLongToPrice(min)
                else PriceUtils.convertLongToPrice(min)
            }
            else -> PriceUtils.convertLongToPrice(0)
        }
    }

    fun getProductInformation(): List<ProductInfo> = product.informations.orEmpty()

    fun getTotalViewInMonth(): Int = product.infoMore?.viewInMonth.getDefault()

    fun getSatisfied(): Int = product.infoMore?.satisfied.getDefault()

    fun getTotalLike(): Int = product.infoMore?.like.getDefault()

    fun getTotalFeedback(): Int = product.feedbacks?.totalFeedback.getDefault()

    fun getShopRating(): Float = product.shop?.rating.getDefault()

    fun getChatResponseRate(): Int = product.shop?.chatResponseRate.getDefault()

    fun getAverageFeedback(): Float = product.feedbacks?.averageFeedbackRate.getDefault()

    fun getSatisfactionRate(): Int = product.feedbacks?.satisfactionRate.getDefault().toInt()

    fun getListFeedback(): List<Feedback> = product.feedbacks?.feedbacks.orEmpty()

    fun getListFeedbackMedias(): List<String> = product.feedbacks?.feedbackMedias.orEmpty()

    fun getTotalRatingStar() = product.feedbacks?.totalByStar.orEmpty()

    fun getVariations(): List<Variation> = product.variants.orEmpty()

    fun getSoldNumber(): Int = product.sold.getDefault()

    fun getOptionType(): List<OptionType> = product.optionTypes.orEmpty()

    fun getPriceFromVariation(variation: Variation? = null): String {
        return if (variation != null) {
            PriceUtils.convertLongToPrice(variation.salePrice.getDefault())
        } else {
            when {
                product.priceMinMax?.min != null -> {
                    val min = product.priceMinMax?.min.getDefault()
                    val max = product.priceMinMax?.max.getDefault()
                    if (min == max) PriceUtils.convertLongToPrice(min)
                    else "${PriceUtils.convertLongToPrice(min)} - ${PriceUtils.convertLongToPrice(max)}"
                }
                !product.variants.isNullOrEmpty() -> {
                    val priceVariants = mutableListOf<Long>()
                    product.variants?.forEach {
                        priceVariants.add(it.salePrice.getDefault())
                    }
                    val min = priceVariants.minOrNull()
                    val max = priceVariants.maxOrNull()
                    if (min == max) PriceUtils.convertLongToPrice(min.getDefault())
                    else "${PriceUtils.convertLongToPrice(min.getDefault())} - ${PriceUtils.convertLongToPrice(max.getDefault())}"
                }
                product.salePrice != null -> {
                    PriceUtils.convertLongToPrice(product.salePrice.getDefault())
                }
                else -> PriceUtils.convertLongToPrice(0)
            }
        }
    }

    fun getStockFromVariation(variation: Variation? = null): Int {
        return variation?.quantity ?: when {
            product.quantity != null -> {
                product.quantity.getDefault()
            }
            !product.variants.isNullOrEmpty() -> {
                var quantity = 0
                val variants = product.variants.orEmpty()
                variants.forEach {
                    quantity += it.quantity.getDefault()
                }
                quantity
            }
            else -> {
                0
            }
        }
    }

    fun getVariationFromOptionValues(optionValues: List<OptionValue>): Variation? {
        if (optionValues.isEmpty() || getVariations().isEmpty()) {
            return null
        } else {
            // on check name in option value contains all vs variation names
            getVariations().forEach { variation ->
                val optionValuesString = optionValues.map { it.name.orEmpty() }
                val variationOptionValuesString = variation.optionValues.orEmpty().map { it.name.orEmpty() }
                if (
                    optionValuesString.isNotEmpty()
                    && variationOptionValuesString.isNotEmpty()
                    && getContainsListString(optionValuesString, variationOptionValuesString)
                ) {
                    return variation
                }
            }
            return null
        }
    }

    fun getConditionRefundActive(): List<ReasonReturn> = product.refundConditions.orEmpty().filter { it.active == true }

    fun getRefundDuration(): Int = product.durationRefund.getDefault()

    fun getAllowRefund(): Boolean = product.allowRefund.getDefault()

    fun getTimePrepareOrders() = product.timePrepareOrders

    fun getValueTimePrepareOrder(day: String?): Float? {
        return getTimePrepareOrders()?.firstOrNull { it.day.equals(day, true) }?.value
    }

    fun getDayMaxTimePrepareOrder(): String? {
        var dayMax = getTimePrepareOrders()?.firstOrNull()?.day
        getTimePrepareOrders()?.forEach {
            if (getValueTimePrepareOrder(it.day).getDefault() > getValueTimePrepareOrder(dayMax).getDefault()) {
                dayMax = it.day.getDefault()
            }
        }
        return if (getValueTimePrepareOrder(dayMax).getDefault() > 0) dayMax else null
    }

    fun onCheckDayMax(day: String): Boolean {
        val dayMax = getDayMaxTimePrepareOrder()
        return day.equals(dayMax, true)
    }

    fun getTotalSold() = product.sold.getDefault()

    fun getExpectedShippingFee() = product.expectedShippingFee.orEmpty()

    fun getDiscountPercent(): Int = product.discountPercent.getDefault()

    fun getMaxVoucherDiscount() = product.maxVoucherDiscount.getDefault()

    fun getVouchersApply() = product.vouchers.orEmpty()

    fun getSimilarProducts() = product.similarProducts.orEmpty()

    fun getSuggestProducts() = product.suggestProduct.orEmpty()
}