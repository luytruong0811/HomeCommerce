import com.example.homecommerce.model.ImageAd
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class SystemBannerVoucher(
    @SerializedName("classify")
    val classify: String,
    @SerializedName("end_time")
    val endTime: Int,
    @SerializedName("_id")
    val id: String,
    @SerializedName("image")
    val image: Any,
    @SerializedName("images")
    val images: List<ImageAd>,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("order")
    val order: Any,
    @SerializedName("position")
    val position: String,
    @SerializedName("products")
    val products: List<Any>,
    @SerializedName("promo_link")
    val promoLink: String,
    @SerializedName("shop_id")
    val shopId: Any,
    @SerializedName("start_time")
    val startTime: Int,
    @SerializedName("vouchers")
    val vouchers: List<Any>
)