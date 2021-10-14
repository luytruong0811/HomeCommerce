package com.example.homecommerce.adapter

import android.annotation.SuppressLint
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
import kotlinx.android.synthetic.main.item_product.view.*
import kotlinx.android.synthetic.main.item_suggest_product.view.*
import kotlinx.android.synthetic.main.item_top_product.view.*
import java.text.DecimalFormat

class SuggestProductAdapter (
//    private val userPref: UserPref,
    private val onItemClickListener: (Product) -> Unit,
    private val onBookmarkClickListener: (Product) -> Unit
    ) : RecyclerView.Adapter<SuggestProductAdapter.ItemSuggestProduct>() {

    private val items = mutableListOf<Product>()

    fun setSuggestProduct(items: List<Product>){
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

    class ItemSuggestProduct(
        view: View,
//        private val userPref: UserPref,
        private  val onItemClickListener: (Product) -> Unit,
        private  val onBookmarkClickListener: (Product) -> Unit
    ) : RecyclerView.ViewHolder(view){
        @SuppressLint("SetTextI18n")
        fun bind(data: Product){
            val productModel = ProductModel(data)
            itemView.apply {

                ivProductImage.loadImageUrl(productModel.getImage().orEmpty())

                tvProductName.text = productModel.getName()

                tvProductPrice.text = productModel.getSalePrice()

                tvProductLocationProduct.text = productModel.getLocation(context)

                tvProductSoldProduct.setVisible(productModel.getTotalSold() > 0)
                if (productModel.getTotalSold() >= 0) {
                    tvProductSoldProduct.text = context.getString(R.string.sold_s, productModel.getTotalSold().formatToString())
                }

                tvLabelDiscountProduct.setVisible(productModel.isShowDiscountPercent())
                if (productModel.isShowDiscountPercent()) {
                    tvLabelDiscountProduct.text = "${productModel.getDiscountPercent()}%"
                }

                tvLabelNewProduct.visibility = View.GONE

                updateBookmarkState(productModel.getBookmarkedState())

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