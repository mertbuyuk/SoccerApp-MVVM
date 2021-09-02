package com.mb.soccerleauge.ui.teamlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mb.soccerleauge.data.Fixture
import com.mb.soccerleauge.data.TeamDetail
import com.mb.soccerleauge.db.db
import com.mb.soccerleauge.ui.teamlist.TeamListRepository.TeamListResult.Failure
import com.mb.soccerleauge.ui.teamlist.TeamListRepository.TeamListResult.Succes
import com.mb.soccerleauge.utils.toFixtureEntityList
import com.mb.soccerleauge.utils.toFixtureList
import com.mb.soccerleauge.utils.toTeamEntityList
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch



class TeamListViewModel(private val repository: TeamListRepository) : ViewModel() {
    private val _teams = MutableLiveData<List<TeamDetail>>()
    val teams : LiveData<List<TeamDetail>> = _teams

    private val _fixture = MutableLiveData<List<Fixture>>()
    val fixture : LiveData<List<Fixture>> = _fixture

    init {
        fetchTeams()
    }

    private fun fetchTeams() = viewModelScope.launch {
        repository.fetchList().collect {
            when(it){
                Failure -> onFail()
                is Succes -> onSucces(it.teamList)
            }
        }
    }

    private suspend fun onSucces(teamList: List<TeamDetail>) {
        _teams.value = teamList
        db.teamDao().insertAll(teamList.toTeamEntityList())
    }

    private fun onFail(){

    }
    private fun checkList() : ArrayList<TeamDetail> {
        var shuffledList = teams.value?.shuffled()
        Log.i("checklisssst", shuffledList.toString())
        if (shuffledList?.size!! % 2 == 1){
            shuffledList = shuffledList?.drop(1)
        }
        return (shuffledList as ArrayList<TeamDetail>?)!!
    }

      fun createFixture() : ArrayList<Fixture>{

        var listRaw = checkList()
        val fixtureList : ArrayList<Fixture> = arrayListOf()
        var newList  : ArrayList<TeamDetail> = arrayListOf()
        val round = teams.value!!.size-1
        val matchInRound = teams.value!!.size/2
        var idCount = 0
        for(i in 0..round){
            for(j in 0..matchInRound-1){
                val team1 = listRaw[j].shortName
                val team2 = listRaw[teams.value!!.size-1-j].shortName
                val fixtureVariable = Fixture(idCount,team1, team2,i+1)
                fixtureList.add(fixtureVariable)
                idCount++
            }

            newList.add(listRaw[0])
            newList.add(listRaw[listRaw.size-1])

            for(i in 1..listRaw.size-1){
                newList.add(listRaw.get(i))
            }

            listRaw = newList
        }
          viewModelScope.launch {
              db.fixtureDao().insertFixture(fixtureList.toFixtureEntityList())
          }

         return fixtureList

    }

    fun getByWeek(week : Int) : List<Fixture> {
        var list : List<Fixture> = arrayListOf()
        viewModelScope.launch {
           list =  db.fixtureDao().getByWeek(week).toFixtureList()
        }
        return list
    }
}