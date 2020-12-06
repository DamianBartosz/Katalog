package com.example.katalog.screens.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.katalog.R
import com.example.katalog.screens.viewpager.MotorcycleDetailsViewModel

class GalleryFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: MotorcycleDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)
        viewModel = ViewModelProvider(parentFragment as ViewModelStoreOwner).get(
            MotorcycleDetailsViewModel::class.java
        )
        recyclerView = view.findViewById(R.id.GalleryView)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(view.context)
            this.adapter =  GalleryViewAdapter(viewModel.selectedMotorcycle.photos)
        }
        return view
    }
}