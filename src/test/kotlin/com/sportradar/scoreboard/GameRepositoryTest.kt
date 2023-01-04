package com.sportradar.scoreboard

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class GameRepositoryTest {

    @Test
    fun `Get all games should return all games in repository`() {
        val gameRepository = GameRepository()
        val game1 = Game(
            Team("REAL MADRID"),
            Team("BARCELONA")
        )
        val game2 = Game(
            Team("LIVERPOOL"),
            Team("MANCHESTER UNITED")
        )

        gameRepository.saveGames(listOf(game1, game2))
        val foundGame = gameRepository.getAllGames()

        assertNotNull(foundGame)
        assertEquals(foundGame.size, 2)
    }

    @Test
    fun `Get game by the id should return the game with correct id`() {
        val gameRepository = GameRepository()
        val game1 = Game(
            Team("REAL MADRID"),
            Team("BARCELONA")
        )
        val game2 = Game(
            Team("LIVERPOOL"),
            Team("MANCHESTER UNITED")
        )

        gameRepository.saveGames(listOf(game1, game2))
        val foundGame = gameRepository.getGameById(game1.id)

        assertNotNull(foundGame)
        assertEquals(foundGame, game1)
    }

    @Test
    fun `Insert game should persist the game to the repository`() {
        val gameRepository = GameRepository()
        val game = Game(
            Team("REAL MADRID"),
            Team("BARCELONA")
        )

        gameRepository.saveGame(game)
        assertEquals(gameRepository.getAllGames().size, 1)
    }

    @Test
    fun `Insert same game twice should persist the game only once to the repository`() {
        val gameRepository = GameRepository()
        val game = Game(
            Team("REAL MADRID"),
            Team("BARCELONA")
        )

        gameRepository.saveGame(game)
        gameRepository.saveGame(game)
        assertEquals(gameRepository.getAllGames().size, 1)
    }

    @Test
    fun `Insert multiple games should persist all games to the repository`() {
        val gameRepository = GameRepository()
        val game1 = Game(
            Team("REAL MADRID"),
            Team("BARCELONA")
        )
        val game2 = Game(
            Team("LIVERPOOL"),
            Team("MANCHESTER UNITED")
        )

        gameRepository.saveGames(listOf(game1, game2))
        assertEquals(gameRepository.getAllGames().size, 2)
    }

    @Test
    fun `Delete game should delete desired game from repository`() {
        val gameRepository = GameRepository()
        val game1 = Game(
            Team("REAL MADRID"),
            Team("BARCELONA")
        )
        val game2 = Game(
            Team("LIVERPOOL"),
            Team("MANCHESTER UNITED")
        )

        gameRepository.saveGames(listOf(game1, game2))
        gameRepository.removeGame(game1)

        assertEquals(gameRepository.getAllGames().size, 1)
        assertEquals(gameRepository.getGameById(game2.id), game2)
    }

    @Test
    fun `Delete multiple games should delete selected games from repository`() {
        val gameRepository = GameRepository()
        val game1 = Game(
            Team("REAL MADRID"),
            Team("BARCELONA")
        )
        val game2 = Game(
            Team("LIVERPOOL"),
            Team("MANCHESTER UNITED")
        )
        val game3 = Game(
            Team("CHELSEA"),
            Team("MANCHESTER CITY")
        )

        gameRepository.saveGames(listOf(game1, game2, game3))
        gameRepository.removeGames(listOf(game1, game2))

        assertEquals(gameRepository.getAllGames().size, 1)
    }
}