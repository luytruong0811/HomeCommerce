package com.example.homecommerce.model

import android.os.Parcelable
import com.example.homecommerce.prefs.AppLanguage
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 7/25/21.
 */
@Parcelize
data class ReasonReturn(

    @SerializedName("active")
    var active: Boolean? = null,

    @SerializedName("code")
    var code: Int? = null,

    @SerializedName("vn_name")
    var vnName: String? = null,

    @SerializedName("ko_name")
    var koName: String? = null,

    @SerializedName("en_name")
    var enName: String? = null

) : Parcelable {

    fun getName(appLanguage: AppLanguage): String? {
        return when (appLanguage) {
            AppLanguage.KOREAN -> koName
            AppLanguage.ENGLISH -> enName
            else -> vnName
        }
    }

}