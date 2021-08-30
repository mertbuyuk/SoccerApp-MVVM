package com.mb.soccerleauge.db.team

import androidx.room.Dao
import androidx.room.Query
import com.mb.soccerleauge.data.TeamDetail

@Dao
interface TeamDao {

    @Query("SELECT * FROM team ")
    suspend fun getAllTeam() : List<TeamEntity>
}