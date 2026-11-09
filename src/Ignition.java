import edu.macalester.graphics.*;

public class Ignition {
    private CanvasWindow canvas;
    private int size;
    public Ignition()   {
        int size=500;
        canvas = new CanvasWindow("HELO", size, size);
        canvas.animate(null);
    }
    public static void main(String[] args) {
        Ignition main = new Ignition();
        Ball attack = new Ball();
    }
}
