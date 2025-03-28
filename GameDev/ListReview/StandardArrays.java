package GameDev.ListReview;

import java.util.Arrays;

public class StandardArrays {
    public static void main(String[] args) {
        // int[] nums = new int[100];
        // // System.out.println(Arrays.toString(nums));

        // // Find the max average in 1000000 iterations
        // double maxAverage = 0;
        // for(int j = 1; j <= Integer.MAX_VALUE; j++) {
        //     // Assign random values to the items in the array
        //     for (int i = 0; i < nums.length; i++) {
        //         nums[i] = (int) (Math.random() * 100) + 1;
        //     }
        //     double sum = 0;
        //     for (int num : nums)
        //         sum += num;
        //     double average = sum / nums.length;
        //     if (average > maxAverage) {
        //         maxAverage = average;
        //     }
        // }
        // System.out.println("Max average: " + maxAverage);

        // // Print a random workday
        // String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        // int randomIndex = (int) (Math.random() * dayNames.length);
        // System.out.println("Random workday: " + dayNames[randomIndex]);
        for (int r = 1; r <= 3; r++)
{
   for (int c = 4; c > r; c--)
        System.out.print("*");
   System.out.print(" ");
}
    }
}