package com.sportradar.scoreboard

class GameRepository(
    private val games: MutableList<Game> = mutableListOf()
) {

    fun getAllGames(): List<Game> {
        return games
    }

    fun getGameById(uuid: String): Game? {
        return games.find { it.id == uuid }
    }

    fun saveGame(game: Game) {
        // if game will same id already exists, remove old one first
        val existingGame = getGameById(game.id)
        if (existingGame != null) { removeGame(existingGame) }
        games.add(game)
    }

    fun saveGames(games: List<Game>) {
        games.forEach { saveGame(it) }
    }

    fun removeGame(game: Game) {
        games.remove(game)
    }

    fun removeGames(games: List<Game>) {
        games.forEach { removeGame(it) }
    }
}