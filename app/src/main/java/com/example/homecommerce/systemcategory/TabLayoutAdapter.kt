package com.example.homecommerce.systemcategory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.homecommerce.model.Category

class TabLayoutAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    val items = mutableListOf<Category>()

    override fun getItemCount(): Int {
        return items.size
    }

    fun getCurrentItem(position: Int): Category? {
        return if (position in 0..items.lastIndex) {
            items[position]
        } else {
            null
        }
    }

    fun updateAdapter(categories: List<Category>) {
        items.addAll(categories)
        notifyDataSetChanged()
    }

    override fun createFragment(position: Int): Fragment {
        return SystemCategoryChildFragment()
    }

}