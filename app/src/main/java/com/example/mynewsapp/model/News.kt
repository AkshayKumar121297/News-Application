package com.example.mynewsapp.model

import com.example.mynewsapp.model.Article

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)