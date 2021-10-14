package com.example.homecommerce.model.ranking

import android.os.Parcelable
import com.example.homecommerce.model.Shop
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by pvduc9773 on 12/05/2021.
 */

@Parcelize
data class ShopRanking(

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("totalRevenue")
    var totalRevenue: Int? = null,

    @SerializedName("shop")
    val shop: Shop,

    @SerializedName("change")
    val change: RankingChange

) : Parcelable {

    @Parcelize
    data class RankingChange(

        @SerializedName("type")
        var type: String,

        @SerializedName("value")
        var value: Int

    ) : Parcelable

    enum class TypeRankingChange(val value: String) {
        UP("UP"),
        DOWN("DOWN"),
        NEW("NEW"),
    }
}