package com.example.traveltogether.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.traveltogether.data.Attraction
import com.example.traveltogether.databinding.FragmentAttractionDetailsBinding
import com.squareup.picasso.Picasso

class AttractionDetailsFragment : BaseFragment() {

    private var _binding: FragmentAttractionDetailsBinding? = null
    private val binding get() = _binding!!

    private val safeArgs: AttractionDetailsFragmentArgs by navArgs()
    private val attraction: Attraction by lazy {
        attractions.find { it.id == safeArgs.attractionId }!!
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAttractionDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.titleText.text =attraction.title
        Picasso.get().load(attraction.image_url).into(binding.headerImage)
        binding.descriptionText.text = attraction.description
        binding.monthsToVisitText.text =attraction.months_to_visit
        binding.numberOfFactsText.text = "${attraction.facts.size}facts"
        binding.numberOfFactsText.setOnClickListener {
            //todo
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}