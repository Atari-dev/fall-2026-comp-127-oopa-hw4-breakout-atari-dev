import java.awt.Color;

import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsObject;


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
        this.Ball = new Ellipse(-40, -40, diameter, diameter);
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
    if (Defender.getGraphics().equals(null))
    {
        return delete;
    }

CurrentX = getGraphics().getCenter().getX();
CurrentY = getGraphics().getCenter().getY();
boolean hitTop = Defender.getGraphics().testHit(CurrentX, CurrentY - radius);
boolean hitBottom = Defender.getGraphics().testHit(CurrentX, CurrentY + radius);
boolean hitLeft = Defender.getGraphics().testHit(CurrentX- radius, CurrentY);
boolean hitRight = Defender.getGraphics().testHit(CurrentX+ radius, CurrentY);

if (hitTop)
{
    ReverseY();
   delete = true;
}
else if (hitBottom)
{
    ReverseY();
   delete = true;
}

else if (hitRight)
{
    ReverseX();
   delete = true;
}
else if (hitLeft)
{
        ReverseX();
    delete = true;
}
else if (hitRight)
{
    ReverseX();
    delete = true;
}
    return delete;
    }



public boolean IsCollided(Brick Defender) {
    boolean delete=false;
    if (Defender.getGraphics().equals(null))
    {
        return delete;
    }
boolean hitTop = Defender.getGraphics().testHit(CurrentX, CurrentY - radius);
boolean hitBottom = Defender.getGraphics().testHit(CurrentX, CurrentY + radius);
boolean hitLeft = Defender.getGraphics().testHit(CurrentX- radius, CurrentY);
boolean hitRight = Defender.getGraphics().testHit(CurrentX+ radius, CurrentY);



if (hitTop || hitBottom ) {
   delete = true;
}
else if (hitLeft || hitRight) {
    delete = true;
}
    return delete;
    }


public void Collide(Paddle Bonker) {
CurrentX= getGraphics().getCenter().getX();
CurrentY = getGraphics().getCenter().getY();
boolean hitTop = Bonker.getGraphics().testHit(CurrentX, CurrentY - radius);
boolean hitBottom = Bonker.getGraphics().testHit(CurrentX, CurrentY + radius);
boolean hitLeft = Bonker.getGraphics().testHit(CurrentX- radius, CurrentY);
boolean hitRight = Bonker.getGraphics().testHit(CurrentX+ radius, CurrentY);

if (hitTop)
{
    ReverseY();
}
else if (hitBottom)
{
    ReverseY();
}

else if (hitRight)
{
    ReverseX();
}
else if (hitLeft)
{
    ReverseX();
}
else if (hitRight)
{
    ReverseX();
}
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