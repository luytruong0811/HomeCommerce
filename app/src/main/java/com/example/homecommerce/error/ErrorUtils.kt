package com.example.homecommerce.error

import android.content.Context
import com.example.homecommerce.R
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.IOException
import javax.inject.Inject

class ErrorUtils @Inject constructor(
    @ApplicationContext val context: Context
) {
    fun getErrorCodeMessage(provideErrorCode: Int): String? {
        return context.getString(R.string.error_code, provideErrorCode)
    }

    fun getErrorServerMessage(): String {
        return context.getString(R.string.error_server)
    }

    fun getErrorAuthorizedMessage(): String {
        return context.getString(R.string.error_authorization)
    }

    fun getErrorNetWorkMessage(): String {
        return context.getString(R.string.error_network)
    }

    fun getErrorIOExceptionMessage(): String {
        return context.getString(R.string.error_data_io)
    }

    fun getErrorJsonSyntaxExceptionMessage(): String {
        return context.getString(R.string.error_data)
    }
}