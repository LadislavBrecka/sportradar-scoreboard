package com.sportradar.scoreboard

import java.time.LocalTime
import java.util.*

data class Game(
    val homeTeam: Team,
    val awayTeam: Team,
    val startTime: LocalTime = LocalTime.now(),
    var id: String = UUID.randomUUID().toString()) {

    fun updateScore(homeTeamScore: Int, awayTeamScore: Int) {
        homeTeam.score = homeTeamScore
        awayTeam.score = awayTeamScore
    }
}
