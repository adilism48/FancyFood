package com.example.fancyfood.models

data class Restaurant(
    val id: String,
    val title: String,
    val price: String,
    val description: String,
    val category: String,
    val image: String,
    val rating: Rating
)
