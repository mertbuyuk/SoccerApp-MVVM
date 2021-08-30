package com.mb.soccerleauge.db

import android.content.Context
import androidx.room.Room

private var _db : AppDatabase? = null

val db: AppDatabase get() = _db!!

// Accessing this will crash if done before calling createDatabase()
fun createDatabase(context: Context){
    if (_db != null) return

    _db = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "app-db"
    ).build()
}