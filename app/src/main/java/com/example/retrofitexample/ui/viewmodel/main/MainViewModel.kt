package com.example.retrofitexample.ui.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.retrofitexample.api.model.Food
import com.example.retrofitexample.api.model.Repository
import com.example.retrofitexample.ui.main.state.MainStateEvent
import com.example.retrofitexample.ui.main.state.MainStateEvent.GetFoodEvent
import com.example.retrofitexample.ui.main.state.MainStateEvent.None
import com.example.retrofitexample.ui.main.state.MainViewState
import com.example.retrofitexample.util.AbsentLiveData
import com.example.retrofitexample.util.DataState

class MainViewModel : ViewModel() {

    private val _viewState : MutableLiveData<MainViewState> = MutableLiveData()

    private val _stateEvent : MutableLiveData<MainStateEvent> = MutableLiveData()


    //Return the object
    val viewState: LiveData<MainViewState>
        get() = _viewState

    //Listening for the change in state of _viewState mutable live data object, if changed,
    //code below will be executed
    val dataState: LiveData<DataState<MainViewState>> = Transformations
        .switchMap(_stateEvent) { stateEvent ->
            stateEvent?.let {
                handleStateEvent(it)

            }
        }

    // we handle the different state events here
    fun handleStateEvent(stateEvent: MainStateEvent): LiveData<DataState<MainViewState>> {
        when (stateEvent) {

            is GetFoodEvent -> {
                return Repository.getFood(stateEvent.query,stateEvent.from,stateEvent.to)
            }

            is None -> {
                return AbsentLiveData.create()
            }
        }
    }


    fun setFood(food: Food){
        val state = getCurrentViewStateOrNew()
        state.food = food
        _viewState.value = state
    }


    //CHECK IF viewState is not null, return a new viewstate if it is
    fun getCurrentViewStateOrNew(): MainViewState {
        val value = viewState.value?.let {
            it
        } ?: MainViewState()
        return value
    }

    fun setStateEvent(event: MainStateEvent){
        _stateEvent.value = event
    }
}