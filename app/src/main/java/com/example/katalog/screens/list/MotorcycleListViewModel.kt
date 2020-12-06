package com.example.katalog.screens.list

import androidx.lifecycle.ViewModel
import com.example.katalog.Motorcycle

class MotorcycleListViewModel : ViewModel() {
    val motorcycles: MutableList<Motorcycle> = Motorcycle.factory()

    fun remove(motorcycle: Motorcycle){
        motorcycles.remove(motorcycle)
    }
}