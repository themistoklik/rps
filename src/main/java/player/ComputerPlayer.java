package player;

import strategy.RockPaperScissorsStrategies;
import strategy.Strategy;

/**
 * Computer is a Player that has by default a {@link strategy.RandomStrategy}
 * Inspired by Github implementations to model this as a singleton.
 */
public class ComputerPlayer extends HumanPlayer {
    private final static String name = "cpu";
    private static HumanPlayer instance;

    private ComputerPlayer() {
        super(name, RockPaperScissorsStrategies.RANDOM.getStrategy());
    }

    private ComputerPlayer(Strategy strategy) {
        super(name, strategy);
    }

    public static Player withRandomStrategy() {
        if (instance == null) {
            instance = new ComputerPlayer();
        }
        return instance;
    }

    public static Player withStrategy(Strategy strategy) {
        if (instance == null) {
            instance = new ComputerPlayer(strategy);
        }
        return instance;
    }
}
