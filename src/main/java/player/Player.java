package player;

import move.Move;
import strategy.Strategy;

import java.util.List;
import java.util.Map;

/**
 * A player, participating in a {@link game.Game}
 * They must be able to play, report their name, update their {@link Strategy}
 */
public interface Player {
    Move play();

    String getName();

    void updateStrategy(Map<Player, List<Move>> history);
}
