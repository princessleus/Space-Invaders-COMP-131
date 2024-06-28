import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GraphicsObject {

    private int width;
    private int height;

    public Player(double x, double y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
    	g.setColor(Color.GREEN); 
    	/// draw body
   		g.fillRect((int)x, (int)y, (int)width, (int)height);
   		/// draw projectile cannon 
   		g.fillRect((int)x + 8, (int)y - 10, (int)width/2, (int)height/2); 
    }
}