package com.example.traveltogether.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.traveltogether.fragment.BaseFragment
import com.example.traveltogether.databinding.FragmentHomeBinding

class HomeFragment: BaseFragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeAdapter =  HomeFragmentAdapter { attractionId ->
           val navDirections = HomeFragmentDirections.actionHomeFragmentToAttractionDetailFragment(attractionId)
            navController.navigate(navDirections)
        }

        binding.recyclerView.adapter = homeAdapter

        homeAdapter.setData(attractions)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }


}