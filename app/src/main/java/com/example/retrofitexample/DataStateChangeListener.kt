package com.example.retrofitexample

import com.example.retrofitexample.util.DataState

interface DataStateChangeListener {
    fun onDataStateChange(dataState: DataState<*>?)
}