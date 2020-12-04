package com.example.katalog.screens.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.katalog.Motorcycle
import com.example.katalog.R
import kotlinx.android.synthetic.main.motorcycle_row.view.*

class MotorcycleViewAdapter ( private var motorcycleList:Array<Motorcycle>):RecyclerView.Adapter<MotorcycleViewAdapter.ViewHolder>(){
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val brandTV = itemView. findViewById<TextView>(R.id.brandTV)
        val modelTV = itemView. findViewById<TextView>(R.id.modelTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val motorcycleRow = LayoutInflater.from(parent.context).inflate(R.layout.motorcycle_row, parent, false)
        return ViewHolder(motorcycleRow)
    }

    override fun getItemCount(): Int {
        return motorcycleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val motorcycle = motorcycleList[position]

        holder.apply {
            brandTV.text = motorcycle.brand
            modelTV.text = motorcycle.model
        }
    }
}