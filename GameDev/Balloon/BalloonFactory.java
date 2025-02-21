package GameDev.Balloon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

public class BalloonFactory {
    public static void main(String[] args) {
        Balloon b1 = new Balloon(Color.CYAN, 16);
        System.out.println(b1);


        
        ArrayList<Balloon> balloons = new ArrayList<Balloon>();
        for(int i = 0; i < 100; i++) {
            int size = (int)(Math.random() * 20) + 5;
            Color color = getRandomBalloonColor();
            balloons.add(new Balloon(color, size));
        }

        

        balloons.add(b1);

        for(Balloon b : balloons)
            System.out.println(b);

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter a size: ");
        int requestSize = sc.nextInt();

        int numFound = getBalloonSizeCount(balloons, requestSize);
        System.out.println("There are " + numFound + " balloons with size " + requestSize);


    }

    public static Color getRandomBalloonColor() {
        Color[] colorOptions = {Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
        return colorOptions[(int)(Math.random() * colorOptions.length)];
    }
    public static int getBalloonSizeCount(ArrayList<Balloon> balloonList, int targetSize) {
        int counter = 0;
        for(Balloon b : balloonList) {
            if(b.getDiameter() == targetSize)
                counter++;
        }
        return counter;
    }
}
