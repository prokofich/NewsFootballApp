package com.example.football.api

import com.example.football.model.item_news
import com.example.football.model.item_statistics
import com.example.football.model.item_statistics_attack
import com.example.football.model.item_table
import retrofit2.Response

class Repository {

    suspend fun getTable(): Response<item_table> {
        return RetrofitInstance.api.getTable()
    }

    suspend fun getStatisticsDefense():Response<item_statistics>{
        return RetrofitInstance.api.getStatisticsDefense()
    }

    suspend fun getStatisticsAttack():Response<item_statistics_attack>{
        return RetrofitInstance.api.getStatisticsAttack()
    }

    suspend fun getNews():Response<item_news>{
        return RetrofitInstance.api.getNews()
    }

}