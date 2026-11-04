public class CleverPlayer implements Player {

    public CleverPlayer () {}

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
