import java.awt.Color;
import edu.macalester.graphics.*;

/**
 * The players movable paddle used to hit the ball up
 */

public class Paddle {
    private Rectangle rect;

    /**
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Paddle(int x, int y, int width, int height) {
        this.rect = new Rectangle(x, y, width, height);
        this.rect.setFillColor(new Color(222, 18, 18));
    }

    public Rectangle getGraphics() {
        return rect;
    }
}
