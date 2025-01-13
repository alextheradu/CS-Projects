import java.util.Scanner;
//Honors Computer Science
//Program description: These exercises are designed to:
//                      - introduce math operations and functions in Java
//                      - practice declaring and using variables
//                      - develop algorithmic thinking

public class MathExercises
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      
      /** Exercise #1
       *  a) Prompt the user to enter 2 integers.
       *  b) Display the sum, difference, product and quotient.
       *     For example, if 42 and 18 are entered, display:  42 + 18 = 60 ... etc.
       */
//      System.out.print("Enter a number: ");
//      int int1 = sc.nextInt();
//      System.out.print("Enter another number: ");
//      int int2 = sc.nextInt();
//      int sum1 = int1 + int2;
//      int difference1 = int1 - int2;
//      int product1 = int1 * int2;
//      double quotient1 = (double) int1 / int2;
//      System.out.println(int1 + " + " + int2 + " = " + sum1);
//      System.out.println(int1 + " - " + int2 + " = " + difference1);
//      System.out.println(int1 + " * " + int2 + " = " + product1);
//      System.out.println(int1 + " / " + int2 + " = " + quotient1);
//
//      /** Exercise #2
//       *  Repeat exercise #1 using decimals
//       */
//      System.out.print("Enter a number with a decimal (ex: 3.141592653): ");
//      double dec1 = sc.nextDouble();
//      System.out.print("Enter another number with a decimal (ex: 3.141592653): ");
//      double dec2 = sc.nextDouble();
//      double sum2 = dec1 + dec2;
//      double difference2 = dec1 - dec2;
//      double product2 = dec1 * dec2;
//      double quotient2 = dec1 / dec2;
//      System.out.println(dec2 + " + " + dec1 + " = " + sum2);
//      System.out.println(dec1 + " - " + dec2 + " = " + difference2);
//      System.out.println(dec1 + " * " + dec2 + " = " + product2);
//      System.out.println(dec1 + " / " + dec2 + " = " + quotient2);
//      
//      /** Exercise #3
//       *  a) Prompt the user for 2 integer sets of ordered pairs... (x1, y1) and (x2, y2)
//       *  b) Calculate and display the slope of the line containing those points using a variable called slope.
//       *  c) Calculate and display the distance between those points using a variable called distance.
//       */
//      System.out.print("Enter x1: ");
//      double x1 = sc.nextDouble();
//      System.out.print("Enter y1: ");
//      double y1 = sc.nextDouble();
//      System.out.print("Enter x2: ");
//      double x2 = sc.nextDouble();
//      System.out.print("Enter y2: ");
//      double y2 = sc.nextDouble();
//      double m = (y2 - y1) / (x2 - x1);
//      double distance = Math.sqrt(((y2 - y1) * (y2 - y1)) + ((x2 - x1) * (x2 - x1)));
//      System.out.println("The slope between (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ") is " + m + " \nThe distance between (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ") is " + distance);
//      /** Exercise #4
//       *  a) Enter the number of quarters, dimes, nickels and pennies in a piggy bank.
//       *  b) Calculate and display the total amount of money in a variable called total.
//       */
//      System.out.print("Enter how many quarters you have: ");
//      double quarters = sc.nextDouble();
//      System.out.print("Enter how many dimes you have: ");
//      double dimes = sc.nextDouble();
//      System.out.print("Enter how many nickels you have: ");
//      double nickels = sc.nextDouble();
//      System.out.print("Enter how many pennies you have: ");
//      double pennies = sc.nextDouble();
//      quarters = quarters * 0.25;
//      dimes = dimes * 0.10;
//      nickels = nickels * 0.05;
//      pennies = pennies * 0.01;
//      double total = quarters + nickels + dimes + pennies;
//      System.out.println("\nYou have " + total + " dollars in your piggy bank.");
//      
      
      
      /** Exercise #5
       *  a) Enter a total number of cents (int) and determine the minimum number of dollar bills and coins needed for that amount of money.
       *  b) For example, 293 cents is 2 dollars, 3 quarters, 1 dime, 1 nickels, and 3 pennies.
       */
      System.out.print("Enter the total number of cents: ");
      int totalCents = sc.nextInt();
      
      int dollars2 = totalCents / 100;
      int remainingCents = totalCents % 100;
      System.out.println(3 % 12);
      
      int quarters2 = remainingCents / 25;
      remainingCents %= 25;
      
      int dimes2 = remainingCents / 10;
      remainingCents %= 10;
      
      int nickels2 = remainingCents / 5;
      remainingCents %= 5;
      
      int pennies2 = remainingCents;

      System.out.println("Minimum number of coins and bills: ");
      System.out.println("Dollars: " + dollars2);
      System.out.println("Quarters: " + quarters2);
      System.out.println("Dimes: " + dimes2);
      System.out.println("Nickels: " + nickels2);
      System.out.println("Pennies: " + pennies2);
      
   }
}
