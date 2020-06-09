package game;

import org.junit.Before;
import org.junit.Test;
import player.ComputerPlayer;
import player.HumanPlayer;
import player.Player;

import java.util.Arrays;
import java.util.List;

import static move.RockPaperScissorsMoves.PAPER;
import static move.RockPaperScissorsMoves.ROCK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static strategy.RockPaperScissorsStrategies.PAPER_ONLY;
import static strategy.RockPaperScissorsStrategies.ROCK_ONLY;

public class RockPaperScissorsTest {
    private Player computer;
    private Player human;
    private List<Player> players;

    @Before
    public void setUp() {
        computer = ComputerPlayer.withStrategy(PAPER_ONLY.getStrategy());
        human = new HumanPlayer("1", ROCK_ONLY.getStrategy());
        players = Arrays.asList(computer, human);
    }

    @Test
    public void testGame() {

        var game = new RockPaperScissors(3, players);

        game.play();

        assertEquals(game.history.get(human).size(), 3);
        assertTrue(game.history.get(human).equals(Arrays.asList(ROCK, ROCK, ROCK)));
        assertEquals(game.history.get(computer).size(), 3);
        assertTrue(game.history.get(computer).equals(Arrays.asList(PAPER, PAPER, PAPER)));

        assertEquals(game.leaderBoard.get(human), Long.valueOf(0));
        assertEquals(game.leaderBoard.get(computer), Long.valueOf(3));
        assertEquals(game.leaderBoard.size(), 2);
    }

    @Test
    public void testNonSenseMaxRoundLimitGetsNoMovesGame() {
        var game = new RockPaperScissors(Long.MAX_VALUE + 1, players);

        game.play();

        assertEquals(game.history.get(human).size(), 0);
        assertEquals(game.history.get(computer).size(), 0);
        assertEquals(game.leaderBoard.get(human), Long.valueOf(0));
        assertEquals(game.leaderBoard.get(computer), Long.valueOf(0));
    }
}
