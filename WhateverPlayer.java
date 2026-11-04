import java.util.Random;

public class WhateverPlayer implements Player {

    public WhateverPlayer() {}

    @Override
    public void playTurn(Board board, Mark mark) {
        Random random = new Random();
        while (true) {
            int row = random.nextInt(board.getSize());
            int col = random.nextInt(board.getSize());
            if (board.putMark(mark, row, col)) {
                break;
            }
        }
    }
}
