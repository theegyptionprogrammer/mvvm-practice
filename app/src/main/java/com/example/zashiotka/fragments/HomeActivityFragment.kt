package com.example.zashiotka.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zashiotka.R
import com.example.zashiotka.adapters.MainRVadapter
import com.example.zashiotka.database.ApplicationScope
import com.example.zashiotka.database.ZashiotkaModleView
import com.example.zashiotka.views.HomeStudentView
import kotlinx.android.synthetic.main.fragment_home_activity.*
import toothpick.Toothpick

class HomeActivityFragment : Fragment() {

    lateinit var moduleView : ZashiotkaModleView
    lateinit var contentview : HomeStudentView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toothpick.inject(this , ApplicationScope.scope)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home_activity, container , false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        update.setOnClickListener { getAll() }
        clear.setOnClickListener { clear() }


        main_recycler_view.layoutManager = LinearLayoutManager(context)
        val adapter = MainRVadapter(arrayListOf())
        main_recycler_view.adapter = adapter
    }

    private fun getAll(){
        moduleView.listZashiotkas.observe(this , Observer {
            notelist -> contentview.loadData(notelist)
        })
    }

    private fun clear(){
        moduleView = ViewModelProviders.of(this).get(ZashiotkaModleView::class.java)
    }

    companion object{
        fun newInstance() = HomeActivityFragment()
    }
}