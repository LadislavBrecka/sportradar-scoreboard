package com.sportradar.scoreboard

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TeamTest {

    @Test
    fun `Creating a team should create a team with a score 0 and a given name`() {
        val team = Team("REAL MADRID")
        assertEquals(team.name, "REAL MADRID")
        assertEquals(team.score, 0)
    }

    @Test
    fun `Scoring exactly one goal should update the score by one`() {
        val team = Team("REAL MADRID")
        team.score++
        assertEquals(team.score, 1)
    }

    @Test
    fun `Updating the score by n goals should update the score by n`() {
        val team = Team("REAL MADRID")
        team.score = 3
        assertEquals(team.score, 3)

        team.score += 2
        assertEquals(team.score, 5)
    }

    @Test
    fun `Updating initial score with negative value should do nothing to the score`() {
        val team = Team("REAL MADRID")
        team.score = -3
        assertEquals(team.score, 0)
    }

    @Test
    fun `Updating the score with smaller then actual value should do nothing to the score`() {
        val team = Team("REAL MADRID")
        team.score = 4
        assertEquals(team.score, 4)
        team.score = 2
        assertEquals(team.score, 4)
    }

    @Test
    fun `Updating non initial score with negative value should do nothing to the score`() {
        val team = Team("REAL MADRID")
        team.score = 4
        assertEquals(team.score, 4)
        team.score = -5
        assertEquals(team.score, 4)
    }
}