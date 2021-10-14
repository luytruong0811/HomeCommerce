package com.example.homecommerce.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 13/06/2021.
 */
@Parcelize
class AddressDefault(

    @SerializedName("address_default")
    val addressDefault: Address? = null,

    @SerializedName("pick_address_default")
    val pickAddressDefault: Address? = null,

    @SerializedName("return_address_default")
    val returnAddressDefault: Address? = null

) : Parcelable