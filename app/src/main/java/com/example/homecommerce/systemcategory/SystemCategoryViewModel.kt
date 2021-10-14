package com.example.homecommerce.systemcategory

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class SystemCategoryViewModel @ViewModelInject constructor(

) : ViewModel(){
    private var tabSelectedId: String? = null

    fun onTabSelected(categoryId: String?) {
        tabSelectedId = categoryId
    }
}