package com.example.homecommerce.base

/**
 * Created by pvduc9773 on 2/20/21.
 */
class BaseResponse<T> {
    var success: Boolean = false
    var message: String? = null
    var data: T? = null
}