/**
 * Represents a human player that receives move coordinates through interactive console input.
 * Prompts the user to input 2-digit integer coordinates to place their mark on a game board
 * (such as the default 4x4 dimensions) at an empty location holding {@link Mark#BLANK}.
 */
public class HumanPlayer implements Player {
    private static final int TEN_DIVIDER = 10;
    private static final int HUNDRED_DIVIDER = 100;

    /**
     * Constructs a new {@code HumanPlayer} instance ready for interactive turn inputs.
     */
    public HumanPlayer() {}

    /**
     * Executes a turn by prompting the human user via console input to enter move coordinates.
     * Extracts the column from the units digit (% 10) and row from the tens digit,
     * re-prompting the user if the coordinates are out of bounds
     * or if the target cell is not empty (state is not {@link Mark#BLANK}).
     *
     * @param board the {@link Board} on which to place the mark, with dimensions such as the default 4x4
     * @param mark the {@link Mark} (such as {@link Mark#X} or {@link Mark#O}) assigned to this player
     */
    @Override
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
