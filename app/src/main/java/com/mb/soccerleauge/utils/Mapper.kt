package com.mb.soccerleauge.utils

import com.mb.soccerleauge.data.TeamDetail
import com.mb.soccerleauge.db.team.TeamEntity

fun List<TeamEntity>.toTeamDetailList() = map {
    it.toTeamDetail()
}

fun List<TeamDetail>.toTeamEntityList() = map {
    it.toTeamEntity()
}

fun TeamEntity.toTeamDetail() = TeamDetail(
    id = id,
    shortName = shortName
)

fun TeamDetail.toTeamEntity() = TeamEntity(
    id = id,
    shortName = shortName
)