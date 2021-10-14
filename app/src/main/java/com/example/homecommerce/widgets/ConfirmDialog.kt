package com.example.homecommerce.widgets

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.TextView
import com.example.homecommerce.R
import com.example.homecommerce.ext.setOnDelayClickListener
import com.example.homecommerce.ext.setVisible
import com.example.homecommerce.utils.applyGradientColorPink
import kotlinx.android.synthetic.main.dialog_confirm.*

/**
 * Created by pvduc9773 on 2/19/21.
 */
class ConfirmDialog(
    context: Context,
    private val title: String? = null,
    private val content: String,
    private val cancelable: Boolean? = true,
    private val submitText: String,
    private val cancelText: String,
    private val onSubmitCallback: () -> Unit?,
    private val onCancelCallback: () -> Unit?
) : Dialog(context, R.style.DialogStyle) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.dialog_confirm)
        setCancelable(cancelable ?: true)

        tvTitle.setVisible(!title.isNullOrEmpty())
        if (!title.isNullOrEmpty()) {
            tvTitle.text = title
        }

        tvContent.text = content
        tvSubmit.text = submitText
        tvCancel.text = cancelText

        tvSubmit.applyGradientColorPink()

        ivClose.setOnDelayClickListener {
            onCancelCallback.invoke()
            dismiss()
        }

        tvCancel.setOnDelayClickListener {
            onCancelCallback.invoke()
            dismiss()
        }

        tvSubmit.setOnDelayClickListener {
            onSubmitCallback.invoke()
            dismiss()
        }
    }
}