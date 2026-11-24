/**
 * Keeps track of both Points and Lives, and increments/decrements them as
 * needed.
 */

public class LivingCounter {

    private int points;
    private int lives;

    LivingCounter(int Lives) {
        points = 0;
        this.lives = Lives;
    }

    public int getPoints() {
        return points;
    }

    public int getLives() {
        return lives;
    }

    public void setPoints(int amount) {
        points += amount;
    }

    public void loseLife() {
        lives--;
    }

    public boolean isPointsMax() {
        if (points >= 500) {
            return true;
        } else
            return false;
    }

}
