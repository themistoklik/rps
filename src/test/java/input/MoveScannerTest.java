package input;

import move.Move;
import org.junit.Test;
import strategy.IOMock;
import strategy.ReadFromCLIStrategy;

import static move.RockPaperScissorsMoves.PAPER;
import static move.RockPaperScissorsMoves.ROCK;
import static move.RockPaperScissorsMoves.SCISSORS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Since {@link ReadFromCLIStrategy} is a mere wrapper around this, this file serves as a test for it as well.
 * If in the future update history functionality is added, then consider testing the strategy by itself.
 */
public class MoveScannerTest extends IOMock {
    @Test(expected = IllegalArgumentException.class)
    public void testMoveScanner() {
        mockIn("0\n1\n2\n3\n"); // 3 correct inputs, then a wrong one
        var ms = new MoveScanner();

        assertEquals(ms.readUnlessInvalid(), ROCK);
        assertEquals(ms.readUnlessInvalid(), PAPER);
        assertEquals(ms.readUnlessInvalid(), SCISSORS);

        ms.readUnlessInvalid();
    }
}
