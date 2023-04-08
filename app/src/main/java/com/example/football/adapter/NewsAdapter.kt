package com.example.football.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.football.R
import com.example.football.model.item_newsItem
import kotlinx.android.synthetic.main.item_news.view.*
import kotlinx.android.synthetic.main.item_table.view.*

class NewsAdapter(private val context: Context): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>()   {

    var list = ArrayList<item_newsItem>()

    class NewsViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        Glide.with(context)
            .load(list[position].img)
            .into(holder.itemView.id_news_image)

        holder.itemView.id_news_title.text = list[position].tittle
        holder.itemView.id_news_message.text = list[position].text
        holder.itemView.id_news_date.text = list[position].date
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    @JvmName("setList1")
    fun setList(List:ArrayList<item_newsItem>){
        list = List
        notifyDataSetChanged()
    }



}