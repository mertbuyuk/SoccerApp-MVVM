package com.mb.soccerleauge.db.fixture

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fixture")
data class FixtureEntity(
    @PrimaryKey val id : Int,
    val home: String,
    val away: String,
    val week: Int

)