package com.mb.soccerleauge.utils

import com.mb.soccerleauge.data.Fixture
import com.mb.soccerleauge.db.fixture.FixtureEntity

fun List<Fixture>.toFixtureEntityList() = map {
    it.toFixtureEntity()
}

fun Fixture.toFixtureEntity() = FixtureEntity(
    id = id,
    home = homeTeam,
    away = awayTeam,
    week = week
)

fun List<FixtureEntity>.toFixtureList() = map {
    it.toFixture()
}

fun FixtureEntity.toFixture() = Fixture(
    id = id,
    homeTeam = home,
    awayTeam = away,
    week = week
)


