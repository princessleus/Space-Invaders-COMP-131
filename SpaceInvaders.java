/// Melissa Dodson and Princess Leus Project 2
import java.util.ArrayList;
import java.util.Random;

// graphics
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

// events
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// swing
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SpaceInvaders extends JPanel implements ActionListener, KeyListener, Runnable {

    private final int canvasWidth;
    private final int canvasHeight;
    private Color backgroundColor;

    private final int framesPerSecond = 25;
    private final int msPerFrame = 1000 / framesPerSecond;
    private Timer timer;
    private int frame = 0;

    private Player player;
    ArrayList<Aliens> aliens;
    private ArrayList<AliensProjectiles> aliensProjectiles;
    private ArrayList<PlayerProjectiles> playerProjectiles;
    private ArrayList<Destroy> destroyed;
    private ArrayList<Destroy> dead;
    private ArrayList<Aliens> dying;
    private Loser Loss = new Loser(0,0);
    private Winner Win = new Winner(0,0);

    // setting the x and y bounds for the aliens that make up the block of aliens 
    double XLeftBound = 0.0;
    double XRightBound = 800.0;
    double YUp = 0.0;
    double YDown = 100.0;
    double alien_X1 = XLeftBound;
    double alien_Y1 = YUp;
    double alien1_end = 755.0;
    double alien_X2 = XLeftBound + 30;
    double alien_Y2 = YUp;
    double alien2_end = 710.0;
    double alien_X3 = XLeftBound + 60;
    double alien_Y3 = YUp;
    double alien3_end = 665.0;
    double alien_X4 = XLeftBound + 90;
    double alien_Y4 = YUp;
    double alien4_end = 620.0;
    double alien_X5 = XLeftBound + 120;
    double alien_Y5 = YUp;
    double alien5_end = 575.0;
    double alien_X6 = XLeftBound + 150;
    double alien_Y6 = YUp;
    double alien_X7=XLeftBound;
    double alien_Y7 = YUp+30;
    double alien_X8 = XLeftBound+30;
    double alien_Y8=YUp+30;
    double alien_X9=XLeftBound+60;
    double alien_Y9=YUp+30;
    double alien_X10=XLeftBound+90;
    double alien_Y10=YUp+30;
    double alien_X11=XLeftBound+120;
    double alien_Y11=YUp+30;
    double alien_X12=XLeftBound+150;
    double alien_Y12=YUp+30;
    double alien_X13=XLeftBound;
    double alien_Y13=YUp+60;
    double alien_X14=XLeftBound+30;
    double alien_Y14=YUp+60;
    double alien_X15=XLeftBound+60;
    double alien_Y15=YUp+60;
    double alien_X16=XLeftBound+90;
    double alien_Y16=YUp+60;
    double alien_X17=XLeftBound+120;
    double alien_Y17=YUp+60;
    double alien_X18=XLeftBound+150;
    double alien_Y18=YUp+60;
    double alien_X19=XLeftBound;
    double alien_Y19=YUp+90;
    double alien_X20=XLeftBound+30;
    double alien_Y20=YUp+90;
    double alien_X21=XLeftBound+60;
    double alien_Y21=YUp+90;
    double alien_X22=XLeftBound+90;
    double alien_Y22=YUp+90;
    double alien_X23=XLeftBound+120;
    double alien_Y23=YUp+90;
    double alien_X24=XLeftBound+150;
    double alien_Y24=YUp+90;
    double alien_X25=XLeftBound;
    double alien_Y25=YUp+120;
    double alien_X26=XLeftBound+30;
    double alien_Y26=YUp+120;
    double alien_X27 = XLeftBound+60;
    double alien_Y27 = YUp+120;
    double alien_X28 = XLeftBound+90;
    double alien_Y28 = YUp+120;
    double alien_X29 = XLeftBound+120;
    double alien_Y29 = YUp+120;
    double alien_X30 = XLeftBound + 150;
    double alien_Y30 = YUp + 120;


    Random rando= new Random();

    public SpaceInvaders() {
        this.canvasWidth = 800;
        this.canvasHeight = 400;
        this.backgroundColor = Color.black;
        setPreferredSize(new Dimension(this.canvasWidth, this.canvasHeight));

        this.timer = new Timer(msPerFrame, this);
        this.aliens = new ArrayList<>();
        this.aliensProjectiles = new ArrayList<>();
        this.playerProjectiles = new ArrayList<>();
        this.destroyed = new ArrayList<>(); /// array list of destruction to player / stores whether the player has been destroyed by alien or projectile
        this.dead = new ArrayList<>(); /// array list of dead aliens / stores the aliens in the moving block (grid) of aliens that are killed by player
        this.dying=new ArrayList<>();  /// array list used to store number of aliens left 

        player = new Player(300, 300, 30, 30);
        
        // creating the alien block / adding to the array list of aliens 
        aliens.add(new Aliens(alien_X1,alien_Y1,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X2,alien_Y2,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X3,alien_Y3,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X4,alien_Y4,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X5,alien_Y5,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X6,alien_Y6,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X7,alien_Y7,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X8,alien_Y8,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X9,alien_Y9,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X10,alien_Y10,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X11,alien_Y11,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X12,alien_Y12,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X13,alien_Y13,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X14,alien_Y14,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X15,alien_Y15,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X16,alien_Y16,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X17,alien_Y17,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X18,alien_Y18,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X19,alien_Y19,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X20,alien_Y20,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X21,alien_Y21,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X22,alien_Y22,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X23,alien_Y23,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X24,alien_Y24,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X25,alien_Y25,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X26,alien_Y26,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X27,alien_Y27,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X28,alien_Y28,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X29,alien_Y29,5.0,0.1, 20, 20));
        aliens.add(new Aliens(alien_X30,alien_Y30,5.0,0.1, 20, 20));

            }

    @Override
    public void run() {
        display();

        this.timer.start();
    }

    private void display() {
        JFrame jframe = new JFrame();
        jframe.addKeyListener(this);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setContentPane(this);
        jframe.pack();
        jframe.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint(0, 0, this.canvasWidth, this.canvasHeight);
        this.frame++;
    }

    @Override
    protected void paintComponent(Graphics g) {
        clearCanvas(g);
        if (hasWonGame()) {
            paintWinScreen(g);
        } else if (hasLostGame()) {
            paintLoseScreen(g);
        } else {
            paintGameScreen(g);
        }
    }

    private void clearCanvas(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(this.backgroundColor);
        g.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
        g.setColor(oldColor);
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    	/// what happens when the left arrow is pressed, player moves to the left
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.player.x -=10;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        /// what happens when right arrow is pressed, player moves to the right 
            this.player.x += 10;
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
        /// player shoots projectiles
            playerProjectiles.add(new PlayerProjectiles(player.x + 15, player.y, -10.0));
        }
    }

    private void update() {
        this.player.update(this.canvasWidth, this.canvasHeight,frame);
        for(Aliens movingAlienBlock: this.aliens){
            movingAlienBlock.update(this.canvasWidth, this.canvasHeight, frame);
         }
        for(PlayerProjectiles lasers: this.playerProjectiles){
            lasers.update(this.canvasWidth, this.canvasHeight, frame);
        }
        for (AliensProjectiles lasers: this.aliensProjectiles) {
            lasers.update(this.canvasWidth, this.canvasHeight, frame);
        }
    }

    private boolean hasLostGame() {
        //if projectile hits player or right by player (wiggle room), it will be destroyed
        for (AliensProjectiles lasers: this.aliensProjectiles) {
            if (lasers.x >= player.x - 15 && lasers.x <= player.x + 15 && lasers.y >= player.y && lasers.y <= player.y + 15) {
                destroyed.add(new Destroy(player.x, player.y));
            }
        }
        /// if alien touches player or right above player (wiggle room), player will be destroyed
        for (Aliens sprite: this.aliens){
            if (sprite.x >= player.x - 25 && sprite.x <= player.x + 25 && sprite.y + 25 >= player.y && sprite.y + 25 <= player.y + 25){
                destroyed.add(new Destroy(player.x, player.y));
            }
            
            else if (sprite.y + 50 >= player.y){
                destroyed.add(new Destroy(player.x, player.y));
            }
        }
        if (destroyed.size() >= 1){
            return true;
        }
        else {
            return false;
        }
    }

    private boolean hasWonGame() {
    	
    	
        for(PlayerProjectiles projectiles: this.playerProjectiles){
            for(Aliens sprite: this.aliens) {
                Destroy destroy = new Destroy(sprite.x, sprite.y);
                
                /// if the players projectiles hit alien, alien dies, is removed from list, along with the player projectile (disappears)
                if(projectiles.x >= sprite.x && projectiles.x <= sprite.x + 25 && projectiles.y >= sprite.y && projectiles.y <= sprite.y + 25) {
                    dead.add(destroy);
                    aliens.remove(sprite);   
                    playerProjectiles.remove(projectiles);
                    dying.add(sprite);
                }
                
                /// projectiles leaves screen
                if (projectiles.y <= 0){
                    playerProjectiles.remove(projectiles);
                }
            }
        }
        
        /// if all the 30 aliens are dead, player wins
        if (dying.size()>= 30) {
            return true;
        }
        return false;
    }

    private void paintGameScreen(Graphics g) {
        this.player.draw(g);
        for (Aliens aliens: this.aliens){
            aliens.draw(g);

            if (aliens.x == rando.nextInt(550)) {
                aliensProjectiles.add(new AliensProjectiles(aliens.x + 5, aliens.y + 10, 7.0));
                aliensProjectiles.add(new AliensProjectiles(aliens.x + 5, aliens.y + 10, 7.0));
            }
        }
        for (AliensProjectiles projectiles: this.aliensProjectiles) {
            projectiles.draw(g);
        }
        for (PlayerProjectiles projectiles: this.playerProjectiles) {
            projectiles.draw(g);
        }


    }

    private void paintWinScreen(Graphics g) {
        Win.draw(g);
    }

    private void paintLoseScreen(Graphics g) {
        Loss.draw(g);
    }


    public static void main(String[] args) {
        SpaceInvaders invaders = new SpaceInvaders();
        EventQueue.invokeLater(invaders);

    }
}