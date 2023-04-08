package com.example.football.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.football.R
import com.example.football.model.item_statisticsItem
import com.example.football.model.item_statistics_attackItem
import kotlinx.android.synthetic.main.item_statistics.view.*

class StatisticsAdapter: RecyclerView.Adapter<StatisticsAdapter.StatisticsViewHolder>()  {

    var list_defense = ArrayList<item_statisticsItem>()
    var list_attack = ArrayList<item_statistics_attackItem>()
    var flag = true

    class StatisticsViewHolder(view: View):RecyclerView.ViewHolder(view){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatisticsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_statistics,parent,false)
        return StatisticsViewHolder(view)
    }

    override fun onBindViewHolder(holder: StatisticsViewHolder, position: Int) {
        if(flag){
            holder.itemView.id_stat_number.text = (position+1).toString()
            holder.itemView.id_stat_team.text  = list_defense[position].Команда
            holder.itemView.id_stat_turnir.text  = list_defense[position].Турнир
            holder.itemView.id_stat_udari.text  = list_defense[position].Удары_зи.toString()
            holder.itemView.id_stat_otbori.text  = list_defense[position].Отборы_зи.toString()
        }else{
            holder.itemView.id_stat_number.text = (position+1).toString()
            holder.itemView.id_stat_team.text = list_attack[position].Команда
            holder.itemView.id_stat_turnir.text = list_attack[position].Турнир
            holder.itemView.id_stat_udari.text = list_attack[position].Удары_зи.toString()
            holder.itemView.id_stat_otbori.text = list_attack[position].Удары_вствор_зи.toString()
        }

    }

    override fun getItemCount(): Int {
        if(flag){
            return list_defense.size
        }else{
            return list_attack.size
        }

    }


    @SuppressLint("NotifyDataSetChanged")
    fun setListDefense(List:ArrayList<item_statisticsItem>){
        list_defense = List
        flag = true
        notifyDataSetChanged()
        list_attack = ArrayList<item_statistics_attackItem>()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListAttack(List:ArrayList<item_statistics_attackItem>){
        list_attack = List
        flag = false
        notifyDataSetChanged()
        list_defense = ArrayList<item_statisticsItem>()
    }


    fun getSiziattack(): Int {
        return list_attack.size
    }

    fun getSiziDefense(): Int {
        return list_defense.size
    }






}