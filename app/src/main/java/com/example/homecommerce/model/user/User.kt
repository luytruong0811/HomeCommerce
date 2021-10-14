package com.example.homecommerce.model.user

import android.os.Parcelable
import com.example.homecommerce.model.Shop
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import timber.log.Timber

/**
 * Created by hung.nguyendk on 10/6/20.
 */
@Parcelize
data class User(

    @SerializedName("_id")
    var id: String? = null,

    var userName: String? = null,

    var nameOrganizer: NameOrganizer? = null,

    var email: String? = null,

    var avatar: String? = null,

    var imageCover: String? = null,

    var cover: Cover? = null,

    var followCount: Int = 0,

    var follow_count: Int = 0,

    var followingCount: Int = 0,

    var following_count: Int = 0,

    var totalPosts: Int = 0,

    var createdAt: String? = null,

    var updatedAt: String? = null,

    var description: String? = null,

    var phoneNumber: String? = null,

    var birthday: String? = null,

    var gender: Int = 0,

    var isSocial: Boolean = false,

    var isFollow: Boolean = false,

    var is_follow: Boolean = false,

    var isInterestShowed: Boolean = false, // interest: false -> show, true -> not show

    var isVerified: Boolean = false,

    var verificationType: Int = 0,

    var hasNewStory: Boolean = false,

    var bodyShapeType: String? = null,

    var bodyMeasurement: BodyMeasurement? = null,

    @SerializedName("gallery_image")
    var galleryImage: GalleryImage? = null,

    var shop: Shop? = null,

    var banners: List<Banner>? = null,

    @SerializedName("phone_verified")
    var phoneVerified: Boolean = false,

    @SerializedName("email_verified")
    var emailVerified: Boolean = false,

    @SerializedName("feedback")
    var feedback: Float? = null,

    @SerializedName("is_online")
    var isOnline: Boolean = false

) : Parcelable {

    companion object {
        fun fromJson(json: String?): User? {
            return try {
                json ?: throw Exception("pref: no user data")
                Gson().fromJson(json, User::class.java)
            } catch (e: Exception) {
                Timber.e("fail to get user info from pref: ${e.message}")
                e.printStackTrace()
                null
            }
        }
    }

    fun toJson(): String? {
        return try {
            Gson().toJson(this)
        } catch (e: Exception) {
            Timber.e("fail to pass json user info: ${e.message}")
            e.printStackTrace()
            null
        }
    }

    enum class VerificationType(val value: Int) { // is BiDu account
        OTHER(0),
        BIDU(1)
    }
}

@Parcelize
class NameOrganizer(

    @SerializedName("userName")
    var userName: String? = null,

    @SerializedName("unsigneduserName")
    var unsignedUserName: String? = null

) : Parcelable


@Parcelize
class GalleryImage(

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("mimeType")
    var mimeType: String? = null,

    @SerializedName("galleryImageAbleId")
    var galleryImageAbleId: String? = null,

    @SerializedName("galleryImageAbleType")
    var galleryImageAbleType: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("isActive")
    var isActive: Boolean? = null,

    @SerializedName("createdAt")
    var createdAt: String? = null,

    @SerializedName("updatedAt")
    var updatedAt: String? = null

) : Parcelable

@Parcelize
class Banner(

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("image")
    var image: String? = null,

    @SerializedName("mobileVNURL")
    var mobileVNURL: String? = null,

    @SerializedName("mobileKOURL")
    var mobileKOURL: String? = null,

    @SerializedName("promo_link")
    var promoLink: String? = null,

    @SerializedName("is_active")
    var isActive: Boolean? = null,

    @SerializedName("start_time")
    var startTime: String? = null,

    @SerializedName("end_time")
    var endTime: String? = null,

    @SerializedName("products")
    var products: List<String>? = null

) : Parcelable

@Parcelize
data class Cover(

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("x_percent_offset")
    var xPercentOffset: Float? = null,

    @SerializedName("y_percent_offset")
    var yPercentOffset: Float? = null

) : Parcelable