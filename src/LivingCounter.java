public class LivingCounter {
    private int Points;
    private int Lives;

    LivingCounter(int Lives) {
        Points=0;
        this.Lives=Lives;
    }

    public int getPoints() {return Points;}
    
    public int getLives(){return Lives;}


    public void setPoints(int amount) {
        Points+=amount;
    }

    public void LoseLife() {
        Lives--;
    }


    public boolean IsPointMax() {
        if (Points >= 500) {
                return true;
            }
        else return false;
    }

}
