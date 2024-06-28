import java.awt.Color;
import java.awt.Graphics;

public class Winner extends GraphicsObject {
    int x;
    int y;

    public Winner(int x, int y){
        super(x, y);
    }

    // draws winner screen
    public void draw(Graphics g){
        g.setColor(Color.GREEN);
        g.drawString("You Win! :D", 300, 200);
    }
}