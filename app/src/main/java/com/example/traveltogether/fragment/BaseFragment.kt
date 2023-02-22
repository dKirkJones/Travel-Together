package com.example.traveltogether.fragment

import androidx.fragment.app.Fragment
import com.example.traveltogether.MainActivity
import com.example.traveltogether.data.Attraction

abstract class BaseFragment: Fragment() {

    protected val navController by lazy {
        (activity as MainActivity).navController
    }

    protected val attractions: List<Attraction>
    get() = (activity as MainActivity).attractionsList
}