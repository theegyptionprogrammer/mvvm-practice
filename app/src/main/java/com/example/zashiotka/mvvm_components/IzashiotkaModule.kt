package com.example.zashiotka.mvvm_components

import com.example.zashiotka.database.Zashiotka

typealias SuccessCallback = (Boolean) -> Unit

interface IzashiotkaModle {

    fun addZashiotka(zashiotka: Zashiotka)
    fun getZashiotka() : ArrayList<Zashiotka>
    fun searchZashiotka(id : Int , callback: SuccessCallback)
    fun deleteZashiotka(zashiotka: Zashiotka, callback: SuccessCallback)
}