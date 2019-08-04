package com.example.zashiotka.mvvm_components

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.example.zashiotka.adapters.MainRVadapter
import com.example.zashiotka.database.Zashiotka

class HomeStudentView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttribute: Int = 1
) : RelativeLayout(context , attributeSet , defStyleAttribute){

    lateinit var adapter : MainRVadapter


    fun loadData(listZashiotkas: ArrayList<Zashiotka>?){
        adapter.update(listZashiotkas)
    }

}