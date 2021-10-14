package com.example.homecommerce.model

import android.os.Parcelable
import com.example.homecommerce.R
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

/**
 * Created by pvduc9773 on 5/2/21.
 */
@Parcelize
class PaymentMethod(

    @SerializedName("_id")
    val id: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("name_query")
    val nameQuery: String? = null

) : Parcelable

enum class TypePaymentMethod(val id: String, val nameQuery: String, val nameRes: Int) {
    VNPAY("6080f24dca33c1913de1be35", "VNPAY", R.string.vnpay),
    MOMO("6080f319ca33c1913de1be36", "MOMO", R.string.momo),
    CASH("6080f987ca33c1913de1be38", "CASH", R.string.cash)
}

@Parcelize
data class VNPAYPaymentMethod(

    @SerializedName("RspCode")
    var RspCode: String? = null,

    @SerializedName("url")
    var url: String? = null

) : Parcelable


@Parcelize
data class MOMOPaymentMethod(

    @SerializedName("requestId")
    var requestId: String? = null,

    @SerializedName("errorCode")
    var errorCode: Int? = null,

    @SerializedName("orderId")
    var orderId: String? = null,

    @SerializedName("message")
    var message: String? = null,

    @SerializedName("localMessage")
    var localMessage: String? = null,

    @SerializedName("requestType")
    var requestType: String? = null,

    @SerializedName("payUrl")
    var payUrl: String? = null,

    @SerializedName("signature")
    var signature: String? = null,

    @SerializedName("qrCodeUrl")
    var qrCodeUrl: String? = null,

    @SerializedName("deeplink")
    var deeplink: String? = null

) : Parcelable