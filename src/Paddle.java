import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

public class Paddle {
        private Rectangle rect;
    private int width,height;
    public Paddle(int x, int y,int width, int height){
        this.rect = new Rectangle(x,y, width,height);
    }

    public Rectangle getGraphics(){return rect;}
}
