package com.example.football.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.football.api.Repository
import com.example.football.model.item_table
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class TableViewModel:ViewModel() {

    val repo = Repository()
    var Table:MutableLiveData<Response<item_table>> = MutableLiveData()

    fun getTable(){
        viewModelScope.launch(Dispatchers.IO) {

            val response = repo.getTable()
            withContext(Dispatchers.Main){
                Table.value = response
            }

        }
    }

}