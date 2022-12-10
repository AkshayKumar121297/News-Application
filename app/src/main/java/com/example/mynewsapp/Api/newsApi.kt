package com.example.mynewsapp.Api

import com.example.mynewsapp.model.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface newsApi {

    @GET("top-headlines/")

    suspend fun getNews(@Query("sources") sources: String, @Query("apiKey") apiKey: String): Response<News>
}

// https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=API_KEY
// 21a41885b54f46219aa7527684f6d508

// https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=21a41885b54f46219aa7527684f6d508