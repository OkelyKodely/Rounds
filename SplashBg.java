/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rounds;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author laptop
 */
public class SplashBg {

    Image image;
    
    public Image getImage() {
        return new ImageIcon(getClass().getResource("bgs.png")).getImage();
    }
    
    public void draw(Graphics g) {
        g.drawImage(getImage(), 0, 0, 599, 599, null);
    }
}
