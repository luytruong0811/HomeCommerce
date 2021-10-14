package com.example.homecommerce.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 15/06/2021.
 */
@Parcelize
data class UnRedNotification(
    var community: Int? = null,
    var commerce: Int? = null
):Parcelable