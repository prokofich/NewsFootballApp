package com.example.football.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.football.R
import com.example.football.model.item_tableItem
import kotlinx.android.synthetic.main.item_table.view.*

class TableAdapter():RecyclerView.Adapter<TableAdapter.TableViewHolder>() {

    var list = ArrayList<item_tableItem>()
    var country = ""


    class TableViewHolder(view: View): RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_table,parent,false)
        return TableViewHolder(view)
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        when(country){
           "Англия" -> {
               holder.itemView.id_item_table_number.text = (position+1).toString()
               holder.itemView.id_item_table_name.text = list[0].data.get(position+1)!!.Команда
               holder.itemView.id_item_table_game.text = list[0].data.get(position+1)!!.Игры.toString()
               holder.itemView.id_item_table_win.text = list[0].data.get(position+1)!!.В.toString()
               holder.itemView.id_item_table_draw.text = list[0].data.get(position+1)!!.Н.toString()
               holder.itemView.id_item_table_loss.text = list[0].data.get(position+1)!!.П.toString()
               holder.itemView.id_item_table_ball.text = list[0].data.get(position+1)!!.Мячи
               holder.itemView.id_item_table_points.text = list[0].data.get(position+1)!!.Очки.toString()
           }
            "Россия" -> {
                holder.itemView.id_item_table_number.text = (position+1).toString()
                holder.itemView.id_item_table_name.text = list[1].data.get(position+1)!!.Команда
                holder.itemView.id_item_table_game.text = list[1].data.get(position+1)!!.Игры.toString()
                holder.itemView.id_item_table_win.text = list[1].data.get(position+1)!!.В.toString()
                holder.itemView.id_item_table_draw.text = list[1].data.get(position+1)!!.Н.toString()
                holder.itemView.id_item_table_loss.text = list[1].data.get(position+1)!!.П.toString()
                holder.itemView.id_item_table_ball.text = list[1].data.get(position+1)!!.Мячи
                holder.itemView.id_item_table_points.text = list[1].data.get(position+1)!!.Очки.toString()
            }
            "Испания" -> {
                holder.itemView.id_item_table_number.text = (position+1).toString()
                holder.itemView.id_item_table_name.text = list[2].data.get(position+1)!!.Команда
                holder.itemView.id_item_table_game.text = list[2].data.get(position+1)!!.Игры.toString()
                holder.itemView.id_item_table_win.text = list[2].data.get(position+1)!!.В.toString()
                holder.itemView.id_item_table_draw.text = list[2].data.get(position+1)!!.Н.toString()
                holder.itemView.id_item_table_loss.text = list[2].data.get(position+1)!!.П.toString()
                holder.itemView.id_item_table_ball.text = list[2].data.get(position+1)!!.Мячи
                holder.itemView.id_item_table_points.text = list[2].data.get(position+1)!!.Очки.toString()
            }
            "Германия" -> {
                holder.itemView.id_item_table_number.text = (position+1).toString()
                holder.itemView.id_item_table_name.text = list[3].data.get(position+1)!!.Команда
                holder.itemView.id_item_table_game.text = list[3].data.get(position+1)!!.Игры.toString()
                holder.itemView.id_item_table_win.text = list[3].data.get(position+1)!!.В.toString()
                holder.itemView.id_item_table_draw.text = list[3].data.get(position+1)!!.Н.toString()
                holder.itemView.id_item_table_loss.text = list[3].data.get(position+1)!!.П.toString()
                holder.itemView.id_item_table_ball.text = list[3].data.get(position+1)!!.Мячи
                holder.itemView.id_item_table_points.text = list[3].data.get(position+1)!!.Очки.toString()
            }
        }

    }

    override fun getItemCount(): Int {
        when(country){
            "Англия" -> { return list[0].players_count }
            "Россия" -> { return list[1].players_count }
            "Испания" -> { return list[2].players_count }
            "Германия" -> { return list[3].players_count }
            else -> { return 0 }
        }

    }

    @JvmName("setList1")
    @SuppressLint("NotifyDataSetChanged")
    fun setList(listItem:ArrayList<item_tableItem>){
        list = listItem
        notifyDataSetChanged()
    }

    @JvmName("setCountry1")
    fun setCountry(Country:String){
        country = Country
    }


}