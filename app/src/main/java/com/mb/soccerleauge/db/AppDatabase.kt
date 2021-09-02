package com.mb.soccerleauge.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mb.soccerleauge.db.fixture.FixtureDao
import com.mb.soccerleauge.db.fixture.FixtureEntity
import com.mb.soccerleauge.db.team.TeamDao
import com.mb.soccerleauge.db.team.TeamEntity

@Database(entities = [TeamEntity::class,FixtureEntity::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun teamDao() : TeamDao
    abstract fun fixtureDao() : FixtureDao

}