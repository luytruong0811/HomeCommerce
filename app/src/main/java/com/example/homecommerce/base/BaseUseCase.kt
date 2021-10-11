package com.example.homecommerce.base

import io.reactivex.rxjava3.core.Observable


abstract class BaseUseCase<T> {
    abstract fun execute(vararg params: Any): Observable<T>
}