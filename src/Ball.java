

import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsObject;
import java.awt.Color;


public class Ball extends Collision
{
    private Ellipse Ball;
    private int diameter=15;
    private double SpeedX=5;
    private double SpeedY=5;
    private final double GravY = 1;
    private double CurrentX;
    private double CurrentY;

    public Ball()   {
        this.Ball = new Ellipse(0, 0, diameter, diameter);
        this.Ball.setFillColor(new Color(100,200,52));
    }

    @Override
    public GraphicsObject getBoundedArea() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override 
    public void Collide(){
                    if (IsBallOut(this)==1){
                this.ReverseY();
                this.MoveBall();
            }
            else if (IsBallOut(this)==2) 
                {
                    this.ReverseX();
                    this.MoveBall();
                }
            else this.MoveBall();}


    public GraphicsObject getGraphics() {return Ball;}

    public int getRadius() {return diameter/2;}

    public void ReverseY() {SpeedY *= -1;}
    public void ReverseX() {SpeedX *= -1;}

    public void MoveBall()
    {
        CurrentX = Ball.getCenter().getX();
        CurrentY = Ball.getCenter().getY();
        Ball.setCenter((CurrentX+SpeedX), (CurrentY+SpeedY));

    }
}