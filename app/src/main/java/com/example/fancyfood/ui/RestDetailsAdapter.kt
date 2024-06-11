package com.example.fancyfood.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.fancyfood.models.Food

class RestDetailsAdapter : ListAdapter<Food, RestDetailsVH>(RestDetailsDC()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestDetailsVH {
        return RestDetailsVH.create(parent)
    }

    override fun onBindViewHolder(holder: RestDetailsVH, position: Int) {
        holder.bind(getItem(position))
    }
}