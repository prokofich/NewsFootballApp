package com.example.football.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.football.R
import com.example.football.adapter.NewsAdapter
import com.example.football.blackThemes
import com.example.football.flagChangeBackground
import com.example.football.numberBackground
import com.example.football.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.fragment_news.*


class NewsFragment : Fragment() {

    lateinit var recyclerViewNews: RecyclerView
    lateinit var adapterNews: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(flagChangeBackground){
            when(numberBackground){
                1 -> { id_fragment_news.setBackgroundResource(R.drawable.background1)}
                2 -> { id_fragment_news.setBackgroundResource(R.drawable.background2)}
                3 -> { id_fragment_news.setBackgroundResource(R.drawable.background3) }
            }
        }


        if(blackThemes){
            id_news_title.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
        }else{
            id_news_title.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
        }


        val viewModelNews = ViewModelProvider(this)[NewsViewModel::class.java]

        recyclerViewNews = id_rv_news
        adapterNews = NewsAdapter(requireContext())
        recyclerViewNews.adapter = adapterNews

        viewModelNews.getNews()
        viewModelNews.News.observe(viewLifecycleOwner){ list ->
            list.body().let{adapterNews.setList(it!!)}
        }

    }


}