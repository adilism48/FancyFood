package com.example.fancyfood.ui.restaurant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fancyfood.R
import com.example.fancyfood.databinding.RestaurantItemBinding
import com.example.fancyfood.models.Restaurant

class RestaurantViewHolder (private val binding: RestaurantItemBinding) :
RecyclerView.ViewHolder(binding.root) {

    fun bind(restaurant: Restaurant) = with(binding) {
        tvRestName.text = restaurant.title
        tvRestRating.text = restaurant.rating.rate

        Glide.with(itemView.context)
            .load(restaurant.image)
            .into(ivRestImg)

        binding.bReadMore.setOnClickListener {
            val bundle = bundleOf(
                "title" to restaurant.title,
                "desc" to restaurant.description,
                "image" to restaurant.image
            )
            root.findNavController().navigate(R.id.action_RestaurantFragment_to_restaurantDetailsFragment, bundle)
        }
    }

    companion object {
        fun create(parent: ViewGroup): RestaurantViewHolder {
            return RestaurantViewHolder(
                RestaurantItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}