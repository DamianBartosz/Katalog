package com.example.katalog.screens.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.katalog.Motorcycle
import com.example.katalog.R
import com.example.katalog.data.Category


class MotorcycleListFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: MotorcycleListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_motorcycle_list, container, false)
        setViewModel()
        setRecyclerView(view)
        setSwipeDelete()
        return view
    }

    private fun setViewModel() {
        viewModel = ViewModelProvider(this).get(MotorcycleListViewModel::class.java)
    }

    private fun setRecyclerView(view: View) {
        val lifecycleOwner = this
        recyclerView = view.findViewById(R.id.MotorcycleListView)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(view.context)
            this.adapter =  MotorcycleListViewAdapter(viewModel.motorcycles, lifecycleOwner)
        }
    }

    private fun setSwipeDelete(){
        val swipeToDeleteCallback = object : SwipeToDeleteCallback() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val pos = viewHolder.adapterPosition
                val removedMotorcycle = (recyclerView.adapter as MotorcycleListViewAdapter).motorcycleListFiltered[pos]
                viewModel.remove(removedMotorcycle)
                (recyclerView.adapter as MotorcycleListViewAdapter).filterMotorcycles()
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.category_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_favorite->{
                switchFilterFavourite(item)
                true
            }
            R.id.category_all ->{
                setFilterCategory(null)
                true
            }
            R.id.category_sport ->{
                setFilterCategory(Category.SPORT)
                true
            }
            R.id.category_tourer ->{
                setFilterCategory(Category.TOURER)
                true
            }
            R.id.category_naked ->{
                setFilterCategory(Category.NAKED)
                true
            }
            R.id.category_cruiser ->{
                setFilterCategory(Category.CRUISER)
                true
            }
            R.id.category_supermoto ->{
                setFilterCategory(Category.SUPERMOTO)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun switchFilterFavourite(item: MenuItem){
        Motorcycle.filterFavourite = !Motorcycle.filterFavourite
        item.setIcon(if(Motorcycle.filterFavourite)android.R.drawable.btn_star_big_on else android.R.drawable.btn_star_big_off)
        (recyclerView.adapter as MotorcycleListViewAdapter).filterMotorcycles()
    }

    private fun setFilterCategory(categoryID:Category?){
        Motorcycle.filterCategory = categoryID
        (recyclerView.adapter as MotorcycleListViewAdapter).filterMotorcycles()
    }
}