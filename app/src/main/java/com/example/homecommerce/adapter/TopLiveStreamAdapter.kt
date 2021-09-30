package com.example.homecommerce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homecommerce.R
import com.example.homecommerce.model.TopLivestream
import kotlinx.android.synthetic.main.item_bidu_live.view.*

class TopLiveStreamAdapter : RecyclerView.Adapter<TopLiveStreamAdapter.TopLiveStreamVH>() {
    private val items = mutableListOf<TopLivestream>()

    fun setTopLiveStream(items : List<TopLivestream>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }
    class TopLiveStreamVH(view: View) : RecyclerView.ViewHolder(view){
        fun bind(data : TopLivestream){
            itemView.apply{
                Glide.with(ivTopLive)
                    .load(data.image)
                    .error(R.mipmap.ic_launcher)
                    .into(ivTopLive)

                Glide.with(ivAvatar)
                    .load(data.user.avatar)
                    .error(R.mipmap.ic_launcher)
                    .into(ivAvatar)

                tvNameTopLive.text = data.user.userName
                tvDescription.text = data.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopLiveStreamVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bidu_live, parent, false)
        return TopLiveStreamVH(view)
    }

    override fun onBindViewHolder(holder: TopLiveStreamVH, position: Int) {
        items.let {holder.bind(it[position]) }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}