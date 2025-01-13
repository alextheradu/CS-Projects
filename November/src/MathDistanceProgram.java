import java.util.Scanner;
import javax.swing.JOptionPane;

//Alex Radu
//Date: Nov 4, 2024

public class MathDistanceProgram
{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Do you want to either:\n"
			+ "1. Find distance using coordinates\n"
			+ "2. Find distance using x and y distances\n"
			+ "Enter answer here: ");
	int plaything = sc.nextInt();
	if(plaything == 1)
	{
		System.out.print("Enter X1: ");
		double x1 = sc.nextDouble();
		System.out.println();
		System.out.print("Enter Y1: ");
		double y1 = sc.nextDouble();
		System.out.println();
		System.out.print("Enter X2: ");
		double x2 = sc.nextDouble();
		System.out.println();
		System.out.print("Enter Y2: ");
		double y2 = sc.nextDouble();
		System.out.println();
		double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
		System.out.println("The distance is: " + distance);
	}
	if(plaything == 2)
	{
		System.out.print("Enter num 1: ");
		double num1 = sc.nextDouble();
		System.out.println();
		System.out.print("Enter num 2: ");
		double num2 = sc.nextDouble();
		double ans = Math.sqrt(Math.pow(num1, 2) + Math.pow(num2, 2));
		System.out.println(ans);
		System.out.println(Math.pow(num1, 2) + Math.pow(num2, 2));
	}
	}
}
