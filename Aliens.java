import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Aliens extends GraphicsObject {
    double speed_x;
    double speed_y;
    double startPosition;
    double endPosition;
    private int width;
    private int height;

    public Aliens(double x, double y, double speed_x, double speed_y, double width, double height) {
        super(x, y);
        this.speed_x = speed_x;
        this.speed_y = speed_y;
        this.width = (int) width;
        this.height = (int) height;
    }

    public void draw(Graphics g) {
        // body of alien
 	   g.setColor(Color.YELLOW);
	   	g.fillRect((int)x - 4, (int)y - 4, (int)width*7/5, (int)height*7/5);
	   	// face of alien
   	   g.setColor(Color.GREEN);
	   	g.fillRect((int)x, (int)y, (int)width, (int)height);
	   	// eyes of alien
	   	g.setColor(Color.BLACK);
	   	g.fillRect((int)x + 2, (int)y + 4, (int)width/4, (int)height/4);
	   	g.fillRect((int)x + 12, (int)y + 4, (int)width/4, (int)height/4);
	   	// mouth of alien
	   	g.setColor(Color.RED);
	   	g.fillRect((int)x + 7, (int)y + 12, (int)width/4, (int)height/4);
		
    }

    public void update(int pic_width, int pic_height, int frame) {
    	
    	// if the alien reaches the left bound of the canvas, it will turn and move right, also move down
        if (this.x <= 0 && this.speed_x == -5.0) {
            this.x += 1;
            this.y += 20;
            this.speed_x = 5;
        }
        
        // if the alien reaches the right bound of the canvas, it will turn and move left, also move down
        else if (this.x >= 560 && speed_x == 5.0) {
            this.x -= 1;
            this.y += 20;
            this.speed_x = -5;
            
        }
        else {
            this.x += this.speed_x;
            this.y += this.speed_y;
        }
    }
}
