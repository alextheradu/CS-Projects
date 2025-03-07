package GameDev.ListReview;

import java.util.ArrayList;

public class ListReview1 {
    public static void main(String[] args) {
        // Make an arraylist called Grades
        ArrayList<Integer> grades = new ArrayList<>();

        // Add 100 random numbers from 75 to 100.
        for (int i = 0; i < 100; i++) {
            grades.add((int) (Math.random() * 1000) + 1);
            System.out.println(grades.get(i));
        }

        // Calculate the average of the numbers in the lis
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        double average = sum / grades.size();
        System.out.println("Average grade: " + average);

        // Find the largest value in the list

        int max = grades.get(0);
        for (int grade : grades) {
            if (grade > max) {
                max = grade;
            }
        }
        System.out.println("Largest grade: " + max);

    }
}
