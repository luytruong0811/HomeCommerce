package com.example.homecommerce.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homecommerce.R
import com.example.homecommerce.ext.*
import com.example.homecommerce.model.Product
import com.example.homecommerce.model.ProductModel
import com.example.homecommerce.prefs.UserPref
import kotlinx.android.synthetic.main.item_home_page_top_product.view.*
import kotlinx.android.synthetic.main.item_top_product.view.*
import java.text.DecimalFormat

class TopProductAdapter(
//    private val userPref: UserPref,
    private val onItemClickListener: (Product) -> Unit,
    private val onBookmarkClickListener: (Product) -> Unit
) : RecyclerView.Adapter<TopProductAdapter.ItemProductVH>(){

    private val items = mutableListOf<Product>()


    fun setTopProduct(items: List<Product>){
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun findPositionAndUpdateItem(product: Product): Int {
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
//        private val userPref: UserPref,
        private val onItemClickListener: (Product) -> Unit,
        private val onBookmarkClickListener: (Product) -> Unit
    ) : RecyclerView.ViewHolder(view){
        @SuppressLint("SetTextI18n")
        fun bind(data : Product, position : Int){
            val productModel = ProductModel(data)
            itemView.apply {
                tvRanking.text = "$position"

                ivProductImage.loadImageUrl(productModel.getImage().orEmpty())

                tvProductName.text = productModel.getName()

                tvProductPrice.text = productModel.getSalePrice()

                tvProductSold.setVisible(productModel.getTotalSold() > 0)
                if (productModel.getTotalSold() >= 0) {
                    tvProductSold.text = context.getString(R.string.sold_s, productModel.getTotalSold().formatToString())
                }

                tvLabelDiscount.setVisible(productModel.isShowDiscountPercent())
                if (productModel.isShowDiscountPercent()) {
                    tvLabelDiscount.text = "${productModel.getDiscountPercent()}%"
                }

                tvProductLocationTest.setVisible(!productModel.getLocation(context).isNullOrEmpty())
                if (!productModel.getLocation(context).isNullOrEmpty()) {
                    tvProductLocationTest.text = productModel.getLocation(context)
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