package com.example.fancyfood.ui.restaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fancyfood.databinding.FragmentRestaurantBinding
import com.example.fancyfood.interfaces.ApiFromFakeStoreService

class RestaurantFragment : Fragment() {

    private var _binding: FragmentRestaurantBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: RestaurantAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRestaurantBinding.inflate(inflater, container, false)
        val root: View = binding.root

        restaurantViewModel.restaurants.observe(viewLifecycleOwner) { rest ->
            adapter.submitList(rest)
        }

        initRcView()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val restaurantViewModel: RestaurantViewModel by viewModels {
        RestaurantViewModelFactory(ApiFromFakeStoreService.create())
    }

    private fun initRcView() = with(binding) {
        adapter = RestaurantAdapter()
        rcvRest.layoutManager = LinearLayoutManager(context)
        rcvRest.adapter = adapter
    }
}