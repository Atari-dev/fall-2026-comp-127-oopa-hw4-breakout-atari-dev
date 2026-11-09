import edu.macalester.graphics.*;
import edu.macalester.graphics.ui.Button;
public class Window {
    private GraphicsGroup background;
    private GraphicsGroup GameMain;
    private Button start;
    protected Ball attack;
    public Window()
    {
        this.attack = new Ball();
        background = new GraphicsGroup();
          start = new Button("Start Game!");
             start.onClick(() -> SendToGame());
        background.add(start);
        //background.add(attack.getGraphics());

        


    }
    
    public boolean KeepBallBounded(){
        if (attack.getCenter().getY()+attack.getRadius()>=500){
        }
    }
    public GraphicsGroup getBackground(){return background;}
    public void SendToGame()    {

        System.out.print("Your did it!");

    }

}