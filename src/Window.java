import edu.macalester.graphics.*;
import edu.macalester.graphics.ui.Button;
import java.awt.*;

public class Window {
    private GraphicsGroup background;
    private Button start;
    private GraphicsText PointsCounter;
    private GraphicsText LivesCounter;
    private int i;
    private LivingCounter Counter = new LivingCounter(3);
    private Ball attack;
    private Paddle Pladdle;
    
    public Window() {
        this.PointsCounter = new GraphicsText("Points: "+Counter.getPoints());
        PointsCounter.setFont(FontStyle.PLAIN,15);
        PointsCounter.setFillColor(new Color(255,255,255));

        this.LivesCounter = new GraphicsText("Lives: "+Counter.getLives());
        LivesCounter.setFont(FontStyle.PLAIN,15);
        LivesCounter.setFillColor(new Color(255,255,255));

        this.Pladdle = new Paddle(175, 400, 75, 15);

        this.attack = new Ball(0,0);

        background = new GraphicsGroup();

          start = new Button("Start Game!");
             start.onClick(() -> SendToGame());

        background.add(start,500*0.4,250);
        background.add(Pladdle.getGraphics());
        for (i = 0; i != 50; i++) {
            if (i < 10 && i <20) {
                Brick victim = new Brick(0,0,50,15);
                victim.getGraphics().setFillColor(new Color(0, 145, 235));
                background.add(victim.getGraphics(),i*50,0);
                BreakoutMain.TileSet.add(victim);
                }
            else if (i >= 10 && i < 20) {
                Brick victim = new Brick(0,0,50,15);
                victim.getGraphics().setFillColor(new Color(209, 0, 112));
                background.add(victim.getGraphics(),(i-10)*50,15);
                BreakoutMain.TileSet.add(victim);
                }
            else if (i >= 20 && i < 30) {
                Brick victim = new Brick(0,0,50,15);
                victim.getGraphics().setFillColor(new Color(209, 0, 112));
                background.add(victim.getGraphics(),(i-20)*50,30);
                BreakoutMain.TileSet.add(victim);
                }
            else if (i >= 30 && i < 40) {
                Brick victim = new Brick(0,0,50,15);
                background.add(victim.getGraphics(),(i-30)*50,45);
                victim.getGraphics().setFillColor(new Color(64, 21, 92));
                BreakoutMain.TileSet.add(victim);
                }
            else if (i >= 40 && i < 50) {
                Brick victim = new Brick(0,0,50,15);
                background.add(victim.getGraphics(),(i-40)*50,60);
                victim.getGraphics().setFillColor(new Color(64, 21, 92));
                BreakoutMain.TileSet.add(victim);
                }
        }
        background.add(PointsCounter,10,485);
        background.add(LivesCounter,440,485);
    }

    public GraphicsGroup getBackground() {return background;}

    public Ball getBall() {return this.attack;}

    public Paddle getPaddle() {return this.Pladdle;}

    
    public boolean SendToGame() {
        background.remove(start);
        this.attack = new Ball(5,-5);
        background.add(attack.getGraphics(),250,250);
        return true;
    }

    public Window BallOut(Ball ball) {

        if (ball.getGraphics().getY() >= 420) {

                Counter.LoseLife();
                ball.getGraphics().setPosition(250,250);
                ball.ReverseY();
            }

        
    return this;
    }

    public boolean updatePointsCounter(int amount) {

        Counter.setPoints(amount);
        PointsCounter.setText("Points: "+Counter.getPoints());
    return Counter.IsPointMax();}

    public boolean updateLivesCounter() {

        LivesCounter.setText("Lives: "+Counter.getLives());
        if (Counter.getLives() == 0) {
            return true;
        }
    return false;
    }
    
}