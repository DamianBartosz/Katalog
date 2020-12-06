package com.example.katalog.screens.accessories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.katalog.R

class AccessoriesViewAdapter(private val accessories: Array<String>) :
    RecyclerView.Adapter<AccessoriesViewAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val accessoryTV: TextView = view.findViewById<TextView>(R.id.accessoryTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val accessoryRow =
            LayoutInflater.from(parent.context).inflate(R.layout.accessories_row, parent, false)
        return ViewHolder(accessoryRow)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            accessoryTV.text = accessories[position]
        }
    }

    override fun getItemCount(): Int {
        return accessories.size
    }
}