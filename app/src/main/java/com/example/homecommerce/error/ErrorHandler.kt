package com.example.homecommerce.error

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object ErrorHandler {
    fun <T : BaseError> getError(
        throwable: Throwable,
        clazz: Class<T>,
        errorUtils: ErrorUtils
    ): T {
        when (throwable) {
            is UnknownHostException -> return BaseError.create(clazz, ErrorType.UNKNOWN.apply {
                Timber.e("??? UnknownHostException: throwable=$throwable")
                errorMessage = errorUtils.getErrorServerMessage()
            })
            is SocketTimeoutException -> return BaseError.create(clazz, ErrorType.NETWORK.apply {
                Timber.e("??? SocketTimeoutException: throwable=$throwable")
                errorMessage = errorUtils.getErrorServerMessage()
            })
            is ConnectException -> return BaseError.create(clazz, ErrorType.NETWORK.apply {
                Timber.e("??? ConnectException: throwable=$throwable")
                errorMessage = errorUtils.getErrorServerMessage()
            })
            is IOException -> return BaseError.create(clazz, ErrorType.NETWORK.apply {
                Timber.e("??? IOException: throwable=$throwable")
                errorMessage = errorUtils.getErrorIOExceptionMessage()
            })
            is JsonSyntaxException -> return BaseError.create(clazz, ErrorType.DATA.apply {
                Timber.e("??? JsonSyntaxException: throwable=$throwable")
                errorMessage = errorUtils.getErrorJsonSyntaxExceptionMessage()
            })
            is HttpException -> {
                val httpCode: Int = throwable.code()
                val errorBody: String? = throwable.response()?.errorBody()?.string()
                Timber.e("??? UnknownHostException: httpCode=$httpCode, errorBody=$errorBody")

                return try {
                    Gson().fromJson(errorBody, clazz).apply {
                        errorInfo = BaseError.ErrorInfo(provideErrorCode(), errorUtils.getErrorCodeMessage(provideErrorCode()))
                    }
                } catch (e: Exception) {
                    Timber.e(e)
                    if (httpCode == BaseError.ERROR_HTTP_AUTHORIZED_CODE) {
                        BaseError.create(clazz, ErrorType.HTTP.apply {
                            errorMessage = errorUtils.getErrorAuthorizedMessage()
                        })
                    } else {
                        BaseError.create(clazz, ErrorType.HTTP).apply {
                            errorInfo = BaseError.ErrorInfo(httpCode, errorUtils.getErrorServerMessage())
                        }
                    }
                }
            }
            else -> return BaseError.create(clazz, ErrorType.UNKNOWN)
        }
    }
}