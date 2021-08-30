package com.mb.soccerleauge.ui.teamlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mb.soccerleauge.data.TeamDetail
import com.mb.soccerleauge.ui.teamlist.TeamListRepository.TeamListResult.Failure
import com.mb.soccerleauge.ui.teamlist.TeamListRepository.TeamListResult.Succes
import com.mb.soccerleauge.ui.teamlist.TeamListRepository.TeamListResult.UnexpectedError
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TeamListViewModel(private val repository: TeamListRepository) : ViewModel() {
    private val _teams = MutableLiveData<List<TeamDetail>>()
    val teams : LiveData<List<TeamDetail>> = _teams

    private fun fetchTeams() = viewModelScope.launch {
        repository.fetchList().collect {
            when(it){
                Failure -> TODO()
                is Succes -> onSucces(it.teams)
                UnexpectedError -> TODO()
            }
        }
    }

    private fun onSucces(teams: List<TeamDetail>) {
        _teams.postValue(teams)
    }
}