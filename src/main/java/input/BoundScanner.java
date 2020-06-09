package input;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Not gonna lie, this borrows heavily from Stack Overflow.
 * A Wrapper around a Scanner that discards whatever extending functions deem as nonsense.
 * <p>
 * Discarding is essentially retrying input (without max attempts, a nice possible addition).
 */
public abstract class BoundScanner<E> {
    protected Scanner scanner = new Scanner(System.in);

    protected abstract E readUnlessInvalid() throws IllegalArgumentException;

    public E next() {
        try {
            System.out.print(">>");
            return readUnlessInvalid();
        } catch (IllegalArgumentException iae) {
            System.out.println("What you entered is against the rules of the game");
            return next();
        } catch (InputMismatchException ime) {
            System.out.println("What you entered is unexpected.. Try once more!");
            scanner.nextLine();
            return readUnlessInvalid();
        }
    }
}
