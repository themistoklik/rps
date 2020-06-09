package rule;

import player.Player;

import java.util.List;

/**
 * Result of a round of the game.
 * If it's not a tie, someone won, so you get their index based ranks.
 */
public class Result {

    private boolean tie;
    private List<Player> ranks;

    public Result(boolean tie, List<Player> ranks) {
        this.tie = tie;
        this.ranks = ranks;
    }

    public boolean isTie() {
        return tie;
    }

    public List<Player> getRanks() {
        return ranks;
    }
}
