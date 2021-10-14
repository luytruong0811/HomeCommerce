package com.example.homecommerce.error

enum class ErrorType constructor(val errorCode: Int, var errorMessage: String) {
    NETWORK(101, "Network error"),
    DATA(102, "Data error"),
    HTTP(103, "HTTP error"),
    UNKNOWN(BaseError.ERROR_UNKNOWN_CODE, BaseError.ERROR_UNKNOWN_MESSAGE);

    companion object {
        const val HTTP_ERROR_START = 400
        const val HTTP_ERROR_END = 599
    }
}
