package com.example.fancyfood.interfaces

import com.example.fancyfood.models.Restaurant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiFromFakeStoreService {
    @GET("products")
    suspend fun getRestaurants(): List<Restaurant>

    companion object {
        private const val BASE_URL = "https://fakestoreapi.com"

        fun create(): ApiFromFakeStoreService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiFromFakeStoreService::class.java)
        }
    }
}