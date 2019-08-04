package com.example.zashiotka.database

import android.app.Application

class ZashiotkaApplication : Application(){

    companion object {
        lateinit var instance: ZashiotkaApplication
    }

    init {
        instance = this
    }
}