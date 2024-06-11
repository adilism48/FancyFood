package com.example.fancyfood.ui.restaurant

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.fancyfood.models.Restaurant

class RestaurantAdapter : ListAdapter<Restaurant, RestaurantViewHolder>(RestaurantDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}