import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import service.FootballWordCupScoreBoard

class FootballWordCupScoreBoardTests {

    val footballWordCupScoreBoard = FootballWordCupScoreBoard()


    @Nested
    inner class StartGame {

        @Test
        fun `throws IllegalArgumentException for duplicate team name`() {
            //TODO
        }

        @Test
        fun `throws IllegalArgumentException for duplicate team name with different case`() {
            //TODO
        }

        @Test
        fun `throws IllegalStateException if game already running`() {
            //TODO
        }
    }

    @Nested
    inner class FinishGame {
        @Test
        fun `archives current game`() {
            //TODO
        }

        @Test
        fun `un-assigns current game`() {
            //TODO
        }

        @Test
        fun `throws if IllegalStateException game not running`() {
            //TODO
        }
    }

    @Nested
    inner class Update {
        @Test
        fun `throws IllegalArgumentException for negative values`() {
            //TODO

        }

        @Test
        fun `throws if IllegalStateException game not running`() {
            //TODO
        }
    }

    @Nested
    inner class GetGamesByTotalScore {
        @Test
        fun `no games returns empty set`() {
            //TODO
        }

        @Test
        fun `result ordered by total score`() {
            //TODO
        }
    }

}