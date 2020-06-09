package rule;

import move.Move;
import player.Player;

import java.util.List;

/**
 * How to determine winners and losers in a game, as well as
 * how many points each poisition in the ranks is worth.
 */
public interface Rules {
    /**
     * Given each {@link Player}'s move, return either a tie or rank the players for the concluded round of the {@link game.Game}
     */
    Result rankPlayers(List<Player> players, List<Move> moves);

    /**
     * Dictates the scores (ascending) for every rank achieved at the end of each round.
     * Index 0 has the winner, 1 the second place etc..
     * Enables negative scoring and flexibility in how many points a win is worth.
     */
    long[] getScoresPerRank();

    long tieScore = 0;
}
