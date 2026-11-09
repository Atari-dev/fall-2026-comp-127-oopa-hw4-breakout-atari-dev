import edu.macalester.graphics.*;

public class Ignition {
    private static CanvasWindow canvas;
    private static int size=500;
    public Ignition()
    {
        canvas = new CanvasWindow("Breaking Out!", size, size);

    }
    public static void main(String[] args) {
        Ignition main = new Ignition();
        Window MainWindow = new Window();
        canvas.add(MainWindow.getBackground());
        //Ball attack = new Ball();
        //canvas.add(attack.getGraphics(),200,300);
        canvas.animate(dt -> {
            /*if (MainWindow.IsBallOut()==1){
                MainWindow.attack.ReverseY();
                MainWindow.attack.MoveBall();
            }
            else if (MainWindow.IsBallOut()==2) 
                {
                    MainWindow.attack.ReverseX();
                    MainWindow.attack.MoveBall();
                }
            else {MainWindow.attack.MoveBall();}*/
            MainWindow.attack.Collide();
        });

    }
}
