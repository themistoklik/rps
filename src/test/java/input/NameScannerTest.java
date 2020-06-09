package input;

import org.junit.Rule;
import org.junit.Test;
import strategy.IOMock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NameScannerTest extends IOMock {

    @Test(expected = IllegalArgumentException.class)
    public void testNameScanner() {
        mockIn("IMC\n  \n");
        var ns = new NameScanner();
        var firstRead = ns.readUnlessInvalid();

        assertEquals(firstRead, "IMC");

        ns.readUnlessInvalid();
        ns.scanner.close();
    }
}
