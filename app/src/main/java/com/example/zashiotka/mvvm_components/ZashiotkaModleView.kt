package com.example.zashiotka.mvvm_components

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.zashiotka.database.Zashiotka
import toothpick.Toothpick
import javax.inject.Inject

class ZashiotkaModleView : ViewModel(){

    @Inject
    lateinit var model : IzashiotkaModle

    private val _listZashiotkas : MutableLiveData<ArrayList<Zashiotka>> = MutableLiveData()
    val listZashiotkas : MutableLiveData<ArrayList<Zashiotka>> = _listZashiotkas

    init {
        Toothpick.inject(this , ApplicationScope.scope)
        getdata()
    }

    fun getdata(){
        listZashiotkas.postValue(model.getZashiotka())
    }

}