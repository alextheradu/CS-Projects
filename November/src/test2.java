import java.util.Scanner;

//Alex Radu
//Date: Nov 13, 2024

public class test2
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a day of the week (1-7): ");
		int num = sc.nextInt();
		if(ExploringFunctions.getDayName(num).equalsIgnoreCase("non existent"))
			System.out.println("You didn't input one of the correct numbers. Shame on you!");
		else
			System.out.println("That day is a " + ExploringFunctions.getDayName(num) + ".");
	}

}
