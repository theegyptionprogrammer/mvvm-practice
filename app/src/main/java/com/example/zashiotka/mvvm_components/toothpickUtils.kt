package com.example.zashiotka.mvvm_components

import toothpick.Scope
import toothpick.Toothpick
import toothpick.config.Module

object ApplicationScope {
    val scope: Scope = Toothpick.openScope(this).apply {
        installModules(ApplicationModule)
    }
}

object ApplicationModule : Module(){
    init {
        bind(IZashiotkaModule::class.java).toInstance(ZashiotkaLocaleModule())
    }
}