package com.mb.soccerleauge.ui.teamlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mb.soccerleauge.data.TeamDetail
import com.mb.soccerleauge.teamListadapter
import com.mb.soccerleauge.ui.teamlist.TeamListRepository.TeamListResult.Failure
import com.mb.soccerleauge.ui.teamlist.TeamListRepository.TeamListResult.Succes
import com.mb.soccerleauge.ui.teamlist.TeamListRepository.TeamListResult.UnexpectedError
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TeamListViewModel(private val repository: TeamListRepository) : ViewModel() {
    private val _teams = MutableLiveData<List<TeamDetail>>()
    val teams : LiveData<List<TeamDetail>> = _teams

    init {
        fetchTeams()
    }

    private fun fetchTeams() = viewModelScope.launch {
        repository.fetchList().collect {
            when(it){
                Failure -> onFail()
                is Succes -> onSucces(it.teamList)
                UnexpectedError -> TODO()
            }
        }
    }

    private fun onSucces(teamList: List<TeamDetail>) {
        _teams.value = teamList
    }

    private fun onFail(){
        Log.i("ssss","failed")
    }
}