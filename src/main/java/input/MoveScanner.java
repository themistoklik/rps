package input;

import move.Move;
import move.RockPaperScissorsMoves;

/**
 * Read a number and map it to a move if that number is correctly index-mapped to the values of
 * {@link RockPaperScissorsMoves}
 */
public class MoveScanner extends BoundScanner<Move> {
    @Override
    protected Move readUnlessInvalid() throws IllegalArgumentException {
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice < 0 || choice >= RockPaperScissorsMoves.values().length) {
            throw new IllegalArgumentException("Invalid choice, please try again!");
        }
        return RockPaperScissorsMoves.values()[choice];
    }
}
