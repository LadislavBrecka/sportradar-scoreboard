package com.sportradar.scoreboard

class GameRepository(
    private val games: MutableList<Game> = mutableListOf()
) {

    fun getAllGames(): List<Game> {
        return games
    }

    fun getGameById(uuid: String): Game? {
        TODO()
    }

    fun saveGame(game: Game): String {
        TODO()
    }

    fun saveGames(games: List<Game>) {
        TODO()
    }

    fun removeGame(game: Game): Boolean {
        TODO()
    }

    fun removeGames(game: List<Game>): Boolean {
        TODO()
    }
}