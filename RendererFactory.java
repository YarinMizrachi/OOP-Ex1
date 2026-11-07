/**
 * Factory class responsible for instantiating different types of {@link Renderer} implementations.
 * Constructs board renderer instances configured for specific board dimensions
 * (such as the default 4x4 size).
 */
public class RendererFactory {

    /**
     * Creates and returns a {@link Renderer} instance corresponding to the specified
     * type string and board dimension.
     * Converts the string to lower case and constructs a {@code ConsoleRenderer}
     * configured for the given board size, a silent {@code VoidRenderer},
     * or {@code null} if the type is unrecognized.
     *
     * @param type the renderer type identifier (e.g., "console" or "void")
     * @param size the dimension (width and height) of the square game board (e.g., default 4)
     * @return the constructed {@link Renderer} instance, or {@code null} if the specified type is unsupported
     */
    public Renderer buildRenderer (String type, int size) {
        type = type.toLowerCase();
        Renderer renderer = null;
        switch (type) {
            case "console":
                renderer = new ConsoleRenderer(size);
                break;
            case "void":
                renderer = new VoidRenderer();
                break;
        }
        return renderer;
    }
}
