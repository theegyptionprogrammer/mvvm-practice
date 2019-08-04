package com.example.zashiotka.database
import javax.inject.Inject


class ZashiotkaLocalModel @Inject constructor() : IzashiotkaModle {

    private var db = ZashiotkaDatabase.getInsance(ZashiotkaApplication.instance.applicationContext)

    override fun getZashiotka(): ArrayList<Zashiotka> = db!!.zashiotkaDao().getAll()

    override fun addZashiotka(zashiotka: Zashiotka) {
        db!!.zashiotkaDao().insert(zashiotka)
    }

    override fun searchZashiotka(id: Int, callback: SuccessCallback) {
        db!!.zashiotkaDao().search(id)
        callback.invoke(true)
    }

    override fun deleteZashiotka(zashiotka: Zashiotka, callback: SuccessCallback) {

    }
}