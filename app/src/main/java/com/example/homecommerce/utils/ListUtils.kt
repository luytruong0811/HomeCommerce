package com.example.homecommerce.utils

/**
 * Created by pvduc9773 on 05/07/2021.
 */

fun getContainsListString(list1: List<String>, list2: List<String>): Boolean {
    return list1.containsAll(list2) && list2.containsAll(list1)
}