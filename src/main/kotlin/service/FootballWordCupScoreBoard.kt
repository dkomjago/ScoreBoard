package service

import domain.Game
import java.lang.IllegalArgumentException

class FootballWordCupScoreBoard : ScoreBoard {

    internal var currentGame: Game? = null
    internal val archive: MutableSet<Game> = sortedSetOf()

    override fun startGame(homeTeam: String, awayTeam: String) {
        if (homeTeam.equals(awayTeam, true)) throw IllegalArgumentException()

        if (currentGame == null) currentGame = Game(homeTeam, awayTeam) else throw IllegalStateException()
    }

    override fun finishGame() {
        currentGame?.let { archive.add(it) } ?: throw IllegalStateException()
        currentGame = null
    }

    override fun update(score: Pair<Int, Int>) {
        if (score.first < 0 || score.second < 0) throw IllegalArgumentException()

        currentGame?.let {
            it.homeTeamScore.score = score.first
            it.awayTeamScore.score = score.second
        } ?: throw IllegalStateException()
    }

    override fun getGamesOrderedByTotalScore(): Set<Game> {
        return archive
    }
}