package com.example.homecommerce.model
import SystemBannerVoucher
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("newest_product")
    val newestProduct: List<NewestProduct> ?= null,
    @SerializedName("suggest_product")
    val suggestProduct: List<SuggestProduct> ?= null,
    @SerializedName("system_banner")
    val systemBanner: List<SystemBanner> ?= null,
    @SerializedName("system_banner_voucher")
    val systemBannerVoucher: List<SystemBannerVoucher> ?= null,
    @SerializedName("system_category")
    val systemCategory: List<SystemCategory> ?= null,
    @SerializedName("top_keyword")
    val topKeyword: List<TopKeyword> ?= null,
    @SerializedName("top_livestreams")
    val topLivestreams: List<TopLivestream> ?= null,
    @SerializedName("top_product")
    val topProduct: List<TopProduct> ?= null,
    @SerializedName("top_shop")
    val topShop: List<TopShop>,
    @SerializedName("total_product_in_cart")
    val totalProductInCart: Int ?= 0,
    @SerializedName("total_unread_notify")
    val totalUnreadNotify: Int ?= 0
)