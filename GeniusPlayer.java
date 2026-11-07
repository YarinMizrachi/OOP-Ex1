/**
 * Represents an advanced strategy player that prioritizes securing immediate wins
 * and blocking opponent victories.
 * Analyzes cells with state {@link Mark#BLANK} on a game board
 * (such as the default 4x4 dimensions) to detect streaks of at least 2 matching marks,
 * falling back to a structured column placement if no critical move is available.
 */
public class GeniusPlayer implements Player{
    private static final int FIRST_ROW = 0;
    private static final int FIRST_COLUMN = 0;
    private static final int SECOND_COLUMN = 1;
    private static final int WIN_NEXT_STEP = 2;

    /**
     * Constructs a new {@code GeniusPlayer} instance ready to play on a board (e.g., default 4x4 dimensions).
     */
    public GeniusPlayer () {}

    /**
     * Executes a turn using a prioritized tactical strategy.
     * Checks all {@link Mark#BLANK} cells for an immediate win (2 adjacent matching marks),
     * then checks to block an opponent win,
     * and otherwise falls back to scanning columns from index 1 before attempting column 0.
     *
     * @param board the {@link Board} on which the turn is executed, with dimensions such as the default 4x4
     * @param mark the {@link Mark} (such as {@link Mark#X} or {@link Mark#O}) assigned to this player
     */
    @Override
    public void playTurn (Board board, Mark mark) {
        int size = board.getSize();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board.getMark(row, col) == Mark.BLANK) {
                    if (isWinning(board, mark, row, col)) {
                        board.putMark(mark, row, col);
                        return;
                    }
                }
            }
        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board.getMark(row, col) == Mark.BLANK) {
                    if (isLosing(board, mark, row, col)) {
                        board.putMark(mark, row, col);
                        return;
                    }
                }
            }
        }
        for (int col = SECOND_COLUMN; col < size; col++) {
            for (int row = FIRST_ROW; row < size; row++) {
                if (board.putMark(mark, row, col)) {
                    return;
                }
            }
        }
        for (int row = FIRST_ROW; row < size; row++) {
            if (board.putMark(mark, row, FIRST_COLUMN)) {
                return;
            }
        }
    }

    private int countMarkInDirection (Board board, int row, int col,
                                      int rowChange, int colChange, Mark mark) {
        int count = 0;
        int currentRow = row + rowChange;
        int currentCol = col + colChange;
        while (currentRow >= 0 && currentRow < board.getSize() &&
                currentCol >= 0  && currentCol < board.getSize() &&
                board.getMark(currentRow, currentCol) == mark) {
            count++;
            currentRow += rowChange;
            currentCol += colChange;
        }
        return count;
    }

    private boolean isWinning (Board board, Mark mark, int row, int col) {
        int leftStreak = countMarkInDirection(board, row, col, 0, -1, mark);
        int rightStreak = countMarkInDirection(board, row, col, 0, 1, mark);
        int upStreak = countMarkInDirection(board, row, col, -1, 0, mark);
        int downStreak = countMarkInDirection(board, row, col, 1, 0, mark);
        int diagonalLeftUp =  countMarkInDirection(board, row, col, -1, -1, mark);
        int diagonalRightDown =  countMarkInDirection(board, row, col, 1, 1, mark);
        int diagonalLeftDown =  countMarkInDirection(board, row, col, 1, -1, mark);
        int diagonalRightUp =  countMarkInDirection(board, row, col, -1, 1, mark);
        return (leftStreak + rightStreak >= WIN_NEXT_STEP) ||
                (upStreak + downStreak >= WIN_NEXT_STEP) ||
                (diagonalLeftUp + diagonalRightDown >= WIN_NEXT_STEP) ||
                (diagonalLeftDown + diagonalRightUp >= WIN_NEXT_STEP);
    }

    private boolean isLosing (Board board, Mark mark, int row, int col) {
        Mark opponentMark;
        if (mark == Mark.X) {
            opponentMark = Mark.O;
        }
        else {
            opponentMark = Mark.X;
        }
        return isWinning(board, opponentMark, row, col);
    }
}
