package com.example.homecommerce.model

class HomeCategory(
    val categories: List<Category>? = null,
    val products: CategoryProducts? = null,
    val topProduct: CategoryProducts? = null
) {
    class CategoryProducts(
        val data: List<Product>? = null
    )
}