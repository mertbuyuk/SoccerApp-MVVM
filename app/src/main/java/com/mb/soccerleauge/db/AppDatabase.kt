package com.mb.soccerleauge.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mb.soccerleauge.db.team.TeamDao
import com.mb.soccerleauge.db.team.TeamEntity

@Database(entities = [TeamEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun teamDao() : TeamDao
}