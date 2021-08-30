package com.mb.soccerleauge.db.team

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team")
data class TeamEntity(
    @PrimaryKey val id : Int,
    val shortName : String
)