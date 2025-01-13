import java.util.Scanner;

//Alex Radu
//Date: Nov 11, 2024

public class PrimeAlgorithm
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter what number to go up to: ");
		int s = sc.nextInt();
		int attempts = 0;
		int n = 0;
		while(n <= s) {
		if(Prime.isPrime(n) == true)
		{
			System.out.println(n + " is prime.");
			
		}
		n++;
		attempts++;
		}
	}
}