public class GeniusPlayer implements Player{
    private static final int FIRST_COLUMN = 0;
    public GeniusPlayer () {}

    @Override
    public void playTurn(Board board, Mark mark) {
        int size = board.getSize();
        for (int col = 1; col < size; col++) {
            for (int row = 0; row < size; row++) {
                if (board.putMark(mark, row, col)) {
                    return;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (board.putMark(mark, i, FIRST_COLUMN)) {
                return;
            }
        }
    }
}
