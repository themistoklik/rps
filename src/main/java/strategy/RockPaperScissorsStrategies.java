package strategy;

/**
 * All the available {@link Strategy} options.
 */
public enum RockPaperScissorsStrategies {
    READ_FROM_CLI(new ReadFromCLIStrategy()),
    RANDOM(new RandomStrategy()),
    ROCK_ONLY(new RockOnlyStrategy()),
    PAPER_ONLY(new PaperOnlyStrategy());

    public Strategy getStrategy() {
        return strategy;
    }

    private Strategy strategy;

    RockPaperScissorsStrategies(Strategy strategy) {
        this.strategy = strategy;
    }
}
