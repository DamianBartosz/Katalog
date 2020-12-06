package com.example.katalog.screens.viewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.katalog.Motorcycle
import com.example.katalog.screens.accessories.AccessoriesFragment
import com.example.katalog.screens.details.MotorcycleDetailsFragment
import com.example.katalog.screens.gallery.GalleryFragment

class ViewPagerAdapter(parent: Fragment, val fragments: Array<Fragment>) :
    FragmentStateAdapter(parent) {
    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position]
}