/**
 * Represents an automated player that follows a sequential placement strategy.
 * Scans board positions row by row and column by column
 * to place its mark in the first unoccupied cell holding {@link Mark#BLANK}
 * on a board (such as the default 4x4 dimensions).
 */
public class CleverPlayer implements Player {

    /**
     * Constructs a new {@code CleverPlayer} ready to play on a square board
     * (e.g., the default 4x4 dimensions).
     */
    public CleverPlayer () {}

    /**
     * Executes a turn by sequentially scanning the board from the top-left coordinate
     * (row 0, column 0) row by row and column by column.
     * Places the specified mark in the first available cell possessing state
     * {@link Mark#BLANK} and immediately ends the turn.
     *
     * @param board the {@link Board} on which the turn is played, typically having default 4x4 dimensions
     * @param mark the {@link Mark} (such as {@link Mark#X} or {@link Mark#O}) to place on the board
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        int size = board.getSize();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board.putMark(mark, row, col)) {
                    return;
                }
            }
        }
    }
}
