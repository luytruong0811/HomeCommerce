package com.example.homecommerce.widgets

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.example.homecommerce.R

/**
 * Created by pvduc9773 on 2/21/21.
 */
class LoadingDialog(context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_loading)
        window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}