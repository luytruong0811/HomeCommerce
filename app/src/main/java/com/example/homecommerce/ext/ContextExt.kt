package com.example.homecommerce.ext

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.DisplayMetrics
import androidx.core.content.ContextCompat
import java.io.File

/**
 * Created by pvduc9773 on 2/19/21.
 */

/**
 * return pattern "[applicationId]/data/@params[folderName]/"
 */
fun Context.createInternalFolderIfNeeded(folderName: String): String {
    val path = "${this.cacheDir}/$folderName/"
    val folder = File(path)
    if (!folder.exists()) {
        folder.mkdir() //If there is no folder it will be created.
    }
    return folder.absolutePath
}

fun Context.hasPermission(permission: String): Boolean {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
    } else true
}

fun Context.hasPermissions(permissions: List<String>): Boolean {
    var hasAll = true
    permissions.forEach {
        if (!hasPermission(it)) {
            hasAll = false
        }
    }
    return hasAll
}

fun Context.getScreenSize(): DisplayMetrics {
    return this.resources.displayMetrics
}

fun Context?.getInt(resId: Int): Int {
    return this?.resources?.getInteger(resId) ?: 0
}