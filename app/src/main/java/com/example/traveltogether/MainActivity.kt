package com.example.traveltogether

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.traveltogether.data.Attraction
import com.example.traveltogether.data.AttractionsResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    private  val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    val attractionsList: List<Attraction> by lazy {
       parseAttractions()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    private fun parseAttractions(): List<Attraction> {
        val textFromFile = resources.openRawResource(R.raw.croatia).bufferedReader().use { it.readText() }

        val type = Types.newParameterizedType(List::class.java, Attraction::class.java)
        val adapter: JsonAdapter<AttractionsResponse> = moshi.adapter(AttractionsResponse::class.java)
        return adapter.fromJson(textFromFile)!!.attractions
    }
}