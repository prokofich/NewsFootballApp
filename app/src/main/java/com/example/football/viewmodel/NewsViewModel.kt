package com.example.football.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.football.api.Repository
import com.example.football.model.item_news
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class NewsViewModel:ViewModel() {

    val repo = Repository()
    var News:MutableLiveData<Response<item_news>> = MutableLiveData()

    fun getNews(){
        viewModelScope.launch(Dispatchers.IO) {

            var response = repo.getNews()
            withContext(Dispatchers.Main){
                News.value = response
            }

        }
    }


}