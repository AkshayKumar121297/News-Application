package com.example.mynewsapp

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.mynewsapp.model.Article

class NewsApadter(val article: List<Article>) :
    RecyclerView.Adapter<NewsApadter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.newsTittle.text = article[position].title
        holder.newsDescription.text = article[position].description
        Glide.with(holder.itemView.context).load(article[position].urlToImage).into(holder.newsImage)
        holder.itemView.setOnClickListener {
                val builder = CustomTabsIntent.Builder()
                val customTabsIntent = builder.build()
                customTabsIntent.launchUrl(holder.itemView.context, Uri.parse(article[position].url))
        }
    }

    override fun getItemCount(): Int {
        return article.size
    }

    class ArticleViewHolder(itemView: View) : ViewHolder(itemView) {

        var newsImage = itemView.findViewById<ImageView>(R.id.newsImage)
        var newsTittle = itemView.findViewById<TextView>(R.id.newsTittle)
        var newsDescription = itemView.findViewById<TextView>(R.id.newsDescription)

    }
}