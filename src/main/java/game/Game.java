package game;

import move.Move;
import player.Player;
import rule.Result;
import rule.Rules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * An abstraction for a game of limited rounds, some {@link Rules}, played by N {@link Player}s
 * There's a history kept for analytics purposes and a leaderboard to determine winners.
 */
public abstract class Game {
    protected Long roundLimit;
    protected Rules rules;
    protected List<Player> players = new ArrayList<>();
    public Map<Player, List<Move>> history;
    public Map<Player, Long> leaderBoard;

    public void play() {
        setUpGame();

        for (long round = 0; round < roundLimit; round++) {
            playRound(round);
        }

        endResult();

        exitGreeting();
    }


    private void setUpGame() throws IllegalStateException {
        greet();

        setRounds();

        setPlayers();

        initHistory();

        initLeaderBoard();

        setRules();

        if (rules.getScoresPerRank().length != players.size()) {
            throw new IllegalStateException("Number of players and scores does not match, game is misconfigured and will stop.");
        }
    }


    protected void playRound(long round) {
        roundIntro(round);
        List<Move> moves = getMoves();

        Result roundResult = rules.rankPlayers(players, moves);

        adjustScores(roundResult);
        updateHistory(moves);

        roundOutro(round);
    }


    private void updateHistory(List<Move> moves) {
        for (int i = 0; i < moves.size(); i++) {
            Player player = players.get(i);
            history.get(player).add(moves.get(i));
        }
    }


    private List<Move> getMoves() {
        return players.stream()
                .map(Player::play)
                .collect(Collectors.toList());
    }


    private void adjustScores(Result result) throws IllegalStateException {
        long[] scores = rules.getScoresPerRank();

        if (result.isTie()) {
            players.stream()
                    .forEach(player -> leaderBoard.computeIfPresent(player, (key, val) -> val + rules.tieScore));
        } else {
            final List<Player> ranks = result.getRanks();

            for (int i = 0; i < scores.length; i++) {
                Player player = ranks.get(i);
                long score = scores[i];

                long currentScore = leaderBoard.get(player);
                leaderBoard.put(player, currentScore + score);
            }
        }
    }


    private void initHistory() {
        this.history = players.stream()
                .collect(Collectors.toMap(Function.identity(), value -> new ArrayList<>()));
    }


    private void initLeaderBoard() {
        this.leaderBoard = new HashMap<>(players.stream()
                .collect(Collectors.toMap(Function.identity(), value -> 0L)));
    }

    protected abstract void endResult();

    protected abstract void roundIntro(long roundNumber);

    protected abstract void setRules();

    protected abstract void setPlayers();

    protected abstract void setRounds();

    protected abstract void greet();

    protected abstract void exitGreeting();

    protected abstract void roundOutro(long round);
}
