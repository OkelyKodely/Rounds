/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rounds;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author laptop
 */
public class Splashscreen {

    Rounds r;

    JFrame frame0;

    public class Dlg extends JDialog {

        public Dlg(JFrame frame, String str) {
            super(frame, str);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    System.exit(0);
                }
            });
        }
    }

    public Splashscreen() {
        frame0 = new JFrame();
        Dlg frame = new Dlg(frame0, "");
        frame.setLayout(null);
        frame.setBounds(100, 100, 599, 599);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Graphics g = frame.getGraphics();

                    SplashBg bg = new SplashBg();
                    bg.draw(g);

                    g.setFont(new Font("arial", Font.PLAIN, 60));
                    int x = 100;
                    int y = 530;
                    for (int i = 0; i < 20; i++) {
                        Thread.sleep(50);
                        g.setColor(Color.BLACK);
                        g.drawString("NAZI", 100, 300);
                        g.setColor(Color.MAGENTA);
                        g.drawString("Loading...", 50, 500);
                        g.drawString(".", 300 + i * 20, 500);
                        
                        g.setColor(Color.BLACK);
                        g.fillRect(x+i*10, y, 100, 20);
                    }

                    Thread.sleep(1000);

                    r = new Rounds();

                    frame.dispose();

                } catch (Exception exc) {

                }
            }
        });
        thread.start();
    }
}
