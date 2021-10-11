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
import com.example.homecommerce.model.NewestProduct
import com.example.homecommerce.model.NewestProductModel
import com.example.homecommerce.model.TopProduct
import kotlinx.android.synthetic.main.item_home_page_top_product.view.*
import kotlinx.android.synthetic.main.item_new_product.view.*
import kotlinx.android.synthetic.main.item_product.view.*
import kotlinx.android.synthetic.main.item_product.view.ivProductImage
import kotlinx.android.synthetic.main.item_product.view.tvLabelDiscount
import kotlinx.android.synthetic.main.item_product.view.tvLabelNew
import kotlinx.android.synthetic.main.item_product.view.tvProductLocation
import kotlinx.android.synthetic.main.item_product.view.tvProductName
import kotlinx.android.synthetic.main.item_product.view.tvProductPrice
import kotlinx.android.synthetic.main.item_product.view.tvProductSold
import java.text.DecimalFormat

class NewProductAdapter(
    private val onItemClickListener: (NewestProduct) -> Unit,
    private val onBookmarkClickListener: (NewestProduct) -> Unit
) : RecyclerView.Adapter<NewProductAdapter.ItemNewProductVH>(){

    private val items = mutableListOf<NewestProduct>()

    fun setNewProduct(items: List<NewestProduct>){
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun findPositionAndUpdateItem(product: NewestProduct): Int {
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
        private val onItemClickListener: (NewestProduct) -> Unit,
        private val onBookmarkClickListener: (NewestProduct) -> Unit
    ) : RecyclerView.ViewHolder(view){
        @SuppressLint("SetTextI18n")
        fun bind(data : NewestProduct){
            val productModel = NewestProductModel(data)
            itemView.apply {
                Glide.with(ivProductImage)
                    .load(data.images.firstOrNull())
                    .error(R.mipmap.ic_launcher)
                    .into(ivProductImage)
                tvProductName.text = data.name
                val decimalFormat =  DecimalFormat("###,###,###")
                tvProductPrice.text = decimalFormat.format(data.beforeSalePrice).plus(" ₫")
                if (data.shop.country == "KO"){
                    tvProductLocation.text = "Hàn Quốc"
                }else if(data.shop.country == "VN"){
                    tvProductLocation.text = "Việt Nam"
                }else{
                    tvProductLocation.text = "Mỹ"
                }
                tvProductSold.text = "Đã bán "+ data.sold.toString()
                if(data.discount_percent==0) {
                    tvLabelDiscount.visibility = View.GONE
                } else {
                    tvLabelDiscount.text = data.discount_percent.toString()+"%"
                }
                tvLabelNew.visibility = View.GONE

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