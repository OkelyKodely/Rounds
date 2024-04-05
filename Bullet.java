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
public class Bullet {

    Nazi guy;
    
    int x, y;
    
    int theX, theY;
    
    ArrayList<Ball> balls;

    public Bullet(Nazi guy) {
        this.guy = guy;
    }
    
    public Bullet(ArrayList<Ball> balls) {this.balls = balls;}
    
    public void shoot(ArrayList<Bullet> b) {
        b.add(this);
    }
    
    public boolean isGuyHit() {
        boolean ishit = false;
        if(x >= guy.x && x <= guy.x+50 &&
                y >= guy.y && y <= guy.y+100) {
            return true;
        }
        return false;
    }
    
    public boolean isHit() {
        boolean ishit = false;
        boolean fals = false;
        for(int i=0; i<balls.size(); i++) {
            theX = balls.get(i).x;
            theY = balls.get(i).y;
            if(x >= theX && x <= theX+20
		&& y >= theY && y <= theY+20) {
                ishit = true;
                if(ishit)
                    balls.remove(balls.get(i));
                return ishit;
            } else {
                ishit = false;
            }
        }
        return ishit;
    }
    
}
