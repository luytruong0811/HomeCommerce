package com.example.homecommerce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homecommerce.R
import com.example.homecommerce.ext.setOnDelayClickListener
import com.example.homecommerce.model.TopShop
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_top_seller.view.*

class TopSellerAdapter : RecyclerView.Adapter<TopSellerAdapter.ItemSellerVH>() {

    private val items = mutableListOf<TopShop>()
    var isExpanded = false
    fun setTopSeller(items: List<TopShop>){
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    companion object {
        private const val LIMIT = 3
    }

    fun setExpandState(isExpand: Boolean) {
        isExpanded = isExpand
        notifyItemRangeChanged(LIMIT , items.size )
    }


    class ItemSellerVH(
        view : View,
    ): RecyclerView.ViewHolder(view){
        fun bind(data : TopShop, position: Int){
            itemView.apply {
                tvCountTopSeller.text = "${position+1}"
                Glide.with(circleAvatarSeller)
                    .load(data.shop.user.avatar)
                    .error(R.mipmap.ic_launcher)
                    .into(circleAvatarSeller)
                when(position) {
                    0 -> ivTopSeller.setImageResource(R.drawable.ic_diamond)
                    1 -> ivTopSeller.setImageResource(R.drawable.ic_king)
                    else -> ivTopSeller.setImageResource(R.drawable.ic_queen)
                }
                tvNameSeller.text = data.shop.user.nameOrganizer.userName
                tvCountFavorite.text = "${data.shop.feedback.averageFeedbackRate}"
                tvCountFollow.text = context.getString(R.string.s_follow_count, data.shop.user.followCount.toString())
            }
        }
    }
    

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemSellerVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_top_seller, parent, false)
        return ItemSellerVH(view)
    }

    override fun onBindViewHolder(holder: ItemSellerVH, position: Int) {
        items.let { holder.bind(items[position], position) }
    }

    override fun getItemCount(): Int {
        return when {
            isExpanded -> items.size
            items.size > LIMIT -> LIMIT
            else -> items.size
        }
    }

}

