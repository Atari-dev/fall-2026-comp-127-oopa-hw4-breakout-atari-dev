

import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsObject;
import java.awt.Color;


public class Ball extends Collision
{
    private Ellipse Ball;

    public Ball()   {
        this.Ball = new Ellipse(0, 0, 100, 100);
        this.Ball.setFillColor(new Color(100,200,52));
        
    }

    @Override
    public GraphicsObject getBoundedArea() {
        // TODO Auto-generated method stub
        return null;
    }

    public GraphicsObject getGraphics() {return Ball;}
}