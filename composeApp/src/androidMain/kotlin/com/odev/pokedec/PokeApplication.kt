package com.odev.pokedec

import android.app.Application
import modules.KoinInitializer

class PokeApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()
    }

}