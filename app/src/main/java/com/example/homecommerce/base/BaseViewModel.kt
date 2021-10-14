package com.example.homecommerce.base

import androidx.hilt.Assisted
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

/**
 * Created by hung.nguyendk on 10/7/20.
 */
abstract class BaseViewModel(
    @Assisted val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val disposable = CompositeDisposable()

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}