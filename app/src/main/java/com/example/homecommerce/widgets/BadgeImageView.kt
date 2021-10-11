package com.example.homecommerce.widgets

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.example.homecommerce.ext.toPx

class BadgeImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private val radius: Int = 6f.toPx(context)
    var maxCount = 99

    var isShow = false
        set(value) {
            field = value
            invalidate()
        }
    var count: Int = 0
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (isShow) {
            val x = width.toFloat() - radius - 5
            val y = 0f + radius + 5
            drawCircle(canvas, x, y)
            drawText(canvas, x, y + radius / 2)
        }
    }

    private fun drawCircle(canvas: Canvas, x: Float, y: Float) {
        val paint = Paint()
        paint.color = Color.RED
        canvas.drawCircle(x, y, radius.toFloat(), paint)
    }

    private fun drawText(canvas: Canvas, x: Float, y: Float) {
        val paint = Paint()
        paint.color = Color.WHITE
        paint.textSize = 8f.toPx(context).toFloat()
        paint.isAntiAlias = true
        paint.textAlign = Paint.Align.CENTER
        val text = if (count > maxCount) {
            "$maxCount+"
        } else {
            "$count"
        }
        canvas.drawText(text, x, y, paint)
    }

}