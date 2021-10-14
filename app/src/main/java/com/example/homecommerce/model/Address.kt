package com.example.homecommerce.model

import android.os.Parcelable
import com.example.homecommerce.ext.getDefault
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 4/28/21.
 */
@Parcelize
data class Address(

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("phone")
    var phone: String? = null,

    @SerializedName("main_address")
    var mainAddress: String? = null,

    @SerializedName("country")
    var country: String? = null,

    @SerializedName("accessible_type")
    var accessible_type: String? = null,

    @SerializedName("accessible_id")
    var accessible_id: String? = null,

    @SerializedName("is_default")
    var isDefault: Boolean? = null,

    @SerializedName("is_pick_address_default")
    var isPickAddressDefault: Boolean? = null,

    @SerializedName("is_return_address_default")
    var isReturnAddressDefault: Boolean? = null,

    @SerializedName("state")
    var state: AddressOption? = null,

    @SerializedName("district")
    var district: AddressOption? = null,

    @SerializedName("ward")
    var ward: AddressOption? = null,

    @SerializedName("street")
    var street: String? = null

) : Parcelable {

    @Parcelize
    data class AddressOption(
        var id: String? = null,
        var name: String? = null
    ) : Parcelable

    fun getNameAndPhoneToString(): String? {
        var phoneNameAddress: String? = null
        name?.let { name ->
            phoneNameAddress = phoneNameAddress.getDefault() + "${name.getDefault()} - "
        }
        phone?.let { phone ->
            phoneNameAddress = phoneNameAddress.getDefault() + phone
        }
        return phoneNameAddress
    }

    fun getAddressToString(): String? {
        var addressToString: String? = null
        street?.let { street ->
            addressToString = addressToString.getDefault() + "${street.getDefault()}, "
        }
        ward?.let { ward ->
            addressToString = addressToString.getDefault() + "${ward.name.getDefault()}, "
        }
        district?.let { district ->
            addressToString = addressToString.getDefault() + "${district.name.getDefault()}, "
        }
        state?.let { state ->
            addressToString = addressToString.getDefault() + state.name.getDefault()
        }
        return addressToString
    }
}