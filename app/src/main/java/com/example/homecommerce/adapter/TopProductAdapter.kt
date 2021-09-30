package com.example.homecommerce.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homecommerce.R
import com.example.homecommerce.model.TopProduct
import kotlinx.android.synthetic.main.item_top_product.view.*
import java.text.DecimalFormat

class TopProductAdapter : RecyclerView.Adapter<TopProductAdapter.ItemProductVH>(){

    private val items = mutableListOf<TopProduct>()

    fun setTopProduct(items: List<TopProduct>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    class ItemProductVH(view : View) : RecyclerView.ViewHolder(view){
        @SuppressLint("SetTextI18n")
        fun bind(data : TopProduct, count : Int){
            itemView.apply {

                tvTopProductCount.text = "$count"
                Glide.with(ivTopProduct)
                    .load(data.images.firstOrNull())
                    .error(R.mipmap.ic_launcher)
                    .into(ivTopProduct)
                Log.d("TAG", "image1 = ${data.images}")

                tvNameProduct.text = data.name
                val decimalFormat =  DecimalFormat("###,###,###")
                tvPriceProduct.text = decimalFormat.format(data.priceMinMax.max).plus(" ₫")

                tvSold.text = "Đã bán: ${data.sold}"

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemProductVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_top_product, parent, false)
//        view.context.resources.displayMetrics.widthPixels * 30 / 100 : Fix with and height
//        view.layoutParams.width
        return ItemProductVH(view)
    }

    override fun onBindViewHolder(holder: ItemProductVH, position: Int) {
        items.let { holder.bind(it[position], position + 1) }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}