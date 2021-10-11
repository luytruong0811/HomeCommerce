package com.example.homecommerce.model

class SuggestProductModel (val suggestProduct: SuggestProduct) {
    fun getBookmarkedState(): Boolean = suggestProduct.isBookmarked
}