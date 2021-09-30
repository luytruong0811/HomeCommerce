package com.example.homebidu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homecommerce.R
import com.example.homecommerce.model.SuggestProduct
import kotlinx.android.synthetic.main.item_suggest_product.view.*
import java.text.DecimalFormat

class SuggestProductAdapter : RecyclerView.Adapter<SuggestProductAdapter.ItemSuggestProduct>() {

    private val items = mutableListOf<SuggestProduct>()

    fun getSuggestProduct(items: List<SuggestProduct>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    class ItemSuggestProduct(view: View) : RecyclerView.ViewHolder(view){
        fun bind(data: SuggestProduct){
            itemView.apply {
                Glide.with(ivSuggestProduct)
                    .load(data.images.firstOrNull())
                    .error(R.mipmap.ic_launcher)
                    .into(ivSuggestProduct)

                tvNameSuggestProduct.text = data.name
                val decimalFormat =  DecimalFormat("###,###,###")
                tvPriceSuggestProduct.text = decimalFormat.format(data.priceMinMax.max).plus(" ₫")
                if (data.shop.country == "VN"){
                    tvCountrySuggest.text = "Việt Nam"
                }
                else if (data.shop.country == "KO"){
                    tvCountrySuggest.text = "Hàn Quốc"
                }
                else {
                    tvCountrySuggest.text = "Mỹ"
                }

                tvSoldSuggest.text = "Đã bán: ${data.sold}"

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemSuggestProduct {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_suggest_product, parent, false)
        return ItemSuggestProduct(view)
    }

    override fun onBindViewHolder(holder: ItemSuggestProduct, position: Int) {
        items.let { holder.bind(it[position]) }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}