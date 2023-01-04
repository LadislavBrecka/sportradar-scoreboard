package com.sportradar.scoreboard

class Game(val homeTeam: Team,
           val awayTeam: Team) {
    fun updateScore(homeTeamScore: Int, awayTeamScore: Int) {
        homeTeam.score = homeTeamScore
        awayTeam.score = awayTeamScore
    }
}
