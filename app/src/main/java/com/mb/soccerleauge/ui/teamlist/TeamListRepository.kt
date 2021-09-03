package com.mb.soccerleauge.ui.teamlist


import com.mb.soccerleauge.api.api
import com.mb.soccerleauge.data.TeamDetail
import com.mb.soccerleauge.db.db
import com.mb.soccerleauge.sharedpref.SharedPref
import com.mb.soccerleauge.ui.teamlist.TeamListRepository.TeamListResult.Failure
import com.mb.soccerleauge.ui.teamlist.TeamListRepository.TeamListResult.Succes
import com.mb.soccerleauge.utils.Constant
import com.mb.soccerleauge.utils.toTeamDetailList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class TeamListRepository {

    suspend fun fetchList() : Flow<TeamListResult> = flow {

      val cachedTeamList = db.teamDao().getAllTeam()
        if (cachedTeamList.isNotEmpty()){
            emit(Succes(cachedTeamList.toTeamDetailList()))
        }

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
            else -> emit(Failure)
        }

    }

    sealed class TeamListResult(){
        class Succes(val teamList : List<TeamDetail>) : TeamListResult()
        object Failure : TeamListResult()
    }
}