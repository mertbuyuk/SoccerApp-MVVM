package com.mb.soccerleauge.api

import com.mb.soccerleauge.data.Team
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SoccerLeaugeApi {

    @GET("search_all_teams.php")
    fun getAllTeamByLeague(@Query("1") name: String?): Response<List<Team>>
}