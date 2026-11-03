public class Game {
    private static final int DEFAULT_WIN_STREAK = 3;
    private static final int EVEN = 2;
    private Player playerX;
    private Player playerO;
    private Board board;
    private int winStreak = DEFAULT_WIN_STREAK;
    private Renderer renderer;

    public Game (Player playerX, Player playerO, Renderer renderer) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
        this.board = new Board ();
    }

    public Game (Player playerX, Player playerO, int size, int winStreak, Renderer renderer) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.board = new Board (size);
        this.winStreak = winStreak;
        this.renderer = renderer;
    }

    public int getWinStreak () {
        return this.winStreak;
    }

    public int getBoardSize () {
        return this.board.getSize();
    }

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
