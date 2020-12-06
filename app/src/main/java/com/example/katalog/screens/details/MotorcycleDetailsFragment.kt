package com.example.katalog.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.katalog.R
import com.example.katalog.databinding.FragmentMotorcycleDetailsBinding
import com.example.katalog.screens.viewpager.MotorcycleDetailsViewModel

class MotorcycleDetailsFragment : Fragment() {
    private lateinit var viewModel: MotorcycleDetailsViewModel

    private lateinit var binding: FragmentMotorcycleDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMotorcycleDetailsBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(parentFragment as ViewModelStoreOwner).get(
            MotorcycleDetailsViewModel::class.java)
        setUiData()
        return binding.root
    }

    private fun setUiData() {
        val selectedMotorcycle = viewModel.selectedMotorcycle
        binding.apply {
            mainPhotoIMGV.setImageResource(selectedMotorcycle.photos[0])
            brandDetailsTV.text = getString(R.string.brand_details_name, selectedMotorcycle.brand)
            modelDetailsTV.text = getString(R.string.model_details_name, selectedMotorcycle.model)
            categoryDetailsTV.text =
                getString(R.string.category_details_name, selectedMotorcycle.category.toString())
            horsepowerDetailsTV.text =
                getString(R.string.horsepower_details_name, selectedMotorcycle.horsePower)
        }
    }

}