package com.mb.soccerleauge

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mb.soccerleauge.ui.adapter.TeamListAdapter
import com.mb.soccerleauge.data.TeamDetail

val teamListadapter = TeamListAdapter()

@BindingAdapter("app:teams")
fun RecyclerView.teams(teamsList:List<TeamDetail>?){
    adapter = teamListadapter
    teamListadapter.submitList(teamsList.orEmpty())

}