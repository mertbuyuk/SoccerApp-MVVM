package com.mb.soccerleauge.db.fixture

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.mb.soccerleauge.data.Fixture
import com.mb.soccerleauge.ui.fixture.weekFixture.WeekFixtureFragment

@Dao
interface FixtureDao {

    @Query("SELECT * FROM fixture where week = :week")
    suspend fun getByWeek(week : Int) : List<FixtureEntity>

    @Insert(onConflict = REPLACE)
    suspend fun insertFixture(list : List<FixtureEntity>)
}