package com.example.homecommerce.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homecommerce.R
import com.example.homecommerce.ext.imageDrawable
import com.example.homecommerce.ext.setOnDelayClickListener
import com.example.homecommerce.ext.toPx
import com.example.homecommerce.model.SuggestProduct
import com.example.homecommerce.model.TopProduct
import com.example.homecommerce.model.TopProductModel
import kotlinx.android.synthetic.main.item_home_page_top_product.view.*
import kotlinx.android.synthetic.main.item_product.view.*
import kotlinx.android.synthetic.main.item_product.view.ivProductImage
import kotlinx.android.synthetic.main.item_product.view.tvLabelDiscount
import kotlinx.android.synthetic.main.item_product.view.tvProductName
import kotlinx.android.synthetic.main.item_product.view.tvProductPrice
import kotlinx.android.synthetic.main.item_product.view.tvProductSold
import kotlinx.android.synthetic.main.item_top_product.view.*
import java.text.DecimalFormat

class TopProductAdapter(
    private val onItemClickListener: (TopProduct) -> Unit,
    private val onBookmarkClickListener: (TopProduct) -> Unit
) : RecyclerView.Adapter<TopProductAdapter.ItemProductVH>(){

    private val items = mutableListOf<TopProduct>()


    fun setTopProduct(items: List<TopProduct>){
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun findPositionAndUpdateItem(product: TopProduct): Int {
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

    class ItemProductVH(
        view : View,
        private val onItemClickListener: (TopProduct) -> Unit,
        private val onBookmarkClickListener: (TopProduct) -> Unit
    ) : RecyclerView.ViewHolder(view){
        @SuppressLint("SetTextI18n")
        fun bind(data : TopProduct, count : Int){
            val productModel = TopProductModel(data)
            itemView.apply {
                tvRanking.text = "$count"
                Glide.with(ivProductImage)
                    .load(data.images.firstOrNull())
                    .error(R.mipmap.ic_launcher)
                    .into(ivProductImage)
                Log.d("TAG", "image1 = ${data.images}")

                tvProductName.text = data.name
                val decimalFormat =  DecimalFormat("###,###,###")
                tvProductPrice.text = decimalFormat.format(data.priceMinMax.max).plus(" ₫")

                tvProductSold.text = "Đã bán ${data.sold}"

                if(data.discount_percent == 0) {
                    tvLabelDiscount.visibility = View.GONE
                } else {
                    tvLabelDiscount.text = data.discount_percent.toString()+"%"
                }

                updateBookmarkState(productModel.getBookmarkedState())

                ivBookmarkTopProduct.setOnDelayClickListener {
                    onBookmarkClickListener.invoke(data)
                }
                setOnDelayClickListener {
                    onItemClickListener.invoke(data)
                }

            }
        }

        fun updateBookmarkState(isFavorite: Boolean) {
            with(itemView) {
                ivBookmarkTopProduct.imageDrawable(
                    if (isFavorite) R.drawable.ic_bookmark_product else R.drawable.ic_unbookmark_product
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemProductVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_page_top_product, parent, false)
        view.layoutParams = ViewGroup.LayoutParams(114f.toPx(parent.context), ViewGroup.LayoutParams.MATCH_PARENT)
        view.setPadding(10f.toPx(parent.context), 0f.toPx(parent.context), 0f.toPx(parent.context), 0f.toPx(parent.context))
        return ItemProductVH(view, onItemClickListener, onBookmarkClickListener)
    }

    override fun onBindViewHolder(holder: ItemProductVH, position: Int) {
        items.let { holder.bind(it[position], position + 1) }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}