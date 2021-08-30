package com.mb.soccerleauge

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mb.soccerleauge.adapter.TeamListAdapter
import com.mb.soccerleauge.data.TeamDetail

val teamListadapter = TeamListAdapter()

@BindingAdapter("app:teams")
fun RecyclerView.teams(teamsList:List<TeamDetail>?){
    adapter = teamListadapter
    teamListadapter.submitList(teamsList.orEmpty())

}