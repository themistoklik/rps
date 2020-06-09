package player;

import move.Move;
import strategy.Strategy;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Class that is essentially us playing through the command line
 */
public class HumanPlayer implements Player {
    private String name;
    private Strategy strategy;

    public HumanPlayer(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    @Override
    public Move play() {
        return strategy.nextMove();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void updateStrategy(Map<Player, List<Move>> history) {

    }

    @Override
    @SuppressWarnings({"squid:S1067", "squid:S00121", "squid:S00122", "PMD.IfStmtsMustUseBraces"})
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HumanPlayer that = (HumanPlayer) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(strategy, that.strategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, strategy);
    }
}
