package com.example.zashiotka.database

import toothpick.Toothpick
import toothpick.config.Module

object ApplicationScope{
    val scope = Toothpick.openScope(this).apply {
        installModules(ApplicationModule)
    }
}

object ApplicationModule : Module(){
    init {
        bind(IzashiotkaModle::class.java).toInstance(ZashiotkaLocalModel())
    }
}