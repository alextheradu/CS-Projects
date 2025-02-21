package GameDev.BallBounce;

import java.util.ArrayList;

public class BallTester {
    public static void main(String[] args) {
        Ball b1 = new Ball(4, 5, 6, 7);
        System.out.println(b1.getX());
        b1.setX(300);
        System.out.println(b1.getX());
        System.out.println(b1);
        ArrayList<Ball> balls = new ArrayList<Ball>();
        balls.add(b1);

        for(int i = 0; i < 500; i++) {
            int x = (int)(Math.random() * 800);
            int y = (int)(Math.random() * 600);
            int w = (int)(Math.random() * 41) +10;
            int h = (int)(Math.random() * 41) +10;
            balls.add(new Ball(x, y, w, h));
        }
        //how many of the balloons are 16 in diameter?
        int count = 0;
        
        for(Ball b : balls) {
            System.out.println(b);
        }
    }
}
