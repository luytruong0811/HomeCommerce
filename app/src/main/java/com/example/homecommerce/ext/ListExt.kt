package com.example.homecommerce.ext

fun List<String>?.toStringValue(): String {
    val values = StringBuilder()
    this?.forEachIndexed { index, s ->
        values.append(s)
        if (index != this.lastIndex) {
            values.append(", ")
        }
    }
    return values.toString()
}