package com.example.katalog.screens.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.katalog.R

class GalleryViewAdapter(private val photos: Array<Int>) :
    RecyclerView.Adapter<GalleryViewAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val galleryPhotoIMGV: ImageView = view.findViewById(R.id.galleryPhotoIMGV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val galleryRow =
            LayoutInflater.from(parent.context).inflate(R.layout.gallery_row, parent, false)
        return ViewHolder(galleryRow)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            galleryPhotoIMGV.setImageResource(photos[position])
        }
    }

    override fun getItemCount(): Int {
        return photos.size
    }
}