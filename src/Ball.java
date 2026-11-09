

import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsObject;
import java.awt.Color;


public class Ball extends Collision
{
    private Ellipse Ball;
    private int radius=15;
    private double SpeedX;
    private double SpeedY;
    private final double GravY = 1;
    private double CurrentX;
    private double CurrentY;

    public Ball()   {
        this.Ball = new Ellipse(0, 0, radius, radius);
        this.Ball.setFillColor(new Color(100,200,52));
    }

    @Override
    public GraphicsObject getBoundedArea() {
        // TODO Auto-generated method stub
        return null;
    }

    public GraphicsObject getGraphics() {return Ball;}
    public int getRadius() {return radius;}
    public void Gravity()
    {
        CurrentX = Ball.getCenter().getX();
        CurrentY = Ball.getCenter().getY();
        Ball.setCenter(CurrentX, CurrentY+GravY);

    }
}