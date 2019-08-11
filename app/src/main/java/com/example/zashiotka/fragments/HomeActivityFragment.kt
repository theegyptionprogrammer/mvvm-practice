package com.example.zashiotka.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zashiotka.R
import com.example.zashiotka.adapters.MainRVadapter
import kotlinx.android.synthetic.main.fragment_home_activity.*

class HomeActivityFragment : Fragment() {

    private lateinit var adapter : MainRVadapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home_activity , container , false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MainRVadapter()
        main_recycler_view.layoutManager = LinearLayoutManager(context)
        main_recycler_view.adapter = adapter
    }

    companion object{
        fun newInstance() = HomeActivityFragment()
    }
}