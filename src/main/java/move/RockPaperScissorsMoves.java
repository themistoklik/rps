package move;


import java.util.Collection;
import java.util.Collections;

/**
 * The {@link Move}s that define the game of Rock-Paper-Scissors
 */

public enum RockPaperScissorsMoves implements Move {
    ROCK {
        @Override
        public Collection<Move> beatsMoves() {
            return Collections.singleton(SCISSORS);
        }
    },
    PAPER {
        @Override
        public Collection<Move> beatsMoves() {
            return Collections.singleton(ROCK);
        }
    },
    SCISSORS {
        @Override
        public Collection<Move> beatsMoves() {
            return Collections.singleton(PAPER);
        }
    };
}
