package com.example.homecommerce.model.user

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 * Created by hung.nguyendk on 4/5/21.
 */
@Parcelize
data class BodyMeasurement(

    var height: Float = 0f,

    var weight: Float = 0f,

    var bustSize: Float = 0f,

    var waistSize: Float = 0f,

    var highHipSize: Float = 0f,

    var hipSize: Float = 0f

) : Parcelable