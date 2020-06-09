package strategy;

import move.Move;
import player.Player;

import java.util.List;
import java.util.Map;

import static move.RockPaperScissorsMoves.PAPER;

/**
 * Just plays {@link move.RockPaperScissorsMoves.PAPER}
 */
public class PaperOnlyStrategy implements Strategy {
    @Override
    public Move nextMove() {
        return PAPER;
    }

    @Override
    public void update(Map<Player, List<Move>> history) {

    }
}
