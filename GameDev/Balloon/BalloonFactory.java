package GameDev.Balloon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

        // balloons.add(b1);
        Collections.sort(balloons);
        for(Balloon b : balloons)
            System.out.println(b);

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter a size: ");
        int requestSize = sc.nextInt();

        int numFound = getBalloonSizeCount(balloons, requestSize);
        System.out.println("There are " + numFound + " balloons with size " + requestSize);

        //use the removeAllBalloonsOfSize method to remove all balloons of a certain size
        ArrayList<Balloon> requestList = removeAllBalloonsOfSize(balloons, requestSize);
        System.out.println("Removed balloons: ");
        for(Balloon b : requestList)
            System.out.print(b + " ");

     
        // test the ability to count balloon colors
        System.out.println("\nEnter red value: ");
        int red = sc.nextInt();
        System.out.println("Enter green value: ");
        int green = sc.nextInt();
        System.out.println("Enter blue value: ");
        int blue = sc.nextInt();
        Color requestedColor = new Color(red, green, blue);
        int numFoundColor = getBalloonColorCount(balloons, requestedColor);
        System.out.println("There are " + numFoundColor + " balloons with color " + requestedColor);

        ArrayList<Balloon> requestedList = removeAllBalloonsOfColor(balloons, requestedColor);
        System.out.println("Requested balloons: ");
        for(Balloon b : requestedList)
            System.out.print(b + " ");
    }
    
    public static ArrayList<Balloon> removeAllBalloonsOfSize(ArrayList<Balloon> balloon, int size) {
        ArrayList<Balloon> foundList = new ArrayList<Balloon>();
        for(int i = 0; i < balloon.size(); i++) {
            if(balloon.get(i).getDiameter() == size) {
                foundList.add(balloon.get(i));
                balloon.remove(i);
                i--;
            }
        }
        return foundList;
    }

    // removeAllBalloonsOfColor
    public static ArrayList<Balloon> removeAllBalloonsOfColor(ArrayList<Balloon> balloon, Color color) {
        ArrayList<Balloon> foundList = new ArrayList<Balloon>();
        for(int i = 0; i < balloon.size(); i++) {
            if(balloon.get(i).getColor().equals(color)) {
                foundList.add(balloon.get(i));
                balloon.remove(i);
                i--;
            }
        }
        return foundList;
    }

    public static int getBalloonColorCount(ArrayList<Balloon> balloonList, Color targetColor) {
        int counter = 0;
        for(Balloon b : balloonList) {
            if(b.getColor().equals(targetColor))
                counter++;
        }
        return counter;
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
