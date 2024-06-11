package com.example.fancyfood.ui.restaurant

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fancyfood.interfaces.ApiFromFakeStoreService

class RestaurantViewModelFactory(private val service: ApiFromFakeStoreService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RestaurantViewModel::class.java)) {
            return RestaurantViewModel(service) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}