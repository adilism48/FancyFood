package com.example.fancyfood.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fancyfood.interfaces.ApiFromJSONPlaceholderService

class RestDetailsVMF(private val service: ApiFromJSONPlaceholderService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RestDetailsViewModel::class.java)) {
            return RestDetailsViewModel(service) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}