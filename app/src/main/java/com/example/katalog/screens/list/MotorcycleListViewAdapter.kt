package com.example.katalog.screens.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.katalog.Motorcycle
import com.example.katalog.R

class MotorcycleListViewAdapter(
    private var motorcycleList: MutableList<Motorcycle>,
    private val parent: LifecycleOwner
) : RecyclerView.Adapter<MotorcycleListViewAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val motorcycleIMGV = itemView.findViewById<ImageView>(R.id.mainMotorcycleIMGV)
        val brandTV = itemView.findViewById<TextView>(R.id.brandTV)
        val modelTV = itemView.findViewById<TextView>(R.id.modelTV)
        val categoryTV = itemView.findViewById<TextView>(R.id.categoryTV)
        val favouriteIMGB = itemView.findViewById<ImageButton>(R.id.favouriteIMGB)
    }

    lateinit var motorcycleListFiltered: MutableList<Motorcycle>
        private set

    init {
        filterMotorcycles()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val motorcycleRow =
            LayoutInflater.from(parent.context).inflate(R.layout.motorcycle_row, parent, false)
        return ViewHolder(motorcycleRow)
    }

    override fun getItemCount(): Int {
        return motorcycleListFiltered.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val motorcycle = motorcycleListFiltered[position]

        holder.apply {
            motorcycleIMGV.setImageResource(motorcycle.photos[0])
            brandTV.text = motorcycle.brand
            modelTV.text = motorcycle.model
            categoryTV.text = motorcycle.category.name
            favouriteIMGB.setImageResource(if (motorcycle.isFavourite.value!!) android.R.drawable.btn_star_big_on else android.R.drawable.btn_star_big_off)
            favouriteIMGB.setOnClickListener { motorcycle.switchFavourite() }
            itemView.setOnClickListener { onMotorcycleClick((parent as Fragment).requireView(), motorcycle) }
        }

        val isFavouriteObserver = Observer<Boolean> { newIsFavourite ->
            holder.favouriteIMGB.setImageResource(if (newIsFavourite) android.R.drawable.btn_star_big_on else android.R.drawable.btn_star_big_off)
        }
        motorcycle.isFavourite.observe(parent, isFavouriteObserver)
    }

    fun filterMotorcycles() {
        motorcycleListFiltered = motorcycleList.filter { motorcycle ->
            motorcycle.isFiltered()
        } as MutableList<Motorcycle>
        notifyDataSetChanged()
    }

    private fun onMotorcycleClick(v: View, motorcycle: Motorcycle) {
        val action =
            MotorcycleListFragmentDirections.actionMotorcycleListFragmentToViewPagerFragment(
                motorcycle
            )
        v.findNavController().navigate(action)
    }
}