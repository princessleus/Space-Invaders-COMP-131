import java.awt.Color;
import java.awt.Graphics;

public class AliensProjectiles extends GraphicsObject {
    double speed_y;

    public AliensProjectiles(double x, double y, double speed_y){
        super(x,y);
        this.speed_y = speed_y;
    }

    public void draw(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect((int)x, (int)y, 5, 10);

    }

    public void update(int pic_width, int pic_height, int frame) {
        this.y += this.speed_y;
    }
}
