package com.sportradar.scoreboard

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ScoreBoarTest {

    @Test
    fun `Creating scoreboard should create a empty scoreboard`() {
        val scoreboard = ScoreBoard(GameRepository())

        assertEquals(scoreboard.getAllGames(), emptyList())
    }

    @Test
    fun `Get all games should return all games in scoreboard`() {
        val scoreboard = ScoreBoard(GameRepository())

        assertEquals(scoreboard.getAllGames(), emptyList())
    }

    @Test
    fun `Starting game should store the game to scoreboard`() {
        val scoreBoard = ScoreBoard(GameRepository())
        val game = Game(
            Team("REAL MADRID"),
            Team("BARCELONA")
        )

        scoreBoard.startGame(game)
        assertEquals(scoreBoard.getAllGames().size, 1)
    }

    @Test
    fun `Starting multiple games should store games to the scoreboard in given order`() {
        val scoreBoard = ScoreBoard(GameRepository())
        val game1 = Game(
            Team("REAL MADRID"),
            Team("BARCELONA")
        )
        val game2 = Game(
            Team("LIVERPOOL"),
            Team("MANCHESTER UNITED")
        )

        scoreBoard.startGamesOrdered(listOf(game1, game2))
        assertEquals(scoreBoard.getAllGames().size, 2)
    }

    @Test
    fun `Finishing game should remove the game from the scoreboard`() {
        val scoreBoard = ScoreBoard(GameRepository())
        val game = Game(
            Team("REAL MADRID"),
            Team("BARCELONA")
        )

        scoreBoard.startGame(game)
        scoreBoard.finishGame(game)
        assertEquals(scoreBoard.getAllGames().size, 0)
    }

    @Test
    fun `Finishing multiple games should remove selected games from scoreboard`() {
        val scoreBoard = ScoreBoard(GameRepository())
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

        scoreBoard.startGamesOrdered(listOf(game1, game2, game3))
        scoreBoard.finishGames(listOf(game1, game2))
        assertEquals(scoreBoard.getAllGames().size, 1)
    }

    @Test
    fun `Updating game score should update the score of the teams`() {
        val scoreBoard = ScoreBoard(GameRepository())
        val game1 = Game(
            Team("REAL MADRID"),
            Team("BARCELONA")
        )
        val game2 = Game(
            Team("LIVERPOOL"),
            Team("MANCHESTER UNITED")
        )

        scoreBoard.startGamesOrdered(listOf(game1, game2))

        // sorry if you are fan of Barcelona or Manchester United, but I'm fan of the opposites
        scoreBoard.updateGameScore(game1, 2, 1)  // !HALA MADRID!
        scoreBoard.updateGameScore(game2, 3, 0)  // YNWA!

        val games = scoreBoard.getAllGames()

        // test if number of games is not changed
        assertEquals(games.size, 2)

        // game 1 test
        assertEquals(games[0].homeTeam.score, 2)
        assertEquals(games[0].awayTeam.score, 1)

        // game 2 test
        assertEquals(games[1].homeTeam.score, 3)
        assertEquals(games[1].awayTeam.score, 0)
    }

    @Test
    fun `Get games in progress summary should return all games in progress ordered by total score`() {
        val scoreBoard = ScoreBoard(GameRepository())
        val game1 = Game(Team("MEXICO"), Team("CANADA"))
        val game2 = Game(Team("SPAIN"), Team("BRAZIL"))
        val game3 = Game(Team("GERMANY"), Team("FRANCE"))
        val game4 = Game(Team("URUGUAY"), Team("ITALY"))
        val game5 = Game(Team("ARGENTINA"), Team("AUSTRALIA"))

        scoreBoard.startGamesOrdered(listOf(game1, game2, game3, game4, game5))

        scoreBoard.updateGameScore(game1, 0, 5)
        scoreBoard.updateGameScore(game2, 10, 2)
        scoreBoard.updateGameScore(game3, 2, 2)
        scoreBoard.updateGameScore(game4, 6, 6)
        scoreBoard.updateGameScore(game5, 3, 1)

        val gamesSummary = scoreBoard.getGamesInProgressSummary()

        assertEquals(gamesSummary[0], game4)
        assertEquals(gamesSummary[1], game2)
        assertEquals(gamesSummary[2], game1)
        assertEquals(gamesSummary[3], game5)
        assertEquals(gamesSummary[4], game3)
    }
}