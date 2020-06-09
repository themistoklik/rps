package strategy;

import move.Move;
import move.RockPaperScissorsMoves;
import player.Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Choose the next {@link Move} at random.
 */
public class RandomStrategy implements Strategy {

    @Override
    public Move nextMove() {
        final List<RockPaperScissorsMoves> moves = Arrays.asList(RockPaperScissorsMoves.values());
        Collections.shuffle(moves);
        return moves.get(0);
    }

    //No need to consider past moves
    @Override
    public void update(Map<Player, List<Move>> history) {
    }
}
