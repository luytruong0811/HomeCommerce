package com.example.homecommerce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homecommerce.R
import com.example.homecommerce.model.TopKeyword
import kotlinx.android.synthetic.main.item_top_key.view.*

class TopKeyAdapter : RecyclerView.Adapter<TopKeyAdapter.ItemTopKeyVH>()  {

    private val items = mutableListOf<TopKeyword>()

    fun setTopKey(items: List<TopKeyword>){
        this.items.clear()
        this.items.addAll(items)
    }

    class ItemTopKeyVH(view : View) : RecyclerView.ViewHolder(view){
        fun bind(data: TopKeyword){
            itemView.apply {
                Glide.with(ivTopKey)
                    .load(data.avatar)
                    .error(R.mipmap.ic_launcher)
                    .into(ivTopKey)

                tvTopKey.text = data.keyword
                tvTotalProduct.text = "${data.totalProduct} sản phẩm"
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