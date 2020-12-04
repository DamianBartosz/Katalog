package com.example.katalog.screens.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.katalog.Category
import com.example.katalog.Motorcycle
import com.example.katalog.R


class MotorcycleListFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    val motorcycles: Array<Motorcycle> = Array(1) {
        Motorcycle("Kawasaki", "Ninja 650", 80f, Category.SPORT, Array(1) { 1 })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_motorcycle_list, container, false)
        recyclerView = view.findViewById(R.id.MotorcycleListView)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(view.context)
            adapter = MotorcycleViewAdapter(motorcycles)
        }
        return view
    }
}