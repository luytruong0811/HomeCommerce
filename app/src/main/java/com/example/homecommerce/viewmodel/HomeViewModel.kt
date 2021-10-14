package com.example.homecommerce.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.homecommerce.base.BaseEcommerceViewModel
import com.example.homecommerce.ext.getDefault
import com.example.homecommerce.model.*
import com.example.homecommerce.prefs.UserPref
import com.example.homecommerce.shared.AppManagerStateChangeObs
import com.example.homecommerce.usecase.HomeUseCase
import com.example.homecommerce.utils.addTo
import com.example.homecommerce.utils.applyBackgroundStream

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel @ViewModelInject constructor(
    private val homeUseCase: HomeUseCase,
) : ViewModel() {

    private val _home = MutableLiveData<GetHomePageState>()
    val home: LiveData<GetHomePageState> = _home

    private val _bookmarkProductObs = MutableLiveData<BookmarkProductState>()
    val bookmarkProductObs: LiveData<BookmarkProductState> = _bookmarkProductObs

    private val _getHomePageObs = MutableLiveData<GetHomePageState>()
    val getHomePageObs: LiveData<GetHomePageState> = _getHomePageObs

    fun getData() {
        _getHomePageObs.postValue(GetHomePageState.Loading)
        homeUseCase.excute().enqueue(object : Callback<Home> {
            override fun onResponse(call: Call<Home>, response: Response<Home>) {
                response.body()?.homePage?.let {
                    _getHomePageObs.postValue(GetHomePageState.Success(it))
                }
            }

            override fun onFailure(call: Call<Home>, t: Throwable) {
                _getHomePageObs.postValue(GetHomePageState.Failed(t.message.toString()))
            }

        })
    }

    fun requestBookmarkProduct(product: Product) {
        product.isBookmarked = product.isBookmarked.not()
        _bookmarkProductObs.postValue(BookmarkProductState.Success(product))
    }

    sealed class BookmarkProductState {
        object Loading : BookmarkProductState()
        class Failed(val message: String) : BookmarkProductState()
        class Success(val product: Product?) : BookmarkProductState()
    }

    sealed class GetHomePageState {
        object Loading : GetHomePageState()
        class Failed(val message: String) : GetHomePageState()
        class Success(val homePage: HomePage) : GetHomePageState()
    }
}
