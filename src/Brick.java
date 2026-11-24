import edu.macalester.graphics.*;

/**
 * A brick to be drawn to the screen and hit for points.
 * @param x
 * @param y
 * @param width
 * @param height
 * @return a Brick object with graphics attached.
 */

public class Brick {
    private Rectangle rect;

    public Brick(int x, int y, int width, int height) {
        this.rect = new Rectangle(x, y, width, height);
    }

    public Rectangle getGraphics() {
        return rect;
    }

}