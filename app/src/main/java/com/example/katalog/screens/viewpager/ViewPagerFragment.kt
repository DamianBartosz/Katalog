package com.example.katalog.screens.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.katalog.R
import com.example.katalog.screens.accessories.AccessoriesFragment
import com.example.katalog.screens.details.MotorcycleDetailsFragment
import com.example.katalog.screens.gallery.GalleryFragment
import kotlinx.android.synthetic.main.fragment_view_pager.view.*

class ViewPagerFragment : Fragment() {

    val args: ViewPagerFragmentArgs by navArgs()
    private lateinit var viewModel: MotorcycleDetailsViewModel
    private lateinit var viewModelFactory: MotorcycleDetailsViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_view_pager, container, false)
        setViewModel()
        val fragments = arrayOf(
            MotorcycleDetailsFragment(),
            GalleryFragment(),
            AccessoriesFragment()
        )
        val pagerAdapter = ViewPagerAdapter(this, fragments)
        view.pager.adapter = pagerAdapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setViewModel() {
        viewModelFactory = MotorcycleDetailsViewModelFactory(args.selectedMotorcycle)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MotorcycleDetailsViewModel::class.java)
    }
}