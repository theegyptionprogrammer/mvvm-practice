package com.example.zashiotka.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zashiotka.R
import com.example.zashiotka.database.Zashiotka
import kotlinx.android.synthetic.main.zashiotka.view.*

class SearchRVadapter(private var listItems : ArrayList<Zashiotka> = arrayListOf()) : RecyclerView.Adapter<SearchRVadapter.viewHolder>(){

    fun update(listItems: ArrayList<Zashiotka>){
        listItems.clear()
        listItems.addAll(this.listItems)
        notifyDataSetChanged()
    }

    fun deleteAll(){
        listItems.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent : ViewGroup, position: Int): viewHolder {
        return viewHolder(LayoutInflater.from(parent.context).inflate(R.layout.zashiotka , parent , false))
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {holder.onBind(listItems[position])}

    class viewHolder(val view: View) : RecyclerView.ViewHolder(view){

        fun onBind(zashiotka: Zashiotka) {
          //  view.studentIdTV.text = zashiotka.idStudent.toString()
            view.studentNameTV.text = zashiotka.nameStudent
            view.englishTV.text = zashiotka.english.toString()
            view.informaticsTV.text = zashiotka.informatics.toString()

        }

    }
}