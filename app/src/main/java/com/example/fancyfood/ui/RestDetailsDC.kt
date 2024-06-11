package com.example.fancyfood.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.fancyfood.models.Food

class RestDetailsDC : DiffUtil.ItemCallback<Food>() {
    override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
        return oldItem == newItem
    }
}