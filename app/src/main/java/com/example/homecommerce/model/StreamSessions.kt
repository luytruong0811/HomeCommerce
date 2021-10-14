package com.example.homecommerce.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 3/21/21.
 */
@Parcelize
class StreamSessions(

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("image")
    var image: String? = null,

    @SerializedName("stream_id")
    var streamId: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("is_approved")
    var isApproved: String? = null,

    @SerializedName("list_id_product")
    var productIds: List<String>? = null,

    @SerializedName("products")
    var products: List<Product>? = null,

    @SerializedName("stream")
    var stream: Stream? = null,

    @SerializedName("status")
    var status: String? = null,

    @SerializedName("user")
    var user: UserStream? = null,

    @SerializedName("view")
    var view: Int? = null,

    @SerializedName("view_max")
    var viewMax: Int? = null,

    @SerializedName("heart")
    var heart: Int? = null,

    @SerializedName("active")
    var active: Boolean? = null,

    @SerializedName("archive_link")
    var archiveLink: String? = null,

    @SerializedName("archive_links")
    var archiveLinks: List<String>? = null,

    @SerializedName("session_number")
    var sessionNumber: Long? = null,

    @SerializedName("time_will_start")
    var timeWillStart: String? = null,

    @SerializedName("type_of_viewer")
    var typeOfViewer: String? = null,

    @SerializedName("type")
    var type: String? = null,

    @SerializedName("room_chat_id")
    var roomChatId: String? = null,

    @SerializedName("shop_id")
    var shopId: String? = null,

    @SerializedName("shop")
    var shop: Shop? = null

) : Parcelable {
    @Parcelize
    class UserStream(

        @SerializedName("_id")
        var id: String? = null,

        @SerializedName("avatar")
        var avatar: String? = null,

        @SerializedName("email")
        var email: String? = null,

        @SerializedName("nameOrganizer")
        var nameOrganizer: NameOrganizer? = null,

        @SerializedName("follow_count")
        var followCount: Int? = null,

        @SerializedName("following_count")
        var followingCount: Int? = null,

        @SerializedName("is_follow")
        var isFollow: Boolean? = null

    ) : Parcelable {
        @Parcelize
        class NameOrganizer(

            @SerializedName("userName")
            var userName: String? = null,

            @SerializedName("unsigneduserName")
            var unsignedUserName: String? = null

        ) : Parcelable
    }

    @Parcelize
    class StreamShop(

        @SerializedName("_id")
        var id: String? = null,

        @SerializedName("name")
        var name: String? = null,

        @SerializedName("description")
        var description: String? = null,

        @SerializedName("user_id")
        var userId: String? = null,

        @SerializedName("pause_mode")
        var pauseMode: Boolean? = null,

        @SerializedName("return_money_mode")
        var returnMoneyMode: Boolean? = null,

        @SerializedName("refund_money_mode")
        var refundMoneyMode: Boolean? = null,

        @SerializedName("refund_money_regulations")
        var refundMoneyRegulations: RefundMoneyRegulations? = null,

        @SerializedName("shop_type")
        var shopType: Boolean? = null,

        @SerializedName("createdAt")
        var createdAt: String? = null,

        @SerializedName("updatedAt")
        var updatedAt: String? = null

    ) : Parcelable {
        @Parcelize
        class RefundMoneyRegulations(

            @SerializedName("refund_max")
            var refundMax: Long? = null

        ) : Parcelable
    }
}

@Parcelize
class Stream(

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("rtmp_link")
    var rtmpLink: String? = null,

    @SerializedName("hls_link")
    var hlsLink: String? = null,

    @SerializedName("user_id")
    var userId: String? = null,

    @SerializedName("shop_id")
    var shopId: String? = null,

    @SerializedName("createdAt")
    var createdAt: String? = null,

    @SerializedName("updatedAt")
    var updatedAt: String? = null

) : Parcelable