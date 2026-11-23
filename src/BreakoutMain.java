import java.awt.*;
import java.util.ArrayList;
import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;

public class BreakoutMain {
    private static CanvasWindow canvas;
    private int size = 500;
    private static Window mainWindow;
    public static ArrayList<Brick> tileSet = new ArrayList<Brick>();

    public BreakoutMain() {
        canvas = new CanvasWindow("Breaking Out!", size, size);
    }

    public static void main(String[] args) {
        new BreakoutMain();
        mainWindow = new Window();
        canvas.setBackground(new Color(0, 0, 0));
        canvas.add(mainWindow.getBackground());
        canvas.animate(dt -> {
            if (canvas.getKeysPressed().contains(Key.LEFT_ARROW)) {
                mainWindow.getPaddle().getGraphics().moveBy(-5, 0);
            }
            ;

            if (canvas.getKeysPressed().contains(Key.RIGHT_ARROW)) {
                mainWindow.getPaddle().getGraphics().moveBy(5, 0);
            }
            if (mainWindow.BallOut(mainWindow.getBall()).updateLivesCounter() || mainWindow.updatePointsCounter(0)) {
                canvas.removeAll();
                mainWindow = new Window();
                canvas.add(mainWindow.getBackground());
            }
            mainWindow.getBall().Collide(mainWindow.getBall());
            mainWindow.getBall().Collide(mainWindow.getPaddle());

            tileSet.forEach(brick -> {
                if (mainWindow.getBall().IsCollided(brick) && brick.getGraphics() != null) {

                    try {
                        mainWindow.getBackground().remove(brick.getGraphics());
                        mainWindow.getBall().Collide(brick);
                        mainWindow.updatePointsCounter(10);
                    } catch (Exception e) {
                    }
                }

            });
        });

    }
}
