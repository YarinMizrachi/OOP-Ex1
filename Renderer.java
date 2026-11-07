/**
 * Defines the contract for visual display modules responsible for rendering the game board.
 * Implementations output the current layout of the board
 * (such as default 4x4 dimensions) and the state of its cells.
 */
public interface Renderer {

    /**
     * Displays the current state of the specified game board.
     * Renders all grid cells along with their marks
     * (such as {@link Mark#X}, {@link Mark#O}, or empty {@link Mark#BLANK} positions).
     *
     * @param board the {@link Board} to be rendered, typically having default 4x4 dimensions
     */
    void renderBoard (Board board);
}
