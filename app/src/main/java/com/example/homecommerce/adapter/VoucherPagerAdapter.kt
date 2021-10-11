package com.example.homecommerce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.homecommerce.R

class VoucherPagerAdapter : PagerAdapter() {
    private val items = mutableListOf<String>()
    fun setVoucher(items: List<String>){
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context).inflate(R.layout.item_voucher, container, false)

        val ivVoucher : ImageView = view.findViewById(R.id.ivVoucher)

        val data = items[position]
            Glide.with(ivVoucher)
                .load(data)
                .error(R.mipmap.ic_launcher)
                .into(ivVoucher)

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}