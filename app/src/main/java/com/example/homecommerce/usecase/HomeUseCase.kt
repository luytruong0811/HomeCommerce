package com.example.homecommerce.usecase

import com.example.homecommerce.model.Home
import com.example.homecommerce.repository.HomeRepository
import retrofit2.Call
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    fun excute() : Call<Home> {
        return homeRepository.getHome()
    }
}
