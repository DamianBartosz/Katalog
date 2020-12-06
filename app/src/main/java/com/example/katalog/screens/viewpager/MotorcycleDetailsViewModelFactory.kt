package com.example.katalog.screens.viewpager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.katalog.Motorcycle
import java.lang.IllegalArgumentException

class MotorcycleDetailsViewModelFactory(private val selectedMotorcycle:Motorcycle) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MotorcycleDetailsViewModel::class.java)){
            return MotorcycleDetailsViewModel(selectedMotorcycle) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}