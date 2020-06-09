package rule;

import org.junit.Before;
import org.junit.Test;
import player.HumanPlayer;
import player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static move.RockPaperScissorsMoves.PAPER;
import static move.RockPaperScissorsMoves.ROCK;
import static move.RockPaperScissorsMoves.SCISSORS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static strategy.RockPaperScissorsStrategies.RANDOM;

public class RuleTest {
    private List<Player> players;
    private Rules rpsRules = new RockPaperScissorsRules(new long[]{1, 0});

    @Before
    public void setUp() {
        players = new ArrayList<>();
        players.add(new HumanPlayer("1", RANDOM.getStrategy()));
        players.add(new HumanPlayer("2", RANDOM.getStrategy()));
    }

    @Test
    public void testWin() {
        //first player wins
        Result firstPlayerWin = rpsRules.rankPlayers(players, Arrays.asList(PAPER, ROCK));
        assertEquals(firstPlayerWin.getRanks().get(0), players.get(0));
        assertEquals(firstPlayerWin.getRanks().get(1), players.get(1));
        assertFalse(firstPlayerWin.isTie());

        //second player wins
        Result secondPlayerWin = rpsRules.rankPlayers(players, Arrays.asList(PAPER, SCISSORS));
        assertEquals(secondPlayerWin.getRanks().get(0), players.get(1));
        assertEquals(secondPlayerWin.getRanks().get(1), players.get(0));
        assertFalse(secondPlayerWin.isTie());
    }

    @Test
    public void testTie() {
        Result tie = rpsRules.rankPlayers(players, Arrays.asList(PAPER, PAPER));
        assertTrue(tie.isTie());
        assertTrue(tie.getRanks().isEmpty());
    }
}
