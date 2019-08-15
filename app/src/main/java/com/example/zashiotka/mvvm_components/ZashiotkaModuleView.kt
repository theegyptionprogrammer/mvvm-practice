package com.example.zashiotka.mvvm_components

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.zashiotka.roomDB.Zashiotka
import toothpick.Toothpick
import javax.inject.Inject

class ZashiotkaModuleView {

    @Inject
    lateinit var module: IZashiotkaModule

    private val _mutableListData : MutableLiveData<List<Zashiotka>> = MutableLiveData()
    val mutableListData : LiveData<List<Zashiotka>> = _mutableListData

    init {
        Toothpick.inject(this, ApplicationScope.scope)
        loadData()
    }

    private fun loadData(){
        module.retriviveData {nullableList ->
            nullableList.let {
                _mutableListData.postValue(it)
            }
        }
    }
}