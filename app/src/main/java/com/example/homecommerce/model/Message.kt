package com.example.homecommerce.model

import android.content.Context
import android.os.Parcelable
import com.example.homecommerce.R
import com.example.homecommerce.ext.getDefault
import com.example.homecommerce.model.user.User
import com.example.homecommerce.utils.DateTimeUtils
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*
import java.util.concurrent.TimeUnit

@Parcelize
class Message(

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("content")
    val content: String? = null,

    @SerializedName("type")
    val type: String? = null,

    @SerializedName("user_id")
    val userId: String? = null,

    @SerializedName("user")
    val user: UserChat? = null

) : Parcelable {

    enum class TypeMessage {
        ITEM_MESSAGE_HOST,
        ITEM_MESSAGE_GUEST
    }

    enum class TypeContentMessage(val value: String) {
        TYPE_TEXT("text"),
        TYPE_IMAGE("image"),
        TYPE_CUSTOMIZE("customize")
    }

    fun getTypeMessage(host: User?): TypeMessage {
        return if (user?.id == host?.id) {
            TypeMessage.ITEM_MESSAGE_HOST
        } else {
            TypeMessage.ITEM_MESSAGE_GUEST
        }
    }

    fun getTypeContentMessage(): TypeContentMessage {
        return when (type) {
            TypeContentMessage.TYPE_CUSTOMIZE.value -> TypeContentMessage.TYPE_CUSTOMIZE
            TypeContentMessage.TYPE_IMAGE.value -> TypeContentMessage.TYPE_IMAGE
            else -> TypeContentMessage.TYPE_TEXT
        }
    }

    fun getTimeSecondMessage(): Long {
        return id.getDefault().toLong()
    }

    // group message by DayInMonth key
    fun getTimeDayMessage(): Long {
        return TimeUnit.SECONDS.toDays(getTimeSecondMessage())
    }

    fun getDateTimeSendMessageToString(context: Context): String {
        val currentDay = DateTimeUtils.currentDate()
        val sendDay = DateTimeUtils.convertSecondToDate(getTimeSecondMessage())
        val timeDiff = currentDay.time - sendDay.time
        val dayDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS).toInt()
        return when (dayDiff) {
            0 -> {
                context.getString(R.string.today)
            }
            in 1..6 -> {
                DateTimeUtils.getDateTimeFormat(sendDay, DateTimeUtils.EEEE_dd_MM_yyyy)
            }
            else -> {
                DateTimeUtils.getDateTimeFormat(sendDay, DateTimeUtils.dd_MM_yyyy)
            }
        }
    }
}