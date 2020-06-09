package move;

import java.util.Collection;

/**
 * An action in a game, what other actions it beats and how to determine the beating.
 * Default interface method impl inspired by Github implementation of game.
 */
public interface Move {
    Collection<Move> beatsMoves();

    default public boolean beatsMove(Move move) {
        return this.beatsMoves().contains(move);
    }
}
