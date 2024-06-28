import java.awt.Color;
import java.awt.Graphics;

public class Loser extends GraphicsObject {
    int x;
    int y;

    public Loser(int x, int y){
        super(x, y);
    }

    // draws loser screen
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.drawString("You Lose :( Game Over.", 300, 200);
    }
}
