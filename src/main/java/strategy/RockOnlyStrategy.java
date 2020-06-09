package strategy;

import move.Move;
import player.Player;

import java.util.List;
import java.util.Map;

import static move.RockPaperScissorsMoves.ROCK;

/**
 * Just plays {@link move.RockPaperScissorsMoves.ROCK}
 */
public class RockOnlyStrategy implements Strategy {
    @Override
    public Move nextMove() {
        return ROCK;
    }

    @Override
    public void update(Map<Player, List<Move>> history) {

    }
}
