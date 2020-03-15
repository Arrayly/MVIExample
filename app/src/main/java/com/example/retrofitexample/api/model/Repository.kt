package com.example.retrofitexample.api.model

import androidx.lifecycle.LiveData
import com.example.retrofitexample.api.RetrofitBuilder
import com.example.retrofitexample.ui.main.state.MainViewState
import com.example.retrofitexample.util.ApiSuccessResponse
import com.example.retrofitexample.util.Constants
import com.example.retrofitexample.util.DataState
import com.example.retrofitexample.util.DataState.Companion
import com.example.retrofitexample.util.GenericApiResponse
import com.example.retrofitexample.util.NetworkBoundResource

object Repository {

//    fun getFood(query: String, from: Int, to: Int): LiveData<DataState<MainViewState>> {
//        return object : NetworkBoundResource<Food>, MainViewState>() {
//            override fun handleApiSuccessResponse(response: ApiSuccessResponse<Food>) {
//                result.value = DataState.data(
//                    data = MainViewState(food = response.body)
//                )
//            }
//
//            override fun createCall(): LiveData<GenericApiResponse<Food>> {
//                return RetrofitBuilder.apiService.searchRecipes(
//                    query,
//                    Constants.APPLICATION_ID,
//                    Constants.API_KEY,
//                    from,
//                    to
//                )
//            }
//        }.asLiveData()
//    }

    fun getFood(query: String, from: Int, to: Int): LiveData<DataState<MainViewState>> {
        return object : NetworkBoundResource<Food, MainViewState>() {
            override fun createCall(): LiveData<GenericApiResponse<Food>> {
                return RetrofitBuilder.apiService.searchRecipes(
                    query,
                    Constants.APPLICATION_ID,
                    Constants.API_KEY,
                    from,
                    to
                )
            }

            override fun handleApiSuccessResponse(response: ApiSuccessResponse<Food>) {
                result.value = DataState.data(
                    data = MainViewState(food = response.body)
                )
            }
        }.asLiveData()
    }
}
