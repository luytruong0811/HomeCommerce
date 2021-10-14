package com.example.homecommerce.prefs

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by hung.nguyendk on 10/6/20.
 */
abstract class BasePref(context: Context, val name: String) {
    private val pref: SharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)
    private val editor = pref.edit()

    fun getString(key: String, default: String?): String? {
        return pref.getString(key, default) ?: default
    }

    fun getInt(key: String, default: Int): Int {
        return pref.getInt(key, default)
    }

    fun getBoolean(key: String, default: Boolean): Boolean {
        return pref.getBoolean(key, default)
    }

    fun getFloat(key: String, default: Float): Float {
        return pref.getFloat(key, default)
    }

    fun getLong(key: String, default: Long): Long {
        return pref.getLong(key, default)
    }

    fun clear() {
        editor.clear().apply()
    }

    fun <T> putData(key: String, value: T) {
        when (value) {
            is String -> {
                editor.putString(key, value).apply()
            }
            is Int -> {
                editor.putInt(key, value).apply()
            }
            is Float -> {
                editor.putFloat(key, value).apply()
            }
            is Boolean -> {
                editor.putBoolean(key, value).apply()
            }
            is Long -> {
                editor.putLong(key, value).apply()
            }
            else -> {
                throw UnsupportedOperationException("not support this type")
            }
        }
    }
}