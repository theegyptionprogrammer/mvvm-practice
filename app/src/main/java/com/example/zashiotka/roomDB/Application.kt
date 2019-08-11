package com.example.zashiotka.roomDB

import android.app.Application

class application : Application() {

    companion object {
        lateinit var instance: Application
    }

    init {
        instance = this
    }

}