package input;

/**
 * Gets {@link Long}s from {@link System.in} and just returns them to be used by the {@link game.Game}
 */
public class RoundScanner extends BoundScanner<Long> {
    @Override
    protected Long readUnlessInvalid() throws IllegalArgumentException {
        long roundLimit = scanner.nextLong();
        if (roundLimit <= 0) {
            throw new IllegalArgumentException("Can't play negative rounds, thanks for pentesting.");
        }
        return roundLimit;
    }
}
