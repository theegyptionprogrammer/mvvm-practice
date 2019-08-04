package com.example.zashiotka.database

typealias SuccessCallback = (Boolean) -> Unit

interface IzashiotkaModle {

    fun addZashiotka(zashiotka: Zashiotka)
    fun getZashiotka() : ArrayList<Zashiotka>
    fun searchZashiotka(id : Int , callback: SuccessCallback)
    fun deleteZashiotka(zashiotka: Zashiotka , callback: SuccessCallback)
}