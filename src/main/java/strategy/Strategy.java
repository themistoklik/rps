package strategy;


import move.Move;
import player.Player;

import java.util.List;
import java.util.Map;

/**
 * How {@link Move}s manifest and a way to change that based on contextual information
 */
public interface Strategy {
    Move nextMove();

    /**
     * The way to update one's strategy (if necessary)
     *
     * @param history all moves by all players of a game at any given timee
     */
    void update(Map<Player, List<Move>> history);
}
