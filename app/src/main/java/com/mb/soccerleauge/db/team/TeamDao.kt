package com.mb.soccerleauge.db.team

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.mb.soccerleauge.data.TeamDetail

@Dao
interface TeamDao {

    @Query("SELECT * FROM team ")
    suspend fun getAllTeam() : List<TeamEntity>

    @Insert(onConflict = REPLACE)
    suspend fun insertAll(list : List<TeamEntity>)
}