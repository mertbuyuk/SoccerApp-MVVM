package com.mb.soccerleauge.api

import com.mb.soccerleauge.data.TeamResponse
import com.mb.soccerleauge.utils.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface SoccerLeaugeApi {

    @GET(Constant.GET_ALL_TEAMS)
    suspend fun getAllTeam(@Header("X-Auth-Token") key : String): Response<TeamResponse>


}