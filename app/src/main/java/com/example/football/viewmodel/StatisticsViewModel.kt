package com.example.football.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.football.api.Repository
import com.example.football.model.item_statistics
import com.example.football.model.item_statistics_attack
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class StatisticsViewModel:ViewModel() {

    val repo = Repository()
    var Statistics_Defense:MutableLiveData<Response<item_statistics>> = MutableLiveData()
    var Statistics_Attack:MutableLiveData<Response<item_statistics_attack>> = MutableLiveData()

    fun getStatisticsDefense(){
        viewModelScope.launch(Dispatchers.IO) {

            var response_defense = repo.getStatisticsDefense()
            withContext(Dispatchers.Main){
                Statistics_Defense.value = response_defense
            }

        }
    }

    fun getStatisticsAttack(){
        viewModelScope.launch(Dispatchers.IO) {

            var response_attack = repo.getStatisticsAttack()
            withContext(Dispatchers.Main){
                Statistics_Attack.value = response_attack
            }

        }
    }




}