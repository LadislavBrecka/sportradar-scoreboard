package com.sportradar.scoreboard

data class Team(val name: String = "") {

    var score: Int = 0
        set(value) {
            if (value > score)
                field = value
        }
}
