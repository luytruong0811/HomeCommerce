package com.example.homecommerce.utils

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.widget.TextView

/**
 * Created by pvduc9773 on 4/17/21.
 */
fun TextView.applyGradientColorPink() {
    val paint = this.paint
    val width = paint.measureText(this.text.toString())
    val textShader: Shader = LinearGradient(
        0f,
        0f,
        width,
        this.textSize,
        intArrayOf(
            Color.parseColor("#FD37AE"),
            Color.parseColor("#FD374F")
        ),
        null,
        Shader.TileMode.CLAMP
    )

    this.paint.shader = textShader
}

fun TextView.applyGradientColorPinkV2() {
    val paint = this.paint
    val width = paint.measureText(this.text.toString())
    val textShader: Shader = LinearGradient(
        0f,
        0f,
        width,
        this.textSize,
        intArrayOf(
            Color.parseColor("#FF7C79"),
            Color.parseColor("#E812A4")
        ),
        null,
        Shader.TileMode.CLAMP
    )

    this.paint.shader = textShader
}


fun TextView.applyGradientColorPinkCommunity() {
    val paint = this.paint
    val width = paint.measureText(this.text.toString())
    val textShader: Shader = LinearGradient(
        0f,
        0f,
        width,
        this.textSize,
        intArrayOf(
            Color.parseColor("#FB8E8C"),
            Color.parseColor("#E812A4")
        ),
        null,
        Shader.TileMode.CLAMP
    )

    this.paint.shader = textShader
}

fun TextView.applyColorGraySilver() {
    val paint = this.paint
    val width = paint.measureText(this.text.toString())
    val textShader: Shader = LinearGradient(
        0f,
        0f,
        width,
        this.textSize,
        intArrayOf(
            Color.parseColor("#C9C9C9"),
            Color.parseColor("#C9C9C9")
        ),
        null,
        Shader.TileMode.CLAMP
    )

    this.paint.shader = textShader
}

fun TextView.applyColorWhite() {
    val paint = this.paint
    val width = paint.measureText(this.text.toString())
    val textShader: Shader = LinearGradient(
        0f,
        0f,
        width,
        this.textSize,
        intArrayOf(
            Color.parseColor("#FFFFFF"),
            Color.parseColor("#FFFFFF")
        ),
        null,
        Shader.TileMode.CLAMP
    )

    this.paint.shader = textShader
}