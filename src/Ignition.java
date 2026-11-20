import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import edu.macalester.graphics.*;

public class Ignition {
    private static CanvasWindow canvas;
    private static int size=500;
    protected static ArrayList<Brick> TileSet = new ArrayList<Brick>();
    public Ignition()
    {
        canvas = new CanvasWindow("Breaking Out!", size, size);

    }
    public static void main(String[] args) {
        new Ignition();
        Window MainWindow = new Window();
        canvas.add(MainWindow.getBackground());
        canvas.animate(dt -> {
            MainWindow.attack.Collide(MainWindow.attack);
            TileSet.forEach( brick -> {
                MainWindow.attack.Collide(brick);
            });
            MainWindow.attack.Collide(MainWindow.test);
        });

    }
}
