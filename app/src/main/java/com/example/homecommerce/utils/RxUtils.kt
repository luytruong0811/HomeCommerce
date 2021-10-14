package com.example.homecommerce.utils

import com.example.homecommerce.base.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


fun <T> Observable<T>.applyBackgroundStream(): Observable<T> {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun Disposable.addTo(viewModel: BaseViewModel) {
    viewModel.disposable.add(this)
}