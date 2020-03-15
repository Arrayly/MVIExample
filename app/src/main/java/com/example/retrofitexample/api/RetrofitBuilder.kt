package com.example.retrofitexample.api

import com.example.retrofitexample.util.LiveDataCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Singleton
object RetrofitBuilder {

    val BASE_URL = "https://api.edamam.com/"
    val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
    }

    val apiService: ApiService by lazy {
        retrofitBuilder
            .build()
            .create(ApiService::class.java)
    }
}