package com.example.homecommerce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homecommerce.R
import com.example.homecommerce.ext.getDefault
import com.example.homecommerce.ext.loadImageUrl
import com.example.homecommerce.model.HomePage
import kotlinx.android.synthetic.main.item_top_key.view.*

class TopKeyAdapter : RecyclerView.Adapter<TopKeyAdapter.ItemTopKeyVH>()  {

    private val items = mutableListOf<HomePage.TopKeywordHomePage>()

    fun setTopKey(items: List<HomePage.TopKeywordHomePage>){
        this.items.clear()
        this.items.addAll(items)
    }

    class ItemTopKeyVH(view : View) : RecyclerView.ViewHolder(view){
        fun bind(data: HomePage.TopKeywordHomePage){
            itemView.apply {
                ivTopKey.loadImageUrl(data.avatar.orEmpty())

                tvTopKey.text = data.keyword
                tvTotalProduct.text = context.getString(R.string.d_product, data.totalProduct.getDefault())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemTopKeyVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_top_key, parent, false)
        return ItemTopKeyVH(view)
    }

    override fun onBindViewHolder(holder: ItemTopKeyVH, position: Int) {
        items.let { holder.bind(it[position]) }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}