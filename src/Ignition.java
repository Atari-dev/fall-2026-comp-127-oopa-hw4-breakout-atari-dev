import edu.macalester.graphics.*;

public class Ignition {
    private static CanvasWindow canvas;
    private static int size=500;
    public Ignition()
    {
        this.canvas = new CanvasWindow("Breaking Out!", size, size);

    }
    public static void main(String[] args) {
        Ignition main = new Ignition();
        Window MainWindow = new Window();
        canvas.add(MainWindow.getBackground(),size*0.4,size/2);
        canvas.add(MainWindow.attack.getGraphics(),200,300);
        //Ball attack = new Ball();
        //canvas.add(attack.getGraphics(),200,300);
        canvas.animate(() -> {
            MainWindow.attack.Gravity();
        });

    }
}
