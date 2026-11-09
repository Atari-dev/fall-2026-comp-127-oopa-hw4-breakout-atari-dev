import edu.macalester.graphics.*;
import edu.macalester.graphics.ui.Button;
public class Window {
    private GraphicsGroup background;
    private GraphicsGroup GameMain;
    private Button start;
    protected Ball attack;
    public Window()
    {
        //rn assumes size is 500
        this.attack = new Ball();
        background = new GraphicsGroup();
          start = new Button("Start Game!");
             start.onClick(() -> SendToGame());
        background.add(start,500*0.4,250);
        background.add(attack.getGraphics(),500*0.4,300);
        //background.add(attack.getGraphics());

        


    }
    /*public int IsBallOut(){
        int result=0;
        if (attack.getGraphics().getCenter().getY()+attack.getRadius()>=500 || attack.getGraphics().getCenter().getX()+attack.getRadius()>=500) 
            {
                if (attack.getGraphics().getCenter().getY() >= attack.getGraphics().getCenter().getX()) result=1;
                else result=2;
            }
        else result=0;
        return result;
    }*/
    public GraphicsGroup getBackground(){return background;}
    public void SendToGame()    {

        System.out.print("Your did it!");

    }

}