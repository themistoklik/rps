package game;

import input.NameScanner;
import input.RoundScanner;
import player.ComputerPlayer;
import player.HumanPlayer;
import player.Player;
import rule.RockPaperScissorsRules;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static strategy.RockPaperScissorsStrategies.READ_FROM_CLI;

/**
 * A 2 player Rock-Paper-Scissors {@link Game}, played between a human and a computer player.
 */
public class RockPaperScissors extends Game {
    public RockPaperScissors() {
        super();
    }

    public RockPaperScissors(long roundLimit, List<Player> players) {
        this.roundLimit = roundLimit;
        this.players = players;
    }

    @Override
    protected void endResult() {

        final List<Map.Entry<Player, Long>> finalRanks = leaderBoard.entrySet().stream()
                .sorted((Map.Entry.comparingByValue()))
                .collect(Collectors.toList());

        Map.Entry<Player, Long> firstPlace = finalRanks.get(1);
        Map.Entry<Player, Long> secondPlace = finalRanks.get(0);

        if (firstPlace.getValue() == secondPlace.getValue()) {
            System.out.println("It's a tie!");
        } else {
            System.out.println(firstPlace.getKey().getName() + " wins!");
            System.out.println(firstPlace.getKey().getName() + "-" + firstPlace.getValue());
            System.out.println(secondPlace.getKey().getName() + "-" + secondPlace.getValue());
            System.out.println();
        }
    }

    @Override
    protected void roundIntro(long roundNumber) {
        System.out.println(String.format("Round %d begins!", roundNumber));
        System.out.println();
    }

    @Override
    protected void setRules() {
        rules = new RockPaperScissorsRules(new long[]{1, 0});
    }

    @Override
    protected void setPlayers() {
        if (players.isEmpty()) {
            System.out.println("Hello, what should I call you?");
            String name = new NameScanner().next();

            Player human = new HumanPlayer(name, READ_FROM_CLI.getStrategy());
            players.add(human);
            players.add(ComputerPlayer.withRandomStrategy());
        }
    }

    @Override
    protected void setRounds() {
        if (roundLimit == null) {
            System.out.println("How long will our game be?");
            long rounds = new RoundScanner().next();
            roundLimit = rounds;
        }
    }

    @Override
    protected void greet() {
        System.out.println("Oh hi there!");
    }

    @Override
    protected void exitGreeting() {
        System.out.println("OOF What a game! Till next time friend!");
    }

    @Override
    protected void roundOutro(long roundNumber) {
        System.out.println(String.format("Round %d ends!", roundNumber));
        System.out.println();
    }
}
