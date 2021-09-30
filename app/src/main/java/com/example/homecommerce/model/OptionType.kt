import com.example.homecommerce.model.OptionValue
import com.google.gson.annotations.SerializedName

data class OptionType(
    @SerializedName("_id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("option_values")
    val optionValues: List<OptionValue>
)