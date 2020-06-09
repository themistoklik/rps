package move;

import org.junit.Test;

import static move.RockPaperScissorsMoves.PAPER;
import static move.RockPaperScissorsMoves.ROCK;
import static move.RockPaperScissorsMoves.SCISSORS;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovesTest {
    @Test
    public void testPaper(){
        assertTrue(PAPER.beatsMove(ROCK));
        assertFalse(PAPER.beatsMove(PAPER));
        assertFalse(PAPER.beatsMove(SCISSORS));
    }

    @Test
    public void testRock(){
        assertTrue(ROCK.beatsMove(SCISSORS));
        assertFalse(ROCK.beatsMove(ROCK));
        assertFalse(ROCK.beatsMove(PAPER));
    }

    @Test
    public void testScissors(){
        assertTrue(SCISSORS.beatsMove(PAPER));
        assertFalse(SCISSORS.beatsMove(SCISSORS));
        assertFalse(SCISSORS.beatsMove(ROCK));
    }
}
