package com.sportradar.scoreboard

import java.util.*

class Game(val homeTeam: Team,
           val awayTeam: Team,
           var id: String = UUID.randomUUID().toString()) {
    fun updateScore(homeTeamScore: Int, awayTeamScore: Int) {
        homeTeam.score = homeTeamScore
        awayTeam.score = awayTeamScore
    }
}
