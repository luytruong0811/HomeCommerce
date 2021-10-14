package com.example.homecommerce.base

abstract class BaseRepository {
    fun bearer(token: String) = "Bidu $token"
}