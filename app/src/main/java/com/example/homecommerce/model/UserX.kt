package com.example.homecommerce.model


import com.google.gson.annotations.SerializedName

data class UserX(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("bodyMeasurement")
    val bodyMeasurement: BodyMeasurement,
    @SerializedName("detail_size_history")
    val detailSizeHistory: List<DetailSizeHistoryX>,
    @SerializedName("email")
    val email: String,
    @SerializedName("email_verified")
    val emailVerified: Boolean,
    @SerializedName("follow_count")
    val followCount: Int,
    @SerializedName("following_count")
    val followingCount: Int,
    @SerializedName("_id")
    val id: String,
    @SerializedName("is_follow")
    val isFollow: Boolean,
    @SerializedName("nameOrganizer")
    val nameOrganizer: NameOrganizer,
    @SerializedName("phone_verified")
    val phoneVerified: Boolean,
    @SerializedName("referral_code")
    val referralCode: String,
    @SerializedName("saved_vouchers")
    val savedVouchers: List<String>,
    @SerializedName("userName")
    val userName: String
)