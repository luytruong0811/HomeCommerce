package com.example.homecommerce.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homecommerce.ext.getDefault
import com.example.homecommerce.model.*
import com.example.homecommerce.shared.AppManagerStateChangeObs
import com.example.homecommerce.usecase.HomeUseCase

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel @ViewModelInject constructor(
    private val homeUseCase: HomeUseCase,
) : ViewModel() {

    private val _home = MutableLiveData<HomeState>()
    val home : LiveData<HomeState> = _home

    private val _bookmarkTopProductObs = MutableLiveData<BookmarkTopProductState>()
    val bookmarkTopProductObs: LiveData<BookmarkTopProductState> = _bookmarkTopProductObs

    private val _bookmarkNewestProductObs = MutableLiveData<BookmarkNewestProductState>()
    val bookmarkNewestProductObs: LiveData<BookmarkNewestProductState> = _bookmarkNewestProductObs

    private val _bookmarkSuggestProductObs = MutableLiveData<BookmarkSuggestProductState>()
    val bookmarkSuggestProductState: LiveData<BookmarkSuggestProductState> = _bookmarkSuggestProductObs

    fun getData(){
        _home.postValue(HomeState.Loading)
        homeUseCase.excute().enqueue(object : Callback<Home>{
                override fun onResponse(call: Call<Home>, response: Response<Home>) {
                    _home.postValue(response.body()?.homePage?.let { HomeState.Success(it) })
                }

                override fun onFailure(call: Call<Home>, t: Throwable) {
                    _home.postValue(HomeState.Error(t.message.toString()))
                }

            })
    }

    fun requestBookmarkTopProduct(product: TopProduct) {
        product.isBookmarked = product.isBookmarked.not()
        _bookmarkTopProductObs.postValue(BookmarkTopProductState.Success(product))
    }

    fun requestBookmarkSuggestProduct(suggestProduct: SuggestProduct) {
        suggestProduct.isBookmarked = suggestProduct.isBookmarked.not()
        _bookmarkSuggestProductObs.postValue(BookmarkSuggestProductState.Success(suggestProduct))
    }

    fun requestBookmarkNewestProduct(newestProduct: NewestProduct) {
        newestProduct.isBookmarked = newestProduct.isBookmarked.not()
        _bookmarkNewestProductObs.postValue(BookmarkNewestProductState.Success(newestProduct))
    }



    sealed class HomeState{
        object Loading : HomeState()
        class Success(var items: HomePage) : HomeState()
        class Error(var message: String) : HomeState()
    }

    sealed class BookmarkTopProductState {
        object Loading : BookmarkTopProductState()
        class Failed(val message: String) : BookmarkTopProductState()
        class Success(val topProduct: TopProduct?) : BookmarkTopProductState()
    }

    sealed class BookmarkNewestProductState {
        object Loading : BookmarkNewestProductState()
        class Failed(val message: String) : BookmarkNewestProductState()
        class Success(val newestProduct: NewestProduct?) : BookmarkNewestProductState()
    }

    sealed class BookmarkSuggestProductState {
        object Loading : BookmarkSuggestProductState()
        class Failed(val message: String) : BookmarkSuggestProductState()
        class Success(val suggestProduct: SuggestProduct?) : BookmarkSuggestProductState()
    }
}
