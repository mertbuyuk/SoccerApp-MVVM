package com.mb.soccerleauge

import android.app.Application
import com.mb.soccerleauge.api.generateApi
import com.mb.soccerleauge.db.createDatabase

class SoccerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        generateApi(this)
        createDatabase(this)
    }
}