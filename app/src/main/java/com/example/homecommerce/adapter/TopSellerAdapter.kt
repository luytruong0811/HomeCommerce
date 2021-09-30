package com.example.homecommerce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homecommerce.R
import com.example.homecommerce.model.TopShop
import kotlinx.android.synthetic.main.item_top_seller.view.*

class TopSellerAdapter : RecyclerView.Adapter<TopSellerAdapter.ItemSellerVH>() {

    private val items = mutableListOf<TopShop>()
    fun getTopSeller(items: List<TopShop>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }
    class ItemSellerVH(view : View ): RecyclerView.ViewHolder(view){
        fun bind(data : TopShop, count :Int){
            itemView.apply {
                tvCountTopSeller.text = "${count}"
                Glide.with(circleAvatarSeller)
                    .load(data.shop.user.avatar)
                    .error(R.mipmap.ic_launcher)
                    .into(circleAvatarSeller)
                if (count == 1){
                    ivTopSeller.setImageResource(R.drawable.ic_diamond)
                }else if(count == 2){
                    ivTopSeller.setImageResource(R.drawable.ic_king)
                }else{
                    ivTopSeller.setImageResource(R.drawable.ic_queen)
                }
                tvNameSeller.text = data.shop.user.nameOrganizer.userName
                tvCountFavorite.text = "${data.shop.feedback.averageFeedbackRate}"
                tvCountFollow.text = "${data.shop.user.followCount} lượt theo dõi"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemSellerVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_top_seller, parent, false)
        return ItemSellerVH(view)
    }

    override fun onBindViewHolder(holder: ItemSellerVH, position: Int) {
        items.let { holder.bind(items[position], position + 1) }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

