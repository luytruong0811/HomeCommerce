package com.example.homecommerce.model

class NewestProductModel(val product: NewestProduct) {
        fun getBookmarkedState(): Boolean = product.isBookmarked
}