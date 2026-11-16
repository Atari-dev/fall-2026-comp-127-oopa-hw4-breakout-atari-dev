import edu.macalester.graphics.*;

public abstract class Collision {
    public abstract GraphicsObject getBoundedArea();

    public void Bonk(Ball attacker)    {
        attacker.getGraphics().getBounds();
    }

    public abstract void Collide(Ball ball);
}