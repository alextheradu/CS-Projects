package GameDev.Practice;

import java.util.ArrayList;

public class Letters {
    public static void main(String[] args) {
        // a) Construct an ArrayList called letters to hold Integer values.
        ArrayList<Integer> letters = new ArrayList<>();
        // b) Add 100 random numbers to the list, they should range from 75 to 100.
        for (int i = 0; i < 100; i++) {
            letters.add((int) (Math.random() * 26) + 75);
            System.out.println(letters.get(i));
        }

        // c) Suppose the numbers represent grades. Find and print the average grade.
        int total = 0;
        for (int grade : letters) {
            total += grade;
        }
        System.out.println("Average grade: " + total / letters.size());
    }
}
