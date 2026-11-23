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

    public void LoseLife() {
        lives--;
    }

    public boolean IsPointMax() {
        if (points >= 500) {
            return true;
        } else
            return false;
    }

}
