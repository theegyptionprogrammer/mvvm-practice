package com.example.zashiotka.views

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.example.zashiotka.adapters.SearchRVadapter
import kotlinx.android.synthetic.main.fragment_search_activity.view.*

class SearchStudentView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttribute: Int = 1
) : RelativeLayout(context , attributeSet , defStyleAttribute) {

    fun setcontentview(){
        search_recycler_view.layoutManager = LinearLayoutManager(context)
        val adapter = SearchRVadapter(arrayListOf())
        search_recycler_view.adapter = adapter
    }
}
