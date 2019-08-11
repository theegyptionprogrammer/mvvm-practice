package com.example.zashiotka.mvvm_components

import com.example.zashiotka.roomDB.Zashiotka

typealias SuccessCallback = (Boolean) -> Unit

interface IZashiotkaModule {

    fun insert(zashiotka: Zashiotka , callback: SuccessCallback)
    fun retriviveData() : MutableList<Zashiotka>
}