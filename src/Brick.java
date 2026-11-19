import edu.macalester.graphics.*;

public class Brick extends Collision {
    private Rectangle rect;
    private int size;
    public Brick(){
        this.rect = new Rectangle(0,0, 75,25);
    }

    public GraphicsObject getGraphics(){return rect;}
    @Override
    public GraphicsObject getBoundedArea() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoundedArea'");
    }

    @Override
    public void Collide(Ball attacker) {
        if (getGraphics().testHit(attacker.getGraphics().getX(),attacker.getGraphics().getY()))
        {
            System.out.println("yay");
            attacker.ReverseY();
            
        }
    }


}