package com.sportradar.scoreboard

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GameTest {

    @Test
    fun `Creating a game should have initial total score zero`() {
        val game = Game(Team("REAL MADRID"), Team("BARCELONA"))

        assertEquals(game.homeTeam.name, "REAL MADRID")
        assertEquals(game.homeTeam.score, 0)

        assertEquals(game.awayTeam.name, "BARCELONA")
        assertEquals(game.awayTeam.score, 0)
    }

    @Test
    fun `Updating home team score should update only home team`() {
        val game = Game(Team("REAL MADRID"), Team("BARCELONA"))
        game.updateScore(4, 0)
        assertEquals(game.homeTeam.score, 4)
        assertEquals(game.awayTeam.score, 0)
    }

    @Test
    fun `Updating away team score should update only away team`() {
        val game = Game(Team("REAL MADRID"), Team("BARCELONA"))
        game.updateScore(0, 4)
        assertEquals(game.homeTeam.score, 0)
        assertEquals(game.awayTeam.score, 4)
    }

    @Test
    fun `Updating both teams score should update both teams`() {
        val game = Game(Team("REAL MADRID"), Team("BARCELONA"))
        game.updateScore(3, 1)
        assertEquals(game.homeTeam.score, 3)
        assertEquals(game.awayTeam.score, 1)
    }

    @Test
    fun `Updating home team score with negative values should not update any team`() {
        val game = Game(Team("REAL MADRID"), Team("BARCELONA"))
        game.updateScore(-2, 0)
        assertEquals(game.homeTeam.score, 0)
        assertEquals(game.awayTeam.score, 0)
    }

    @Test
    fun `Updating away team score with negative values should not update any team`() {
        val game = Game(Team("REAL MADRID"), Team("BARCELONA"))
        game.updateScore(0, -2)
        assertEquals(game.homeTeam.score, 0)
        assertEquals(game.awayTeam.score, 0)
    }

    @Test
    fun `Updating both teams score with negative values should not update any team`() {
        val game = Game(Team("REAL MADRID"), Team("BARCELONA"))
        game.updateScore(-2, -2)
        assertEquals(game.homeTeam.score, 0)
        assertEquals(game.awayTeam.score, 0)

        game.updateScore(2, 2)
        assertEquals(game.homeTeam.score, 2)
        assertEquals(game.awayTeam.score, 2)

        game.updateScore(-4, -4)
        assertEquals(game.homeTeam.score, 2)
        assertEquals(game.awayTeam.score, 2)
    }

    @Test
    fun `Updating both teams score with smaller values should not update any team`() {
        val game = Game(Team("REAL MADRID"), Team("BARCELONA"))
        game.updateScore(3, 3)
        assertEquals(game.homeTeam.score, 3)
        assertEquals(game.awayTeam.score, 3)

        game.updateScore(2, 1)
        assertEquals(game.homeTeam.score, 3)
        assertEquals(game.awayTeam.score, 3)
    }
}