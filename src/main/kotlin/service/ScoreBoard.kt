package service

import domain.Game

interface ScoreBoard {

    fun startGame(homeTeam: String, awayTeam: String)

    fun finishGame()

    fun update(score: Pair<Int, Int>)

    fun getGamesOrderedByTotalScore(): List<Game>
}