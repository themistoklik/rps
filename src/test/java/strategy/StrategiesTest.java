package strategy;

import move.Move;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import static move.RockPaperScissorsMoves.PAPER;
import static move.RockPaperScissorsMoves.ROCK;
import static move.RockPaperScissorsMoves.SCISSORS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StrategiesTest {

    @Test
    public void testRandomStrategyContainsAllMoves() {
        Strategy strategy = new RandomStrategy();
        Set<Move> moves = new HashSet<>();

        for (int i = 0; i < 200; i++) {
            moves.add(strategy.nextMove());
        }
        assertTrue(moves.containsAll(Arrays.asList(ROCK, PAPER, SCISSORS)));
    }
}
