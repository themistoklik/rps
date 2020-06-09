package input;

import org.junit.Test;
import strategy.IOMock;

import static org.junit.Assert.assertEquals;

public class RoundScannerTest extends IOMock {

    @Test(expected = IllegalArgumentException.class)
    public void testRoundScanner() {
        mockIn("1\n0\n");
        var rs = new RoundScanner();
        assertEquals(rs.readUnlessInvalid(), Long.valueOf(1));

        rs.readUnlessInvalid();
        rs.scanner.close();
    }
}
