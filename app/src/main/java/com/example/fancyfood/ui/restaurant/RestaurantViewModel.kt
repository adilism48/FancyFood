package com.example.fancyfood.ui.restaurant

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.fancyfood.interfaces.ApiFromFakeStoreService
import kotlinx.coroutines.Dispatchers

class RestaurantViewModel(private val apiFromFakeStoreService: ApiFromFakeStoreService) : ViewModel() {
    val restaurants = liveData(Dispatchers.IO) {
        val retrievedTours = apiFromFakeStoreService.getRestaurants()
        emit(retrievedTours)
    }
}