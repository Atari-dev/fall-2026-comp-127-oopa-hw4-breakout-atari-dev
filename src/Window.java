import java.util.ArrayList;

import edu.macalester.graphics.*;
import edu.macalester.*;
import edu.macalester.graphics.ui.Button;
import java.awt.*;
import edu.macalester.graphics.Rectangle;

import java.awt.Color;
public class Window {
    private GraphicsGroup background;
    private Button start;
    protected Ball attack;
    protected Ball attack2;
    protected Brick test;
    private int i;
    public Window()
    {
        //rn assumes size is 500
        this.attack = new Ball(5,5);
        this.attack2 = new Ball(5,0);
        background = new GraphicsGroup();
          start = new Button("Start Game!");
             start.onClick(() -> SendToGame());
        this.test = new Brick(0,0, 20, 25);
        background.add(start,500*0.4,250);
        background.add(attack.getGraphics(),150,300);
        background.add(test.getGraphics(),150,40);

        for (i = 0; i != 50; i++) {
            if (i < 10 && i <20)
                {
                    System.out.println("step 1");
                Brick victim = new Brick(0,0,50,15);
                victim.getGraphics().setFillColor(new Color(0, 145, 235));
                background.add(victim.getGraphics(),i*50,0);
                Ignition.TileSet.add(victim);
                }
            else if (i >= 10 && i < 20)
                {
                Brick victim = new Brick(0,0,50,15);
                victim.getGraphics().setFillColor(new Color(209, 0, 112));
                background.add(victim.getGraphics(),(i-10)*50,15);
                Ignition.TileSet.add(victim);
                System.out.println("step 2");
                }
            else if (i >= 20 && i < 30)
                {
                Brick victim = new Brick(0,0,50,15);
                victim.getGraphics().setFillColor(new Color(209, 0, 112));
                background.add(victim.getGraphics(),(i-20)*50,30);
                Ignition.TileSet.add(victim);
                System.out.println("step 3");
                }
            else if (i >= 30 && i < 40)
                {
                Brick victim = new Brick(0,0,50,15);
                background.add(victim.getGraphics(),(i-30)*50,45);
                victim.getGraphics().setFillColor(new Color(64, 21, 92));
                Ignition.TileSet.add(victim);
                System.out.println("step 4");
                }
            else if (i >= 40 && i < 50)
                {
                Brick victim = new Brick(0,0,50,15);
                background.add(victim.getGraphics(),(i-40)*50,60);
                victim.getGraphics().setFillColor(new Color(64, 21, 92));
                Ignition.TileSet.add(victim);
                System.out.println("step 5");
                }
        }
    }
    public GraphicsGroup getBackground(){return background;}
    public boolean SendToGame()    {
        System.out.print("Your did it!");
        background.remove(start);
        return true;
    }

}