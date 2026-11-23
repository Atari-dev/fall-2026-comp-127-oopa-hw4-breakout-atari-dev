import java.awt.*;
import java.util.ArrayList;
import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;

public class BreakoutMain {
    private static CanvasWindow canvas;
    private static int size=500;
    private static Window MainWindow;
    protected static ArrayList<Brick> TileSet = new ArrayList<Brick>();
    public BreakoutMain() {
        canvas = new CanvasWindow("Breaking Out!", size, size);
    }
    public static void main(String[] args) {
        new BreakoutMain();
        MainWindow = new Window();
        canvas.setBackground(new Color(0,0,0));
        canvas.add(MainWindow.getBackground());
        canvas.animate(dt -> {
                if (canvas.getKeysPressed().contains(Key.LEFT_ARROW)) {
                    MainWindow.getPaddle().getGraphics().moveBy(-5,0);
                    };
            
                if (canvas.getKeysPressed().contains(Key.RIGHT_ARROW)) {
                        MainWindow.getPaddle().getGraphics().moveBy(5,0);
                    }
            if (MainWindow.BallOut(MainWindow.getBall()).updateLivesCounter() || MainWindow.updatePointsCounter(0)) {
                canvas.removeAll();
                MainWindow = new Window();
                canvas.add(MainWindow.getBackground());    
            }
            MainWindow.getBall().Collide(MainWindow.getBall());
            MainWindow.getBall().Collide(MainWindow.getPaddle());

            TileSet.forEach( brick -> {
                if (MainWindow.getBall().IsCollided(brick) && brick.getGraphics() != null) {

                    try {
                    MainWindow.getBackground().remove(brick.getGraphics());
                    MainWindow.getBall().Collide(brick);
                    MainWindow.updatePointsCounter(10);
                    } 
                    catch (Exception e) {}
                }

            });
        });

    }
}
