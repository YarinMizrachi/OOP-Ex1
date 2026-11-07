/**
 * Represents a square game board containing a grid of marks.
 * Manages board dimensions and operations for placing and reading marks at grid coordinates.
 */
public class Board {
    private static final int DEFAULT_SIZE = 4;
    private int size = DEFAULT_SIZE;
    private Mark[][] board;

    /**
     * Constructs a default 4x4 square game board with all cells initialized to {@link Mark#BLANK}.
     */
    public Board () {
        this.board = new Mark[DEFAULT_SIZE][DEFAULT_SIZE];
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                this.board[i][j] = Mark.BLANK;
            }
        }
    }

    /**
     * Constructs a square game board with the given custom dimension,
     * initializing all cells to {@link Mark#BLANK}.
     *
     * @param size the width and height dimension of the square board
     */
    public Board (int size) {
        this.size = size;
        this.board = new Mark[this.size][this.size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = Mark.BLANK;
            }
        }
    }

    /**
     * Returns the side length dimension of the square game board.
     *
     * @return the number of rows and columns on the board
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Places the specified mark at the given row and column coordinates if valid and empty.
     * Checks board bounds and ensures the target position currently holds
     * {@link Mark#BLANK} before setting the new mark.
     *
     * @param mark the {@link Mark} to place on the board
     * @param row the 0-based row index
     * @param col the 0-based column index
     * @return {@code true} if the mark was successfully placed;
     * {@code false} if coordinates are out of bounds or the position is already occupied
     */
    public boolean putMark (Mark mark, int row, int col) {
        if (!checkBounds(row, col)) {
            return false;
        }
        if (this.board[row][col] == Mark.BLANK) {
            this.board[row][col] = mark;
            return true;
        }
        return false;
    }

    /**
     * Returns the mark located at the specified row and column coordinates.
     * Validates that coordinates are within bounds, returning {@link Mark#BLANK} if out of bounds.
     *
     * @param row the 0-based row index
     * @param col the 0-based column index
     * @return the {@link Mark} at the specified location, or {@link Mark#BLANK} if coordinates are invalid
     */
    public Mark getMark (int row, int col) {
        if (!checkBounds(row, col)) {
            return Mark.BLANK;
        }
        return this.board[row][col];
    }

    private boolean checkBounds (int row, int col) {
        if (row < 0 || row >= this.size) {
            return false;
        }
        if (col < 0 || col >= this.size) {
            return false;
        }
        return true;
    }
}
