package com.example.katalog.screens.viewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(parent: Fragment, private val fragments: Array<Fragment>) :
    FragmentStateAdapter(parent) {
    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position]
}