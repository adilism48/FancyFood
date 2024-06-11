package com.example.fancyfood.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.fancyfood.interfaces.ApiFromJSONPlaceholderService
import kotlinx.coroutines.Dispatchers

class RestDetailsViewModel(private val apiFromJSONPlaceholderService: ApiFromJSONPlaceholderService) : ViewModel() {
    val foods = liveData(Dispatchers.IO) {
        val retrievedTours = apiFromJSONPlaceholderService.getFoods()
        emit(retrievedTours)
    }
}