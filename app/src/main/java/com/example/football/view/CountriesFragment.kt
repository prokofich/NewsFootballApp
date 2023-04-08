package com.example.football.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.football.*
import kotlinx.android.synthetic.main.fragment_countries.*
import kotlinx.android.synthetic.main.fragment_menu.*

class CountriesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(flagChangeBackground){
            when(numberBackground){
                1 -> { id_fragment_countries.setBackgroundResource(R.drawable.background1)}
                2 -> { id_fragment_countries.setBackgroundResource(R.drawable.background2)}
                3 -> { id_fragment_countries.setBackgroundResource(R.drawable.background3) }
            }
        }

        if(blackThemes){
            id_tables_england.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            id_tables_russia.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            id_tables_germany.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            id_tables_spaney.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            id_tables_title.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
        }else{
            id_tables_england.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
            id_tables_russia.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
            id_tables_germany.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
            id_tables_spaney.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
            id_tables_title.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
        }

        id_tables_germany.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("COUNTRY","Германия")
            MAIN.navController.navigate(R.id.action_countriesFragment_to_tableFragment,bundle)
        }

        id_tables_spaney.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("COUNTRY","Испания")
            MAIN.navController.navigate(R.id.action_countriesFragment_to_tableFragment,bundle)
        }

        id_tables_england.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("COUNTRY","Англия")
            MAIN.navController.navigate(R.id.action_countriesFragment_to_tableFragment,bundle)
        }

        id_tables_russia.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("COUNTRY","Россия")
            MAIN.navController.navigate(R.id.action_countriesFragment_to_tableFragment,bundle)
        }


    }

}