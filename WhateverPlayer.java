import java.util.Random;

/**
 * Represents an automated player that chooses its moves completely at random.
 * It does not employ any strategy to win or block opponents.
 */
public class WhateverPlayer implements Player {

    /**
     * Constructs a new random-moving player.
     */
    public WhateverPlayer() {}

    /**
     * Executes a turn by repeatedly generating random row and column coordinates
     * within the board's boundaries.
     * The loop continues until it successfully places the specified mark on an available
     * {@link Mark#BLANK} cell.
     *
     * @param board the game {@link Board} to place the mark on
     * @param mark  the {@link Mark} representing this player
     */
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
