import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsObject;
import java.awt.Color;


public class Ball extends Collision
{
    private Ellipse Ball;
    private int diameter=16;
    private int radius=diameter/2;
    private double SpeedX;
    private double SpeedY;
    private final double GravY = 1;
    private double CurrentX;
    private double CurrentY;

    public Ball(int SpeedX,int SpeedY)   {
        this.Ball = new Ellipse(0, 0, diameter, diameter);
        this.Ball.setFillColor(new Color(100,200,52));
        this.SpeedX=SpeedX;
        this.SpeedY=SpeedY;
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

public boolean Collide(Brick Defender) {
boolean delete=false;
double cx = getGraphics().getCenter().getX();
double cy = getGraphics().getCenter().getY();
boolean hitTop = Defender.getGraphics().testHit(cx, cy - radius);
boolean hitBottom = Defender.getGraphics().testHit(cx, cy + radius);
boolean hitLeft = Defender.getGraphics().testHit(cx - radius, cy);
boolean hitRight = Defender.getGraphics().testHit(cx + radius, cy);



if (hitTop || hitBottom ) {
    ReverseY();
   delete = true;
}
else if (hitLeft || hitRight) {
    ReverseX();
    delete = true;
}
    return delete;
    }

    public GraphicsObject getGraphics() {return Ball;}

    public int getRadius() {return diameter/2;}
    public double getSpeedY() {return SpeedY;}
    public double getSpeedX() {return SpeedX;}

    public void ReverseY() {SpeedY *= -1;}
    public void ReverseX() {SpeedX *= -1;}

    public void MoveBall()
    {
        CurrentX = Ball.getX();
        CurrentY = Ball.getY();
        Ball.moveBy(SpeedX,SpeedY);

    }
}