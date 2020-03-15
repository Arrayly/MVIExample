package com.example.retrofitexample.ui.main.state

sealed class MainStateEvent {

    class GetFoodEvent(
        val query : String,
        val from : Int,
        val to : Int
    ) : MainStateEvent()

    class None : MainStateEvent()
}