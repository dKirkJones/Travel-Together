package com.example.traveltogether.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.traveltogether.R
import com.example.traveltogether.data.Attraction
import com.example.traveltogether.databinding.ViewHolderAttractionCardBinding
import com.squareup.picasso.Picasso

class HomeFragmentAdapter(
    private val onClickedCallback: (String)-> Unit

) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val attractions = ArrayList<Attraction>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return AttractionViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as AttractionViewHolder).onBind(attractions[position], onClickedCallback)
    }

    override fun getItemCount(): Int {
       return attractions.size
    }

    fun setData(attractions: List<Attraction>){
        this.attractions.clear()
        this.attractions.addAll(attractions)
        notifyDataSetChanged()
    }

    inner class AttractionViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_attraction_card, parent, false)
    ){
        private val binding = ViewHolderAttractionCardBinding.bind(itemView)
        fun onBind(attraction: Attraction, onClicked: (String)  -> Unit){
            binding.titleTextView.text = attraction.title
            Picasso.get().load(attraction.image_url).into(binding.headerImageView)
            binding.monthsToVisitTextView.text = attraction.months_to_visit
            binding.root.setOnClickListener{
                onClicked(attraction.id)
            }

        }
    }
}
