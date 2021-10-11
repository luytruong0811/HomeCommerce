package com.example.homecommerce.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    fun inflateView(parent: ViewGroup, @LayoutRes id: Int): View {
        return LayoutInflater.from(parent.context).inflate(id, parent, false)
    }

}