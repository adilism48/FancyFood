package com.example.fancyfood.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fancyfood.databinding.FoodItemBinding
import com.example.fancyfood.models.Food

class RestDetailsVH (private val binding: FoodItemBinding) :
RecyclerView.ViewHolder(binding.root) {

    fun bind(food: Food) = with(binding) {
        tvFoodName.text = food.title

        Glide.with(itemView.context)
            .load(food.url)
            .into(imageView)
    }

    companion object {
        fun create(parent: ViewGroup): RestDetailsVH {
            return RestDetailsVH(
                FoodItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}