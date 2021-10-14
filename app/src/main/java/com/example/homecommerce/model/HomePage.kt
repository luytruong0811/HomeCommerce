package com.example.homecommerce.model

import android.os.Parcelable
import com.example.homecommerce.ext.getDefault
import com.example.homecommerce.prefs.AppLanguage
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 5/4/21.
 */
@Parcelize
class HomePage(

    @SerializedName("total_unread_notify")
    var totalUnreadNotify: Int? = null,

    @SerializedName("total_product_in_cart")
    var totalProductInCart: Int? = null,

    @SerializedName("system_banner")
    var systemBanner: List<SystemBannerHomePage>? = null,

    @SerializedName("system_banner_voucher")
    var systemBannerVoucher: List<SystemBannerHomePage>? = null,

    @SerializedName("top_livestreams")
    var topLiveStreams: List<StreamSessions>? = null,

    @SerializedName("top_product")
    var topProduct: List<Product>? = null,

    @SerializedName("top_shop")
    var topShop: List<TopShopHomePage>? = null,

    @SerializedName("suggest_product")
    var suggestProduct: List<Product>? = null,

    @SerializedName("system_category")
    var systemCategory: List<SystemCategory>? = null,

    @SerializedName("top_keyword")
    var topKeyword: List<TopKeywordHomePage>? = null,

    @SerializedName("newest_product")
    var newestProduct: List<Product>? = null

) : Parcelable {

    @Parcelize
    class SystemBannerHomePage(

        @SerializedName("_id")
        var id: String? = null,

        @SerializedName("name")
        var name: String? = null,

        @SerializedName("images")
        var images: List<ImagesSystemBanner>? = null,

        @SerializedName("shop_id")
        var shopId: String? = null,

        @SerializedName("classify")
        var classify: String? = null,

        @SerializedName("vouchers")
        var vouchers: List<String>? = null,

        @SerializedName("products")
        var products: List<String>? = null,

        @SerializedName("promo_link")
        var promoLink: String? = null,

        @SerializedName("is_active")
        var isActive: Boolean? = null,

        @SerializedName("start_time")
        var startTime: String? = null,

        @SerializedName("end_time")
        var endTime: String? = null

    ) : Parcelable {

        enum class ClassifyType(val value: String) {
            TYPE_PRODUCT("product"),
            TYPE_VOUCHER("voucher"),
            TYPE_LINK("link"),
            TYPE_NONE("none")
        }

        fun getClassifyType(): ClassifyType {
            return when (classify) {
                ClassifyType.TYPE_PRODUCT.value -> ClassifyType.TYPE_PRODUCT
                ClassifyType.TYPE_VOUCHER.value -> ClassifyType.TYPE_VOUCHER
                ClassifyType.TYPE_LINK.value -> ClassifyType.TYPE_LINK
                else -> ClassifyType.TYPE_NONE
            }
        }

        fun getImagesByLanguage(appLanguage: AppLanguage): ImagesSystemBanner? {
            return when (appLanguage) {
                AppLanguage.KOREAN -> {
                    images?.firstOrNull { it.lang == "ko" } ?: images?.firstOrNull()
                }
                AppLanguage.ENGLISH -> {
                    images?.firstOrNull { it.lang == "en" } ?: images?.firstOrNull()
                }
                else -> {
                    images?.firstOrNull { it.lang == "vi" } ?: images?.firstOrNull()
                }
            }
        }
    }


    @Parcelize
    class SystemCategory(

        @SerializedName("_id")
        var id: String? = null,

        @SerializedName("name")
        var name: String? = null,

        @SerializedName("avatar")
        var avatar: String? = null,

        @SerializedName("is_active")
        var isActive: Boolean? = false,

        @SerializedName("priority")
        var priority: Int? = null,

        @SerializedName("permalink")
        var permalink: String? = null,

        @SerializedName("shop_id")
        val shopId: String? = null,

        @SerializedName("childs")
        var childs: List<Category>? = null,

        @SerializedName("created_at")
        var createdAt: String? = null,

        @SerializedName("updated_at")
        var updatedAt: String? = null
    ) : Parcelable

    @Parcelize
    class TopKeywordHomePage(

        @SerializedName("_id")
        var id: String? = null,

        @SerializedName("count_number")
        var count_number: Int? = null,

        @SerializedName("keyword")
        var keyword: String? = null,

        @SerializedName("avatar")
        var avatar: String? = null,

        @SerializedName("total_product")
        var totalProduct: Int? = null

    ) : Parcelable


    @Parcelize
    data class TopShopHomePage(

        @SerializedName("_id")
        var id: String? = null,

        @SerializedName("totalRevenue")
        var totalRevenue: Int? = null,

        @SerializedName("shop")
        val shop: Shop? = null,

        @SerializedName("change")
        val change: RankingChange? = null

    ) : Parcelable {

        @Parcelize
        data class RankingChange(

            @SerializedName("type")
            var type: String,

            @SerializedName("value")
            var value: Int

        ) : Parcelable

        enum class TypeRankingChange(val value: String) {
            UP("UP"),
            DOWN("DOWN"),
            NEW("NEW"),
            EQUAL("EQUAL")
        }

        fun getUserId(): String? {
            return shop?.user?.id
        }

        fun getUserName(): String? {
            return shop?.user?.nameOrganizer?.userName
        }

        fun getUserAvatar(): String? {
            return shop?.user?.avatar
        }

        fun getFollowCount(): Int {
            return shop?.user?.follow_count.getDefault()
        }

        fun getStatusFollow(): Boolean {
            return shop?.user?.is_follow.getDefault()
        }
    }


    @Parcelize
    class ImagesSystemBanner(

        @SerializedName("top")
        var top: String? = null,

        @SerializedName("middle")
        var middle: String? = null,

        @SerializedName("detail")
        var detail: String? = null,

        @SerializedName("lang")
        var lang: String? = null

    ) : Parcelable

}