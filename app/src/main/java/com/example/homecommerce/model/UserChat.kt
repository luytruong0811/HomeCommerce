package com.example.homecommerce.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 4/15/21.
 */
@Parcelize
class UserChat(

    @SerializedName("_id")
    val id: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("userName")
    val userName: String? = null,

    @SerializedName("avatar")
    val avatar: String? = null,

    @SerializedName("email")
    val email: String? = null,

    @SerializedName("gender")
    val gender: Int? = null,

    @SerializedName("is_muted")
    val isMuted: Boolean? = null,

    @SerializedName("is_online")
    val isOnline: Boolean? = null,

    @SerializedName("red_dot")
    val redDot: Int? = null,

    @SerializedName("seen_last_message_index")
    val seenLastMessageIndex: Int? = null

) : Parcelable