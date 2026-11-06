public class RendererFactory {

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
