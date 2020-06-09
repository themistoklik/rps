package rule;

import move.Move;
import player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * How to rank players after a round of {@link game.RockPaperScissors} has elapsed, and handy method to get scores per
 * rank achieved.
 */
public class RockPaperScissorsRules implements Rules {

    private long[] scoresPerRank;

    public RockPaperScissorsRules(long[] scoresPerRank) {
        this.scoresPerRank = scoresPerRank;
    }

    @Override
    public Result rankPlayers(List<Player> players, List<Move> moves) {
        boolean tie;
        List<Player> ranks = new ArrayList<>(players);

        Move playerOneMove = moves.get(0);
        Move playerTwoMove = moves.get(1);

        System.out.println(players.get(0).getName() + " played " + playerOneMove.toString());
        System.out.println(players.get(1).getName() + " played " + playerTwoMove.toString());
        System.out.println();

        if (playerOneMove.beatsMove(playerTwoMove)) {
            tie = false;
        } else if (playerTwoMove.beatsMove(playerOneMove)) {
            tie = false;
            Collections.swap(ranks, 1, 0);
        } else {
            tie = true;
            ranks = Collections.EMPTY_LIST;
        }

        return new Result(tie, ranks);
    }

    @Override
    public long[] getScoresPerRank() {
        return scoresPerRank;
    }
}
