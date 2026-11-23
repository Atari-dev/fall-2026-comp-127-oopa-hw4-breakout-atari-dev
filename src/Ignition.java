import java.awt.*;
import java.util.ArrayList;
import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;

public class Ignition {
    private static CanvasWindow canvas;
    private static int size=500;
    private static Window MainWindow;
    protected static ArrayList<Brick> TileSet = new ArrayList<Brick>();
    public Ignition()
    {
        canvas = new CanvasWindow("Breaking Out!", size, size);


    }
    public static void main(String[] args) {
        new Ignition();
        MainWindow = new Window();
        canvas.setBackground(new Color(0,0,0));
        canvas.add(MainWindow.getBackground());
        canvas.animate(dt -> {
                if (canvas.getKeysPressed().contains(Key.LEFT_ARROW))
                    {
                        MainWindow.Pladdle.getGraphics().moveBy(-5,0);
                    };
            
                if (canvas.getKeysPressed().contains(Key.RIGHT_ARROW))
                    {
                        MainWindow.Pladdle.getGraphics().moveBy(5,0);
                    };
            if (MainWindow.BallOut(MainWindow.attack).updateLivesCounter() || MainWindow.updatePointsCounter(0))
            {
                canvas.removeAll();
                MainWindow = new Window();
                canvas.add(MainWindow.getBackground());
                
            }
            MainWindow.attack.Collide(MainWindow.attack);
            MainWindow.attack.Collide(MainWindow.Pladdle);

            TileSet.forEach( brick -> {
                if (MainWindow.attack.IsCollided(brick) && brick.getGraphics() != null)
                {

                    try {
                    MainWindow.getBackground().remove(brick.getGraphics());
                    MainWindow.attack.Collide(brick);
                    
                    if(MainWindow.updatePointsCounter(10))
                    {
                        
                    }
                    } catch (Exception e) {

                    }


                }

            });
        });

    }
}
