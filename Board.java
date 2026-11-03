public class Board {
    private static final int DEFAULT_SIZE = 4;
    private int size = DEFAULT_SIZE;
    private Mark[][] board;

    public Board () {
        this.board = new Mark[DEFAULT_SIZE][DEFAULT_SIZE];
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                this.board[i][j] = Mark.BLANK;
            }
        }
    }

    public Board (int size) {
        this.size = size;
        this.board = new Mark[this.size][this.size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = Mark.BLANK;
            }
        }
    }

    public int getSize() {
        return this.size;
    }

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
