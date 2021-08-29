package com.mb.soccerleauge

import android.app.Application
import com.mb.soccerleauge.api.generateApi

class SoccerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        generateApi(this)
    }
}