/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rounds;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;

/**
 *
 * @author laptop
 */
public class Nazi {

    Lifer lifer;
    Rounds r;

    int x, y;

    ArrayList<Bullet> b;
    ArrayList<Ball> balls;

    Graphics g;
    Image bimg;

    AudioInputStream ais;
    Clip clip;

    public Nazi(int x, int y, ArrayList<Ball> balls, Lifer lifer, Rounds r) {
        this.r = r;
        this.balls = balls;
        this.lifer = lifer;
        this.x = x;
        this.y = y;
        b = new ArrayList<>();
        bimg();
        createShooterThread(g);

        try {
            String filename = "ack.wav";
            URL url = this.getClass().getResource(filename);
            ais = AudioSystem.getAudioInputStream(url);
            DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(ais);
        } catch (Exception e) {

        }
    }

    public Image getImage() {
        return bimg;
    }

    private void bimg() {
        try {
            bimg = new ImageIcon(getClass().getResource("bullet.gif")).getImage();
        } catch (Exception exc) {
        }
    }

    private void createShooterThread(Graphics graphics) {
        this.g = graphics;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        for (int i = 0; i < b.size(); i++) {
                            int move = 10;
                            b.get(i).x += move;
                            if(b.get(i).x > 1200)
                                b.remove(b.get(i));
                            if (b.get(i).isHit()) {
                                Thread thread0 = new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            String filename = "ack.wav";
                                            URL url = this.getClass().getResource(filename);
                                            ais = AudioSystem.getAudioInputStream(url);
                                            DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
                                            clip = (Clip) AudioSystem.getLine(info);
                                            clip.open(ais);
                                            clip.start();
                                            //clip.close();            // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY); 

                                            // If you want to stop the sound, then use clip.stop();
                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                });

                                thread0.start();
                            }
                        }
                        for (int i = 0; i < balls.size(); i++) {
                            for (int j = 0; j < balls.get(i).b2.size(); j++) {
                                int move = 10;
                                balls.get(i).b2.get(j).x -= move;
                                if (balls.get(i).b2.get(j).isGuyHit()) {
                                    lifer.decrease();
                                    if (lifer.lives == 0) {
                                        new Splashscreen();
                                        r.frame.dispose();
                                    }
                                    Thread thread0 = new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                String filename = "ack.wav";
                                                URL url = this.getClass().getResource(filename);
                                                ais = AudioSystem.getAudioInputStream(url);
                                                DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
                                                clip = (Clip) AudioSystem.getLine(info);
                                                clip.open(ais);
                                                clip.start();
                                                //clip.close();            // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY); 

                                                // If you want to stop the sound, then use clip.stop();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        }
                                    });

                                    thread0.start();
                                }
                            }
                        }
                        for (int i = 0; i < balls.size(); i++) {
                            int x = balls.get(i).x;
                            int y = balls.get(i).y;
                            Random random = new Random();
                            int v = random.nextInt(5000);
                            if (v == 1) {
                                balls.get(i).shoot(Nazi.this);
                            }
                            if (isHit(balls.get(i))) {
                                Thread thread0 = new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            String filename = "ack.wav";
                                            URL url = this.getClass().getResource(filename);
                                            ais = AudioSystem.getAudioInputStream(url);
                                            DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
                                            clip = (Clip) AudioSystem.getLine(info);
                                            clip.open(ais);
                                            clip.start();
                                            //clip.close();            // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY); 

                                            // If you want to stop the sound, then use clip.stop();
                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                });

                                thread0.start();
                            }
                        }

                        Thread.sleep(10);
                    } catch (Exception exc) {
                    }
                }
            }
        }
        );
        thread.start();
    }

    public void shoot() {
        Bullet bullet = new Bullet(balls);
        bullet.x = x;
        bullet.y = y;
        bullet.shoot(b);
    }

    public ArrayList<Bullet> getBullets() {
        return b;
    }

    public ArrayList<Bullet> getBullets2() {
        ArrayList<Bullet> myBullets = new ArrayList<>();
        for (int i = 0; i < balls.size(); i++) {
            for (int j = 0; j < balls.get(i).b2.size(); j++) {
                myBullets.add(balls.get(i).b2.get(j));
            }
        }
        return myBullets;
    }

    public boolean isHit(Ball ball) {
        boolean ishit = false;
        boolean fals = false;
        int theX = ball.x;
        int theY = ball.y;
        if (x >= theX && x <= theX + 50
                && y >= theY && y <= theY + 100) {
            ishit = true;
            if (ishit) {
                balls.remove(ball);
            }
            return ishit;
        } else {
            ishit = false;
        }
        return ishit;
    }
}
