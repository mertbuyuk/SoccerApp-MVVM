package com.mb.soccerleauge.data

import com.google.gson.annotations.SerializedName

data class TeamResponse (
    @SerializedName("teams")
    val list : List<TeamDetail>
    )

data class TeamDetail(
    val id : Int,
    val shortName : String
) {

}

