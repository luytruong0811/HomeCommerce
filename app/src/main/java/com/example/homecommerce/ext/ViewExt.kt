package com.example.homecommerce.ext

import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.homecommerce.R

fun View.setOnDelayClickListener(method: () -> Unit) {
    this.setOnClickListener {
        this.isEnabled = false
        method.invoke()
        this.postDelayed({
            this.isEnabled = true
        }, 600)
    }
}

fun ImageView.loadImageUrl(link: String) {
    Glide.with(this)
        .load(link)
        .error(R.drawable.ic_bell)
        .placeholder(R.drawable.ic_bell)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}

fun View.setVisible(visible: Boolean) {
    if (visible) this.show()
    else this.hide()
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun ImageView.imageDrawable(drawable: Int) {
    setImageDrawable(ContextCompat.getDrawable(context, drawable))
}
