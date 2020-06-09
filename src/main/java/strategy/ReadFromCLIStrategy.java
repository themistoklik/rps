package strategy;

import input.MoveScanner;
import move.Move;
import player.Player;

import java.util.List;
import java.util.Map;

/**
 * Next {@link Move} to be determined by user input through {@link System.in}
 */
public class ReadFromCLIStrategy implements Strategy {

    private static final MoveScanner scanner = new MoveScanner();

    @Override
    public Move nextMove() {
        System.out.println("PLAY!");
        System.out.println("[0] Rock");
        System.out.println("[1] Paper");
        System.out.println("[2] Scissors");

        return scanner.next();
    }

    @Override
    public void update(Map<Player, List<Move>> history) {
    }
}
