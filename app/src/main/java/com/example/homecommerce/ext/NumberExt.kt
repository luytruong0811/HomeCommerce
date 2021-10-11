package com.example.homecommerce.ext

import android.content.Context
import android.util.TypedValue
import androidx.annotation.Px

fun Float.toPx(context: Context): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        this,
        context.resources.displayMetrics
    ).toInt()
}

fun Boolean?.getDefault(): Boolean {
    return this ?: false
}

fun Float?.getDefault(): Float {
    return this ?: 0f
}

fun Int?.getDefault(): Int {
    return this ?: 0
}

fun Int.formatToString(): String {
    return if (this < 10000) {
        "$this"
    } else {
        val thousand = this / 1000
        val thousandFormat = "${thousand}k "
        val hundred = (thousand - thousand * 1000) / 100
        val hundredFormat = if (hundred > 0) "$hundred" else ""
        "${thousandFormat}${hundredFormat}"
    }
}