package com.mb.soccerleauge.data

import androidx.room.PrimaryKey

data class Fixture(
    val id : Int,
    val homeTeam : String,
    val awayTeam : String,
    val week : Int
)