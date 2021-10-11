import com.example.homecommerce.model.OptionValue
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class OptionType(
    @SerializedName("_id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("option_values")
    val optionValues: List<OptionValue>
)