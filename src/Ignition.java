import edu.macalester.graphics.*;

public class Ignition {
    private static CanvasWindow canvas;
    private static int size=500;
    public Ignition()
    {
        canvas = new CanvasWindow("Breaking Out!", size, size);

    }
    public static void main(String[] args) {
        new Ignition();
        Window MainWindow = new Window();
        canvas.add(MainWindow.getBackground());
        canvas.animate(dt -> {
            MainWindow.attack.Collide(null);
        });

    }
}
