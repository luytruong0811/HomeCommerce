package com.example.homecommerce.systemcategory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.homecommerce.R
import com.example.homecommerce.ext.setStatusBarColor
import com.example.homecommerce.ext.setStatusBarIconColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SystemCategoryChildFragment : Fragment() {

    private val productBySystemCategoryViewModel : ProductBySystemCategoryViewModel by viewModels()
    private val systemCategoryViewModel : SystemCategoryViewModel by viewModels()

    private val categoryId: String? by lazy {
        arguments?.getString(ProductBySystemCategoryActivity.EXTRA_CATEGORY_ID)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setStatusBarIconColor(true)
        activity?.setStatusBarColor(R.color.backgroundColorWhite)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_system_category_child, container, false)
    }

    companion object {
        const val EXTRA_CATEGORY_ID = "extra-category-id"

        fun newInstance(categoryId: String): SystemCategoryChildFragment {
            return SystemCategoryChildFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_CATEGORY_ID, categoryId)
                }
            }
        }
    }
}