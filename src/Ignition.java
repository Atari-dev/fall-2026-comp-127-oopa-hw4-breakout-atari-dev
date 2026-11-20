import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.events.KeyboardEventHandler;

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
            MainWindow.attack.Collide(MainWindow.Pladdle);
            TileSet.forEach( brick -> {
                if (MainWindow.attack.IsCollided(brick) && brick.getGraphics() != null)
                {
                    try {
                    MainWindow.getBackground().remove(brick.getGraphics());
                    MainWindow.attack.Collide(brick);
                    } catch (Exception e) {

                    }


                }

                if (canvas.getKeysPressed().contains(Key.LEFT_ARROW))
                    {
                        MainWindow.Pladdle.getGraphics().moveBy(-0.3,0);
                    };
            
                if (canvas.getKeysPressed().contains(Key.RIGHT_ARROW))
                    {
                        MainWindow.Pladdle.getGraphics().moveBy(0.3,0);
                    };
            });
        });

    }
}
