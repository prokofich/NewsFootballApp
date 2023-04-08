package com.example.football.api

import com.example.football.model.item_news
import com.example.football.model.item_statistics
import com.example.football.model.item_statistics_attack
import com.example.football.model.item_table
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("api/data_tournament_tables.json")
    suspend fun getTable():Response<item_table>

    @GET("api/data_statistic_defense.json")
    suspend fun getStatisticsDefense():Response<item_statistics>

    @GET("api/data_statistic_attack.json")
    suspend fun getStatisticsAttack():Response<item_statistics_attack>

    @GET("api/news.json")
    suspend fun getNews():Response<item_news>
}