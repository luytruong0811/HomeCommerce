package com.example.homecommerce.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

/**
 * Created by hung.nguyendk on 9/30/20.
 */
abstract class BaseFragment : Fragment() {
    @LayoutRes
    abstract fun layoutId(): Int

    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun showToast(message: Int) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(layoutId(), container, false)
    }

    fun replaceFragment(
        containerId: Int = android.R.id.content,
        fragment: BaseFragment,
        tag: String? = null,
        addToBackStack: Boolean = false,
        option: ((transition: FragmentTransaction) -> FragmentTransaction)? = null
    ) {
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(containerId, fragment, tag)
        if (addToBackStack) {
            transaction.addToBackStack(BaseFragment::javaClass.toString())
        }
        if (option != null) {
            option(transaction)
        }
        transaction.commit()
    }

    fun replaceFragment(
        containerId: Int = android.R.id.content,
        fragment: Class<out BaseFragment>,
        arg: Bundle? = null,
        tag: String? = null,
        addToBackStack: Boolean = false,
        option: ((transition: FragmentTransaction) -> Any)? = null
    ) {
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(containerId, fragment, arg, tag)
        if (addToBackStack) {
            transaction.addToBackStack(BaseFragment::javaClass.toString())
        }
        if (option != null) {
            option(transaction)
        }
        transaction.commit()
    }

}