package com.example.homecommerce.model

class TopProductModel(val product: TopProduct) {
    fun getBookmarkedState(): Boolean = product.isBookmarked
}