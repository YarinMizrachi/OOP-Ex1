/**
 * Manages the execution and rules of a Tic-Tac-Toe game session between two players using a given renderer.
 * Handles alternating turns between {@link Mark#X} and {@link Mark#O}, board setup
 * (such as default 4x4 dimensions), win streak checks (defaulting to 3),
 * and tie checks when no cells remain {@link Mark#BLANK}.
 */
public class Game {
    private static final int DEFAULT_WIN_STREAK = 3;
    private static final int EVEN = 2;
    private Player playerX;
    private Player playerO;
    private Board board;
    private int winStreak = DEFAULT_WIN_STREAK;
    private Renderer renderer;

    /**
     * Constructs a new {@code Game} instance using default 4x4 board dimensions and default win streak of 3.
     *
     * @param playerX the player assigned to {@link Mark#X}
     * @param playerO the player assigned to {@link Mark#O}
     * @param renderer the {@link Renderer} used to display the board state
     */
    public Game (Player playerX, Player playerO, Renderer renderer) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
        this.board = new Board ();
    }

    /**
     * Constructs a new {@code Game} instance with specified custom board dimensions and win streak length.
     *
     * @param playerX the player assigned to {@link Mark#X}
     * @param playerO the player assigned to {@link Mark#O}
     * @param size the dimension (width and height) of the square game board
     * @param winStreak the number of consecutive identical marks required to win
     * @param renderer the {@link Renderer} used to display the board state
     */
    public Game (Player playerX, Player playerO, int size, int winStreak, Renderer renderer) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.board = new Board (size);
        this.winStreak = winStreak;
        this.renderer = renderer;
    }

    /**
     * Returns the required number of consecutive marks needed to achieve a victory.
     *
     * @return the win streak target value (such as the default 3)
     */
    public int getWinStreak () {
        return this.winStreak;
    }

    /**
     * Returns the side length dimension of the game board.
     *
     * @return the board size (such as the default 4 for a 4x4 grid)
     */
    public int getBoardSize () {
        return this.board.getSize();
    }

    /**
     * Runs the main game loop, rendering the board and alternating turns between
     * {@link Mark#X} and {@link Mark#O} until a player wins or a tie occurs.
     * Evaluates win conditions after each turn and checks for a tie
     * when all board positions are filled without any remaining {@link Mark#BLANK} cells.
     *
     * @return the winning player's {@link Mark} (either {@link Mark#X} or {@link Mark#O}),
     * or {@link Mark#BLANK} if the game ends in a tie
     */
    public Mark run () {
        int counter = 0;
        renderer.renderBoard(this.board);
        while (true) {
            if (counter % EVEN == 0) {
                playerX.playTurn(this.board, Mark.X);
                renderer.renderBoard(this.board);
                if (gameOver(Mark.X)) {
                    return Mark.X;
                }
            }
            else {
                playerO.playTurn(this.board, Mark.O);
                renderer.renderBoard(this.board);
                if (gameOver(Mark.O)) {
                    return Mark.O;
                }
            }
            if (isTie()) {
                return Mark.BLANK;
            }
            counter++;
        }
    }

    private boolean gameOver (Mark mark) {
        int size = this.getBoardSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (checkWin(mark, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkWin (Mark mark, int row, int col) {
        boolean verticalWon = true;
        boolean horizontalWon = true;
        boolean diagonalWin = true;
        boolean reverseDiagonalWin = true;
        for (int i = 0; i < this.winStreak; i++) {
            if (this.board.getMark(row + i, col) != mark)
            {
                verticalWon = false;
            }
            if (this.board.getMark(row, col + i) != mark) {
                horizontalWon = false;
            }
            if (this.board.getMark(row + i, col + i) != mark) {
                diagonalWin = false;
            }
            if (this.board.getMark(row + i, col - i) != mark) {
                reverseDiagonalWin = false;
            }

        }
        return verticalWon || horizontalWon || diagonalWin || reverseDiagonalWin;
    }

    private boolean isTie () {
        int size = this.board.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (this.board.getMark(i, j) == Mark.BLANK) {
                    return false;
                }
            }
        }
        return true;
    }
}
