package com.example.traveltogether.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.traveltogether.data.Attraction
import com.example.traveltogether.repository.AttractionsRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AttractionsViewModel : ViewModel() {

    private val repository = AttractionsRepository()

    // HomeFragment
    val attractionListLiveData = MutableLiveData<ArrayList<Attraction>>()

    // AttractionDetailFragment
    val selectedAttractionLiveData = MutableLiveData<Attraction>()

    // MainActivity
    val locationSelectedLiveData = MutableLiveData<Attraction>()

    fun init(context: Context) {
        viewModelScope.launch {
            delay(2_000)
            val attractionsList = repository.parseAttractions(context)
            attractionListLiveData.postValue(attractionsList)
        }
    }

    fun onAttractionSelected(attractionId: String) {
        val attraction = attractionListLiveData.value?.find {
            it.id == attractionId
        } ?: return

        selectedAttractionLiveData.postValue(attraction)
    }
}