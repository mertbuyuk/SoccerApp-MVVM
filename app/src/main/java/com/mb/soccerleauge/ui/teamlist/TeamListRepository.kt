package com.mb.soccerleauge.ui.teamlist

import android.util.Log
import com.mb.soccerleauge.api.api
import com.mb.soccerleauge.data.TeamDetail
import com.mb.soccerleauge.ui.teamlist.TeamListRepository.TeamListResult.Failure
import com.mb.soccerleauge.ui.teamlist.TeamListRepository.TeamListResult.Succes
import com.mb.soccerleauge.ui.teamlist.TeamListRepository.TeamListResult.UnexpectedError
import com.mb.soccerleauge.utils.Constant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class TeamListRepository {

    suspend fun fetchList() : Flow<TeamListResult> = flow {
        val response =
            try {
                api.getAllTeam(Constant.API_KEY)
            }catch (e : Exception){
                null
            }

        when(response?.code()){
            200 -> {
                emit(Succes(response.body()!!.list))
            }
            null -> emit(Failure)
            else -> emit(UnexpectedError)
        }

    }

    sealed class TeamListResult(){
        class Succes(val teamList : List<TeamDetail>) : TeamListResult()
        object Failure : TeamListResult()
        object UnexpectedError  : TeamListResult()
    }
}