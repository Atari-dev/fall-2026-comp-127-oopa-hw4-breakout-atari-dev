import java.awt.Color;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsObject;

public class Ball {
    private Ellipse ball;
    private int diameter = 16;
    private int radius = diameter / 2;
    private double speedX;
    private double speedY;
    private double currentX;
    private double currentY;

    public Ball(int speedX, int speedY) {
        this.ball = new Ellipse(-40, -40, diameter, diameter);
        this.ball.setFillColor(new Color(0, 255, 0));
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public int IsBallOut(Ball ballIn) {
        currentX = ball.getCenter().getX();
        currentY = ball.getCenter().getY();
        int result = 0;
        if ((currentY + radius >= 500 || currentX + radius >= 500)) {
            if (currentY >= currentX)
                result = 1;
            else
                result = 2;
        } else
            result = 0;

        if (currentY - radius <= 0 || currentX - radius <= 0) {
            if (currentY <= currentX)
                result = 1;
            else
                result = 2;
        }
        return result;
    }

    public void Collide(Ball ball) { // based on how result is set (0-2) it knows which way it needs to reverse
        if (IsBallOut(this) == 1) {
            this.ReverseY();
            this.MoveBall();
        } else if (IsBallOut(this) == 2) {
            this.ReverseX();
            this.MoveBall();
        } else
            this.MoveBall();
    }

    public boolean Collide(Brick defender) {
        boolean delete = false;
        if (defender.getGraphics().equals(null)) {
            return delete;
        }

        currentX = getGraphics().getCenter().getX();
        currentY = getGraphics().getCenter().getY();
        boolean hitTop = defender.getGraphics().testHit(currentX, currentY - radius);
        boolean hitBottom = defender.getGraphics().testHit(currentX, currentY + radius);
        boolean hitLeft = defender.getGraphics().testHit(currentX - radius, currentY);
        boolean hitRight = defender.getGraphics().testHit(currentX + radius, currentY);

        if (hitTop) {
            ReverseY();
            delete = true;
        } else if (hitBottom) {
            ReverseY();
            delete = true;
        }

        else if (hitRight) {
            ReverseX();
            delete = true;
        } else if (hitLeft) {
            ReverseX();
            delete = true;
        } else if (hitRight) {
            ReverseX();
            delete = true;
        }
        return delete;
    }

    public boolean IsCollided(Brick defender) {
        boolean delete = false;
        if (defender.getGraphics().equals(null)) {
            return delete;
        }
        boolean hitTop = defender.getGraphics().testHit(currentX, currentY - radius);
        boolean hitBottom = defender.getGraphics().testHit(currentX, currentY + radius);
        boolean hitLeft = defender.getGraphics().testHit(currentX - radius, currentY);
        boolean hitRight = defender.getGraphics().testHit(currentX + radius, currentY);

        if (hitTop || hitBottom) {
            delete = true;
        } else if (hitLeft || hitRight) {
            delete = true;
        }
        return delete;
    }

    public void Collide(Paddle bonker) {
        currentX = getGraphics().getCenter().getX();
        currentY = getGraphics().getCenter().getY();

        boolean hitBottom = bonker.getGraphics().testHit(currentX, currentY + radius);
        boolean hitLeft = bonker.getGraphics().testHit(currentX - radius, currentY);
        boolean hitRight = bonker.getGraphics().testHit(currentX + radius, currentY);

        if (hitBottom) {
            ReverseY();
        } else if (hitLeft) {
            ReverseX();
        } else if (hitRight) {
            ReverseX();
        }

    }

    public GraphicsObject getGraphics() {
        return ball;
    }

    public int getRadius() {
        return radius;
    }

    public double getSpeedY() {
        return speedY;
    }

    public double getSpeedX() {
        return speedX;
    }

    public void ReverseY() {
        speedY *= -1;
    }

    public void ReverseX() {
        speedX *= -1;
    }

    public void MoveBall() {
        currentX = ball.getX();
        currentY = ball.getY();
        ball.moveBy(speedX, speedY);

    }
}