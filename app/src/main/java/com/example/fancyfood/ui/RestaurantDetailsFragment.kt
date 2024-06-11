package com.example.fancyfood.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.fancyfood.databinding.FragmentRestaurantDetailsBinding
import com.example.fancyfood.interfaces.ApiFromJSONPlaceholderService

class RestaurantDetailsFragment : Fragment() {
    private var _binding: FragmentRestaurantDetailsBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: RestDetailsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRestaurantDetailsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.tvRestName.text = arguments?.getString("title")
        binding.tvRestDesc.text = arguments?.getString("desc")

        Glide.with(root)
            .load(arguments?.getString("image"))
            .into(binding.ivImage)

        restDetailsViewModel.foods.observe(viewLifecycleOwner) { foods ->
            adapter.submitList(foods)
        }

        initRcView()
        return root
    }

    private val restDetailsViewModel: RestDetailsViewModel by viewModels {
        RestDetailsVMF(ApiFromJSONPlaceholderService.create())
    }

    private fun initRcView() = with(binding) {
        adapter = RestDetailsAdapter()
        rcvRestD.layoutManager = LinearLayoutManager(context)
        rcvRestD.adapter = adapter
    }
}