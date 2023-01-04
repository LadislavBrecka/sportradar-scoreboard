package com.sportradar.scoreboard

class ScoreBoard(
    private val gameRepository: GameRepository
) {

    fun getAllGames(): List<Game> {
        return gameRepository.getAllGames()
    }

    fun startGame(game: Game) {
        gameRepository.saveGame(game)
    }

    fun startGamesOrdered(games: List<Game>) {
        gameRepository.saveGames(games)
    }

    fun finishGame(game: Game) {
        gameRepository.removeGame(game)
    }

    fun finishGames(games: List<Game>) {
        gameRepository.removeGames(games)
    }

    fun updateGameScore(game: Game, homeTeamScore: Int, awayTeamScore: Int) {
        game.updateScore(homeTeamScore, awayTeamScore)
        gameRepository.saveGame(game)
    }

    fun getGamesInProgressSummary(): List<Game> {
        return getAllGames()
            .sortedWith(
                compareByDescending<Game> { it.homeTeam.score + it.awayTeam.score }
                    .thenByDescending { it.startTime }
            )
    }

}