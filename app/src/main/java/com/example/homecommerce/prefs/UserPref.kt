package com.example.homecommerce.prefs

import android.content.Context
import com.example.homecommerce.model.user.User
import javax.inject.Inject

class UserPref(context: Context) : BasePref(context, "user-pref") {
    companion object {
        private const val KEY_TOKEN = "key-token"
        private const val KEY_USER_INFO = "key-user-info"
        private const val KEY_SHOW_MEASURE_INFO = "key-show-measure-info"
    }

    fun getToken(): String? = getString(KEY_TOKEN, null)

    fun saveToken(token: String) = putData(KEY_TOKEN, token)

    fun getUserInfo(): User? {
        val userJson = getString(KEY_USER_INFO, null)
        return if (userJson.isNullOrEmpty()) {
            null
        } else {
            User.fromJson(userJson)
        }
    }

    fun saveUserInfo(user: User) {
        putData(KEY_USER_INFO, user.toJson())
    }

    fun isShowMeasureInfo(): Boolean = getBoolean(KEY_SHOW_MEASURE_INFO, true)

    fun updateShowMeasureInfo(value: Boolean) {
        putData(KEY_SHOW_MEASURE_INFO, value)
    }
}

fun UserPref.getAccessToken(): String = getToken().orEmpty()

fun UserPref.isLogged(): Boolean = getAccessToken().isNotEmpty()