import java.awt.Color;

import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsObject;

/**
 * The ball that bounces around the screen.
 * 
 * @param speedX
 * @param speedY
 * @return a Ball object with graphics and collison logic.
 */

public class Ball {
    private Ellipse ball;
    private final int diameter = 16;
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

    /**
     * Tests if the ball is out of bounds and sets a number from 0-2, 0 meaning in
     * bounds, 1 meaning out of bounds on the bottom and right edge of the ball,
     * 2 meaning out of bounds on the left and top edge of the ball.
     */
    public int isBallOut(Ball ballIn) {
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

    /**
     * Uses IsBallOut result to determine which direction to reverse and reverses
     * the ball.
     */
    public void collide(Ball ball) {
        if (isBallOut(this) == 1) {
            this.reverseY();
            this.moveBall();
        } else if (isBallOut(this) == 2) {
            this.reverseX();
            this.moveBall();
        } else
            this.moveBall();
    }

    /**
     * detects collison between a Brick and a ball, and changes the ball direction
     * if true.
     */
    public void collide(Brick defender) {
        if (defender.getGraphics().equals(null)) {
            return;
        }

        currentX = getGraphics().getCenter().getX();
        currentY = getGraphics().getCenter().getY();
        boolean hitTop = defender.getGraphics().testHit(currentX, currentY - radius);
        boolean hitBottom = defender.getGraphics().testHit(currentX, currentY + radius);
        boolean hitLeft = defender.getGraphics().testHit(currentX - radius, currentY);
        boolean hitRight = defender.getGraphics().testHit(currentX + radius, currentY);

        if (hitTop) {
            reverseY();
        } else if (hitBottom) {
            reverseY();
        }

        else if (hitRight) {
            reverseX();
        } else if (hitLeft) {
            reverseX();
        } else if (hitRight) {
            reverseX();
        }
    }

    /**
     * only asks if Collison occured, then returns true if it should be deleted.
     */
    public boolean isCollided(Brick defender) {
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

    /**
     * Special case of Collide for the paddle, only checks the bottom and sides of
     * the ball.
     */
    public void collide(Paddle bonker) {
        currentX = getGraphics().getCenter().getX();
        currentY = getGraphics().getCenter().getY();

        boolean hitBottom = bonker.getGraphics().testHit(currentX, currentY + radius);
        boolean hitLeft = bonker.getGraphics().testHit(currentX - radius, currentY);
        boolean hitRight = bonker.getGraphics().testHit(currentX + radius, currentY);

        if (hitBottom) {
            reverseY();
        } else if (hitLeft) {
            reverseX();
        } else if (hitRight) {
            reverseX();
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

    public void reverseY() {
        speedY *= -1;
    }

    public void reverseX() {
        speedX *= -1;
    }

    public void moveBall() {
        currentX = ball.getX();
        currentY = ball.getY();
        ball.moveBy(speedX, speedY);

    }
}