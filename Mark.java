/**
 * Represents the mark state of a cell on the game board (such as the default 4x4 grid).
 * Contains enum values indicating an empty cell ({@link #BLANK})
 * or assigned player marks ({@link #X} and {@link #O}).
 */
public enum Mark {
    /**
     * Represents an unassigned, empty cell state on the board.
     */
    BLANK,

    /**
     * Represents the player mark "X".
     */
    X,

    /**
     * Represents the player mark "O".
     */
    O;

    /**
     * Returns the string representation of this mark.
     * Returns {@code "X"} for {@link #X}, {@code "O"} for {@link #O},
     * and {@code null} for empty {@link #BLANK} cells.
     *
     * @return the text representation of the mark, or {@code null} if the mark is {@link #BLANK}
     */
    @Override
    public String toString () {
        switch (this) {
            case BLANK:
                return null;
            case X:
                return "X";
            case O:
                return "O";
            default:
                return null;
        }
    }
}
