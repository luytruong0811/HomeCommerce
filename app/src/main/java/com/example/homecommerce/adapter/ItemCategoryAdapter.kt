package com.example.homecommerce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homecommerce.R
import com.example.homecommerce.model.SystemCategory

class ItemCategoryAdapter : RecyclerView.Adapter<ItemCategoryAdapter.ItemCategoryVH>() {

    private val items = mutableListOf<SystemCategory>()

    fun getItemCategory(items: List<SystemCategory>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    class ItemCategoryVH(view: View) : RecyclerView.ViewHolder(view){
        private lateinit var ivCategory : ImageView
        private lateinit var tvName : TextView
        fun bind(data: SystemCategory){
                ivCategory = itemView.findViewById(R.id.ivCategory)
                tvName = itemView.findViewById(R.id.tvNameCategory)

                Glide.with(ivCategory)
                    .load(data.pdfAvatar)
                    .error(R.mipmap.ic_launcher)
                    .into(ivCategory)

                tvName.text = data.name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCategoryVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ItemCategoryVH(view)
    }

    override fun onBindViewHolder(holder: ItemCategoryVH, position: Int) {
        items.let { holder.bind(it[position]) }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}