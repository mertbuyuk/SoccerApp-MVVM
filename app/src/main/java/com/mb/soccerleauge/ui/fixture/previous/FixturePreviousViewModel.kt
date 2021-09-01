package com.mb.soccerleauge.ui.fixture.previous

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mb.soccerleauge.data.Fixture
import com.mb.soccerleauge.data.TeamDetail
import com.mb.soccerleauge.db.db
import com.mb.soccerleauge.db.team.TeamEntity

class FixturePreviousViewModel() : ViewModel() {
    private val _teams = MutableLiveData<List<TeamEntity>>()
    val teams : LiveData<List<TeamEntity>> = _teams

    suspend fun getTeams() {
        _teams.value = db.teamDao().getAllTeam()
    }

    fun checkList() : List<TeamEntity>{
        var teamList = teams.value?.shuffled()
        if (teams.value!!.size!! % 2 == 1){
            teamList = teamList?.drop(1)
        }

        return teamList!!
    }

    fun previousFixture() : ArrayList<Fixture>{
        val teamList = checkList()
        val fixtureList : ArrayList<Fixture> = arrayListOf()
        for (i in teamList.indices step 2){
            val fixtureVariable = Fixture(teamList[i].shortName,teamList[i+1].shortName)
            fixtureList.add(fixtureVariable)
        }

        return fixtureList
    }




}