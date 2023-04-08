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
import com.example.football.adapter.StatisticsAdapter
import com.example.football.blackThemes
import com.example.football.flagChangeBackground
import com.example.football.numberBackground
import com.example.football.viewmodel.StatisticsViewModel
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.fragment_statistics.*

class StatisticsFragment : Fragment() {

    lateinit var recyclerViewStatistics: RecyclerView
    lateinit var adapterStatistics: StatisticsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(flagChangeBackground){
            when(numberBackground){
                1 -> { id_fragment_statistic.setBackgroundResource(R.drawable.background1)}
                2 -> { id_fragment_statistic.setBackgroundResource(R.drawable.background2)}
                3 -> { id_fragment_statistic.setBackgroundResource(R.drawable.background3) }
            }
        }

        if (blackThemes){
            id_statistics_defense.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            id_statistics_attack.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            id_statistic_title.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
        }else{
            id_statistics_defense.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
            id_statistics_attack.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
            id_statistic_title.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
        }




        val viewModelStatistics = ViewModelProvider(this)[StatisticsViewModel::class.java]

        recyclerViewStatistics = id_rv_statistics
        adapterStatistics = StatisticsAdapter()
        recyclerViewStatistics.adapter = adapterStatistics


        id_stat_tv_4.text = "Удары"
        id_stat_tv_5.text = "Отборы"
        viewModelStatistics.getStatisticsDefense()
        viewModelStatistics.Statistics_Defense.observe(viewLifecycleOwner){ list ->
            list.body().let { adapterStatistics.setListDefense(it!!) }
        }




        id_statistics_attack.setOnClickListener {

            id_statistics_attack.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.orange))
            id_statistics_defense.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.blue))
            id_stat_tv_4.text = "Удары"
            id_stat_tv_5.text = "Удары в ст."

            viewModelStatistics.getStatisticsAttack()
            viewModelStatistics.Statistics_Attack.observe(viewLifecycleOwner){ list ->
                list.body().let { adapterStatistics.setListAttack(it!!) }
            }

        }



        id_statistics_defense.setOnClickListener {

            id_statistics_attack.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.blue))
            id_statistics_defense.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.orange))
            id_stat_tv_4.text = "Удары"
            id_stat_tv_5.text = "Отборы"

            viewModelStatistics.getStatisticsDefense()
            viewModelStatistics.Statistics_Defense.observe(viewLifecycleOwner){ list ->
                list.body().let { adapterStatistics.setListDefense(it!!) }
            }

        }

    }

}