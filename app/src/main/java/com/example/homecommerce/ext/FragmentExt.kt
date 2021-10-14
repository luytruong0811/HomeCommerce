package com.example.homecommerce.ext

import android.os.Build
import android.view.View
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.fragment.app.Fragment

/**
 * Created by pvduc9773 on 2/19/21.
 */
fun Fragment.setStatusBarIconColor(isLight: Boolean) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val decor: View? = this.activity?.window?.decorView
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