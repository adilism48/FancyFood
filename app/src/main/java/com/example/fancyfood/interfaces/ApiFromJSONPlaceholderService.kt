package com.example.fancyfood.interfaces

import com.example.fancyfood.models.Food
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiFromJSONPlaceholderService {
    @GET("photos")
    suspend fun getFoods(): List<Food>

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun create(): ApiFromJSONPlaceholderService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiFromJSONPlaceholderService::class.java)
        }
    }
}