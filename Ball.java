/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rounds;

import java.util.ArrayList;

/**
 *
 * @author laptop
 */
   public class Ball {
        int x, y;
        int WIDTH = 50;
        int HEIGHT = 50;
        int firstX;
        int secondX;
        int thirdX;
        int fourthX;
        int firstY;
        int secondY;
        int thirdY;
        int fourthY;

        int _firstX;
        int _secondX;
        int _thirdX;
        int _fourthX;
        int _firstY;
        int _secondY;
        int _thirdY;
        int _fourthY;

        ArrayList<Bullet> b2 = new ArrayList<>();
        
        public void shoot(Nazi guy) {
            Bullet bullet = new Bullet(guy);
            bullet.x = x;
            bullet.y = y;
            bullet.shoot(b2);
        }
   }
