/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rounds;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author laptop
 */
public class Rounds extends JPanel {

    Nazi guy;
    Lifer lifer = new Lifer();
    BallMover bm;

    Graphics g;
    ArrayList<Ball> balls = new ArrayList<>();

    Image heroImage, winner, bgImage, bg;
    Image nazi, hero, hero2, enemy, enemy2, enemy3, enemy4;

    Random random = new Random();
    int probe;
    Color randomColor = Color.RED;

    private Image getResource(String str) throws Exception {
        return new ImageIcon(getClass().getResource(str)).getImage();
    }

    private void loadHero() {
        try {
            String str = "nazi.gif";
            if (nazi == null) {
                nazi = getResource(str);
            }
            winner = nazi;
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void loadHeroImage() {
        try {
            String str = "hero.gif";
            if (hero == null) {
                hero = getResource(str);
            }
            heroImage = hero;
        } catch (Exception exc) {
        }
    }

    public void loadHeroImage2() {
        try {
            String str = "boss.gif";
            if (hero2 == null) {
                hero2 = getResource(str);
            }
            heroImage = hero2;
        } catch (Exception exc) {
        }
    }

    public void loadHeroImageOne() {
        try {
            String str = "enemy.gif";
            if (enemy == null) {
                enemy = getResource(str);
            }
            heroImage = enemy;
        } catch (Exception exc) {
        }
    }

    public void loadHeroImageTwo() {
        try {
            String str = "enemy2.gif";
            if (enemy2 == null) {
                enemy2 = getResource(str);
            }
            heroImage = enemy2;
        } catch (Exception exc) {
        }
    }

    public void loadHeroImageThree() {
        try {
            String str = "enemy3.gif";
            if (enemy3 == null) {
                enemy3 = getResource(str);
            }
            heroImage = enemy3;
        } catch (Exception exc) {
        }
    }

    public void loadBgImage() {
        try {
            String str = "bg.jpg";
            if (bg == null) {
                bg = getResource(str);
            }
            bgImage = bg;
        } catch (Exception exc) {
        }
    }    
    
    public void loadHeroImageFour() {
        try {
            String str = "enemy4.gif";
            if (enemy4 == null) {
                enemy4 = getResource(str);
            }
            heroImage = enemy4;
        } catch (Exception exc) {
        }
    }

    private int randomDistance() {
        return random.nextInt(100);
    }

    private int randomDistance2() {
        return random.nextInt(10);
    }

    public void clearScreen() {
        loadBgImage();
        g.drawImage(bgImage, 0, 0, 1200, 700, null);
    }

    public void drawBalls() {
        g.setColor(Color.red);
        for (int i = 0; i < balls.size(); i++) {
            int ballx = balls.get(i).x;
            int bally = balls.get(i).y;
            int ballwidth = balls.get(i).WIDTH;
            int ballheight = balls.get(i).HEIGHT;
            probe();
            g.fillOval(ballx, bally, ballwidth, ballheight);
            g.drawImage(heroImage, ballx, bally, ballwidth, ballheight, null);
        }
    }

    public void drawNazi() {
        g.setColor(Color.BLUE);
        try {
            int x = guy.x;
            int y = guy.y;
            int WIDTH = 50, HEIGHT = 100;
            g.drawImage(winner, x, y, WIDTH, HEIGHT, null);
        } catch (Exception exc) {
        }
    }

    public void probe() {
        probe = random.nextInt(5);
        if (probe == 0) {
            probe = random.nextInt(5);
            if (probe == 0) {
                loadHeroImage();
            } else if (probe == 1) {
                loadHeroImageOne();
            } else if (probe == 2) {
                loadHeroImageTwo();
            } else if (probe == 3) {
                loadHeroImageThree();
            } else if (probe == 4) {
                loadHeroImageFour();
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g = g;
        clearScreen();
        drawNazi();
        if(guy != null)
            drawBullets(guy.getBullets());
        if(guy != null)
            drawBallBullets(guy.getBullets2());
        drawBalls();
        bm.moveBalls();
        lifer.draw(g);
    }

    public void drawBullets(ArrayList<Bullet> b) {
        if(b != null)
        for(int i=0; i<b.size(); i++) {
            g.drawImage(guy.getImage(), b.get(i).x, b.get(i).y, 20, 20, null);
        }
    }

    public void drawBallBullets(ArrayList<Bullet> b) {
        for(int i=0; i<b.size(); i++) {
            g.drawImage(guy.getImage(), b.get(i).x, b.get(i).y, 20, 20, null);
        }
    }

    JFrame frame = new JFrame();

    public Rounds() {
        frame.setLayout(null);
        frame.setBounds(0, 0, 1200, 700);
        frame.add(this);
        frame.setTitle("Screen Saver");
        this.setBounds(frame.getBounds());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        bm = new BallMover(balls);
        bm.createBalls();

        g = this.getGraphics();
        guy = new Nazi(100, 350, balls, lifer, this);
        
        loadHero();
        loadHeroImage();
        setup();
        addMovementForHero();
    }

    private void addMovementForHero() {
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_SPACE:
                        guy.shoot();
                        break;
                    case KeyEvent.VK_LEFT:
                        guy.x -= 40;
                        if(guy.x < 0)
                            guy.x = 1200;
                        break;
                    case KeyEvent.VK_RIGHT:
                        guy.x += 40;
                        if(guy.x > 1200)
                            guy.x = 0;
                        break;
                    case KeyEvent.VK_UP:
                        guy.y -= 40;
                        if(guy.y < 0)
                            guy.y = 700;
                        break;
                    case KeyEvent.VK_DOWN:
                        guy.y += 40;
                        if(guy.y > 700)
                            guy.y = 0;
                        break;
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    public void setup() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        repaint();
                    } catch (Exception exc) {
                    }
                }
            }
        });
        thread.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO codefguy =  application logic here
        new Splashscreen();
   }

}
