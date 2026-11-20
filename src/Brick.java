import edu.macalester.graphics.*;

public class Brick extends Collision {
    private Rectangle rect;
    private int width,height;
    public Brick(int x, int y,int width, int height){
        this.rect = new Rectangle(x,y, width,height);
    }

    public Rectangle getGraphics(){return rect;}
    @Override
    public GraphicsObject getBoundedArea() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoundedArea'");
    }

    @Override
    public void Collide(Ball ball) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Collide'");
    }

}