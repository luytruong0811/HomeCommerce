package com.example.homecommerce.error

class AppError : BaseError() {
    private var code: Int? = null
    private var message: String? = null

    override fun provideErrorCode(): Int {
        return code ?: -1
    }

    override fun provideErrorMessage(): String {
        return message ?: errorInfo?.errorMessage.orEmpty()
    }
}