import domain.Game
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInRelativeOrder
import org.hamcrest.collection.IsEmptyCollection
import org.hamcrest.core.IsNot
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import service.FootballWordCupScoreBoard
import java.lang.IllegalArgumentException

class FootballWordCupScoreBoardTests {

    val footballWordCupScoreBoard = FootballWordCupScoreBoard()

    private val team1Name = "test"
    private val team2Name = "test2"

    @Nested
    inner class StartGame {

        @Test
        fun `throws IllegalArgumentException for duplicate team name`() {
            assertThrows<IllegalArgumentException> {
                footballWordCupScoreBoard.startGame(team1Name, team1Name)
            }
        }

        @Test
        fun `throws IllegalArgumentException for duplicate team name with different case`() {
            assertThrows<IllegalArgumentException> {
                footballWordCupScoreBoard.startGame(team1Name, team1Name)
            }
        }

        @Test
        fun `throws IllegalStateException if game already running`() {
            assertThrows<IllegalStateException> {
                footballWordCupScoreBoard.startGame(team1Name, team2Name)
                footballWordCupScoreBoard.startGame(team1Name, team2Name)
            }
        }
    }

    @Nested
    inner class FinishGame {
        @Test
        fun `archives current game`() {
            footballWordCupScoreBoard.currentGame = Game(team1Name, team2Name)

            footballWordCupScoreBoard.finishGame()

            assertThat(footballWordCupScoreBoard.archive, IsNot(IsEmptyCollection()))
        }

        @Test
        fun `un-assigns current game`() {
            footballWordCupScoreBoard.currentGame = Game(team1Name, team2Name)

            footballWordCupScoreBoard.finishGame()

            assertNull(footballWordCupScoreBoard.currentGame)
        }

        @Test
        fun `throws IllegalStateException if game not running`() {
            assertThrows<IllegalStateException> {
                footballWordCupScoreBoard.finishGame()
            }
        }
    }

    @Nested
    inner class Update {
        @Test
        fun `throws IllegalArgumentException for negative values`() {
            assertThrows<IllegalArgumentException> {
                footballWordCupScoreBoard.update(-1 to -2)
            }

        }

        @Test
        fun `throws IllegalStateException if game not running`() {
            assertThrows<IllegalStateException> {
                footballWordCupScoreBoard.update(0 to 0)
            }
        }
    }

    @Nested
    inner class GetGamesByTotalScore {
        @Test
        fun `no games returns empty set`() {
            val result = footballWordCupScoreBoard.getGamesOrderedByTotalScore()

            assertThat(result, IsEmptyCollection())
        }

        @Test
        fun `result ordered by total score`() {
            fun getGame(homeTeamScore: Int, awayTeamScore: Int) =
                Game(team1Name, team2Name).also {
                    it.homeTeamScore.score = homeTeamScore
                    it.awayTeamScore.score = awayTeamScore
                }

            val game1 = getGame(5, 5)
            val game2 = getGame(1, 2)
            val game3 = getGame(4, 3)
            footballWordCupScoreBoard.archive.addAll(listOf(game1, game2, game3))

            val result = footballWordCupScoreBoard.getGamesOrderedByTotalScore()

            assertThat(result, containsInRelativeOrder(game1, game3, game2))
        }

        @Test
        fun `games with same total score ordered by recency`() {
            val game1 = Game("testName1", "testName2")
            val game2 = Game("testName3", "testName4")
            val game3 = Game(team1Name, team2Name)


            footballWordCupScoreBoard.archive.run {
                add(game1)
                add(game2)
                add(game3)
            }

            val result = footballWordCupScoreBoard.getGamesOrderedByTotalScore()

            assertThat(result, containsInRelativeOrder(game1, game2, game3))
        }
    }

}