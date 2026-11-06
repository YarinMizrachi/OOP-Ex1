public class GeniusPlayer implements Player{
    private static final int FIRST_ROW = 0;
    private static final int FIRST_COLUMN = 0;
    private static final int SECOND_COLUMN = 1;
    private static final int THIRD_COLUMN = 2;
    private static final int THIRD_ROW = 2;

    public GeniusPlayer () {}

    @Override
    public void playTurn(Board board, Mark mark) {
        int size = board.getSize();
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
}
