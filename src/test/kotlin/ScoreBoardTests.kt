import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ScoreBoardTests {

    @Nested
    inner class StartGame {

        @Test
        fun `doesn't allow duplicate team name`() {
            //TODO
        }

        @Test
        fun `doesn't allow duplicate team name with different case`() {
            //TODO
        }

        @Test
        fun `throws if game already running`() {
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
        fun `throws if game not running`() {
            //TODO
        }
    }

    @Nested
    inner class Update {
        @Test
        fun `doesn't allow negative values`() {
            //TODO

        }

        @Test
        fun `throws if game not running`() {
            //TODO
        }
    }

    @Nested
    inner class GetGamesByTotalScore {
        @Test
        fun `no games returns empty collection`() {
            //TODO
        }

        @Test
        fun `result ordered by total score`() {
            //TODO
        }
    }

}