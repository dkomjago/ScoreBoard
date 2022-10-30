package service

import domain.Game

class FootballWordCupScoreBoard : ScoreBoard {

    internal var currentGame: Game? = null
    internal val archive: MutableSet<Game> = sortedSetOf()

    override fun startGame(homeTeam: String, awayTeam: String) {
        //TODO
    }

    override fun finishGame() {
        //TODO
    }

    override fun update(score: Pair<Int, Int>) {
        //TODO
    }

    override fun getGamesOrderedByTotalScore(): Set<Game> {
        //TODO
        return emptySet()
    }
}