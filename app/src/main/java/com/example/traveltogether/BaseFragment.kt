package com.example.traveltogether

import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {

    protected val navController by lazy {
        (activity as MainActivity).navController
    }
}