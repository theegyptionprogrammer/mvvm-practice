package com.example.zashiotka.mvvm_components

import com.example.zashiotka.roomDB.Zashiotka
import com.example.zashiotka.roomDB.ZashiotkaDatabase
import com.example.zashiotka.roomDB.application
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import javax.inject.Inject

const val TIMEOUT_DURATION_MILLIS = 3000L

class ZashiotkaLocaleModule @Inject constructor() : IZashiotkaModule  {

    private var databaseZashiotka = ZashiotkaDatabase.getInstance(application.instance.applicationContext)

    private fun performOperationWithTimeout(function: ()-> Unit , callback: SuccessCallback ){
        GlobalScope.launch {
            val job = async {
                try {
                    withTimeout(TIMEOUT_DURATION_MILLIS){
                        function.invoke()
                    }
                } catch (e: java.lang.Exception) {
                    callback.invoke(false)
                }
            }
            job.await()
            callback.invoke(true)
        }
    }

    override fun insert(zashiotka: Zashiotka, callback: SuccessCallback) {
        performOperationWithTimeout({databaseZashiotka!!.zashiotkaDao().insertZashiotka(zashiotka)}, callback)
    }

    override fun retriviveData(callback : (List<Zashiotka>?) -> Unit) {
        GlobalScope.launch {
            val job = async {

                withTimeout(TIMEOUT_DURATION_MILLIS){
                    databaseZashiotka!!.zashiotkaDao().getAllZashiotkas()
                }
            }
            callback.invoke(job.await())
        }
    }

}