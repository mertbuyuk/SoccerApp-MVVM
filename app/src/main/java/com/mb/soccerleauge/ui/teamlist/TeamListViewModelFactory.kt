package com.mb.soccerleauge.ui.teamlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TeamListViewModelFactory(private val repository: TeamListRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T  = TeamListViewModel(repository) as T
}