package com.sportradar.scoreboard

class ScoreBoard(
    val gameRepository: GameRepository
) {

    fun startGame(game: Game): Boolean {
        TODO()
    }

    fun startGamesOrdered(games: List<Game>): Boolean {
        TODO()
    }

    fun finishGame(game: Game): Boolean {
        TODO()
    }

    fun finishGames(games: List<Game>): Boolean {
        TODO()
    }

    fun getAllGames(): List<Game> {
        TODO()
    }

    fun updateGameScore(game: Game, homeTeamScore: Int, awayTeamScore: Int) {
        TODO()
    }

    fun getGamesInProgressSummary(): List<Game> {
        TODO()
    }

}
