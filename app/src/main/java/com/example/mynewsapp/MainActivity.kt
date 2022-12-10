package com.example.mynewsapp

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mynewsapp.Api.newsApi
import com.example.mynewsapp.Retrofit.newsRetrofit
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {

    lateinit var newsList: RecyclerView
    lateinit var adapter: NewsApadter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        newsList = findViewById(R.id.newsList)

        val apiobj = newsRetrofit.getinstance().create(newsApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val result = apiobj.getNews("techcrunch", "21a41885b54f46219aa7527684f6d508")
            if(!result.isSuccessful){
                Log.d("RESULT:", "result is null")
            }else{
                withContext(Dispatchers.Main){
                    Log.d("RESULT:", "${result.body()?.toString()}")
                    adapter = result.body()?.articles?.let { article->
                        NewsApadter (article)
                    }!!
                    newsList.adapter = adapter
                    newsList.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
        }

    }
}