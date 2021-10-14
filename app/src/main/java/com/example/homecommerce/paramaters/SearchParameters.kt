package com.example.homecommerce.paramaters

/**
 * Created by pvduc9773 on 3/20/21.
 */
data class SearchParameters(
    var keyword: String?,
    var orderBy: String?,
    var priceMin: Long?,
    var priceMax: Long?,
    var stringRate: String?,
    var stringLocations: List<String>?
)