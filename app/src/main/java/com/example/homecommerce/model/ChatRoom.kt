package com.example.homecommerce.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class ChatRoom(

    @SerializedName("_id")
    val id: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("type")
    val type: String? = null,

    @SerializedName("users")
    val users: List<UserChat>? = null,

    @SerializedName("creator_id")
    val creatorId: String? = null,

    @SerializedName("is_group")
    val isGroup: Boolean? = null,

    @SerializedName("messages")
    val messages: List<Message>? = null,

    @SerializedName("last_message")
    var lastMessage: Message? = null,

    @SerializedName("red_dot")
    var redDot: Int? = null,

    @SerializedName("last_object")
    var lastObject: Message? = null

) : Parcelable {

    fun getUserId(authId: String?): String? {
        return users?.firstOrNull { it.id != authId }?.id
    }
}