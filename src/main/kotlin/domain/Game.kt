package domain

data class Game(val homeTeamName: String, val awayTeamName: String) : Comparable<Game> {

    val homeTeamScore: TeamScore  = TeamScore(homeTeamName, 0)
    val awayTeamScore: TeamScore = TeamScore(awayTeamName, 0)

    override fun compareTo(other: Game): Int {
        return this.homeTeamScore.score + this.awayTeamScore.score -
                other.homeTeamScore.score - other.awayTeamScore.score
    }
}