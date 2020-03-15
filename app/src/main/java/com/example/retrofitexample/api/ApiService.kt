package com.example.retrofitexample.api

import androidx.lifecycle.LiveData
import com.example.retrofitexample.api.model.Food
import com.example.retrofitexample.util.GenericApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //SEARCH REQUEST

    @GET("search")
    fun searchRecipes(
        @Query("q") query : String,
        @Query("app_id") id : String,
        @Query("app_key") key : String,
        @Query("from") from : Int,
        @Query("to") to : Int

    ): LiveData<GenericApiResponse<Food>>






}