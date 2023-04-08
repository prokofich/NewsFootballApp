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
import com.example.football.adapter.TableAdapter
import com.example.football.blackThemes
import com.example.football.flagChangeBackground
import com.example.football.numberBackground
import com.example.football.viewmodel.TableViewModel
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.fragment_statistics.*
import kotlinx.android.synthetic.main.fragment_table.*

class TableFragment : Fragment() {

    lateinit var recyclerViewTable: RecyclerView
    lateinit var adapterTable: TableAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_table, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val country = arguments?.getString("COUNTRY")
        id_strana_title.text = country


        if(flagChangeBackground){
            when(numberBackground){
                1 -> { id_fragment_table.setBackgroundResource(R.drawable.background1)}
                2 -> { id_fragment_table.setBackgroundResource(R.drawable.background2)}
                3 -> { id_fragment_table.setBackgroundResource(R.drawable.background3) }
            }
        }

        if(blackThemes){
            id_strana_title.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
        }else{
            id_strana_title.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
        }

        val viewModelTable = ViewModelProvider(this)[TableViewModel::class.java]

        recyclerViewTable = id_rv_table
        adapterTable = TableAdapter()
        recyclerViewTable.adapter = adapterTable

        viewModelTable.getTable()
        viewModelTable.Table.observe(viewLifecycleOwner){ list ->
            list.body().let{ adapterTable.setList(it!!) }
            adapterTable.setCountry(country!!)
            //Toast.makeText(requireContext(),"${adapterTable.getList()}",Toast.LENGTH_SHORT).show()
        }





    }

}