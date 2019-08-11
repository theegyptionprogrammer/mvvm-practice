package com.example.zashiotka.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zashiotka.R
import com.example.zashiotka.roomDB.Zashiotka
import kotlinx.android.synthetic.main.zashiotka.view.*

class MainRVadapter(private var listItems : MutableList<Zashiotka> = arrayListOf()) : RecyclerView.Adapter<MainRVadapter.viewHolder>() {

    fun update(listItems: MutableList<Zashiotka>){
        listItems.addAll(this.listItems)
        notifyDataSetChanged()
    }

    fun deleteAll(){
        listItems.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): viewHolder {
        return viewHolder(LayoutInflater.from(parent.context).inflate(R.layout.zashiotka , parent , false))
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {holder.onBind(listItems[position])}

    class viewHolder(val view: View) : RecyclerView.ViewHolder(view){

        fun onBind(zashiotka: Zashiotka) {
            view.studentIdTV.text = zashiotka.studentId.toString()
            view.studentNameTV.text = zashiotka.studentName
            view.englishTV.text = zashiotka.englishSubject.toString()
            view.informaticsTV.text = zashiotka.informaticsSubject.toString()
        }
    }
}