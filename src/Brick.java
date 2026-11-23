import edu.macalester.graphics.*;

public class Brick {
    private Rectangle rect;
    private int width,height;
    public Brick(int x, int y,int width, int height) {
        this.rect = new Rectangle(x,y, width,height);
    }

    public Rectangle getGraphics() {return rect;}

}