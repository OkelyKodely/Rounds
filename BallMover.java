/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rounds;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author laptop
 */
public class BallMover {

    Random random = new Random();
    
    int firstX = 0;
    int secondY = 0;
    int thirdX = 0;
    int fourthY = 0;
    
    ArrayList<Ball> balls;

    public BallMover(ArrayList<Ball> balls) {
        this.balls = balls;
    }

    public void createBalls() {
        int x = 600;
        int y = 50;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Ball ball = new Ball();
                ball.x = x;
                y += 50;
                ball.y = y;
                ball.firstX = x - 100 - randomDistance();
                ball.secondX = x - 100 - randomDistance();
                ball.thirdX = x;
                ball.fourthX = x;
                ball.firstY = y;
                ball.secondY = y + 40 + randomDistance();
                ball.thirdY = y + 40 + randomDistance();
                ball.fourthY = y;
                ball._firstX = ball.firstX;
                ball._secondX = ball.secondX;
                ball._thirdX = ball.thirdX;
                ball._fourthX = ball.fourthX;
                ball._firstY = ball.firstY;
                ball._secondY = ball.secondY;
                ball._thirdY = ball.thirdY;
                ball._fourthY = ball.fourthY;
                balls.add(ball);
            }
            x += 50;
            y = 50;
        }
    }

    private int randomDistance() {
        return random.nextInt(100);
    }

    private int randomDistance2() {
        return random.nextInt(10);
    }
    
    public void firstX() {
        for (int i = 0; i < balls.size(); i++) {
            balls.get(i)._firstX += randomDistance2();
            int x = balls.get(i)._firstX;
            int v = random.nextInt(2);
            if (v == 1) {
                x = balls.get(i).firstX;
            }
            int theX = balls.get(i).x;
            if(balls.get(i).x > 1200)
                balls.get(i).x = 0;
            if(balls.get(i).x < 0)
                balls.get(i).x = 1200;
            if (theX >= x) {
                balls.get(i).x -= 10;
            } else {
                firstX = 1;
            }
        }
    }

    public void secondY() {
        for (int i = 0; i < balls.size(); i++) {
            balls.get(i)._secondY += randomDistance2();
            int y = balls.get(i)._secondY;
            int v = random.nextInt(2);
            if (v == 1) {
                y = balls.get(i).secondY;
            }
            int theY = balls.get(i).y;
            if(balls.get(i).y > 700)
                balls.get(i).y = 0;
            if(balls.get(i).y < 0)
                balls.get(i).y = 700;
            if (theY <= y) {
                balls.get(i).y += 10;
            } else {
                secondY = 1;
            }
        }
    }

    public void thirdX() {
        for (int i = 0; i < balls.size(); i++) {
            balls.get(i)._thirdX += randomDistance2();
            int x = balls.get(i)._thirdX;
            int v = random.nextInt(2);
            if (v == 1) {
                x = balls.get(i).thirdX;
            }
            int theX = balls.get(i).x;
            if(balls.get(i).x > 1200)
                balls.get(i).x = 0;
            if(balls.get(i).x < 0)
                balls.get(i).x = 1200;
            if (theX <= x) {
                balls.get(i).x += 10;
            } else {
                thirdX = 1;
            }
        }
    }

    public void fourthY() {
        for (int i = 0; i < balls.size(); i++) {
            balls.get(i)._fourthY += randomDistance2();
            int y = balls.get(i)._fourthY;
            int v = random.nextInt(2);
            if (v == 1) {
                y = balls.get(i).fourthY;
            }
            int theY = balls.get(i).y;
            if(balls.get(i).y > 700)
                balls.get(i).y = 0;
            if(balls.get(i).y < 0)
                balls.get(i).y = 700;
            if (theY >= y) {
                balls.get(i).y -= 10;
            } else {
                firstX = 0;
                secondY = 0;
                thirdX = 0;
                fourthY = 0;
            }
        }
    }

    public void moveBalls() {
        if (thirdX == 1) {
            fourthY();
        } else if (secondY == 1) {
            thirdX();
        } else if (firstX == 1) {
            secondY();
        } else if (firstX == 0) {
            firstX();
        }
    }
    
}
