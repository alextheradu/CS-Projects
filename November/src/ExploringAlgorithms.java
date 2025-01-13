import java.util.Scanner;

//Alex Radu
//Date: Nov 6, 2024

public class ExploringAlgorithms
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = sc.nextInt();
		String prime = "prime";
		if (num <= 1)
		{
			prime = "Not prime.";
		}
		int p = 0;
		for (int i = 2; i < num; i++)
			if (num % i == 0)
				p = 1;

		if (p == 1)
			System.out.println(num + " is not prime.");
		else
			System.out.println(num + " is prime.");
	}

}
