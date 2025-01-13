import java.util.Scanner;

//Alex Radu
//Date: Nov 11, 2024

public class MathStuff
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int wholeThing = 1;
		while(wholeThing == 1)
		{
		int tryagain1 = 1;
		int tryagain2 = 1;
		int tryagain3 = 1;
		System.out.print("Do you want to: \n1. Find the Slope\n2. Count Prime Numbers\n3. Is a Number Prime\nEnter option: ");
		int option1 = sc.nextInt();
		if(option1 == 1)
			while(tryagain1 == 1)
			{
			System.out.print("Enter X1: ");
			float x1 = sc.nextFloat();
			System.out.print("Enter Y1: ");
			float y1 = sc.nextFloat();
			System.out.print("Enter X2: ");
			float x2 = sc.nextFloat();
			System.out.print("Enter Y2: ");
			float y2 = sc.nextFloat();
			double slope1 = MathProgram.slope(x1, y1, x2, y2);
			System.out.println("The slope is: " + slope1);
			System.out.print("Do you want to find the slope again?\n1. Yes\n2. No\nEnter your answer (1, 2, or 3): ");
			int option2 = sc.nextInt();
			if(option2 == 2)
				tryagain1 = 0;
			}
		if(option1 == 2)
			while(tryagain2 == 1)
			{
				System.out.print("Enter what number to stop writing prime numbers: ");
				int s = sc.nextInt();
				int attempts = 0;
				int n = 0;
				while(n <= s) {
				if(MathProgram.isPrime(n) == true)
				{
					System.out.println(n + " is prime.");
					
				}
					n++;
					attempts++;
				}
				System.out.print("Do you want to find a prime number again?\n1. Yes\n2. No\nEnter your answer (1 or 2): ");
				int option3 = sc.nextInt();
				if(option3 == 2)
					tryagain2 = 0;
			}
		if(option1 == 3)
			while(tryagain3 == 1)
			{
				System.out.print("Enter a number to see if it's prime or not: ");
				int num = sc.nextInt();
				if(MathProgram.isPrime(num) == true)
				{
					System.out.println(num + " is a prime number.");
					
				}
				else
				{
					System.out.println(num + " is a composite number.");
				}
				System.out.print("\nDo you want to find a prime number again?\n1. Yes\n2. No\nEnter your answer (1 or 2): ");
				int option3 = sc.nextInt();
				if(option3 == 2)
					tryagain3 = 0;
			}
			System.out.print("Do you want the original questions back?\n1. Yes\n2. No\nEnter your answer (1 or 2): ");
			int option4 = sc.nextInt();
			
		}
	}

}
