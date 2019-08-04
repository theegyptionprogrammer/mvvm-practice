package com.example.zashiotka.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import android.widget.SearchView
import com.example.zashiotka.R
import com.example.zashiotka.adapters.MainRVadapter
import com.example.zashiotka.views.SearchStudentView
import kotlinx.android.synthetic.main.fragment_home_activity.view.*
import kotlinx.android.synthetic.main.fragment_search_activity.*

class SearchActivtiyFragment : Fragment()  {

    lateinit var searchView: SearchView
    private lateinit var contentview : SearchStudentView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search_activity, container , false )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        search_recycler_view.layoutManager = LinearLayoutManager(context)
        val adapter = MainRVadapter(arrayListOf())
        search_recycler_view.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {

        inflater?.inflate(R.menu.search_menu, menu)
        searchView = menu?.findItem(R.id.search_bar)?.actionView as SearchView
        searchView.isSubmitButtonEnabled
        super.onCreateOptionsMenu(menu, inflater)
    }

    companion object{
        fun newInstance() = SearchActivtiyFragment()
    }

}