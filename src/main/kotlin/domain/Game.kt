package domain

data class Game(val homeTeamName: String, val awayTeamName: String) {
    val homeTeamScore: TeamScore = TeamScore(homeTeamName, 0)
    val awayTeamScore: TeamScore = TeamScore(awayTeamName, 0)
}