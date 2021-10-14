package com.example.homecommerce.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class AddAddressRequest(
    var name: String? = null,
    var phone: String? = null,
    var state: AddressLocation? = null,
    var district: AddressLocation? = null,
    var ward: AddressLocation? = null,
    var street: String? = null,
    var is_default: Boolean? = null,
    var is_pick_address_default: Boolean? = null,
    var is_return_address_default: Boolean? = null
) {
    fun clearDistrict() {
        district = null
    }

    fun clearWards() {
        ward = null
    }

    fun setState(location: Location?) {
        location?.let {
            state = AddressLocation(location.id, location.name)
        }
    }

    fun setDistrict(location: Location?) {
        location?.let {
            district = AddressLocation(location.id, location.name)
        }
    }

    fun setWard(location: Location?) {
        location?.let {
            ward = AddressLocation(location.id, location.name)
        }
    }

    @Parcelize
    class AddressLocation(
        var id: String? = null,
        var name: String? = null
    ) : Parcelable
}