import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsObject;
import java.awt.Color;


public class Ball extends Collision
{
    private Ellipse Ball;
    private int diameter=15;
    private int radius=diameter/2;
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
        
        return null;
    }
public int IsBallOut(Ball ball){
        CurrentX = Ball.getCenter().getX();
        CurrentY = Ball.getCenter().getY();
        int result=0;
        if ((CurrentY+radius>=500 || CurrentX+radius>=500)){
                if (CurrentY >= CurrentX) result=1;
                else result=2;
            }
        else result=0;

        if (CurrentY-radius<=0 || CurrentX-radius<=0){
            {
                if (CurrentY <= CurrentX) result=1;
                else result=2;
            }
        }
        return result;}


    @Override 
    public void Collide(Ball ball){ //based on how result is set (0-2) it knows which way it needs to reverse
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

    public int getradius() {return diameter/2;}

    public void ReverseY() {SpeedY *= -1;}
    public void ReverseX() {SpeedX *= -1;}

    public void MoveBall()
    {
        CurrentX = Ball.getCenter().getX();
        CurrentY = Ball.getCenter().getY();
        Ball.setCenter((CurrentX+SpeedX), (CurrentY+SpeedY));

    }
}