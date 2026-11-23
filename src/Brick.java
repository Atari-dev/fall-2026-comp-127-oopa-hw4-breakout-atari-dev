import edu.macalester.graphics.*;

public class Brick {
    private Rectangle rect;

    public Brick(int x, int y, int width, int height) {
        this.rect = new Rectangle(x, y, width, height);
    }

    public Rectangle getGraphics() {
        return rect;
    }

}