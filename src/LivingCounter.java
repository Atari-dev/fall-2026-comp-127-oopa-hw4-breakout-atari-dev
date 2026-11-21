public class LivingCounter {
    private int Points;
    private int Lives;

    LivingCounter(int Lives)
    {
        Points=0;
        this.Lives=Lives;
    }

    public void update()
    {
        
    }

    public int getPoints() {return Points;}
    
    public int getLives(){return Lives;}


    public void setPoints(int amount)
    {
        Points+=amount;
    }

    public void LoseLife()
    {
        Lives--;
    }


    public boolean IsPointMax()
    {
        if (Points >= 5000) 
            {
                resetGameState();
                Points=0;
                return true;
            }
        else return false;
    }
    
    private void resetGameState()
    {

    }

}
