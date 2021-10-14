package com.example.homecommerce.utils

import java.text.NumberFormat
import java.util.*

/**
 * Created by vanthien113 on 2/27/21.
 */
object PriceUtils {
    // #.### ₫
    fun convertLongToPrice(price: Long): String {
        val formatter = NumberFormat.getNumberInstance(Locale.US)
        return "${formatter.format(price).replace(",", ".")} ₫"
    }

    // ₫ #.###
    fun convertLongToPriceEditText(price: Long): String {
        val formatter = NumberFormat.getNumberInstance(Locale.US)
        return "₫ ${formatter.format(price).replace(",", ".")}"
    }

    fun convertPriceToLong(price: String): Long {
        return kotlin.runCatching {
            price.replace("[₫]".toRegex(), "")
                .replace("[,]".toRegex(), "")
                .replace("[.]".toRegex(), "")
                .replace("[-]".toRegex(), "")
                .replace("[ ]".toRegex(), "")
                .toLongOrNull() ?: 0
        }.getOrElse { 0 }
    }

    fun addVNPriceChar(price: String): String {
        return "₫${price}"
    }

    private val magnitudes = charArrayOf('k', 'M', 'G', 'T', 'P', 'E') // enough for long

    fun convertToKPrice(number: Long): String {
        var number = number
        val ret: String
        if (number >= 0) {
            ret = ""
        } else if (number <= -9200000000000000000L) {
            return "-9E"
        } else {
            ret = "-"
            number = -number
        }
        if (number < 1000) return ret + number
        var i = 0
        while (true) {
            // if (number < 10000 && number % 1000 >= 100) return ret + number / 1000 + ',' + number % 1000 / 100 + magnitudes[i]
            if (number < 10000 && number % 1000 >= 100) return ret + number / 1000
            number /= 1000
            if (number < 1000) return ret + number + magnitudes[i]
            i++
        }
    }

    fun convertToKPrice(number: Long, result: (String, String) -> Unit) {
        var number = number
        val ret: String
        if (number >= 0) {
            ret = ""
        } else if (number <= -9200000000000000000L) {
            return result.invoke("-9.2E", "")
        } else {
            ret = "-"
            number = -number
        }
        if (number < 1000) return result.invoke(ret + number, "")
        var i = 0
        while (true) {
            // if (number < 10000 && number % 1000 >= 100) return result.invoke(ret + number / 1000 + ',' + number % 1000 / 100, magnitudes[i].toString())
            if (number < 10000 && number % 1000 >= 100) return result.invoke(ret + number / 1000, magnitudes[i].toString())
            number /= 1000
            if (number < 1000) return result.invoke(ret + number, magnitudes[i].toString())
            i++
        }
    }

    fun convertToKPriceString(number: Long): String {
        var number = number
        val ret: String
        if (number >= 0) {
            ret = ""
        } else if (number <= -9200000000000000000L) {
            return "-9.2E"
        } else {
            ret = "-"
            number = -number
        }
        if (number < 1000) return "$ret$number₫"
        var i = 0
        while (true) {
            if (number < 10000 && number % 1000 >= 100) return "$ret${number / 1000}${magnitudes[i]}"
            number /= 1000
            if (number < 1000) return "$ret$number${magnitudes[i]}"
            i++
        }
    }
}