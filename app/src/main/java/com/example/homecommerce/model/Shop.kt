package com.example.homecommerce.model

import android.os.Parcelable
import com.example.homecommerce.model.user.User
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 3/12/21.
 */
@Parcelize
data class Shop(

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("avatar")
    var avatar: String? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("user_id")
    var userId: String? = null,

    @SerializedName("user")
    var user: User? = null,

    @SerializedName("shop_type")
    var shopType: Int? = null,

    @SerializedName("createdAt")
    var createdAt: String? = null,

    @SerializedName("updatedAt")
    var updatedAt: String? = null,

    @SerializedName("refund_money_regulations")
    val refundMoneyRegulations: RefundMoneyRegulations? = null,

    @SerializedName("refund_money_mode")
    val refundMoneyMode: Boolean? = null,

    @SerializedName("pause_mode")
    val pauseMode: Boolean? = null,

    @SerializedName("follow_count")
    val followCount: Int? = null,

    @SerializedName("following_count")
    val followingCount: Int? = null,

    @SerializedName("rating")
    val rating: Float? = null,

    @SerializedName("is_live")
    val isLive: Boolean? = null,

    @SerializedName("feedback")
    val feedback: Feedbacks? = null,

    @SerializedName("country")
    var country: String? = null,

    @SerializedName("chat_response_rate")
    var chatResponseRate: Int? = null

) : Parcelable {

    enum class TypeShopCountry(val value: String) {
        VIETNAM("VN"),
        KOREA("KO")
    }

    fun getTypeShopCountry(): TypeShopCountry? {
        return TypeShopCountry.values().find { it.value == country }
    }

}

@Parcelize
class RefundMoneyRegulations(
    @SerializedName("refund_max")
    val refundMax: Long? = null,
    val regulations: String? = null
) : Parcelable
