package com.example.homecommerce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.homecommerce.R
import com.example.homecommerce.base.BaseAdapter
import com.example.homecommerce.ext.loadImageUrl
import com.example.homecommerce.ext.setOnDelayClickListener
import com.example.homecommerce.model.SystemCategory
import kotlinx.android.synthetic.main.item_category.view.*

class ItemCategoryAdapter(
    private val onItemClickListener: (SystemCategory) -> Unit
) : BaseAdapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<SystemCategory>()
    var isExpanded = false

    companion object {
        private const val LIMIT = 10
        private const val TYPE_NORMAL = 0
        private const val TYPE_VIEW_MORE = 1
    }

    fun setItemCategory(items: List<SystemCategory>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun setExpandState(isExpand: Boolean) {
        isExpanded = isExpand
        notifyItemRangeChanged(LIMIT - 1, items.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_NORMAL -> {
                ItemCategoryVH(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_category, parent, false),
                    onItemClickListener
                )
            }
            else -> {
                ViewMoreCategoryVH(
                    view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false),
                    onViewMoreClickListener = { setExpandState(true) }
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemCategoryVH -> {
                holder.bind(items[position])
            }
            is ViewMoreCategoryVH -> {
                holder.bind()
            }
        }
    }

    override fun getItemCount(): Int {
        return when {
            isExpanded -> items.size
            items.size > LIMIT -> LIMIT
            else -> items.size
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            isExpanded -> TYPE_NORMAL
            (position == LIMIT - 1) && items.size != LIMIT -> TYPE_VIEW_MORE
            else -> TYPE_NORMAL
        }
    }

    class ViewMoreCategoryVH(
        view: View,
        private val onViewMoreClickListener: () -> Unit
    ) : RecyclerView.ViewHolder(view) {
        fun bind() {
            with(itemView) {
                ivCategory.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.ic_view_more_category
                    )
                )
                tvNameCategory.text = context.getString(R.string.view_more)

                setOnDelayClickListener {
                    onViewMoreClickListener.invoke()
                }
            }
        }
    }

    class ItemCategoryVH(
        view: View,
        private val onItemClickListener: (SystemCategory) -> Unit
    ) : RecyclerView.ViewHolder(view) {
        fun bind(systemCategory: SystemCategory) {
            itemView.apply {
                ivCategory.loadImageUrl(systemCategory.avatar.orEmpty())
                tvNameCategory.text = systemCategory.name.orEmpty()

                setOnDelayClickListener {
                    onItemClickListener.invoke(systemCategory)
                }
            }
        }
    }
}