package com.example.mynewsapp.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object newsRetrofit {

    val baseUrl = "https://newsapi.org/v2/"

    fun getinstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}