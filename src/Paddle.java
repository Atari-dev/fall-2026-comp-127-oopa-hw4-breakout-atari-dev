import java.awt.Color;

import edu.macalester.graphics.*;

public class Paddle {
        private Rectangle rect;
    public Paddle(int x, int y,int width, int height){
        this.rect = new Rectangle(x,y, width,height);
        this.rect.setFillColor(new Color(222, 18, 18));
    }

    public Rectangle getGraphics(){return rect;}
}
