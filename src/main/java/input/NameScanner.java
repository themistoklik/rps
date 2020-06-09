package input;

/**
 * Get a {@link String} form {@link System.in}, remove whitespaces and return it if it contains any characters.
 */
public class NameScanner extends BoundScanner<String> {
    @Override
    protected String readUnlessInvalid() throws IllegalArgumentException {
        String name = scanner.nextLine().trim();
        if (name.isBlank()) {
            throw new IllegalArgumentException("That's not a name..try once more");
        }
        return name;
    }
}
