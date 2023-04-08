package com.example.football.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.football.R
import com.example.football.blackThemes
import com.example.football.flagChangeBackground
import com.example.football.numberBackground
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.fragment_statistics.*
import kotlin.random.Random

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(flagChangeBackground){
            when(numberBackground){
                1 -> { id_fragment_settings.setBackgroundResource(R.drawable.background1)}
                2 -> { id_fragment_settings.setBackgroundResource(R.drawable.background2)}
                3 -> { id_fragment_settings.setBackgroundResource(R.drawable.background3) }
            }
        }

        if (blackThemes){
            id_settings_title.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            id_settings_notif.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            id_settings_black.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            id_settings_back.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            id_settings_button_change.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            id_settings_switch_black.isChecked = true
        }else{
            id_settings_title.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
            id_settings_notif.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
            id_settings_black.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
            id_settings_back.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
            id_settings_button_change.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
        }

        id_settings_button_change.setOnClickListener {

            flagChangeBackground = true
            var newNumberBackground = (1..3).random()

            if(newNumberBackground!= numberBackground){
                numberBackground = newNumberBackground
                when(numberBackground){
                    1 -> { id_fragment_settings.setBackgroundResource(R.drawable.background1)}
                    2 -> { id_fragment_settings.setBackgroundResource(R.drawable.background2)}
                    3 -> { id_fragment_settings.setBackgroundResource(R.drawable.background3)}
                }
            }else{

                while (newNumberBackground == numberBackground){
                    newNumberBackground = (1..3).random()
                }
                numberBackground = newNumberBackground
                when(numberBackground){
                    1 -> { id_fragment_settings.setBackgroundResource(R.drawable.background1)}
                    2 -> { id_fragment_settings.setBackgroundResource(R.drawable.background2)}
                    3 -> { id_fragment_settings.setBackgroundResource(R.drawable.background3)}
                }

            }

        }


        id_settings_switch_black.setOnCheckedChangeListener { compoundButton, b ->
            if(id_settings_switch_black.isChecked){
                blackThemes = true
                id_settings_title.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                id_settings_notif.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                id_settings_black.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                id_settings_back.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                id_settings_button_change.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            }else{
                blackThemes = false
                id_settings_title.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                id_settings_notif.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                id_settings_black.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                id_settings_back.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                id_settings_button_change.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
            }
        }

    }

}