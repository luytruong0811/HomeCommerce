package com.example.homecommerce.ext

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

/**
 * Created by pvduc9773 on 2/19/21.
 */
fun Activity.setStatusBarColor(colorId: Int) {
    window?.statusBarColor = ContextCompat.getColor(this, colorId)
}

@Suppress("DEPRECATION")
fun Activity.setStatusBarIconColor(isLight: Boolean) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val decor: View? = this.window?.decorView
        decor?.let { view ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                view.windowInsetsController?.setSystemBarsAppearance(
                    WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS,
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                )
            } else {
                if (isLight) {
                    view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
                } else {
                    view.setSystemUiVisibility(0)
                }
            }
        }

    }
}

fun AppCompatActivity.smoothReplaceFragment(
    containerId: Int,
    fragment: Class<out Fragment>,
    arg: Bundle? = null,
    tag: String? = null,
    addToBackStack: Boolean = false
) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(containerId, fragment, arg, tag)
    if (addToBackStack) {
        transaction.addToBackStack(this.localClassName)
    }
    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
    transaction.commit()
}

fun AppCompatActivity.smoothAddFragment(
    containerId: Int,
    fragment: Class<out Fragment>,
    arg: Bundle? = null,
    tag: String? = null,
    addToBackStack: Boolean = false
) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.add(containerId, fragment, arg, tag)
    if (addToBackStack) {
        transaction.addToBackStack(this.localClassName)
    }
    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
    transaction.commit()
}