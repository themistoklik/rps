package strategy;

import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Thankfully Github had this neat (or hacky) solution fo mocking a stream in Java.
 */
public class IOMock {
    protected ByteArrayOutputStream mockedOut = new ByteArrayOutputStream();

    public void mockIn(String input) {
        System.setIn(new ByteArrayInputStream((input + "\n").getBytes()));
    }

    @Before
    public void mockOutput() {
        System.setOut(new PrintStream(mockedOut));
    }

    @After
    public void restoreStreams() {
        System.setIn(System.in);
        System.setOut(System.out);
    }
}
