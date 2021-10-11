package com.example.homecommerce.ext

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun Context.inflateView(res: Int, root: ViewGroup? = null): View {
    return LayoutInflater.from(this).inflate(res, root)
}