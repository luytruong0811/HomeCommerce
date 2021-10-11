package com.example.homecommerce.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

class InterceptTouchRecyclerView(context: Context, attrs: AttributeSet?) : RecyclerView(context, attrs) {
    private var onInterceptTouch: OnInterceptTouch? = null

    fun setInterceptTouchListener(listener: OnInterceptTouch) {
        onInterceptTouch = listener
    }

    override fun onInterceptTouchEvent(e: MotionEvent?): Boolean {
        onInterceptTouch?.onInterceptTouch(e)
        return super.onInterceptTouchEvent(e)
    }

    interface OnInterceptTouch {
        fun onInterceptTouch(e: MotionEvent?)
    }
}