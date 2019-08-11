package com.example.zashiotka.mvvm_components

import com.example.zashiotka.roomDB.Zashiotka
import com.example.zashiotka.roomDB.ZashiotkaDatabase
import com.example.zashiotka.roomDB.application
import javax.inject.Inject

class ZashiotkaLocaleModule @Inject constructor() : IZashiotkaModule  {

    private var databaseZashiotka = ZashiotkaDatabase.getInstance(application.instance.applicationContext)

    override fun insert(zashiotka: Zashiotka, callback: SuccessCallback) {
        databaseZashiotka!!.zashiotkaDao().insertZashiotka(zashiotka)
        callback.invoke(true)
    }

    override fun retriviveData(): MutableList<Zashiotka> = databaseZashiotka!!.zashiotkaDao().getAllZashiotkas()

}