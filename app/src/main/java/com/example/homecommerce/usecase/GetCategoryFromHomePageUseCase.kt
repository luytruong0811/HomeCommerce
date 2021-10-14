package com.example.homecommerce.usecase

import com.example.homecommerce.base.BaseUseCase
import com.example.homecommerce.model.HomeCategory
import com.example.homecommerce.repository.HomeRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GetCategoryFromHomePageUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) : BaseUseCase<HomeCategory>() {
    override fun execute(vararg params: Any): Observable<HomeCategory> {
        val categoryId: String = params[0] as String
        val page: Int = params[1] as Int
        return homeRepository.getCategoryFromHomePage(
            id = categoryId,
            page = page
        )
    }
}