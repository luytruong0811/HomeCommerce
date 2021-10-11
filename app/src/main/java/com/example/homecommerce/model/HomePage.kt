package com.example.homecommerce.model
import SystemBannerVoucher
import android.os.Parcelable
import com.example.homecommerce.ext.getDefault
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

//@Parcelize
data class HomePage(
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
    //val topShop: List<TopShopHomePage>? = null,
    val topShop: List<TopShop> ?= null,
    @SerializedName("total_product_in_cart")
    val totalProductInCart: Int ?= 0,
    @SerializedName("total_unread_notify")
    val totalUnreadNotify: Int ?= 0
)
//    : Parcelable {
//
//    @Parcelize
//    data class TopShopHomePage(
//
//        @SerializedName("_id")
//        var id: String? = null,
//
//        @SerializedName("totalRevenue")
//        var totalRevenue: Int? = null,
//
//        @SerializedName("shop")
//        val shop: ShopXXX? = null,
//
//        @SerializedName("change")
//        val change: RankingChange? = null
//    ): Parcelable {
//        @Parcelize
//        data class RankingChange(
//
//            @SerializedName("type")
//            var type: String,
//
//            @SerializedName("value")
//            var value: Int
//
//        ) : Parcelable
//
//        enum class TypeRankingChange(val value: String) {
//            UP("UP"),
//            DOWN("DOWN"),
//            NEW("NEW"),
//            EQUAL("EQUAL")
//        }
//
//        fun getUserId(): String? {
//            return shop?.user?.id
//        }
//
//        fun getUserAvatar(): String? {
//            return  shop?.user?.avatar
//        }
//
//        fun getUserName(): String? {
//            return  shop?.user?.userName
//        }
//
//        fun getFollowCount(): Int {
//            return shop?.user?.followCount.getDefault()
//        }
//    }

//}
