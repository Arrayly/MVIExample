package com.example.retrofitexample.ui.main.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitexample.R
import com.example.retrofitexample.R.layout
import com.example.retrofitexample.ui.fragment.SearchFragment
import com.example.retrofitexample.DataStateChangeListener
import com.example.retrofitexample.ui.viewmodel.main.MainViewModel
import com.example.retrofitexample.util.DataState

class MainActivity : AppCompatActivity(), DataStateChangeListener {

    lateinit var viewModel: MainViewModel
    lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        progress = findViewById(R.id.mainActivity_proBar)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        loadFragment()
    }

    private fun loadFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainActivity_fragmentContainer, SearchFragment(), "SearchFragment")
            .addToBackStack("stack1")
            .commit()
    }

    override fun onDataStateChange(dataState: DataState<*>?) {
        handleDataStateChange(dataState)
    }

    private fun handleDataStateChange(dataState: DataState<*>?) {
        dataState?.let { state ->
            if (state.loading) {
                progress.visibility = View.VISIBLE
            } else {
                progress.visibility = View.GONE
            }

            dataState?.message.let { event ->
                event?.getContentIfNotHandled().let {
                    Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
