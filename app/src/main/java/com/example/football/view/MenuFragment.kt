package com.example.football.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.football.*
import kotlinx.android.synthetic.main.fragment_menu.*


class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(flagChangeBackground){
            when(numberBackground){
                1 -> { id_fragment_menu.setBackgroundResource(R.drawable.background1)}
                2 -> { id_fragment_menu.setBackgroundResource(R.drawable.background2)}
                3 -> { id_fragment_menu.setBackgroundResource(R.drawable.background3) }
            }
        }

        if(blackThemes){
            id_menu_news.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            id_menu_statistics.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            id_menu_settings.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            id_menu_tables.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
        }else{
            id_menu_news.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
            id_menu_statistics.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
            id_menu_settings.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
            id_menu_tables.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
        }

        id_menu_news.setOnClickListener {
            MAIN.navController.navigate(R.id.action_menuFragment_to_newsFragment)
        }

        id_menu_settings.setOnClickListener {
            MAIN.navController.navigate(R.id.action_menuFragment_to_settingsFragment)
        }

        id_menu_tables.setOnClickListener {
            MAIN.navController.navigate(R.id.action_menuFragment_to_countriesFragment)
        }

        id_menu_statistics.setOnClickListener {
            MAIN.navController.navigate(R.id.action_menuFragment_to_statisticsFragment)
        }

    }


}