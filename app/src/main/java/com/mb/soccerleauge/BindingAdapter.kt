package com.mb.soccerleauge

import androidx.databinding.BindingAdapter

import androidx.recyclerview.widget.RecyclerView
import com.mb.soccerleauge.ui.adapter.TeamListAdapter
import com.mb.soccerleauge.data.TeamDetail
import androidx.recyclerview.widget.ListAdapter
import com.mb.soccerleauge.data.Fixture
import com.mb.soccerleauge.ui.adapter.NextFixtureAdapter

val teamListadapter = TeamListAdapter()

@BindingAdapter("app:teams")
fun RecyclerView.teams(teamsList:List<TeamDetail>?) {

    adapter = teamListadapter
    teamListadapter.submitList(teamsList.orEmpty())

}

val nextFixtureAdapter = NextFixtureAdapter(arrayListOf())

@BindingAdapter("app:nextFixture")
fun RecyclerView.nextFixture(list: ArrayList<Fixture>?) {

    adapter = nextFixtureAdapter

    nextFixtureAdapter.submitList(list.orEmpty())

}