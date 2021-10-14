package com.example.homecommerce.systemcategory

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homecommerce.error.AppError
import com.example.homecommerce.error.ErrorHandler
import com.example.homecommerce.error.ErrorUtils
import com.example.homecommerce.model.HomeCategory
import com.example.homecommerce.usecase.GetCategoryFromHomePageUseCase
import com.example.homecommerce.utils.applyBackgroundStream

class ProductBySystemCategoryViewModel @ViewModelInject constructor(
    private val errorUtils: ErrorUtils,
    private val getCategoryFromHomePageUseCase: GetCategoryFromHomePageUseCase
) : ViewModel() {
    sealed class GetCategoryFromHomeState {
        object Loading : GetCategoryFromHomeState()
        class Failed(val message: String) : GetCategoryFromHomeState()
        class Success(val homeCategory: HomeCategory) : GetCategoryFromHomeState()
    }

    private var page = 1

    val getCategoryFromHomeObs= MutableLiveData<GetCategoryFromHomeState>()

    fun getCategoryFromHomePage(categoryId: String, forceUpdate: Boolean = false) {
        getCategoryFromHomeObs.postValue(GetCategoryFromHomeState.Loading)
        if (forceUpdate) page = 1
        getCategoryFromHomePageUseCase
            .execute(categoryId,  page)
            .applyBackgroundStream()
            .subscribe({
                page++
                getCategoryFromHomeObs.postValue(GetCategoryFromHomeState.Success(it))
            }, {
                val error = ErrorHandler.getError(it, AppError::class.java, errorUtils)
                getCategoryFromHomeObs.postValue(GetCategoryFromHomeState.Failed(error.provideErrorMessage()))
            })
    }
}