package com.example.homecommerce.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 21/07/2021.
 */
@Parcelize
data class ReasonReport(
    val code: String? = null,
    var name: String? = null
) : Parcelable