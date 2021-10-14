package com.example.homecommerce.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 21/07/2021.
 */
@Parcelize
data class Referral(

    @SerializedName("code")
    val code: String? = null

) : Parcelable