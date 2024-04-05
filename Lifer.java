/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rounds;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author laptop
 */
public class Lifer {

    int lives = 100;
    
    public void decrease() {
        lives--;
    }
    
    public void draw(Graphics g) {
        int x = 100;
        int y = 50;
        int width = 10;
        int height = 40;
        g.setColor(Color.GREEN);
        g.setFont(new Font("arial", Font.PLAIN, 50));
        g.drawString(""+lives, x, y+180);
        for(int i=0; i<lives; i++) {
            g.fillRect(x+width*i, y+50, width, height);
        }
    }
    
}
