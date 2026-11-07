/**
 * Defines the contract for a game participant capable of executing turns on a game board.
 * Implementations (such as human or automated strategy players) inspect and update the board
 * (e.g., default 4x4 dimensions) by placing their mark into an empty cell holding {@link Mark#BLANK}.
 */
public interface Player {

    /**
     * Executes a single turn for this player on the specified board.
     * Selects a valid target cell holding {@link Mark#BLANK} on the board
     * and places the player's assigned mark.
     *
     * @param board the {@link Board} on which the turn is played, typically having default 4x4 dimensions
     * @param mark the {@link Mark} (such as {@link Mark#X} or {@link Mark#O}) assigned to this player
     */
    void playTurn(Board board, Mark mark);
}
