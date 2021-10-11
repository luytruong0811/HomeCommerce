package com.example.homecommerce.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homecommerce.R
import com.example.homecommerce.ext.imageDrawable
import com.example.homecommerce.ext.setOnDelayClickListener
import com.example.homecommerce.ext.toPx
import com.example.homecommerce.model.SuggestProduct
import com.example.homecommerce.model.SuggestProductModel
import com.example.homecommerce.model.TopProduct
import kotlinx.android.synthetic.main.item_product.view.*
import kotlinx.android.synthetic.main.item_suggest_product.view.*
import kotlinx.android.synthetic.main.item_top_product.view.*
import java.text.DecimalFormat

class SuggestProductAdapter (
    private val onItemClickListener: (SuggestProduct) -> Unit,
    private val onBookmarkClickListener: (SuggestProduct) -> Unit
    ) : RecyclerView.Adapter<SuggestProductAdapter.ItemSuggestProduct>() {

    private val items = mutableListOf<SuggestProduct>()

    fun setSuggestProduct(items: List<SuggestProduct>){
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun findPositionAndUpdateItem(product: SuggestProduct): Int {
        var position = -1
        items.forEachIndexed { i, p ->
            if (p.id == product.id) {
                p.isBookmarked = product.isBookmarked
                position = i
                return@forEachIndexed
            }
        }
        return position
    }

    class ItemSuggestProduct(
        view: View,
        private  val onItemClickListener: (SuggestProduct) -> Unit,
        private  val onBookmarkClickListener: (SuggestProduct) -> Unit
    ) : RecyclerView.ViewHolder(view){
        @SuppressLint("SetTextI18n")
        fun bind(data: SuggestProduct){
            val suggestProductModel = SuggestProductModel(data)
            itemView.apply {
                Glide.with(ivProductImage)
                    .load(data.images.firstOrNull())
                    .error(R.mipmap.ic_launcher)
                    .into(ivProductImage)

                tvProductName.text = data.name
                val decimalFormat =  DecimalFormat("###,###,###")
                tvProductPrice.text = decimalFormat.format(data.priceMinMax.max).plus(" ₫")
                if (data.shop.country == "VN"){
                    tvProductLocation.text = "Việt Nam"
                }
                else if (data.shop.country == "KO"){
                    tvProductLocation.text = "Hàn Quốc"
                }
                else {
                    tvProductLocation.text = "Mỹ"
                }

                tvProductSold.text = "Đã bán "+data.sold

                if(data.discountPercent==0) {
                    tvLabelDiscount.visibility = View.GONE
                } else {
                    tvLabelDiscount.text = data.discountPercent.toString()+"%"
                }
                tvLabelNew.visibility = View.GONE

                updateBookmarkState(suggestProductModel.getBookmarkedState())

                ivBookmarkProduct.setOnDelayClickListener {
                    onBookmarkClickListener.invoke(data)
                }
                setOnDelayClickListener {
                    onItemClickListener.invoke(data)
                }
            }
        }
        fun updateBookmarkState(isFavorite: Boolean) {
            with(itemView) {
                ivBookmarkProduct.imageDrawable(
                    if (isFavorite) R.drawable.ic_bookmark_product else R.drawable.ic_unbookmark_product
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemSuggestProduct {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        view.layoutParams = ViewGroup.LayoutParams(166f.toPx(parent.context), ViewGroup.LayoutParams.WRAP_CONTENT)
        view.setPadding(5f.toPx(parent.context), 0f.toPx(parent.context), 5f.toPx(parent.context), 20f.toPx(parent.context))
        return ItemSuggestProduct(view, onItemClickListener, onBookmarkClickListener)
    }

    override fun onBindViewHolder(holder: ItemSuggestProduct, position: Int) {
        items.let { holder.bind(it[position]) }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}