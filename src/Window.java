import edu.macalester.graphics.*;
import edu.macalester.graphics.ui.Button;
public class Window {
    private GraphicsGroup background;
    private GraphicsGroup GameMain;
    private Button start;
    protected Ball attack;
    protected Brick test;
    public Window()
    {
        //rn assumes size is 500
        this.test = new Brick();
        this.attack = new Ball();
        background = new GraphicsGroup();
          start = new Button("Start Game!");
             start.onClick(() -> SendToGame());
        background.add(start,500*0.4,250);
        background.add(attack.getGraphics(),500*0.4,310);
        background.add(test.getGraphics(),150,40);
    }
    public GraphicsGroup getBackground(){return background;}
    public void SendToGame()    {

        System.out.print("Your did it!");

    }

}