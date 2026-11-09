import edu.macalester.graphics.*;

public abstract class Collision {
    public abstract GraphicsObject getBoundedArea();

    public void Bonk(GraphicsObject Defender)    {


        
    }

    public int IsBallOut(Ball ball){
        int result=0;
        if ((ball.getGraphics().getCenter().getY()+ball.getRadius()>=500 || ball.getGraphics().getCenter().getX()+ball.getRadius()>=500)) 
            {
                if (ball.getGraphics().getCenter().getY() >= ball.getGraphics().getCenter().getX()) result=1;
                else result=2;
            }
        else result=0;


        if (ball.getGraphics().getCenter().getY()-ball.getRadius()<=0 || ball.getGraphics().getCenter().getX()-ball.getRadius()<=0)
        {
                    if ((ball.getGraphics().getCenter().getY()+ball.getRadius()>=500 || ball.getGraphics().getCenter().getX()+ball.getRadius()>=500)) 
            {
                if (ball.getGraphics().getCenter().getY() >= ball.getGraphics().getCenter().getX()) result=1;
                else result=2;
            }
        }
        return result;}

    public abstract void Collide();
}