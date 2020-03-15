package com.example.retrofitexample.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnScrollChangeListener
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.retrofitexample.DataStateChangeListener
import com.example.retrofitexample.R
import com.example.retrofitexample.api.model.Food.Hit.Recipe
import com.example.retrofitexample.ui.main.state.MainStateEvent
import com.example.retrofitexample.ui.main.state.MainViewState
import com.example.retrofitexample.ui.viewmodel.main.MainViewModel
import com.example.retrofitexample.util.ItemDecoration
import com.example.retrofitexample.util.RecipeListAdapter
import com.example.retrofitexample.util.RecipeListAdapter.Interaction

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment(), Interaction {

    lateinit var viewModel: MainViewModel

    lateinit var dataStateListener: DataStateChangeListener

    lateinit var recyclerView: RecyclerView

    lateinit var rvAdapter: RecipeListAdapter

    lateinit var searchView: SearchView

    private var recipe: ArrayList<Recipe> = ArrayList()

    private var to: Int = 10

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View = inflater.inflate(R.layout.fragment_search, container, false)
        recyclerView = view.findViewById(R.id.searchFragment_rv)
        searchView = view.findViewById(R.id.searchFragment_searchView)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initRecyclerView()

        viewModel = activity?.run { ViewModelProvider(this).get(MainViewModel::class.java) }
            ?: throw Exception("Invalid Activity")

        subscribeObservers()

        val listener: OnQueryTextListener =
            object : OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    println("DEBUG  query... $query")

                    if (query != null) {
                        runQuery(query)
                    }

                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    println("DEBUG newText... $newText")
                    return false
                }
            }

        searchView.setOnQueryTextListener(listener)
    }

    private fun runQuery(query: String) {
        viewModel.setStateEvent(MainStateEvent.GetFoodEvent(query, to - 10, to))
    }

    private fun initRecyclerView() {

        val scrollListener : OnScrollListener =
            object : OnScrollListener(){
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (recyclerView.canScrollVertically(1)){
                        println("DEBUG... Reached bottom!")

                    }
                }
            }


        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(ItemDecoration(30))
            rvAdapter = RecipeListAdapter(this@SearchFragment, activity)
            recyclerView.adapter = rvAdapter
            recyclerView.addOnScrollListener(scrollListener)

        }





    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->

            //handle loading and exception
            dataStateListener.onDataStateChange(dataState)

            dataState.data?.let { event ->
                event.getContentIfNotHandled()?.let { it ->
                    it.food?.let { it ->
                        viewModel.setFood(it)
                    }
                }
            }
        })

        viewModel.viewState.observe(viewLifecycleOwner, Observer { viewState ->
            viewState.food?.let { list ->
                //                recipe.clear()

                try {
                    for (element in list.hits) {
                        recipe.add(element.recipe)
                    }

                    rvAdapter.submitList(recipe)
                } catch (e: java.lang.Exception) {
                    println("viewState observer exception")
                }
            }
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            dataStateListener = context as DataStateChangeListener
        } catch (e: ClassCastException) {
            println("DEBUG: ${e}... $context MainActivity must implement DataStateChangeListener")
        }
    }

    override fun onItemSelected(position: Int, item: Recipe) {
    }
}
