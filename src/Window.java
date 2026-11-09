import edu.macalester.graphics.*;
import edu.macalester.graphics.ui.Button;
public class Window {

    private GraphicsGroup background;
    private Button start;
    public Window(int size)
    {
        background = new GraphicsGroup();
          start = new Button("Start Game!");
             start.onClick(() -> SendToGame());
        background.add(start);


    }

    public GraphicsGroup getGraphicsGroup(){return background;}
    public void SendToGame()    {
        System.out.print("Your did it!");

    }

}