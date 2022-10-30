package service

interface ScoreBoard {

    fun startGame()

    fun finishGame()

    fun update()

    fun getGamesOrderedByTotalScore()
}