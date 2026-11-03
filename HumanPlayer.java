public class HumanPlayer implements Player {
    private static final int TEN_DIVIDER = 10;
    private static final int HUNDRED_DIVIDER = 100;

    public HumanPlayer() {}

    public void playTurn (Board board, Mark mark) {
        System.out.println("Player " +mark + ", type coordinates: ");
        while (true) {
            int coordinates = KeyboardInput.readInt();
            int col = coordinates % TEN_DIVIDER;
            int row = ((coordinates % HUNDRED_DIVIDER) - col) / TEN_DIVIDER;
            if (!board.putMark(mark, row, col)) {
                if (board.getMark(row, col) == Mark.BLANK) {
                    System.out.println("Invalid mark position. Please choose a valid position: ");
                } else {
                    System.out.println("Mark position is already occupied. Please choose a valid position: ");
                }
            }
            else {
                break;
            }
        }
    }

}
