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
import kotlinx.android.synthetic.main.item_home_page_top_product.view.*
import kotlinx.android.synthetic.main.item_new_product.view.*
import kotlinx.android.synthetic.main.item_product.view.*
import kotlinx.android.synthetic.main.item_product.view.ivProductImage
import kotlinx.android.synthetic.main.item_product.view.tvProductName
import kotlinx.android.synthetic.main.item_product.view.tvProductPrice
import java.text.DecimalFormat

class NewProductAdapter(
//    private val userPref: UserPref,
    private val onItemClickListener: (Product) -> Unit,
    private val onBookmarkClickListener: (Product) -> Unit
) : RecyclerView.Adapter<NewProductAdapter.ItemNewProductVH>(){

    private val items = mutableListOf<Product>()

    fun setNewProduct(items: List<Product>){
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

    fun findPositionAndUpdateBookmarked(productId: String, isBookmarked: Boolean): Int {
        var position = -1
        items.forEachIndexed { i, p ->
            if (p.id == productId) {
                p.isBookmarked = isBookmarked
                position = i
                return@forEachIndexed
            }
        }
        return position
    }

    class ItemNewProductVH(
        view : View,
//        private val userPref: UserPref,
        private val onItemClickListener: (Product) -> Unit,
        private val onBookmarkClickListener: (Product) -> Unit
    ) : RecyclerView.ViewHolder(view){
        @SuppressLint("SetTextI18n")
        fun bind(data : Product){
            val productModel = ProductModel(data)
            itemView.apply {
                ivProductImage.loadImageUrl(productModel.getImage().orEmpty())

                tvProductName.text = productModel.getName()

                tvProductPrice.text = productModel.getSalePrice()

                tvProductLocationProduct.setVisible(!productModel.getLocation(context).isNullOrEmpty())
                if (!productModel.getLocation(context).isNullOrEmpty()) {
                    tvProductLocationProduct.text = productModel.getLocation(context)
                }

                tvProductSoldProduct.setVisible(productModel.getTotalSold() > 0)
                if (productModel.getTotalSold() >= 0) {
                    tvProductSoldProduct.text = context.getString(R.string.sold_s, productModel.getTotalSold().formatToString())
                }

                tvLabelDiscountProduct.setVisible(productModel.isShowDiscountPercent())
                if (productModel.isShowDiscountPercent()) {
                    tvLabelDiscountProduct.text = "${productModel.getDiscountPercent()}%"
                }
                tvLabelNewProduct.visibility = View.GONE

//                ivBookmarkProduct.setVisible(userPref.getUserInfo()?.shop?.id != data.shopId)

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemNewProductVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        view.layoutParams = ViewGroup.LayoutParams(114f.toPx(parent.context), ViewGroup.LayoutParams.MATCH_PARENT)
        view.setPadding(10f.toPx(parent.context), 0f.toPx(parent.context), 0f.toPx(parent.context), 0f.toPx(parent.context))
        return ItemNewProductVH(view, onItemClickListener, onBookmarkClickListener)
    }

    override fun onBindViewHolder(holder: ItemNewProductVH, position: Int) {
        items.let { holder.bind(it[position]) }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}