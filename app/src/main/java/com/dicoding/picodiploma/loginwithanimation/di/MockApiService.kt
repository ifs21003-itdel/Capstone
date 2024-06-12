package com.dicoding.picodiploma.loginwithanimation.di

object MockApiService {
    fun getHeadlineIngredients() = FakeData.generateHeadlineIngredients()

    fun getIngredients() = FakeData.generateIngredients()

    fun searchIngredients(query: String) = FakeData.searchIngredients(query)

    fun searchKeluhanIngredients(query: String) = FakeData.searchKeluhanIngredients(query)
}