package com.example.homecommerce.adapter

import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homecommerce.R
import com.example.homecommerce.ext.formatToString
import com.example.homecommerce.ext.getDefault
import com.example.homecommerce.ext.loadImageUrl
import com.example.homecommerce.model.HomePage
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_top_seller.view.*

class TopSellerAdapter : RecyclerView.Adapter<TopSellerAdapter.ItemSellerVH>() {

    private val items = mutableListOf<HomePage.TopShopHomePage>()
    var isExpanded = false
    fun setTopSeller(items: List<HomePage.TopShopHomePage>){
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
        fun bind(data : HomePage.TopShopHomePage, position: Int){
            itemView.apply {
                tvCountTopSeller.text = "${position+1}"

                circleAvatarSeller.loadImageUrl(data.getUserAvatar().orEmpty())
                when(position) {
                    0 -> ivTopSeller.setImageResource(R.drawable.ic_diamond)
                    1 -> ivTopSeller.setImageResource(R.drawable.ic_king)
                    else -> ivTopSeller.setImageResource(R.drawable.ic_queen)
                }

                tvNameSeller.text = data.getUserName()

                tvCountFavorite.text = data.shop?.feedback?.averageFeedbackRate.getDefault().toString()

                val followCount = data.getFollowCount()
                tvCountFollow.text = context.getString(R.string.s_follow, followCount.formatToString())
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

