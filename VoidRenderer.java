/**
 * A silent implementation of the {@link Renderer} interface that produces no output.
 * Useful for running large-scale automated tournaments (e.g., 10,000 rounds) without console overhead.
 */
public class VoidRenderer implements Renderer {

    /**
     * Intentionally provides an empty implementation to avoid rendering the board to the screen.
     *
     * @param board the current game {@link Board} state (ignored in this implementation)
     */
    @Override
    public void renderBoard (Board board) {}
}
