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
    }
}
