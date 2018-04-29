package it.sileo.associazionelucana.utils

import android.app.Application


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        VolleyService.initialize(this)
    }
}